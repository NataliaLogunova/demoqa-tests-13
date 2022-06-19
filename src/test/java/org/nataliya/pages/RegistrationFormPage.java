package org.nataliya.pages;

import com.codeborne.selenide.SelenideElement;
import org.nataliya.pages.components.CalendarComponent;
import org.nataliya.pages.components.CityComponent;
import org.nataliya.pages.components.ResultsTableComponent;
import org.nataliya.pages.components.StateComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    public CalendarComponent calendarComponent = new CalendarComponent();
    public ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    public StateComponent stateComponent = new StateComponent();
    public CityComponent cityComponent = new CityComponent();

    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName (String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setUserEmail (String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationFormPage setGender (String value) {
        $("#genterWrapper").$(byText("Male")).click();

        return this;
    }

    public RegistrationFormPage setUserNumber (String value) {
        $("#userNumber").setValue("9010003344");

        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        $("#subjectsInput").sendKeys("English");
        $("#subjectsInput").pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText("Music")).click();

        return this;
    }

    public RegistrationFormPage setPicture(String value) {
        $("#uploadPicture").uploadFromClasspath("picture.jpg");

        return this;
    }

    public RegistrationFormPage setAddress (String value) {
        $("#currentAddress").setValue("9/1 Oakstreet, Portland, USA");

        return this;
    }

    public RegistrationFormPage setState(String value) {
        $("#state").click();
        stateComponent.setState(value);

        return this;
    }
    public RegistrationFormPage setCity(String value) {
        $("#city").click();
        cityComponent.setCity(value);

        return this;
    }
    public RegistrationFormPage clickSubmit() {
        $("#submit").click();

        return this;
    }

    public RegistrationFormPage checkFormAppeared(String value) {
        $("#example-modal-sizes-title-lg")
                .shouldHave(text("Thanks for submitting the form"));

        return this;
    }
    public RegistrationFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);

        return this;
    }

}
