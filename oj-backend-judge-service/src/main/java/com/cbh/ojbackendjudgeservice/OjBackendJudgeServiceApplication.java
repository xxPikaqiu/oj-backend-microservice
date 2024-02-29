package com.cbh.ojbackendjudgeservice;

import com.cbh.ojbackendjudgeservice.rabbitmq.InitRabbitMq;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
// 扫包（不同模块需要扫包）
@ComponentScan("com.cbh")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.cbh.ojbackendserviceclient.service"})
public class OjBackendJudgeServiceApplication {


    public static void main(String[] args) {
        InitRabbitMq.doInit();
        SpringApplication.run(OjBackendJudgeServiceApplication.class, args);
    }

}
