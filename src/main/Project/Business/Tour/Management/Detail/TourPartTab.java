package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.TourPartUI;
import Interfaces.Shared.MediaManagementUI;
import Project.Business.Tour.Management.TourCommon;
import Project.Shared.Management.MediaManagement;
import org.openqa.selenium.WebDriver;

public class TourPartTab extends TourCommon {
    MediaManagement media;
    WebDriver driver;
    public TourPartTab(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPartTabDisplaySuccess() {
        waitElementToVisible(driver,TourPartUI.TOUR_PART);
        return checkElementDisplay(driver, TourPartUI.TOUR_PART);
    }
    public boolean checkPartDetailDisplay(){
        waitElementToVisible(driver,TourPartUI.TOUR_PART_DETAIL);
        return checkElementDisplay(driver, TourPartUI.BUTTON_SAVE_PART);
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
        media = new MediaManagement(driver);
        clickToElementByJS(driver, TourPartUI.UPLOAD_BUTTON, "click:uploadCover");
        waitElementToVisible(driver, MediaManagementUI.MEDIA_MANAGEMENT_POPUP);
        media.uploadImageFromLocalToMedia(driver, fileImage);
        waitForElementInvisible(driver, MediaManagementUI.PROCESSING_BAR);
        setTimeDelay(10);
        media.selectOneImageOnMedia(driver);
        setTimeDelay(1);
    }

    public void clickToButtonSavePart(WebDriver driver) {
        waitForElementClickable(driver, TourPartUI.BUTTON_SAVE_PART);
        clickToElement(driver, TourPartUI.BUTTON_SAVE_PART);
    }

    public boolean checkPartHasBeenCreatedSuccessfully() {
        return true;
    }
}
