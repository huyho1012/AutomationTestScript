package Interfaces.hahalolo_business.Business;

public class Business_Overview_PageUI {
    public static final String CREATE_NEW_BUSINESS_ACCOUNT_BUTTON = "//a[@data-target ='#modal__create-business']" ;
    public static final String TYPE_BUSINESS_CHECKBOX = "//input[@type='radio'][@id='%s']/following-sibling::label" ;
    public static final String BUSINESS_NAME_FIELD = "//input[@name='bv104']";
    public static final String OWNER_NAME_FIELD = "//input[@name='bv105']";
    public static final String BUSINESS_EMAIL_FIELD = "//input[@name='bv106']";
    public static final String FINISH_CREATE_BUSINESS_BUTTON = "//button[contains(@data-bind,'createBusinessAccount')]";
    public static final String TITLE_OVERVIEW_BUSINESS = "//div[@class='business-dashboard-cover__content']//h1";
    public static final String CONTENT_OVERVIEW_BUSINESS = "//div[@class='business-dashboard-cover__content']//p[1]";
    public static final String POP_UP_CREATE_BUSINESS = "//div[@id = 'modal__create-business'][contains(@class,'%s')]";
    public static final String BUTTON_BUSI_MANAGEMENT = "//a[text()='Quản lý tài khoản']";
    public static final String OVERVIEW_DASHBOARD = "//main[@class= 'business-dashboard']";
}
