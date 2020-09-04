package Interfaces.Business.Tour.Management;

public class TourInfoTabUI {

    public static final String SKU_FIELD = "//input[@name ='tv102']";
    public static final String TOTAL_DAY_FIELD = "//input[@name ='tn123']";
    public static final String BASIC_PRICE_FIELD = "//input[@name ='tn133']" ;
    public static final String ALLOW_BOOKING_FIELD = "//input[@name ='tn130']";
    public static final String ADDRESS_FIELD = "//input[@name ='address']" ;

    public static final String COUNTRY_DROPDOWN = "//select[@name='country']";
    public static final String COUNTRY_ITEM = "//select[@name='country']/following-sibling::div//div[@class='selectize-dropdown-content']/div[contains(@class,'option')]";
    public static final String CITY_DROPDOWN = "//select[@name='city']";
    public static final String CITY_ITEM = "//select[@name='city']/following-sibling::div//div[@class='selectize-dropdown-content']/div[contains(@class,'option')]";
    public static final String WARD_DROPDOWN = "//select[@name='region']";
    public static final String WARD_ITEM = "//select[@name='region']/following-sibling::div//div[@class='selectize-dropdown-content']/div[contains(@class,'option')]";

    public static final String SHORT_DESC_TEXT_AREA = "//textarea[@name ='tv159']";
    public static final String REGULATION_TEXT_AREA = "//div[@name ='tv152'][contains(@data-bind,'summernote')]//div[contains(@class,'note-editable')]";
    public static final String POLICY_TEXT_AREA = "//div[@name ='tv153'][contains(@data-bind,'summernote')]//div[contains(@class,'note-editable')]";
    public static final String INSTALLMENT_POLICY_TEXT_AREA = "//div[@name ='tv155'][contains(@data-bind,'summernote')]//div[contains(@class,'note-editable')]";

    public static final String SAVE_TOUR_BUTTON = "//button[contains(@data-bind,'tourFormVM.onSaveInfo')]";

    public static final String UPLOAD_LOGO_BUTTON = "//button[contains(@data-bind,'uploadLogo')]";
    public static final String UPLOAD_COVER_BUTTON = "//button[contains(@data-bind,'uploadCover')]";
    public static final String UPLOAD_GALLERY_BUTTON = "//button[contains(@data-bind,'uploadGalleries')]";


}
