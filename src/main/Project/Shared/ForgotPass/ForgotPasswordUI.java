package Project.Shared.ForgotPass;

public class ForgotPasswordUI {
    public static final String SEARCH_USERNAME_FIELD = "//input[@name = 'nv108']";
    public static final String SEARCH_USER_BUTTON = "//button[contains(@data-bind,'searchUser')]";
    public static final String CANCEL_FORGOT_BUTTON = "//button[contains(@data-bind,'cancelForgotPw')]";

    public static final String ERR_VALIDATE_USERNAME_FIELD = "//input[@name = 'nv108']/following-sibling::div[contains(@class,'invalid-feedback')]";
    public static final String NO_RESULT = "//div[contains(@data-bind,'dataVM.noResult')]";
    public static final String NO_RESULT_HEADER = "//div[contains(@data-bind,'dataVM.noResult')]/h6";
    public static final String NO_RESULT_CONTENT = "//div[contains(@data-bind,'dataVM.noResult')]/span";

    public static final String USERNAME_FIELD_DATA = "//input[contains(@data-bind,'dataVM.nv108')]";
    public static final String CONTINUE_STEP2 = "//button[contains(@data-bind,'sendCode')]";
    public static final String BACK_FIND_ACCOUNT_BUTTON = "//button[contains(@data-bind,'backFindAcc')]";

    public static final String USER_NAME_ON_FORGOT_FORM = "//b[contains(@data-bind,'dataVM.nv108')]";
    public static final String DYNAMIC_FIELD_ON_FORGOT_FORM = "//input[@name = '%s']";
    public static final String ERR_VALIDATE_DYNAMIC_FIELD_ON_FORGOT_FORM= "//input[@name = '%s']/following-sibling::div[contains(@class,'invalid-feedback')]";
    public static final String ERR_VALIDATE_CAPTCHA= "//span[contains(@class,'invalid-feedback')]/following-sibling::input[@name = 'captchaCode']";

    public static final String CAPTCHA_CODE_IMAGE = "//span[contains(@data-bind,'dataVM.captcha')]";
    public static final String RELOAD_CAPTCHA_ICON = "//button[contains(@data-bind,'dataVM.refreshCaptcha')]";
    public static final String SEND_CODE_AGAIN_BUTTON = "//button[contains(@data-bind,'sendCode')]";
    public static final String USER_NAME_ON_SEND_CODE = "//div[@id ='send-again']//b";

    public static final String CHANGE_PASS_BUTTON = "//button[contains(@data-bind,'changePwd')]";

}
