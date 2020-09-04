package Project.Newsfeed.UserSetting;

import Common.HandleFunction.AbstractPage;
import Interfaces.Newsfeed.AccountSetting.AccountSettingUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class GeneralAccountSetting extends HeaderPage {
    WebDriver driver;
    public GeneralAccountSetting(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkAccountSettingPageIsDisplay() {
        return getTextElement(driver,AccountSettingUI.TITLE_PAGE).contains("Thiết lập tài khoản chung");
    }

    public Object getFullNameIsDisplay() {
        return getTextElement(driver, AccountSettingUI.FULL_NAME);
    }
}