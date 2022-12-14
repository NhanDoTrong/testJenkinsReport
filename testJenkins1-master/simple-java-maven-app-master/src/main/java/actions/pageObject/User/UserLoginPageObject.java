package actions.pageObject.User;

import actions.pageObject.navigation.PageGeneratorManager;
import interfaces.pageUIs.User.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class UserLoginPageObject extends cores.common.BasePage_Executor {
    WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void inputToEmailAddressTextBox(String emailAddress) {
        sendKeyToElement(driver,LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
    }

    public void inputToPasswordTextBox(String password) {
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public MyDashBoardPageObject clickToLoginButton() {
        waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
        getWebElement(driver,LoginPageUI.LOGIN_BUTTON).click();
        return PageGeneratorManager.openMyDashBoard(driver);
    }

    public String getEmailAddressEmptyErrorMessage() {
        return waitForElementVisible( driver,LoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE).getText();
    }

    public String getPasswordEmptyErrorMessage() {
        return waitForElementVisible(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE).getText();

    }

    public String getEmailAddressInvalidErrorMessage() {
        return waitForElementVisible(driver,LoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSAGE).getText();
    }

    public String emailPasswordIncorrectErrorMessage() {
        return waitForElementVisible(driver,LoginPageUI.EMAIL_PASSWORD_INCORRECT_ERROR_MESSAGE).getText();
    }

    public String passwordINValidErrorMessage() {
        return waitForElementVisible(driver,LoginPageUI.PASSWORD_INVALID_ERROR_MESSAGE).getText();
    }

}
