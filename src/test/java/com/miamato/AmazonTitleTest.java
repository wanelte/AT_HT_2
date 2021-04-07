package com.miamato;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTitleTest extends BaseTest{

    static final String AMAZON_HOME_PAGE_URL = "https://www.amazon.com/";
    static final String AMAZON_HOME_PAGE_TITLE = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
    @Test
    public void verifyAmazonPageTitle() {
        driver.get(AMAZON_HOME_PAGE_URL);
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, AMAZON_HOME_PAGE_TITLE);
    }
}
