package Project.Newsfeed.AccountSetting;

import Interfaces.hahalolo_newsfeed.AccountSetting.AccountSettingUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class AccountCommon extends HeaderPage {
<<<<<<< HEAD
    WebDriver driver;
    public void clickToItemOnAccountNavigatioNMenu(String tabAccountSetting){
        waitElementToVisible(driver, AccountSettingUI.MENU_ACCOUNT_SETTING);
=======

    public String getTitleOfTab(WebDriver driver, String tabName) {
        waitElementToVisible(driver, AccountSettingUI.ACCOUNT_SETTING_PAGE);
        waitElementToVisible(driver, AccountSettingUI.ACCOUNT_SETTING_MENU);
        return getTextElement(driver, AccountSettingUI.TITLE_PAGE, tabName);
    }

    public void clickToItemOnAccountSettingMenu(WebDriver driver, String itemMenu){
        waitElementToVisible(driver, AccountSettingUI.ACCOUNT_SETTING_MENU);
        waitForElementClickable(driver, AccountSettingUI.ITEM_ON_MENU_ACCOUNT_SETTING, itemMenu);
        clickToElement(driver, AccountSettingUI.ITEM_ON_MENU_ACCOUNT_SETTING, itemMenu);
>>>>>>> adc713830de5a294a6c41b775a3c72c6900baef4
    }
}
