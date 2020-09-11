package Interfaces.hahalolo_backend;

public class BackendVerifyBusiManagementUI {

    // Bộ lọc
    public static final String SEARCH_BUSINESS_FIELD = "//input[contains(@data-bind,'filterVM.psearch')]";
    public static final String START_DATE_FIELD = "//input[contains(@data-bind,'filterVM.startDate')]";
    public static final String END_DATE_FIELD = "//input[contains(@data-bind,'filterVM.endDate')]";
    public static final String BUSI_TYPE_DROPDOWN = "//select[contains(@data-bind,'businessType')]/following-sibling::div//div[@class='item']";
    public static final String BUSI_TYPE_ITEM = "//select[contains(@data-bind,'businessType')]/following-sibling::div//div[@class='selectize-dropdown-content']//div";
    public static final String STATUS_VERIFY_DROPDOWN = "//select[contains(@data-bind,'status')]/following-sibling::div//div[@class='item']";
    public static final String STATUS_VERIFY_ITEM = "//select[contains(@data-bind,'status')]/following-sibling::div//div[@class='selectize-dropdown-content']//div";
    public static final String BUTTON_FILTER = "//button[contains(@data-bind,'businessVerifyCollection.collection().onFilter')]";
    // Popup Confirm Verification
    public static final String POPUP_CONFIRM_VERIFICATION = "//div[contains(@class,'modal__confirm')]";
    public static final String BUTTON_CONFIRM = "//button[contains(@data-bind,'onConfirm')]";
    // Table Business Verification
    public static final String BUTTON_VERIFY = "//a[contains(text(),'%s')]/following-sibling::div//span[contains(@data-bind,'bv105')][contains(text(),'%s')]/parent::div/following-sibling::div//span[contains(@data-bind,'bv106')][contains(text(),'%s')]/parent::div/following-sibling::div//span[contains(@data-bind,'approve')]";
    public static final String STATUS_VERIFICATION_OF_DIRECT_BUSINESS ="//a[contains(text(),'%s')]/following-sibling::div//span[contains(@data-bind,'bv105')][contains(text(),'%s')]/parent::div/following-sibling::div//span[contains(@data-bind,'bv106')][contains(text(),'%s')]/ancestor::td/following-sibling::td[@data-title ='Status']/span";
}
