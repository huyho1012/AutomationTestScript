package Interfaces.hahalolo_newsfeed.Booking.PaymentGateWay;

public class AlleypayGatewayUI {
    public static final String ALLEYPAY_PAGE = "";

    public static final String PAYMENT_METHOD_DROPDOWN = "//div[@id ='typePayment']//select" ;
    public static final String CARDHOLDER_NAME_FIELD = "//input[@name ='cardHolderName']" ;
    public static final String CARD_NUMBER_FIELD = "//input[@name ='cardNumber']";

    public static final String EXPIRED_DATE_FIELD = "//input[@name ='expiredCard']";
    public static final String CCV_CODE_FIELD = "//input[@name ='cvcNumber']";
    public static final String EMAIL_FIELD = "//input[@name ='email']";
    public static final String PHONE_FIELD = "//input[@name ='phone']";

    public static final String PAYMENT_BUTTON ="//div[contains(@ng-show,'NEW')]//button[contains(@class,'paymentButton')]";

    public static final String ICON_LOADING = "//button//div[@class= 'loader']";
}
