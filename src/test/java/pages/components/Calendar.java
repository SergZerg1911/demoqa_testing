package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Calendar {

    public void chooseDate(String year, String month, String day){
        $(".react-datepicker__month-dropdown-container").$$("option").findBy(text(month)).click();
        $(".react-datepicker__year-dropdown-container").$$("option").findBy(text(year)).click();
        $(".react-datepicker__day--0" + day).click();
    }
}
