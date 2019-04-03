package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    String baseUrl;
    String expectedUrl;
    ActionsWithOurElements actionsWithOurElements;


    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        baseUrl = "https://dev.smarttrader.com";
        this.expectedUrl = baseUrl + expectedUrl;
        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public void checkCurrentUrl() {
        try {
            Assert.assertEquals("Url isn't expected!", expectedUrl, getCurrentUrl());
        } catch (Exception e) {
            logger.error("Can't work with URL.");
            Assert.fail("Can't work with URL.");
        }
    }

}
