package actions.pageObject.User;

import actions.pageObject.navigation.UserSideBarMyAccountPageObject;
import org.openqa.selenium.WebDriver;

public class MyWishListPage extends UserSideBarMyAccountPageObject {
    WebDriver driver;

    public MyWishListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
