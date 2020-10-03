package Interfaces.hahalolo_newsfeed.PersonaWall.About;

public class PerAbout_ContactAndBasicInfo_PageUI {

    public static final String CONTACT_AND_BASIC_INFO_TAB = "//div[@id = 'about_contact'][contains(@class ,'active')]";
    public static final String TITLE_PAGE = "//div[@id = 'about_contact']//div[contains(@data-bind,'contactInfo')]";
    // Section Main phone
    public static final String MAIN_PHONE_DATA = "//div[@id = 'main-phone']";
    public static final String BUTTON_ADD_NEW_MAIN_PHONE = "//div[contains(@data-bind,'doOpen.formAddPhone')]";
    public static final String ICON_EDIT_MAIN_PHONE = "//button[contains(@data-bind,'doOpen.formAddPhone')]";
    public static final String MAIN_PHONE_FIELD = "//input[@name = 'nv217']";
    public static final String MAIN_PHONE_ERROR_MESSAGE = "//input[@name = 'nv217']/following-sibling::div";

    public static final String BUTTON_ADD_OTHER_PHONE = "//a[contains(@data-bind,'formOtherPhone')]";
    public static final String LIST_OTHER_PHONE = "//a[@id = 'act-add-form-phone-number']/following-sibling::div";
    public static final String OTHER_PHONE_FIELD = "//a[@id = 'act-add-form-phone-number']/following-sibling::div[position()= '%s']//input[@name = 'nv216']";
    public static final String OTHER_PHONE_ERROR_MESSAGE = "//a[@id = 'act-add-form-phone-number']/following-sibling::div[position()= '%s']//input[@name = 'nv216']/following-sibling::div";
    public static final String BUTTON_REMOVE_OTHER_PHONE = "//a[@id = 'act-add-form-phone-number']/following-sibling::div[position()= '%s']//input[@name = 'nv216']/following-sibling::a";

    public static final String BUTTON_SAVE_PHONE = "//button[@id = 'act-add-phone']";
    public static final String BUTTON_CANCEL_SAVE_CHANGE_PHONE = "//button[contains(@data-bind,'doCancel.addPhone')]";

    // Section Address
    public static final String ICON_EDIT_ADDRESS = "//button[contains(@data-bind,'doOpen.formAddAddress')]";
    public static final String BUTTON_ADD_ADDRESSS = "//div[contains(@data-bind,'doOpen.formAddAddress')]";
    public static final String ADDRESS_DATA = "//div[contains(@data-bind,'contactAndBasicInfoVM.nv218')]";
    public static final String ADDRESS_FIELD = "//input[@name = 'nv218']";
    public static final String ADDRESS_ERROR_MESSAGE = "//input[@name = 'nv218']/following-sibling::div";
    public static final String CITY_FIELD = "//input[@name = 'nv219']";
    public static final String CITY_ERROR_MESSAGE = "//input[@name = 'nv219']/following-sibling::div";
    public static final String AREA_CODE_FIELD = "//input[@name = 'nv220']";
    public static final String BUTTON_SAVE_ADDRESS = "//button[@id = 'act-add-address']";
    public static final String BUTTON_CANCEL_SAVE_ADDRESS = "//button[contains(@data-bind, 'doCancel.addAddress')]";

    // Section birthday
    public static final String BIRTHDAY_DATA = "//div[contains(@data-bind,'contactAndBasicInfoVM.nd206')]";
    public static final String ICON_EDIT_BIRTHDAY = "//button[contains(@data-bind, 'doOpen.formEditBirthday')]";
    public static final String BIRTHDAY_FIELD = "//input[@name = 'nd206']";
    public static final String BIRTHDAY_ERROR_MESSAGE = "//input[@name = 'nd206']/following-sibling::div";
    public static final String SCOPE_DROPDOWN_OF_BIRTHDAY = "//div[contains(@data-bind,'isShowFormAddBirthday')]//button[@data-toggle ='dropdown']";
    public static final String SCOPE_ITEM_OF_BIRTHDAY = "//div[contains(@data-bind,'isShowFormAddBirthday')]//div[@class = 'dropdown-item']";
    public static final String BUTTON_SAVE_BIRTHDAY = "//button[contains(@data-bind, 'doAdd.birthDay')]";
    public static final String BUTTON_CANCEL_SAVE_BIRTHDAY = "//button[contains(@data-bind, 'doCancel.addBirthday')]";

    // Section gender
    public static final String GENDER_DATA = "//div[contains(@data-bind,'contactAndBasicInfoVM.gender')]";
    public static final String ICON_EDIT_GENDER = "//button[contains(@data-bind, 'doOpen.formEditGender')]";
    public static final String GENDER_DROPDOWN = "//select[contains(@data-bind, 'contactAndBasicInfoVM.nv207')]";
    public static final String BUTTON_SAVE_GENDER = "//button[contains(@data-bind, 'doAdd.gender')]";
    public static final String BUTTON_CANCEL_SAVE_GENDER = "//button[contains(@data-bind, 'doCancel.addGender')]";


}



