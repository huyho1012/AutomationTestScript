package Interfaces.hahalolo_business.Business;

public class BusinessDashboardPageUI {

    public static final String SEND_VERIFY_BUTTON = "//a[@href ='info?verify=true']";
    public static final String DASHBOARD_BUSINESS_PAGE =  "//main[@class ='pt-3 business-dashboard']";
    public static final String TITLE_CONTENT_VERIFY_BUSINESS = "//div[@id ='load-page-container']//div[contains(@class,'list-group-item')][position()= '1']//h5" ;

    public static final String TITLE_CREATE_NEW_BUSINESS_SUCCESS = "//main[contains(@class ,'business-dashboard')]//h4";
    public static final String DASBOARD_PAGE = "//main[contains(@class, 'business-dashboard')]" ;

    public static final String BUTTON_CREATE_PAGE_NOW = "//button[contains(@data-bind,'onCreatePage')]";
    public static final String PAGE_SECTION_TITLE = "//button[contains(@data-bind,'onCreatePage')]/preceding-sibling::h5";
    public static final String FORM_BUSI_INFO = "//div[@class='card card-dashboard']//h5[text() ='Thông tin kinh doanh']";
    public static final String FORM_BUSI_PAGE = "//div[@class='card card-dashboard']//h5[text() ='Trang kinh doanh']";
    public static final String FORM_BUSI_STAFF = "//div[@class='card card-dashboard']//h5[text() ='Nhân viên']";
    public static final String DASBOARD_TITLE = "//main[contains(@class,'business-dashboard')]//h4";
}
