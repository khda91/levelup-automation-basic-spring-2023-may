package ru.levelp.at.lesson1011.cicd.allure;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import java.util.List;
import org.testng.annotations.Test;
import ru.levelp.at.lesson1011.cicd.allure.annotations.AutomatedBy;
import ru.levelp.at.lesson1011.cicd.allure.annotations.Priority;
import ru.levelp.at.lesson1011.cicd.allure.dictionary.PriorityLevel;
import ru.levelp.at.lesson1011.cicd.allure.groups.TestGroups;
import ru.levelp.at.lesson1011.cicd.allure.pages.UserBugRedLoginRegistrationPage;

@TmsLinks({@TmsLink("LUP-547"), @TmsLink("LUP-369")})
@Owner("d.khodakovskiy")
@Epic("Регистрация")
@Story("Падающая регистрация")
public class AllureReporterFailV2Test extends BaseSeleniumTest {

    @Test(description = "Успешная регистрация пользователя (падающий)",
          groups = {TestGroups.POSITIVE_TEST})
    @Severity(SeverityLevel.TRIVIAL)
    @Issue("LUP-444")
    @AutomatedBy("some author")
    @Description("Что-то мы тестируем, что-то не дотестируем")
    @Feature("Правильная регистрация")
    @Priority(PriorityLevel.LOW)
    public void registerUserTest() {
        var name = faker.funnyName().name();
        var email = faker.internet().emailAddress();
        var password = faker.internet().password();

        var registrationPage = new UserBugRedLoginRegistrationPage(driver);

        registrationPage.open();
        registrationPage.fillNameTextField(name);
        registrationPage.fillEmailTextField(email);
        registrationPage.fillPasswordTextField(password);
        registrationPage.clickRegisterButton();

        var doub = 1 / 0;
    }

    @Test(description = "Пользователь не может зарегистрироваться с неправильным почтовым адресом (падающий)",
          groups = {TestGroups.NEGATIVE_TEST})
    @Severity(SeverityLevel.BLOCKER)
    @Issues({@Issue("LUP-111"), @Issue("LUP-2222"), @Issue("LUP-5557")})
    @AutomatedBy("some author")
    @Feature("Неправильная регистрация")
    @Priority(PriorityLevel.LOW)
    public void negativeRegistrationTest() {
        var name = faker.funnyName().name();
        var email = faker.internet().domainSuffix();
        var password = faker.internet().password();

        var registrationPage = new UserBugRedLoginRegistrationPage(driver);

        registrationPage.open();
        registrationPage.fillNameTextField(name);
        registrationPage.fillEmailTextField(email);
        registrationPage.fillPasswordTextField(password);
        registrationPage.clickRegisterButton();

        var list = List.of("aksjakdas");
        var elem = list.get(5);
    }
}
