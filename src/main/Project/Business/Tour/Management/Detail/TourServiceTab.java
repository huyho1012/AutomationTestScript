package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.TourServicePriceUI;
import Interfaces.hahalolo_business.Tour.Management.Detail.TourServiceUI;
import Project.Business.Tour.Management.TourCommon;
import org.openqa.selenium.WebDriver;

public class TourServiceTab extends TourCommon {
    WebDriver driver;
    public TourServiceTab (WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkTourServiceTabDisplaySuccess() {
        return checkElementDisplay(driver, TourServiceUI.SERVICE_TAB);
    }

    public void addServicesApply(WebDriver driver , int numberService) {
        waitElementToVisible(driver, TourServiceUI.SERVICE_TAB);
        int n = findElements(driver, TourServiceUI.HALO_SERVICE_LIST).size();
        for(int i =0 ; i<n ; i++){
            waitForElementClickable(driver,TourServiceUI.HALO_SERVICE_ITEM);
            clickToElement(driver,TourServiceUI.HALO_SERVICE_ITEM);
            setTimeDelay(1);
            if(i == numberService){
                break;
            }
        }
    }
    public void removeServiceApply(WebDriver driver) {
        waitElementToVisible(driver, TourServiceUI.SERVICE_TAB);
        int n = findElements(driver, TourServiceUI.HALO_SERVICE_LIST).size();
        for(int i =0 ; i<n ; i++){
            waitForElementClickable(driver,TourServiceUI.HALO_SERVICE_ITEM);
            clickToElement(driver,TourServiceUI.HALO_SERVICE_ITEM);
            setTimeDelay(1);
        }
    }

    public void clickUpdateButton(WebDriver driver) {
        waitForElementClickable(driver, TourServiceUI.BUTTON_UPDATE_SERVICE);
        clickToElement(driver,TourServiceUI.BUTTON_UPDATE_SERVICE);
        setTimeDelay(1);
    }

    public void checkHaloTourIsAdded(WebDriver driver) {
        waitElementToVisible(driver, TourServiceUI.SERVICE_TAB);
        int n = findElements(driver, TourServiceUI.TOUR_SERVICE_LIST).size();
        for(int i = 0; i<n ; i++){
            waitForElementClickable(driver,TourServiceUI.TOUR_SERVICE_ITEM);
            clickToElement(driver,TourServiceUI.TOUR_SERVICE_ITEM);
            setTimeDelay(1);
        }

    }
}
