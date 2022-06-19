package org.nataliya.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CityComponent {
    public void setCity (String value) {
        $("#stateCity-wrapper").$(byText(value)).click();
    }
}

