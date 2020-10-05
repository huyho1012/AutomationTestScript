package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.TourSchedulerUI;
import Project.Business.Tour.Management.TourCommon;
import org.openqa.selenium.WebDriver;

public class TourSchedulerTab extends TourCommon {
    WebDriver driver;
    public TourSchedulerTab(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkSchedulerTabDisplaySuccess() {
        scrollToTopPage(driver);
        return checkElementIsDisplayed(driver, TourSchedulerUI.SCHEDULER_TAB);
    }

    public void chooseStartDate(WebDriver driver, String startDate) {
        waitElementToVisible(driver, TourSchedulerUI.START_DATE_FIELD);
        sendKeyToElement(driver, TourSchedulerUI.START_DATE_FIELD,startDate);
    }

    public void chooseEndDate(WebDriver driver,String endDate) {
        waitElementToVisible(driver, TourSchedulerUI.END_DATE_FIELD);
        sendKeyToElement(driver, TourSchedulerUI.END_DATE_FIELD,endDate);
        setTimeDelay(3);
    }

    public void clickButtonSetting(WebDriver driver) {
        clickToElement(driver,TourSchedulerUI.SCHEDULER_TAB);
        waitForElementClickable(driver, TourSchedulerUI.BUTTON_SETTING);
        clickToElementByJS(driver, TourSchedulerUI.BUTTON_SETTING);
    }
}
