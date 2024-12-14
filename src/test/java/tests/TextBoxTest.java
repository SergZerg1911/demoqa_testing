package tests;

import org.junit.jupiter.api.Test;

public class TextBoxTest extends BaseConfig{

    private String userName = "Scott L Jones";
    private String userEmail = "s.k.i.l.ig.ge.e@gmail.com";
    private String currentAddress = "4176 Rinehart Road Miami, Florida(FL), 33179";
    private String permanentAddress = "65 Maxwell Street Hartford, Connecticut(CT), 06103";

    @Test
    void fillTheFormTest(){
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
}
