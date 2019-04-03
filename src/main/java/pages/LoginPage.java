package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.print.DocFlavor;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//input[@placeholder='Email Address']")
    private WebElement emailInput;
    @FindBy(xpath = ".//input[@placeholder='Password']")
    private WebElement passwordInput;
    @FindBy(xpath = ".//button[@name='authenticate']")
    private WebElement logInButton;
    @FindBy(xpath = ".//input[@value='Yes']")
    private WebElement checkRememberMe;
    @FindBy(xpath = ".//a[@class='joinForFreeLogin']")
    private WebElement joinForFreeButton;
    @FindBy(xpath = ".//a[@id='forgotPassword']")
    private WebElement forgotPasswordLink;
    @FindBy(xpath = ".//body/div/div[@class='login_page_wrap']/div[contains(@class,'login-item flex-item')]/div[1]")
    private WebElement wrongMessage;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login/");
    }

    @Step
    public void openPage() {
        try {
            webDriver.get(baseUrl + "/login/");
            checkCurrentUrl();
            logger.info("LoginPage was opened.");
        } catch (Exception e) {
            logger.error("Can't open LoginPage.");
            Assert.fail("Can't open LoginPage.");
        }
    }

    @Step
    public void openPage(String url) {
        try {
            webDriver.get(url + "/login/");
            checkCurrentUrl();
            logger.info("LoginPage was opened.");
        } catch (Exception e) {
            logger.error("Can't open LoginPage.");
            Assert.fail("Can't open LoginPage.");
        }
    }

    @Step
    public void login(String url, String email, String password) {
        try {
            openPage(url);
            enterEmail(email);
            enterPassword(password);
            clickOnLogInButton();
            isMainPagePresent();
        } catch (Exception e) {
            logger.error("Can't open LoginPage.");
            Assert.fail("Can't open LoginPage.");
        }
    }

    @Step
    public void enterEmail(String email) {
        actionsWithOurElements.enterTextToElement(emailInput, email);
    }

    @Step
    public void enterPassword(String password) {
        actionsWithOurElements.enterTextToElement(passwordInput, password);
    }

    @Step
    public void clickOnLogInButton() {
        actionsWithOurElements.clickOnElement(logInButton);
    }

    @Step
    protected void checkAC(String message, boolean actual, boolean expected) {
        if (actual != expected) {
            logger.error("AC failed: " + message);
        }
        Assert.assertEquals(message, expected, actual);
    }
    @Step
    public boolean isMainPagePresent() {
        return webDriver.getTitle().contains("Forex Trading Software & Stock Market Charting Software | SmartTrader");
    }

//    @Step
//    public boolean isAlertPresent() {
//        return actionsWithOurElements.isElementDisplay(modalAlertLogin);
//    }
}
