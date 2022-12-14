package testcases.techpanda.account;

import actions.pageObject.Admin.AdminLoginPageObject;
import actions.pageObject.Admin.AdminManageCustomerPageObject;
import actions.pageObject.User.*;
import actions.pageObject.navigation.PageGeneratorManager;
import cores.common.BaseTest;
import cores.common.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Level_12_Global_Constain_Teacher_Part_I extends BaseTest {
    WebDriver driver;
    UserHomePageObject userHomePageObject;
    UserLoginPageObject UserloginPageObject;
    MyDashBoardPageObject myDashBoardPageObject;
    MyOrdersPage myOrdersPage;
    MyProductReviewsPage myProductReviewsPage;
    MyApplicationsPage myApplicationsPage;
    AdvancedSearchPage advancedSearchPage;
    ContactUsPage contactUsPage;
    CustomerServicePage customerServicePage;
    String userUrl , adminUrl;
    AdminManageCustomerPageObject adminManageCustomerPageObject;
    AdminLoginPageObject adminLoginPageObject;
    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        this.adminUrl = GlobalConstants.LIVE_USER_URL;
        this.userUrl = GlobalConstants.LIVE_USER_URL;
        // Chay thang nao thi truyen thang do
        driver = getBrowserDrivers(browserName);
        userHomePageObject = PageGeneratorManager.openUserHomePage(driver);
    }

    @Test
    public void TC_06_LoginWithValidEmailAndPassword() {
        UserloginPageObject = userHomePageObject.clickToMyAccountLink();
        UserloginPageObject.inputToEmailAddressTextBox("automationfc.vn@gmail.com");
        UserloginPageObject.inputToPasswordTextBox("123123");
        myDashBoardPageObject = UserloginPageObject.clickToLoginButton();
        assertTrue(myDashBoardPageObject.getContactInformationByUserName().isDisplayed());
        assertTrue(myDashBoardPageObject.getContactInformationByEmail().isDisplayed());
    }

    @Test
    public void TC_07_SideBar_Page() {
        // cách 1 : Không return
        myDashBoardPageObject.openSideBarLinkByPageName("My Orders");
        myOrdersPage = PageGeneratorManager.openMyOrders(driver);
        myOrdersPage.openSideBarLinkByPageName("My Applications");
        myApplicationsPage = PageGeneratorManager.openMyApplicationsPage(driver);
        myApplicationsPage.openSideBarLinkByPageName("My Product Reviews");
        myProductReviewsPage =PageGeneratorManager.openMyProductReviews(driver);
        myProductReviewsPage.openSideBarLinkByPageName("My Orders");
        myOrdersPage =PageGeneratorManager.openMyOrders(driver);
        myOrdersPage.openSideBarLinkByPageName("My Product Reviews");
        myProductReviewsPage = PageGeneratorManager.openMyProductReviews(driver);
        myProductReviewsPage.openSideBarLinkByPageName("My Applications");
        myApplicationsPage = PageGeneratorManager.openMyApplicationsPage(driver);
    }
    @Test
    public void TC_08_Footer_Page() {
    advancedSearchPage = myApplicationsPage.getFooterContainerPageObject(driver).openAdvancedSearchPage();
    contactUsPage = advancedSearchPage.openContactUsPage();
    customerServicePage = contactUsPage.openCustomerServicePage();
    }
    @Test
    public void TC_09_Role() {
        // User --- >Admin ( Login)
        adminLoginPageObject = customerServicePage.openUrlAdminPage(driver,GlobalConstants.LIVE_ADMIN_URL);
        PageGeneratorManager.openAdminLoginPageObject(driver);
        adminLoginPageObject.enterToUserNameTextbox("user01");
        adminLoginPageObject.enterToPasswordTextbox("guru99com");
        adminManageCustomerPageObject = adminLoginPageObject.clickToLoginButton();
        adminManageCustomerPageObject.closeIncomingMessagePopup();
        // ADmin -->User
        adminLoginPageObject = adminManageCustomerPageObject.getAdminHeaderPageObject(driver).clickToLogoutLink();
        UserloginPageObject = adminLoginPageObject.openUrlUserPage(driver,GlobalConstants.LIVE_USER_URL);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}

