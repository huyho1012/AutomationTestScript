package Project.Newsfeed.AccountSetting;

import Interfaces.hahalolo_newsfeed.AccountSetting.AccountSettingUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class GeneralAccountSetting extends HeaderPage {
    WebDriver driver;
    public GeneralAccountSetting(WebDriver webDriver){
        driver = webDriver;
    }

    public String getTitleOfTab(WebDriver driver, String tabName) {
        waitElementToVisible(driver, AccountSettingUI.ACCOUNT_SETTING_PAGE);
        waitElementToVisible(driver, AccountSettingUI.ACCOUNT_SETTING_MENU);
        return getTextElement(driver, AccountSettingUI.TITLE_PAGE, tabName);
    }

    public String getFullNameIsDisplay(WebDriver driver) {
        waitElementToVisible(driver, AccountSettingUI.FULLNAME_LOADING);
        return getTextElement(driver, AccountSettingUI.FULL_NAME);
    }

    public void clickToButtonEditFullName(WebDriver driver) {
        waitForElementClickable(driver, AccountSettingUI.BUTTON_EDIT_FULLNAME);
        clickToElement(driver, AccountSettingUI.BUTTON_EDIT_FULLNAME);
    }

    public boolean checkUpdateFullNameFormIsDisplay(WebDriver driver) {
        return checkElementDisplay(driver, AccountSettingUI.FIRSTNAME_FIELD)
                && checkElementDisplay(driver, AccountSettingUI.MIDDLENAME_FIELD)
                && checkElementDisplay(driver, AccountSettingUI.LASTNAME_FIELD);
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

    public boolean checkConfirmPasswordPopupIsDisplay(WebDriver driver) {
        return checkElementDisplay(driver, AccountSettingUI.FORM_CONFIRM_PASS_FOR_CHANGING);
    }

    public void enterDataToPasswordConfirm(WebDriver driver, String confirmPwd) {
        waitElementToVisible(driver, AccountSettingUI.CONFIRM_PASS_FIELD);
        sendKeyToElement(driver, AccountSettingUI.CONFIRM_PASS_FIELD, confirmPwd);
    }

    public void clickToConfirmButton() {
        waitForElementClickable(driver, AccountSettingUI.CONFIRM_BUTTON);
        clickToElement(driver, AccountSettingUI.CONFIRM_BUTTON);
    }

    public String getErrMessageValidationOfConfirmPass(WebDriver driver) {
        waitElementToVisible(driver, AccountSettingUI.ERR_MESSAGE_CONFIRM_PASS);
        return  getTextElement(driver, AccountSettingUI.ERR_MESSAGE_CONFIRM_PASS);
    }

    public void clickCancelUpdateFullname(WebDriver driver) {
        waitForElementClickable(driver, AccountSettingUI.BUTTON_CANCEL_UPDATE_FULLNAME);
        clickToElement(driver, AccountSettingUI.BUTTON_CANCEL_UPDATE_FULLNAME);
    }

    public void clickButtonToCancelSaveChangeFullName(WebDriver driver) {
        waitForElementClickable(driver, AccountSettingUI.BUTTON_CANCEL_CONFIRM_PASS);
        clickToElement(driver, AccountSettingUI.BUTTON_CANCEL_CONFIRM_PASS);
    }

    public Object getErrMessageOfChangeFullName(WebDriver driver) {
        waitElementToVisible(driver,AccountSettingUI.ERR_MESSAGE_OF_FULNAME_FUNCTION);
        return getTextElement(driver, AccountSettingUI.ERR_MESSAGE_OF_FULNAME_FUNCTION);
    }


    // Function thay đổi định danh người dùng
    public String getUserIdentityNameDisplay(WebDriver driver){
        waitElementToVisible(driver, AccountSettingUI.USERNAME);
        return getTextElement(driver, AccountSettingUI.USERNAME);
    }

    public void clickToButtonEditUsername() {
        waitForElementClickable(driver, AccountSettingUI.BUTTON_EDIT_USERNAME);
        clickToElement(driver, AccountSettingUI.BUTTON_EDIT_USERNAME);
    }

    public boolean checkButtonSaveChangeOfUsername(WebDriver driver) {
        return checkElementDisplay(driver, AccountSettingUI.BUTTON_SAVE_USERNAME);
    }


    public void clickToButtonSaveChangeUserName(WebDriver driver) {
        waitForElementClickable(driver, AccountSettingUI.BUTTON_SAVE_USERNAME);
        clickToElement(driver, AccountSettingUI.BUTTON_SAVE_USERNAME);
    }

    public String getErrMessOnUsername() {
        waitElementToVisible(driver, AccountSettingUI.VALIDATE_MESS_OF_USERNAME);
        return getTextElement(driver, AccountSettingUI.VALIDATE_MESS_OF_USERNAME);
    }


    public boolean checkIconSuccessIsDisplay() {
        return checkElementDisplay(driver, AccountSettingUI.ICON_SUCCESS_CHANGE_USERNAME);
    }

    public boolean checkIconErrorIsDisplay() {
        return checkElementDisplay(driver, AccountSettingUI.ICON_ERROR_CHANGE_USERNAME);
    }

    public Object checkUserNameIsDisplay() {
        return null;
    }

    public boolean checkGeneralAccountSettingTabIsDisplay(WebDriver driver, String fullName) {
        waitElementToVisible(driver,AccountSettingUI.FULL_NAME);
        return getPageTitle(driver).contains("Cài đặt tài khoản | Hahalolo")
                && getTextElement(driver,AccountSettingUI.FULL_NAME).contains(fullName)
                && checkElementDisplay(driver, AccountSettingUI.TITLE_PAGE,"setting_general");
    }

    public void enterDataToUsernameField(WebDriver driver, String userName) {
        waitElementToVisible(driver, AccountSettingUI.USERNAME_FIELD);
        sendKeyToElement(driver,AccountSettingUI.USERNAME_FIELD,userName);
    }
}
