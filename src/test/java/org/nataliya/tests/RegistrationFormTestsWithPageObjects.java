package org.nataliya.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.nataliya.pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTestsWithPageObjects extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillFormTest() {
        String firstName = "Paul";
        String lastName = "Richardson";

        registrationFormPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail("paulri4@gmail.com")
                    .setGender("Male")
                    .setUserNumber("9010003344")
                    .setDateOfBirth( "01","October", "1991")
                    .setSubject("English")
                    .setHobbies("Music")
                    .setPicture("picture.jpg")
                    .setAddress("9/1 Oakstreet, Portland, USA")
                    .setState("NCR")
                    .setCity("Delhi")
                    .clickSubmit()
                    .checkFormAppeared("Thanks for submitting the form")
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", "paulri4@gmail.com")
                    .checkResult("Date of Birth", "01 October,1991")
                    .checkResult("Subjects", "English")
                    .checkResult("Hobbies", "Music")
                    .checkResult("Picture", "picture.jpg")
                    .checkResult("Address", "9/1 Oakstreet, Portland, USA")
                    .checkResult("State and City", "NCR Delhi");

    }
}


