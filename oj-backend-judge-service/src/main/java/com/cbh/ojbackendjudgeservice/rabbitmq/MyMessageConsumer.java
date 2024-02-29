package com.cbh.ojbackendjudgeservice.rabbitmq;

import com.cbh.ojbackendjudgeservice.judge.JudgeService;
import com.rabbitmq.client.Channel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author: cbh
 * @Date: 2024-02-29 9:27
 */
@Component
@Slf4j
public class MyMessageConsumer {

    @Resource
    private JudgeService judgeService;

    @SneakyThrows
    // queues: 哪个队列，ackMode：确认消息方式
    @RabbitListener(queues = {"code_queue"}, ackMode = "MANUAL")
    public void receiveMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) {
        log.info("receiveMessage message = {}", message);
        long questionSubmitId = Long.parseLong(message);
        try {
            judgeService.doJudge(questionSubmitId);
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            channel.basicNack(deliveryTag, false, true);
        }
    }
}
