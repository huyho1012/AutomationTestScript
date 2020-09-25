package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.PersonalUI;
import org.openqa.selenium.WebDriver;

public class PerAbout_Overview_PageObject extends PersonalAboutPage {
    WebDriver driver;
    public PerAbout_Overview_PageObject(WebDriver webDriver){
        driver = webDriver;
    }
    public String getEmailIsDisplayOnIntroduceWidget(String fullname) {
        if(checkPersonalPageIsDisplay(fullname)){
            return getTextElement(driver, PersonalUI.WIDGET_INTRO_EMAIL);
        }
        return null;
    }

    public String getBirthdayDisplayOnIntroduceWidget(String fullname) {
        if(checkPersonalPageIsDisplay(fullname)){
            return getTextElement(driver, PersonalUI.WIDGET_INTRO_BIRTHDAY);
        }
        return null;
    }

    public String getGenderDisplayOnIntroduceWidget(String fullname) {
        if(checkPersonalPageIsDisplay(fullname)){
            return getTextElement(driver, PersonalUI.WIDGET_INTRO_GENDER);
        }
        return null;
    }


}
