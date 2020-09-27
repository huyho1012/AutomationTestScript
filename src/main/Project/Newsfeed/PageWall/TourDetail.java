package Project.Newsfeed.PageWall;

import Interfaces.hahalolo_newsfeed.PersonaWall.PersonalCommonUI;
import Interfaces.hahalolo_newsfeed.PageWall.Tour.TourDetailForBookingUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class TourDetail extends HeaderPage {
    WebDriver driver;
    public TourDetail(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkTourDetailBookingPageIsDisplay() {
        waitElementToVisible(driver, PersonalCommonUI.HEADER_SECTION);
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

    public Object getCurrencyOnPriceFromSection() {
        return null;
    }

    public Object getCurrencySymbolOfTourItemOnScheduler() {
        return null;
    }
}
