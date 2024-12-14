package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    String url = "/text-box";
    SelenideElement userName = $("#userName"),
                    userEmail = $("#userEmail"),
                    currentAddress = $("#currentAddress"),
                    permanentAddress = $("#permanentAddress"),
                    submit = $("#submit"),
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
}
