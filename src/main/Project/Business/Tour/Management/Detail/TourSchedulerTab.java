package Project.Business.Tour.Management.Detail;

import Project.Business.Tour.Management.TourCommon;
import org.openqa.selenium.WebDriver;

public class TourSchedulerTab extends TourCommon {
    WebDriver driver;
    public TourSchedulerTab(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkSchedulerTabDisplaySuccess() {
        return true;
    }

    public void chooseStartDate(WebDriver driver) {
    }

    public void chooseEndDate(WebDriver driver) {
    }

    public void clickButtonSetting(WebDriver driver) {
    }
}
