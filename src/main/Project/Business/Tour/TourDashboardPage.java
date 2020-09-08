package Project.Business.Tour;

import Common.HandleFunction.AbstractPage;
import Interfaces.Business.Tour.TourDashboardPageUI;
import org.openqa.selenium.WebDriver;

public class TourDashboardPage extends AbstractPage {
    WebDriver driver;

    public TourDashboardPage(WebDriver webDriver){
        driver = webDriver;
    }

    public void clickItemOnTourNavMenu(WebDriver driver, String itemMenu) {
        clickToElementByJS(driver, TourDashboardPageUI.ITEM_ON_TOUR_BUSINESS,itemMenu);
    }

    public String getPageNameOnTourDashboard(WebDriver driver) {
        waitElementToVisible(driver,TourDashboardPageUI.TOUR_DASHBOARD_PAGE);
        return getTextElement(driver, TourDashboardPageUI.PAGE_NAME_ON_DASHBOARD);
    }

    public boolean checkPageIsDisplay(WebDriver driver , String tourPageName) {
        return getPageNameOnTourDashboard(driver).contains(tourPageName) && getPageTitle(driver).contains("Hahalolo - Tour Dashboard");
    }
}
