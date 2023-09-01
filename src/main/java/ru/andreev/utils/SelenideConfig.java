package ru.andreev.utils;

import com.codeborne.selenide.Configuration;

public abstract class SelenideConfig {

    public static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10 * 1000;
        Configuration.pageLoadTimeout = 10 * 1000;
        Configuration.downloadsFolder = "src/test/resources/downloads";
        Configuration.fastSetValue = true;
    }
}
