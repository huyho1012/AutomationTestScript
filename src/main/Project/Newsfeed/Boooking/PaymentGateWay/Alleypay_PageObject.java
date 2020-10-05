package Project.Newsfeed.Boooking.PaymentGateWay;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_newsfeed.Booking.PaymentGateWay.Newsfeed_Payment_Alepay_PageUI;
import org.openqa.selenium.WebDriver;

public class Alleypay_PageObject extends AbstractPage
{
    WebDriver driver;
    public Alleypay_PageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkAlleypayGateWayIsDisplay(){
        return true;
    }

    public void choosePaymentMethod(WebDriver driver, String paymentMethod){
        waitForElementClickable(driver, Newsfeed_Payment_Alepay_PageUI.PAYMENT_METHOD_DROPDOWN);
        selectItemInDropdownByText(driver, Newsfeed_Payment_Alepay_PageUI.PAYMENT_METHOD_DROPDOWN,paymentMethod);
    }

    public void enterDataToCardHolderNameField(WebDriver driver, String cardHoldername){
        waitElementToVisible(driver, Newsfeed_Payment_Alepay_PageUI.CARDHOLDER_NAME_FIELD);
        sendKeyToElement(driver, Newsfeed_Payment_Alepay_PageUI.CARDHOLDER_NAME_FIELD,cardHoldername);
    }

    public void enterDataToCardNumberField(WebDriver driver, String cardHoldername){
        waitElementToVisible(driver, Newsfeed_Payment_Alepay_PageUI.CARD_NUMBER_FIELD);
        sendKeyToElement(driver, Newsfeed_Payment_Alepay_PageUI.CARD_NUMBER_FIELD,cardHoldername);
    }

    public void enterDataToExpiredDateField(WebDriver driver, String expireDate){
        waitElementToVisible(driver, Newsfeed_Payment_Alepay_PageUI.EXPIRED_DATE_FIELD);
        sendKeyToElement(driver, Newsfeed_Payment_Alepay_PageUI.EXPIRED_DATE_FIELD,expireDate);
    }

    public void enterDataToCVVField(WebDriver driver, String ccvCode){
        waitElementToVisible(driver, Newsfeed_Payment_Alepay_PageUI.CCV_CODE_FIELD);
        sendKeyToElement(driver, Newsfeed_Payment_Alepay_PageUI.CCV_CODE_FIELD,ccvCode);
    }

    public void enterDataToEmailField(WebDriver driver, String email){
        waitElementToVisible(driver, Newsfeed_Payment_Alepay_PageUI.EMAIL_FIELD);
        sendKeyToElement(driver, Newsfeed_Payment_Alepay_PageUI.EMAIL_FIELD,email);
    }
    public void enterDataToPhoneField(WebDriver driver, String phone){
        waitElementToVisible(driver, Newsfeed_Payment_Alepay_PageUI.PHONE_FIELD);
        sendKeyToElement(driver, Newsfeed_Payment_Alepay_PageUI.PHONE_FIELD,phone);
    }


    public void clickToConfirmPayment(WebDriver driver){
        waitForElementClickable(driver, Newsfeed_Payment_Alepay_PageUI.PAYMENT_BUTTON);
        clickToElement(driver, Newsfeed_Payment_Alepay_PageUI.PAYMENT_BUTTON);
    }

}
