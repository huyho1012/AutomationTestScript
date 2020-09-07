package Project.Backend;

import Common.HandleFunction.AbstractPage;
import Interfaces.Backend.BackendVerifyBusinessManagementUI;
import org.openqa.selenium.WebDriver;

public class BackendVerifyBusinessManagement extends AbstractPage {
    WebDriver driver;
    public BackendVerifyBusinessManagement(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterEmailBusinessForSearch(WebDriver driver, String ownerBusinessEmail) {
        waitElementToVisible(driver, BackendVerifyBusinessManagementUI.SEARCH_BUSINESS_FIELD);
        sendKeyToElement(driver, BackendVerifyBusinessManagementUI.SEARCH_BUSINESS_FIELD,ownerBusinessEmail);
    }

    public void chooseStartDateForFilter(WebDriver driver, String startDate){
        waitElementToVisible(driver, BackendVerifyBusinessManagementUI.START_DATE_FIELD);
        sendKeyToElement(driver, BackendVerifyBusinessManagementUI.START_DATE_FIELD,startDate);

    }
    public void chooseEndDateForFilter(WebDriver driver, String endDate){
        waitElementToVisible(driver, BackendVerifyBusinessManagementUI.END_DATE_FIELD);
        sendKeyToElement(driver, BackendVerifyBusinessManagementUI.END_DATE_FIELD, endDate);
    }
    public void chooseTypeBusiness(WebDriver driver, String typeBusiness){
        selectItemInCustomDropdown(driver,BackendVerifyBusinessManagementUI.TYPE_BUSINESS_DROPDOWN, BackendVerifyBusinessManagementUI.TYPE_BUSINESS_ITEM, typeBusiness);
    }
    public void chooseStatusVerification(WebDriver driver, String statusVerification){
        selectItemInCustomDropdown(driver, BackendVerifyBusinessManagementUI.STATUS_VERIFICATION_DROPDOWN, BackendVerifyBusinessManagementUI.STATUS_VERIFICATION_ITEM, statusVerification);
    }
    public void clickToFilterButton(WebDriver driver) {
        waitForElementClickable(driver, BackendVerifyBusinessManagementUI.BUTTON_FILTER);
        clickToElement(driver, BackendVerifyBusinessManagementUI.BUTTON_FILTER);
        setTimeDelay(2);
    }

    public void clickVerifyButton(WebDriver driver, String businessName, String ownerName, String ownerEmail) {
        waitForElementClickable(driver, BackendVerifyBusinessManagementUI.BUTTON_VERIFY_BUSINESS,businessName,ownerName, ownerEmail);
        clickToElement(driver, BackendVerifyBusinessManagementUI.BUTTON_VERIFY_BUSINESS,businessName,ownerName, ownerEmail);
    }

    public void clickConfirmButtonOnPopup(WebDriver driver) {
        waitElementToVisible(driver,BackendVerifyBusinessManagementUI.CONFIRM_VERIFY_POPUP);
        waitForElementClickable(driver, BackendVerifyBusinessManagementUI.CONFIRM_BUTTON);
        clickToElement(driver, BackendVerifyBusinessManagementUI.CONFIRM_BUTTON);
    }

    public void goToWalletLoginPage(WebDriver driver) {
    }

    public boolean checkPageIsDisplaySuccess() {
        return true;
    }

    public String getStatusOfBusinessVerification() {
        return getTextElement(driver,BackendVerifyBusinessManagementUI.STATUS_VERIFICATION_OF_DIRECT_BUSINESS);
    }
}
