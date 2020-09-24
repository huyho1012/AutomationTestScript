package Project.Newsfeed.AccountSetting;

import Interfaces.hahalolo_newsfeed.AccountSetting.AccountSettingUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class AccountCommon extends HeaderPage {
    WebDriver driver;
    public void clickToItemOnAccountNavigatioNMenu(String tabAccountSetting){
        waitElementToVisible(driver, AccountSettingUI.MENU_ACCOUNT_SETTING);
    }
}
