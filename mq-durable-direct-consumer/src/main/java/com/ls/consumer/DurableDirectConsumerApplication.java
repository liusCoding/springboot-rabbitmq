package com.ls.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DurableDirectConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DurableDirectConsumerApplication.class, args);
    }

}
