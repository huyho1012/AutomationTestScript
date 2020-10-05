package Project.Newsfeed.Boooking;


import Interfaces.hahalolo_newsfeed.Booking.PaymentGateWay.Newsfeed_Payment_BillingInfo_PageUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class PaymentInfo extends HeaderPage {
    WebDriver driver;
    public PaymentInfo (WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPaymentBillinginfoIsDisplay() {
        return checkElementIsDisplayed(driver, Newsfeed_Payment_BillingInfo_PageUI.PAYMENT_TAB);
    }

    public void enterDataToDynamicFieldOnBillingInfoTab(WebDriver driver, String nameField, String valueData ){
        waitElementToVisible(driver, Newsfeed_Payment_BillingInfo_PageUI.DYNAMIC_FIELD_ON_BILLING_INFO, nameField);
        sendKeyToElement(driver, Newsfeed_Payment_BillingInfo_PageUI.DYNAMIC_FIELD_ON_BILLING_INFO, valueData, nameField);
    }

    public void chooseCountryOnBillingInfoTab(WebDriver driver, String countryName) {
        selectItemInCustomDropdownByScroll(driver, Newsfeed_Payment_BillingInfo_PageUI.COUNTRY_DROPDOWN_ON_BILLING_INFO , Newsfeed_Payment_BillingInfo_PageUI.COUNTRY_ITEMM_ON_BILLING_INFO, countryName);
        setTimeDelay(1);
    }
    public void clickUpdateBillingInfo(WebDriver driver){
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfo_PageUI.BUTTON_UPDATE_BILLING_INFO);
        clickToElement(driver, Newsfeed_Payment_BillingInfo_PageUI.BUTTON_UPDATE_BILLING_INFO);
    }

//    public boolean checkPaymentMethodSectionIsDisplay(WebDriver driver){
//        return checkElementDisplay(driver, PaymentInfoUI.PAYMENT_METHOD_SECTION);
//    }

    public void choosePaymentMethodAleypay(){
//        waitElementToVisible(driver, PaymentInfoUI.PAYMENT_METHOD_SECTION);
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfo_PageUI.PAYMENT_METHOD_DOMESTIC);
        clickToElement(driver, Newsfeed_Payment_BillingInfo_PageUI.PAYMENT_METHOD_DOMESTIC);
        setTimeDelay(1);
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfo_PageUI.ALEYPAY_GATE_WAY);
        clickToElement(driver, Newsfeed_Payment_BillingInfo_PageUI.ALEYPAY_GATE_WAY);
        clickToElement(driver, Newsfeed_Payment_BillingInfo_PageUI.CHECKBOX_AGGREE_POLICY);
        clickToElement(driver, Newsfeed_Payment_BillingInfo_PageUI.BUTTON_PAYMENT);
    }

    public void choosePaymentMethodBaoKim(){
//        waitElementToVisible(driver, PaymentInfoUI.PAYMENT_METHOD_SECTION);
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfo_PageUI.PAYMENT_METHOD_DOMESTIC);
        clickToElement(driver, Newsfeed_Payment_BillingInfo_PageUI.PAYMENT_METHOD_DOMESTIC);
        setTimeDelay(1);
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfo_PageUI.BAOKIM_GATE_WAY);
        clickToElement(driver, Newsfeed_Payment_BillingInfo_PageUI.BAOKIM_GATE_WAY);
        clickToElement(driver, Newsfeed_Payment_BillingInfo_PageUI.CHECKBOX_AGGREE_POLICY);
        clickToElement(driver, Newsfeed_Payment_BillingInfo_PageUI.BUTTON_PAYMENT);
    }
    public void choosePaymentMethodStripe(){
//        waitElementToVisible(driver, PaymentInfoUI.PAYMENT_METHOD_SECTION);
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfo_PageUI.PAYMENT_METHOD_INTERNATIONAL);
        clickToElement(driver, Newsfeed_Payment_BillingInfo_PageUI.PAYMENT_METHOD_INTERNATIONAL);
        setTimeDelay(1);
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfo_PageUI.STRIPE_GATE_WAY);
        clickToElement(driver, Newsfeed_Payment_BillingInfo_PageUI.STRIPE_GATE_WAY);
        clickToElement(driver, Newsfeed_Payment_BillingInfo_PageUI.CHECKBOX_AGGREE_POLICY);
        clickToElement(driver, Newsfeed_Payment_BillingInfo_PageUI.BUTTON_PAYMENT);
    }
    public boolean checkViscardTabIsDisplay() {
        return true;
    }

    public void clickButtonSaveBillingInfo() {
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfo_PageUI.BUTTON_UPDATE_BILLING_INFO);
        clickToElement(driver, Newsfeed_Payment_BillingInfo_PageUI.BUTTON_UPDATE_BILLING_INFO);
    }
    

    public void checkPaymentMethodIsDisplay() {
        setTimeDelay(2);
    }

    public boolean checkPaymentSuccessIsDisplay() {
        return true;
    }

    public void clickHereLinkToGoHandnote(WebDriver driver) {
    }


}
