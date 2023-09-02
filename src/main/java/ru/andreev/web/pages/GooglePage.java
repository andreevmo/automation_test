package ru.andreev.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static java.time.Duration.ofSeconds;
import static ru.andreev.web.pages.BasePage.XPATH_CITE;

public class GooglePage {

    public static final String GOOGLE_PAGE_URL = "https://www.google.com/";

    @FindBy(xpath = "//textarea[@name='q']")
    SelenideElement search;

    @FindBy(xpath = "//h1[text()='Результаты поиска']")
    SelenideElement sectionResults;

    @Step("Задать значение для поиска '{0}' и нажать Enter")
    public GooglePage searchByValue(String value) {
        search.setValue(value).pressEnter();
        sectionResults.should(exist, ofSeconds(10));
        return this;
    }

    @Step("Получить результаты по значению '{0}'")
    public List<WebElement> getResultsByValue(String value) {
        return sectionResults.findElements(By.xpath(String.format(XPATH_CITE, value))).stream()
                .filter(WebElement::isDisplayed)
                .toList();
    }
}
