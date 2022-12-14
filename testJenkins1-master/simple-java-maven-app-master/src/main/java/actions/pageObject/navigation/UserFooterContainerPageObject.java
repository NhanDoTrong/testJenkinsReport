package actions.pageObject.navigation;

import actions.pageObject.User.AdvancedSearchPage;
import actions.pageObject.User.ContactUsPage;
import actions.pageObject.User.CustomerServicePage;
import interfaces.pageUIs.User.FooterContainerPageUI;
import org.openqa.selenium.WebDriver;

public class UserFooterContainerPageObject extends cores.common.BasePage_Executor{
    WebDriver driver;

    public UserFooterContainerPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public AdvancedSearchPage openAdvancedSearchPage() {
        waitForElementClickable(driver, FooterContainerPageUI.ADVANCED_SEARCH);
        clickToElement(driver, FooterContainerPageUI.ADVANCED_SEARCH);
        return PageGeneratorManager.openAdvancedSearchPage(driver);
    }
    public ContactUsPage openContactUsPage() {
        waitForElementClickable(driver, FooterContainerPageUI.CONTACT_US);
        clickToElement(driver, FooterContainerPageUI.CONTACT_US);
        return PageGeneratorManager.openContactUsPage(driver);
    }
    public CustomerServicePage openCustomerServicePage() {
        waitForElementClickable(driver, FooterContainerPageUI.CUSTOMER_SERVICE);
        clickToElement(driver, FooterContainerPageUI.CUSTOMER_SERVICE);
        return PageGeneratorManager.openCustomerServicePage(driver);
    }
}
