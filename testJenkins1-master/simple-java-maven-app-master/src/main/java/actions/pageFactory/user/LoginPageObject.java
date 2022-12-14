package actions.pageFactory.user;

import cores.common.BasePage_Factory_Teacher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePage_Factory_Teacher {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "xpath=//input[@id='email']")
    WebElement EmailTextBox;

    @FindBy(how = How.XPATH, using = "xpath=//input[@id='pass']")
    WebElement PasswordTextBox;

    @FindBy(how = How.XPATH, using = "xpath=//button[@id='send2']")
    WebElement LoginButton;
    @FindBy(how = How.XPATH, using = "xpath=//div[@id='advice-required-entry-email']")
    WebElement EmailAddressEmptyErrorMessage;
    @FindBy(how = How.XPATH, using = "xpath=//div[@id='advice-required-entry-pass']")
    WebElement PasswordEmptyErrorMessage;
    @FindBy(how = How.XPATH, using = "xpath=//div[@id='advice-validate-email-email']")
    WebElement EmailAddressInvalidErrorMessage;
    @FindBy(how = How.XPATH, using = "xpath=//li[@class='error-msg']//span")
    WebElement emailPasswordIncorrectErrorMessage;
    @FindBy(how = How.XPATH, using = "xpath=//div[@id='advice-validate-password-pass']")
    WebElement passwordINValidErrorMessage;

    public void inputToEmailAddressTextBox(String dataValue) {
        sendKeyToElement(driver, EmailTextBox, dataValue);
    }

    public void inputToPasswordTextBox(String dataValue) {
        sendKeyToElement(driver, PasswordTextBox, dataValue);
    }

    public void clickToLoginButton() {
        clickToElement(driver, LoginButton);
    }
    public String getEmailAddressEmptyErrorMessage(){
        return getTextElement(EmailAddressEmptyErrorMessage);
    }
    public String getPasswordEmptyErrorMessage(){
        return getTextElement(PasswordEmptyErrorMessage);
    }
    public String getEmailAddressInvalidErrorMessage(){
        return getTextElement(EmailAddressInvalidErrorMessage);
    }
    public String emailPasswordIncorrectErrorMessage(){
        return getTextElement(emailPasswordIncorrectErrorMessage);
    }
    public String passwordINValidErrorMessage(){
        return getTextElement(passwordINValidErrorMessage);
    }
}
