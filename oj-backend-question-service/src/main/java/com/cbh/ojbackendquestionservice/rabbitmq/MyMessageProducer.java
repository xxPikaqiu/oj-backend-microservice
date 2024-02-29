package com.cbh.ojbackendquestionservice.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: cbh
 * @Date: 2024-02-29 9:20
 */
@Component
public class MyMessageProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param exchange 哪个交换机
     * @param routingKey 路由件
     * @param message 内容
     */
    public void sendMessage(String exchange, String routingKey, String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
