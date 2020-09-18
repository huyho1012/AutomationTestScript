package Interfaces.hahalolo_newsfeed.Booking.PaymentGateWay;

public class StripeGatewayUI {
    public static final String STRIPE_PAGE = "//div[contains(@data-bind,'stripeVM')]";
    public static final String CARD_HOLDERNAME = "//input[@name = 'cardHolderName']";
    public static final String CARD_NUMBER = "//input[@name = 'cardNo']";
    public static final String monthExpDropdown = "//select[contains(@data-bind, 'month')]";
    public static final String yearExpDropdown = "//select[contains(@data-bind, 'year')]";
    public static final String CVV_CODE_FIELD = "//input[@name = 'cvc']";
}
