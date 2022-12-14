package actions.pageObject.User;

import actions.pageObject.navigation.UserSideBarMyAccountPageObject;
import org.openqa.selenium.WebDriver;

public class MyApplicationsPage extends UserSideBarMyAccountPageObject {
    WebDriver driver;

    public MyApplicationsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
