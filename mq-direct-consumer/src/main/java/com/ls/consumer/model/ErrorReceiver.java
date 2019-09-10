package com.ls.consumer.model;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-rabbitmq->InfoReceiver
 * @description: 消息接收者
 * @author: liushuai
 * @create: 2019-09-10 15:28
 * @RabbitListener bindings:绑定队列
 * @QueueBinding value：绑定队列的名称
 *               exchange:配置的交换机
 *               key:配置的路由key
 *
 * @Queue：value:配置队列名称
 *         autoDelete:是否是一个可删除的临时队列
 *
 * @Exchange  value: 为交换机起个名称
 *             type：指定具体的交换机类型
 *
 *
 **/

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(
                        value = "${mq.config.queue.error}",autoDelete = "true"
                ),
                exchange = @Exchange(
                        value = "${mq.config.exchange}",type = ExchangeTypes.DIRECT
                ),
                key = "${mq.config.queue.error.routing.key}"
        )
)

public class ErrorReceiver {


    /**
     *接收消息的方法，采用消息队列监听机制
     * @author liushuai
     * @param msg
     */
    @RabbitHandler
    public void process(String msg){
        System.out.println("error ---------------receiver:"+msg);
    }
}
