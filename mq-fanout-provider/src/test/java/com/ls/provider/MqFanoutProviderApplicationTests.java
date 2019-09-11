package com.ls.provider;

import com.ls.provider.model.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqFanoutProviderApplicationTests {

    @Autowired
    private Sender sender;


    /**
     *测试消息队列
     * @author liushuai
     * @param
     * @return
     */
    @Test
    public void testFanout() {
        sender.send("Hello RabbitMQ");
    }

}
