package Interfaces.Backend;

public class BackendVerifyBusinessManagementUI {

    public static final String SEARCH_BUSINESS_FIELD = "//input[contains(@data-bind,'filterVM.psearch')]";

    public static final String START_DATE_FIELD = "//input[contains(@data-bind,'filterVM.startDate')]";
    public static final String END_DATE_FIELD = "//input[contains(@data-bind,'filterVM.endDate')]";
    public static final String TYPE_BUSINESS_DROPDOWN = "//select[contains(@data-bind,'businessType')]/following-sibling::div//div[@class='item']";
    public static final String TYPE_BUSINESS_ITEM = "//select[contains(@data-bind,'businessType')]/following-sibling::div//div[@class='selectize-dropdown-content']//div";
    public static final String STATUS_VERIFICATION_DROPDOWN = "//select[contains(@data-bind,'status')]/following-sibling::div//div[@class='item']";
    public static final String STATUS_VERIFICATION_ITEM = "//select[contains(@data-bind,'status')]/following-sibling::div//div[@class='selectize-dropdown-content']//div";

    public static final String BUTTON_FILTER = "//button[contains(@data-bind,'businessVerifyCollection.collection().onFilter')]";
    public static final String BUTTON_VERIFY_BUSINESS = "//a[contains(text(),'%s')]/following-sibling::div//span[contains(@data-bind,'bv105')][contains(text(),'%s')]/parent::div/following-sibling::div//span[contains(@data-bind,'bv106')][contains(text(),'%s')]/parent::div/following-sibling::div//span[contains(@data-bind,'approve')]";
}
