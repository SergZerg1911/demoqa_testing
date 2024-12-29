package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import pages.AutomationPracticeFormPage;
import pages.TextBoxPage;

public class BaseConfig {

    static Faker faker = new Faker();
    TextBoxPage textBoxPage = new TextBoxPage();
    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();

    @BeforeAll
    static void BeforeAll(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "maxSize";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
}
