package testcases.JqueryDataTable;

import actions.pageObject.jQuery.HomePageObject;
import actions.pageObject.jQuery.PageGeneratorManager;
import cores.common.BaseTest;
import cores.common.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_13_Data_Table_Teacher_Part_I extends BaseTest {
    WebDriver driver;

    String userUrl, adminUrl;
    HomePageObject homePageObject;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        this.adminUrl = GlobalConstants.LIVE_USER_URL;
        this.userUrl = GlobalConstants.LIVE_USER_URL;
        // Chay thang nao thi truyen thang do
        driver = getBrowserDrivers(browserName);
        homePageObject = PageGeneratorManager.openUserHomePage(driver);

    }

    @Test
    public void TC_01_()  {
        //1. Làm sao để nhập liệu vào textbox trong header
        // Paramester : Header name: Cột nào để enter vào
        // Parameter: Value để nhập textbox vào
        homePageObject.enterToTextboxByHeaderName( "Country","Angola");
        homePageObject.refreshPage(driver);
        homePageObject.enterToTextboxByHeaderName( "Males","56746000");
        // Click vao icon cua 1 nuoc nao do


    }

    @Test
    public void TC_07_SideBar_Page() {
    }

    @Test
    public void TC_08_Footer_Page() {

    }

    @Test
    public void TC_09_Role() {
    }


    @AfterClass
    public void afterClass() {
//        driver.quit();
    }


}

