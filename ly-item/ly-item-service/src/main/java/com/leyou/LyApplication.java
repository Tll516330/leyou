package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author tll
 * @date 2020/05/05
 * 入口
 * @MapperScan("com.leyou.item/mapper")注解后 包下面的接口类，在编译后都会生成相应的实现类
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.leyou.item.mapper")
public class LyApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyApplication.class,args);
    }
}
