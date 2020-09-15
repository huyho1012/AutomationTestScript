package Interfaces.hahalolo_business.Tour.Management.List;

public class TourManagementUI {
    public static final String BUTTON_START_CREATE_TOUR = "//table[@id='table-tour']//button[contains(@data-bind,'onCreateTour')]" ;
    public static final String BUTTON_CREATE_TOUR = "//div[@class='management-header']//button[contains(@data-bind,'onCreateTour')]" ;


    // Pop up create Tour
    public static final String POPUP_CREATE_TOUR = "//div[contains(@data-bind,'create')]//div[@id='modal__create-tour']";
    public static final String POPUP_CREATE_TOUR_TITLE = "//div[contains(@data-bind,'create')]//div[@id='modal__create-tour']//h2[@class='modal-title']";
    public static final String TOUR_NAME_FIELD = "//div[contains(@data-bind,'create')]//input[@name='tv151']";
    public static final String TOUR_TYPE_DROP_DOWN = "//div[contains(@data-bind,'create')]//select[@name='tn120']";
    public static final String TOUR_TOPIC_DROP_DOWN = "//div[contains(@data-bind,'create')]//select[@name='pt550']";
    public static final String BUTTON_SAVE = "//div[contains(@data-bind,'create')]//button[contains(@data-bind,'onSaveTour')]";
    public static final String DEFAULT_LANGUAGE = "//select[contains(@data-bind,'languages')]/option";
}
