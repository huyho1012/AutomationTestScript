package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.TourInfoUI;
import Interfaces.Shared.MediaManagementUI;
import Project.Business.Tour.Management.TourCommon;
import Project.Shared.MediaManagement_PageObject;
import org.openqa.selenium.WebDriver;

public class TourInfoTab extends TourCommon {
    WebDriver driver;
    MediaManagement_PageObject media;
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
        clickToElementByJS(driver, TourInfoUI.UPLOAD_BUTTON, "uploadLogo");
        waitElementToVisible(driver,MediaManagementUI.MEDIA_MANAGEMENT_POPUP);
        media = new MediaManagement_PageObject(driver);
        media.uploadImageFromLocalToMedia(driver, fileImage);
        waitElementToVisible(driver, MediaManagementUI.PROCESSING_BAR);
        waitForElementClickable(driver,MediaManagementUI.SELECT_BUTTON);
        clickToElement(driver, MediaManagementUI.SELECT_BUTTON);
        setTimeDelay(1);
    }
    public void updateCover(WebDriver driver, String fileName) {
        clickToElementByJS(driver, TourInfoUI.UPLOAD_BUTTON, "uploadCover");
        waitElementToVisible(driver,MediaManagementUI.MEDIA_MANAGEMENT_POPUP);
        media = new MediaManagement_PageObject(driver);
        media.uploadImageFromLocalToMedia(driver,fileName);
        waitElementToVisible(driver, MediaManagementUI.PROCESSING_BAR);
        waitForElementClickable(driver,MediaManagementUI.SELECT_BUTTON);
        clickToElement(driver, MediaManagementUI.SELECT_BUTTON);
        setTimeDelay(1);
    }
    public void updateTourGallery(WebDriver driver, String... fileImage) {
        clickToElementByJS(driver, TourInfoUI.UPLOAD_BUTTON, "uploadGalleries");
        waitElementToVisible(driver,MediaManagementUI.MEDIA_MANAGEMENT_POPUP);
        media = new MediaManagement_PageObject(driver);
        media.uploadImageFromLocalToMedia(driver,fileImage);
        waitElementToVisible(driver, MediaManagementUI.PROCESSING_BAR);
        waitForElementClickable(driver,MediaManagementUI.SELECT_BUTTON);
        clickToElement(driver, MediaManagementUI.SELECT_BUTTON);
        setTimeDelay(1);
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
        return checkElementIsDisplayed(driver, TourInfoUI.TAB_INFORMATION);
    }

    public void chooseLanguage(WebDriver driver, String languageName) {
        waitElementToVisible(driver, TourInfoUI.TAB_INFORMATION);
        selectItemInCustomDropdownByScroll(driver, TourInfoUI.LANGUAGE_DROPDOWN, TourInfoUI.LANGUAGE_ITEM, languageName);
        setTimeDelay(1);
    }

    public void choooseCurrency(WebDriver driver, String currencyCode) {
        waitElementToVisible(driver, TourInfoUI.TAB_INFORMATION);
        selectItemInCustomDropdownByScroll(driver, TourInfoUI.CURRENCY_DROPDOWN, TourInfoUI.CURRENCY_ITEM, currencyCode);
        setTimeDelay(1);
    }
}
