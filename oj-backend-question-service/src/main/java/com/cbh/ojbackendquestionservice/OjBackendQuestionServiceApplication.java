package com.cbh.ojbackendquestionservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.cbh.ojbackendquestionservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
// 扫包（不同模块需要扫包）
@ComponentScan("com.cbh")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.cbh.ojbackendserviceclient.service"})
public class OjBackendQuestionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OjBackendQuestionServiceApplication.class, args);
    }

}
