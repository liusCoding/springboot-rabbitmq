package com.ls.topic.model;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-rabbitmq->ProductSender
 * @description: 消息发送者
 * @author: liushuai
 * @create: 2019-09-11 16:25
 **/

@Component
public class ProductSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;

    /*
     * 发送消息的方法
     */
    public void send(String msg){
        //向消息队列发送消息
        //参数一：交换器名称。
        //参数二：路由键
        //参数三：消息
        this.rabbitTemplate.convertAndSend(this.exchange,"product.log.debug", "product.log.debug....."+msg);
        this.rabbitTemplate.convertAndSend(this.exchange,"product.log.info", "product.log.info....."+msg);
        this.rabbitTemplate.convertAndSend(this.exchange,"product.log.warn","product.log.warn....."+msg);
        this.rabbitTemplate.convertAndSend(this.exchange,"product.log.error", "product.log.error....."+msg);
    }

}
