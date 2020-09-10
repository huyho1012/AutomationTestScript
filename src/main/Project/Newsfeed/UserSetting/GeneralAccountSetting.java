package Project.Newsfeed.UserSetting;

import Interfaces.Newsfeed.AccountSetting.AccountSettingUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class GeneralAccountSetting extends HeaderPage {
    WebDriver driver;
    public GeneralAccountSetting(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkAccountSettingPageIsDisplay() {

        waitElementToVisible(driver, AccountSettingUI.ACCOUNT_SETTIGN_PAGE);
        return getTextElement(driver, AccountSettingUI.TITLE_PAGE, "setting_general").contains("THIẾT LẬP TÀI KHOẢN CHUNG");
    }

    public String getFullNameIsDisplay() {
        waitElementToVisible(driver, AccountSettingUI.FULL_NAME_LOADING);
        return getTextElement(driver, AccountSettingUI.FULL_NAME);
    }
}
