package Project.Newsfeed.Boooking;

import Interfaces.hahalolo_newsfeed.Booking.PaymentInfoUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class PaymentInfo extends HeaderPage {
    WebDriver driver;
    public PaymentInfo (WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checBookingTourStep4IsDisplay() {
        return true;
    }

    public void enterDataToDynamicFieldOnBillingInfoTab(WebDriver driver, String nameField, String valueData ){
        waitElementToVisible(driver,PaymentInfoUI.DYNAMIC_FIELD_ON_BILLING_INFO, nameField);
        sendKeyToElement(driver, PaymentInfoUI.DYNAMIC_FIELD_ON_BILLING_INFO, valueData, nameField);
    }

    public void chooseCountryOnBillingInfoTab(WebDriver driver, String s) {
    }
    public boolean checkViscardTabIsDisplay() {
        return true;
    }

    public void clickToAggreeRule() {
    }

    public void enterCardHolderName() {
    }

    public void enterCardNumber(String s) {
    }



    public void clickButtonSaveBillingInfo() {
    }
    

    public void checkPaymentMethodIsDisplay() {
    }

    public void choosePaymentMethod() {
    }

    public void chooseExpDate() {
    }

    public void enterDataToDynamicFieldOnVisaMethod(WebDriver driver, String nameField, String dataValue) {
    }

    public void clickButtonPayment() {
    }

    public boolean checkPaymentSuccessIsDisplay() {
        return true;
    }
}
