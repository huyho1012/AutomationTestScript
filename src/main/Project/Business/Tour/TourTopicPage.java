package Project.Business.Tour;

import Common.HandleFunction.AbstractPage;;
import Interfaces.Business.Tour.Topic.TourTopicPageUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class TourTopicPage extends HeaderPage {
    WebDriver driver;
    public TourTopicPage(WebDriver webDriver){
        driver = webDriver;
    }

    public void clickCreateTopic(WebDriver driver) {
        waitElementToVisible(driver, TourTopicPageUI.TOPIC_PAGE);
        waitElementToVisible(driver, TourTopicPageUI.BUTTON_CREATE_NEW_TOPIC);
        clickToElement(driver, TourTopicPageUI.BUTTON_CREATE_NEW_TOPIC);
    }

    public void chooseTopicImage() {
    }

    public void chooseLanguageOfTopic(WebDriver driver) {
    }

    public void enterTopicName(WebDriver driver, String s) {
    }

    public void enterTopicDescription(WebDriver driver, String s) {
    }

    public void clickToSaveButton(WebDriver driver) {
    }

    public void clickToTourOnMenu(WebDriver driver) {
    }

    public boolean checkPageWithCaseNoTopicDisplay() {
        return true;
    }

    public boolean checkCreatedTopicDisplay(WebDriver driver) {
        return true;
    }

    public boolean checkPopupCreateTopicDisplay() {
        return true;
    }

    public boolean checkPopupCreateTourDisplay() {
        return true;
    }
}
