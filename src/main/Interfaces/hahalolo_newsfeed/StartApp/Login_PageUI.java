package Interfaces.hahalolo_newsfeed.StartApp;

public class Login_PageUI {

    public static final String FORM_LOGIN_BACKEND_CENSOR = "//signin-signup//div[@class = 'card-body']";
    public static final String FORM_LOGIN_WALLET = "//form[@id = 'signin_form']";

    public static final String FORGOT_LINK = "//a[@class='forgotpw']";

    public static final String USER_NAME_FIELD = "//input[@name = 'identity']";
    public static final String PASSWORD_FIELD = "//input[@name = 'password']";
    public static final String CAPTCHA_CODE_FIELD = "//input[@id='captchaCode']";
    public static final String RELOAD_CAPTCHA_ICON = "//button[contains(@data-bind,'refreshCaptcha')]";

    public static final String LOGIN_BUTTON ="//button[(text() = 'Đăng nhập')]";

    public static final String VALIDATE_USERNAME_ERROR_MESSAGE = "//input[@name = 'identity']/following-sibling::div";
    public static final String VALIDATE_PASSWORD_ERROR_MESSAGE = "//input[@name = 'password']/following-sibling::div";
    public static final String VALIDATE_CAPTCHA_ERROR_MESSAGE = "//input[@id = 'captchaCode']/following-sibling::div";

    public static final String CAPTCHA_CODE_IMAGE = "";
}
