package Interfaces.hahalolo_business.Tour.Management.Detail;

public class TourPromotionUI {
    // Header Tab Tour Promotion
    public static final String TOUR_PROMO_TAB = "//form[@id='promotions-form']";
    public static final String TOUR_PROMO_TAB_TITLE = "//form[@id='promotions-form']//h5";
    public static final String DATA_NOT_FOUND_MESSAGE = "//form[@id ='promotions-form']//td[@class ='text-center']";
    public static final String BUTTON_CREATE_PROMO = "//a[contains(@data-bind,'linkCreatePromotion()')]";

    // Item Promotion
    public static final String BUTTON_EDIT =  "//div[@class='infocard__name'][contains(text(),'%s')]/following-sibling::div//a[contains(@data-bind,'onLinkPromoDetail')]";
    public static final String BUTTON_REMOVE =  "//div[@class='infocard__name'][contains(text(),'%s')]/following-sibling::div//span[contains(@data-bind,'onDeletePromo')]";
    public static final String BUTTON_VIEW_ALL =  "//div[@class='infocard__name'][contains(text(),'%s')]/following-sibling::div//span[contains(@data-bind,'onDeletePromo')]";
    public static final String STATUS_PROMOTION = "//div[@class='infocard__name'][contains(text(),'%s')]/ancestor::td/following-sibling::td[@data-title = 'Status']";
    public static final String DATE_RANGE_ITEM = "//div[@class='infocard__name'][contains(text(),'%s')]/ancestor::td/following-sibling::td[@data-title = 'Time range']";
    public static final String VIEW_ALL_ITEM = "//div[@class='infocard__name'][contains(text(),'%s')]/ancestor::td/following-sibling::td[@data-title = 'Settings']//a[contains(@data-bind,'onViewMinOrderValue')]";
}
