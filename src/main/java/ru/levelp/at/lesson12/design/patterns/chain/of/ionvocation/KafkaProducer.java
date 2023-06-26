package ru.levelp.at.lesson12.design.patterns.chain.of.ionvocation;

import java.util.Map;

public class KafkaProducer {

    private Map<String, Object> config;
    private String topic;

    public KafkaProducer config(Map<String, Object> config) {
        this.config = config;
        return this;
    }

    public KafkaProducer topic(String topic) {
        this.topic = topic;
        return this;
    }

    public void sendMessage(Object message) {
        System.out.println("сообщение отправлено " + message);
    }
}
