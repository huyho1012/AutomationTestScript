package Project.Newsfeed.AccountSetting;

import Interfaces.hahalolo_newsfeed.AccountSetting.AccountSettingUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class GeneralAccountSetting extends HeaderPage {
    WebDriver driver;
    public GeneralAccountSetting(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkAccountSettingPageIsDisplay() {

        waitElementToVisible(driver, AccountSettingUI.ACCOUNT_SETTIGN_PAGE);
        return getTextElement(driver, AccountSettingUI.TITLE_PAGE, "setting_general").contains("THIẾT LẬP TÀI KHOẢN CHUNG");
    }

    public String getFullNameIsDisplay() {
        waitElementToVisible(driver, AccountSettingUI.FULLNAME_LOADING);
        return getTextElement(driver, AccountSettingUI.FULL_NAME);
    }

    public void clickToButtonEditFullName() {
        waitForElementClickable(driver, AccountSettingUI.BUTTON_EDIT_FULLNAME);
        clickToElement(driver, AccountSettingUI.BUTTON_EDIT_FULLNAME);
    }

    public boolean checkUpdateFullNameFormIsDisplay() {
        if(checkElementDisplay(driver, AccountSettingUI.FIRSTNAME_FIELD) && checkElementDisplay(driver, AccountSettingUI.MIDDLENAME_FIELD) && checkElementDisplay(driver,AccountSettingUI.LASTNAME_FIELD))
        {
            return  true;
        }
        else return false;
    }

    public void enterDataToFirstNameField(WebDriver driver, String firstName) {
        waitElementToVisible(driver, AccountSettingUI.FIRSTNAME_FIELD);
        sendKeyToElement(driver, AccountSettingUI.FIRSTNAME_FIELD, firstName);
    }

    public String getErrMessageValidationOfFirstName(WebDriver driver) {
        waitElementToVisible(driver, AccountSettingUI.ERR_VALIDATION_OF_FIRSTNAME);
        return getTextElement(driver, AccountSettingUI.ERR_VALIDATION_OF_FIRSTNAME);
    }

    public void enterDataToLastnameField(WebDriver driver, String lastName) {
        waitElementToVisible(driver, AccountSettingUI.LASTNAME_FIELD);
        sendKeyToElement(driver, AccountSettingUI.LASTNAME_FIELD, lastName);
    }

    public String getErrMessageValidationOfLastName(WebDriver driver) {
        waitElementToVisible(driver, AccountSettingUI.ERR_VALIDATION_OF_LASTNAME);
        return getTextElement(driver, AccountSettingUI.ERR_VALIDATION_OF_LASTNAME);
    }

    public void enterDataToMidnameField(WebDriver driver, String midName) {
        waitElementToVisible(driver, AccountSettingUI.MIDDLENAME_FIELD);
        sendKeyToElement(driver, AccountSettingUI.MIDDLENAME_FIELD, midName);
    }

    public Object getErrMessageValidationOfMidName(WebDriver driver) {
        waitElementToVisible(driver, AccountSettingUI.ERR_VALIDATION_OF_MIDDLENAME);
        return getTextElement(driver, AccountSettingUI.ERR_VALIDATION_OF_MIDDLENAME);
    }


    public void clickButtonSaveChangesToUpdateFullname(WebDriver driver) {
        waitForElementClickable(driver, AccountSettingUI.BUTTON_SAVE_CHANGES_FULLNAME);
        clickToElement(driver, AccountSettingUI.BUTTON_SAVE_CHANGES_FULLNAME);
    }

    public boolean checkConfirmPasswordPopupIsDisplay() {
        return true;
    }

    public void enterDataToPasswordConfirm(WebDriver driver, String confirmPwd, String s) {
    }

    public void clickToConfirmButton() {
    }
}
