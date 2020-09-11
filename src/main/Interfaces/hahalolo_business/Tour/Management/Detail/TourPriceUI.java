package Interfaces.hahalolo_business.Tour.Management.Detail;

public class TourPriceUI {
    public static final String TOUR_PRICE = "//div[@id ='tour-prices-list']";
    public static final String BTN_CREATE_NEW_PRICE = "//button[contains(@data-bind,'onCreatePrice')]";
    public static final String TOUR_PRICE_DETAIL = "//form[@id ='tour-prices-details']";
    public static final String START_DATE_PRICE = "//input[@name ='td401']";
    public static final String ADULT_PRICE = "//input[@name ='tn402']";
    public static final String CHILD_PRICE = "//input[@name ='tn403']";
    public static final String CHILD_CHECKBOX = "//input[@type='checkbox'][contains(@data-bind,'priceVM.checkTn403')]";
    public static final String YOUNG_CHILD_PRICE = "///input[@name ='tn404']";
    public static final String YOUNG_CHILD_CHECKBOX = "//input[@type='checkbox'][contains(@data-bind,'priceVM.checkTn404')]";
    public static final String BABY_PRICE = "//input[@name ='tn417']";
    public static final String BABY_CHECKBOX = "//input[@type='checkbox'][contains(@data-bind,'priceVM.checkTn417')]";

    public static final String BTN_SAVE_PRICE = "//button[contains(@data-bind,'tourInfoVM.onSavePrice')]";
}
