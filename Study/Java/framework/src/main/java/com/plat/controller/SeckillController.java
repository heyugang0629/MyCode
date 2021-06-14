package com.plat.controller;

import com.plat.config.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jack on 2021/3/29.
 */
//@Scope("prototype")
@RestController
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private RedisService redisService;

    private static long ss = 0;

    /**
     * 设置秒杀的数量
     *
     * @param productId
     * @param number
     * @return
     */
    @RequestMapping(value = "/setSeckillNum")
    public Object initSeckillNum(@RequestParam("productId") String productId, @RequestParam("number") Integer number) {
        Map<String, Object> map = new HashMap<>();
        try {
            redisService.set(productId, number);
        } catch (Exception e) {
            map.put("status", false);
            map.put("msg", "系统异常请联系管理员!");
            e.printStackTrace();
        }
        map.put("status", true);
        return map;
    }

    Lock lock = new ReentrantLock();

    /**
     * 设置秒杀的数量
     *
     * @param productId
     * @param number
     * @return
     */
    @RequestMapping(value = "/seckillNum")
    public void seckillNum(@RequestParam("productId") String productId, @RequestParam("number") Integer number) {
        ExecutorService executorService = Executors.newFixedThreadPool(30 );
        executorService.execute(new Thread(() -> {
            try {
                lock.lock();
                Integer num = (Integer) redisService.get(productId);
                if (num > number) {
                    System.out.println("本次购买量：" + number);
                    redisService.decr(productId, number);
                } else if (num - number < 0) {
                    System.out.println("只剩下" + num + "件商品了，库存不足！");
                } else if (num <= 0) {
                    System.out.println("本次秒杀商品已抢光了!");
                }
                System.out.println("当前剩余量：" + num);
            } catch (Exception e) {
                System.out.println("系统异常，请联系管理员!");
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }));
    }

    /**
     * 设置秒杀的数量
     *
     * @param productId
     * @param number
     * @return
     */
    @RequestMapping(value = "/seckillNum2")
    public void seckillNum2(@RequestParam("productId") String productId, @RequestParam("number") Integer number) {
        try {
            lock.lock();
            Integer num = (Integer) redisService.get(productId);
            if (num > number) {
                System.out.println("本次购买量：" + number);
                redisService.decr(productId, number);
            } else if (num - number < 0) {
                System.out.println("只剩下" + num + "件商品了，库存不足！");
            } else if (num <= 0) {
                System.out.println("本次秒杀商品已抢光了!");
            }
            System.out.println("当前剩余量：" + num);
        } catch (Exception e) {
            System.out.println("系统异常，请联系管理员!");
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

