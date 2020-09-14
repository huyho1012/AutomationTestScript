package Interfaces.hahalolo_business.Business;

public class BusinessPageManagementUI {
    // Header page
    public static final String HEADER_TITLE_PAGE = "//span[contains(@data-bind, 'pageCollection')]/preceding-sibling::span";
    public static final String HEADER_PAGE_COUNT = "//span[contains(@data-bind, 'pageCollection')]";
    public static final String BUTTON_CREATE_NEW_PAGE = "//button[contains(@data-bind,'onShowModalCreatePage')]";
    // Page Management
    public static final String PAGE_NAME_ON_DETAIL = "//span[contains(@data-bind,' pageVM().pv101')]";
    public static final String PAGE_NAME_ON_LIST = "//span[contains(@data-bind,'pv101')]";
    public static final String PAGE_MANAGEMENT_LINK = "//a[contains(text(),'Quản lý trang')]";
    public static final String BUTTON_ASSIGNED_PAGE = "//button[contains(@data-bind,'onShowModalAssignPeople')]";
    public static final String OWNER_PAGE = "//span[contains(@data-bind,'pageVM().dl147')]";
    public static final String ID_PAGE = "//span[contains(@data-bind,'pageVM().id')]";

    public static final String POPUP_CREATE_NEW_PAGE = "//div[@id = 'modal__add-new-page']";
    public static final String PAGE_CATEGORY_ITEM = "//div[contains(@data-bind,'%s')]";
    public static final String PAGE_NAME_FIELD = "//input[@name ='pv101']";
    public static final String BUTTON_CREATE_PAGE = "//button[contains(@data-bind,'onCreateNewPage')]";




}
