package testcases.techpanda.account;

import actions.pageObject.User.MyDashBoardPageObject;
import actions.pageObject.User.UserHomePageObject;
import actions.pageObject.User.UserLoginPageObject;
import actions.pageObject.navigation.PageGeneratorManager;
import cores.common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;


public class Level_16_Extend_Report_Vesion_2_Teacher_Part_I extends BaseTest {
    WebDriver driver;
    UserHomePageObject homePageObject;
    UserLoginPageObject loginPageObject;
    MyDashBoardPageObject myDashBoardPageObject;
    String emailTextbox = "123@456.789";

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        driver.get("http://live.techpanda.org/");
        homePageObject = PageGeneratorManager.openUserHomePage(driver);
    }

    @Test
    public void TC_01_LoginWithEmptyEmailAndPassword() {
        log.info("Login_01-Step 01 : Click to My Account link");
        loginPageObject = homePageObject.clickToMyAccountLink();

        log.info("Login_01-Step 02 : Enter to Email Address textbox with empty Email");
        loginPageObject.inputToEmailAddressTextBox("");

        log.info("Login_01-Step 03 : Enter to Password textbox with empty Password");
        loginPageObject.inputToPasswordTextBox("");

        log.info("Login_01-Step 04 : Click to button Login");
        loginPageObject.clickToLoginButton();

        log.info("Login_01-Step 05 : Verify error Password message Empty");
        assertEquals(loginPageObject.getPasswordEmptyErrorMessage(), "This is a required field.");
    }

    @Test
    public void TC_02_LoginWithInvalidEmail() {
        log.info("Login_02-Step 01 : Enter Email  Textbox with " + emailTextbox);
        loginPageObject.inputToEmailAddressTextBox(emailTextbox);
        log.info("Login_01-Step 03 : Enter to Password textbox with  Password");
        loginPageObject.inputToPasswordTextBox("123456");
        log.info("Login_01-Step 04 : Click to button Login");
        loginPageObject.clickToLoginButton();
        log.info("Login_01-Step 05 : Verify error email address message ");
        assertEquals(loginPageObject.getEmailAddressInvalidErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test(description = "Email not exist in application")
    public void TC_03_LoginWithIncorrectEmail() {
        loginPageObject.inputToEmailAddressTextBox("auto_test" + getRandomNumber() + "@live.com");
        loginPageObject.inputToPasswordTextBox("123456");
        loginPageObject.clickToLoginButton();
        assertEquals(loginPageObject.emailPasswordIncorrectErrorMessage(), "Invalid login or password.");
    }

    @Test(description = "Password less than 6 characters")
    public void TC_04_LoginWithInvalidPassword() {
        loginPageObject.inputToEmailAddressTextBox("auto_test" + getRandomNumber() + "@live.com");
        loginPageObject.inputToPasswordTextBox("123");
        loginPageObject.clickToLoginButton();
        assertEquals(loginPageObject.passwordINValidErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_05_LoginWithIncorrectPassword() {
        loginPageObject.inputToEmailAddressTextBox("auto_test" + getRandomNumber() + "@live.com");
        loginPageObject.inputToPasswordTextBox("");
        loginPageObject.clickToLoginButton();
        assertEquals(loginPageObject.passwordINValidErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_06_LoginWithValidEmailAndPassword() {
        log.info("Login_01-Step 02 : Enter to Email Address textbox with empty Email");
        loginPageObject.inputToEmailAddressTextBox("automationfc.vn@gmail.com");
        loginPageObject.inputToPasswordTextBox("123123");
        myDashBoardPageObject = loginPageObject.clickToLoginButton();

        assertTrue(myDashBoardPageObject.getContactInformationByEmail().isDisplayed());
        //False
        assertFalse(myDashBoardPageObject.getContactInformationByEmail().isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}

