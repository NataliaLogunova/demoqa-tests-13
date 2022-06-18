package org.nataliya.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationForm {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        String name = "Paul";

        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(name);
        $("#lastName").setValue("Richardson");
        $("#userEmail").setValue("paulri4@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9010003344");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").sendKeys("English");
        $("#subjectsInput").pressEnter();

        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("picture.jpg");

        $("#currentAddress").setValue("9/1 Oakstreet, Portland, USA");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        //$(".modal-content").shouldHave(
             //   text("Paul"),
             //   text("Richardson"),
             //   text("paulri4@gmail.com"),
             //   text("Male"),
             //   text("1 October,1991"),
             //   text("Music"),
             //   text("picture.jpg"),
             //   text("9/1 Oakstreet, Portland, USA"),
             //   text("English"));
    }
}


