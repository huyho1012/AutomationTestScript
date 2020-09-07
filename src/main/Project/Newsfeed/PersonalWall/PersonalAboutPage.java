package Project.Newsfeed.PersonalWall;

import Common.HandleFunction.AbstractPage;
import Interfaces.Newsfeed.PersonaWall.PersonalUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class PersonalAboutPage extends HeaderPage {
    WebDriver driver;
    public PersonalAboutPage(WebDriver webDriver){
        driver = webDriver;
    }

    public String getEmailIsDisplayOnIntroduceWidget() {
        return getTextElement(driver, PersonalUI.WIDGET_INTRO_EMAIL);
    }

    public Object getBirthdayDisplayOnIntroduceWidget() {
        return getTextElement(driver, PersonalUI.WIDGET_INTRO_BIRTHDAY);
    }

    public Object getGenderDisplayOnIntroduceWidget() {
        return getTextElement(driver, PersonalUI.WIDGET_INTRO_GENDER);
    }

    public boolean checkPageIsDisplay() {
        return true;
    }
}
