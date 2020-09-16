package Project.Business.Promotion;

import Interfaces.hahalolo_business.Promotion.DetailPromoUI;
import org.openqa.selenium.WebDriver;

public class DetailPromo extends Promotion {
    WebDriver driver;
    public DetailPromo(WebDriver webDriver){
        driver = webDriver;
    }
    public boolean checkViewDetailPromotionDisplay() {
        return true;
    }

    public String getPromoNameOnDetail() {
        return getTextElement(driver, DetailPromoUI.PROMO_NAME);
    }

    public String getPromoDescOnDetail() {
        return getTextElement(driver, DetailPromoUI.PROMO_DESC);
    }

    public String getStatusOnDetail() {
        return getTextElement(driver, DetailPromoUI.PROMO_STATUS);
    }

    public String getLanguageOnDetail() {
        return getTextElement(driver, DetailPromoUI.PROMO_LANGUAGE);
    }

    public String getCurrencyOnDetail() {
        return getTextElement(driver, DetailPromoUI.PROMO_LANGUAGE);
    }

    public String getDateRangeOnDetail() {
        return getTextElement(driver, DetailPromoUI.PROMO_APPLY_TIME);
    }

    public String geDiscountTypeOnDetail() {
        return getTextElement(driver, DetailPromoUI.DISCOUNT_TYPE);
    }

    public String getPromoTypeOnDetail() {
        return getTextElement(driver, DetailPromoUI.PROMO_TYPE);
    }

    public String getTourTypeAppliedOnDetail() {
        return null;
    }

    public String getListTourAppliedOnPromoDetail() {
        return null;
    }

}
