package com.ls.provider.model;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-rabbitmq->Sender
 * @description: 消息发送者
 * @author: liushuai
 * @create: 2019-09-11 18:17
 **/

@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;


    /**
     * 发送消息的方法
     */

    public void send(String msg){

        //向消息队列发送消息
        //参数一：交换机名称
        //参数二：路由键
        //参数三：消息
        rabbitTemplate.convertAndSend(exchange, "",msg);
    }

}
