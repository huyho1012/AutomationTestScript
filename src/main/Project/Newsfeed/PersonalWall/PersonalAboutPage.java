package Project.Newsfeed.PersonalWall;

import Common.HandleFunction.AbstractPage;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class PersonalAboutPage extends HeaderPage {
    WebDriver driver;
    public PersonalAboutPage(WebDriver webDriver){
        driver = webDriver;
    }

    public Object getEmailIsDisplayOnIntroduceWidget() {
        return  null;
    }

    public Object getBirthdayDisplayOnIntroduceWidget() {
        return  null;
    }

    public Object getGenderDisplayOnIntroduceWidget() {
        return  null;
    }
}
