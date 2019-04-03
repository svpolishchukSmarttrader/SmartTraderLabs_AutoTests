package registration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ExistsRegistration {

    WebDriver webDriver;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void existRegistration() {

        webDriver.get("https://eu.dilzzz.com");
        webDriver.findElement(By.xpath(".//li[@class = 'level0']/a[@href = '#singupEmail']")).click();
        webDriver.findElement(By.id("firstname")).sendKeys("Сергей");
        webDriver.findElement(By.id("lastname")).sendKeys("Полищук");
        webDriver.findElement(By.id("email2")).sendKeys("psv0782@gmail.com");
        webDriver.findElement(By.id("password2")).sendKeys("12345678");
        webDriver.findElement(By.name("month")).click();
        webDriver.findElement(By.xpath(".//select[@name = 'month']/option[@value = 'January']")).click();
        webDriver.findElement(By.name("day")).click();
        webDriver.findElement(By.xpath(".//select[@name = 'day']/option[@value = '7']")).click();
        webDriver.findElement(By.name("year")).click();
        webDriver.findElement(By.xpath(".//select[@name = 'year']/option[@value = '1982']")).click();
        webDriver.findElement(By.xpath(".//label[@for = 'checkbox-tou']")).click();
        webDriver.findElement(By.xpath(".//button[text() = 'Sign Up']")).click();

        Assert.assertTrue("Welcome popup is not present.",
                webDriver.findElement(By.xpath(".//div[@id = 'welcome']//div[@class='modal-dialog']")).isDisplayed());

    }

    @After
    public void tearDown() {
//        webDriver.quit();
    }
}