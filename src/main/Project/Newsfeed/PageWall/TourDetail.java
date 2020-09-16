package Project.Newsfeed.PageWall;

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
    }

    public void chooseDepatureDateWantBooking() {
    }



    public boolean checkTourSchedulerTabIsDisplay() {
        return true;
    }
}
