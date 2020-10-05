package Project.Newsfeed.Boooking.PaymentGateWay;

import Interfaces.hahalolo_newsfeed.Booking.PaymentGateWay.StripeGatewayUI;
import Project.Newsfeed.Boooking.BookingCommon;
import org.openqa.selenium.WebDriver;

public class Stripe_PageObject extends BookingCommon {
    WebDriver driver;

    public Stripe_PageObject(WebDriver webDriver){
        driver = webDriver;
    }
    public boolean checkStripeSectionIsDisplay(){
        return checkElementIsDisplayed(driver, StripeGatewayUI.STRIPE_PAGE);
    }

    public void enterCardnumber(WebDriver driver, String cardNum){
        waitElementToVisible(driver, StripeGatewayUI.CARD_NUMBER);
        sendKeyToElement(driver, StripeGatewayUI.CARD_NUMBER, cardNum);

    }

    public void enterValueToCcvCodeField(WebDriver driver, String ccvCode){
        waitElementToVisible(driver, StripeGatewayUI.CVV_CODE_FIELD);
        sendKeyToElement(driver, StripeGatewayUI.CVV_CODE_FIELD, ccvCode);
    }

    public void enterValueToCardholderName(WebDriver driver, String cardHolderName){
        waitElementToVisible(driver, StripeGatewayUI.CARD_HOLDERNAME);
        sendKeyToElement(driver, StripeGatewayUI.CARD_HOLDERNAME, cardHolderName);
    }
    public void chooseExpirteDate(WebDriver driver, String valueMonth, String valueYear){
        selectItemInDropdownByValue(driver,StripeGatewayUI.monthExpDropdown,valueMonth);
        setTimeDelay(1);
        selectItemInDropdownByValue(driver,StripeGatewayUI.yearExpDropdown,valueYear);
    }
}
