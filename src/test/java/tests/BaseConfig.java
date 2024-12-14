package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.TextBoxPage;

public class BaseConfig {

    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void BeforeAll(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "maxSize";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
