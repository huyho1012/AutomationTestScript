package Interfaces.Newsfeed.Homepage;

import Common.HandleFunction.AbstractPage;
import org.openqa.selenium.WebDriver;

public class NewsfeedHomePage extends AbstractPage {
    WebDriver driver;
    public NewsfeedHomePage(WebDriver webDriver){
        driver = webDriver;
    }
}
