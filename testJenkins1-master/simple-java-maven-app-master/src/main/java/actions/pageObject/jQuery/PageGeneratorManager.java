package actions.pageObject.jQuery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static HomePageObject openUserHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }
}
