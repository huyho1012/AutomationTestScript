package Project.Business.Promotion;

import Interfaces.hahalolo_business.Promotion.Promotion_Detail_PageUI;
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
        return getTextElement(driver, Promotion_Detail_PageUI.PROMO_NAME);
    }

    public String getPromoDescOnDetail() {
        return getTextElement(driver, Promotion_Detail_PageUI.PROMO_DESC);
    }

    public String getStatusOnDetail() {
        return getTextElement(driver, Promotion_Detail_PageUI.PROMO_STATUS);
    }

    public String getLanguageOnDetail() {
        return getTextElement(driver, Promotion_Detail_PageUI.PROMO_LANGUAGE);
    }

    public String getCurrencyOnDetail() {
        return getTextElement(driver, Promotion_Detail_PageUI.PROMO_LANGUAGE);
    }

    public String getDateRangeOnDetail() {
        return getTextElement(driver, Promotion_Detail_PageUI.PROMO_APPLY_TIME);
    }

    public String geDiscountTypeOnDetail() {
        return getTextElement(driver, Promotion_Detail_PageUI.DISCOUNT_TYPE);
    }

    public String getPromoTypeOnDetail() {
        return getTextElement(driver, Promotion_Detail_PageUI.PROMO_TYPE);
    }

    public String getTourTypeAppliedOnDetail() {
        return null;
    }

    public String getListTourAppliedOnPromoDetail() {
        return null;
    }

}
