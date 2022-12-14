package actions.pageObject.User;

import actions.pageObject.navigation.UserFooterContainerPageObject;
import org.openqa.selenium.WebDriver;

public class AdvancedSearchPage extends UserFooterContainerPageObject {
    WebDriver driver;

    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
