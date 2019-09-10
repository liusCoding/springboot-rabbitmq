package com.ls.provider;

import com.ls.provider.model.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqDirectProviderApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    public void test1() throws InterruptedException {

        while (true){
            Thread.sleep(1000);
            sender.send("Hello Rabbit");

        }
    }

}
