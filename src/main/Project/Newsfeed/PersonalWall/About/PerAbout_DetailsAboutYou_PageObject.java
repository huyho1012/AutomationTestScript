package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.PerAbout_DetailsAboutYou_PageUI;
import org.openqa.selenium.WebDriver;

public class PerAbout_DetailsAboutYou_PageObject extends PerAbout_Common_PageObject {
    WebDriver driver;

    public PerAbout_DetailsAboutYou_PageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkDetailAboutYouIsDisplay(){
        return true;
    }

    public void clickToAddNewIntroduce(){
        waitForElementClickable(driver, PerAbout_DetailsAboutYou_PageUI.ADD_NEW_INTRODUCE);
        clickToElement(driver, PerAbout_DetailsAboutYou_PageUI.ADD_NEW_INTRODUCE);
    }

    public void clickTOEditIntroduce(){
        waitForElementClickable(driver, PerAbout_DetailsAboutYou_PageUI.EDIT_INTRODUCE);
        clickToElement(driver, PerAbout_DetailsAboutYou_PageUI.EDIT_INTRODUCE);
    }

    public void enterDataToIntroduceField(String introduceData){
        waitElementToVisible(driver, PerAbout_DetailsAboutYou_PageUI.INTRODUCE_INFO_FIELD);
        sendKeyToElement(driver, PerAbout_DetailsAboutYou_PageUI.INTRODUCE_INFO_FIELD,introduceData);
    }

    public void clickToSaveIntroduceInfo(){
        waitForElementClickable(driver, PerAbout_DetailsAboutYou_PageUI.BUTTON_SAVE_INTRODUCE);
        clickToElement(driver, PerAbout_DetailsAboutYou_PageUI.BUTTON_SAVE_INTRODUCE);
    }

    public void clickToCancelSaveIntroduceInfo(){
        waitForElementClickable(driver, PerAbout_DetailsAboutYou_PageUI.BUTTON_CANCEL_SAVE_INTRODUCE);
        clickToElement(driver, PerAbout_DetailsAboutYou_PageUI.BUTTON_CANCEL_SAVE_INTRODUCE);
    }

    public String getIntroduceDataDisplay(){
        return getTextElement(driver, PerAbout_DetailsAboutYou_PageUI.INTRODUCE_DATA);
    }

    public String getErrMessOfIntroduceInfo(){
        return getTextElement(driver, PerAbout_DetailsAboutYou_PageUI.ERROR_MESS_OF_INTRODUCE);
    }


    // Chức năng cập nhật Favorite quote
    public void clickToAddFavoriteQuote(){
        waitForElementClickable(driver, PerAbout_DetailsAboutYou_PageUI.BUTTON_ADD_NEW_FAVORITE_QUOTE);
        clickToElement(driver, PerAbout_DetailsAboutYou_PageUI.BUTTON_ADD_NEW_FAVORITE_QUOTE);
    }

    public void clickToButtonEditFavoriteQuote(){
        waitForElementClickable(driver, PerAbout_DetailsAboutYou_PageUI.ICON_EDIT_FAVORITE_QUOTE);
        clickToElement(driver, PerAbout_DetailsAboutYou_PageUI.ICON_EDIT_FAVORITE_QUOTE);
    }

    public void enterDataToFavoriteQuoteField(String favoriteQuote){
        waitElementToVisible(driver, PerAbout_DetailsAboutYou_PageUI.FAVORITE_QUOTE_FIELD);
        sendKeyToElement(driver, PerAbout_DetailsAboutYou_PageUI.FAVORITE_QUOTE_FIELD,favoriteQuote);
    }

    public void clickToSaveFavoriteQuote(){
        waitForElementClickable(driver, PerAbout_DetailsAboutYou_PageUI.BUTTON_SAVE_FAVORITE_QUOTE);
        clickToElement(driver, PerAbout_DetailsAboutYou_PageUI.BUTTON_SAVE_FAVORITE_QUOTE);
    }

    public void clickToCancelSaveFavoriteQuote(){
        waitForElementClickable(driver, PerAbout_DetailsAboutYou_PageUI.BUTTON_CANCEL_SAVE_FAVORITE_QUOTE);
        clickToElement(driver, PerAbout_DetailsAboutYou_PageUI.BUTTON_CANCEL_SAVE_FAVORITE_QUOTE);
    }

    public String getFavoriteQuoteDataDisplay(){
        return getTextElement(driver, PerAbout_DetailsAboutYou_PageUI.FAVORITE_QUOTE_DATA);
    }

    public String getErrMessOfFavoriteQuoteField(){
        return getTextElement(driver, PerAbout_DetailsAboutYou_PageUI.ERROR_MESS_OF_FAVORITE_QUOTE);
    }

    // Chức năng cập nhật OtherName
    public void clickToAddNewOtherName(){
        waitForElementClickable(driver, PerAbout_DetailsAboutYou_PageUI.ADD_NEW_OTHER_NAME);
        clickToElement(driver, PerAbout_DetailsAboutYou_PageUI.ADD_NEW_OTHER_NAME);
    }

    public void clickTOEditOtherName(){
        waitForElementClickable(driver, PerAbout_DetailsAboutYou_PageUI.EDIT_OTHER_NAME);
        clickToElement(driver, PerAbout_DetailsAboutYou_PageUI.EDIT_OTHER_NAME);
    }

    public void enterDataToOtherNameField(String otherName){
        waitElementToVisible(driver, PerAbout_DetailsAboutYou_PageUI.OTHER_NAME_FIELD);
        sendKeyToElement(driver, PerAbout_DetailsAboutYou_PageUI.OTHER_NAME_FIELD,otherName);
    }

    public void clickToSaveOtherName(){
        waitForElementClickable(driver, PerAbout_DetailsAboutYou_PageUI.BUTTON_SAVE_OTHER_NAME);
        clickToElement(driver, PerAbout_DetailsAboutYou_PageUI.BUTTON_SAVE_OTHER_NAME);
    }

    public void clickToCancelSaveOtherName(){
        waitForElementClickable(driver, PerAbout_DetailsAboutYou_PageUI.BUTTON_CANCEL_SAVE_OTHER_NAME);
        clickToElement(driver, PerAbout_DetailsAboutYou_PageUI.BUTTON_CANCEL_SAVE_OTHER_NAME);
    }

    public String getOtherNameDataDisplay(){
        return getTextElement(driver, PerAbout_DetailsAboutYou_PageUI.OTHER_NAME_DATA);
    }

    public String getErrMessOfOtherNameField(){
        return getTextElement(driver, PerAbout_DetailsAboutYou_PageUI.ERROR_MESS_OF_OTHER_NAME);
    }


    public void clickToButtonAddNewIntroduce() {
    }
}
