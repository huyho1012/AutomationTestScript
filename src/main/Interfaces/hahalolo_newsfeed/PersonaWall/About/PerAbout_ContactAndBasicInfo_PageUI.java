package Interfaces.hahalolo_newsfeed.PersonaWall.About;

public class PerAbout_ContactAndBasicInfo_PageUI {

    public static final String CONTACT_AND_BASIC_INFO_TAB = "//div[@id = 'about_contact'][contains(@class ,'active')]";
    public static final String TITLE_PAGE = "//div[@id = 'about_contact']//div[contains(@data-bind,'contactInfo')]" ;
    // Section Main phone
    public static final String MAIN_PHONE_DATA = "";
    public static final String BUTTON_ADD_NEW_MAIN_PHONE = "";
    public static final String ICON_EDIT_MAIN_PHONE = "";
    public static final String MAIN_PHONE_FIELD = "";
    public static final String MAIN_PHONE_ERROR_MESSAGE = "";

    public static final String BUTTON_ADD_OTHER_PHONE = "";
    public static final String OTHER_PHONE_FIELD = "";
    public static final String OTHER_PHONE_ERROR_MESSAGE = "";
    public static final String BUTTON_REMOVE_OTHER_PHONE = "";

    public static final String BUTTON_SAVE_PHONE = "";
    public static final String BUTTON_CANCEL_SAVE_CHANGE_PHONE = "";

    // Section Address
    public static final String ICON_EDIT_ADDRESS = "";
    public static final String BUTTON_ADD_ADDRESSS = "//div[contains(@data-bind, 'doOpen.formAddAddress')]";
    public static final String ADDRESS_DATA = "";
    public static final String ADDRESS_FIELD = "//input[@name = 'nv218']" ;
    public static final String ADDRESS_ERROR_MESSAGE = "//input[@name = 'nv218']/following-sibling::div";
    public static final String CITY_FIELD = "//input[@name = 'nv219']" ;
    public static final String CITY_ERROR_MESSAGE = "//input[@name = 'nv219']/following-sibling::div";
    public static final String AREA_CODE_FIELD = "//input[@name = 'nv220']" ;
    public static final String BUTTON_SAVE_ADDRESS = "//button[contains(@data-bind, 'doAdd.address')]";
    public static final String BUTTON_CANCEL_SAVE_ADDRESS = "//button[contains(@data-bind, 'doCancel.addAddress')]";

    // Section Email
    public static final String EMAIL_DATA = "//div[@class='col']//div[contains(@data-bind,'contactAndBasicInfoVM.nv215')]";
    public static final String BUTTON_ADD_EMAIL ="";
    public static final String EMAIL_FIELD = "";
    public static final String EMAIL_ERROR_MESSAGE = "";
    public static final String BUTTON_SAVE_EMAIL = "";
    public static final String BUTTON_CANCEL_SAVE_EMAIL = "";

    // Section birthday
    public static final String BIRTHDAY_DATA = "//div[contains(@data-bind,'contactAndBasicInfoVM.nd206')]";
    public static final String ICON_EDIT_BIRTHDAY = "//button[contains(@data-bind, 'doOpen.formEditBirthday')]" ;
    public static final String BIRTHDAY_FIELD = "//input[@name = 'nd206']";
    public static final String BIRTHDAY_ERROR_MESSAGE = "//input[@name = 'nd206']/following-sibling::div";
    public static final String BUTTON_SAVE_BIRTHDAY = "//button[contains(@data-bind, 'doAdd.birthDay')]";
    public static final String BUTTON_CANCEL_SAVE_BIRTHDAY = "//button[contains(@data-bind, 'doCancel.addBirthday')]";

    // Section gender
    public static final String GENDER_DATA = "//div[contains(@data-bind,'contactAndBasicInfoVM.gender')]";
    public static final String ICON_EDIT_GENDER = "//button[contains(@data-bind, 'doOpen.formEditGender')]" ;
    public static final String GENDER_DROPDOWN = "//select[contains(@data-bind, 'contactAndBasicInfoVM.nv207')]";
    public static final String BUTTON_SAVE_GENDER = "//button[contains(@data-bind, 'doAdd.gender')]";
    public static final String BUTTON_CANCEL_SAVE_GENDER = "//button[contains(@data-bind, 'doCancel.addGender')]";



}
