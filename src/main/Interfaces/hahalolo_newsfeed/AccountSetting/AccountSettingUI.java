package Interfaces.hahalolo_newsfeed.AccountSetting;

public class AccountSettingUI {
    public static final String TITLE_PAGE = "//div[@id='%s']//div[@class = 'pageUI-about-heading']";
    public static final String ACCOUNT_SETTIGN_PAGE = "//section[@id = 'main-content']";
    // Full name section
    public static final String FULL_NAME = "//div[contains(@data-bind,'userProfileVM.fullName')]";
    public static final String FULLNAME_LOADING = "//div[contains(@data-bind,'userProfileVM.fullName')][contains(@data-bind,'!isLoading()')]" ;
    public static final String BUTTON_EDIT_FULLNAME =  "//div[contains(@data-bind,'userProfileVM.fullName')]/parent::div//following-sibling::div//i";
    public static final String ERR_MESSAGE_OF_FULNAME_FUNCTION = "//div[contains(@class,'invalid-feedback')]";

    // Form Update fullname
    public static final String FIRSTNAME_FIELD = "//input[@name = 'firstName']";
    public static final String ERR_VALIDATION_OF_FIRSTNAME = "//input[@name = 'firstName']/following-sibling::div";
    public static final String MIDDLENAME_FIELD = "//input[@name = 'middleName']";
    public static final String ERR_VALIDATION_OF_MIDDLENAME = "//input[@name = 'middleName']/following-sibling::div";
    public static final String LASTNAME_FIELD = "//input[@name = 'lastName']";
    public static final String ERR_VALIDATION_OF_LASTNAME = "//input[@name = 'lastName']/following-sibling::div";
    public static final String BUTTON_SAVE_CHANGES_FULLNAME = "//button[contains(@data-bind,'onConfirmSaveName')]";

    // Popup confirm password
    public static final String FORM_CONFIRM_PASS_FOR_CHANGING = "//div[@id = 'modalConfirmPw']";
    public static final String CONFIRM_PASS_FIELD = "//div[@id = 'modalConfirmPw']//input[@name = 'confirmPwd']";
    public static final String ERR_MESSAGE_CONFIRM_PASS = "//div[@id = 'modalConfirmPw']//input[@name = 'confirmPwd']/following-sibling::div[contains(@class, 'invalid-feedback')]";
    public static final String CONFIRM_BUTTON = "//button[@id = 'act-confirm-pwd']";
    public static final String BUTTON_CANCEL_UPDATE_FULLNAME = "//button[contains(@data-bind,'onCancelSaveName')]";
    public static final String BUTTON_CANCEL_CONFIRM_PASS = "//button[contains(@data-bind,'onSaveName')]/following-sibling::button";


    public static final String USERNAME = "//a[contains(@data-bind,'baseUrlUsername')]";

    public static final String BUTTON_EDIT_USERNAME = "//div[@id ='js_body_username']//i";
    public static final String USERNAME_FIELD = "//input[contains(@data-bind,'valUsername')]";
    public static final String VALIDATE_MESS_OF_USERNAME = "//div[@id ='jsLoadMsg']//span";
    public static final String BUTTON_SAVE_USERNAME = "//button[@id = 'js_btn_save_username']";
    public static final String BUTTON_CANCEL_CHANGE_USERNAME = "//button[@id = 'js_btn_save_username']/following-sibling::button";

    public static final String ICON_SUCCESS_CHANGE_USERNAME = "//div[@id='jsLoadMsg']/i[@class ='fa fa-check text-success']";
    public static final String ICON_ERROR_CHANGE_USERNAME = "//div[@id='jsLoadMsg']/i[@class ='ffa fa-times text-danger']";


    public static final String MENU_ACCOUNT_SETTING = "" ;
}
