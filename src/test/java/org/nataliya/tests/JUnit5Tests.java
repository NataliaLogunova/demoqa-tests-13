package org.nataliya.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnit5Tests {

    @BeforeEach
    void openYaPage() {
        Selenide.open("https://ya.ru");
    }

    @AfterEach
    void close() {
        WebDriverRunner.closeWindow();
    }

    @Test
    void assertTest1(){
        // ... поиск в новостях
    }

    @Test
    void assertTest2(){
        // ... поиск в картинках
    }

}
