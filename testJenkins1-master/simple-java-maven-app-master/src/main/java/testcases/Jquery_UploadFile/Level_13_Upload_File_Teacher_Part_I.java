package testcases.Jquery_UploadFile;

import actions.pageObject.jQuery.HomePageObject;
import actions.pageObject.jQuery.PageGeneratorManager;
import cores.common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Level_13_Upload_File_Teacher_Part_I extends BaseTest {
    WebDriver driver;
    HomePageObject homePageObject;
    String seleniumImage_1 = "Selenium_1.jpg";
    String seleniumImage_2 = "Selenium_2.png";
    String seleniumImage_3 = "Selenium_3.jpg";
    String seleniumImage_4 = "Selenium_4.png";
    String seleniumImage_5 = "Selenium_5.jpg";

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        // Chay thang nao thi truyen thang do
        driver = getBrowserDriver(browserName, url);
        homePageObject = PageGeneratorManager.openUserHomePage(driver);

    }

    @Test
    public void TC_01_One_File(){
        homePageObject.refreshPage(driver);
        homePageObject.uploadMultipleFile(driver, seleniumImage_2);
        assertTrue(homePageObject.isFileNameLoadedSuccess(seleniumImage_2));
        homePageObject.clickToStartButton();
        assertTrue(homePageObject.isFileNameupLoadedSuccess(seleniumImage_2));
    }

    @Test
    public void TC_02_Multiple_File() {
        homePageObject.refreshPage(driver);
        homePageObject.uploadMultipleFile(driver, seleniumImage_2,seleniumImage_3,seleniumImage_4,seleniumImage_5);
        assertTrue(homePageObject.isFileNameLoadedSuccess(seleniumImage_3));
        assertTrue(homePageObject.isFileNameLoadedSuccess(seleniumImage_4));
        assertTrue(homePageObject.isFileNameLoadedSuccess(seleniumImage_5));
        assertTrue(homePageObject.isFileNameLoadedSuccess(seleniumImage_2));
        homePageObject.clickToStartButton();
        assertTrue(homePageObject.isFileNameupLoadedSuccess(seleniumImage_2));
        assertTrue(homePageObject.isFileNameupLoadedSuccess(seleniumImage_3));
        assertTrue(homePageObject.isFileNameupLoadedSuccess(seleniumImage_4));
        assertTrue(homePageObject.isFileNameupLoadedSuccess(seleniumImage_5));
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}

