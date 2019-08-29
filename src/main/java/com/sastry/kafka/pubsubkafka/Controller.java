package com.sastry.kafka.pubsubkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class Controller {

    @Autowired
    private Receiver receiver;

    @Autowired
    private Sender sender;
    @Value("${kafka.topic.test}")
    private String topic;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/kafka")
    public String kafka() throws InterruptedException {
        System.out.println(" topic name "+ topic);
        sender.send(topic, "Hello Spring Kafka!");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        return "Done";
    }
}
