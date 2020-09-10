package Project.Business.Tour.Management;

import Common.HandleFunction.AbstractPage;
import Interfaces.Business.Tour.Management.TourCommonUI;
import org.openqa.selenium.WebDriver;

public class TourCommon extends AbstractPage {
    public void clickToItemOfNavigationMenu(WebDriver driver, String nameItem) {
        waitElementToVisible(driver, TourCommonUI.MENU_ON_TOUR_DETAIL);
        waitElementToVisible(driver, TourCommonUI.ITEM_MENU_ON_TOUR_DETAIL, nameItem);
        clickToElement(driver, TourCommonUI.ITEM_MENU_ON_TOUR_DETAIL, nameItem);
    }
}
