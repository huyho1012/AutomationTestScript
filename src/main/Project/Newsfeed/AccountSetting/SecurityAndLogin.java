package Project.Newsfeed.AccountSetting;

import Interfaces.hahalolo_newsfeed.AccountSetting.SecurityAndLoginUI;
import Interfaces.hahalolo_newsfeed.HeaderPageUI;
import org.openqa.selenium.WebDriver;

public class SecurityAndLogin extends AccountCommon{
    WebDriver driver;
    public SecurityAndLogin(WebDriver webDriver){
        driver = webDriver;
    }

    public void clickButtonLogOutAllSession(){
        waitForElementClickable(driver, SecurityAndLoginUI.BUTTON_LOGOUT_ALL);
        clickToElement(driver, SecurityAndLoginUI.BUTTON_LOGOUT_ALL);
    }

    public boolean checkConfirmLogOutAllSessionIsDisplay(){
        return checkElementDisplay(driver, SecurityAndLoginUI.POPUP_CONFIRM_LOGOUT_ALL_SESSION);
    }

    public void clickToConfirmActionLogoutAll(){
        waitForElementClickable(driver, SecurityAndLoginUI.BUTTON_CONFIRM_LOGOUT_ALL);
        clickToElement(driver, SecurityAndLoginUI.BUTTON_CONFIRM_LOGOUT_ALL);
    }

    public boolean checkLogoutAllSessionSuccesfully(){
        return getTextElement(driver, HeaderPageUI.TOAST_MESSAGE).equalsIgnoreCase("Đăng xuất thành công");
    }

    public void clickToIconChangePassword(){
        waitForElementClickable(driver, SecurityAndLoginUI.ICON_CHANGE_PASSWORD);
        clickToElement(driver, SecurityAndLoginUI.ICON_CHANGE_PASSWORD);
    }

    public void clickToConfirmChangePass(){
        waitForElementClickable(driver,SecurityAndLoginUI.BUTTON_CONFIRM_CHANGE_PASS);
        clickToElement(driver, SecurityAndLoginUI.BUTTON_CONFIRM_CHANGE_PASS);
    }

    public void clickToCancelChangePass(){
        waitForElementClickable(driver, SecurityAndLoginUI.BUTTON_CANCEL_CHANGE_PASS);
        clickToElement(driver, SecurityAndLoginUI.BUTTON_CANCEL_CHANGE_PASS);
    }

    public void clickToLinkForgotPass(){
        waitForElementClickable(driver, SecurityAndLoginUI.LINK_FORGOT);
        clickToElement(driver, SecurityAndLoginUI.LINK_FORGOT);
    }

    public void enterDataToCurrentPassword(String currentPass){
        waitElementToVisible(driver, SecurityAndLoginUI.CURRENT_PASS);
        sendKeyToElement(driver, SecurityAndLoginUI.CURRENT_PASS, currentPass);
    }

    public void enterDataToNewPassword(String newPass){
        waitElementToVisible(driver, SecurityAndLoginUI.NEW_PASS);
        sendKeyToElement(driver, SecurityAndLoginUI.NEW_PASS, newPass);
    }

    public void enterDataToConfirmNewPass(String confirmNewPass){
        waitElementToVisible(driver, SecurityAndLoginUI.CONFIRM_NEW_PASS);
        sendKeyToElement(driver, SecurityAndLoginUI.CONFIRM_NEW_PASS, confirmNewPass);
    }

    public String getErrorMessageOfCurrentPass(){
        waitElementToVisible(driver,SecurityAndLoginUI.MESSAGE_OF_CURRENT_PASS);
        return getTextElement(driver, SecurityAndLoginUI.MESSAGE_OF_CURRENT_PASS);
    }

    public String getErrorMessageOfNewPass(){
        waitElementToVisible(driver,SecurityAndLoginUI.MESSAGE_OF_NEW_PASS);
        return getTextElement(driver, SecurityAndLoginUI.MESSAGE_OF_NEW_PASS);
    }

    public String getErrorMessageOfConfirmNewPass(){
        waitElementToVisible(driver,SecurityAndLoginUI.MESSAGE_OF_CONFIRM_NEW_PASS);
        return getTextElement(driver, SecurityAndLoginUI.MESSAGE_OF_CONFIRM_NEW_PASS);
    }
}
