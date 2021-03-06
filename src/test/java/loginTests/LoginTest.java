package loginTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {
    private WebDriver driver;

    @Test
    
    public void validLoginTest() throws Exception{
        try{
        Thread.sleep(3000);
        loginPage.openPage();
        loginPage.enterEmail("360ProTagTest@gmail.com");
        loginPage.enterPassword("1Qaz2wsx");
        loginPage.clickOnLogInButton();

        checkAC("'Log In' link is present.",
                !mainPage.isMainPagePresent(),
                false);

        checkAC("Avatar link isn't present.",
                mainPage.isAvatarPresent(),
                false);
        }finally {
            takeScreenshot(driver);
        }
    }
//    public void validLogin() {
//        loginPage.openPage();
//        loginPage.enterEmail("360ProTagTest@gmail.com");
//        loginPage.enterPassword("1Qaz2wsx");
//        loginPage.clickOnLogInButton();
//
//        checkAC("'Log In' link is present.",
//                !mainPage.isMainPagePresent(),
//                false);
//
//        checkAC("Avatar link isn't present.",
//                mainPage.isAvatarPresent(),
//                false);
//    }

    @Test
    public void unValidLogin() {
        loginPage.openPage();
        loginPage.enterEmail("equimosis@bigmir.net");
        loginPage.enterPassword("8dggmdkaslY");
        loginPage.clickOnLogInButton();

//        checkAC("Incorrect login alert isn't present.",
//                loginPage.isAlertPresent(),
//                false);
    }
    @Test
    public void addAlerts(){
        loginPage.login("","","");

    }
}
