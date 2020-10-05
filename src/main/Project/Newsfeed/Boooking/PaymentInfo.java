package Project.Newsfeed.Boooking;


import Interfaces.hahalolo_newsfeed.Booking.PaymentInfoUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class PaymentInfo extends HeaderPage {
    WebDriver driver;
    public PaymentInfo (WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPaymentBillinginfoIsDisplay() {
        return checkElementIsDisplayed(driver, PaymentInfoUI.PAYMENT_TAB);
    }

    public void enterDataToDynamicFieldOnBillingInfoTab(WebDriver driver, String nameField, String valueData ){
        waitElementToVisible(driver,PaymentInfoUI.DYNAMIC_FIELD_ON_BILLING_INFO, nameField);
        sendKeyToElement(driver, PaymentInfoUI.DYNAMIC_FIELD_ON_BILLING_INFO, valueData, nameField);
    }

    public void chooseCountryOnBillingInfoTab(WebDriver driver, String countryName) {
        selectItemInCustomDropdownByScroll(driver, PaymentInfoUI.COUNTRY_DROPDOWN_ON_BILLING_INFO , PaymentInfoUI.COUNTRY_ITEMM_ON_BILLING_INFO, countryName);
        setTimeDelay(1);
    }
    public void clickUpdateBillingInfo(WebDriver driver){
        waitForElementClickable(driver, PaymentInfoUI.BUTTON_UPDATE_BILLING_INFO);
        clickToElement(driver, PaymentInfoUI.BUTTON_UPDATE_BILLING_INFO);
    }

//    public boolean checkPaymentMethodSectionIsDisplay(WebDriver driver){
//        return checkElementDisplay(driver, PaymentInfoUI.PAYMENT_METHOD_SECTION);
//    }

    public void choosePaymentMethodAleypay(){
//        waitElementToVisible(driver, PaymentInfoUI.PAYMENT_METHOD_SECTION);
        waitForElementClickable(driver, PaymentInfoUI.PAYMENT_METHOD_DOMESTIC);
        clickToElement(driver, PaymentInfoUI.PAYMENT_METHOD_DOMESTIC);
        setTimeDelay(1);
        waitForElementClickable(driver, PaymentInfoUI.ALEYPAY_GATE_WAY);
        clickToElement(driver, PaymentInfoUI.ALEYPAY_GATE_WAY);
        clickToElement(driver, PaymentInfoUI.CHECKBOX_AGGREE_POLICY);
        clickToElement(driver, PaymentInfoUI.BUTTON_PAYMENT);
    }

    public void choosePaymentMethodBaoKim(){
//        waitElementToVisible(driver, PaymentInfoUI.PAYMENT_METHOD_SECTION);
        waitForElementClickable(driver, PaymentInfoUI.PAYMENT_METHOD_DOMESTIC);
        clickToElement(driver, PaymentInfoUI.PAYMENT_METHOD_DOMESTIC);
        setTimeDelay(1);
        waitForElementClickable(driver, PaymentInfoUI.BAOKIM_GATE_WAY);
        clickToElement(driver, PaymentInfoUI.BAOKIM_GATE_WAY);
        clickToElement(driver, PaymentInfoUI.CHECKBOX_AGGREE_POLICY);
        clickToElement(driver, PaymentInfoUI.BUTTON_PAYMENT);
    }
    public void choosePaymentMethodStripe(){
//        waitElementToVisible(driver, PaymentInfoUI.PAYMENT_METHOD_SECTION);
        waitForElementClickable(driver, PaymentInfoUI.PAYMENT_METHOD_INTERNATIONAL);
        clickToElement(driver, PaymentInfoUI.PAYMENT_METHOD_INTERNATIONAL);
        setTimeDelay(1);
        waitForElementClickable(driver, PaymentInfoUI.STRIPE_GATE_WAY);
        clickToElement(driver, PaymentInfoUI.STRIPE_GATE_WAY);
        clickToElement(driver, PaymentInfoUI.CHECKBOX_AGGREE_POLICY);
        clickToElement(driver, PaymentInfoUI.BUTTON_PAYMENT);
    }
    public boolean checkViscardTabIsDisplay() {
        return true;
    }

    public void clickButtonSaveBillingInfo() {
        waitForElementClickable(driver, PaymentInfoUI.BUTTON_UPDATE_BILLING_INFO);
        clickToElement(driver, PaymentInfoUI.BUTTON_UPDATE_BILLING_INFO);
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
