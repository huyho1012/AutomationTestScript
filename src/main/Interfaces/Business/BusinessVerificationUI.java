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
}
