package Project.Shared.SingUp;

import Project.Shared.CommonStartApp;
import Interfaces.Shared.SignUp.SignUpUI;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


public class SignUpPage extends CommonStartApp {
    WebDriver driver;
    public SignUpPage(WebDriver webDriver){
        driver = webDriver;
    }

    public String getTitleOfFormSignUp(WebDriver driver){
        waitElementToVisible(driver, SignUpUI.TITLE_REGISTER_FORM);
        return getTextElement(driver, SignUpUI.TITLE_REGISTER_FORM);
    }

    public void enterDataValueToDynamicOnFormSignUp(WebDriver driver, String nameField , String dataValue){
        waitElementToVisible(driver, SignUpUI.TEXT_FIELD_DYNAMIC, nameField);
        sendKeyToElement(driver, SignUpUI.TEXT_FIELD_DYNAMIC, dataValue, nameField);
        setTimeDelay(1);
    }

    public void choosePhoneCode(WebDriver driver, String phoneName){
        waitForElementClickable(driver,SignUpUI.PHONE_CODE_DROPDOWN);
        selectItemInCustomDropdown(driver,SignUpUI.PHONE_CODE_DROPDOWN,SignUpUI.PHONE_CODE_ITEM,phoneName);
        setTimeDelay(1);
    }

    public String getValidErrMessageOfDynamicOnFormSignUp(WebDriver driver, String nameField){
        waitElementToVisible(driver, SignUpUI.ERROR_MESSAGE_OF_TEXT_FIELD, nameField);
        return getTextElement(driver, SignUpUI.ERROR_MESSAGE_OF_TEXT_FIELD, nameField);
    }

    public void clickSignUpButton(){
        waitForElementClickable(driver, SignUpUI.SIGNUP_BUTTON);
        clickToElement(driver, SignUpUI.SIGNUP_BUTTON);
        setTimeDelay(1);
    }

    public String getErrMessageOfPhoneCode(WebDriver driver){
        waitElementToVisible(driver, SignUpUI.ERROR_MESS_PHONE_AREA);
        return getTextElement(driver, SignUpUI.ERROR_MESS_PHONE_AREA);
    }

    public String getUserAccountToDisplay(){
        waitElementToVisible(driver, SignUpUI.CREATED_USERNAME);
        return getTextElement(driver, SignUpUI.CREATED_USERNAME );
    }

    public String getTitleOfVerifyForm(){
        waitElementToVisible(driver, SignUpUI.TITLE_FORM_VERIFY_ACCOUNT);
        return getTextElement(driver, SignUpUI.TITLE_FORM_VERIFY_ACCOUNT);
    }



    public void enterVerifyCodeToVerifyAccount(WebDriver driver, String verifyCode){
        waitElementToVisible(driver, SignUpUI.VERIFY_CODE_FIELD);
        sendKeyToElement(driver,SignUpUI.VERIFY_CODE_FIELD,verifyCode);
        setTimeDelay(1);
    }

    public void clickToVerifyAccount(WebDriver driver){
        waitForElementClickable(driver, SignUpUI.VERIFY_ACCOUNT_BUTTON);
        clickToElement(driver, SignUpUI.VERIFY_ACCOUNT_BUTTON);
        setTimeDelay(1);
    }

    public void clickToResendCodeOnVerificationPage(WebDriver driver){
        waitForElementClickable(driver, SignUpUI.BUTTON_RESEND_CODE);
        clickToElement(driver,SignUpUI.BUTTON_RESEND_CODE);
        setTimeDelay(1);
    }


    public boolean checkVerifyPageDisplay() {
        if(checkElementDisplay(driver, SignUpUI.VERIFY_ACCOUNT_FORM_PAGE) && getPageTitle(driver).equals("Kích hoạt tài khoản | Hahalolo")){
            return true;
        }
        return false;
    }


    public String getVerifyCodeByEmail(String email){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        openNewWindow(driver, "https://www.mailinator.com/");
        waitElementToVisible(driver, SignUpUI.SEARCH_EMAIL_FIELD);
        sendKeyToElement(driver, SignUpUI.SEARCH_EMAIL_FIELD, email);
        clickToElement(driver, SignUpUI.BUTTON_SEARCH_EMAIL);
        clickToElement(driver, SignUpUI.EMAIL_VERIFY,getEmailWithoutDomain(email));
        switchToIframeOrFrame(driver, SignUpUI.IFRAME_EMAIL);
        String code = getTextElement(driver, SignUpUI.VERIFY_CODE);
        driver.close();
        driver.switchTo().window(tabs.get(0));
        return code;
    }

    public Object getPlaceholderOfDynamicField() {
        return null;
    }

    public Object getContentOfSignUpButton() {
        return null;
    }
}
