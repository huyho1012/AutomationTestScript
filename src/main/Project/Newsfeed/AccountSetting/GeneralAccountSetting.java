package Project.Newsfeed.AccountSetting;

import Common.HelperFunction.AbstractTest;
import Interfaces.hahalolo_newsfeed.AccountSetting.Newsfeed_Account_GeneralSetting_PageUI;
import org.openqa.selenium.WebDriver;

public class GeneralAccountSetting extends AccountCommon {
    WebDriver driver;
    AbstractTest abstractTest;
    public GeneralAccountSetting(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkGeneralAccountSettingTabIsDisplay(String fullName) {
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.FULL_NAME);
        return getPageTitle(driver).contains("Cài đặt tài khoản | Hahalolo")
                && getTextElement(driver, Newsfeed_Account_GeneralSetting_PageUI.FULL_NAME).contains(fullName)
                && checkElementIsDisplayed(driver, Newsfeed_Account_GeneralSetting_PageUI.TITLE_PAGE,"setting_general");
    }

    // Fullname section
    public String getFullNameDisplay() {
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.FULLNAME_LOADING);
        return getTextElement(driver, Newsfeed_Account_GeneralSetting_PageUI.FULL_NAME);
    }

    public void clickToButtonEditFullName() {
        waitForElementClickable(driver, Newsfeed_Account_GeneralSetting_PageUI.BUTTON_EDIT_FULLNAME);
        clickToElement(driver, Newsfeed_Account_GeneralSetting_PageUI.BUTTON_EDIT_FULLNAME);
    }

    public boolean checkUpdateFullNameFormIsDisplay() {
        return checkElementIsDisplayed(driver, Newsfeed_Account_GeneralSetting_PageUI.FIRSTNAME_FIELD)
                && checkElementIsDisplayed(driver, Newsfeed_Account_GeneralSetting_PageUI.MIDDLENAME_FIELD)
                && checkElementIsDisplayed(driver, Newsfeed_Account_GeneralSetting_PageUI.LASTNAME_FIELD);
    }

    public void enterDataToFirstNameField(String firstName) {
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.FIRSTNAME_FIELD);
        sendKeyToElement(driver, Newsfeed_Account_GeneralSetting_PageUI.FIRSTNAME_FIELD, firstName);
    }

    public void enterDataToMidnameField(String midName) {
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.MIDDLENAME_FIELD);
        sendKeyToElement(driver, Newsfeed_Account_GeneralSetting_PageUI.MIDDLENAME_FIELD, midName);
    }

    public void enterDataToLastnameField(String lastName) {
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.LASTNAME_FIELD);
        sendKeyToElement(driver, Newsfeed_Account_GeneralSetting_PageUI.LASTNAME_FIELD, lastName);
    }

    public String getMessageValidateFirstName() {
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.ERR_VALIDATION_OF_FIRSTNAME);
        return getTextElement(driver, Newsfeed_Account_GeneralSetting_PageUI.ERR_VALIDATION_OF_FIRSTNAME);
    }

    public String getMessageValidateLastName() {
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.ERR_VALIDATION_OF_LASTNAME);
        return getTextElement(driver, Newsfeed_Account_GeneralSetting_PageUI.ERR_VALIDATION_OF_LASTNAME);
    }

    public String getMessageValidateMidName() {
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.ERR_VALIDATION_OF_MIDDLENAME);
        return getTextElement(driver, Newsfeed_Account_GeneralSetting_PageUI.ERR_VALIDATION_OF_MIDDLENAME);
    }

    public void clickToSaveFullname() {
        waitForElementClickable(driver, Newsfeed_Account_GeneralSetting_PageUI.BUTTON_SAVE_CHANGES_FULLNAME);
        clickToElement(driver, Newsfeed_Account_GeneralSetting_PageUI.BUTTON_SAVE_CHANGES_FULLNAME);
    }

    public boolean checkConfirmPasswordPopupIsDisplayed() {
        return checkElementIsDisplayed(driver, Newsfeed_Account_GeneralSetting_PageUI.FORM_CONFIRM_PASS_FOR_CHANGING);
    }

    public void enterDataToPasswordConfirm(String confirmPwd) {
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.CONFIRM_PASS_FIELD);
        sendKeyToElement(driver, Newsfeed_Account_GeneralSetting_PageUI.CONFIRM_PASS_FIELD, confirmPwd);
    }

    public void clickToConfirmButton() {
        waitForElementClickable(driver, Newsfeed_Account_GeneralSetting_PageUI.CONFIRM_BUTTON);
        clickToElement(driver, Newsfeed_Account_GeneralSetting_PageUI.CONFIRM_BUTTON);
    }

    public String getErrMessageValidationOfConfirmPass(WebDriver driver) {
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.ERR_MESSAGE_CONFIRM_PASS);
        return  getTextElement(driver, Newsfeed_Account_GeneralSetting_PageUI.ERR_MESSAGE_CONFIRM_PASS);
    }

    public void clickCancelUpdateFullname() {
        waitForElementClickable(driver, Newsfeed_Account_GeneralSetting_PageUI.BUTTON_CANCEL_UPDATE_FULLNAME);
        clickToElement(driver, Newsfeed_Account_GeneralSetting_PageUI.BUTTON_CANCEL_UPDATE_FULLNAME);
    }

    public void clickToCancelSaveChangeFullName() {
        waitForElementClickable(driver, Newsfeed_Account_GeneralSetting_PageUI.BUTTON_CANCEL_CONFIRM_PASS);
        clickToElement(driver, Newsfeed_Account_GeneralSetting_PageUI.BUTTON_CANCEL_CONFIRM_PASS);
    }

    public String getMessageFullNameFunction() {
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.ERR_MESSAGE_OF_FULNAME_FUNCTION);
        return getTextElement(driver, Newsfeed_Account_GeneralSetting_PageUI.ERR_MESSAGE_OF_FULNAME_FUNCTION);
    }

    // Function Username
    public String getUsernameDisplay(){
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.USERNAME);
        return getTextElement(driver, Newsfeed_Account_GeneralSetting_PageUI.USERNAME);
    }

    public String getContentOfMessageNoUser(){
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.NO_USERNAME);
        return getTextElement(driver, Newsfeed_Account_GeneralSetting_PageUI.NO_USERNAME);
    }

    public void clickToEditUsername() {
        waitForElementClickable(driver, Newsfeed_Account_GeneralSetting_PageUI.BUTTON_EDIT_USERNAME);
        clickToElement(driver, Newsfeed_Account_GeneralSetting_PageUI.BUTTON_EDIT_USERNAME);
    }

    public boolean checkButtonSaveChangeOfUsername() {
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.BUTTON_CANCEL_CHANGE_USERNAME);
        return checkElementIsEnabled(driver, Newsfeed_Account_GeneralSetting_PageUI.BUTTON_SAVE_USERNAME);
    }

    public void clickToButtonSaveChangeUserName() {
        waitForElementClickable(driver, Newsfeed_Account_GeneralSetting_PageUI.BUTTON_SAVE_USERNAME);
        clickToElement(driver, Newsfeed_Account_GeneralSetting_PageUI.BUTTON_SAVE_USERNAME);
        setTimeDelay(1);
    }

    public String getMessageValidateUsername() {
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.VALIDATE_MESS_OF_USERNAME);
        return getTextElement(driver, Newsfeed_Account_GeneralSetting_PageUI.VALIDATE_MESS_OF_USERNAME);
    }

    public boolean checkIconSuccessIsDisplay() {
        return checkElementIsDisplayed(driver, Newsfeed_Account_GeneralSetting_PageUI.ICON_SUCCESS_CHANGE_USERNAME);
    }

    public boolean checkIconErrorIsDisplay() {
        return checkElementIsDisplayed(driver, Newsfeed_Account_GeneralSetting_PageUI.ICON_ERROR_CHANGE_USERNAME);
    }

    public void enterDataToUsernameField(String userName) {
        waitElementToVisible(driver, Newsfeed_Account_GeneralSetting_PageUI.USERNAME_FIELD);
        sendKeyToElement(driver, Newsfeed_Account_GeneralSetting_PageUI.USERNAME_FIELD,userName);
        setTimeDelay(1);
    }

    public void cancelSaveChangeUsername() {
        waitForElementClickable(driver, Newsfeed_Account_GeneralSetting_PageUI.BUTTON_CANCEL_CHANGE_USERNAME);
        clickToElement(driver, Newsfeed_Account_GeneralSetting_PageUI.BUTTON_CANCEL_CHANGE_USERNAME);
    }

    public boolean checkAccountGeneralSettingIsDisplay() {
        return true;
    }

    public void updateFullnameUser(String firstName, String middleName, String lastName){
        enterDataToFirstNameField(firstName);
        enterDataToMidnameField(middleName);
        enterDataToLastnameField(lastName);
        clickToSaveFullname();
    }
}
