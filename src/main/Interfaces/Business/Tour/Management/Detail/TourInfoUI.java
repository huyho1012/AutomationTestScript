package Interfaces.Business.Tour.Management.Detail;

public class TourInfoUI {

    public static final String DYNAMIC_FIELD_TAB_INFO = "//input[@name ='%s']";

    public static final String DYNAMIC_DROPDOWN = "//select[@name='%s']";
    public static final String ITEM_DYNAMIC_DROPDOWN = "//select[@name='%s']/following-sibling::div//div[@class='selectize-dropdown-content']/div[contains(@class,'option')]";

    public static final String SHORT_DESC_TEXT_AREA = "//textarea[@name ='tv159']";
    public static final String DYNAMIC_TEXT_AREA = "//div[@name ='tv152'][contains(@data-bind,'summernote')]//div[contains(@class,'note-editable')]";

    public static final String SAVE_TOUR_BUTTON = "//button[contains(@data-bind,'tourFormVM.onSaveInfo')]";

    public static final String UPLOAD_LOGO_BUTTON = "//button[contains(@data-bind,'uploadLogo')]";
    public static final String UPLOAD_COVER_BUTTON = "//button[contains(@data-bind,'uploadCover')]";
    public static final String UPLOAD_GALLERY_BUTTON = "//button[contains(@data-bind,'uploadGalleries')]";


}
