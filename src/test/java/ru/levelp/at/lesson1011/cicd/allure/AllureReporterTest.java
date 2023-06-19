package ru.levelp.at.lesson1011.cicd.allure;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import ru.levelp.at.lesson1011.cicd.allure.annotations.AutomatedBy;
import ru.levelp.at.lesson1011.cicd.allure.annotations.Priority;
import ru.levelp.at.lesson1011.cicd.allure.dictionary.PriorityLevel;
import ru.levelp.at.lesson1011.cicd.allure.groups.TestGroups;
import ru.levelp.at.lesson1011.cicd.allure.model.UserDto;
import ru.levelp.at.lesson1011.cicd.allure.pages.UserBugRedLoginRegistrationPage;
import ru.levelp.at.lesson1011.cicd.allure.pages.UserBugRedMainPage;

@AutomatedBy("some author")
@Epic("Регистрация")
public class AllureReporterTest extends BaseSeleniumTest {

    @Test(description = "Успешная регистрация пользователя",
          groups = {TestGroups.POSITIVE_TEST})
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("LUP-12345")
    @Owner("d.khodakovskiy")
    @Story("Успешная регистрация")
    @Feature("Правильные данные")
    @Priority(PriorityLevel.MEDIUM)
    public void registerUserTest() {
        var name = faker.funnyName().name();
        var email = faker.internet().emailAddress();
        var password = faker.internet().password();

        var registrationPage = new UserBugRedLoginRegistrationPage(driver);
        registrationPage.open();

        step("Выполняем регистрацию", () -> {
            registrationPage.fillNameTextField(name);
            registrationPage.fillEmailTextField(email);
            registrationPage.fillPasswordTextField(password);
            registrationPage.clickRegisterButton();
        });

        var mainPage = new UserBugRedMainPage(driver);
        step("Проверка имени зарегистрированного пользователя", () -> {
            String actualUserName = mainPage.getUsernameDropdownText();
            assertThat(actualUserName).isEqualToIgnoringCase(name);
        });
    }

    @Test(description = "Пользователь не может зарегистрироваться с неправильным почтовым адресом",
          groups = {TestGroups.NEGATIVE_TEST})
    @TmsLink("LUP-1235")
    @TmsLink("LUP-888")
    @Owner("d.khodakovskiy")
    @Story("Успешная регистрация")
    @Feature("Неправильные данные")
    @Priority(PriorityLevel.MEDIUM)
    public void negativeRegistrationTest() {
        var testUser = step("Генерируем тестового пользователя",
            () -> new UserDto(faker.funnyName().name(),
                faker.internet().domainSuffix(),
                faker.internet().password()));

        var registrationPage = new UserBugRedLoginRegistrationPage(driver);

        registrationPage.open();
        step("Выполняем регистрацию", () -> {
            registrationPage.fillNameTextField(testUser.getName());
            registrationPage.fillEmailTextField(testUser.getEmail());
            registrationPage.fillPasswordTextField(testUser.getPassword());
            registrationPage.clickRegisterButton();
        });

        step("Проверка ошибки при регистраци", () -> {
            String actualUserName = registrationPage.getErrorMessageLabelText();
            assertThat(actualUserName).isEqualToIgnoringCase("register_not_correct_field (email)");
        });
    }
}
