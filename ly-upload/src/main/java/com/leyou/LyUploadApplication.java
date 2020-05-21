package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tll
 * @version 1.0.0
 * @date 2020/5/19 14:15
 * 上传文件启动类
 * EnableDiscoverClient 发现注册中心 并将服务注册到Eureka中
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LyUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(LyUploadApplication.class,args);
    }
}
