package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.Homepage.HomePageUI;
import Interfaces.hahalolo_newsfeed.PersonaWall.About.PerAbout_PlacesYouLived_PageUI;
import Interfaces.hahalolo_newsfeed.PersonaWall.PersonalHeadCoverUI;
import Interfaces.hahalolo_newsfeed.PersonaWall.PersonalUI;
import org.openqa.selenium.WebDriver;

public class PerAbout_PlacesYouLived_PageObject extends PersonalAboutPage{
    WebDriver driver;
    public PerAbout_PlacesYouLived_PageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPerAboutPlacesYouLivedIsDisplay(){
        if(getTextElement(driver, PersonalHeadCoverUI.TITLE_TAB_OF_ABOUT,"about_location").equalsIgnoreCase("Thành phố đang sống và quê quán")
            && getAttributeValue(driver, PersonalHeadCoverUI.ABOUT_ITEM_MENU,"class","about_location").endsWith("active")){
            return true;
        }
        return false;
    }

    public boolean checkPerAboutPlacesYouLivedDisplayWithcaseHaveCurrentCity(){
        if(checkPerAboutPlacesYouLivedIsDisplay() && checkElementDisplay(driver,PerAbout_PlacesYouLived_PageUI.CURRENT_CITY_DATA)){
            return true;
        }
        return false;
    }

    public boolean checkPerAboutPlacesYouLivedDisplayWithcaseNoCurrentCity(){
        if(checkPerAboutPlacesYouLivedIsDisplay() && checkElementDisplay(driver,PerAbout_PlacesYouLived_PageUI.ADD_NEW_CURRENT_CITY)){
            return true;
        }
        return false;
    }

    public boolean checkPerAboutPlacesYouLivedDisplayWithcaseNoHometown(){
        return (checkPerAboutPlacesYouLivedIsDisplay() && checkElementDisplay(driver,PerAbout_PlacesYouLived_PageUI.ADD_NEW_HOMETOWN);
    }

    public boolean checkPerAboutPlacesYouLivedDisplayWithcaseHaveHometown(){
        if(checkPerAboutPlacesYouLivedIsDisplay() && checkElementDisplay(driver,PerAbout_PlacesYouLived_PageUI.HOME_TOWN_DATA)){
            return true;
        }
        return false;
    }


    public void clickToAddNewCurrentLiving(){
        waitForElementClickable(driver, PerAbout_PlacesYouLived_PageUI.ADD_NEW_CURRENT_CITY);
        clickToElement(driver, PerAbout_PlacesYouLived_PageUI.ADD_NEW_CURRENT_CITY);
    }

    public void enterDataToCurrentLivingField(String currentLiving){
        waitElementToVisible(driver, PerAbout_PlacesYouLived_PageUI.CURRENT_CITY_FIELD);
        sendKeyToElement(driver, PerAbout_PlacesYouLived_PageUI.CURRENT_CITY_FIELD,currentLiving);
    }

    public void clickToSaveCurrentLiving(){
        waitForElementClickable(driver, PerAbout_PlacesYouLived_PageUI.BUTTON_SAVE_CURRENT_CITY);
        clickToElement(driver, PerAbout_PlacesYouLived_PageUI.BUTTON_SAVE_CURRENT_CITY);
    }

    public void clickToCancelSaveCurrentLiving(){
        waitForElementClickable(driver, PerAbout_PlacesYouLived_PageUI.BUTTON_CANCEL_SAVE_CURRENT_CITY);
        clickToElement(driver, PerAbout_PlacesYouLived_PageUI.BUTTON_CANCEL_SAVE_CURRENT_CITY);
    }

    public void clickToAddNewHomeTown(){
        waitForElementClickable(driver, PerAbout_PlacesYouLived_PageUI.ADD_NEW_HOMETOWN);
        clickToElement(driver, PerAbout_PlacesYouLived_PageUI.ADD_NEW_HOMETOWN);
    }

    public void enterDataToHomeTownField(String homeTown){
        waitElementToVisible(driver, PerAbout_PlacesYouLived_PageUI.HOMETOWN_FIELD);
        sendKeyToElement(driver, PerAbout_PlacesYouLived_PageUI.HOMETOWN_FIELD,homeTown);
    }

    public void clickToSaveHomeTown(){
        waitForElementClickable(driver, PerAbout_PlacesYouLived_PageUI.BUTTON_SAVE_HOMETOWN);
        clickToElement(driver, PerAbout_PlacesYouLived_PageUI.BUTTON_SAVE_HOMETOWN);
    }

    public void clickToCancelSaveHomeTown(){
        waitForElementClickable(driver, PerAbout_PlacesYouLived_PageUI.BUTTON_CANCEL_SAVE_HOMETOWN);
        clickToElement(driver, PerAbout_PlacesYouLived_PageUI.BUTTON_CANCEL_SAVE_HOMETOWN);
    }

}
