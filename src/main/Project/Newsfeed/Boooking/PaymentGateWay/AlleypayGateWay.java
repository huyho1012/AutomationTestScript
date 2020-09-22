package Project.Newsfeed.Boooking.PaymentGateWay;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_newsfeed.Booking.PaymentGateWay.AlleypayGatewayUI;
import org.openqa.selenium.WebDriver;

public class AlleypayGateWay extends AbstractPage
{
    WebDriver driver;
    public AlleypayGateWay(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkAlleypayGateWayIsDisplay(){
        return true;
    }

    public void choosePaymentMethod(WebDriver driver, String paymentMethod){
        waitForElementClickable(driver, AlleypayGatewayUI.PAYMENT_METHOD_DROPDOWN);
        selectItemInDropdownByText(driver, AlleypayGatewayUI.PAYMENT_METHOD_DROPDOWN,paymentMethod);
    }

    public void enterDataToCardHolderNameField(WebDriver driver, String cardHoldername){
        waitElementToVisible(driver, AlleypayGatewayUI.CARDHOLDER_NAME_FIELD);
        sendKeyToElement(driver, AlleypayGatewayUI.CARDHOLDER_NAME_FIELD,cardHoldername);
    }

    public void enterDataToCardNumberField(WebDriver driver, String cardHoldername){
        waitElementToVisible(driver, AlleypayGatewayUI.CARD_NUMBER_FIELD);
        sendKeyToElement(driver, AlleypayGatewayUI.CARD_NUMBER_FIELD,cardHoldername);
    }

    public void enterDataToExpiredDateField(WebDriver driver, String expireDate){
        waitElementToVisible(driver, AlleypayGatewayUI.EXPIRED_DATE_FIELD);
        sendKeyToElement(driver, AlleypayGatewayUI.EXPIRED_DATE_FIELD,expireDate);
    }

    public void enterDataToCVVField(WebDriver driver, String ccvCode){
        waitElementToVisible(driver, AlleypayGatewayUI.CCV_CODE_FIELD);
        sendKeyToElement(driver, AlleypayGatewayUI.CCV_CODE_FIELD,ccvCode);
    }

    public void enterDataToEmailField(WebDriver driver, String email){
        waitElementToVisible(driver, AlleypayGatewayUI.EMAIL_FIELD);
        sendKeyToElement(driver, AlleypayGatewayUI.EMAIL_FIELD,email);
    }
    public void enterDataToPhoneField(WebDriver driver, String phone){
        waitElementToVisible(driver, AlleypayGatewayUI.PHONE_FIELD);
        sendKeyToElement(driver, AlleypayGatewayUI.PHONE_FIELD,phone);
    }


    public void clickToConfirmPayment(WebDriver driver){
        waitForElementClickable(driver, AlleypayGatewayUI.PAYMENT_BUTTON);
        clickToElement(driver, AlleypayGatewayUI.PAYMENT_BUTTON);
    }

}
