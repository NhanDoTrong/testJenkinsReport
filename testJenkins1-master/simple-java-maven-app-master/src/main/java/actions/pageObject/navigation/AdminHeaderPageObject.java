package actions.pageObject.navigation;

import actions.pageObject.Admin.AdminLoginPageObject;
import interfaces.pageUIs.Admin.AdminHeaderPageUI;
import org.openqa.selenium.WebDriver;

public class AdminHeaderPageObject extends cores.common.BasePage_Executor {
    WebDriver driver;

    public AdminHeaderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AdminLoginPageObject clickToLogoutLink() {
        clickToElement(driver, AdminHeaderPageUI.LOGOUT_LINK);
        return new AdminLoginPageObject(driver);
    }
}
