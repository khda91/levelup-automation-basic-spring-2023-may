package ru.levelp.at.lesson12.design.patterns.chain.of.ionvocation;

import java.util.Map;
import java.util.function.Predicate;

public class KafkaConsumer {

    private Map<String, Object> config;
    private String topic;

    public KafkaConsumer config(Map<String, Object> config) {
        this.config = config;
        return this;
    }

    public KafkaConsumer topic(String topic) {
        this.topic = topic;
        return this;
    }

    public Object searchMessage(Predicate<Boolean> predicate) {
        System.out.println("Читаем сообщение из Kafka");
        return new Object();
    }
}
