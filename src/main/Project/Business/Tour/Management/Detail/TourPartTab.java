package Project.Business.Tour.Management.Detail;

import Interfaces.Business.Tour.Management.Detail.TourPartUI;
import Project.Business.Tour.Management.TourCommon;
import org.openqa.selenium.WebDriver;

public class TourPartTab extends TourCommon {
    WebDriver driver;
    public TourPartTab(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPartTabDisplaySuccess() {
        return true;
    }

    public void clickToCreateNewPartButton() {
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

    public void chooseTransportItem(WebDriver driver) {
    }

    public void choosePartLogo(WebDriver driver) {
    }

    public void clickToButtonSavePart(WebDriver driver) {
    }

    public boolean checkPartHasBeenCreatedSuccessfully() {
        return true;
    }
}
