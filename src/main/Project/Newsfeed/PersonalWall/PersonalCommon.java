package Project.Newsfeed.PersonalWall;

import Interfaces.hahalolo_newsfeed.PersonaWall.Personal_Common_PageUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class PersonalCommon extends HeaderPage {
    WebDriver driver;
    public String getGenderNameByValue(String languageSytem, String genderType) {
        if(languageSytem == "vi"){
            if(genderType == "M"){
                return "Nam";
            }else if(genderType =="F"){
                return "Nữ";
            }else if(genderType =="N"){
                return "Khác";
            }else
                return null;
        }
        else if(languageSytem == "en") {
            if (genderType == "M") {
                return "Male";
            } else if (genderType == "F") {
                return "Female";
            } else if (genderType == "N") {
                return "Other";
            } else
                return null;
        }
        return null;
    }

    public void clickToUploadAvatarByLocalImage(String imageLink){
        waitForElementClickable(driver, Personal_Common_PageUI.UPLOAD_AVATAR_ICON);
        clickToElement(driver, Personal_Common_PageUI.UPLOAD_AVATAR_ICON);
        waitForElementClickable(driver, Personal_Common_PageUI.UPLOAD_AVATAR_FROM_LOCAL);
        clickToElement(driver, Personal_Common_PageUI.UPLOAD_AVATAR_FROM_LOCAL);
        uploadOneFileByAutoIT(driver,imageLink);
    }

    public void clickToUploadCoverByLocalImage(WebDriver driver, String imageLink){
        waitForElementClickable(driver, Personal_Common_PageUI.UPLOAD_COVER_ICON);
        clickToElement(driver, Personal_Common_PageUI.UPLOAD_COVER_ICON);
        waitForElementClickable(driver, Personal_Common_PageUI.UPLOAD_COVER_FROM_LOCAL);
        clickToElement(driver, Personal_Common_PageUI.UPLOAD_COVER_FROM_LOCAL);
        uploadOneFileByAutoIT(driver,imageLink);
    }

    public void saveChangeImage(WebDriver driver){
        waitForElementClickable(driver, Personal_Common_PageUI.BUTTON_SAVE_CHANGE_COVER);
        clickToElement(driver, Personal_Common_PageUI.BUTTON_SAVE_CHANGE_COVER);
    }

    public void crossAvatarImage(){
        waitElementToVisible(driver, Personal_Common_PageUI.CROSS_IMAGE_POPUP);
        waitForElementClickable(driver, Personal_Common_PageUI.BUTTON_SAVE_CROSS_IMAGE);
        clickToElement(driver, Personal_Common_PageUI.BUTTON_SAVE_CROSS_IMAGE);
    }

    public String getErrMessageOfValidationFileUpload(WebDriver driver){
        waitElementToVisible(driver, Personal_Common_PageUI.VALIDATION_ERR_MESS);
        return  getTextElement(driver, Personal_Common_PageUI.VALIDATION_ERR_MESS);
    }

    public boolean checkCoverImageDisplayWithCaseNoImage(WebDriver driver) {
        waitElementToVisible(driver, Personal_Common_PageUI.COVER_IMAGE);
        String imageLink = getImageOfCover(driver);
        return imageLink.equals("cover-default.jpg");
    }

    public boolean checkUploadAvatarUserSuccess(WebDriver driver, String avatarBeforeChange) {
        System.out.println(getDateTimeNow());
        waitForElementInvisible(driver, Personal_Common_PageUI.ICON_LOADING_IMAGE);
        System.out.println(getDateTimeNow());
        String avatarAfterChange = getImageURLOfAvatar(driver);
        System.out.println(avatarAfterChange);
        return avatarBeforeChange.contains(avatarAfterChange);
    }

    public boolean checkCoverImageUploadSuccessfully(WebDriver driver,String coverBeforeChange) {
        waitElementToVisible(driver, Personal_Common_PageUI.ICON_LOADING_IMAGE);
        String avatarAfterChange = getImageOfCover(driver);
        return avatarAfterChange.contains(coverBeforeChange);
    }

    public boolean checkAvatarUserDisplayWithGenderType(WebDriver driver, String genderName){
        String imageLink = getImageURLOfAvatar(driver);
        if(genderName.equalsIgnoreCase("nam")|| genderName.equalsIgnoreCase("male")){
            if(imageLink.contains("avatar-male-256px.png")){
                return true;
            } else {
                return false;
            }

        } else if(genderName.equalsIgnoreCase("nữ")||genderName.equalsIgnoreCase("female")){
            if(imageLink.contains("avatar-female-256px.png")){
                return true;
            }
            else {
                return false;
            }
        } else if(genderName.contains("Khác") || genderName.equalsIgnoreCase("other")){
            if(imageLink.contains("avatar-user-256px.png")){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public String getImageURLOfAvatar(WebDriver driver) {
        String imageURL = getCSSValueOfElement(driver, Personal_Common_PageUI.AVATAR_IMAGE,"background-image");
        String[] imageLink = imageURL.split("/");
        String imagePath = imageLink[imageLink.length-1];
        return imagePath.replaceAll("[^\\w\\.\\-]", "");
    }

    public String getImageOfCover(WebDriver driver) {
        String imageURL = getAttributeValue(driver, Personal_Common_PageUI.COVER_IMAGE,"src");
        String[] imageLink = imageURL.split("/");
        String imagePath = imageLink[imageLink.length-1];
        return imagePath.replaceAll("[^\\w\\.\\-]", "");
    }


}

