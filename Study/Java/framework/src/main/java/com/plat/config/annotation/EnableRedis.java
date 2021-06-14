package com.plat.config.annotation;

import com.plat.config.redis.RedisConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({RedisConfig.class})
public @interface EnableRedis {
}
