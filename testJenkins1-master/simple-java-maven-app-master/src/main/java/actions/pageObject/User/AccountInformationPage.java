package actions.pageObject.User;

import actions.pageObject.navigation.UserSideBarMyAccountPageObject;
import org.openqa.selenium.WebDriver;

public class AccountInformationPage extends UserSideBarMyAccountPageObject {
    WebDriver driver;

    public AccountInformationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
