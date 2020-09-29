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

    public boolean checkCoverImageDisplayWithCaseNoImage(WebDriver driver) {
        waitElementToVisible(driver, PersonalCommonUI.COVER_IMAGE);
        String imageLink = getImageOfCover(driver);
        return imageLink.equals("cover-default.jpg");
    }

    public boolean checkUploadAvatarUserSuccess(WebDriver driver, String avatarBeforeChange) {
        System.out.println(getDateTimeNow());
        waitForElementInvisible(driver, PersonalCommonUI.ICON_LOADING_IMAGE);
        System.out.println(getDateTimeNow());
        String avatarAfterChange = getImageURLOfAvatar(driver);
        System.out.println(avatarAfterChange);
        return avatarBeforeChange.contains(avatarAfterChange);
    }

    public boolean checkCoverImageUploadSuccessfully(WebDriver driver,String coverBeforeChange) {
        waitElementToVisible(driver, PersonalCommonUI.ICON_LOADING_IMAGE);
        String avatarAfterChange = getImageOfCover(driver);
        return avatarAfterChange.contains(coverBeforeChange);
    }

    public boolean checkAvatarUserDisplayWithGenderType(WebDriver driver, String genderType){
        System.out.println(genderType);
        String imageLink = getImageURLOfAvatar(driver);
        System.out.println(imageLink);
        if(genderType.contains("Nam")){
            if(imageLink.contains("avatar-male-256px.png")){
                System.out.println("This image is male png");
                return true;
            } else {
                System.out.println("This image is not a male png");
                return false;
            }

        } else if(genderType.contains("Nữ")){
            if(imageLink.contains("avatar-user-256px.png")){
                System.out.println("This image is female png");
                return true;
            }
            else {
                System.out.println("This image is not a female png");
                return false;
            }
        } else if(genderType.contains("Khác")){
            if(imageLink.contains("avatar-user")){
                System.out.println("This image is a other png");
                return true;
            }
            else {
                System.out.println("This image is not a other png");
                return false;
            }
        }
        return false;
    }

    public String getImageURLOfAvatar(WebDriver driver) {
        String imageURL = getCSSValueOfElement(driver, PersonalCommonUI.AVATAR_IMAGE,"background-image");
        String[] imageLink = imageURL.split("/");
        String imagePath = imageLink[imageLink.length-1];
        return imagePath.replaceAll("[^\\w\\.\\-]", "");
    }

    public String getImageOfCover(WebDriver driver) {
        String imageURL = getAttributeValue(driver,PersonalCommonUI.COVER_IMAGE,"src");
        String[] imageLink = imageURL.split("/");
        String imagePath = imageLink[imageLink.length-1];
        return imagePath.replaceAll("[^\\w\\.\\-]", "");
    }


}

