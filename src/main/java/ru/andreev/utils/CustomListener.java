package ru.andreev.utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class CustomListener implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (WebDriverRunner.hasWebDriverStarted()) {
            makeScreenshot();
        }
    }

    @Attachment(value = "Page screenchot", type = "image/png")
    private byte[] makeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}
