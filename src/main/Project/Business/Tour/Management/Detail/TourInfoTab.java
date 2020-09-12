package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.TourInfoUI;
import Interfaces.Shared.MediaManagementUI;
import Project.Business.Tour.Management.TourCommon;
import Project.Shared.Management.MediaManagement;
import org.openqa.selenium.WebDriver;

public class TourInfoTab extends TourCommon {
    WebDriver driver;
    MediaManagement media;
    public TourInfoTab(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterValueOfShortDesc(WebDriver driver, String shortDesc) {
        waitElementToVisible(driver, TourInfoUI.SHORT_DESC_TEXT_AREA);
        sendKeyToElement(driver, TourInfoUI.SHORT_DESC_TEXT_AREA, shortDesc);
    }

    public void enterValueOfTourToDynamicSummerNoteOnInformationTab(WebDriver driver, String nameTextarea, String valueData) {
        waitElementToVisible(driver, TourInfoUI.DYNAMIC_TEXT_AREA,nameTextarea);
        sendKeyToElement(driver, TourInfoUI.DYNAMIC_TEXT_AREA, valueData,nameTextarea);
    }

    public void updateLogo(WebDriver driver, String fileImage) {
        media = new MediaManagement(driver);
        clickToElementByJS(driver, TourInfoUI.UPLOAD_BUTTON, "uploadLogo");
        waitElementToVisible(driver,MediaManagementUI.MEDIA_MANAGEMENT_POPUP);
        media.uploadImageFromLocalToMedia(driver, fileImage);
        waitForElementInvisible(driver, MediaManagementUI.PROCESSING_BAR);
        setTimeDelay(10);
        media.selectOneImageOnMedia(driver);
        setTimeDelay(1);
    }
    public void updateCover(WebDriver driver, String fileImage) {
        media = new MediaManagement(driver);
        clickToElementByJS(driver, TourInfoUI.UPLOAD_BUTTON, "uploadCover");
        waitElementToVisible(driver,MediaManagementUI.MEDIA_MANAGEMENT_POPUP);
        media.uploadImageFromLocalToMedia(driver, fileImage);
        waitForElementInvisible(driver, MediaManagementUI.PROCESSING_BAR);
        setTimeDelay(10);
        media.selectOneImageOnMedia(driver);
        setTimeDelay(1);
    }
    public void updateTourGallery(WebDriver driver, String fileImage) {
        media = new MediaManagement(driver);
        clickToElementByJS(driver, TourInfoUI.UPLOAD_BUTTON, "uploadGalleries");
        waitElementToVisible(driver,MediaManagementUI.MEDIA_MANAGEMENT_POPUP);
        media.uploadImageFromLocalToMedia(driver, fileImage);
        waitForElementInvisible(driver, MediaManagementUI.PROCESSING_BAR);
        setTimeDelay(10);
        media.selectOneImageOnMedia(driver);
        setTimeDelay(1);
    }

    public void uploadImageToMediaManagement(WebDriver driver){
        waitElementToVisible(driver, MediaManagementUI.MEDIA_MANAGEMENT_POPUP);
        waitForElementClickable(driver, MediaManagementUI.UPLOAD_BUTTON);
        clickToElement(driver, MediaManagementUI.UPLOAD_BUTTON);
        uploadMultipleFileByAutoIT(driver);
    }

    public void enterValueToDynamicField(WebDriver driver, String nameField, String valueData) {
        waitElementToVisible(driver, TourInfoUI.DYNAMIC_FIELD_TAB_INFO, nameField);
        sendKeyToElement(driver, TourInfoUI.DYNAMIC_FIELD_TAB_INFO, valueData, nameField);
    }
    public void chooseItemToUpdateLocation(WebDriver driver, String dropdownName, String valueData) {
        clickToElement(driver,  TourInfoUI.DYNAMIC_DROPDOWN,dropdownName );
        setTimeDelay(1);
        clickToElementByJS(driver, TourInfoUI.ITEM_DYNAMIC_DROPDOWN,dropdownName, valueData);
        setTimeDelay(1);
    }

    public void clickToButtonSaveTour() {
        waitForElementClickable(driver, TourInfoUI.SAVE_TOUR_BUTTON);
        clickToElement(driver, TourInfoUI.SAVE_TOUR_BUTTON);
        setTimeDelay(2);
    }

    public boolean checkTourInfoTabDisplay() {
        return checkElementDisplay(driver, TourInfoUI.TAB_INFORMATION);
    }
}
