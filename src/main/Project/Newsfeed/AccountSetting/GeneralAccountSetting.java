package Project.Newsfeed.AccountSetting;

import Interfaces.hahalolo_newsfeed.AccountSetting.AccountGeneralSetting_PageUI;
import org.openqa.selenium.WebDriver;

public class GeneralAccountSetting extends AccountCommon {
    WebDriver driver;
    public GeneralAccountSetting(WebDriver webDriver){
        driver = webDriver;
    }

    public String getFullNameIsDisplay() {
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.FULLNAME_LOADING);
        return getTextElement(driver, AccountGeneralSetting_PageUI.FULL_NAME);
    }

    public void clickToButtonEditFullName() {
        waitForElementClickable(driver, AccountGeneralSetting_PageUI.BUTTON_EDIT_FULLNAME);
        clickToElement(driver, AccountGeneralSetting_PageUI.BUTTON_EDIT_FULLNAME);
    }

    public boolean checkUpdateFullNameFormIsDisplay() {
        return checkElementIsDisplayed(driver, AccountGeneralSetting_PageUI.FIRSTNAME_FIELD)
                && checkElementIsDisplayed(driver, AccountGeneralSetting_PageUI.MIDDLENAME_FIELD)
                && checkElementIsDisplayed(driver, AccountGeneralSetting_PageUI.LASTNAME_FIELD);
    }

    public void enterDataToFirstNameField(String firstName) {
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.FIRSTNAME_FIELD);
        sendKeyToElement(driver, AccountGeneralSetting_PageUI.FIRSTNAME_FIELD, firstName);
    }

    public String getErrMessageValidationOfFirstName() {
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.ERR_VALIDATION_OF_FIRSTNAME);
        return getTextElement(driver, AccountGeneralSetting_PageUI.ERR_VALIDATION_OF_FIRSTNAME);
    }

    public void enterDataToLastnameField(String lastName) {
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.LASTNAME_FIELD);
        sendKeyToElement(driver, AccountGeneralSetting_PageUI.LASTNAME_FIELD, lastName);
    }

    public String getErrMessageValidationOfLastName() {
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.ERR_VALIDATION_OF_LASTNAME);
        return getTextElement(driver, AccountGeneralSetting_PageUI.ERR_VALIDATION_OF_LASTNAME);
    }

    public void enterDataToMidnameField(String midName) {
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.MIDDLENAME_FIELD);
        sendKeyToElement(driver, AccountGeneralSetting_PageUI.MIDDLENAME_FIELD, midName);
    }

    public Object getErrMessageValidationOfMidName() {
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.ERR_VALIDATION_OF_MIDDLENAME);
        return getTextElement(driver, AccountGeneralSetting_PageUI.ERR_VALIDATION_OF_MIDDLENAME);
    }

    public void clickButtonSaveChangesToUpdateFullname() {
        waitForElementClickable(driver, AccountGeneralSetting_PageUI.BUTTON_SAVE_CHANGES_FULLNAME);
        clickToElement(driver, AccountGeneralSetting_PageUI.BUTTON_SAVE_CHANGES_FULLNAME);
    }

    public boolean checkConfirmPasswordPopupIsDisplay() {
        return checkElementIsDisplayed(driver, AccountGeneralSetting_PageUI.FORM_CONFIRM_PASS_FOR_CHANGING);
    }

    public void enterDataToPasswordConfirm(String confirmPwd) {
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.CONFIRM_PASS_FIELD);
        sendKeyToElement(driver, AccountGeneralSetting_PageUI.CONFIRM_PASS_FIELD, confirmPwd);
    }

    public void clickToConfirmButton() {
        waitForElementClickable(driver, AccountGeneralSetting_PageUI.CONFIRM_BUTTON);
        clickToElement(driver, AccountGeneralSetting_PageUI.CONFIRM_BUTTON);
    }

    public String getErrMessageValidationOfConfirmPass(WebDriver driver) {
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.ERR_MESSAGE_CONFIRM_PASS);
        return  getTextElement(driver, AccountGeneralSetting_PageUI.ERR_MESSAGE_CONFIRM_PASS);
    }

    public void clickCancelUpdateFullname() {
        waitForElementClickable(driver, AccountGeneralSetting_PageUI.BUTTON_CANCEL_UPDATE_FULLNAME);
        clickToElement(driver, AccountGeneralSetting_PageUI.BUTTON_CANCEL_UPDATE_FULLNAME);
    }

    public void clickButtonToCancelSaveChangeFullName() {
        waitForElementClickable(driver, AccountGeneralSetting_PageUI.BUTTON_CANCEL_CONFIRM_PASS);
        clickToElement(driver, AccountGeneralSetting_PageUI.BUTTON_CANCEL_CONFIRM_PASS);
    }

    public Object getErrMessageOfChangeFullName() {
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.ERR_MESSAGE_OF_FULNAME_FUNCTION);
        return getTextElement(driver, AccountGeneralSetting_PageUI.ERR_MESSAGE_OF_FULNAME_FUNCTION);
    }


    // Function thay đổi định danh người dùng
    public String getUserIdentityNameDisplay(){
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.USERNAME);
        return getTextElement(driver, AccountGeneralSetting_PageUI.USERNAME);
    }

