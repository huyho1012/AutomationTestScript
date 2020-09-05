package Interfaces;

public class MediaManagementUI {

    public static final String MEDIA_MANAGEMENT_POPUP = "//div[@id= 'view-media-manager']";
    public static final String UPLOAD_BUTTON = "//button[contains(@data-bind,'onUpload')]";
    public static final String SELECT_BUTTON = "//button[contains(@data-bind,'onSelectMedia')]";

    public static final String ROOT_IMAGE = "//div[contains(@data-bind,'onCreateAlbum')]/ancestor::div[@id ='media-album-area']/following-sibling::div//div[@class='media-list']/div[@class = 'media-list__item'][1]";
    public static final String ROOT_LIST_IMAGE = "//div[contains(@data-bind,'onCreateAlbum')]/ancestor::div[@id ='media-album-area']/following-sibling::div//div[@class='media-list']";
}
