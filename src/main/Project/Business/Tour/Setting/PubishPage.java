package Project.Business.Tour.Setting;

import Interfaces.hahalolo_business.Tour.GeneralSetting.PublishPageUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class PubishPage extends HeaderPage {
    WebDriver driver;
    public PubishPage(WebDriver webDriver) {
        driver = webDriver;
    }

    public boolean checkPublishPageIsDisplay(WebDriver driver){
        return checkElementIsDisplayed(driver, PublishPageUI.TITLE_PAGE) && checkElementIsDisplayed(driver, PublishPageUI.BUTTON_PUBLISH_PAGE);
    }

    public void publishPage(WebDriver driver){
        waitForElementClickable(driver, PublishPageUI.BUTTON_PUBLISH_PAGE);
        clickToElement(driver,PublishPageUI.BUTTON_PUBLISH_PAGE);
        setTimeDelay(1);
    }

    public void unPublishPage(WebDriver driver){
        waitForElementClickable(driver, PublishPageUI.BUTTON_PUBLISH_PAGE);
        clickToElement(driver,PublishPageUI.BUTTON_PUBLISH_PAGE);
        setTimeDelay(1);
    }


    public Boolean checkStatusOfPage (WebDriver driver) {
        String rgb = Color.fromString(getAttributeClassWithAfter(driver, ".custom-control-label","background-color")).asHex();
        if(rgb.equals("#166986")){
            System.out.println("Page publish");
            return true;
        }
        else {
            System.out.println("Page unpublish");
            return false;
        }
    }

    public String getTextOFToastMessage(WebDriver driver){
        waitForElementInvisible(driver, PublishPageUI.TOAST_MESSAGE);
        return getTextElement(driver, PublishPageUI.TOAST_MESSAGE);
    }
}

