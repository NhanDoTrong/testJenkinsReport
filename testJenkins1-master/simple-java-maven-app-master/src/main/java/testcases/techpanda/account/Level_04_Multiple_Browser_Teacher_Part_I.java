package testcases.techpanda.account;

import actions.pageObject.User.MyDashBoardPageObject;
import actions.pageObject.User.UserHomePageObject;
import actions.pageObject.User.UserLoginPageObject;
import cores.common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Level_04_Multiple_Browser_Teacher_Part_I extends BaseTest{
    WebDriver driver;

    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    UserHomePageObject homePageObject;
    UserLoginPageObject loginPageObject;
    MyDashBoardPageObject myDashBoardPageObject;
    BaseTest baseTest;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDrivers(browserName);
        driver.get("http://live.techpanda.org/");
        homePageObject = new UserHomePageObject(driver);
        loginPageObject = new UserLoginPageObject(driver);

    }


    @Test
    public void TC_01_LoginWithEmptyEmailAndPassword()  {
        homePageObject = new UserHomePageObject(driver);
        homePageObject.clickToMyAccountLink();
        loginPageObject.inputToEmailAddressTextBox("");
        loginPageObject.inputToPasswordTextBox("");
        loginPageObject.clickToLoginButton();
        assertEquals(loginPageObject.getEmailAddressEmptyErrorMessage(),"This is a required field.");
        assertEquals(loginPageObject.getPasswordEmptyErrorMessage(),"This is a required field.");
    }

    @Test
    public void TC_02_LoginWithInvalidEmail() {
        loginPageObject.inputToEmailAddressTextBox("123@456.789");
        loginPageObject.inputToPasswordTextBox("123456");
        loginPageObject.clickToLoginButton();
        assertEquals(loginPageObject.getEmailAddressInvalidErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test(description = "Email not exist in application")
    public void TC_03_LoginWithIncorrectEmail() {
        loginPageObject.inputToEmailAddressTextBox("auto_test" + randomNumber() + "@live.com");
        loginPageObject.inputToPasswordTextBox("123456");
        loginPageObject.clickToLoginButton();
        assertEquals(loginPageObject.emailPasswordIncorrectErrorMessage(), "Invalid login or password.");
    }

    @Test(description = "Password less than 6 characters")
    public void TC_04_LoginWithInvalidPassword() {
        loginPageObject.inputToEmailAddressTextBox("auto_test" + randomNumber() + "@live.com");
        loginPageObject.inputToPasswordTextBox("123");
        loginPageObject.clickToLoginButton();
        assertEquals(loginPageObject.passwordINValidErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_05_LoginWithIncorrectPassword() {
        loginPageObject.inputToEmailAddressTextBox("auto_test" + randomNumber() + "@live.com");
        loginPageObject.inputToPasswordTextBox("");
        loginPageObject.clickToLoginButton();
        assertEquals(loginPageObject.passwordINValidErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_06_LoginWithValidEmailAndPassword() {
        loginPageObject.inputToEmailAddressTextBox("automationfc.vn@gmail.com");
        loginPageObject.inputToPasswordTextBox("123123");
        loginPageObject.clickToLoginButton();
        myDashBoardPageObject = new MyDashBoardPageObject(driver);
        assertTrue(myDashBoardPageObject.getContactInformationByUserName().isDisplayed());
        assertTrue(myDashBoardPageObject.getContactInformationByEmail().isDisplayed());

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(999999);
    }

}

