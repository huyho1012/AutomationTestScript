package Interfaces.hahalolo_business.Tour.Management.Detail;

public class TourServicePriceUI {
    public static final String TAB_PRICE_SERVICE = "//div[@id = 'tour-service-price']" ;
    public static final String TITLE_TAB_PRICE_SERVICE ="//div[@id = 'tour-service-price']/h5";
    public static final String BUTTON_CREATE_PRICE = "//button[contains(@data-bind,'onAddServicePrice')]";
    public static final String SERVICE_PRICE_FIELD = "//div[contains(@class,'list-group')]/div[contains(@class,'list-group-item')][position()='1']//input[@name = 'price']";
    public static final String SERVICE_DROP_LiST = "//div[contains(@class,'list-group')]/div[contains(@class,'list-group-item')][position()='1']//select[@name = 'pt250']/following-sibling::div/div[contains(@class ,'selectize-input ')]";
    public static final String SERVICE_DROP_ITEM = "//select[@name = 'pt250']/following-sibling::div//div[contains(@class ,'option')]";

    public static final String SELECTED_SERIVCE =   "//div[contains(@class,'serfac-list__item')]";
    public static final String SERVICE_PRICE_LIST = "//div[contains(@class,'list-group-item')]";
}
