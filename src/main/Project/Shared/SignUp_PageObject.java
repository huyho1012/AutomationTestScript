package Project.Shared;

import Interfaces.hahalolo_newsfeed.StartApp.SignUpUI;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


public class SignUp_PageObject extends CommonStartApp {
    WebDriver driver;
    public SignUp_PageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public String getTitleOfFormSignUp(){
        waitElementToVisible(driver, SignUpUI.TITLE_REGISTER_FORM);
        return getTextElement(driver, SignUpUI.TITLE_REGISTER_FORM);
    }

    public void enterDataValueToDynamicOnFormSignUp(String nameField , String dataValue){
        waitElementToVisible(driver, SignUpUI.TEXT_FIELD_DYNAMIC, nameField);
        sendKeyToElement(driver, SignUpUI.TEXT_FIELD_DYNAMIC, dataValue, nameField);
    }

    public void choosePhoneCode(String countryCode){
        waitForElementClickable(driver,SignUpUI.PHONE_CODE_DROPDOWN);
        selectItemInCustomDropdown(driver,SignUpUI.PHONE_CODE_DROPDOWN,SignUpUI.PHONE_CODE_ITEM,countryCode);
    }

    public String getValidErrMessageOfDynamicOnFormSignUp(String nameField){
        waitElementToVisible(driver, SignUpUI.ERROR_MESSAGE_OF_TEXT_FIELD, nameField);
        return getTextElement(driver, SignUpUI.ERROR_MESSAGE_OF_TEXT_FIELD, nameField);
    }

    public void clickSignUpButton(){
        waitForElementClickable(driver, SignUpUI.SIGNUP_BUTTON);
        clickToElement(driver, SignUpUI.SIGNUP_BUTTON);
    }

    public String getErrMessageOfPhoneCode(){
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

    public void enterVerifyCodeToVerifyAccount(String verifyCode){
        waitElementToVisible(driver, SignUpUI.VERIFY_CODE_FIELD);
        sendKeyToElement(driver,SignUpUI.VERIFY_CODE_FIELD,verifyCode);
    }

    public void clickToVerifyAccount(){
        waitForElementClickable(driver, SignUpUI.VERIFY_ACCOUNT_BUTTON);
        clickToElement(driver, SignUpUI.VERIFY_ACCOUNT_BUTTON);
    }

    public void clickToResendCodeOnVerificationPage(){
        waitForElementClickable(driver, SignUpUI.BUTTON_RESEND_CODE);
        clickToElement(driver,SignUpUI.BUTTON_RESEND_CODE);
    }


    public boolean checkVerifyPageDisplay() {
        return checkElementDisplay(driver, SignUpUI.VERIFY_ACCOUNT_FORM_PAGE) && getPageTitle(driver).equals("Kích hoạt tài khoản | Hahalolo");
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

    public void signUpWithNewAccountByEmail(String firstName, String lastName, String email, String password, String confirmPass){
        // Step 1 - Nhập tên của người dùng
        enterDataValueToDynamicOnFormSignUp("nv104", firstName);

        // Step 2 - Nhập họ của người dùng
        enterDataValueToDynamicOnFormSignUp("nv103", lastName);

        // Step 3 - Nhập email để đăng ký
        enterDataValueToDynamicOnFormSignUp("nv108", email);

        // Step 4 - Nhập mật khẩu tài khoản
        enterDataValueToDynamicOnFormSignUp("nv109", password);

        // Step 5 - Xác nhận lại mật khảu
        enterDataValueToDynamicOnFormSignUp("repeatPassword", confirmPass);

        // Step 6 - Nhấn nút xác nhận đăng ký tài khoản
        clickSignUpButton();

        // Step 7 - Xác nhân người dùng đăng ký tài khoản bằng email
        verifyTrue(getTitleOfVerifyForm().contains(""));

        // Step 8 - Kiểm tra email người dùng nhập ở bước 3 hiển thị chính xác hay không
        verifyEquals(getUserAccountToDisplay(), email);

        // Step 9 - Lấy mã xác minh đăng ký tài khoản và nhập vào ô Mã xác minh
        String code = getVerifyCodeByEmail(email);
        enterVerifyCodeToVerifyAccount(code);

        // Step 10 - Nhấn nút xác minh để hoàn tất quy trình đăng ký tài khoản
        clickToVerifyAccount();
    }
}
