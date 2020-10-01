package Interfaces.hahalolo_newsfeed.PersonaWall;

public class Per_Common_PageUI {

    public static final String PERSONAL_PAGE =  "//div[contains(@class, 'p-header--user')] ";
    public static final String FULLNAME_ON_COVER = "//div[@class='p-info__name']/span";
    public static final String PER_MENU = "";
    public static final String PER_ITEM_MENU = "";

    public static final String PER_ABOUT_LEFT_MENU = "//nav[contains(@class,'personal-about-nav')]" ;
    public static final String PER_ABOUT_ITEM_LEFT_MENU = "//nav[contains(@class,'personal-about-nav')]//div[@data-target='%s']";

    public static final String AVATAR_IMAGE = "//div[@id ='js-timeline-avatar']" ;
    public static final String UPLOAD_AVATAR_ICON = "//div[@class = 'p-intro']//div[contains(@data-bind,'isEditingAvatar()')]";
    public static final String UPLOAD_AVATAR_FROM_LOCAL = "//div[contains(@data-bind,'onSelectAvatarFromLocal')]";
    public static final String UPLOAD_AVATAR_FROM_MEDIA_MANAGER = "//div[contains(@data-bind,'onSelectAvatarFromMediaManager')]";

    public static final String COVER_IMAGE = "//img[@id='js-image-cover']";
    public static final String UPLOAD_COVER_ICON = "//div[@class = 'p-cover']//div[contains(@data-bind,'isEditingAvatar()')]";
    public static final String UPLOAD_COVER_FROM_LOCAL = "//div[contains(@data-bind,'onSelectCoverFromLocal')]";
    public static final String UPLOAD_COVER_FROM_MEDIA_MANAGER = "//div[contains(@data-bind,'onSelectCoverFromMediaManager')]";
    public static final String ICON_LOADING_IMAGE ="//div[@id='js-loading-container']";

    public static final String ABOUT_MENU = "//nav[contains(@class,'personal-about-nav')]" ;
    public static final String ABOUT_ITEM_MENU = "//nav[contains(@class,'personal-about-nav')]//div[@data-target='%s']";
    public static final String PER_ABOUT = "//div[@class = 'personal-about']";
    public static final String TITLE_TAB_OF_ABOUT = "//div[@id = '%s']//div[@class = 'pageUI-about-heading']";




    // Popup cross image
    public static final String CROSS_IMAGE_POPUP = "//div[@id = 'js_crop_media']";
    public static final String BUTTON_SAVE_CROSS_IMAGE = "//button[contains(@data-bind,'onSaveAvatarCropp')]";
    public static final String VALIDATION_ERR_MESS ="//div[@class='toast-body']" ;
    public static final String BUTTON_SAVE_CHANGE_COVER = "//button[contains(@data-bind,'onSaveCover')]";





}
