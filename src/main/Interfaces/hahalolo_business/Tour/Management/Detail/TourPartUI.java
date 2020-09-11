package Interfaces.hahalolo_business.Tour.Management.Detail;

public class TourPartUI {
    public static final String TOUR_PART = "//div[@id ='tour-parts-list']";
    public static final String BUTTON_CREATE_NEW_PART = "//button[contains(@data-bind,'onCreatePart')]";

    // Tour part details
    public static final String TOUR_PART_DETAIL = "//div[@id ='tour-part-details']" ;
    public static final String DYNAMIC_FIELD = "//div[@id ='tour-part-details']//input[@name ='%s']";
    public static final String DYNAMIC_DROPDOWN = "//div[@id='tour-part-details']//select[@name='%s']/following-sibling::div//div[@class='item']";
    public static final String ITEM_DYNAMIC_DROPDOWN = "//div[@id='tour-part-details']//select[@name='%s']/following-sibling::div//div[@class='selectize-dropdown-content']/div[contains(@class,'option')]";
    public static final String SHORT_DESC_TEXT_AREA = "//div[@name = 'tv303'][contains(@data-bind,'editor-summernote')]//textarea/following-sibling::div";
    public static final String BUTTON_SAVE_PART = "//button[contains(@data-bind,'tourVM.onSavePart')]";
    public static final String UPLOAD_BUTTON = "//button[contains(@data-bind,'uploadCover')]" ;
    public static final String TRANSPORT_ITEM = "//div[contains(@data-bind,'transportions')]//input[@id ='%s']/following-sibling::label";
}
