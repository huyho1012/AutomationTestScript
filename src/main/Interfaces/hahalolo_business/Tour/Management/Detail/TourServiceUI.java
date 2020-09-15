package Interfaces.hahalolo_business.Tour.Management.Detail;

public class TourServiceUI {
    public static final String SERVICE_TAB = "//form[@id='services-form']" ;
    public static final String BUTTON_UPDATE_SERVICE = "//button[contains(@data-bind,'onSaveServices')]" ;
    public static final String TOUR_SERVICE_ITEM = "//div[contains(@data-bind,'tourService')]/div[position()='%s']//label";
    public static final String TOUR_SERVICE_LIST = "//div[contains(@data-bind,'tourService')]";
    public static final String HALO_SERVICE_ITEM = "//div[contains(@data-bind,'haloService')]/div[position()='%s']//label";
    public static final String HALO_SERVICE_LIST = "//div[contains(@data-bind,'haloService')]";
}
