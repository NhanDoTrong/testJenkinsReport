package actions.pageObject.User;

import actions.pageObject.navigation.PageGeneratorManager;
import interfaces.pageUIs.User.HomePageUI;
import org.openqa.selenium.WebDriver;

public class UserHomePageObject extends cores.common.BasePage_Executor {
    WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public UserLoginPageObject clickToMyAccountLink() {
        waitForElementClickable( driver,HomePageUI.MY_ACCOUNT_LINK);
        getWebElement(driver,HomePageUI.MY_ACCOUNT_LINK).click();
        return PageGeneratorManager.openUserLoginPage(driver);
    }
}