//    public String getMessageNoUsernameIsDisplay(){
//        waitElementToVisible(driver, AccountSettingUI.NO_USERNAME);
//        return getTextElement(driver, AccountSettingUI.NO_USERNAME);
//    }
    public void clickToButtonEditUsername() {
        waitForElementClickable(driver, AccountGeneralSetting_PageUI.BUTTON_EDIT_USERNAME);
        clickToElement(driver, AccountGeneralSetting_PageUI.BUTTON_EDIT_USERNAME);
    }

    public boolean checkButtonSaveChangeOfUsername() {
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.BUTTON_CANCEL_CHANGE_USERNAME);
        return checkElementIsEnabled(driver, AccountGeneralSetting_PageUI.BUTTON_SAVE_USERNAME);
    }

    public void clickToButtonSaveChangeUserName() {
        waitForElementClickable(driver, AccountGeneralSetting_PageUI.BUTTON_SAVE_USERNAME);
        clickToElement(driver, AccountGeneralSetting_PageUI.BUTTON_SAVE_USERNAME);
        setTimeDelay(1);
    }

    public String getErrMessOnUsername() {
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.VALIDATE_MESS_OF_USERNAME);
        return getTextElement(driver, AccountGeneralSetting_PageUI.VALIDATE_MESS_OF_USERNAME);
    }


    public boolean checkIconSuccessIsDisplay() {
        return checkElementIsDisplayed(driver, AccountGeneralSetting_PageUI.ICON_SUCCESS_CHANGE_USERNAME);
    }

    public boolean checkIconErrorIsDisplay() {
        return checkElementIsDisplayed(driver, AccountGeneralSetting_PageUI.ICON_ERROR_CHANGE_USERNAME);
    }


    public String getMessageNoUsername() {
        return getTextElement(driver,AccountGeneralSetting_PageUI.NO_USERNAME);
    }

    public boolean checkGeneralAccountSettingTabIsDisplay(String fullName) {
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.FULL_NAME);
        return getPageTitle(driver).contains("Cài đặt tài khoản | Hahalolo")
                && getTextElement(driver, AccountGeneralSetting_PageUI.FULL_NAME).contains(fullName)
                && checkElementIsDisplayed(driver, AccountGeneralSetting_PageUI.TITLE_PAGE,"setting_general");
    }

    public void enterDataToUsernameField(String userName) {
        waitElementToVisible(driver, AccountGeneralSetting_PageUI.USERNAME_FIELD);
        sendKeyToElement(driver, AccountGeneralSetting_PageUI.USERNAME_FIELD,userName);
        setTimeDelay(1);
    }

    public void cancelSaveChangeUsername() {
        waitForElementClickable(driver, AccountGeneralSetting_PageUI.BUTTON_CANCEL_CHANGE_USERNAME);
        clickToElement(driver, AccountGeneralSetting_PageUI.BUTTON_CANCEL_CHANGE_USERNAME);
    }

    public boolean checkAccountGeneralSettingIsDisplay() {
        return true;
    }



    public void updateFullName(String firstName, String middleName, String lastName){
        enterDataToFirstNameField(firstName);
        enterDataToMidnameField(middleName );
        enterDataToLastnameField(lastName);
        clickButtonSaveChangesToUpdateFullname();
    }
}
