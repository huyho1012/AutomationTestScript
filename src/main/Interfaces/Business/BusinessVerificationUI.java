package Interfaces.Business;

import Common.HandleFunction.AbstractPage;
import org.openqa.selenium.WebDriver;

public class BusinessVerificationUI {
    public static final String SELECT_DAY_DROPDOWN = "//select[contains(@data-bind,'daySelect')]";
    public static final String SELECT_MONTH_DROPDOWN = "//select[contains(@data-bind,'monthSelect')]";
    public static final String SELECT_YEAR_DROPDOWN ="//select[contains(@data-bind,'yearSelect')]";
    public static final String DYNAMIC_FIELD_ON_ENTERPRISE_VERIFICATION = "//input[@name='%s']";
    public static final String SEARCH_ADDRESS_ICON = "//button[contains(@data-bind,'onSearch')]" ;

    public static final String ZIPCODE_FIELD = "//input[contains(@data-bind,'locationObj.postCode')]";
    public static final String BUSINESS_SCOPE_TEXT_AREA = "//textarea[@name = 'bv111']";
    public static final String UPLOAD_FILE_BUTTON = "//button[contains(@data-bind, 'uploadFile')]";
    public static final String UPLOADED_FIELD = "//div[contains(@data-bind,'filesUpload')]";
    public static final String BUTTON_VERIFY_BUSINESS = "//button[contains(@data-bind, 'sendVerify')]";
    public static final String FORM_NOTIFICATION_SENT_REQUEST = "//div[@id = 'verification-success']";
    public static final String TITLE_FORM_NOTIFICATION_SENT_REQUEST = "//div[@id = 'verification-success']//h3/span";
    public static final String BACK_TO_BUSINESS_DASHBOARD_BUTTON = "//a[contains(@data-bind,'backPage')]";

    public static final String BUSINESS_NAVBAR_INFO = "//div[contains(@class,'business-navbar-info')]";
    public static final String TITLE_FORM_ENTERPRISE_VERIFICATION = "//div[@id = 'form-update-enterprise-info']/h6" ;
    public static final String FORM_ENTERPRISE_VERIFICATION = "//div[@id = 'form-update-enterprise-info']";
}
