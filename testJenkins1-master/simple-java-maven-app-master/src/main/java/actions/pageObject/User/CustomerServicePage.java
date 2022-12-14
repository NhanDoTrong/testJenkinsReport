package actions.pageObject.User;

import actions.pageObject.navigation.UserFooterContainerPageObject;
import org.openqa.selenium.WebDriver;

public class CustomerServicePage extends UserFooterContainerPageObject {
    WebDriver driver;

    public CustomerServicePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
