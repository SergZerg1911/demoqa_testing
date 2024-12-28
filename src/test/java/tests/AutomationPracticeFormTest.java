package tests;

import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;

import java.time.Month;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class AutomationPracticeFormTest extends BaseConfig{

    final String[] subjects = {"Maths", "Chemistry", "Computer Science", "Accounting", "Arts", "Social Studies", "History"},
            states = {"NCR", "Haryana"},
            NCRCities = {"Delhi", "Gurgaon", "Noida"},
            HaryanaCities = {"Karnal", "Penipat"};

    int randomMonthNumber = faker.number().numberBetween(1, 13);
    String monthName = Month.of(randomMonthNumber).name();
    int subjectRandomIndex = faker.number().numberBetween(0, subjects.length);
    int statesRandomIndex = faker.number().numberBetween(0, states.length);
    int NCRCitiesRandomIndex = faker.number().numberBetween(0, NCRCities.length);
    int HaryanaCitiesRandomIndex = faker.number().numberBetween(0, HaryanaCities.length);

    private final String year = String.valueOf(faker.number().numberBetween(1990, 2024)),
                    month = monthName.substring(0, 1).toUpperCase() + monthName.substring(1).toLowerCase(),
                    day = String.valueOf(faker.number().numberBetween(1, 31)),
                    firstName = faker.name().firstName(),
                    lastName = faker.name().lastName(),
                    userEmail = faker.internet().emailAddress(),
                    userNumber = faker.phoneNumber().phoneNumber(),
                    subject = subjects[subjectRandomIndex],
                    path = "src/test/resources/testpic.jpg",
                    address = faker.address().fullAddress(),
                    state = states[statesRandomIndex];


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
                .setCity(state.equals("NCR") ? NCRCities[NCRCitiesRandomIndex] : HaryanaCities[HaryanaCitiesRandomIndex])
                .clickSubmit();
    }
}
