package Project.Business.Tour;

import Interfaces.hahalolo_business.Tour.TourDashboardPageUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class TourDashboardPage extends HeaderPage {
    WebDriver driver;

    public TourDashboardPage(WebDriver webDriver){
        driver = webDriver;
    }



    public String getPageNameOnTourDashboard(WebDriver driver) {
        waitElementToVisible(driver,TourDashboardPageUI.TOUR_DASHBOARD_PAGE);
        return getTextElement(driver, TourDashboardPageUI.PAGE_NAME_ON_DASHBOARD);
    }

    public boolean checkPageIsDisplay(WebDriver driver , String tourPageName) {
        switchWindowByTitle(driver,"Hahalolo - Tour Dashboard");
        return getPageNameOnTourDashboard(driver).contains(tourPageName);
    }
}
