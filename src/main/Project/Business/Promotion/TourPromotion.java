package Project.Business.Promotion;

import Interfaces.hahalolo_business.Promotion.CreateEditPromoUI;
import Interfaces.hahalolo_business.Promotion.DetailPromoUI;
import Interfaces.hahalolo_business.Promotion.ListPromoUI;
import org.openqa.selenium.WebDriver;

public class TourPromotion extends Promotion {
    WebDriver driver;
    public TourPromotion(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterTourNameForSeacrching(WebDriver driver, String tourName){
        waitElementToVisible(driver, CreateEditPromoUI.SEARCH_TOUR_FIELD);
        sendKeyToElement(driver, CreateEditPromoUI.SEARCH_TOUR_FIELD, tourName);
        setTimeDelay(1);
    }

    public void clickToSeacrhTour(WebDriver driver, String tourName){
        waitElementToVisible(driver, CreateEditPromoUI.BUTTON_SEARCH_TOUR);
        clickToElement(driver, CreateEditPromoUI.BUTTON_SEARCH_TOUR);
        setTimeDelay(1);
    }

    public void addRedicrectTourTrToSelectedApplyPromo(WebDriver driver, String tourName){
        waitElementToVisible(driver, CreateEditPromoUI.ICON_ADD_DIRECT_TOUR);
        clickToElement(driver, CreateEditPromoUI.ICON_ADD_DIRECT_TOUR,tourName);
        setTimeDelay(1);
    }
    public void removeTourOnSelectedApplyPromo(WebDriver driver,String tourName){
        waitElementToVisible(driver, CreateEditPromoUI.BUTTON_REMOVE_DIRECT_TOUR);
        clickToElement(driver, CreateEditPromoUI.BUTTON_REMOVE_DIRECT_TOUR,tourName);
        setTimeDelay(1);
    }

    public void chooseTypeTour(WebDriver driver, String typeTour){
        waitElementToVisible(driver, CreateEditPromoUI.TYPE_TOUR_OPTION);
        clickToElement(driver, CreateEditPromoUI.TYPE_TOUR_OPTION,typeTour);
        setTimeDelay(1);
    }

    public void chooseTopicTour(WebDriver driver, String topicTour){
        waitElementToVisible(driver, CreateEditPromoUI.TOPIC_TOUR_OPTION);
        clickToElement(driver, CreateEditPromoUI.TOPIC_TOUR_OPTION,topicTour);
        setTimeDelay(1);
    }

    public void chooseExceedTour(WebDriver driver, String tourName){
        waitElementToVisible(driver, CreateEditPromoUI.EXCEED_TOUR_ITEM);
        clickToElement(driver, CreateEditPromoUI.EXCEED_TOUR_ITEM,tourName);
        setTimeDelay(1);
    }


    public void clickIconAddTourToSelectedList(WebDriver driver, String tourName) {
        waitElementToVisible(driver, CreateEditPromoUI.PROMOTION_SIMPLE_MODE);
        waitElementToVisible(driver, CreateEditPromoUI.ICON_ADD_DIRECT_TOUR, tourName);
        clickToElement(driver, CreateEditPromoUI.ICON_ADD_DIRECT_TOUR, tourName);
        setTimeDelay(1);
    }



    public boolean getPromotionDisountLevel() {
        return true;
    }
}
