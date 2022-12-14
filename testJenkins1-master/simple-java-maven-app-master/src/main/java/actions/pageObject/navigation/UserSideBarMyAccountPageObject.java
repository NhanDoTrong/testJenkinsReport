package actions.pageObject.navigation;

import interfaces.pageUIs.User.SideBarMyAccountPageUI;
import org.openqa.selenium.WebDriver;

public class UserSideBarMyAccountPageObject extends cores.common.BasePage_Executor{
    WebDriver driver;

    public UserSideBarMyAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }
    // Không return về Page nào hết
    public void openSideBarLinkByPageName(String pageName){
        clickToElement(driver,SideBarMyAccountPageUI.DYNAMIC_SIDE_BAR_LINK,pageName);
    }

    // Có return , Nhưng chỉ dùng cho số lượng ít Page thôi
    public UserSideBarMyAccountPageObject openSideBarLinkByPageNames(String pageName){
        clickToElement(driver,SideBarMyAccountPageUI.DYNAMIC_SIDE_BAR_LINK,pageName);
        if(pageName.equals("My Orders")){
            return PageGeneratorManager.openMyOrders(driver);
        } else if (pageName.equals("My Applications")) {
            return PageGeneratorManager.openMyApplicationsPage(driver);

        }else if (pageName.equals("My Product Reviews")) {
            return PageGeneratorManager.openMyProductReviews(driver);}
        else {
            return null;

    }



}}
