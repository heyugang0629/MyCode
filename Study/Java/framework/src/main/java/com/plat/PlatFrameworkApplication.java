package com.plat;

import com.plat.config.annotation.EnableRedis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication( exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
@ComponentScan( value = "com.plat")
@EnableRedis
public class PlatFrameworkApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PlatFrameworkApplication.class, args);
	}
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(PlatFrameworkApplication.class);
//	}
}
