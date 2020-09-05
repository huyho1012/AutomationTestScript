package Project.Business.Business;

import Common.HandleFunction.AbstractPage;
import Interfaces.Business.BusinessVerificationUI;
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
        selectItemInDropdownByValue(driver, BusinessVerificationUI.SELECT_MONTH_DROPDOWN, valueMonth);
        selectItemInDropdownByValue(driver, BusinessVerificationUI.SELECT_YEAR_DROPDOWN, valueYear);
    }

    public void clickEnterToSearchAddress(WebDriver driver) {
        waitForElementClickable(driver, BusinessVerificationUI.SEARCH_ADDRESS_ICON);
        clickToElement(driver, BusinessVerificationUI.SEARCH_ADDRESS_ICON);
    }

    public void clickToUploadDocumentVerify(WebDriver driver) {
    }

    public void clickToSendRequestVerify(WebDriver driver) {
    }

    public void clickToBackBusinessManagementPage(WebDriver driver) {
    }

    public void enterValueToZipCodeField(WebDriver driver, String zipCode) {
        waitElementToVisible(driver,BusinessVerificationUI.ZIPCODE_FIELD);
        sendKeyToElement(driver,BusinessVerificationUI.ZIPCODE_FIELD,zipCode);
    }

    public void enterValueToBusinessScopeTextarea(WebDriver driver, String businessScope) {
        waitElementToVisible(driver,BusinessVerificationUI.BUSINESS_SCOPE_TEXT_AREA);
        sendKeyToElement(driver,BusinessVerificationUI.BUSINESS_SCOPE_TEXT_AREA, businessScope);
    }
}