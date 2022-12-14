package actions.pageObject.jQuery;

import interfaces.pageUIs.jQuery.HomePageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageObject extends cores.common.BasePage_Executor {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToTextboxByHeaderName(String headerName, String valueInput) {
    sendKeyToElement(driver,castRestParameter(HomePageUI.HEADER_TEXTBOX_BY_HEADER_NAME,headerName),valueInput);
    sendKeyboardToElement(driver,HomePageUI.HEADER_TEXTBOX_BY_HEADER_NAME,headerName, Keys.ENTER);

    }

    public boolean isFileNameLoadedSuccess(String filename) {
        return isControlDisplayed(driver,HomePageUI.IMAGE_FILE_NAME_LOADED,filename);
    }

    public void clickToStartButton() {
        List<WebElement> startButtonElements = getListElements(driver,HomePageUI.START_BUTTON);
        for (WebElement startButton :startButtonElements
             ) {
            waitForElementClickable(driver,startButton);
            startButton.click();
        }
    }

    public boolean isFileNameupLoadedSuccess(String fileName) {
        return isControlDisplayed(driver,HomePageUI.IMAGE_FILE_NAME_UPLOADED,fileName);

    }
}
