package actions.pageObject.User;

import actions.pageObject.navigation.UserSideBarMyAccountPageObject;
import org.openqa.selenium.WebDriver;

public class NewsletterSubscriptionsPage extends UserSideBarMyAccountPageObject {
    WebDriver driver;

    public NewsletterSubscriptionsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
