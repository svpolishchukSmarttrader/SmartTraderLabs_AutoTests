package parentTest;

import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.LoginPage;
import pages.MainPage;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    private RemoteWebDriver driver;

    //WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected MainPage mainPage;
    protected LoginPage loginPage;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("75.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                capabilities
        );
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
    }


public void takeScreenshot(WebDriver driver) throws Exception {
        byte[] screen = ((TakesScreenshot) new Augmenter().augment(driver)).getScreenshotAs(OutputType.BYTES);
        UUID uuid = UUID.randomUUID();
        FileUtils.writeByteArrayToFile(new File (uuid.toString() + ".png"), screen);
    }

    @After
    public void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
//    public void tearDown() {
//        webDriver.quit();
//    }

    @Step
    protected void checkAC(String message, boolean actual, boolean expected) {
        if (actual != expected) {
            logger.error("AC failed: " + message);
        }
        Assert.assertEquals(message, expected, actual);
    }
}
