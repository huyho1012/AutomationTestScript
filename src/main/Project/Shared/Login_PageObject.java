package Project.Shared;

import Interfaces.hahalolo_newsfeed.StartApp.Login_PageUI;
import Interfaces.hahalolo_newsfeed.StartApp.RegisterAccount_PageUI;
import Interfaces.hahalolo_newsfeed.StartApp.StartingCommonUI;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.WebDriver;

public class Login_PageObject extends CommonStartApp {
    WebDriver driver;

    public Login_PageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public void clickToLoginButton(){
        waitForElementClickable(driver, Login_PageUI.LOGIN_BUTTON);
        clickToElement(driver, Login_PageUI.LOGIN_BUTTON);
    }

    public void enterUserNameToLogin(String userName){
        waitElementToVisible(driver, Login_PageUI.USER_NAME_FIELD);
        sendKeyToElement(driver, Login_PageUI.USER_NAME_FIELD, userName);
    }

    public void enterPasswordToLogin(String password){
        waitElementToVisible(driver, Login_PageUI.PASSWORD_FIELD);
        sendKeyToElement(driver, Login_PageUI.PASSWORD_FIELD, password);
    }

    public String getCaptchaCode(){
        waitForElementToPresence(driver, Login_PageUI.CAPTCHA_CODE_IMAGE);
        return getTextElement(driver, Login_PageUI.CAPTCHA_CODE_IMAGE);
    }

    public void resetCaptchaCode(){
        waitForElementClickable(driver, Login_PageUI.RELOAD_CAPTCHA_ICON);
        clickToElement(driver, Login_PageUI.RELOAD_CAPTCHA_ICON);
    }

    public void clickToForgotPasswordLink(){
        waitForElementClickable(driver, Login_PageUI.FORGOT_LINK);
        clickToElement(driver, Login_PageUI.FORGOT_LINK);
    }

    public void enterCaptchaCodeToLogin(String captchaCode){
        waitElementToVisible(driver, Login_PageUI.CAPTCHA_CODE_FIELD);
        sendKeyToElement(driver, Login_PageUI.CAPTCHA_CODE_FIELD,captchaCode);
    }

    public String getMessageOfUsernameField(){
        waitElementToVisible(driver, Login_PageUI.VALIDATE_USERNAME_ERROR_MESSAGE);
        return getTextElement(driver, Login_PageUI.VALIDATE_USERNAME_ERROR_MESSAGE);
    }

    public String getMessageOfPasswordField(){
        waitElementToVisible(driver, Login_PageUI.VALIDATE_PASSWORD_ERROR_MESSAGE);
        return getTextElement(driver, Login_PageUI.VALIDATE_PASSWORD_ERROR_MESSAGE);
    }

    public String getErrorMessageOfCaptcha(){
        waitElementToVisible(driver, Login_PageUI.VALIDATE_CAPTCHA_ERROR_MESSAGE);
        return getTextElement(driver, Login_PageUI.VALIDATE_CAPTCHA_ERROR_MESSAGE);
    }

    public void LoginNewsfeedHahalolo(String userName, String password){
       if(checkNewsfeedLoginPageIsDisplayed()){
           sendKeyToElement(driver, Login_PageUI.USER_NAME_FIELD, userName);
           sendKeyToElement(driver, Login_PageUI.PASSWORD_FIELD, password);
           clickToElement(driver, Login_PageUI.LOGIN_BUTTON);
       }
    }

    public void LoginBackendHahalolo(String userName, String password, String captcha){
        if(checkBackendLoginPageDisplay()){
            sendKeyToElement(driver, Login_PageUI.USER_NAME_FIELD, userName);
            sendKeyToElement(driver, Login_PageUI.PASSWORD_FIELD, password);
            sendKeyToElement(driver, Login_PageUI.CAPTCHA_CODE_FIELD, captcha);
            clickToElement(driver, Login_PageUI.LOGIN_BUTTON);
        }
    }

    public void LoginCensorHahalolo(String userName, String password, String captcha){
        if(checkCensorLoginPageDisplay()){
            sendKeyToElement(driver, Login_PageUI.USER_NAME_FIELD, userName);
            sendKeyToElement(driver, Login_PageUI.PASSWORD_FIELD, password);
            sendKeyToElement(driver, Login_PageUI.CAPTCHA_CODE_FIELD, captcha);
            clickToElement(driver, Login_PageUI.LOGIN_BUTTON);
        }
    }

    public void LoginWalletHahalolo(String userName, String password, String captcha){
        if(checkWalletLoginPageIsDisplay()){
            sendKeyToElement(driver, Login_PageUI.USER_NAME_FIELD, userName);
            sendKeyToElement(driver, Login_PageUI.PASSWORD_FIELD, password);
            sendKeyToElement(driver, Login_PageUI.CAPTCHA_CODE_FIELD, captcha);
            clickToElement(driver, Login_PageUI.LOGIN_BUTTON);
        }
    }

    public void LoginNewsfeedHahaloloByUsingExcelFile(XSSFRow row){
        if(checkNewsfeedLoginPageIsDisplayed()== true){
            sendKeyToElement(driver, Login_PageUI.USER_NAME_FIELD,row.getCell(2).toString());
            sendKeyToElement(driver, Login_PageUI.PASSWORD_FIELD, row.getCell(3).toString());
            clickToElement(driver, Login_PageUI.LOGIN_BUTTON);
        }
    }

    public boolean checkWalletLoginPageIsDisplay() {
       waitElementToVisible(driver, Login_PageUI.FORM_LOGIN_WALLET);
        return getCurrentURL(driver).equalsIgnoreCase("https://test-wallet.hahalolo.com/auth/signin");
    }

    public boolean checkBackendLoginPageDisplay() {
        waitElementToVisible(driver, Login_PageUI.FORM_LOGIN_BACKEND_CENSOR);
        return getCurrentURL(driver).equalsIgnoreCase("https://test-backend.hahalolo.com/auth/signin");
    }

    public boolean checkCensorLoginPageDisplay() {
        waitElementToVisible(driver, Login_PageUI.FORM_LOGIN_BACKEND_CENSOR);
        return getCurrentURL(driver).equalsIgnoreCase("https://test-censor.hahalolo.com/auth/signin");
    }

    public boolean checkNewsfeedLoginPageIsDisplayed() {
        waitElementToVisible(driver, RegisterAccount_PageUI.FORM_REGISTER_ACCOUNT);
        return getCurrentURL(driver).equalsIgnoreCase("https://test-newsfeed.hahalolo.com/auth/signin");
    }

}
