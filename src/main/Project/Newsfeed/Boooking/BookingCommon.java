package Project.Newsfeed.Boooking;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_newsfeed.Booking.BookingCommonUI;
import Interfaces.hahalolo_newsfeed.Booking.BookingTourUI;
import Interfaces.hahalolo_newsfeed.Booking.PaymentInfoUI;
import org.openqa.selenium.WebDriver;

public class BookingCommon extends AbstractPage {
    WebDriver driver;

    public String getTourNameDisplayOnBookingStep() {
        return getTextElement(driver, BookingTourUI.HEADER_TOUR_NAME);
    }

    public void clickToTermAndConditionTermsLink(WebDriver driver){
        waitForElementClickable(driver, BookingTourUI.HEADER_TERM_CONDITION_LINK);
        clickToElement(driver, BookingTourUI.HEADER_TERM_CONDITION_LINK);
    }

    public void clickToNextStep(WebDriver driver){
        waitForElementClickable(driver,BookingTourUI.BUTTON_CONTINUE_BOOKING);
        clickToElement(driver, BookingTourUI.BUTTON_CONTINUE_BOOKING);
    }

    public void clickToAggreeRule() {
        waitForElementClickable(driver, PaymentInfoUI.CHECKBOX_AGGREE_POLICY);
        clickToElement(driver, PaymentInfoUI.CHECKBOX_AGGREE_POLICY);
    }

    public void clickButtonPayment() {
        waitForElementClickable(driver, PaymentInfoUI.BUTTON_PAYMENT);
        clickToElement(driver, PaymentInfoUI.BUTTON_PAYMENT);
    }
}
