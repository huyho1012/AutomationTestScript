package Project.Business.Business;

import Common.HandleFunction.AbstractPage;
import Interfaces.Business.BusinessVerificationUI;
import Interfaces.Common.LOCATION_PLACE_MODEL;
import org.openqa.selenium.WebDriver;

public class BusinessVerificationPage extends AbstractPage {
    WebDriver driver;

    public BusinessVerificationPage(WebDriver webDriver) {
        driver = webDriver;
    }

    public void enterValueToDynamicFieldOfVerifyForm(WebDriver driver, String nameField, String valueData) {
        waitElementToVisible(driver,BusinessVerificationUI.DYNAMIC_FIELD_ON_ENTERPRISE_VERIFICATION, nameField);
        sendKeyToElement(driver,BusinessVerificationUI.DYNAMIC_FIELD_ON_ENTERPRISE_VERIFICATION,valueData,nameField);
    }

    public void chooseRegistrationDate(WebDriver driver, String valueDay, String valueMonth, String valueYear) {
        selectItemInDropdownByValue(driver, BusinessVerificationUI.SELECT_DAY_DROPDOWN, valueDay);
        setTimeDelay(1);
        selectItemInDropdownByValue(driver, BusinessVerificationUI.SELECT_MONTH_DROPDOWN, valueMonth);
        setTimeDelay(1);
        selectItemInDropdownByValue(driver, BusinessVerificationUI.SELECT_YEAR_DROPDOWN, valueYear);
    }

    public void clickEnterToSearchAddress(WebDriver driver) {
        waitForElementClickable(driver, BusinessVerificationUI.SEARCH_ADDRESS_ICON);
        clickToElement(driver, BusinessVerificationUI.SEARCH_ADDRESS_ICON);
        setTimeDelay(1);
    }

    public void clickToUploadDocumentVerify(WebDriver driver, String fileName) {
        waitForElementClickable(driver, BusinessVerificationUI.UPLOAD_FILE_BUTTON);
        clickToElement(driver,BusinessVerificationUI.UPLOAD_FILE_BUTTON);
        uploadMultipleFileByAutoIT(driver,fileName);
        setTimeDelay(5);
        waitElementToVisible(driver,BusinessVerificationUI.UPLOADED_FIELD);
    }

    public void clickToSendRequestVerify(WebDriver driver) {
        waitForElementClickable(driver, BusinessVerificationUI.BUTTON_VERIFY_BUSINESS);
        clickToElement(driver,BusinessVerificationUI.BUTTON_VERIFY_BUSINESS);
    }

    public void clickToBackBusinessManagementPage(WebDriver driver) {
        waitElementToVisible(driver, BusinessVerificationUI.FORM_NOTIFICATION_SENT_REQUEST);
        waitElementToVisible(driver, BusinessVerificationUI.BACK_TO_BUSINESS_DASHBOARD_BUTTON);
        clickToElement(driver, BusinessVerificationUI.BACK_TO_BUSINESS_DASHBOARD_BUTTON);
        setTimeDelay(1);
    }

    public void enterValueToZipCodeField(WebDriver driver, String zipCode) {
        waitElementToVisible(driver,BusinessVerificationUI.ZIPCODE_FIELD);
        sendKeyToElement(driver,BusinessVerificationUI.ZIPCODE_FIELD,zipCode);
    }

    public void enterValueToBusinessScopeTextarea(WebDriver driver, String businessScope) {
        waitElementToVisible(driver,BusinessVerificationUI.BUSINESS_SCOPE_TEXT_AREA);
        sendKeyToElement(driver,BusinessVerificationUI.BUSINESS_SCOPE_TEXT_AREA, businessScope);
    }

    public boolean checkFormChooseLocationIsDisplay() {
        waitElementToVisible(driver, LOCATION_PLACE_MODEL.TITLE_FORM);
        return checkIsElementIsDisplay(driver, LOCATION_PLACE_MODEL.ADD_LOCATION_BUTTON) &&
                checkIsElementIsDisplay(driver, LOCATION_PLACE_MODEL.MAP_CONTENT) &&
                checkIsElementIsDisplay(driver, LOCATION_PLACE_MODEL.TITLE_FORM);
    }

    public void chooseLocation(WebDriver driver, String expectedAddress) {
        waitElementToVisible(driver, LOCATION_PLACE_MODEL.EXPECTED_LOCATION,expectedAddress);
        clickToElement(driver, LOCATION_PLACE_MODEL.EXPECTED_LOCATION,expectedAddress);
        clickToElement(driver, LOCATION_PLACE_MODEL.ADD_LOCATION_BUTTON);
        setTimeDelay(5);
    }

    public String getTitleOfFormSendRequestSuccess() {
        waitForPageLoading(driver);
        waitElementToVisible(driver, BusinessVerificationUI.FORM_NOTIFICATION_SENT_REQUEST);
        return getTextElement(driver, BusinessVerificationUI.TITLE_FORM_NOTIFICATION_SENT_REQUEST);
    }

    public String getTitleOfFormVerificationRequest() {
        waitElementToVisible(driver,BusinessVerificationUI.FORM_ENTERPRISE_VERIFICATION);
        return getTextElement(driver, BusinessVerificationUI.TITLE_FORM_ENTERPRISE_VERIFICATION);
    }
}