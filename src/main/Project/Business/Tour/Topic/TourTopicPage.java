package Project.Business.Tour.Topic;

import Interfaces.Business.Tour.Topic.TourTopicPageUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import Project.Shared.Management.MediaManagement;
import org.openqa.selenium.WebDriver;

public class TourTopicPage extends HeaderPage {
    WebDriver driver;
    MediaManagement media;
    public TourTopicPage(WebDriver webDriver){
        driver = webDriver;
    }

    public void clickCreateTopic(WebDriver driver) {
        waitElementToVisible(driver, TourTopicPageUI.TOPIC_PAGE);
        waitElementToVisible(driver, TourTopicPageUI.BUTTON_CREATE_NEW_TOPIC);
        clickToElement(driver, TourTopicPageUI.BUTTON_CREATE_NEW_TOPIC);
    }

    public void chooseTopicImage(WebDriver driver, String fileName) {
        media = new MediaManagement(driver);
        waitForElementClickable(driver,TourTopicPageUI.BUTTON_ADD_TOPIC_IMAGE);
        clickToElement(driver,TourTopicPageUI.BUTTON_ADD_TOPIC_IMAGE);
        media.uploadImageFromLocalToMedia(driver,fileName);
        media.selectOneImageOnMedia(driver);
    }

    public void chooseLanguageOfTopic(WebDriver driver , String langName) {
        clickToElementByJS(driver, TourTopicPageUI.LANGUAGE_ITEM,langName);
    }

    public void enterTopicName(WebDriver driver, String topicName) {
        waitForElementClickable(driver, TourTopicPageUI.TOPIC_NAME_FIELD);
        sendKeyToElement(driver, TourTopicPageUI.TOPIC_NAME_FIELD, topicName);
    }

    public void enterTopicDescription(WebDriver driver, String descTopic) {
        waitForElementClickable(driver, TourTopicPageUI.TOPIC_DESCRIPTION_TEXT_AREA);
        sendKeyToElement(driver, TourTopicPageUI.TOPIC_DESCRIPTION_TEXT_AREA, descTopic);
    }

    public void clickToSaveButton(WebDriver driver) {
        waitForElementClickable(driver, TourTopicPageUI.BUTTON_SAVE_TOPIC);
        clickToElement(driver, TourTopicPageUI.BUTTON_SAVE_TOPIC);
    }

    public boolean checkPageWithCaseNoTopicDisplay() {
        return checkElementDisplay(driver, TourTopicPageUI.BUTTON_CREATE_NEW_TOPIC);
    }

    public boolean checkCreatedTopicDisplay(WebDriver driver) {
        return true;
    }

    public boolean checkPopupCreateTopicDisplay() {
        return checkElementDisplay(driver,TourTopicPageUI.POPUP_EDIT_ADD_TOPIC);
    }


}
