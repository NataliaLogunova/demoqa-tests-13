package org.nataliya.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.nataliya.pages.RegistrationFormPage;


public class RegistrationFormTestsWithPageObjectsFaker extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();




    @Test
    public void fillFormTest() {
        //String firstName = "Paul";
        //String lastName = "Richardson";

        registrationFormPage.openPage()
                    .setFirstName(regTestData.firstName)
                    .setLastName(regTestData.lastName)
                    .setUserEmail(regTestData.userEmail)
                    .setGender(regTestData.gender)
                    .setUserNumber(regTestData.userNumber)
                    .setDateOfBirth(regTestData.dayOfBirth, regTestData.monthOfBirth, regTestData.yearOfBirth)
                    .setSubject(regTestData.subject)
                    .setHobbies(regTestData.hobbies)
                    .setPicture(regTestData.pictureName)
                    .setAddress(regTestData.currentAddress)
                    .setState(regTestData.state)
                    .setCity(regTestData.city)
                    .clickSubmit()
                    .checkFormAppeared("Thanks for submitting the form")
                    .checkResult("Student Name", regTestData.firstName + " " + regTestData.lastName)
                    .checkResult("Student Email", regTestData.userEmail)
                    .checkResult("Date of Birth", regTestData.dayOfBirth + " "
                            + regTestData.monthOfBirth + "," + regTestData.yearOfBirth)
                    .checkResult("Subjects", regTestData.subject)
                    .checkResult("Hobbies", regTestData.hobbies)
                    .checkResult("Picture", regTestData.pictureName)
                    .checkResult("Address", regTestData.currentAddress)
                    .checkResult("State and City", regTestData.state + " " + regTestData.city);

    }
}


