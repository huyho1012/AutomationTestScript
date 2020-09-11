package Project.Newsfeed.PersonalWall;

import Interfaces.hahalolo_newsfeed.PersonaWall.PersonalHeadCoverUI;
import Interfaces.hahalolo_newsfeed.PersonaWall.PersonalUI;
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

    public boolean checkPageIsDisplay(String fullName) {
        waitElementToVisible(driver, PersonalHeadCoverUI.PERSONAL_PAGE);
        return getPageTitle(driver).equalsIgnoreCase("Giới thiệu - Trang cá nhân | Hahalolo")
                && getTextElement(driver, PersonalHeadCoverUI.HEADER_COVER_FULLNAME).equalsIgnoreCase(fullName);
    }
}
