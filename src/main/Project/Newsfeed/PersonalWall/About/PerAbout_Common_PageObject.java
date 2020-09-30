package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.Per_Common_PageUI;
import Project.Newsfeed.PersonalWall.PersonalCommon;
import org.openqa.selenium.WebDriver;

public class PerAbout_Common_PageObject extends PersonalCommon {
    WebDriver driver;

    public boolean checkPersonalPageIsDisplay(WebDriver driver, String fullName) {
        waitElementToVisible(driver, Per_Common_PageUI.PERSONAL_PAGE);
        return getPageTitle(driver).equalsIgnoreCase("Giới thiệu - Trang cá nhân | Hahalolo")
                && getTextElement(driver, Per_Common_PageUI.FULLNAME_ON_COVER).equalsIgnoreCase(fullName);
    }

    public void clickToTabItemOnAbout(WebDriver driver, String aboutItem){
        waitElementToVisible(driver, Per_Common_PageUI.ABOUT_MENU);
        waitForElementClickable(driver, Per_Common_PageUI.ABOUT_ITEM_MENU,aboutItem);
        clickToElement(driver, Per_Common_PageUI.ABOUT_ITEM_MENU,aboutItem);
    }

    public boolean checkTabIsSelected(WebDriver driver, String aboutItem){
        waitElementToVisible(driver, Per_Common_PageUI.ABOUT_ITEM_MENU,aboutItem);
        System.out.println("Da vao dayperAboutWorkEducationTab");
        return getAttributeValue(driver, Per_Common_PageUI.ABOUT_ITEM_MENU,"class",aboutItem).contains("active");
    }


}
