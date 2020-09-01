package Project.Shared.ForgotPass;

import Common.HandleFunction.AbstractPage;
import Common.HandleFunction.AbstractTest;
import org.openqa.selenium.WebDriver;

public class ForgotPassword extends AbstractPage {
    WebDriver driver;
    public ForgotPassword(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterUsernameToSearch(WebDriver driver, String userName){
        waitElementToVisible(driver, ForgotPasswordUI.SEARCH_USERNAME_FIELD);
        sendKeyToElement(driver, ForgotPasswordUI.SEARCH_USERNAME_FIELD, userName);
    }

    public void clickToSearchUsername(WebDriver driver){
        waitForElementClickable(driver, ForgotPasswordUI.SEARCH_USER_BUTTON);
        clickToElement(driver, ForgotPasswordUI.SEARCH_USER_BUTTON);
    }

    public void clickToCancelChangePassOnStep1(WebDriver driver){
        waitForElementClickable(driver, ForgotPasswordUI.CANCEL_FORGOT_BUTTON);
        clickToElement(driver, ForgotPasswordUI.CANCEL_FORGOT_BUTTON);
    }

    public String getErrMessageOfUsername(WebDriver driver){
        waitElementToVisible(driver,ForgotPasswordUI.ERR_VALIDATE_USERNAME_FIELD);
        return getTextElement(driver,ForgotPasswordUI.ERR_VALIDATE_USERNAME_FIELD);
    }

    public boolean checkMessageNoResultAccount(WebDriver driver){
        return checkIsElementIsDisplay(driver,ForgotPasswordUI.NO_RESULT);
    }

    public String getHeaderNoResultAccount(WebDriver driver){
        return getTextElement(driver,ForgotPasswordUI.NO_RESULT_HEADER);
    }
    public String getContentNoResultAccount(WebDriver driver){
        return getTextElement(driver,ForgotPasswordUI.NO_RESULT_CONTENT);
    }

    public String getDataOfUsernameDisplayOnStep2(WebDriver driver){
        return  getTextElement(driver,ForgotPasswordUI.USERNAME_FIELD_DATA);
    }
    public void clickContinueButtonOnStep2(WebDriver driver){
        waitForElementClickable(driver,ForgotPasswordUI.CONTINUE_STEP2);
        clickToElement(driver, ForgotPasswordUI.CONTINUE_STEP2);
    }
    public void clickCancelFindAccountOnStep2(WebDriver driver){
        waitForElementClickable(driver,ForgotPasswordUI.BACK_FIND_ACCOUNT_BUTTON);
        clickToElement(driver, ForgotPasswordUI.BACK_FIND_ACCOUNT_BUTTON);
    }
}
