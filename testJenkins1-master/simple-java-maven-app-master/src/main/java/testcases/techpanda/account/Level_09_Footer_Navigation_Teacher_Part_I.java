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

public class Level_09_Footer_Navigation_Teacher_Part_I extends BaseTest {
    WebDriver driver;
    UserHomePageObject homePageObject;
    UserLoginPageObject loginPageObject;
    MyDashBoardPageObject myDashBoardPageObject;
    MyOrdersPage myOrdersPage;
    MyProductReviewsPage myProductReviewsPage;
    MyApplicationsPage myApplicationsPage;
    AdvancedSearchPage advancedSearchPage;
    ContactUsPage contactUsPage;
    CustomerServicePage customerServicePage;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDrivers(browserName);
        driver.get("http://live.techpanda.org/");
        homePageObject = PageGeneratorManager.openUserHomePage(driver);
    }

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
    @Test
    public void TC_08_Footer_Page() {
    advancedSearchPage = myApplicationsPage.getFooterContainerPageObject(driver).openAdvancedSearchPage();
    contactUsPage = advancedSearchPage.openContactUsPage();
    customerServicePage = contactUsPage.openCustomerServicePage();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}

