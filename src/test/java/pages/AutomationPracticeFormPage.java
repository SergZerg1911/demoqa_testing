package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.Calendar;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormPage {

    Calendar calendar = new Calendar();

    String url = "/automation-practice-form";
    private SelenideElement firstName = $("#firstName"),
                            lastName = $("#lastName"),
                            userEmail = $("#userEmail"),
                            maleRadioButton = $("[for=gender-radio-1]"),
                            femaleRadioButton = $("[for=gender-radio-2]"),
                            otherRadioButton = $("[for=gender-radio-3]"),
                            userNumber = $("#userNumber"),
                            dateOfBirth = $("#dateOfBirthInput"),
                            subject = $("#subjectsContainer"),
                            checkboxSports = $("[for=hobbies-checkbox-1]"),
                            checkboxReading = $("[for=hobbies-checkbox-2]"),
                            checkboxMusic = $("[for=hobbies-checkbox-3]"),
                            currentAddress = $("#currentAddress"),
                            uploadFile = $("#uploadPicture"),
                            state = $("#state"),
                            city = $("#city"),
                            submit = $("#submit");

    public AutomationPracticeFormPage openPage(){
        open(url);
        return this;
    }

    public AutomationPracticeFormPage setFirstName(String value){
        firstName.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setLastName(String value){
        lastName.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setUserEmail(String value){
        userEmail.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage selectMaleRadio(){
        maleRadioButton.click();
        return this;
    }

    public AutomationPracticeFormPage selectFemaleRadio(){
        femaleRadioButton.click();
        return this;
    }

    public AutomationPracticeFormPage selectOtherRadio(){
        otherRadioButton.click();
        return this;
    }

    public AutomationPracticeFormPage setUserNumber(String value){
        userNumber.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setSubject(String value){
        subject.click();
        $("#subjectsInput").type(value);
        $(".subjects-auto-complete__menu-list")
                .$(".subjects-auto-complete__option")
                .shouldHave(text(value)).click();
        return this;
    }

    public AutomationPracticeFormPage selectSportsCheckbox(){
        checkboxSports.click();
        return this;
    }

    public AutomationPracticeFormPage selectMusicCheckbox(){
        checkboxMusic.click();
        return this;
    }

    public AutomationPracticeFormPage selectReadingCheckbox(){
        checkboxReading.click();
        return this;
    }

    public AutomationPracticeFormPage setCurrentAddress(String value){
        currentAddress.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage uploadPicture(String path){
        File file = new File(path);
        uploadFile.uploadFile(file);
        return this;
    }

    public AutomationPracticeFormPage setState(String state){
        this.state.click();
        this.state.$(byText(state)).click();
        return this;
    }

    public AutomationPracticeFormPage setCity(String city){
        this.city.click();
        this.city.$(byText(city)).click();
        return this;
    }

    public AutomationPracticeFormPage chooseBirthDate(String year, String month, String day){
        dateOfBirth.click();
        calendar.chooseDate(year, month, day);
        return this;
    }

    public AutomationPracticeFormPage clickSubmit(){
        submit.click();
        return this;
    }
}
