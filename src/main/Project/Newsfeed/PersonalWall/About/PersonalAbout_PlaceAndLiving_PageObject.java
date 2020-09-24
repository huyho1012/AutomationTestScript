package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.PlaceAndLiving_UI;
import org.openqa.selenium.WebDriver;

public class PersonalAbout_PlaceAndLiving_PageObject extends PersonalAboutPage{
    WebDriver driver;
    public PersonalAbout_PlaceAndLiving_PageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPersonalPlaceAndLivingTabIsDisplay(){
        return true;
    }

    public void clickToAddNewCurrentLiving(){
        waitForElementClickable(driver, PlaceAndLiving_UI.ADD_NEW_CURRENT_CITY);
        clickToElement(driver, PlaceAndLiving_UI.ADD_NEW_CURRENT_CITY);
    }

    public void enterDataToCurrentLivingField(String currentLiving){
        waitElementToVisible(driver, PlaceAndLiving_UI.CURRENT_CITY_FIELD);
        sendKeyToElement(driver, PlaceAndLiving_UI.CURRENT_CITY_FIELD,currentLiving);
    }

    public void clickToSaveCurrentLiving(){
        waitForElementClickable(driver, PlaceAndLiving_UI.BUTTON_SAVE_CURRENT_CITY);
        clickToElement(driver, PlaceAndLiving_UI.BUTTON_SAVE_CURRENT_CITY);
    }

    public void clickToCancelSaveCurrentLiving(){
        waitForElementClickable(driver, PlaceAndLiving_UI.BUTTON_CANCEL_SAVE_CURRENT_CITY);
        clickToElement(driver, PlaceAndLiving_UI.BUTTON_CANCEL_SAVE_CURRENT_CITY);
    }

    public void clickToAddNewHomeTown(){
        waitForElementClickable(driver, PlaceAndLiving_UI.ADD_NEW_HOMETOWN);
        clickToElement(driver, PlaceAndLiving_UI.ADD_NEW_HOMETOWN);
    }

    public void enterDataToHomeTownField(String homeTown){
        waitElementToVisible(driver, PlaceAndLiving_UI.HOME_TOWN_FIELD);
        sendKeyToElement(driver, PlaceAndLiving_UI.HOME_TOWN_FIELD,homeTown);
    }

    public void clickToSaveHomeTown(){
        waitForElementClickable(driver, PlaceAndLiving_UI.BUTTON_SAVE_HOME_TOWN);
        clickToElement(driver, PlaceAndLiving_UI.BUTTON_SAVE_HOME_TOWN);
    }

    public void clickToCancelSaveHomeTown(){
        waitForElementClickable(driver, PlaceAndLiving_UI.BUTTON_CANCEL_SAVE_HOME_TOWN);
        clickToElement(driver, PlaceAndLiving_UI.BUTTON_CANCEL_SAVE_HOME_TOWN);
    }
}
