package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.DetailsAboutYou_UI;
import org.openqa.selenium.WebDriver;

public class PerAbout_DetailsAboutYou_PageObject extends PersonalAboutPage{
    WebDriver driver;

    public PerAbout_DetailsAboutYou_PageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkDetailAboutYouIsDisplay(){
        return true;
    }

    public void clickToAddNewIntroduce(){
        waitForElementClickable(driver, DetailsAboutYou_UI.ADD_NEW_INTRODUCE);
        clickToElement(driver,DetailsAboutYou_UI.ADD_NEW_INTRODUCE);
    }

    public void clickTOEditIntroduce(){
        waitForElementClickable(driver, DetailsAboutYou_UI.EDIT_INTRODUCE);
        clickToElement(driver, DetailsAboutYou_UI.EDIT_INTRODUCE);
    }

    public void enterDataToIntroduceField(String introduceData){
        waitElementToVisible(driver, DetailsAboutYou_UI.INTRODUCE_INFO_FIELD);
        sendKeyToElement(driver, DetailsAboutYou_UI.INTRODUCE_INFO_FIELD,introduceData);
    }

    public void clickToSaveIntroduceInfo(){
        waitForElementClickable(driver, DetailsAboutYou_UI.BUTTON_SAVE_INTRODUCE);
        clickToElement(driver, DetailsAboutYou_UI.BUTTON_SAVE_INTRODUCE);
    }

    public void clickToCancelSaveIntroduceInfo(){
        waitForElementClickable(driver,DetailsAboutYou_UI.BUTTON_CANCEL_SAVE_INTRODUCE);
        clickToElement(driver, DetailsAboutYou_UI.BUTTON_CANCEL_SAVE_INTRODUCE);
    }

    public String getIntroduceDataDisplay(){
        return getTextElement(driver, DetailsAboutYou_UI.INTRODUCE_DATA);
    }

    public String getErrMessOfIntroduceInfo(){
        return getTextElement(driver, DetailsAboutYou_UI.ERROR_MESS_OF_INTRODUCE);
    }


    // Chức năng cập nhật Favorite quote
    public void clickToAddFavoriteQuote(){
        waitForElementClickable(driver, DetailsAboutYou_UI.ADD_NEW_FAVORITE_QUOTE);
        clickToElement(driver,DetailsAboutYou_UI.ADD_NEW_FAVORITE_QUOTE);
    }

    public void clickToButtonEditFavoriteQuote(){
        waitForElementClickable(driver, DetailsAboutYou_UI.EDIT_FAVORITE_QUOTE);
        clickToElement(driver, DetailsAboutYou_UI.EDIT_FAVORITE_QUOTE);
    }

    public void enterDataToFavoriteQuoteField(String favoriteQuote){
        waitElementToVisible(driver, DetailsAboutYou_UI.FAVORITE_QUOTE_FIELD);
        sendKeyToElement(driver, DetailsAboutYou_UI.FAVORITE_QUOTE_FIELD,favoriteQuote);
    }

    public void clickToSaveFavoriteQuote(){
        waitForElementClickable(driver, DetailsAboutYou_UI.BUTTON_SAVE_FAVORITE_QUOTE);
        clickToElement(driver, DetailsAboutYou_UI.BUTTON_SAVE_FAVORITE_QUOTE);
    }

    public void clickToCancelSaveFavoriteQuote(){
        waitForElementClickable(driver,DetailsAboutYou_UI.BUTTON_CANCEL_SAVE_FAVORITE_QUOTE);
        clickToElement(driver, DetailsAboutYou_UI.BUTTON_CANCEL_SAVE_FAVORITE_QUOTE);
    }

    public String getFavoriteQuoteDataDisplay(){
        return getTextElement(driver, DetailsAboutYou_UI.FAVORITE_QUOTE_DATA);
    }

    public String getErrMessOfFavoriteQuoteField(){
        return getTextElement(driver, DetailsAboutYou_UI.ERROR_MESS_OF_FAVORITE_QUOTE);
    }

    // Chức năng cập nhật OtherName
    public void clickToAddNewOtherName(){
        waitForElementClickable(driver, DetailsAboutYou_UI.ADD_NEW_OTHER_NAME);
        clickToElement(driver,DetailsAboutYou_UI.ADD_NEW_OTHER_NAME);
    }

    public void clickTOEditOtherName(){
        waitForElementClickable(driver, DetailsAboutYou_UI.EDIT_OTHER_NAME);
        clickToElement(driver, DetailsAboutYou_UI.EDIT_OTHER_NAME);
    }

    public void enterDataToOtherNameField(String otherName){
        waitElementToVisible(driver, DetailsAboutYou_UI.OTHER_NAME_FIELD);
        sendKeyToElement(driver, DetailsAboutYou_UI.OTHER_NAME_FIELD,otherName);
    }

    public void clickToSaveOtherName(){
        waitForElementClickable(driver, DetailsAboutYou_UI.BUTTON_SAVE_OTHER_NAME);
        clickToElement(driver, DetailsAboutYou_UI.BUTTON_SAVE_OTHER_NAME);
    }

    public void clickToCancelSaveOtherName(){
        waitForElementClickable(driver,DetailsAboutYou_UI.BUTTON_CANCEL_SAVE_OTHER_NAME);
        clickToElement(driver, DetailsAboutYou_UI.BUTTON_CANCEL_SAVE_OTHER_NAME);
    }

    public String getOtherNameDataDisplay(){
        return getTextElement(driver, DetailsAboutYou_UI.OTHER_NAME_DATA);
    }

    public String getErrMessOfOtherNameField(){
        return getTextElement(driver, DetailsAboutYou_UI.ERROR_MESS_OF_OTHER_NAME);
    }


}
