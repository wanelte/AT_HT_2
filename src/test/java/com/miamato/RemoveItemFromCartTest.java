package com.miamato;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RemoveItemFromCartTest extends BaseTest {

    static final String AMAZON_HOME_PAGE_URL = "https://www.amazon.com/";
    static final String SEARCH_TERM = "bible";
    static final String SEARCH_FIELD_XPATH = "//input[@id='twotabsearchtextbox']";
    static final String SEARCH_BUTTON_XPATH = "//input[@id='nav-search-submit-button']";
    static final String SEARCHED_ITEM_LINK_XPATH = "//span[@data-component-id='2']//a";
    static final String ONE_ITEM_IN_CART_XPATH = "//*[contains(@id,'nav-cart-count') and contains(text(), 1)]";
    static final String ZERO_ITEM_IN_CART_XPATH = "//*[contains(@id,'nav-cart-count') and contains(text(), 0)]";
    static final String ADD_TO_CART_BUTTON_XPATH = "//input[@id='add-to-cart-button']";
    static final String GO_TO_CART_BUTTON_XPATH = "//a[@id='hlb-view-cart-announce']";
    static final String REMOVE_FROM_CART_BUTTON_XPATH = "//input[@data-action='delete']";

    private static WebElement waitForElementToBePresentFluent(String xPath, long timeoutSeconds, long intervalSeconds) {
        return new WebDriverWait(driver, timeoutSeconds, intervalSeconds * 1000)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }

    @Test
    public void removeFromCartTest() {
        driver.get(AMAZON_HOME_PAGE_URL);
        waitForElementToBePresentFluent(SEARCH_FIELD_XPATH, 15, 1).sendKeys(SEARCH_TERM);
        waitForElementToBePresentFluent(SEARCH_BUTTON_XPATH, 15, 1).click();
        waitForElementToBePresentFluent(SEARCHED_ITEM_LINK_XPATH, 20, 1).click();
        waitForElementToBePresentFluent(ADD_TO_CART_BUTTON_XPATH, 15, 1).click();
        softAssert.assertTrue(driver.findElement(By.xpath(ONE_ITEM_IN_CART_XPATH)).isDisplayed());
        waitForElementToBePresentFluent(GO_TO_CART_BUTTON_XPATH, 15, 1).click();
        waitForElementToBePresentFluent(REMOVE_FROM_CART_BUTTON_XPATH, 15, 1).click();
        softAssert.assertTrue(driver.findElement(By.xpath(ZERO_ITEM_IN_CART_XPATH)).isDisplayed());
        softAssert.assertAll();
    }
}
