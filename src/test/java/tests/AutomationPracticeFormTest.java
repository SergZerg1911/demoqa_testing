package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class AutomationPracticeFormTest extends BaseConfig{

    @Test
    void chooseBirthDate(){
        automationPracticeFormPage.openPage()
                .chooseBirthDate();
        sleep(4000);
    }
}
