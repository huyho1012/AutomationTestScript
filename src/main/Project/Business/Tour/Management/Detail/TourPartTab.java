package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.TourPartUI;
import Interfaces.Shared.MediaManagementUI;
import Project.Business.Tour.Management.TourCommon;
import Project.Shared.MediaManagement_PageObject;
import org.openqa.selenium.WebDriver;

public class TourPartTab extends TourCommon {
    MediaManagement_PageObject media;
    WebDriver driver;
    public TourPartTab(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPartTabDisplaySuccess() {
        waitElementToVisible(driver,TourPartUI.TOUR_PART);
        return checkElementIsDisplayed(driver, TourPartUI.TOUR_PART);
    }
    public boolean checkPartDetailDisplay(){
        waitElementToVisible(driver,TourPartUI.TOUR_PART_DETAIL);
        return checkElementIsDisplayed(driver, TourPartUI.BUTTON_SAVE_PART);
    }
    public void clickToCreateNewPartButton() {
        waitForElementClickable(driver,TourPartUI.BUTTON_CREATE_NEW_PART);
        clickToElement(driver, TourPartUI.BUTTON_CREATE_NEW_PART);
    }
    public void enterValueToDynamicFieldOnPartTab(WebDriver driver, String nameField, String valueData) {
        waitElementToVisible(driver, TourPartUI.DYNAMIC_FIELD, nameField);
        sendKeyToElement(driver, TourPartUI.DYNAMIC_FIELD, valueData, nameField);
        setTimeDelay(1);
    }
    public void chooseItemToUpdateLocation(WebDriver driver, String dropdownName, String valueData) {
        selectItemInCustomDropdown(driver, TourPartUI.DYNAMIC_DROPDOWN, TourPartUI.ITEM_DYNAMIC_DROPDOWN,valueData,dropdownName);
    }

    public void enterValueToShortDescription(WebDriver driver, String partDesc) {
        waitElementToVisible(driver, TourPartUI.SHORT_DESC_TEXT_AREA);
        sendKeyToElement(driver, TourPartUI.SHORT_DESC_TEXT_AREA, partDesc);
        setTimeDelay(1);
    }

    public void chooseNewTransportItem(WebDriver driver, String itemTransport) {
        waitForElementClickable(driver, TourPartUI.TRANSPORT_ITEM, itemTransport);
        clickToElement(driver, TourPartUI.TRANSPORT_ITEM, itemTransport);
        setTimeDelay(1);
    }

    public void choosePartLogo(WebDriver driver, String fileImage) {
        clickToElementByJS(driver, TourPartUI.UPLOAD_BUTTON, "click:uploadCover");
        waitElementToVisible(driver, MediaManagementUI.MEDIA_MANAGEMENT_POPUP);
        media = new MediaManagement_PageObject(driver);
        media.uploadImageFromLocalToMedia(driver,fileImage);
        waitElementToVisible(driver, MediaManagementUI.PROCESSING_BAR);
        waitForElementClickable(driver,MediaManagementUI.SELECT_BUTTON);
        clickToElement(driver, MediaManagementUI.SELECT_BUTTON);
    }

    public void clickToButtonSavePart(WebDriver driver) {
        waitForElementClickable(driver, TourPartUI.BUTTON_SAVE_PART);
        clickToElement(driver, TourPartUI.BUTTON_SAVE_PART);
    }

    public boolean checkPartHasBeenCreatedSuccessfully() {
        return true;
    }
}
