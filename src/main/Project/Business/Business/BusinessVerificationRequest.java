package Project.Business.Business;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_business.Business.Business_VerificationRequest_PageUI;
import Interfaces.Shared.LOCATION_PLACE_MODEL;
import org.openqa.selenium.WebDriver;

public class BusinessVerificationRequest extends AbstractPage {
    WebDriver driver;

    public BusinessVerificationRequest(WebDriver webDriver) {
        driver = webDriver;
    }

    public void enterValueToDynamicFieldOfVerifyForm(WebDriver driver, String nameField, String valueData) {
        waitElementToVisible(driver, Business_VerificationRequest_PageUI.DYNAMIC_FIELD_ON_ENTERPRISE_VERIFICATION, nameField);
        sendKeyToElement(driver, Business_VerificationRequest_PageUI.DYNAMIC_FIELD_ON_ENTERPRISE_VERIFICATION,valueData,nameField);
    }

    public void chooseRegistrationDate(WebDriver driver, String valueDay, String valueMonth, String valueYear) {
        selectItemInDropdownByValue(driver, Business_VerificationRequest_PageUI.SELECT_DAY_DROPDOWN, valueDay);
        setTimeDelay(1);
        selectItemInDropdownByValue(driver, Business_VerificationRequest_PageUI.SELECT_MONTH_DROPDOWN, valueMonth);
        setTimeDelay(1);
        selectItemInDropdownByValue(driver, Business_VerificationRequest_PageUI.SELECT_YEAR_DROPDOWN, valueYear);
    }

    public void clickEnterToSearchAddress(WebDriver driver) {
        waitForElementClickable(driver, Business_VerificationRequest_PageUI.SEARCH_ADDRESS_ICON);
        clickToElement(driver, Business_VerificationRequest_PageUI.SEARCH_ADDRESS_ICON);
        setTimeDelay(1);
    }

    public void clickToUploadDocumentVerify(WebDriver driver, String fileName) {
        waitForElementClickable(driver, Business_VerificationRequest_PageUI.UPLOAD_FILE_BUTTON);
        clickToElement(driver, Business_VerificationRequest_PageUI.UPLOAD_FILE_BUTTON);
        uploadMultipleFileByAutoIT(driver,fileName);
        setTimeDelay(5);
        waitElementToVisible(driver, Business_VerificationRequest_PageUI.UPLOADED_FIELD);
    }

    public void clickToSendRequestVerify(WebDriver driver) {
        waitForElementClickable(driver, Business_VerificationRequest_PageUI.BUTTON_VERIFY_BUSINESS);
        clickToElement(driver, Business_VerificationRequest_PageUI.BUTTON_VERIFY_BUSINESS);
    }

    public void clickToBackBusinessManagementPage(WebDriver driver) {
        waitElementToVisible(driver, Business_VerificationRequest_PageUI.FORM_NOTIFICATION_SENT_REQUEST);
        waitElementToVisible(driver, Business_VerificationRequest_PageUI.BACK_TO_BUSINESS_DASHBOARD_BUTTON);
        clickToElement(driver, Business_VerificationRequest_PageUI.BACK_TO_BUSINESS_DASHBOARD_BUTTON);
        setTimeDelay(1);
    }

    public void enterValueToZipCodeField(WebDriver driver, String zipCode) {
        waitElementToVisible(driver, Business_VerificationRequest_PageUI.ZIPCODE_FIELD);
        sendKeyToElement(driver, Business_VerificationRequest_PageUI.ZIPCODE_FIELD,zipCode);
    }

    public void enterValueToBusinessScopeTextarea(WebDriver driver, String businessScope) {
        waitElementToVisible(driver, Business_VerificationRequest_PageUI.BUSINESS_SCOPE_TEXT_AREA);
        sendKeyToElement(driver, Business_VerificationRequest_PageUI.BUSINESS_SCOPE_TEXT_AREA, businessScope);
    }

    public boolean checkFormChooseLocationIsDisplay() {
        waitElementToVisible(driver, LOCATION_PLACE_MODEL.TITLE_FORM);
        return checkElementIsDisplayed(driver, LOCATION_PLACE_MODEL.ADD_LOCATION_BUTTON) &&
                checkElementIsDisplayed(driver, LOCATION_PLACE_MODEL.MAP_CONTENT) &&
                checkElementIsDisplayed(driver, LOCATION_PLACE_MODEL.TITLE_FORM);
    }

    public void chooseLocation(WebDriver driver, String expectedAddress) {
        waitElementToVisible(driver, LOCATION_PLACE_MODEL.EXPECTED_LOCATION,expectedAddress);
        clickToElement(driver, LOCATION_PLACE_MODEL.EXPECTED_LOCATION,expectedAddress);
        clickToElement(driver, LOCATION_PLACE_MODEL.ADD_LOCATION_BUTTON);
        setTimeDelay(5);
    }

    public String getTitleOfFormSendRequestSuccess(WebDriver driver) {
        waitForPageLoading(driver);
        waitElementToVisible(driver, Business_VerificationRequest_PageUI.FORM_NOTIFICATION_SENT_REQUEST);
        return getTextElement(driver, Business_VerificationRequest_PageUI.TITLE_FORM_NOTIFICATION_SENT_REQUEST);
    }

    public String getTitleOfFormVerificationRequest() {
        waitElementToVisible(driver, Business_VerificationRequest_PageUI.FORM_ENTERPRISE_VERIFICATION);
        return getTextElement(driver, Business_VerificationRequest_PageUI.TITLE_FORM_ENTERPRISE_VERIFICATION);
    }
}