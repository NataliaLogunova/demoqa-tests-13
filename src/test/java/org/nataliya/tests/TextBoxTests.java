package org.nataliya.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1229x597";
    }

    @Test
    void fillFormTest() {
        String name = "Paul Richardson";

        open("/text-box");

        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue("idk@gmail.com");
        $("[id=currentAddress]").setValue("App. 56, Kalinina st.,6, Moscow");
        $("[id=permanentAddress]").setValue("9/1 Oakstreet, Portland, USA");
        $( "[id=submit]").click();

        // Asserts
        $("[id=output]").shouldHave(text(name), text("idk@gmail.com"),
                text("App. 56, Kalinina st.,6, Moscow"),
                text("9/1 Oakstreet, Portland, USA"));

//        $("[id=output] [id=name]").shouldHave(text(name));
//        $("[id=output]").$("[id=name]").shouldHave(text(name));
//        $("[id=name").shouldHave(text(name));
//        $("p[id=permanentAddress]").shouldHave(text("Permanent Address :9/1 Oakstreet, Portland, USA"));
//
    }
}
