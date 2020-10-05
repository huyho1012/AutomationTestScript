package Project.Backend;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_backend.Backend_VerifyBusiManagement_PageUI;
import org.openqa.selenium.WebDriver;

public class BackendVerifyBusiManagement extends AbstractPage {
    WebDriver driver;
    public BackendVerifyBusiManagement(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterEmailBusinessForSearch(WebDriver driver, String ownerBusinessEmail) {
        waitElementToVisible(driver, Backend_VerifyBusiManagement_PageUI.SEARCH_BUSINESS_FIELD);
        sendKeyToElement(driver, Backend_VerifyBusiManagement_PageUI.SEARCH_BUSINESS_FIELD,ownerBusinessEmail);
        setTimeDelay(1);
    }

    public void chooseStartDateForFilter(WebDriver driver, String startDate){
        waitElementToVisible(driver, Backend_VerifyBusiManagement_PageUI.START_DATE_FIELD);
        sendKeyToElement(driver, Backend_VerifyBusiManagement_PageUI.START_DATE_FIELD, startDate);
        setTimeDelay(1);
    }
    public void chooseEndDateForFilter(WebDriver driver, String endDate){
        waitElementToVisible(driver, Backend_VerifyBusiManagement_PageUI.END_DATE_FIELD);
        sendKeyToElement(driver, Backend_VerifyBusiManagement_PageUI.END_DATE_FIELD, endDate);
        setTimeDelay(1);
    }
    public void chooseTypeBusiness(WebDriver driver, String typeBusiness){
        selectItemInCustomDropdown(driver, Backend_VerifyBusiManagement_PageUI.BUSI_TYPE_DROPDOWN, Backend_VerifyBusiManagement_PageUI.BUSI_TYPE_ITEM, typeBusiness);
        setTimeDelay(2);
    }
    public void chooseStatusVerification(WebDriver driver, String statusVerification){
        selectItemInCustomDropdown(driver, Backend_VerifyBusiManagement_PageUI.STATUS_VERIFY_DROPDOWN, Backend_VerifyBusiManagement_PageUI.STATUS_VERIFY_ITEM, statusVerification);
        setTimeDelay(2);
    }
    public void clickToFilterButton(WebDriver driver) {
        clickToElementByJS(driver, Backend_VerifyBusiManagement_PageUI.BUTTON_FILTER);
        setTimeDelay(2);
    }

    public void clickVerifyButton(WebDriver driver, String businessName, String ownerName, String ownerEmail) {
        waitForElementClickable(driver, Backend_VerifyBusiManagement_PageUI.BUTTON_VERIFY,businessName,ownerName, ownerEmail);
        clickToElement(driver, Backend_VerifyBusiManagement_PageUI.BUTTON_VERIFY,businessName,ownerName, ownerEmail);
        setTimeDelay(1);
    }

    public void clickConfirmButtonOnPopup(WebDriver driver) {
        waitElementToVisible(driver, Backend_VerifyBusiManagement_PageUI.POPUP_CONFIRM_VERIFICATION);
        waitForElementClickable(driver, Backend_VerifyBusiManagement_PageUI.BUTTON_CONFIRM);
        clickToElement(driver, Backend_VerifyBusiManagement_PageUI.BUTTON_CONFIRM);
        setTimeDelay(1);
    }

    public void goToWalletLoginPage(WebDriver driver) {
    }

    public boolean checkPageIsDisplaySuccess() {
        return true;
    }

    public String getStatusOfBusinessVerification(WebDriver driver, String businessName, String ownerName, String ownerEmail) {
        return getTextElement(driver, Backend_VerifyBusiManagement_PageUI.STATUS_VERIFY_OF_BUSINESS_ITEM,businessName,ownerName,ownerEmail);
    }

    public boolean checkConfirmPopupDisplay(WebDriver driver) {
        return checkElementIsDisplayed(driver, Backend_VerifyBusiManagement_PageUI.POPUP_CONFIRM_VERIFICATION);
    }
}
