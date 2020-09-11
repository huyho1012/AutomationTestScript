package Project.Business.Promotion;

import Interfaces.hahalolo_business.Promotion.PromotionUI;
import org.openqa.selenium.WebDriver;

public class TourPromotion extends Promotion {
    WebDriver driver;
    public TourPromotion(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterTourNameForSeacrching(WebDriver driver, String tourName){
        waitElementToVisible(driver, PromotionUI.SEARCH_TOUR_FIELD);
        sendKeyToElement(driver, PromotionUI.SEARCH_TOUR_FIELD, tourName);
        setTimeDelay(1);
    }

    public void clickToSeacrhTour(WebDriver driver, String tourName){
        waitElementToVisible(driver, PromotionUI.BUTTON_SEARCH_TOUR);
        clickToElement(driver, PromotionUI.BUTTON_SEARCH_TOUR);
        setTimeDelay(1);
    }

    public void addRedicrectTourTrToSelectedApplyPromo(WebDriver driver, String tourName){
        waitElementToVisible(driver, PromotionUI.BUTTON_ADD_DIRECT_TOUR);
        clickToElement(driver, PromotionUI.BUTTON_ADD_DIRECT_TOUR,tourName);
        setTimeDelay(1);
    }
    public void removeTourOnSelectedApplyPromo(WebDriver driver,String tourName){
        waitElementToVisible(driver, PromotionUI.BUTTON_REMOVE_DIRECT_TOUR);
        clickToElement(driver, PromotionUI.BUTTON_REMOVE_DIRECT_TOUR,tourName);
        setTimeDelay(1);
    }

    public void chooseTypeTour(WebDriver driver, String typeTour){
        waitElementToVisible(driver, PromotionUI.TYPE_TOUR_OPTION);
        clickToElement(driver, PromotionUI.TYPE_TOUR_OPTION,typeTour);
        setTimeDelay(1);
    }

    public void chooseTopicTour(WebDriver driver, String topicTour){
        waitElementToVisible(driver, PromotionUI.TOPIC_TOUR_OPTION);
        clickToElement(driver, PromotionUI.TOPIC_TOUR_OPTION,topicTour);
        setTimeDelay(1);
    }

    public void chooseExceedTour(WebDriver driver, String tourName){
        waitElementToVisible(driver, PromotionUI.EXCEED_TOUR_ITEM);
        clickToElement(driver, PromotionUI.EXCEED_TOUR_ITEM,tourName);
        setTimeDelay(1);
    }


}
