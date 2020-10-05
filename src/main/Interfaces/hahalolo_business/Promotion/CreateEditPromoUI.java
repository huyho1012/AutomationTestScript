package Interfaces.hahalolo_business.Promotion;

public class CreateEditPromoUI {
    //
    public static final String TITlE_HEADER = "//div[@class='management-header__title']";
    //Basic Promotion Info
    public static final String PROMO_STATUS_MODE = "//input[@id='public-promotion']/following-sibling::label";
    public static final String PROMO_NAME_FIELD = "//input[@name ='promotionName']";
    public static final String PROMO_DESC_TEXTAREA = "//textarea[@name ='promotionDes']";
    public static final String BUTTON_ADD_PROMO_IMAGE = "//button[contains(@data-bind,'uploadCover')]";
    public static final String LANGUAGE_DROPDOWN = "//select[contains(@data-bind,'langChoose')]/following-sibling::div[contains(@class,'selectize-control')]";
    public static final String LANGUAGE_ITEM = "//select[contains(@data-bind,'langChoose')]/following-sibling::div//div[@class ='option']" ;
    public static final String CURRENCY_DROPDOWN = "//select[contains(@data-bind,'listCurrency')]/following-sibling::div[contains(@class,'selectize-control')]";
    public static final String CURRENCY_ITEM = "//select[contains(@data-bind,'listCurrency')]/following-sibling::div//div[@class ='option']";
    public static final String PROMOTION_DATE_RANGE = "//input[@name ='startDate']";
    public static final String APPLY_MODE = "//input[@id = 'apply-mode']/following-sibling::label";

    public static final String BUTTON_SAVE_PROMO = "//button[contains(@data-bind,'savePromotion')]";
    public static final String PROMOTION_SIMPLE_MODE = "//div[@class ='promotion-normal-mode']";

    // Type Discount
    public static final String DISCOUNT_TOTAL_ORDER = "//input[@id ='promo-type-1']/following-sibling::label";
    public static final String DISCOUNT_PER_ADULT = "//input[@id ='promo-type-2']/following-sibling::label";
    // Type Promotion
    public static final String FIXED_AMOUNT = "//input[@id ='promotion-type-1']/following-sibling::label";
    public static final String PERCENT_ORIGINAL_PRICE = "//input[@id ='promotion-type-2']/following-sibling::label";
    // Discount PromoInfo
    public static final String DISCOUNT_AMOUNT = "//input[@name ='tn356']";
    public static final String MIN_ORDER_VALUE = "//input[@name ='tn358']";
    public static final String MIN_ADULT_PEOPLE = "//input[@name ='tn361']";
    public static final String ICON_ADD_PROMO_LEVEL = "//button[contains(@data-bind,'addValuePromotion')]";
    public static final String REMOVE_PROMOTION_DISCOUNT_LEVEL = "//button[contains(@data-bind,'removeValuePromotion')]";

    // PROMOTION NORMAL_MODE
    public static final String PROMOTION_NORMAL_MODEL = "//div[@class ='promotion-normal-mode']";
    public static final String SEARCH_TOUR_FIELD = "//input[contains(@data-bind,'onSearchTour')]";
    public static final String ICON_ADD_DIRECT_TOUR = "//div[contains(@data-bind,'tourName')][contains(text(),'%s')]/parent::div/following-sibling::button";
    public static final String ICON_REMOVE_DIRECT_TOUR = "//div[contains(@data-bind,'tourName')][contains(text(),'%s')]/parent::div/following-sibling::button";

    public static final String LIST_TOUR_ITEM = "//span[contains(text(),'Danh sách Tour')]/ancestor::div[contains(@class,'form-group')]/following-sibling::ul";
    public static final String COUNT_TOUR = "//span[contains(text(),'Danh sách Tour')]//following-sibling::span";

    // PROMOTION AVDANCE_MODe
    public static final String PROMOTION_ADVANCE_MODEL = "//div[@class ='promotion-advance-mode']";



    public static final String BUTTON_SEARCH_TOUR = "";
    public static final String TYPE_TOUR_OPTION = "";
    public static final String TOPIC_TOUR_OPTION = "";
    public static final String EXCEED_TOUR_ITEM = "";
    public static final String BUTTON_REMOVE_DIRECT_TOUR = "";
}
