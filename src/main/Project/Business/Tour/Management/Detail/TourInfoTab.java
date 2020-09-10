package Project.Business.Tour.Management.Detail;

import Interfaces.Business.Tour.Management.Detail.TourInfoUI;
import Interfaces.Shared.MediaManagementUI;
import Project.Business.Tour.Management.TourCommon;
import org.openqa.selenium.WebDriver;

public class TourInfoTab extends TourCommon {
    WebDriver driver;
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

    public void chooseImageToUpdateTourInfo(WebDriver driver, String nameFunctionUpload) {
        clickToElement(driver, TourInfoUI.UPLOAD_COVER_BUTTON, nameFunctionUpload);
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

    public void enterValueToDynamicField(WebDriver driver, String nameField, String valueData) {
        waitElementToVisible(driver, TourInfoUI.DYNAMIC_FIELD_TAB_INFO, nameField);
        sendKeyToElement(driver, TourInfoUI.DYNAMIC_FIELD_TAB_INFO, valueData, nameField);
    }
    public void chooseItemToUpdateLocation(WebDriver driver, String dropdownName, String valueData) {
      selectItemInCustomDropdown(driver, TourInfoUI.DYNAMIC_DROPDOWN, TourInfoUI.ITEM_DYNAMIC_DROPDOWN,valueData,dropdownName);
    }

    public void clickToButtonSaveTour() {
        waitForElementClickable(driver, TourInfoUI.SAVE_TOUR_BUTTON);
        clickToElement(driver, TourInfoUI.SAVE_TOUR_BUTTON);
    }



    public boolean checkTourDetaiTabInfoDisplay() {
        return true;
    }
}
