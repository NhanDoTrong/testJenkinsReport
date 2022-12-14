package actions.pageObject.User;

import actions.pageObject.navigation.UserSideBarMyAccountPageObject;
import org.openqa.selenium.WebDriver;

public class BiLLingAgreenentsPage extends UserSideBarMyAccountPageObject {
    WebDriver driver;

    public BiLLingAgreenentsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
