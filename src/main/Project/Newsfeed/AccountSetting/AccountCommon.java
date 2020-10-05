package Project.Newsfeed.AccountSetting;

import Interfaces.hahalolo_newsfeed.AccountSetting.Newsfeed_Account_GeneralSetting_PageUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class AccountCommon extends HeaderPage {

    WebDriver driver;
    public String getTitleOfTab(WebDriver driver, String tabName) {
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.ACCOUNT_SETTING_PAGE);
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.ACCOUNT_SETTING_MENU);
        return getTextElement(driver, Newsfeed_Account_GeneralSetting_PageUI.TITLE_PAGE, tabName);
    }

    public void clickToItemOnAccountSettingMenu(WebDriver driver, String itemMenu){
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.ACCOUNT_SETTING_MENU);
        waitForElementClickable(driver, Newsfeed_Account_GeneralSetting_PageUI.ITEM_ON_MENU_ACCOUNT_SETTING, itemMenu);
        clickToElement(driver, Newsfeed_Account_GeneralSetting_PageUI.ITEM_ON_MENU_ACCOUNT_SETTING, itemMenu);
    }
}
