package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class TextBoxTest extends BaseConfig{

    private final String userName = faker.name().fullName();
    private final String userEmail = faker.internet().emailAddress();
    private final String currentAddress = faker.address().fullAddress();
    private final String permanentAddress = faker.address().fullAddress();

    static Stream<Arguments> completelyFillOutTheForm() {
        return Stream.of(
                Arguments.of(faker.name().fullName(), faker.internet().emailAddress(), faker.address().fullAddress(), faker.address().fullAddress()),
                Arguments.of(faker.name().fullName(), faker.internet().emailAddress(), faker.address().fullAddress(), faker.address().fullAddress()),
                Arguments.of(faker.name().fullName(), faker.internet().emailAddress(), faker.address().fullAddress(), faker.address().fullAddress()),
                Arguments.of(faker.name().fullName(), faker.internet().emailAddress(), faker.address().fullAddress(), faker.address().fullAddress())
        );
    }

    @MethodSource
    @DisplayName("Заполнить форму полностью и нажать Submit")
    @ParameterizedTest(name = "Заполнить форму именем {0}, почтой {1}, текущим адресом {2}, постоянным адресом {3} и нажать Submit")
    @Tag("BLOCKER")
    void completelyFillOutTheForm(
            String userName,
            String userEmail,
            String currentAddress,
            String permanentAddress)
    {
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

    @DisplayName("Заполнить форму без имени и нажать Submit")
    @Test
    @Tag("BLOCKER")
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

    @DisplayName("Заполнить форму с неправильным емейлом и нажать Submit")
    @Test
    @Tag("BLOCKER")
    void FillOutTheFormWithInvalidUserEmail(){
        String invalidUserEmail = "s.k.i.l.ig.ge.e";
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
