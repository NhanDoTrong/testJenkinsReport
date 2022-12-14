package actions.pageObject.Admin;

import interfaces.pageUIs.Admin.AdminManageCustomerPageUI;
import org.openqa.selenium.WebDriver;

public class AdminManageCustomerPageObject extends cores.common.BasePage_Executor{
    WebDriver driver;

    public AdminManageCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void closeIncomingMessagePopup() {
        waitForElementVisible(driver, AdminManageCustomerPageUI.INCOME_MESSAGE_POPUP);
        clickToElement(driver,AdminManageCustomerPageUI.INCOME_MESSAGE_POPUP_CANCEL);

    }

}
