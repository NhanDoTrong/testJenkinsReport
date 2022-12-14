package testcases.techpanda.account;

import actions.pageObject.Admin.AdminLoginPageObject;
import actions.pageObject.Admin.AdminManageCustomerPageObject;
import actions.pageObject.User.*;
import actions.pageObject.navigation.PageGeneratorManager;
import cores.common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Level_11_Dinamic_Locator_Teacher_Part_II extends BaseTest {
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
    @Parameters({"browser","userUrl","adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl , String adminUrl) {
        this.adminUrl = adminUrl;
        this.userUrl = userUrl;
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
        // Cách 2 : Có return
        myOrdersPage = (MyOrdersPage) myDashBoardPageObject.openSideBarLinkByPageNames("My Orders");
        myApplicationsPage = (MyApplicationsPage) myOrdersPage.openSideBarLinkByPageNames("My Applications");
        myProductReviewsPage = (MyProductReviewsPage) myApplicationsPage.openSideBarLinkByPageNames("My Product Reviews");
        myOrdersPage = (MyOrdersPage) myProductReviewsPage.openSideBarLinkByPageNames("My Orders");
        myProductReviewsPage = (MyProductReviewsPage) myOrdersPage.openSideBarLinkByPageNames("My Product Reviews");
        myApplicationsPage = (MyApplicationsPage) myProductReviewsPage.openSideBarLinkByPageNames("My Applications");
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
        adminLoginPageObject = customerServicePage.openUrlAdminPage(driver,adminUrl);
        PageGeneratorManager.openAdminLoginPageObject(driver);
        adminLoginPageObject.enterToUserNameTextbox("user01");
        adminLoginPageObject.enterToPasswordTextbox("guru99com");
        adminManageCustomerPageObject = adminLoginPageObject.clickToLoginButton();
        adminManageCustomerPageObject.closeIncomingMessagePopup();
        // ADmin -->User
        adminLoginPageObject = adminManageCustomerPageObject.getAdminHeaderPageObject(driver).clickToLogoutLink();
        UserloginPageObject = adminLoginPageObject.openUrlUserPage(driver,userUrl);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}

