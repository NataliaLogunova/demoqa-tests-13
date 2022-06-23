package org.nataliya.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.nataliya.pages.RegistrationFormPage;

public class TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    RegistrationFormTestData regTestData;

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void beforeEach() {
        regTestData = new RegistrationFormTestData();
        registrationFormPage.openPage();
    }
}
