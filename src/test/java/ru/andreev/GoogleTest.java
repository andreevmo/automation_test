package ru.andreev;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.andreev.web.pages.GooglePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.andreev.web.pages.GooglePage.GOOGLE_PAGE_URL;

@Owner("andreevmo")
@Feature("Google search")
public class GoogleTest extends BaseTest {

    @Test(description = "Тест на проверку поиска Google")
    public void testSearch() {
        String valueForCheck = "https://ru.selenide.org";

        List<WebElement> elementList = open(GOOGLE_PAGE_URL, GooglePage.class)
                .searchByValue("Selenide")
                .getResultsByValue(valueForCheck);

        assertThat(elementList).hasSizeGreaterThan(0);
    }
}
