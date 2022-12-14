package testcases.techpanda.account;

import actions.pageObject.User.*;
import actions.pageObject.navigation.PageGeneratorManager;
import cores.common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Level_08_Sidebar_Navigation_Teacher_Part_I extends BaseTest {
    WebDriver driver;
    UserHomePageObject homePageObject;
    UserLoginPageObject loginPageObject;
    MyDashBoardPageObject myDashBoardPageObject;
    MyOrdersPage myOrdersPage;
    MyProductReviewsPage myProductReviewsPage;
    MyApplicationsPage myApplicationsPage;


    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDrivers(browserName);
        driver.get("http://live.techpanda.org/");
        homePageObject = PageGeneratorManager.openUserHomePage(driver);
    }
//   @Test
//    public void TC_01_LoginWithEmptyEmailAndPassword()  {
//        loginPageObject = homePageObject.clickToMyAccountLink();
//        loginPageObject.inputToEmailAddressTextBox("");
//        loginPageObject.inputToPasswordTextBox("");
//        loginPageObject.clickToLoginButton();
//        assertEquals(loginPageObject.getEmailAddressEmptyErrorMessage(),"This is a required field.");
//        assertEquals(loginPageObject.getPasswordEmptyErrorMessage(),"This is a required field.");
//    }
//
//    @Test
//    public void TC_02_LoginWithInvalidEmail() {
//        loginPageObject.inputToEmailAddressTextBox("123@456.789");
//        loginPageObject.inputToPasswordTextBox("123456");
//        loginPageObject.clickToLoginButton();
//        assertEquals(loginPageObject.getEmailAddressInvalidErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
//    }
//
//    @Test(description = "Email not exist in application")
//    public void TC_03_LoginWithIncorrectEmail() {
//        loginPageObject.inputToEmailAddressTextBox("auto_test" + getRandomNumber() + "@live.com");
//        loginPageObject.inputToPasswordTextBox("123456");
//        loginPageObject.clickToLoginButton();
//        assertEquals(loginPageObject.emailPasswordIncorrectErrorMessage(), "Invalid login or password.");
//    }
//
//    @Test(description = "Password less than 6 characters")
//    public void TC_04_LoginWithInvalidPassword() {
//        loginPageObject.inputToEmailAddressTextBox("auto_test" + getRandomNumber() + "@live.com");
//        loginPageObject.inputToPasswordTextBox("123");
//        loginPageObject.clickToLoginButton();
//        assertEquals(loginPageObject.passwordINValidErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
//    }
//
//    @Test
//    public void TC_05_LoginWithIncorrectPassword() {
//        loginPageObject.inputToEmailAddressTextBox("auto_test" + getRandomNumber() + "@live.com");
//        loginPageObject.inputToPasswordTextBox("");
//        loginPageObject.clickToLoginButton();
//        assertEquals(loginPageObject.passwordINValidErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
//    }

    @Test
    public void TC_06_LoginWithValidEmailAndPassword() {
        loginPageObject = homePageObject.clickToMyAccountLink();
        loginPageObject.inputToEmailAddressTextBox("automationfc.vn@gmail.com");
        loginPageObject.inputToPasswordTextBox("123123");
        myDashBoardPageObject = loginPageObject.clickToLoginButton();
        assertTrue(myDashBoardPageObject.getContactInformationByUserName().isDisplayed());
        assertTrue(myDashBoardPageObject.getContactInformationByEmail().isDisplayed());
    }

    @Test
    public void TC_07_SideBar_Page() {
//        myOrdersPage = myDashBoardPageObject.openMyOrdersPage();
//        myApplicationsPage = myOrdersPage.openMyApplicationsPage();
//        myProductReviewsPage = myApplicationsPage.openMyProductReviewsPage();
//        myOrdersPage = myProductReviewsPage.openMyOrdersPage();
//        myProductReviewsPage = myOrdersPage.openMyProductReviewsPage();
//        myApplicationsPage = myProductReviewsPage.openMyApplicationsPage();
    }
    public void TC_08_Footer_Page() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}

