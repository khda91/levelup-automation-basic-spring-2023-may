package ru.levelp.at.lesson12.design.patterns.chain.of.ionvocation;

import java.util.Map;
import org.testng.annotations.Test;
import ru.levelp.at.lesson1011.cicd.allure.model.UserDto;

public class ChainOfInvocationTest {

    @Test
    public void producerTest() {
        var user = new UserDto("sasa", "sasas", "jdhavuehaqwiuve");
        new KafkaProducer().topic("topic1")
            .config(Map.of())
            .sendMessage(user);
        sss(user.getEmail());
    }

    @Test
    public void consumerTest() {
        var obj = new KafkaConsumer().topic("topic1")
                           .config(Map.of())
                           .searchMessage(searchCriteria -> true);
    }

    private void sss(String s) {
        s = s + " jnsdfjdhjas";
        System.out.println(s);
    }

    private void ssss(final String s) {
        // s = s + " jnsdfjdhjas"; ошибка потому что final
        System.out.println(s);
    }
}
