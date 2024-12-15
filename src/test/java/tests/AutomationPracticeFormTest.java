package tests;

import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class AutomationPracticeFormTest extends BaseConfig{

    private String year = "2004",
                    month = "April",
                    day = "06",
                    firstName = "John",
                    lastName = "Doe",
                    userEmail = "something@mail.com",
                    userNumber = "4349220921",
                    subject = "Maths",
                    path = "src/test/resources/testpic.jpg",
                    address = "any address",
                    state = "NCR",
                    city = "Noida";

    @Test
    void completelyFillOutTheForm(){
        automationPracticeFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .selectMaleRadio()
                .setUserNumber(userNumber)
                .chooseBirthDate(year, month, day)
                .setSubject(subject)
                .selectSportsCheckbox()
                .uploadPicture(path)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();
    }
}
