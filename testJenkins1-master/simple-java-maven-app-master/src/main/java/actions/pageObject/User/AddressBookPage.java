package actions.pageObject.User;

import actions.pageObject.navigation.UserSideBarMyAccountPageObject;
import org.openqa.selenium.WebDriver;

public class AddressBookPage extends UserSideBarMyAccountPageObject {
    WebDriver driver;

    public AddressBookPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
