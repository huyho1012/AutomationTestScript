package Project.Newsfeed.Newsfeed;

import Common.HandleFunction.AbstractPage;
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
}
