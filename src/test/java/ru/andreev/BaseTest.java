package ru.andreev;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import ru.andreev.utils.CustomListener;
import ru.andreev.utils.SelenideConfig;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;

@Listeners(CustomListener.class)
public class BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        SelenideConfig.setup();
    }

    @AfterMethod
    public void afterMethod() {
        if (hasWebDriverStarted()) {
            closeWebDriver();
        }
    }
}
