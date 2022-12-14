package actions.pageObject.User;

import actions.pageObject.navigation.UserFooterContainerPageObject;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends UserFooterContainerPageObject {
    WebDriver driver;

    public ContactUsPage( WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
