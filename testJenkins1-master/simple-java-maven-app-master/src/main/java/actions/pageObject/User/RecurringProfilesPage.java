package actions.pageObject.User;

import actions.pageObject.navigation.UserSideBarMyAccountPageObject;
import org.openqa.selenium.WebDriver;

public class RecurringProfilesPage extends UserSideBarMyAccountPageObject {
    WebDriver driver;

    public RecurringProfilesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
