package Interfaces.hahalolo_newsfeed.PersonaWall;

public class PersonalCommonUI {

    public static final String HEADER_SECTION = "//div[@id = 'js-header-cover']";

    public static final String BUTTON_UPLOAD_AVATAR = "//div[@class = 'p-intro']//div[contains(@data-bind,'isEditingAvatar()')]";
    public static final String UPLOAD_COVER_BY_LOCAL = "//div[contains(@data-bind,'onSelectCoverFromLocal')]";
    public static final String UPLOAD_COVER_BY_MEDIA = "//div[contains(@data-bind,'onSelectCoverFromMediaManager')]";


    public static final String BUTTON_UPLOAD_COVER = "//div[@class = 'p-cover']//div[contains(@data-bind,'isEditingAvatar()')]";
    public static final String UPLOAD_AVATAR_BY_LOCAL = "//div[contains(@data-bind,'onSelectAvatarFromLocal')]";
    public static final String UPLOAD_AVATAR_BY_MEDIA = "//div[contains(@data-bind,'onSelectAvatarFromMediaManager')]";
    public static final String CROSS_IMAGE_POPUP = "//div[@id = 'js_crop_media']";

    public static final String BUTTON_SAVE_CROSS_IMAGE = "//button[contains(@data-bind,'onSaveAvatarCropp')]";
    public static final String VALIDATION_ERR_MESS ="//div[@class='toast-body']" ;
    public static final String BUTTON_SAVE_CHANGE_COVER = "//button[contains(@data-bind,'onSaveCover')]";


    public static final String HEADER_COVER_FULLNAME = "//div[@class='p-info__name']/span";

    public static final String PERSONAL_PAGE =  "//div[contains(@class, 'p-header--user')] ";
    public static final String ABOUT_MENU = "//nav[contains(@class,'personal-about-nav')]" ;
    public static final String ABOUT_ITEM_MENU = "//nav[contains(@class,'personal-about-nav')]//div[@data-target='#about_overview']";


    public static final String PER_ABOUT = "//div[@class = 'personal-about']";
    public static final String TITLE_TAB_OF_ABOUT = "//div[@id = '%s']//div[@class = 'pageUI-about-heading']";
    public static final String COVER_IMAGE = "//img[@id='js-image-cover']";
    public static final String AVATAR_IMAGE = "//div[@id ='js-timeline-avatar']" ;
}
