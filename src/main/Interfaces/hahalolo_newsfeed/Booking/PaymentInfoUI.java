package Interfaces.hahalolo_newsfeed.Booking;

public class PaymentInfoUI {
    public static final String PAYMENT_TAB = "//div[contains(@data-bind, 'paymentVM')]";
    public static final String DYNAMIC_FIELD_ON_BILLING_INFO = "//input[@name = '%s']";
    public static final String COUNTRY_DROPDOWN_ON_BILLING_INFO = "//select[@name= 'nv211']/following-sibling::div//div[contains(@class, 'selectize-input')]";
    public static final String COUNTRY_ITEMM_ON_BILLING_INFO = "//select[@name= 'nv211']/following-sibling::div//div[@class ='selectize-dropdown-content']/div";
    public static final String BUTTON_UPDATE_BILLING_INFO = "//button[contains(@data-bind,'onSaveInfoBilling')]";
    public static final String PAYMENT_METHOD_SECTION = "/";
    public static final String PAYMENT_METHOD_DOMESTIC = "//input[@id = 'payer-method-0']";
    public static final String PAYMENT_METHOD_INTERNATIONAL = "//input[@id = 'payer-method-1']";
    public static final String ALEYPAY_GATE_WAY = "//input[@value = 'ALEPAY']/following-sibling::label[contains(@data-src,'alepay.jpg')]";
    public static final String BAOKIM_GATE_WAY = "//input[@value = 'BAOKIM']/following-sibling::label[contains(@data-src,'baokim.jpg')]";
    public static final String STRIPE_GATE_WAY = "//input[@value = 'STRIPE']/following-sibling::label[contains(@data-src,'stripe.jpg')]";

    public static final String CHECKBOX_AGGREE_POLICY = "//input[@id = 'save-this-card']/following-sibling::label";
    public static final String BUTTON_PAYMENT = "//button[contains(@data-bind,'btnPayment')]";
}
