package actions.pageObject.User;

import actions.pageObject.navigation.UserSideBarMyAccountPageObject;
import interfaces.pageUIs.User.MyDashBoardPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyDashBoardPageObject extends UserSideBarMyAccountPageObject {
    public MyDashBoardPageObject( WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    WebDriver driver;


    public WebElement getContactInformationByUserName() {
        return waitForElementVisible( driver,MyDashBoardPageUI.CONTACT_INFORMATION_BY_USERNAME);
    }

    public WebElement getContactInformationByEmail() {
        return waitForElementVisible(driver,MyDashBoardPageUI.CONTACT_INFORMATION_BY_EMAIL);
    }
}
