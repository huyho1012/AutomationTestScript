package Interfaces.Newsfeed.Homepage;

public class HomePageUI {
    public static final String NORMAL_EDITOR_FUNCTION = "";
    public static final String EXPERIENCE_EDITOR_FUNCTION = "";


    public static final String HOT_EXPERIENCE_POST_WIDGET_TITLE = "//div[@id='js-widget-hot-exp']//div[@class = 'card-title']";
    public static final String HOT_EXPERIENCE_POST_TITLE = "//div[contains(@data-bind,'hotExperience.title')]";
    public static final String HOT_EXPERIENCE_POST_COVER = "//img[contains(@data-bind,'hotExperience.cover')]";
    public static final String HOT_EXPERIENCE_POST_AUTHOR = "//a[contains(@data-bind,'hotExperience.namePost')]";
    public static final String HOT_EXPERIENCE_POST_CREATED_DATE = "//div[contains(@data-bind,'hotExperience.when')]";
    public static final String HOT_EXPERIENCE_VIEW_MORE_BUTTON = "//a[contains(@data-bind,'hotExperience.model')]";

    public static final String MY_ACCOUNT_FULL_NAME = "//div[contains(@class, 'card-your-info')]//strong";
    public static final String MY_ACCOUNT_EDIT_PROFILE_BUTTON= "//div[contains(@class, 'card-your-info')]//a[contains(text(),'Chỉnh sửa trang cá nhân')]";
    public static final String MY_ACCOUNT_TAB_MENU= "//div[contains(@class, 'card-your-info')]//i[contains(@class,'%s')]";

    public static final String FOOTER_LANGUAGE = "//div[@id='sidebar-right']//span[contains(@data-bind,'changeLanguage')]";
    public static final String FOOTER_CURRENCY = "//div[@id='sidebar-right']//span[contains(@data-bind,'text: currency')]";
    public static final String FOOTER_CHANGE_CURRENCY = "//div[@id='sidebar-right']//a[contains(@data-bind,'onChangeCurrency')]";
    public static final String FOOTER_NAV_LINK = "//div[@id='sidebar-right']//a[contains(@data-bind,'href: %s')]";

    public static final String YOUR_PAGES_TOTAL_PAGE = "//span[contains(@data-bind,'totalYourPages')]";
    public static final String YOUR_PAGES_PAGE_NAME_ITEM = "//span[contains(@data-bind,'totalYourPages')]/ancestor::div[contains(@class,'card-header')]/following-sibling::div//a[@class='obj-name']";
    public static final String YOUR_PAGES_PAGE_NAME_AVATAR = "//span[contains(@data-bind,'totalYourPages')]/ancestor::div[contains(@class,'card-header')]/following-sibling::div//a[@class='avatar avatar--circle']";

    public static final String COMMUNITY_SITES_NUMBER_SITE = "//span[contains(@data-bind,'totalSite')]";
    public static final String COMMUNITY_SITES_SITE_NAME_ITEM = "//span[contains(@data-bind,'totalSite')]/ancestor::div[contains(@class,'card-header')]/following-sibling::div//a[@class='obj-name']";
    public static final String COMMUNITY_SITES_SITE_NAME_AVATAR = "//span[contains(@data-bind,'totalSite')]/ancestor::div[contains(@class,'card-header')]/following-sibling::div//a[@class='avatar avatar--circle']";
    public static final String COMMUNITY_SITES_VIEW_MORE = "//a[contains(@data-bind,'siteColls.collection().onLoadMore')]";
    public static final String COMMUNITY_SITES_BTN_CREATE = "//button[contains(@data-bind,'onCreatePage')]";

    public static final String FRIEND_REQUEST_NAME = "//div[contains(@class,'friend-requests')]//a[@class='obj-name']";
    public static final String FRIEND_REQUEST_AVATAR = "//div[contains(@class,'friend-requests')]//a[@class='avatar avatar--circle']";
    public static final String FRIEND_REQUEST_MUTUAL_FRIEND = "//div[contains(@class,'friend-requests')]//a[contains(@data-bind,'mutuals')]";
    public static final String FRIEND_REQUEST_STATUS_REQUEST_SENT = "//div[contains(@class,'friend-requests')]//button[@class ='btn-friend sent']";
    public static final String FRIEND_REQUEST_STATUS_FRIEND = "//div[contains(@class,'friend-requests')]//button[@class ='btn-friend']";
    public static final String FRIEND_REQUEST_UNFRIEND_BUTTON = "//div[contains(@class,'friend-requests')]//button[contains(@data-bind,'onRemoveFriend')]";
    public static final String FRIEND_REQUEST_ADD_FRIEND_BUTTON = "//div[contains(@class,'friend-requests')]//button[contains(@data-bind,'onAddFriendRequest')]";
    public static final String FRIEND_REQUEST_CANCEL_SEND_REQUEST_BUTTON = "//div[contains(@class,'friend-requests')]//button[contains(@data-bind,'btnRemoveSendRequest')]";
    public static final String FRIEND_REQUEST_CONFIRM_BUTTON = "//div[contains(@class,'friend-requests')]//button[contains(@data-bind,'onAcceptFriend')]";
    public static final String FRIEND_REQUEST_DENY_BUTTON = "//div[contains(@class,'friend-requests')]//button[contains(@data-bind,'onRemoveRequest')]";
    public static final String FRIEND_REQUEST_VIEW_MORE = "//div[contains(@class,'friend-requests')]//a[contains(@data-bind,'seeAllLink')]";

    public static final String FORM_UPDATE_NEW_INFO = "";
    public static final String FORM_UPDATE_NEW_INFO_TITLE = "";
}