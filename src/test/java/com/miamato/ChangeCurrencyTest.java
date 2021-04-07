package com.miamato;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends BaseTest {
    static final String AMAZON_HOME_PAGE_URL = "https://www.amazon.com/";
    static final String NEW_CURRENCY = "EUR";
    static final String FLAG_BUTTON_XPATH = "//span[contains(@class,'icp-nav-flag')]";
    static final String CURRENCY_LIST_XPATH = "//span[@data-action='a-dropdown-button']";
    static final String NEW_CURRENCY_BUTTON_XPATH = "//a[contains(@data-value,'" + NEW_CURRENCY + "')]";
    static final String NEW_CURRENCY_LIST_XPATH = "//span[contains(text(),'" + NEW_CURRENCY + "') and @class='a-button-text a-declarative']";
    static final String SAVE_CHANGES_BUTTON_XPATH = "//input[@class='a-button-input']";

    private static WebElement waitForElementToBePresentFluent(String xPath, long timeoutSeconds, long intervalSeconds) {
        return new WebDriverWait(driver, timeoutSeconds, intervalSeconds*1000)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }

    @Test
    public void changeCurrencyToEuroTest() {
        driver.get(AMAZON_HOME_PAGE_URL);
        waitForElementToBePresentFluent(FLAG_BUTTON_XPATH, 20, 2).click();
        waitForElementToBePresentFluent(CURRENCY_LIST_XPATH, 20, 2).click();
        waitForElementToBePresentFluent(NEW_CURRENCY_BUTTON_XPATH, 20, 2).click();
        waitForElementToBePresentFluent(SAVE_CHANGES_BUTTON_XPATH, 20,2).click();
        waitForElementToBePresentFluent(FLAG_BUTTON_XPATH,20, 2).click();
        Assert.assertTrue(driver.findElement(By.xpath(NEW_CURRENCY_LIST_XPATH)).isDisplayed());
    }
}
