package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.TourSettingUI;
import Project.Business.Tour.Management.TourCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

import java.awt.*;

public class TourSettingTab extends TourCommon {
    WebDriver driver;
    public TourSettingTab (WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkSettingTourPageDisplay(WebDriver driver) {
        return checkElementDisplay(driver, TourSettingUI.TOUR_SETTING_TAB);
    }
    public void publishTour() {
        if(!checkStatusPublishTour()){
            waitForElementClickable(driver, TourSettingUI.PUBLISH_TOUR);
            clickToElement(driver,TourSettingUI.PUBLISH_TOUR);
        }
    }
    public void unPublishTour() {
        if(checkStatusPublishTour()){
            waitForElementClickable(driver, TourSettingUI.PUBLISH_TOUR);
            clickToElement(driver,TourSettingUI.PUBLISH_TOUR);
        }
    }
    public boolean checkStatusPublishTour() {
        String colorBackground =  getAttributeOfClassAfter(driver,".custom-control-label","background-color");
        String hexaColorButtonPublish = Color.fromString(colorBackground).asHex();
        if(hexaColorButtonPublish == "#166986"){
            return true;
        }
        else
            return false;
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, TourSettingUI.BUTTON_SAVE_SETTING);
        clickToElement(driver,TourSettingUI.BUTTON_SAVE_SETTING);
    }


}
