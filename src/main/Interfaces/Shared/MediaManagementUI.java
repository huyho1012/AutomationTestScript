package Interfaces.Shared;

public class MediaManagementUI {

    public static final String MEDIA_MANAGEMENT_POPUP = "//div[@id= 'view-media-manager']";
    public static final String UPLOAD_BUTTON = "//button[contains(@data-bind,'onUpload')]";
    public static final String SELECT_BUTTON = "//button[contains(@data-bind,'onSelectMedia')]";


    public static final String ROOT_IMAGE = "//div[contains(@data-bind,'onCreateAlbum')]/ancestor::div[@id ='media-album-area']/following-sibling::div//div[contains(@class,'media-list__item')][position()= '1']//div[@class='media-list__thumb']";
    public static final String ROOT_LIST_IMAGE = "//div[contains(@data-bind,'onCreateAlbum')]/ancestor::div[@id ='media-album-area']/following-sibling::div//div[@class='media-list']";
    public static final String PROCESSING_BAR = "//div[contains(@data-bind,'onCreateAlbum')]/ancestor::div[@id ='media-album-area']/following-sibling::div//div[contains(@class,'media-list__item')][position()= '1']//div[@class='media-list__thumb']//div[contains(@data-bind,'text: progress()')][contains(text(),'100%')]";
}
