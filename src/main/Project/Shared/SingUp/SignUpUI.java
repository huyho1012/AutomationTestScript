package Project.Shared.SingUp;

public class SignUpUI {
    public static final String TITLE_REGISTER_FORM = "//div[@class = 'form-signup-header']/div";
    public static final String TEXT_FIELD_DYNAMIC = "//input[@name = '%s']";
    public static final String ERROR_MESSAGE_OF_TEXT_FIELD = "//input[@name = '%s']/following-sibling::*[contains(@class,'invalid-feedback')]";
    public static final String PHONE_CODE_DROPDOWN="//select[@id = 'select-phone-code']";
    public static final String PHONE_CODE_ITEM="//select[@id = 'select-phone-code']/following-sibling::div//div[@class = 'item']";

    public static final String SIGNUP_BUTTON = "//button[@id='signUpButton']";
    public static final String ERROR_MESS_PHONE_AREA = "//select[@id = 'select-phone-code']/following-sibling::div[contains(@class,'invalid-feedback')]";
    public static final String CREATED_USERNAME = "//p[contains(@data-bind, 'dataVM.nv108')]/b";
    public static final String TITLE_FORM_VERIFY_ACCOUNT ="//h3[contains(@data-bind,'dataVM.type_acc')]";

    // Mailinator
    public static final String SEARCH_EMAIL_FIELD = "//input[@id = 'addOverlay']";
    public static final String BUTTON_SEARCH_EMAIL = "//button[@id = 'go-to-public']";
    public static final String EMAIL_VERIFY =  "//tr[contains(@id,'%s')][1]/td[3]";
    public static final String IFRAME_EMAIL = "//iframe[@id='msg_body']" ;
    public static final String VERIFY_CODE = "//td/h2";

    public static final String VERIFY_CODE_FIELD = "//input[@name ='code']";
    public static final String VERIFY_ACCOUNT_BUTTON = "//button[contains(@data-bind,'verifyAcc')]";
    public static final String BUTTON_RESEND_CODE = "//button[@id = 'btnResendCode']" ;
}