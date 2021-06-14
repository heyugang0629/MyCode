package com.plat.config.thread;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author hyg
 * @date 2021/5/12
 */
@Configuration
@EnableAsync
public class ThreadPool {

    @Value( "${spring.application.name}")
    private String applicationName;
    //获取系统核数
    private int cpuNum = Runtime.getRuntime().availableProcessors();

    //系统位数
    private String bits = System.getProperties().getProperty("os.arch").equals("x86") ? "32" : "64" ;

    @Bean("taskExecutor")
    public Executor asyncServiceExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize( 5 );
        // 设置最大线程数
        executor.setMaxPoolSize( getThreadNum() );
        //配置队列大小
        executor.setQueueCapacity( Integer.MAX_VALUE );
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds( 60 );
        // 设置默认线程名称
        executor.setThreadNamePrefix( applicationName );
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //执行初始化
        executor.initialize();
        return executor;
    }

    /**
     * 获取线程数
     * @return
     */
    private int getThreadNum(){
        //线程数 = (核数 * 期望CPU利用率 * 总时间 ) / CPU 计算时间
        int threadNum = (int)( ( cpuNum * 0.8 * 0.9 ) / 0.5 );
        System.out.println( "线程池最大数量：" + threadNum );
        return threadNum;
    }
}
