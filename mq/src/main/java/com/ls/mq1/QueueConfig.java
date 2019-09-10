package com.ls.mq1;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springboot-rabbitmq->QueueConfig
 * @description: 创建消息队列
 * @author: liushuai
 * @create: 2019-09-10 14:40
 **/

@Configuration
public class QueueConfig {


    /**
     *创建消息队列
     */
    @Bean
    public Queue createQueue(){
        return new Queue("hello-queue");
    }
}
