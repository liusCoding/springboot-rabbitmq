package com.ls.provider.model;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-rabbitmq->Sender
 * @description: 消息发送
 * @author: liushuai
 * @create: 2019-09-10 15:53
 **/

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    //exchange 交换机名称

    @Value("${mq.config.exchange}")
    private String exchange;

    //routingkey 路由键

    @Value("${mq.config.queue.info.routing.key}")
    private String routingKey;

    /**
     *发送消息的方法
     * @author liushuai
     * @param msg
     */
    public void send(String msg){
        //向消息队列发送消息

        //参数一：交换机名称
        //参数二：路由键
        //参数三：消息

        rabbitTemplate.convertAndSend(exchange, routingKey, msg);
    }



}
