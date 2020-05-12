package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tll
 * @date 2020/05/05
 * 入口
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LyApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyApplication.class,args);
    }
}
