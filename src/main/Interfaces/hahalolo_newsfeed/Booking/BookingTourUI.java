package Interfaces.hahalolo_newsfeed.Booking;

public class BookingTourUI {

    public static final String HEADER_TOUR_NAME = "//h3[contains(@data-bind,'temVM.tourVM.info().tv151')]";
    public static final String HEADER_TERM_CONDITION_LINK = "//h3[contains(@data-bind,'temVM.tourVM.info().tv151')]/following-sibling::div//a[contains(@data-bind,'terms')]";

    // Step 1
    public static final String BASIC_PRICE_ON_DETAIL_STEP1 = "//form[contains(@data-bind,'orderVM.itemVM.tourVM')]//div[contains(@data-bind, 'tn402')]";
    public static final String DEPARTURE_DATE_ON_DETAIL_STEP1 = "//form[contains(@data-bind,'orderVM.itemVM.tourVM')]//div[contains(@data-bind, 'od225')]";
    public static final String DESTINATION_ON_DETAIL_STEP1 = "//form[contains(@data-bind,'orderVM.itemVM.tourVM')]//ol[contains(@data-bind, 'foreach: destination')]/li";
    public static final String DEPARTURE_PLACE_ON_DETAIL_STEP1 = "//form[contains(@data-bind,'orderVM.itemVM.tourVM')]//div[contains(@data-bind, 'departure')]";

    public static final String PRICE_OF_TYPE_AGE = "//td[text()='%s']/following-sibling::td";

    public static final String BUTTON_CONTINUE_BOOKING = "//button[contains(@data-bind,'onNextStep')]";

    public static final String LEADER_PER_TITLE_DROPDOWN = "//select[contains(@data-bind, 'nv230')]/following-sibling::div//div[contains(@class, 'selectize-input')]";
    public static final String LEADER_PER_TITLE_ITEM = "//select[contains(@data-bind, 'nv230')]/following-sibling::div//div[@class ='selectize-dropdown-content']/div";

    public static final String DYNAMIC_FIELD_ON_LEADER_INFO = "//div[contains(@data-bind, 'orderVM.itemVM.leadPersonal.cid')]//input[@name = 'ov402']";
    public static final String REQUEST_NOTE_TEXTAREA = "//textarea[contains(@data-bind, 'ov210')]";
    public static final String CHECKBOX_TRAVEL_LEADER = "//input[@id = 'customCheck1']/following-sibling::label";

    public static final String NUMBER_PER_BY_TYPE_AGE = "//div[contains(text(),'%s')]/parent::div/following-sibling::div/div[@class = 'input-number']";

    public static final String DYNAMIC_FIELD_ON_ADULT_INFO = "//h6[text()='%s']/following-sibling::ul//li[position()='%s']//input[@name= '%s']";
    public static final String GENDER_DROPDOWN_ON_TRAVELLER = "//h6[text()='%s']/following-sibling::ul//li[position()='%s']//select[contains(@data-bind, 'ov404')]/following-sibling::div//div[contains(@class, 'selectize-input')]";
    public static final String GENDER_ITEM_ON_ADULT_INFO = "//h6[text()='%s']/following-sibling::ul//li[position()='1']//select[contains(@data-bind, 'ov404')]/following-sibling::div//div[@class ='selectize-dropdown-content']/div";


    public static final String DROPDOWN_CHOOSE_PERSON_BY_TYPE = "//div[contains(text(),'Người lớn:')]/parent::div/following-sibling::div/div[@class = 'input-number']";
}
