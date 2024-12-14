package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    String url = "/text-box";
    SelenideElement userName = $("#userName"),
                    userEmail = $("#userEmail"),
                    currentAddress = $("#currentAddress"),
                    permanentAddress = $("#permanentAddress"),
                    submit = $("#submit"),
                    outputField = $("#output"),
                    outputUserNameCheck = $("#output").$("#name"),
                    outputUserEmailCheck = $("#output").$("#email"),
                    outputCurrentAddressCheck = $("#output").$("#currentAddress"),
                    outputPermanentAddressCheck = $("#output").$("#permanentAddress");

    public TextBoxPage openPage(){
        open(url);
        return this;
    }

    public TextBoxPage setUserName(String value){
        userName.setValue(value);
        return this;
    };

    public TextBoxPage setUserEmail(String value){
        userEmail.setValue(value);
        return this;
    };

    public TextBoxPage setCurrentAddress(String value){
        currentAddress.setValue(value);
        return this;
    };

    public TextBoxPage setPermanentAddress(String value){
        permanentAddress.setValue(value);
        return this;
    };

    public TextBoxPage clickSubmit(){
        submit.click();
        return this;
    };

    public TextBoxPage verifyUserName(String value){
        outputUserNameCheck.shouldHave(text(value));
        return this;
    };

    public TextBoxPage verifyUserEmail(String value){
        outputUserEmailCheck.shouldHave(text(value));
        return this;
    };

    public TextBoxPage verifyCurrentAddress(String value){
        outputCurrentAddressCheck.shouldHave(text(value));
        return this;
    };

    public TextBoxPage verifyPermanentAddress(String value){
        outputPermanentAddressCheck.shouldHave(text(value));
        return this;
    };

    public TextBoxPage verifyUserNameIsEmpty(){
        outputField.shouldNotHave(text("Name:"));
        return this;
    }

    public TextBoxPage verifyCurrentAddressIsEmpty(){
        outputCurrentAddressCheck.shouldNotHave(text("Current Address :"));
        return this;
    }

    public TextBoxPage verifyPermanentAddressIsEmpty(){
        outputPermanentAddressCheck.shouldNotHave(text("Permananet Address :"));
        return this;
    }

    public TextBoxPage verifyOutputFieldIsEmpty(){
        outputField.shouldBe(empty);
        return this;
    }

    public TextBoxPage verifyUserEmailBorderIsRed(){
        userEmail.shouldHave(cssValue("color", "rgba(73, 80, 87, 1)"));
        return this;
    }
}
