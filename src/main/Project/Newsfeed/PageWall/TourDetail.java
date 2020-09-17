package Project.Newsfeed.PageWall;

import Interfaces.hahalolo_newsfeed.PageWall.TourDetailForBookingUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class TourDetail extends HeaderPage {
    WebDriver driver;
    public TourDetail(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkTourDetailBookingPageIsDisplay() {
        return true;
    }



    public void clickToSchedulerTab() {
        waitForElementClickable(driver, TourDetailForBookingUI.TAB_SCHEDULER);
        clickToElement(driver, TourDetailForBookingUI.TAB_SCHEDULER);
    }

    public void chooseDepatureDateWantBooking() {
        waitForElementClickable(driver, TourDetailForBookingUI.BUTTON_BOOKING_NOW_FOR_DIRECT_TOUR,"");
        clickToElement(driver, TourDetailForBookingUI.BUTTON_BOOKING_NOW_FOR_DIRECT_TOUR,"");
    }



    public boolean checkTourSchedulerTabIsDisplay() {
        return true;
    }
}
