package Project.Business.Tour.Setting;

import Interfaces.hahalolo_business.Tour.GeneralSetting.PublishPageUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class PubishPage extends HeaderPage {
    WebDriver driver;
    public PubishPage(WebDriver webDriver) {
        driver = webDriver;
    }

    public boolean checkPublishPageIsDisplay(WebDriver driver){
        if(checkElementDisplay(driver, PublishPageUI.TITLE_PAGE) && checkElementDisplay(driver, PublishPageUI.BUTTON_PUBLISH_PAGE)){
            return true;
        }
        else
            return false;
    }

    public void publishPage(WebDriver driver){
        if(!checkStatusOfPublishButton(driver)){
            waitForElementClickable(driver, PublishPageUI.BUTTON_PUBLISH_PAGE);
            clickToElement(driver,PublishPageUI.BUTTON_PUBLISH_PAGE);
        }
    }

    public void unPublishPage(WebDriver driver){
        if(checkStatusOfPublishButton(driver)){
            waitForElementClickable(driver, PublishPageUI.BUTTON_PUBLISH_PAGE);
            clickToElement(driver,PublishPageUI.BUTTON_PUBLISH_PAGE);
        }
    }

    public boolean checkStatusOfPublishButton(WebDriver driver) {
        if(getCSSValueOfElement(driver, PublishPageUI.BUTTON_PUBLISH_PAGE,"background-color").contains("#166986")
            && getCSSValueOfElement(driver, PublishPageUI.BUTTON_PUBLISH_PAGE,"border-color").contains("#166986")){
            return  true;
        }
        else
            return false;
    }

    public String getTextOFToastMessage(WebDriver driver){
        waitForElementInvisible(driver, PublishPageUI.TOAST_MESSAGE);
        return getTextElement(driver, PublishPageUI.TOAST_MESSAGE);
    }
}

