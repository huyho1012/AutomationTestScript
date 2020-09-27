package Project.Newsfeed.AccountSetting;

import Interfaces.hahalolo_newsfeed.AccountSetting.AccountSecurityAndLogin_PageUI;
import Interfaces.hahalolo_newsfeed.Header.HeaderPageUI;
import org.openqa.selenium.WebDriver;

public class SecurityAndLogin extends AccountCommon{
    WebDriver driver;
    public SecurityAndLogin(WebDriver webDriver){
        driver = webDriver;
    }

    public void clickButtonLogOutAllSession(){
        waitForElementClickable(driver, AccountSecurityAndLogin_PageUI.BUTTON_LOGOUT_ALL);
        clickToElement(driver, AccountSecurityAndLogin_PageUI.BUTTON_LOGOUT_ALL);
    }

    public boolean checkConfirmLogOutAllSessionIsDisplay(){
        return checkElementDisplay(driver, AccountSecurityAndLogin_PageUI.POPUP_CONFIRM_LOGOUT_ALL_SESSION);
    }

    public void clickToConfirmActionLogoutAll(){
        waitForElementClickable(driver, AccountSecurityAndLogin_PageUI.BUTTON_CONFIRM_LOGOUT_ALL);
        clickToElement(driver, AccountSecurityAndLogin_PageUI.BUTTON_CONFIRM_LOGOUT_ALL);
    }

    public boolean checkLogoutAllSessionSuccesfully(){
        return getTextElement(driver, HeaderPageUI.TOAST_MESSAGE).equalsIgnoreCase("Đăng xuất thành công");
    }

    public void clickToIconChangePassword(){
        waitForElementClickable(driver, AccountSecurityAndLogin_PageUI.ICON_CHANGE_PASSWORD);
        clickToElement(driver, AccountSecurityAndLogin_PageUI.ICON_CHANGE_PASSWORD);
    }

    public void clickToConfirmChangePass(){
        waitForElementClickable(driver, AccountSecurityAndLogin_PageUI.BUTTON_CONFIRM_CHANGE_PASS);
        clickToElement(driver, AccountSecurityAndLogin_PageUI.BUTTON_CONFIRM_CHANGE_PASS);
    }

    public void clickToCancelChangePass(){
        waitForElementClickable(driver, AccountSecurityAndLogin_PageUI.BUTTON_CANCEL_CHANGE_PASS);
        clickToElement(driver, AccountSecurityAndLogin_PageUI.BUTTON_CANCEL_CHANGE_PASS);
    }

    public void clickToLinkForgotPass(){
        waitForElementClickable(driver, AccountSecurityAndLogin_PageUI.LINK_FORGOT);
        clickToElement(driver, AccountSecurityAndLogin_PageUI.LINK_FORGOT);
    }

    public void enterDataToCurrentPassword(String currentPass){
        waitElementToVisible(driver, AccountSecurityAndLogin_PageUI.CURRENT_PASS);
        sendKeyToElement(driver, AccountSecurityAndLogin_PageUI.CURRENT_PASS, currentPass);
    }

    public void enterDataToNewPassword(String newPass){
        waitElementToVisible(driver, AccountSecurityAndLogin_PageUI.NEW_PASS);
        sendKeyToElement(driver, AccountSecurityAndLogin_PageUI.NEW_PASS, newPass);
    }

    public void enterDataToConfirmNewPass(String confirmNewPass){
        waitElementToVisible(driver, AccountSecurityAndLogin_PageUI.CONFIRM_NEW_PASS);
        sendKeyToElement(driver, AccountSecurityAndLogin_PageUI.CONFIRM_NEW_PASS, confirmNewPass);
    }

    public String getErrorMessageOfCurrentPass(){
        waitElementToVisible(driver, AccountSecurityAndLogin_PageUI.MESSAGE_OF_CURRENT_PASS);
        return getTextElement(driver, AccountSecurityAndLogin_PageUI.MESSAGE_OF_CURRENT_PASS);
    }

    public String getErrorMessageOfNewPass(){
        waitElementToVisible(driver, AccountSecurityAndLogin_PageUI.MESSAGE_OF_NEW_PASS);
        return getTextElement(driver, AccountSecurityAndLogin_PageUI.MESSAGE_OF_NEW_PASS);
    }

    public String getErrorMessageOfConfirmNewPass(){
        waitElementToVisible(driver, AccountSecurityAndLogin_PageUI.MESSAGE_OF_CONFIRM_NEW_PASS);
        return getTextElement(driver, AccountSecurityAndLogin_PageUI.MESSAGE_OF_CONFIRM_NEW_PASS);
    }
}
