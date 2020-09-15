package Interfaces.hahalolo_business.Tour.Management.Detail;

public class TourInfoUI {
    public static final String TAB_INFORMATION = "//div[@id='tour-information']";
    public static final String DYNAMIC_FIELD_TAB_INFO = "//div[@id='tour-information']//input[@name ='%s']";

    public static final String DYNAMIC_DROPDOWN = "//select[@name='%s']/following-sibling::div//input";
    public static final String ITEM_DYNAMIC_DROPDOWN = "//select[@name='%s']/following-sibling::div//div[@class='selectize-dropdown-content']/div[contains(@class,'option')][contains(text(),'%s')]";

    public static final String SHORT_DESC_TEXT_AREA = "//textarea[@name ='tv159']";
    public static final String DYNAMIC_TEXT_AREA = "//div[@name ='%s'][contains(@data-bind,'summernote')]//div[contains(@class,'note-editable')]";

    public static final String SAVE_TOUR_BUTTON = "//button[contains(@data-bind,'tourFormVM.onSaveInfo')]";


    public static final String UPLOAD_BUTTON = "//button[contains(@data-bind,'%s')]";
    public static final String LANGUAGE_DROPDOWN = "//select[contains(@data-bind,'langChoose')]/following-sibling::div//div[contains(@class,'selectize-input')]";
    public static final String LANGUAGE_ITEM = "//select[contains(@data-bind,'langChoose')]/following-sibling::div//div[@class ='option']" ;
    public static final String CURRENCY_DROPDOWN = "//select[contains(@data-bind,'currencyChoose')]/following-sibling::div//div[contains(@class,'selectize-input')]";
    public static final String CURRENCY_ITEM = "//select[contains(@data-bind,'currencyChoose')]/following-sibling::div//div[@class ='option']";
}
