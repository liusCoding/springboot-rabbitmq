package com.ls.mq1;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-rabbitmq->Receiver
 * @description: 消息接收者
 * @author: liushuai
 * @create: 2019-09-10 14:49
 **/

@Component
@RabbitListener(queues = "hello-queue")
public class Receiver {

    /**
     * 接收消息的方法。采用消息队列的监听机制
     * @author liushuai
     * @param msg
     */
    @RabbitHandler
    public void process(String msg){
        System.out.println("receiver:"+msg);
    }
}
