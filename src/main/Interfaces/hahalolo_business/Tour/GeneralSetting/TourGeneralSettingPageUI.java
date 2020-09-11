package Interfaces.hahalolo_business.Tour.GeneralSetting;

public class TourGeneralSettingPageUI {

    public static final String DYNAMIC_TEXT_FIELD = "//input[@name = '%s']";
    public static final String VAT_OPTION_1 = "//input[@id = 'vat-included']/following-sibling::label";
    public static final String VAT_VALUE_FIELD = "//input[@name = 'sn304']" ;

    public static final String VAT_OPTION_2 = "//input[@id = 'add-vat']/following-sibling::label";
    public static final String NAVBAR_MENU = "//div[@role ='tablist']/a[contains(@data-bind,'%s')]";
    public static final String BUTTON_SAVE_ON_BODY = "//div[contains(@class,'management-info-card')]//button[contains(@data-bind,'onSave')]" ;
    public static final String TITLE_OF_GENERAL_INFO = "//div[@class='management-header__title']";
    public static final String ENABLE_MODE = "//input[@id='allow-send-email']/following-sibling::label";
}
