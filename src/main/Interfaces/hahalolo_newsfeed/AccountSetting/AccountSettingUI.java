package Interfaces.hahalolo_newsfeed.AccountSetting;

public class AccountSettingUI {
    public static final String FULL_NAME = "//div[contains(@data-bind,'userProfileVM.fullName')]";
    public static final String TITLE_PAGE = "//div[@id='%s']//div[@class = 'pageUI-about-heading']";
    public static final String ACCOUNT_SETTIGN_PAGE = "//section[@id = 'main-content']";
    public static final String FULLNAME_LOADING = "//div[contains(@data-bind,'userProfileVM.fullName')][contains(@data-bind,'!isLoading()')]" ;
    public static final String BUTTON_EDIT_FULLNAME =  "//div[contains(@data-bind,'userProfileVM.fullName')]/parent::div//following-sibling::div//i";
    public static final String FIRSTNAME_FIELD = "//input[@name = 'firstName']";
    public static final String ERR_VALIDATION_OF_FIRSTNAME = "//input[@name = 'firstName']/following-sibling::div";
    public static final String MIDDLENAME_FIELD = "//input[@name = 'middleName']";
    public static final String ERR_VALIDATION_OF_MIDDLENAME = "//input[@name = 'middleName']/following-sibling::div";
    public static final String LASTNAME_FIELD = "//input[@name = 'lastName']";
    public static final String ERR_VALIDATION_OF_LASTNAME = "//input[@name = 'lastName']/following-sibling::div";

    public static final String BUTTON_SAVE_CHANGES_FULLNAME = "//button[contains(@data-bind,'onConfirmSaveName')]";
}
