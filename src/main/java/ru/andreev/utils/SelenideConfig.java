package ru.andreev.utils;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Configuration.*;
import static java.lang.System.getenv;

public abstract class SelenideConfig {

    public static void setup() {
        if (getenv("IS_SELENOID") != null) {
            remote = "http://localhost:4444/wd/hub";
            Map<String, Boolean> options = new HashMap<>();
            options.put("enableVNC", true);
            options.put("enableVideo", Boolean.valueOf(getenv("IS_VIDEO")));
            options.put("enableLog", true);
            browserCapabilities.setCapability("selenoid:options", options);
        }
        browser = "chrome";
        browserSize = "1920x1080";
        timeout = 10 * 1000;
        pageLoadTimeout = 10 * 1000;
        downloadsFolder = "src/test/resources/downloads";
        fastSetValue = true;
    }
}
