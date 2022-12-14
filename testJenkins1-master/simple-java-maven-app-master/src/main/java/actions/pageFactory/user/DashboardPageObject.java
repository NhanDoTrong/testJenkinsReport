package actions.pageFactory.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageObject extends cores.common.BasePage_Factory_Teacher{
    WebDriver driver;
    public DashboardPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(how = How.XPATH,using = "xpath=//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p[contains(.,'Automation FC')]")
    WebElement ContactInformationByUserName;
    @FindBy(how = How.XPATH,using = "xpath=//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p[contains(.,'automationfc.vn@gmail.com')]")
    WebElement ContactInformationByEmail;
    public WebElement getContactInformationByUserName(){
        return waitForElementVisible(driver, ContactInformationByUserName);
    }
    public WebElement getContactInformationByEmail(){
        return waitForElementVisible(driver, ContactInformationByEmail);
    }
}