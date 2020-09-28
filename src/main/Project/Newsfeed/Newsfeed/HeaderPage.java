package Project.Newsfeed.Newsfeed;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_business.Business.BusinessVerificationUI;
import Interfaces.hahalolo_business.Tour.TourDashboardPageUI;
import Interfaces.hahalolo_newsfeed.Header.HeaderPageUI;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends AbstractPage {
    WebDriver driver;
    public void clickToItemOnSettingMenu(WebDriver driver, String nameItem){
        waitForElementClickable(driver, HeaderPageUI.SETTING_ICON);
        clickToElement(driver,HeaderPageUI.SETTING_ICON);
        setTimeDelay(1);
        waitForElementClickable(driver, HeaderPageUI.SETTING_ITEM, nameItem);
        clickToElement(driver, HeaderPageUI.SETTING_ITEM,nameItem);
        setTimeDelay(1);
    }

    public void clickItemOnBusinessNavMenu(WebDriver driver, String businessItem) {
        waitForPageLoading(driver);
        waitElementToVisible(driver, BusinessVerificationUI.BUSINESS_NAVBAR_INFO);
        clickToElement(driver, HeaderPageUI.BUSINESS_NAVBAR_MENU , businessItem);
    }

    public void clickItemOnTourNavMenu(WebDriver driver, String itemMenu) {
        clickToElementByJS(driver, TourDashboardPageUI.ITEM_ON_TOUR_BUSINESS,itemMenu);
    }

    public void clickToAvatarOnHeader(WebDriver driver) {
        waitForElementClickable(driver, HeaderPageUI.USER_AVATAR);
        clickToElement(driver, HeaderPageUI.USER_AVATAR);
    }


    public void clickToHahaloloLogo(){
        waitForElementClickable(driver, HeaderPageUI.LOGO_HALO);
        clickToElement(driver, HeaderPageUI.LOGO_HALO);
    }

    public void clickToWalletIcon(){
        waitForElementClickable(driver, HeaderPageUI.WALLET_ICON);
        clickToElement(driver, HeaderPageUI.WALLET_ICON);
    }

    public void clickToCartIcon(){
        waitForElementClickable(driver, HeaderPageUI.CART_ICON);
        clickToElement(driver, HeaderPageUI.CART_ICON);
    }


    public void clickToCurrencyIcon() {
        waitForElementClickable(driver, HeaderPageUI.CURRENCY_ICON);
        clickToElement(driver, HeaderPageUI.CURRENCY_ICON);
    }
}
