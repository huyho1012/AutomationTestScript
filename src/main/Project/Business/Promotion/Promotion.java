package Project.Business.Promotion;

import Interfaces.Shared.MediaManagementUI;
import Interfaces.hahalolo_business.Promotion.CreateEditPromoUI;
import Interfaces.hahalolo_business.Promotion.ListPromoUI;
import Project.Business.Tour.Management.TourCommon;
import Project.Shared.Management.MediaManagement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Promotion  extends TourCommon {
    WebDriver driver;
    MediaManagement media;

    public void publicPromotion(WebDriver driver){
        scrollToTopPage(driver);
        waitForElementClickable(driver, CreateEditPromoUI.PROMO_STATUS_MODE);
        clickToElement(driver, CreateEditPromoUI.PROMO_STATUS_MODE);
    }

    public void unpublicPromo(WebDriver driver){
        waitForElementClickable(driver, CreateEditPromoUI.PROMO_STATUS_MODE);
        clickToElement(driver, CreateEditPromoUI.PROMO_STATUS_MODE);
    }
    public void enterPromoName(WebDriver driver, String promoName) {
        waitElementToVisible(driver, CreateEditPromoUI.PROMO_NAME_FIELD);
        sendKeyToElement(driver, CreateEditPromoUI.PROMO_NAME_FIELD,promoName);
    }

    public void enterPromoDesc(WebDriver driver, String promoDesc) {
        waitElementToVisible(driver, CreateEditPromoUI.PROMO_DESC_TEXTAREA);
        sendKeyToElement(driver, CreateEditPromoUI.PROMO_DESC_TEXTAREA,promoDesc);
    }

    public void chooseLanguagePromotion(WebDriver driver, String language) {
        selectItemInCustomDropdownByScroll(driver, CreateEditPromoUI.LANGUAGE_DROPDOWN, CreateEditPromoUI.LANGUAGE_ITEM,language);
    }
    public void chooseCurrencyPromotion(WebDriver driver, String currency) {
        selectItemInCustomDropdownByScroll(driver, CreateEditPromoUI.CURRENCY_DROPDOWN, CreateEditPromoUI.CURRENCY_ITEM,currency);
    }

    public void enterDateRangeApply(WebDriver driver, String dateRange){
        waitForElementClickable(driver, CreateEditPromoUI.PROMOTION_DATE_RANGE);
        sendKeyToElement(driver, CreateEditPromoUI.PROMOTION_DATE_RANGE, dateRange);
        sendKeyBoardToElement(driver,CreateEditPromoUI.PROMOTION_DATE_RANGE, Keys.ENTER);
        setTimeDelay(1);
    }

    public void clickAddImagePromo(WebDriver driver, String fileImage){
        waitForElementClickable(driver, CreateEditPromoUI.BUTTON_ADD_PROMO_IMAGE);
        clickToElement(driver, CreateEditPromoUI.BUTTON_ADD_PROMO_IMAGE);
        media = new MediaManagement(driver);
        media.uploadImageFromLocalToMedia(driver,fileImage);
        waitElementToVisible(driver, MediaManagementUI.PROCESSING_BAR);
        waitForElementClickable(driver,MediaManagementUI.SELECT_BUTTON);
        clickToElement(driver, MediaManagementUI.SELECT_BUTTON);
    }

    public void chooseTypeDiscount(WebDriver driver, int numOption) {
        clickToElement(driver,CreateEditPromoUI.TITlE_HEADER);
        switch(numOption){
            case 1:
                waitForElementClickable(driver, CreateEditPromoUI.DISCOUNT_TOTAL_ORDER);
                clickToElement(driver, CreateEditPromoUI.DISCOUNT_TOTAL_ORDER);
                setTimeDelay(1);
                break;
            case 2:
                waitForElementClickable(driver, CreateEditPromoUI.DISCOUNT_PER_ADULT);
                clickToElement(driver, CreateEditPromoUI.DISCOUNT_PER_ADULT);
                setTimeDelay(1);
                break;
            default:
                break;
        }
    }

    public void chooseTypePromo(WebDriver driver, int numOption) {
        clickToElement(driver,CreateEditPromoUI.TITlE_HEADER);
        switch(numOption){
            case 1:
                waitForElementClickable(driver, CreateEditPromoUI.FIXED_AMOUNT);
                clickToElement(driver, CreateEditPromoUI.FIXED_AMOUNT);
                setTimeDelay(1);
                break;
            case 2:
                waitForElementClickable(driver, CreateEditPromoUI.PERCENT_ORIGINAL_PRICE);
                clickToElement(driver, CreateEditPromoUI.PERCENT_ORIGINAL_PRICE);
                setTimeDelay(1);
                break;
           default:
               break;
        }
    }

    public void enterDiscountAmount(WebDriver driver, String discountAmount) {
        waitElementToVisible(driver, CreateEditPromoUI.DISCOUNT_AMOUNT);
        sendKeyToElement(driver, CreateEditPromoUI.DISCOUNT_AMOUNT, discountAmount);
    }

    public void enterMinOrderValue(WebDriver driver, String minOrderValue) {
        waitElementToVisible(driver, CreateEditPromoUI.MIN_ORDER_VALUE);
        sendKeyToElement(driver, CreateEditPromoUI.MIN_ORDER_VALUE, minOrderValue);
    }

    public void enterMinAdultPerson(WebDriver driver, String minAdultPer) {
        waitElementToVisible(driver, CreateEditPromoUI.MIN_ADULT_PEOPLE);
        sendKeyToElement(driver, CreateEditPromoUI.MIN_ADULT_PEOPLE, minAdultPer);
    }

    public void chooseModeAdvance(WebDriver driver){
        if(checkStatusOfModeButton()){
            waitForElementClickable(driver, CreateEditPromoUI.APPLY_MODE);
            clickToElement(driver, CreateEditPromoUI.APPLY_MODE);
        }
    }

    public void chooseModeSimple(WebDriver driver){
        waitForElementClickable(driver, CreateEditPromoUI.APPLY_MODE);
        clickToElement(driver, CreateEditPromoUI.APPLY_MODE);
    }

    private boolean checkStatusOfModeButton() {
        return true;
    }

    public void clickSaveButton(WebDriver driver){
        waitForElementClickable(driver, CreateEditPromoUI.BUTTON_SAVE_PROMO);
        clickToElement(driver, CreateEditPromoUI.BUTTON_SAVE_PROMO);
    }

    public void clickTOAddPromoLevel(WebDriver driver){
        waitForElementClickable(driver, CreateEditPromoUI.ICON_ADD_PROMO_LEVEL);
        clickToElement(driver, CreateEditPromoUI.ICON_ADD_PROMO_LEVEL);
    }


    public String getPromotionNameDisplayOnPromoDetail() {
        return null;
    }
    public String getPromotionDescDisplayOnPromoDetail() {
        return null;
    }

    public Object getPromotionStatusDisplayOnPromoDetail() {
        return null;
    }

    public Object getPromotionLanguageDisplayOnPromoDetail() {
        return null;
    }


}
