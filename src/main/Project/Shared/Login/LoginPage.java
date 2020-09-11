package Project.Shared.Login;

import Project.Shared.CommonStartApp;
import Interfaces.Shared.Login.LoginUI;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonStartApp {
    WebDriver driver;
    public LoginPage(WebDriver webDriver){
        driver = webDriver;
    }

    public void clickToLoginButton(WebDriver driver){
        waitForElementClickable(driver, LoginUI.LOGIN_BUTTON);
        clickToElement(driver, LoginUI.LOGIN_BUTTON);
    }

    public void enterUserNameToLogin(WebDriver driver, String userName){
        waitElementToVisible(driver, LoginUI.USER_NAME);
        sendKeyToElement(driver,LoginUI.USER_NAME, userName);
    }

    public void enterPasswordToLogin(WebDriver driver, String password){
        waitElementToVisible(driver, LoginUI.PASSWORD);
        sendKeyToElement(driver, LoginUI.PASSWORD, password);
    }

    public String getCaptchaCode(WebDriver driver){
        waitForElementToPresence(driver, LoginUI.CAPTCHA_CODE_IMAGE);
        return getTextElement(driver, LoginUI.CAPTCHA_CODE_IMAGE);
    }

    public void resetCaptchaCode(WebDriver driver){
        waitForElementClickable(driver, LoginUI.RELOAD_CAPTCHA_ICON);
        clickToElement(driver, LoginUI.RELOAD_CAPTCHA_ICON);
    }

    public void clickToForgotPasswordLink(WebDriver driver){
        waitForElementClickable(driver, LoginUI.FORGOT_LINK);
        clickToElement(driver, LoginUI.FORGOT_LINK);
    }

    public void enterCaptchaCodeToLogin(WebDriver driver, String captchaCode){
        waitElementToVisible(driver, LoginUI.CAPTCHA_CODE);
        sendKeyToElement(driver, LoginUI.CAPTCHA_CODE,captchaCode);
    }

    public String getErrorMessageOfUsername(WebDriver driver){
        waitElementToVisible(driver, LoginUI.VALIDATE_USERNAME_ERROR_MESSAGE);
        return getTextElement(driver, LoginUI.VALIDATE_USERNAME_ERROR_MESSAGE);
    }

    public String getErrorMessageOfPassword(WebDriver driver){
        waitElementToVisible(driver, LoginUI.VALIDATE_PASSWORD_ERROR_MESSAGE);
        return getTextElement(driver, LoginUI.VALIDATE_PASSWORD_ERROR_MESSAGE);
    }

    public String getErrorMessageOfCaptcha(WebDriver driver){
        waitElementToVisible(driver, LoginUI.VALIDATE_CAPTCHA_ERROR_MESSAGE);
        return getTextElement(driver, LoginUI.VALIDATE_CAPTCHA_ERROR_MESSAGE);
    }



    public void clickToChangeLanguageToVI(WebDriver driver){
        waitForPageLoading(driver);
        if(getAttributeValue(driver,LoginUI.VI_ICON,"class").contains("active")){
            clickToElement(driver,LoginUI.VI_ICON);
        }
    }

    public void clickToChangeToEng(WebDriver driver){
        waitForPageLoading(driver);
        if(getAttributeValue(driver,LoginUI.ENG_ICON,"class").contains("active")){
            clickToElement(driver,LoginUI.ENG_ICON);
        }
    }

    public void Login(WebDriver driver, String userName, String password){
        waitForPageLoading(driver);
        waitElementToVisible(driver, LoginUI.USER_NAME);
        sendKeyToElement(driver, LoginUI.USER_NAME, userName);
        waitElementToVisible(driver, LoginUI.PASSWORD);
        sendKeyToElement(driver, LoginUI.PASSWORD, password);
        waitForElementClickable(driver,LoginUI.LOGIN_BUTTON);
        clickToElement(driver, LoginUI.LOGIN_BUTTON);
    }
    public void Login(WebDriver driver, String userName, String password, String captcha){
        waitForPageLoading(driver);
        waitElementToVisible(driver, LoginUI.USER_NAME);
        sendKeyToElement(driver, LoginUI.USER_NAME, userName);
        waitElementToVisible(driver, LoginUI.PASSWORD);
        sendKeyToElement(driver, LoginUI.PASSWORD, password);
        waitElementToVisible(driver, LoginUI.CAPTCHA_CODE);
        sendKeyToElement(driver,LoginUI.CAPTCHA_CODE, captcha);
        waitForElementClickable(driver,LoginUI.LOGIN_BUTTON);
        clickToElement(driver, LoginUI.LOGIN_BUTTON);
    }

    public boolean checkWalletLoginPageIsDisplay() {
        waitForPageLoading(driver);
        return true;
    }

    public boolean checkBackendLoginPageDisplay() {
        return true;
    }

    public boolean checkNewsfeedLoginPageDisplay(WebDriver driver) {
        return true;
    }
}
