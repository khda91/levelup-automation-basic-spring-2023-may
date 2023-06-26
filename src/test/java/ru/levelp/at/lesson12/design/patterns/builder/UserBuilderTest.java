package ru.levelp.at.lesson12.design.patterns.builder;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserBuilderTest {

    @DataProvider
    public Object[][] builderDataProvider() {
        return new Object[][] {
            {UserDtoWithBuilder.builder().name("sdsd").password("asas").email("asasqwqw").build()},
            {UserDtoWithBuilder.builder().password("asas").email("asasqwqw").build()},
            {UserDtoWithBuilder.builder().email("asasqwqw").build()},
            {UserDtoWithBuilder.builder().password("asas").build()},
            {UserDtoWithBuilder.builder().name("sdsd").email("asasqwqw").build()},
            {UserDtoWithBuilder.builder().name("").password("").email("asasqwqw").build()}
        };
    }

    @DataProvider
    public Object[][] withoutBuilderDataProvider() {
        return new Object[][] {
            {new UserDtoWithoutBuilder("sdcas", "asdas", "aojkj")},
            {new UserDtoWithoutBuilder("asdas", "aojkj")},
            {new UserDtoWithoutBuilder("sdcas", null, "aojkj")},
            {new UserDtoWithoutBuilder("sdcas", "asdas", null)},
            {new UserDtoWithoutBuilder(null, null, "aojkj")},
            {new UserDtoWithoutBuilder(null, null, null)}
        };
    }

    @Test(dataProvider = "builderDataProvider")
    public void builderTest(UserDtoWithBuilder user) {
        System.out.println(user);
    }

    @Test(dataProvider = "withoutBuilderDataProvider")
    public void withoutBuilderTest(UserDtoWithoutBuilder user) {
        System.out.println(user);
    }
}
