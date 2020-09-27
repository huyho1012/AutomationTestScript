package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.PersonalHeadCoverUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class PerAbout_Common_PageObject extends HeaderPage {
    WebDriver driver;

    // Hàm xử lý các thông tin trong widget introduction
    public boolean checkPersonalPageIsDisplay(String fullName) {
        waitElementToVisible(driver, PersonalHeadCoverUI.PERSONAL_PAGE);
        return getPageTitle(driver).equalsIgnoreCase("Giới thiệu - Trang cá nhân | Hahalolo")
                && getTextElement(driver, PersonalHeadCoverUI.HEADER_COVER_FULLNAME).equalsIgnoreCase(fullName);
    }

    public void clickToTabItemOnAbout(String aboutItem){
        waitElementToVisible(driver,PersonalHeadCoverUI.ABOUT_MENU);
        waitForElementClickable(driver, PersonalHeadCoverUI.ABOUT_ITEM_MENU,aboutItem);
        clickToElement(driver, PersonalHeadCoverUI.ABOUT_ITEM_MENU,aboutItem);
    }

    public boolean checkTabIsSelected(String aboutItem){
        waitElementToVisible(driver, PersonalHeadCoverUI.ABOUT_ITEM_MENU,aboutItem);
        return getAttributeValue(driver, PersonalHeadCoverUI.ABOUT_ITEM_MENU,"class",aboutItem).contains("active");
    }


}
