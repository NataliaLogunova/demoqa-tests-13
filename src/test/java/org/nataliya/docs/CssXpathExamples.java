package org.nataliya.docs;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class CssXpathExamples {
    void cssXpathExamples() {
        // <input type="email" class="inputtext_login_form_input_box" name="email" data-testid="email">
        $("").setValue("123");
        $(by("[data-testid]", "")).setValue("123");

        // <input type="email", class="inputtext login_form_input_box" name="email" id="email">
        $("[id=email]").setValue("123"); //кошерно
        $("#email").setValue("123");
        $(byId("email")).setValue("123");
        $(By.id("email")).setValue("123");
        $x("//*[@id='email']").setValue("123");
        $(byXpath("//*[@id='email']")).setValue("123");

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" date-testid="email">
        $("input.inputtext.login_form_input_box#email[name=email][data-testid=email]").setValue("123");

        // <div>Hello qa.guru</div>
        $x("//div[text()='Hello qa.guru']");
        $x("//div[contains(text(), 'ello qa.gur')]");
        $x("//div[text()[contains(.,'ello qa.gur')]]");
        $(byText("Hello qa.guru"));
        $(withText("ello qa.gur"));




    }
}
