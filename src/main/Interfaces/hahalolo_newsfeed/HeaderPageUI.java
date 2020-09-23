package Interfaces.hahalolo_newsfeed.Homepage;

public class HeaderPageUI {
    public static final String LOGO_HALO = "//a[@class = 'logo-top']";
    public static final String MAIN_SEARCH = "//input[@id = 'js-search-user-selectized']";
    public static final String USER_FULL_NAME = "//div[@class ='uri-name']";
    public static final String USER_AVATAR = "//div[@class ='uri-avatar']";
    public static final String HOMEPAGE_LINK = "//a[contains(text(),'Trang chủ')]";
    public static final String FRIEND_ICON = "//i[contains(@class,'ic-friends-primary')]";
    public static final String MESSAGE_ICON = "//i[contains(@class,'ic-chat-primary')]";
    public static final String HELPER_ICON = "//i[contains(@class,'ic-question-circle-primary')]";
    public static final String NOTIFICATION_ICON = "//i[contains(@class,'ic-bell-primary')]";
    public static final String SETTING_ICON = "//i[contains(@class,'ic-caret-down primary')]";
    public static final String CURRENCY_ICON = "//strong[contains(@data-bind,'onChangeCurrency')]";
    public static final String WALLET_ICON = "//i[contains(@class,'ic-wallet-primary')]";
    public static final String CART_ICON = "//i[contains(@class,'ic-cart-primary')]";

    public static final String NAV_FEED_MENU = "//nav[@id = 'menu-primary']//a[text()='%s']";


    public static final String HELPER_ITEM = "//div[@class='menu menu--top']//a[contains(@data-bind, 'href: '%s')]";
    public static final String SETTING_ITEM = "//div[@class='menu menu--top']//i[contains(@class, '%s')]";
    public static final String BUSINESS_NAVBAR_MENU ="//div[@id ='menu-primary']//a[@data-menu='%s']" ;
}
