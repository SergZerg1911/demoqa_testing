package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class AutomationPracticeFormTest extends BaseConfig{

    private String year = "2004",
                    month = "April",
                    day = "006";

    @Test
    void chooseBirthDate(){
        automationPracticeFormPage.openPage()
                .chooseBirthDate(year, month, day);
        sleep(4000);
    }
}
