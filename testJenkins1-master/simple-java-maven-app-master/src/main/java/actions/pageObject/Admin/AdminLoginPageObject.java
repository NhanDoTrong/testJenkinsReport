package actions.pageObject.Admin;

import actions.pageObject.navigation.PageGeneratorManager;
import interfaces.pageUIs.Admin.AdminLoginPageUI;
import org.openqa.selenium.WebDriver;

public class AdminLoginPageObject extends cores.common.BasePage_Executor{
    WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUserNameTextbox(String s) {
        sendKeyToElement(driver,AdminLoginPageUI.USER_NAME_INPUT_TEXTBOX,s);
    }

    public void enterToPasswordTextbox(String s) {
        sendKeyToElement(driver,AdminLoginPageUI.PASSWORD_INPUT_TEXTBOX,s);

    }

    public AdminManageCustomerPageObject clickToLoginButton() {
        clickToElement(driver,AdminLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.openAdminManageCustomerPageObject(driver);
    }
}
