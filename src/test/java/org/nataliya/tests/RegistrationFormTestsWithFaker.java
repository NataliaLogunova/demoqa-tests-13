package org.nataliya.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationFormTestsWithFaker extends TestBase {

 //   Faker faker = new Faker();
    Faker faker = new Faker(new Locale("de"));
    String firstName = faker.address().firstName();
    String lastName = faker.address().lastName();
    String userEmail = faker.internet().emailAddress();
    String currentAddress = faker.aquaTeenHungerForce().character();


    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
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
        $("#currentAddress").setValue(currentAddress);
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


