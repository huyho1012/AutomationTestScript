package Interfaces.Shared.Login;

public class LoginUI {
    public static final String FORGOT_LINK = "//a[@class='forgotpw']";
    public static final String VI_ICON = "//span[text()= 'Tiếng Việt']";
    public static final String ENG_ICON = "//span[text()= 'English']";


    public static final String USER_NAME = "//input[@name = 'identity']";
    public static final String PASSWORD = "//input[@name = 'password']";
    public static final String CAPTCHA_CODE = "//input[@id='captchaCode']";
    public static final String RELOAD_CAPTCHA_ICON = "//button[contains(@data-bind,'refreshCaptcha')]";

    public static final String LOGIN_BUTTON ="//button[(text() = 'Đăng nhập')]";

    public static final String VALIDATE_USERNAME_ERROR_MESSAGE = "//input[@name = 'identity']/following-sibling::div";
    public static final String VALIDATE_PASSWORD_ERROR_MESSAGE = "//input[@name = 'password']/following-sibling::div";
    public static final String VALIDATE_CAPTCHA_ERROR_MESSAGE = "//input[@name = 'password']/following-sibling::div";

    public static final String CAPTCHA_CODE_IMAGE = "";
}
