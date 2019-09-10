package com.ls.mq1;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-rabbitmq->Sender
 * @description: 消息发送者
 * @author: liushuai
 * @create: 2019-09-10 14:43
 **/
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitMqTemplate;

    /**
     *功能描述 发送消息的方法
     * @author liushuai
     */

    public void  send(String msg){
       //向消息队列发送消息

        //参数一：队列的名称
        //参数二：消息
       rabbitMqTemplate.convertAndSend("hello-queue",msg);
    }

}
