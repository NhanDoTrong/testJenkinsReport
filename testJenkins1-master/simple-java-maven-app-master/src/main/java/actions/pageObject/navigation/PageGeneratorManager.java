package actions.pageObject.navigation;

import actions.pageObject.Admin.AdminLoginPageObject;
import actions.pageObject.Admin.AdminManageCustomerPageObject;
import actions.pageObject.User.*;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

    public static UserHomePageObject openUserHomePage(WebDriver driver) {
        return new UserHomePageObject(driver);
    }

    public static UserLoginPageObject openUserLoginPage(WebDriver driver) {
        return new UserLoginPageObject(driver);
    }

    public static MyDashBoardPageObject openMyDashBoard(WebDriver driver) {
        return new MyDashBoardPageObject(driver);
    }

    public static AccountDashboardPage openAccountDashboard (WebDriver driver) {
        return new AccountDashboardPage(driver);
    }

    public static AccountInformationPage openAccountInformation (WebDriver driver) {
        return new AccountInformationPage(driver);
    }

    public static AddressBookPage openAddressBook (WebDriver driver) {
        return new AddressBookPage(driver);
    }

    public static  MyOrdersPage openMyOrders (WebDriver driver) {
        return new MyOrdersPage(driver);
    }

    public static BiLLingAgreenentsPage openBiLLingAgreenents (WebDriver driver) {
        return new BiLLingAgreenentsPage(driver);
    }

    public static RecurringProfilesPage openRecurringProfiles (WebDriver driver) {
        return new RecurringProfilesPage(driver);
    }

    public static MyProductReviewsPage openMyProductReviews (WebDriver driver) {
        return new MyProductReviewsPage(driver);
    }

    public static MyWishListPage openMyWishList (WebDriver driver) {
        return new MyWishListPage(driver);
    }

    public static  MyApplicationsPage  openMyApplicationsPage(WebDriver driver) {
        return new MyApplicationsPage(driver);
    }

    public static NewsletterSubscriptionsPage openNewsletterSubscriptionsPage(WebDriver driver) {
        return new NewsletterSubscriptionsPage(driver);
    }
    public static AdvancedSearchPage openAdvancedSearchPage(WebDriver driver) {
        return new AdvancedSearchPage(driver);
    }
    public static ContactUsPage openContactUsPage(WebDriver driver) {
        return new ContactUsPage(driver);
    }    public static CustomerServicePage openCustomerServicePage(WebDriver driver) {
        return new CustomerServicePage(driver);
    }    public static MyDownLoadableProductsPage openMyDownLoadableProductsPage(WebDriver driver) {
        return new MyDownLoadableProductsPage(driver);
    }
    public static AdminManageCustomerPageObject openAdminManageCustomerPageObject(WebDriver driver) {
        return new AdminManageCustomerPageObject(driver);
    }
    public static AdminLoginPageObject openAdminLoginPageObject(WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }

}
