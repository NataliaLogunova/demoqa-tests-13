package org.nataliya.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class HomeWork {

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

        $("[id=firstName]").setValue(name);
        $("[id=lastName]").setValue("Richardson");

        $("[id=userEmail]").setValue("paulri4@gmail.com");

        $(byText("Male")).click();

        $("[id=userNumber]").setValue("9010003344");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("October")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1991")).scrollIntoView(true).click();
        $(byText("1")).click();

        $("#subjectsInput").sendKeys("English");
        $("#subjectsInput").pressEnter();

        $(byText("Music")).click();

        $("#currentAddress").setValue("9/1 Oakstreet, Portland, USA");

        $("#submit").click();
    }
}
