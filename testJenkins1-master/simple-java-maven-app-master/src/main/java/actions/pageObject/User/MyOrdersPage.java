package actions.pageObject.User;

import actions.pageObject.navigation.UserSideBarMyAccountPageObject;
import org.openqa.selenium.WebDriver;

public class MyOrdersPage extends UserSideBarMyAccountPageObject {
    WebDriver driver;

    public MyOrdersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
