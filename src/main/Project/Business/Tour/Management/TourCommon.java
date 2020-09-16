package Project.Business.Tour.Management;

import Interfaces.hahalolo_business.Tour.Management.TourCommonUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class TourCommon extends HeaderPage {
    WebDriver driver;
    public void clickToItemOfNavigationMenu(WebDriver driver, String nameItem) {
        waitElementToVisible(driver, TourCommonUI.MENU_ON_TOUR_DETAIL);
        waitElementToVisible(driver, TourCommonUI.ITEM_MENU_ON_TOUR_DETAIL, nameItem);
        clickToElementByJS(driver, TourCommonUI.ITEM_MENU_ON_TOUR_DETAIL, nameItem);
    }


    public void clickToBackTourManagement(WebDriver driver) {
        waitElementToVisible(driver, TourCommonUI.BUTTON_BACK_TO_MANAGEMENT_LIST);
        clickToElement(driver, TourCommonUI.BUTTON_BACK_TO_MANAGEMENT_LIST);
    }
}
