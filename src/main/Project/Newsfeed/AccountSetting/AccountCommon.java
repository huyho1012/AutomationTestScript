package Project.Newsfeed.AccountSetting;

import Interfaces.hahalolo_newsfeed.AccountSetting.AccountGeneralSetting_PageUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class AccountCommon extends HeaderPage {

    WebDriver driver;
    public String getTitleOfTab(WebDriver driver, String tabName) {
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.ACCOUNT_SETTING_PAGE);
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.ACCOUNT_SETTING_MENU);
        return getTextElement(driver, AccountGeneralSetting_PageUI.TITLE_PAGE, tabName);
    }

    public void clickToItemOnAccountSettingMenu(WebDriver driver, String itemMenu){
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.ACCOUNT_SETTING_MENU);
        waitForElementClickable(driver, AccountGeneralSetting_PageUI.ITEM_ON_MENU_ACCOUNT_SETTING, itemMenu);
        clickToElement(driver, AccountGeneralSetting_PageUI.ITEM_ON_MENU_ACCOUNT_SETTING, itemMenu);
    }
}
