package Project.Business.Tour.Management.Detail;

import Project.Business.Tour.Management.TourCommon;
import org.openqa.selenium.WebDriver;

public class TourServiceTab extends TourCommon {
    WebDriver driver;
    public TourServiceTab (WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkTourServiceTabDisplaySuccess() {
        return true;
    }

    public void checkAndUpdateServices(WebDriver driver) {
    }

    public void clickUpdateButton(WebDriver driver) {
    }
}
