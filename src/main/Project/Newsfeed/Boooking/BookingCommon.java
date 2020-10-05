package Project.Newsfeed.Boooking;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_newsfeed.Booking.Newsfeed_Booking_Tour_PageUI;
import Interfaces.hahalolo_newsfeed.Booking.PaymentGateWay.Newsfeed_Payment_BillingInfo_PageUI;
import org.openqa.selenium.WebDriver;

public class BookingCommon extends AbstractPage {
    WebDriver driver;

    public String getTourNameDisplayOnBookingStep(WebDriver driver) {
        return getTextElement(driver, Newsfeed_Booking_Tour_PageUI.HEADER_TOUR_NAME);
    }

    public void clickToTermAndConditionTermsLink(WebDriver driver){
        waitForElementClickable(driver, Newsfeed_Booking_Tour_PageUI.HEADER_TERM_CONDITION_LINK);
        clickToElement(driver, Newsfeed_Booking_Tour_PageUI.HEADER_TERM_CONDITION_LINK);
    }

    public void clickToNextStep(WebDriver driver){
        waitForElementClickable(driver, Newsfeed_Booking_Tour_PageUI.BUTTON_CONTINUE_BOOKING);
        clickToElement(driver, Newsfeed_Booking_Tour_PageUI.BUTTON_CONTINUE_BOOKING);
    }

    public void clickToAggreeRule(WebDriver driver) {
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfo_PageUI.CHECKBOX_AGGREE_POLICY);
        clickToElement(driver, Newsfeed_Payment_BillingInfo_PageUI.CHECKBOX_AGGREE_POLICY);
    }

    public void clickButtonPayment(WebDriver driver) {
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfo_PageUI.BUTTON_PAYMENT);
        clickToElement(driver, Newsfeed_Payment_BillingInfo_PageUI.BUTTON_PAYMENT);
    }
}
