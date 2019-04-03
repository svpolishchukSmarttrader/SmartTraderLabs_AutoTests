package registration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import parentTest.ParentTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static libs.Utils.getDateAndTimeFormated;

public class NewRegistration extends ParentTest {
    WebDriver webDriver;
    WebDriverWait webDriverWait20;
    String email = "test_" + getDateAndTimeFormated() + "@mailinator.com";


    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriverWait20 = new WebDriverWait(webDriver, 20);
    }

    @Test
    public void newRegistration() {
        webDriver.get("https://eu.dilzzz.com");
        webDriver.findElement(By.xpath(".//li[@class = 'level0']/a[@href = '#singupEmail']")).click();
        webDriver.findElement(By.id("firstname")).sendKeys("Иван");
        webDriver.findElement(By.id("lastname")).sendKeys("Тестов");
        webDriver.findElement(By.id("email2")).sendKeys(email);
        webDriver.findElement(By.id("password2")).sendKeys("12345678");
        webDriver.findElement(By.name("month")).click();
        webDriver.findElement(By.xpath(".//select[@name = 'month']/option[@value = 'June']")).click();
        webDriver.findElement(By.name("day")).click();
        webDriver.findElement(By.xpath(".//select[@name = 'day']/option[@value = '7']")).click();
        webDriver.findElement(By.name("year")).click();
        webDriver.findElement(By.xpath(".//select[@name = 'year']/option[@value = '1982']")).click();
        webDriver.findElement(By.xpath(".//label[@for = 'checkbox-tou']")).click();
        webDriver.findElement(By.xpath(".//button[text() = 'Sign Up']")).click();


        webDriverWait20.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(".//div[@id = 'loginModal']//div[@class='modal-content']")));

        Assert.assertTrue("Exists registration popup is not present.",
                webDriver.findElement(By.xpath(".//div[@id = 'loginModal']//div[@class='modal-content']")).isDisplayed());
    }

    @After
    public void tearDown() {
//        webDriver.quit();
    }
}
