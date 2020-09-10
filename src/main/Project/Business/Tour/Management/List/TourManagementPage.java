package Project.Business.Tour.Management.List;

import Interfaces.Business.Tour.Management.List.TourManagementUI;
import Project.Business.Tour.Management.TourCommon;
import org.openqa.selenium.WebDriver;

public class TourManagementPage extends TourCommon {
    WebDriver driver;
    public TourManagementPage(WebDriver webDriver){
        driver = webDriver;
    }


    public void enterValueOfTourName(WebDriver driver, String s) {
    }

    public void chooseTourType(WebDriver driver) {
    }

    public void chooseTourTopic(WebDriver driver) {
    }

    public void clickSaveButtonToCreateTour(WebDriver driver) {
    }

    public boolean checkPageWithCaseNoTourDisplay() {
        return true;
    }

    public void clickButtonStartCreateNewTour(WebDriver driver) {
        waitElementToVisible(driver, TourManagementUI.BUTTON_START_CREATE_TOUR);
        clickToElement(driver, TourManagementUI.BUTTON_START_CREATE_TOUR);
    }
    public void clickButtonCreateTour(WebDriver driver){
        waitForElementClickable(driver,TourManagementUI.BUTTON_CREATE_TOUR);
        clickToElement(driver,TourManagementUI.BUTTON_CREATE_TOUR);
    }

    public boolean checkPopupCreateTourDisplay() {
        return checkElementDisplay()
    }
}
