package Project.Backend;

import Common.HandleFunction.AbstractPage;
import Interfaces.Backend.BackendVerifyBusiManagementUI;
import org.openqa.selenium.WebDriver;

public class BackendVerifyBusinessManagement extends AbstractPage {
    WebDriver driver;
    public BackendVerifyBusinessManagement(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterEmailBusinessForSearch(WebDriver driver, String ownerBusinessEmail) {
        waitElementToVisible(driver, BackendVerifyBusiManagementUI.SEARCH_BUSINESS_FIELD);
        sendKeyToElement(driver, BackendVerifyBusiManagementUI.SEARCH_BUSINESS_FIELD,ownerBusinessEmail);
        setTimeDelay(1);
    }

    public void chooseStartDateForFilter(WebDriver driver, String startDate){
        waitElementToVisible(driver, BackendVerifyBusiManagementUI.START_DATE_FIELD);
        sendKeyToElement(driver, BackendVerifyBusiManagementUI.START_DATE_FIELD, startDate);
        setTimeDelay(1);
    }
    public void chooseEndDateForFilter(WebDriver driver, String endDate){
        waitElementToVisible(driver, BackendVerifyBusiManagementUI.END_DATE_FIELD);
        sendKeyToElement(driver, BackendVerifyBusiManagementUI.END_DATE_FIELD, endDate);
        setTimeDelay(1);
    }
    public void chooseTypeBusiness(WebDriver driver, String typeBusiness){
        selectItemInCustomDropdown(driver, BackendVerifyBusiManagementUI.BUSI_TYPE_DROPDOWN, BackendVerifyBusiManagementUI.BUSI_TYPE_ITEM, typeBusiness);
        setTimeDelay(2);
    }
    public void chooseStatusVerification(WebDriver driver, String statusVerification){
        selectItemInCustomDropdown(driver, BackendVerifyBusiManagementUI.STATUS_VERIFY_DROPDOWN, BackendVerifyBusiManagementUI.STATUS_VERIFY_ITEM, statusVerification);
        setTimeDelay(2);
    }
    public void clickToFilterButton(WebDriver driver) {
        clickToElementByJS(driver, BackendVerifyBusiManagementUI.BUTTON_FILTER);
        setTimeDelay(2);
    }

    public void clickVerifyButton(WebDriver driver, String businessName, String ownerName, String ownerEmail) {
        waitForElementClickable(driver, BackendVerifyBusiManagementUI.BUTTON_VERIFY,businessName,ownerName, ownerEmail);
        clickToElement(driver, BackendVerifyBusiManagementUI.BUTTON_VERIFY,businessName,ownerName, ownerEmail);
        setTimeDelay(1);
    }

    public void clickConfirmButtonOnPopup(WebDriver driver) {
        waitElementToVisible(driver, BackendVerifyBusiManagementUI.POPUP_CONFIRM_VERIFICATION);
        waitForElementClickable(driver, BackendVerifyBusiManagementUI.BUTTON_CONFIRM);
        clickToElement(driver, BackendVerifyBusiManagementUI.BUTTON_CONFIRM);
        setTimeDelay(1);
    }

    public void goToWalletLoginPage(WebDriver driver) {
    }

    public boolean checkPageIsDisplaySuccess() {
        return true;
    }

    public String getStatusOfBusinessVerification(WebDriver driver, String businessName, String ownerName, String ownerEmail) {
        return getTextElement(driver, BackendVerifyBusiManagementUI.STATUS_VERIFICATION_OF_DIRECT_BUSINESS,businessName,ownerName,ownerEmail);
    }
}
