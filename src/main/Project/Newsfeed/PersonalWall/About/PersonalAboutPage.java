package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.AboutCommonUI;
import Interfaces.hahalolo_newsfeed.PersonaWall.PersonalHeadCoverUI;
import Interfaces.hahalolo_newsfeed.PersonaWall.PersonalUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class PersonalAboutPage extends HeaderPage {
    WebDriver driver;
    public PersonalAboutPage(WebDriver webDriver){
        driver = webDriver;
    }

    // Hàm xử lý các thông tin trong widget introduction

    public String getEmailIsDisplayOnIntroduceWidget(String fullname) {
        if(checkPageIsDisplay(fullname)){
            return getTextElement(driver, PersonalUI.WIDGET_INTRO_EMAIL);
        }
        return null;
    }

    public String getBirthdayDisplayOnIntroduceWidget(String fullname) {
        if(checkPageIsDisplay(fullname)){
            return getTextElement(driver, PersonalUI.WIDGET_INTRO_BIRTHDAY);
        }
        return null;
    }

    public String getGenderDisplayOnIntroduceWidget(String fullname) {
        if(checkPageIsDisplay(fullname)){
            return getTextElement(driver, PersonalUI.WIDGET_INTRO_GENDER);
        }
        return null;
    }

    public boolean checkPageIsDisplay(String fullName) {
        waitElementToVisible(driver, PersonalHeadCoverUI.PERSONAL_PAGE);
        return getPageTitle(driver).equalsIgnoreCase("Giới thiệu - Trang cá nhân | Hahalolo")
                && getTextElement(driver, PersonalHeadCoverUI.HEADER_COVER_FULLNAME).equalsIgnoreCase(fullName);
    }


    public void clickToItemOnNavTabOnAbout(String aboutItem){
        waitElementToVisible(driver, AboutCommonUI.ABOUT_NAVIGATION_MENU);
        waitForElementClickable(driver, AboutCommonUI.ITEM_ON_ABOUT_NAVIGATION_MENU,aboutItem);
        clickToElement(driver, AboutCommonUI.ITEM_ON_ABOUT_NAVIGATION_MENU);
    }

    public boolean checkTabIsSelected(String aboutItem){
        waitElementToVisible(driver, AboutCommonUI.ITEM_ON_ABOUT_NAVIGATION_MENU,aboutItem);
        return getAttributeValue(driver, AboutCommonUI.ITEM_ON_ABOUT_NAVIGATION_MENU,"class",aboutItem).contains("active");
    }

    public void clickToAddWorkplace(){
        waitForElementClickable(driver, AboutCommonUI.BUTTON_ADD_WORK_SPACE);
        clickToElement(driver, AboutCommonUI.BUTTON_ADD_WORK_SPACE);
    }

    public void clickToAddEducation(){
        waitForElementClickable(driver, AboutCommonUI.BUTTON_ADD_EDUCATION);
        clickToElement(driver, AboutCommonUI.BUTTON_ADD_EDUCATION);
    }

    public void clickToAddLivingPlace(){
        waitForElementClickable(driver, AboutCommonUI.BUTTON_ADD_LIVING_PLACE);
        clickToElement(driver, AboutCommonUI.BUTTON_ADD_LIVING_PLACE);
    }

    public void clickToEditBasicInfoAndContact(){
        waitForElementClickable(driver, AboutCommonUI.BUTTON_EDIT_BASIC_INFO_AND_CONTACT);
        clickToElement(driver, AboutCommonUI.BUTTON_EDIT_BASIC_INFO_AND_CONTACT);
    }

  public void clickToEditWorkplace(){
      waitForElementClickable(driver, AboutCommonUI.BUTTON_EDIT_WORKPLACE);
      clickToElement(driver, AboutCommonUI.BUTTON_EDIT_WORKPLACE);
  }

    public void clickToEditEducation(){
        waitForElementClickable(driver, AboutCommonUI.BUTTON_EDIT_EDUCATION);
        clickToElement(driver, AboutCommonUI.BUTTON_EDIT_EDUCATION);
    }

    public void clickToEditPlaceLiving(){
        waitForElementClickable(driver, AboutCommonUI.BUTTON_EDIT_PLACE_LIVING);
        clickToElement(driver, AboutCommonUI.BUTTON_EDIT_PLACE_LIVING);
    }
}
