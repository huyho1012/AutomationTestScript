package Interfaces.hahalolo_newsfeed.PageWall;

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
}
