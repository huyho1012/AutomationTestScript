package Project.Newsfeed.PersonalWall.Timeline;

import Project.Newsfeed.PersonalWall.PersonalCommon;
import org.openqa.selenium.WebDriver;

public class NewsfeedPersonalTimeline extends PersonalCommon {
    WebDriver driver;
    public NewsfeedPersonalTimeline(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPersonalTimePageIsDislay() {
        return true;
    }

    public Object getFullNameOfUserDisplayOnHeader() {
        return null;
    }
}
