package Interfaces.hahalolo_business.Promotion;

public class PromotionUI {
    public static final String PROMOTION_LIST = "";
    public static final String PROMOTION_DETAIL = "";

    public static final String PROMOTION_NAME = "//input[@name ='promotionName']";
    public static final String PROMOTION_DESC = "//textarea[@name ='promotionDes']";
    public static final String BUTTON_ADD_PROMOTION_IMAGE  = "//button[contains(@data-bind,'uploadCover')]";
    public static final String PROMOTION_DATE_RANGE = "//input[@name ='startDate']";
    public static final String TYPE_DISCOUNT_TOTAL_ORDER = "//input[@id ='promo-type-1']/following-sibling::label";
    public static final String TYPE_DISCOUNT_PER_ADULT = "//input[@id ='promo-type-2']/following-sibling::label";
    public static final String PROMO_TYPE_FIX_AMOUNT = "//input[@id ='promotion-type-1']/following-sibling::label";
    public static final String PROMO_TYPE_PER_CENT = "//input[@id ='promotion-type-2']/following-sibling::label";

    public static final String DISCOUNT_AMOUNT = "//input[@name ='tn356']";
    public static final String MIN_ORDER_VALUE = "//input[@name ='tn358']";
    public static final String MIN_PER = "//input[@name ='tn361']";

    public static final String PROMOTION_STATUS = "//input[@id='public-promotion']/following-sibling::label";
    public static final String FORM_CREATE_EDIT_PROMO = "//div[contains(@data-bind,'with: promotionVM')]";
    public static final String BUTTON_ADD_PROMOTION_LEVEL  = "//button[contains(@data-bind,'addValuePromotion')]";
    public static final String APPLY_ADVANCED_MODE  = "//input[@id = 'apply-mode']/following-sibling::label";

    // PROMOTION NORMAL_MODE
    public static final String PROMOTION_NORMAL_MODEL = "//div[@class ='promotion-normal-mode']";
    public static final String SEARCH_TOUR_FIELD = "//input[contains(@data-bind,'onSearchTour')]";
    public static final String BUTTON_ADD_DIRECT_TOUR = "//div[contains(@data-bind,'tourName')][contains(text(),'Tour Vũng tàu - Phan thiết')]/parent::div/following-sibling::button";

    // PROMOTION AVDANCE_MODe
    public static final String PROMOTION_ADVANCE_MODEL = "//div[@class ='promotion-advance-mode']";

    public static final String CURRENCY_DROPDOWN = "";
    public static final String BUTTON_SAVE_PROMOTO = "";
    public static final String BUTTON_SEARCH_TOUR = "";
    public static final String TYPE_TOUR_OPTION = "";
    public static final String TOPIC_TOUR_OPTION = "";
    public static final String EXCEED_TOUR_ITEM = "";
    public static final String BUTTON_REMOVE_DIRECT_TOUR = "";
}
