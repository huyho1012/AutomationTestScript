package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.TourSettingUI;
import Project.Business.Tour.Management.TourCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class TourSettingTab extends TourCommon {
    WebDriver driver;

    public TourSettingTab (WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkSettingTourPageDisplay(WebDriver driver) {
        return checkElementIsDisplayed(driver, TourSettingUI.TOUR_SETTING_TAB);
    }

    public void clickToPublishTour() {
        if(!checkStatusPublishTour()){
            waitForElementClickable(driver, TourSettingUI.PUBLISH_TOUR);
            clickToElement(driver,TourSettingUI.PUBLISH_TOUR);
        }
    }

    public void clickToUnPublishTour() {
        if(checkStatusPublishTour()){
            waitForElementClickable(driver, TourSettingUI.PUBLISH_TOUR);
            clickToElement(driver,TourSettingUI.PUBLISH_TOUR);
        }
    }

    public boolean checkStatusPublishTour() {
        String colorBackground =  getAttributeClassWithAfter(driver,".custom-control-label","background-color");
        String hexaColorButtonPublish = Color.fromString(colorBackground).asHex();
        return hexaColorButtonPublish == "#166986";
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, TourSettingUI.BUTTON_SAVE_SETTING);
        clickToElement(driver,TourSettingUI.BUTTON_SAVE_SETTING);
    }
}
