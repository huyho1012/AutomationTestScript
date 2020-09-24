package Project.Newsfeed.AccountSetting;

import Interfaces.hahalolo_newsfeed.AccountSetting.AccountSettingUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class AccountCommon extends HeaderPage {

    public String getTitleOfTab(WebDriver driver, String tabName) {
        waitElementToVisible(driver, AccountSettingUI.ACCOUNT_SETTING_PAGE);
        waitElementToVisible(driver, AccountSettingUI.ACCOUNT_SETTING_MENU);
        return getTextElement(driver, AccountSettingUI.TITLE_PAGE, tabName);
    }

    public void clickToItemOnAccountSettingMenu(WebDriver driver, String itemMenu){
        waitElementToVisible(driver, AccountSettingUI.ACCOUNT_SETTING_MENU);
        waitForElementClickable(driver, AccountSettingUI.ITEM_ON_MENU_ACCOUNT_SETTING, itemMenu);
        clickToElement(driver, AccountSettingUI.ITEM_ON_MENU_ACCOUNT_SETTING, itemMenu);
    }

}
