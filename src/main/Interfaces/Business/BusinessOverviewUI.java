package Interfaces.Business;

public class BusinessOverviewUI {
    public static final String CREATE_NEW_BUSINESS_ACCOUNT_BUTTON = "//a[@data-target ='#modal__create-business']" ;
    public static final String TYPE_BUSINESS_CHECKBOX = "//input[@type='radio'][@id='%s']/following-sibling::label" ;
    public static final String BUSINESS_NAME_FIELD = "//input[@name='bv104']";
    public static final String OWNER_NAME_FIELD = "//input[@name='bv105']";
    public static final String BUSINESS_EMAIL_FIELD = "//input[@name='bv106']";
    public static final String FINISH_CREATE_BUSI_BUTTON = "//button[contains(@data-bind,'createBusinessAccount')]";
}
