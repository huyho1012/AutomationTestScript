package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.TourPromotionUI;
import Project.Business.Tour.Management.TourCommon;
import org.openqa.selenium.WebDriver;

public class TourPromotionTab extends TourCommon {
    WebDriver driver;
    public TourPromotionTab (WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPromotionTabDislay() {
        waitElementToVisible(driver, TourPromotionUI.TOUR_PROMO_TAB);
        return getTextElement(driver, TourPromotionUI.TOUR_PROMO_TAB_TITLE).contains("Danh sách khuyến mãi đang áp dụng");
    }

    public String getMessageNotFoundPromo() {
        waitElementToVisible(driver, TourPromotionUI.TOUR_PROMO_TAB);
        return getTextElement(driver, TourPromotionUI.DATA_NOT_FOUND_MESSAGE);
    }

    public void clickToCreatePromotionButton() {
        scrollToTopPage(driver);
        waitElementToVisible(driver, TourPromotionUI.TOUR_PROMO_TAB);
        waitForElementClickable(driver, TourPromotionUI.BUTTON_CREATE_PROMO);
        clickToElement(driver, TourPromotionUI.BUTTON_CREATE_PROMO);
    }
}
