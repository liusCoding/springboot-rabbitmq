package com.ls.mq1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mq1ApplicationTests {

    @Autowired
    private  Sender sender;

    @Test
    public void contextLoads() {

        //测试消息队列
        sender.send("Hello  RabbitMQ");
    }

}
