package ru.levelp.at.lesson12.design.patterns.singleton;

import java.util.Map;
import org.testng.annotations.Test;

public class PersonDaoTest {

    @Test
    public void getAll1Test() {
        // что-то сделали для создания персона

        var personDao = new PersonDao(DataSourceProvider.getInstance());
        Map<String, Object> person = personDao.getPerson();
        System.out.println(person);

        var messengerDao = new MessengerDao(DataSourceProvider.getInstance());
        Map<String, Object> messengers = messengerDao.getMessengers();
        System.out.println(messengers);
    }

    @Test
    public void getAll2Test() {
        // что-то сделали для создания персона

        var personDao = new PersonDao(DataSourceProvider.getInstance());
        Map<String, Object> person = personDao.getPerson();
        System.out.println(person);

        var messengerDao = new MessengerDao(DataSourceProvider.getInstance());
        Map<String, Object> messengers = messengerDao.getMessengers();
        System.out.println(messengers);
    }
}
