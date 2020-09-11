package Project.Business.Promotion;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_business.Promotion.PromotionUI;
import org.openqa.selenium.WebDriver;

public class Promotion  extends AbstractPage {
    WebDriver driver;

    public void publicPromo(WebDriver driver){
        waitForElementClickable(driver, PromotionUI.PROMOTION_STATUS);
        clickToElement(driver, PromotionUI.PROMOTION_STATUS);
    }

    public void unpublicPromo(WebDriver driver){
        waitForElementClickable(driver, PromotionUI.PROMOTION_STATUS);
        clickToElement(driver, PromotionUI.PROMOTION_STATUS);
    }

    public void enterPromoName(WebDriver driver, String promoName) {
        waitElementToVisible(driver, PromotionUI.PROMOTION_NAME);
        sendKeyToElement(driver, PromotionUI.PROMOTION_NAME,promoName);
    }

    public void enterPromoDesc(WebDriver driver, String promoDesc) {
        waitElementToVisible(driver, PromotionUI.PROMOTION_DESC);
        sendKeyToElement(driver, PromotionUI.PROMOTION_DESC,promoDesc);
    }

    public void chooseCurrencyPromo(WebDriver driver, String currency) {
        waitForElementClickable(driver, PromotionUI.CURRENCY_DROPDOWN);
        clickToElement(driver, PromotionUI.CURRENCY_DROPDOWN,currency);
    }

    public void chooseLanguagePromotion(WebDriver driver, String currency) {
        waitForElementClickable(driver, PromotionUI.CURRENCY_DROPDOWN);
        clickToElement(driver, PromotionUI.CURRENCY_DROPDOWN,currency);
    }

    public void enterDateRangeApply(WebDriver driver, String DateRange){
        waitForElementClickable(driver, PromotionUI.PROMOTION_DATE_RANGE);
        sendKeyToElement(driver, PromotionUI.PROMOTION_DATE_RANGE,DateRange);
    }

    public void chooseTypeDiscount(WebDriver driver, int numOption) {
        switch(numOption){
            case 1:
                waitForElementClickable(driver, PromotionUI.TYPE_DISCOUNT_PER_ADULT);
                clickToElement(driver, PromotionUI.TYPE_DISCOUNT_PER_ADULT);
                setTimeDelay(1);
                break;
            case 2:
                waitForElementClickable(driver, PromotionUI.TYPE_DISCOUNT_TOTAL_ORDER);
                clickToElement(driver, PromotionUI.TYPE_DISCOUNT_TOTAL_ORDER);
                setTimeDelay(1);
                break;
            default:
                break;
        }
    }

    public void choosePromoType(WebDriver driver, int numOption) {
       switch(numOption){
            case 1:
                waitForElementClickable(driver, PromotionUI.PROMO_TYPE_FIX_AMOUNT);
                clickToElement(driver, PromotionUI.PROMO_TYPE_FIX_AMOUNT);
                setTimeDelay(1);
                break;
            case 2:
                waitForElementClickable(driver, PromotionUI.PROMO_TYPE_PER_CENT);
                clickToElement(driver, PromotionUI.PROMO_TYPE_PER_CENT);
                setTimeDelay(1);
                break;
           default:
               break;
        }
    }

    public void enterDiscountAmount(WebDriver driver, String discountAmount) {
        waitElementToVisible(driver, PromotionUI.DISCOUNT_AMOUNT);
        sendKeyToElement(driver, PromotionUI.DISCOUNT_AMOUNT,discountAmount);
    }

    public void enterMinOrderValue(WebDriver driver, String minOrderValue) {
        waitElementToVisible(driver, PromotionUI.MIN_ORDER_VALUE);
        sendKeyToElement(driver, PromotionUI.MIN_ORDER_VALUE, minOrderValue);
    }

    public void enterMinAdultPerson(WebDriver driver, String minAdultPer) {
        waitElementToVisible(driver, PromotionUI.MIN_PER);
        sendKeyToElement(driver, PromotionUI.MIN_PER, minAdultPer);
    }

    public void chooseModeAdvance(WebDriver driver){
        if(checkStatusOfModeButton()){
            waitForElementClickable(driver, PromotionUI.PROMOTION_STATUS);
            clickToElement(driver, PromotionUI.PROMOTION_STATUS);
        }
    }

    public void chooseModeSimple(WebDriver driver){
        if(checkStatusOfModeButton()){
            waitForElementClickable(driver, PromotionUI.PROMOTION_STATUS);
            clickToElement(driver, PromotionUI.PROMOTION_STATUS);
        }
    }

    private boolean checkStatusOfModeButton() {
        return true;
    }

    public void clickSaveButton(WebDriver driver){
        waitForElementClickable(driver, PromotionUI.BUTTON_SAVE_PROMOTO);
        clickToElement(driver, PromotionUI.BUTTON_SAVE_PROMOTO);
    }

    public void clickAddImagePromo(WebDriver driver){
        waitForElementClickable(driver, PromotionUI.BUTTON_ADD_PROMOTION_IMAGE);
        clickToElement(driver, PromotionUI.BUTTON_ADD_PROMOTION_IMAGE);
    }

    public void clickTOAddDiscountLevel(WebDriver driver){
        waitForElementClickable(driver, PromotionUI.BUTTON_ADD_PROMOTION_LEVEL);
        clickToElement(driver, PromotionUI.BUTTON_ADD_PROMOTION_LEVEL);
    }
}
