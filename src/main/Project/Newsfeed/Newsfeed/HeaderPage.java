package Project.Newsfeed.Newsfeed;

import Common.HandleFunction.AbstractPage;
import Interfaces.Business.BusinessVerificationUI;
import Interfaces.Business.Tour.TourDashboardPageUI;
import Interfaces.Newsfeed.Homepage.HeaderPageUI;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends AbstractPage {

    public void clickToItemOnSettingMenu(WebDriver driver, String nameItem){
        waitForElementClickable(driver, HeaderPageUI.SETTING_ICON);
        clickToElement(driver,HeaderPageUI.SETTING_ICON);
        setTimeDelay(1);
        waitForElementClickable(driver, HeaderPageUI.SETTING_ITEM, nameItem);
        clickToElement(driver, HeaderPageUI.SETTING_ITEM,nameItem);
    }

    public void clickItemOnBusinessNavMenu(WebDriver driver, String businessItem) {
        waitForPageLoading(driver);
        waitElementToVisible(driver, BusinessVerificationUI.BUSINESS_NAVBAR_INFO);
        clickToElement(driver, HeaderPageUI.BUSINESS_NAVBAR_MENU , businessItem);
    }

    public void clickItemOnTourNavMenu(WebDriver driver, String itemMenu) {
        clickToElementByJS(driver, TourDashboardPageUI.ITEM_ON_TOUR_BUSINESS,itemMenu);
    }
}
