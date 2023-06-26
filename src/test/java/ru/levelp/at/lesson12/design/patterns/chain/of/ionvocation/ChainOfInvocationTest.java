package ru.levelp.at.lesson12.design.patterns.chain.of.ionvocation;

import java.util.Map;
import org.testng.annotations.Test;
import ru.levelp.at.lesson1011.cicd.allure.model.UserDto;

public class ChainOfInvocationTest {

    @Test
    public void producerTest() {
        new KafkaProducer().topic("topic1")
            .config(Map.of())
            .sendMessage(new UserDto("sasa", "sasas", "jdhavuehaqwiuve"));
    }

    @Test
    public void consumerTest() {
        var obj = new KafkaConsumer().topic("topic1")
                           .config(Map.of())
                           .searchMessage(searchCriteria -> true);
    }
}
