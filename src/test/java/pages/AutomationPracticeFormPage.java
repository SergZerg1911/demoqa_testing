package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.Calendar;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormPage {

    Calendar calendar = new Calendar();

    String url = "/automation-practice-form";
    private SelenideElement firstName = $("firstName");
    private SelenideElement lastName = $("lastName");
    private SelenideElement userEmail = $("userEmail");
    private SelenideElement maleRadioButton = $("gender-radio-1");
    private SelenideElement femaleRadioButton = $("gender-radio-2");
    private SelenideElement otherRadioButton = $("gender-radio-3");
    private SelenideElement userNumber = $("userNumber");
    private SelenideElement dateOfBirth = $("#dateOfBirthInput");

    public AutomationPracticeFormPage openPage(){
        open(url);
        return this;
    }

    public AutomationPracticeFormPage chooseBirthDate(String year, String month, String day){
        dateOfBirth.click();
        calendar.chooseDate(year, month, day);
        return this;
    }
}
