package Interfaces.Business.Tour.Topic;

public class TourTopicPageUI {
    public static final String TOPIC_PAGE = "//div[@class= 'management-header']/div[contains(text(),'Danh sách chủ đề')]";
    public static final String BUTTON_CREATE_NEW_TOPIC = "//form[@class ='table-filter']//button[contains(@data-bind,'onShowModalAddTopic')]";
    public static final String POPUP_EDIT_ADD_TOPIC = "//div[@id ='modal__create-topic']";
    public static final String TITLE_POPUP_EDIT_ADD_TOPIC = "";
    public static final String BUTTON_ADD_TOPIC_IMAGE = "//button[contains(@data-bind,'uploadCover')]";
    public static final String LANGUAGE_ITEM = "//div[@id='modal__create-topic']//div[@data-value= '%s']";
    public static final String TOPIC_NAME_FIELD = "//input[@name = 'topicName']";
    public static final String TOPIC_DESCRIPTION_TEXT_AREA = "//textarea[contains(@data-bind,'topicDes')]";
    public static final String BUTTON_SAVE_TOPIC = "";
}
