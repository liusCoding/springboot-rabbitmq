package com.ls.topic.model;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-rabbitmq->UserSender
 * @description: 消息发送者
 * @author: liushuai
 * @create: 2019-09-11 10:14
 **/

@Component
public class UserSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    //exchange 交换机名称

    @Value("${mq.config.exchange}")
    private String exchange;



    public void send(String msg){
        //向消息队列发送消息
        //参数一：交换器名称。
        //参数二：路由键
        //参数三：消息
        this.rabbitTemplate.convertAndSend(this.exchange,"user.log.debug", "user.log.debug....."+msg);
        this.rabbitTemplate.convertAndSend(this.exchange,"user.log.info", "user.log.info....."+msg);
        this.rabbitTemplate.convertAndSend(this.exchange,"user.log.warn","user.log.warn....."+msg);
        this.rabbitTemplate.convertAndSend(this.exchange,"user.log.error", "user.log.error....."+msg);
    }

}
