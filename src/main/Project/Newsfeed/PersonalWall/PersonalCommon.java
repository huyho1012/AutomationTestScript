package Project.Newsfeed.PersonalWall;

import Interfaces.hahalolo_newsfeed.PersonaWall.PersonalCommonUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class PersonalCommon extends HeaderPage {
    WebDriver driver;
    public void clickToUploadAvatarByLocalImage(WebDriver driver, String imageLink){
        waitForElementClickable(driver, PersonalCommonUI.BUTTON_UPLOAD_AVATAR);
        clickToElement(driver, PersonalCommonUI.BUTTON_UPLOAD_AVATAR);
        waitForElementClickable(driver, PersonalCommonUI.UPLOAD_AVATAR_BY_LOCAL);
        clickToElement(driver, PersonalCommonUI.UPLOAD_AVATAR_BY_LOCAL);
        uploadOneFileByAutoIT(driver,imageLink);
    }

    public void clickToUploadCoverByLocalImage(WebDriver driver, String imageLink){
        waitForElementClickable(driver, PersonalCommonUI.BUTTON_UPLOAD_COVER);
        clickToElement(driver, PersonalCommonUI.BUTTON_UPLOAD_COVER);
        waitForElementClickable(driver, PersonalCommonUI.UPLOAD_COVER_BY_LOCAL);
        clickToElement(driver, PersonalCommonUI.UPLOAD_COVER_BY_LOCAL);
        uploadOneFileByAutoIT(driver,imageLink);
    }

    public void saveChangeImage(WebDriver driver){
        waitForElementClickable(driver, PersonalCommonUI.BUTTON_SAVE_CHANGE_COVER);
        clickToElement(driver, PersonalCommonUI.BUTTON_SAVE_CHANGE_COVER);
    }

    public void crossImage(WebDriver driver){
        waitElementToVisible(driver, PersonalCommonUI.CROSS_IMAGE_POPUP);
        waitForElementClickable(driver, PersonalCommonUI.BUTTON_SAVE_CROSS_IMAGE);
        clickToElement(driver,PersonalCommonUI.BUTTON_SAVE_CROSS_IMAGE);
    }

    public String getErrMessageOfValidationFileUpload(WebDriver driver){
        waitElementToVisible(driver,PersonalCommonUI.VALIDATION_ERR_MESS);
        return  getTextElement(driver,PersonalCommonUI.VALIDATION_ERR_MESS);
    }
}

