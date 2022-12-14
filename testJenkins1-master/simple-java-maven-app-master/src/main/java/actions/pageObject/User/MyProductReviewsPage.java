package actions.pageObject.User;

import actions.pageObject.navigation.UserSideBarMyAccountPageObject;
import org.openqa.selenium.WebDriver;

public class MyProductReviewsPage extends UserSideBarMyAccountPageObject {
    WebDriver driver;

    public MyProductReviewsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
