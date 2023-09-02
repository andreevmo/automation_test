package ru.andreev.utils;

import com.codeborne.selenide.Configuration;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.getenv;

public abstract class SelenideConfig {

    public static void setup() {
        if (getenv("IS_SELENOID") != null) {
            Configuration.remote = "http://localhost:4444/wd/hub";
            Map<String, Boolean> options = new HashMap<>();
            options.put("enableVNC", true);
            options.put("enableVideo", Boolean.valueOf(getenv("IS_VIDEO")));
            options.put("enableLog", true);
            Configuration.browserCapabilities.setCapability("selenoid:options", options);
        }
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10 * 1000;
        Configuration.pageLoadTimeout = 10 * 1000;
        Configuration.downloadsFolder = "src/test/resources/downloads";
        Configuration.fastSetValue = true;
    }
}
