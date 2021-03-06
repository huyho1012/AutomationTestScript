package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.PersonalAbout_PlacesYouLived_PageUI;
import Interfaces.hahalolo_newsfeed.PersonaWall.Personal_Common_PageUI;
import org.openqa.selenium.WebDriver;

public class PerAbout_PlacesYouLived_PageObject extends PerAbout_Common_PageObject {
    WebDriver driver;
    public PerAbout_PlacesYouLived_PageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPerAboutPlacesYouLivedIsDisplay(){
        return getTextElement(driver, Personal_Common_PageUI.TITLE_TAB_OF_ABOUT,"about_location").equalsIgnoreCase("Thành phố đang sống và quê quán")
            && getAttributeValue(driver, Personal_Common_PageUI.ABOUT_ITEM_MENU,"class","about_location").endsWith("active");
    }

    public boolean checkDisplayOfPerAboutWithCaseCreateNewAccount(){
        return checkPerAboutPlacesYouLivedIsDisplay()
                && checkElementIsDisplayed(driver, PersonalAbout_PlacesYouLived_PageUI.ADD_NEW_CURRENT_CITY)
                 && checkElementIsDisplayed(driver, PersonalAbout_PlacesYouLived_PageUI.ADD_NEW_HOMETOWN);
    }

    public boolean checkPerAboutPlacesYouLivedDisplayWithcaseNoHometown(){
        return checkPerAboutPlacesYouLivedIsDisplay() && checkElementIsDisplayed(driver, PersonalAbout_PlacesYouLived_PageUI.ADD_NEW_HOMETOWN);
    }

    public boolean checkPerAboutPlacesYouLivedDisplayWithcaseHaveHometown(){
        return checkPerAboutPlacesYouLivedIsDisplay() && checkElementIsDisplayed(driver, PersonalAbout_PlacesYouLived_PageUI.HOME_TOWN_DATA);
    }



    public void clickToAddNewCurrentLiving(){
        waitForElementClickable(driver, PersonalAbout_PlacesYouLived_PageUI.ADD_NEW_CURRENT_CITY);
        clickToElement(driver, PersonalAbout_PlacesYouLived_PageUI.ADD_NEW_CURRENT_CITY);
    }

    public void enterDataToCurrentLivingField(String currentLiving){
        waitElementToVisible(driver, PersonalAbout_PlacesYouLived_PageUI.CURRENT_CITY_FIELD);
        sendKeyToElement(driver, PersonalAbout_PlacesYouLived_PageUI.CURRENT_CITY_FIELD,currentLiving);
    }

    public void clickToSaveCurrentLiving(){
        waitForElementClickable(driver, PersonalAbout_PlacesYouLived_PageUI.BUTTON_SAVE_CURRENT_CITY);
        clickToElement(driver, PersonalAbout_PlacesYouLived_PageUI.BUTTON_SAVE_CURRENT_CITY);
    }

    public void clickToCancelSaveCurrentLiving(){
        waitForElementClickable(driver, PersonalAbout_PlacesYouLived_PageUI.BUTTON_CANCEL_SAVE_CURRENT_CITY);
        clickToElement(driver, PersonalAbout_PlacesYouLived_PageUI.BUTTON_CANCEL_SAVE_CURRENT_CITY);
    }

    public void clickToAddNewHomeTown(){
        waitForElementClickable(driver, PersonalAbout_PlacesYouLived_PageUI.ADD_NEW_HOMETOWN);
        clickToElement(driver, PersonalAbout_PlacesYouLived_PageUI.ADD_NEW_HOMETOWN);
    }

    public void enterDataToHomeTownField(String homeTown){
        waitElementToVisible(driver, PersonalAbout_PlacesYouLived_PageUI.HOMETOWN_FIELD);
        sendKeyToElement(driver, PersonalAbout_PlacesYouLived_PageUI.HOMETOWN_FIELD,homeTown);
    }

    public void clickToSaveHomeTown(){
        waitForElementClickable(driver, PersonalAbout_PlacesYouLived_PageUI.BUTTON_SAVE_HOMETOWN);
        clickToElement(driver, PersonalAbout_PlacesYouLived_PageUI.BUTTON_SAVE_HOMETOWN);
    }

    public void clickToCancelSaveHomeTown(){
        waitForElementClickable(driver, PersonalAbout_PlacesYouLived_PageUI.BUTTON_CANCEL_SAVE_HOMETOWN);
        clickToElement(driver, PersonalAbout_PlacesYouLived_PageUI.BUTTON_CANCEL_SAVE_HOMETOWN);
    }

}
