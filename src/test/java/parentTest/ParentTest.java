package parentTest;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected MainPage mainPage;
    protected LoginPage loginPage;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
    }

    @After
    public void tearDown() {
//        webDriver.quit();
    }

    @Step
    protected void checkAC(String message, boolean actual, boolean expected) {
        if (actual != expected) {
            logger.error("AC failed: " + message);
        }
        Assert.assertEquals(message, expected, actual);
    }
}
