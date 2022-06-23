package org.nataliya.tests;

import com.github.javafaker.Faker;

public class RegistrationFormTestData {


    Faker faker = new Faker();

    String firstName = faker.address().firstName();
    String lastName = faker.address().lastName();
    String userEmail = faker.internet().emailAddress();
    String gender = "Female";
    String userNumber = faker.number().digits(10);
    String monthOfBirth = "May";
    String yearOfBirth = String.valueOf(faker.number().numberBetween(1988, 2004));
    String dayOfBirth = "15";
    String subject = "English";
    String hobbies = "Music";
    String pictureName = "picture.jpg";
    String currentAddress = faker.address().fullAddress();
    String state = "NCR";
    String city = "Delhi";


}
