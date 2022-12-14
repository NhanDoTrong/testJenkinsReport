package actions.pageFactory.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends cores.common.BasePage_Factory_Teacher {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(how = How.XPATH,using = "Xpath=//div[@class='footer']//a[@title='My Account']")
    WebElement myAccountLink;
    public void clickToMyAccountLink() {
        clickToElement(driver,myAccountLink);
    }
}