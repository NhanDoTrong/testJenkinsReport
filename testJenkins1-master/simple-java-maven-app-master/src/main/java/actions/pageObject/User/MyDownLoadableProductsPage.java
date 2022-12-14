
package actions.pageObject.User;

import actions.pageObject.navigation.UserSideBarMyAccountPageObject;
import org.openqa.selenium.WebDriver;

public class MyDownLoadableProductsPage extends UserSideBarMyAccountPageObject {
    WebDriver driver;

    public MyDownLoadableProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
