package Project.Newsfeed.Boooking.PaymentGateWay;

import Interfaces.hahalolo_newsfeed.Booking.PaymentGateWay.Newsfeed_Payment_Stripe_PageUI;
import Project.Newsfeed.Boooking.BookingCommon;
import org.openqa.selenium.WebDriver;

public class Stripe_PageObject extends BookingCommon {
    WebDriver driver;

    public Stripe_PageObject(WebDriver webDriver){
        driver = webDriver;
    }
    public boolean checkStripeSectionIsDisplay(){
        return checkElementIsDisplayed(driver, Newsfeed_Payment_Stripe_PageUI.STRIPE_PAGE);
    }

    public void enterCardnumber(WebDriver driver, String cardNum){
        waitElementToVisible(driver, Newsfeed_Payment_Stripe_PageUI.CARD_NUMBER);
        sendKeyToElement(driver, Newsfeed_Payment_Stripe_PageUI.CARD_NUMBER, cardNum);

    }

    public void enterValueToCcvCodeField(WebDriver driver, String ccvCode){
        waitElementToVisible(driver, Newsfeed_Payment_Stripe_PageUI.CVV_CODE_FIELD);
        sendKeyToElement(driver, Newsfeed_Payment_Stripe_PageUI.CVV_CODE_FIELD, ccvCode);
    }

    public void enterValueToCardholderName(WebDriver driver, String cardHolderName){
        waitElementToVisible(driver, Newsfeed_Payment_Stripe_PageUI.CARD_HOLDERNAME);
        sendKeyToElement(driver, Newsfeed_Payment_Stripe_PageUI.CARD_HOLDERNAME, cardHolderName);
    }
    public void chooseExpirteDate(WebDriver driver, String valueMonth, String valueYear){
        selectItemInDropdownByValue(driver, Newsfeed_Payment_Stripe_PageUI.monthExpDropdown,valueMonth);
        setTimeDelay(1);
        selectItemInDropdownByValue(driver, Newsfeed_Payment_Stripe_PageUI.yearExpDropdown,valueYear);
    }
}
