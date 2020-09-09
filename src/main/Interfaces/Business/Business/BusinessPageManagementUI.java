package Interfaces.Business.Business;

public class BusinessPageManagementUI {
    public static final String POPUP_CREATE_NEW_PAGE = "//div[@id = 'modal__add-new-page']";
    public static final String PAGE_CATEGORY_ITEM = "//div[contains(@data-bind,'%s')]";
    public static final String PAGE_NAME_FIELD = "//input[@name ='pv101']";
    public static final String PAGE_MANAGEMENT = "//span[contains(@data-bind,' pageVM().pv101')][contains(text(),'%s')]/parent::h5/following-sibling::div//a[contains(text(),'Quản lý trang')]";
    public static final String BUTTON_OPEN_CREATE_PAGE_POPUP = "//button[contains(@data-bind,'onShowModalCreatePage')]";
    public static final String BUTTON_CREATE_PAGE = "//button[contains(@data-bind,'onCreateNewPage')]";
    public static final String PAGE_NAME_ON_DETAIL = "//h5[@class='infocard__name']//span[contains(@data-bind,' pageVM().pv101')]";
    public static final String PAGE_NAME_ON_PAGE_LIST = "//div[contains(@class,'business-staff-page__left')]//span[contains(@data-bind,'pv101')]";
    public static final String OWNER_PAGE_NAME = "//span[contains(@data-bind,' pageVM().pv101')][contains(text(),'%s')]/parent::h5/following-sibling::div//span[contains(@data-bind,'pageVM().dl147')]";
    public static final String ID_OF_PAGE_NAME = "//span[contains(@data-bind,' pageVM().pv101')][contains(text(),'%s')]/parent::h5/following-sibling::div//span[contains(@data-bind,'pageVM().id')]";
    public static final String BUTTON_ASSIGNED_PAGE = "//button[contains(@data-bind,'onShowModalAssignPeople')]";
}
