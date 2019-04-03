package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentPage {


    @FindBy(xpath = ".//li[@class = 'level0']/a[@href = '#singupEmail']")
    private WebElement signUpButton;
    @FindBy(xpath = ".//li[@class = 'level0']/a[@href= '#login']")
    private WebElement logInButton;
    @FindBy(xpath = ".//img[@class='landing-header__account']")
    private WebElement avatar;

    public MainPage(WebDriver webDriver) {
        super(webDriver, "/#");
    }


    @Step
    public boolean isButtonLogInPresent() {
        return actionsWithOurElements.isElementDisplay(logInButton);
    }

    @Step
    public boolean isMainPagePresent() {
        return webDriver.getTitle().contains("Forex Trading Software & Stock Market Charting Software | SmartTrader");
    }

    @Step
    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementDisplay(avatar);
    }


    public void clickOnSignUpButton() {
        actionsWithOurElements.clickOnElement(signUpButton);
    }

    public void clickOnLogInButton() {
        actionsWithOurElements.clickOnElement(logInButton);
    }


}
