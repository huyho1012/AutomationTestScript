package Project.Shared;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_newsfeed.StartApp.ForgotPasswor_PageUI;
import org.openqa.selenium.WebDriver;

public class ForgotPassword_PageObject extends AbstractPage {
    WebDriver driver;
    public ForgotPassword_PageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterUsernameToSearch(WebDriver driver, String userName){
        waitElementToVisible(driver, ForgotPasswor_PageUI.SEARCH_USERNAME_FIELD);
        sendKeyToElement(driver, ForgotPasswor_PageUI.SEARCH_USERNAME_FIELD, userName);
    }

    public void clickToSearchUsername(WebDriver driver){
        waitForElementClickable(driver, ForgotPasswor_PageUI.SEARCH_USER_BUTTON);
        clickToElement(driver, ForgotPasswor_PageUI.SEARCH_USER_BUTTON);
    }

    public void clickToCancelChangePassOnStep1(WebDriver driver){
        waitForElementClickable(driver, ForgotPasswor_PageUI.CANCEL_FORGOT_BUTTON);
        clickToElement(driver, ForgotPasswor_PageUI.CANCEL_FORGOT_BUTTON);
    }

    public String getErrMessageOfUsername(WebDriver driver){
        waitElementToVisible(driver, ForgotPasswor_PageUI.ERR_VALIDATE_USERNAME_FIELD);
        return getTextElement(driver, ForgotPasswor_PageUI.ERR_VALIDATE_USERNAME_FIELD);
    }

    public boolean checkMessageNoResultAccount(WebDriver driver){
        return checkElementIsDisplayed(driver, ForgotPasswor_PageUI.NO_RESULT);
    }

    public String getHeaderNoResultAccount(WebDriver driver){
        return getTextElement(driver, ForgotPasswor_PageUI.NO_RESULT_HEADER);
    }
    public String getContentNoResultAccount(WebDriver driver){
        return getTextElement(driver, ForgotPasswor_PageUI.NO_RESULT_CONTENT);
    }

    public String getDataOfUsernameDisplayOnStep2(WebDriver driver){
        return  getTextElement(driver, ForgotPasswor_PageUI.USERNAME_FIELD_DATA);
    }
    public void clickContinueButtonOnStep2(WebDriver driver){
        waitForElementClickable(driver, ForgotPasswor_PageUI.CONTINUE_STEP2);
        clickToElement(driver, ForgotPasswor_PageUI.CONTINUE_STEP2);
    }
    public void clickCancelFindAccountOnStep2(WebDriver driver){
        waitForElementClickable(driver, ForgotPasswor_PageUI.BACK_FIND_ACCOUNT_BUTTON);
        clickToElement(driver, ForgotPasswor_PageUI.BACK_FIND_ACCOUNT_BUTTON);
    }
    public void enterDataOnDynamicFieldOnChangePass(WebDriver driver, String nameField, String data){
        waitElementToVisible(driver, ForgotPasswor_PageUI.DYNAMIC_FIELD_ON_FORGOT_FORM, nameField);
        sendKeyToElement(driver, ForgotPasswor_PageUI.DYNAMIC_FIELD_ON_FORGOT_FORM,nameField, data);
    }
}
