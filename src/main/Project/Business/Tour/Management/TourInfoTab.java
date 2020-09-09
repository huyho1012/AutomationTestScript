package Project.Business.Tour.Management;

import Common.HandleFunction.AbstractPage;
import Interfaces.Business.Tour.Management.TourInfoTabUI;
import Interfaces.MediaManagementUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;

public class TourInfoTab extends AbstractPage {
    WebDriver driver;
    public TourInfoTab(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterValueOfShortDesc(WebDriver driver, String shortDesc) {
        waitElementToVisible(driver, TourInfoTabUI.SHORT_DESC_TEXT_AREA);
        sendKeyToElement(driver,TourInfoTabUI.SHORT_DESC_TEXT_AREA, shortDesc);
    }

    public void enterValueOfTourToDynamicSummerNoteOnInformationTab(WebDriver driver, String nameTextarea, String valueData) {
        waitElementToVisible(driver, TourInfoTabUI.DYNAMIC_TEXT_AREA,nameTextarea);
        sendKeyToElement(driver,TourInfoTabUI.DYNAMIC_TEXT_AREA, valueData,nameTextarea);
    }

    public void chooseImageToUpdateTourInfo(WebDriver driver, String nameFunctionUpload) {
        clickToElement(driver,TourInfoTabUI.UPLOAD_COVER_BUTTON, nameFunctionUpload);
        if(nameFunctionUpload=="" || nameFunctionUpload == ""){
            chooseImageOnMediaManagement(driver,1);
        }
        else {
            chooseImageOnMediaManagement(driver,10);
        }
    }

    public void chooseImageOnMediaManagement(WebDriver driver, int number) {
        uploadImageToMediaManagement(driver);
    }

    public void uploadImageToMediaManagement(WebDriver driver){
        waitElementToVisible(driver, MediaManagementUI.MEDIA_MANAGEMENT_POPUP);
        waitForElementClickable(driver, MediaManagementUI.UPLOAD_BUTTON);
        clickToElement(driver, MediaManagementUI.UPLOAD_BUTTON);
        uploadMultipleFileByAutoIT(driver);
    }

    public void enterValueOfTourToDynamicFieldOnInformationTab(WebDriver driver, String nameField, String valueData) {
        waitElementToVisible(driver, TourInfoTabUI.DYNAMIC_FIELD_TAB_INFO, nameField);
        sendKeyToElement(driver,TourInfoTabUI.DYNAMIC_FIELD_TAB_INFO, valueData, nameField);
    }
    public void chooseItemOnDropdownOnUpdateLocation(WebDriver driver, String dropdownName, String valueData) {
      selectItemInCustomDropdown(driver,TourInfoTabUI.DYNAMIC_DROPDOWN,TourInfoTabUI.ITEM_DYNAMIC_DROPDOWN,valueData,dropdownName);
    }

    public void clickToButtonSaveTour() {
        waitForElementClickable(driver,TourInfoTabUI.SAVE_TOUR_BUTTON);
        clickToElement(driver,TourInfoTabUI.SAVE_TOUR_BUTTON);
    }

    public void clickToItemOfNavigationMenu(WebDriver driver) {
    }

    public boolean checkTourDetaiTabInfoDisplay() {
    }
}
