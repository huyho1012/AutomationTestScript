package Project.Business.Tour.Management.List;

import Interfaces.Business.Tour.Management.List.TourManagementUI;
import Project.Business.Tour.Management.TourCommon;
import org.openqa.selenium.WebDriver;

public class TourManagementPage extends TourCommon {
    WebDriver driver;
    public TourManagementPage(WebDriver webDriver){
        driver = webDriver;
    }


    public void enterValueOfTourName(WebDriver driver, String tourName) {
        waitElementToVisible(driver, TourManagementUI.TOUR_NAME_FIELD);
        sendKeyToElement(driver, TourManagementUI.TOUR_NAME_FIELD,tourName);
    }

    public void chooseTourType(WebDriver driver, String tourType) {
        waitElementToVisible(driver, TourManagementUI.POPUP_CREATE_NEW_TOUR);
        selectItemInDropdownByText(driver, TourManagementUI.TOUR_TYPE_DROP_DOWN,tourType);
    }

    public void chooseTourTopic(WebDriver driver ,String tourTopic) {
        waitElementToVisible(driver, TourManagementUI.POPUP_CREATE_NEW_TOUR);
        selectItemInDropdownByText(driver, TourManagementUI.TOUR_TOPIC_DROP_DOWN,tourTopic);
    }

    public void clickSaveButtonToCreateTour(WebDriver driver) {
        waitElementToVisible(driver, TourManagementUI.BUTTON_START_CREATE_TOUR);
        clickToElement(driver, TourManagementUI.BUTTON_START_CREATE_TOUR);
    }

    public boolean checkPageWithCaseNoTourDisplay() {
        return true;
    }

    public void clickStartCreateTourButtonOnCenterListPage(WebDriver driver) {
        waitElementToVisible(driver, TourManagementUI.BUTTON_START_CREATE_TOUR);
        clickToElement(driver, TourManagementUI.BUTTON_START_CREATE_TOUR);
    }
    public void clickToButtonSaveOnPopup(WebDriver driver){
        waitForElementClickable(driver,TourManagementUI.BUTTON_SAVE);
        clickToElement(driver,TourManagementUI.BUTTON_SAVE);
    }

    public boolean checkPopupCreateTourDisplay() {
        waitElementToVisible(driver, TourManagementUI.POPUP_CREATE_NEW_TOUR);
        return getTextElement(driver, TourManagementUI.POPUP_CREATE_TOUR_TITLE).contentEquals("Tạo Tour mới");
    }
}
