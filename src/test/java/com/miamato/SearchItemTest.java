package com.miamato;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SearchItemTest extends BaseTest {

    static final String AMAZON_HOME_PAGE_URL = "https://www.amazon.com/";
    static final String SEARCH_TERM = "bible";
    static final String SEARCH_FIELD_XPATH = "//input[@id='twotabsearchtextbox']";
    static final String SEARCH_BUTTON_XPATH = "//input[@id='nav-search-submit-button']";
    static final String SEARCH_RESULTS_XPATH = "//span[@class='a-color-state a-text-bold']";


    private static WebElement waitForElementToBePresent(String xPath, long seconds) {
        return new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }

    @Test
    public void searchItem() {
        driver.get(AMAZON_HOME_PAGE_URL);
        waitForElementToBePresent(SEARCH_FIELD_XPATH, 20).sendKeys(SEARCH_TERM);
        waitForElementToBePresent(SEARCH_BUTTON_XPATH, 20).click();
        softAssert.assertTrue(driver.findElement(By.xpath(SEARCH_RESULTS_XPATH)).isDisplayed());
        softAssert.assertAll();
    }
}
