package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.PersonalAbout_ContactAndBasicInfo_PageUI;
import org.openqa.selenium.WebDriver;

public class PerAbout_BasicInfoAndContact_PageObject extends PerAbout_Common_PageObject {
    WebDriver driver;
    public PerAbout_BasicInfoAndContact_PageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkContactAndBasicInfoTabIsDisplay(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.CONTACT_AND_BASIC_INFO_TAB);
        return checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfo_PageUI.TITLE_PAGE);
    }

    public boolean checkContactAndBasicInfoCaseCreateAccountByEmail(){
        return true;
    }

    public boolean checkContactAndBasicInfoCaseCreateAccountByPhone(){
        return true;
    }

    // Phone section
    public String getMainPhoneDisplay(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.CONTACT_AND_BASIC_INFO_TAB);
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.MAIN_PHONE_DATA);
        return getTextElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.MAIN_PHONE_DATA);
    }

    public void clickToButtonAddNewMainPhone(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_ADD_NEW_MAIN_PHONE);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_ADD_NEW_MAIN_PHONE);
    }

    public void enterDataToMainPhoneField(String mainPhone){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.MAIN_PHONE_FIELD);
        sendKeyToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.MAIN_PHONE_FIELD, mainPhone);
        setTimeDelay(1);
    }

    public String getErrorValidateOfMainPhoneField(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.MAIN_PHONE_ERROR_MESSAGE);
        return getTextElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.MAIN_PHONE_ERROR_MESSAGE);
    }

    public Object getErrorValidateOfOtherPhoneField() {
        int n = findElements(driver, PersonalAbout_ContactAndBasicInfo_PageUI.LIST_OTHER_PHONE).size();
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.OTHER_PHONE_ERROR_MESSAGE,String.valueOf(n));
        return getTextElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.OTHER_PHONE_ERROR_MESSAGE,String.valueOf(n));
    }

    public String getAttributeValueOfMainPhoneField(){
        return  getAttributeValue(driver, PersonalAbout_ContactAndBasicInfo_PageUI.MAIN_PHONE_FIELD, "value");
    }

    public String getAttributeValueOfOtherPhoneField(){
        int n = findElements(driver, PersonalAbout_ContactAndBasicInfo_PageUI.LIST_OTHER_PHONE).size();
        return  getAttributeValue(driver, PersonalAbout_ContactAndBasicInfo_PageUI.OTHER_PHONE_FIELD, "value",String.valueOf(n) );
    }

    public void clickToEditMainPhone(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfo_PageUI.ICON_EDIT_MAIN_PHONE);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.ICON_EDIT_MAIN_PHONE);
    }

    public void clickToAddnewOtherPhone(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_ADD_OTHER_PHONE);
        clickToElementByJS(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_ADD_OTHER_PHONE);
    }

    public void enterDataToOtherPhone(String phonenumber) {
        int n = findElements(driver, PersonalAbout_ContactAndBasicInfo_PageUI.LIST_OTHER_PHONE).size();
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.OTHER_PHONE_FIELD, String.valueOf(n));
        sendKeyToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.OTHER_PHONE_FIELD,phonenumber, String.valueOf(n));
    }

    public void clickToRemoveRedirectOtherPhone(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_REMOVE_OTHER_PHONE);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_REMOVE_OTHER_PHONE);
    }

    public void clickToSavePhoneInfo(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_SAVE_PHONE);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_SAVE_PHONE);
    }

    public void clickToCancelSavePhoneInfo(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_CANCEL_SAVE_CHANGE_PHONE);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_CANCEL_SAVE_CHANGE_PHONE);
    }

    public String formatDataOfPhoneField(String phoneData){
        String a =  phoneData.replaceAll("[^\\d]","");
        if(a.length()>20){
            a= a.substring(0,20);
        }
        return a;
    }

    // Birthday
    public String getBirthdayDisplay(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.CONTACT_AND_BASIC_INFO_TAB);
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BIRTHDAY_DATA);
        return getTextElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BIRTHDAY_DATA);
    }

    public void clickToEditBirthday(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfo_PageUI.ICON_EDIT_BIRTHDAY);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.ICON_EDIT_BIRTHDAY);
    }

    public void enterDataTOBirhdayField(String birthday){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BIRTHDAY_FIELD);
        sendKeyToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BIRTHDAY_FIELD, birthday);
    }

    public String getErrorMessageOfBirthday(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BIRTHDAY_ERROR_MESSAGE);
        return getTextElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BIRTHDAY_ERROR_MESSAGE);
    }

    // Hàm nhấn nút lưu thông tin ngày sinh
    public void clickToButtonUpdateBirthday(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_SAVE_BIRTHDAY);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_SAVE_BIRTHDAY);
    }

    // Hàm huỷ lưu thông tin ngày sinh
    public void clickToCancelUpadteBirthday(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_CANCEL_SAVE_BIRTHDAY);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_CANCEL_SAVE_BIRTHDAY);
    }

    // Giới tính

    public String getGenderDisplayOnBasicInfoAndContact(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.GENDER_DATA);
        return getTextElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.GENDER_DATA);
    }


    public void clickToEditGender(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfo_PageUI.ICON_EDIT_GENDER);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.ICON_EDIT_GENDER);
    }

    public void selectGenderOption(String genderOption){
        selectItemInDropdownByValue(driver, PersonalAbout_ContactAndBasicInfo_PageUI.GENDER_DROPDOWN, genderOption);
    }

    public void clickToCancelSaveGenderInfo(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_SAVE_GENDER );
        clickToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_SAVE_GENDER);
    }

    public void clickButtonToSaveGender() {
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_SAVE_GENDER);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_SAVE_GENDER);

    }

    // Address - Contact and Basic info
    public String getAddressDisplay(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.CONTACT_AND_BASIC_INFO_TAB);
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.ADDRESS_DATA);
        return getTextElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.ADDRESS_DATA);
    }

    public void clickToButtonAddNewAddress(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_ADD_ADDRESSS);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_ADD_ADDRESSS);
    }

    public void clickToButtonEditAddress(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfo_PageUI.ICON_EDIT_ADDRESS);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.ICON_EDIT_ADDRESS);
    }

    public void enterDataToAddressField(String address){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.ADDRESS_FIELD);
        sendKeyToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.ADDRESS_FIELD, address);
    }

    public void enterDataToCityField(String city){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.CITY_FIELD);
        sendKeyToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.CITY_FIELD, city);
    }

    public void enterDataToAreaCode(String areaCode){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.AREA_CODE_FIELD);
        sendKeyToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.AREA_CODE_FIELD, areaCode);
    }

    public String getErrorMessageOfAddressField(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.ADDRESS_ERROR_MESSAGE);
        return getTextElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.ADDRESS_ERROR_MESSAGE);
    }

    public String getErrorMessageOfCityField(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.CITY_ERROR_MESSAGE);
        return getTextElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.CITY_ERROR_MESSAGE);
    }

    public void clickToSaveAddress(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_SAVE_ADDRESS);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_SAVE_ADDRESS);
    }

    public void clickToCancelSaveAddress(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_CANCEL_SAVE_ADDRESS);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_CANCEL_SAVE_ADDRESS);
    }


    public Object getOtherPhoneDisplay() {
        return null;
    }

    public boolean checkFormAddOrEditAddressDisplay() {
        return true;
    }

    public String getAttributeValueOfCityIsDisplay() {
        return  getAttributeValue(driver, PersonalAbout_ContactAndBasicInfo_PageUI.CITY_FIELD, "value");
    }

    public String getAttributeValueOfAreaCodeIsDisplay() {
        return  getAttributeValue(driver, PersonalAbout_ContactAndBasicInfo_PageUI.AREA_CODE_FIELD, "value");
    }

    public boolean checkAddressSectionNotHaveData() {
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfo_PageUI.TITLE_PAGE);
        return checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_ADD_ADDRESSS);
    }

    public boolean checkFormUpdateBirthdayIsDisplay() {
        return checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_SAVE_BIRTHDAY);
    }

    public void changeScopeOfBirthday(String valueScope) {
        selectItemInCustomDropdown(driver, PersonalAbout_ContactAndBasicInfo_PageUI.SCOPE_DROPDOWN_OF_BIRTHDAY, PersonalAbout_ContactAndBasicInfo_PageUI.SCOPE_ITEM_OF_BIRTHDAY, valueScope);
    }

    public void clickToButtonSaveBirthday() {
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_SAVE_BIRTHDAY);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_SAVE_BIRTHDAY);
    }

    public void chooseGenderType(String genderType){
        selectItemInDropdownByValue(driver, PersonalAbout_ContactAndBasicInfo_PageUI.GENDER_DROPDOWN,genderType);
    }

    public boolean checkFormEditGenderOfUserIsDisplay() {
        return checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfo_PageUI.GENDER_DROPDOWN)
                && checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_SAVE_GENDER)
                    && checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfo_PageUI.BUTTON_CANCEL_SAVE_GENDER);
    }


    public String getGenderOptionDisplayOnDropdown() {
        return getAttributeValue(driver, PersonalAbout_ContactAndBasicInfo_PageUI.GENDER_DROPDOWN,"value");
    }
}
