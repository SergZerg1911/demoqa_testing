package tests;

import org.junit.jupiter.api.Test;

public class TextBoxTest extends BaseConfig{

    private String userName = faker.name().fullName(),
            userEmail = faker.internet().emailAddress(),
            invalidUserEmail = "s.k.i.l.ig.ge.e",
            currentAddress = faker.address().fullAddress(),
            permanentAddress = faker.address().fullAddress();

    @Test
    void completelyFillOutTheForm(){
        textBoxPage.openPage()
                .setUserName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit()
                .verifyUserName(userName)
                .verifyUserEmail(userEmail)
                .verifyCurrentAddress(currentAddress)
                .verifyPermanentAddress(permanentAddress);
    }

    @Test
    void FillOutTheFormWithoutName(){
        textBoxPage.openPage()
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit()
                .verifyUserNameIsEmpty()
                .verifyUserEmail(userEmail)
                .verifyCurrentAddress(currentAddress)
                .verifyPermanentAddress(permanentAddress);
    }

    @Test
    void FillOutTheFormWithInvalidUserEmail(){
        textBoxPage.openPage()
                .setUserName(userName)
                .setUserEmail(invalidUserEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit()
                .verifyUserEmailBorderIsRed()
                .verifyOutputFieldIsEmpty();
    }
}
