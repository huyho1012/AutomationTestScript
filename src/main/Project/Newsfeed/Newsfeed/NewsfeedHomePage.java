package Project.Newsfeed.Newsfeed;

import Common.HandleFunction.AbstractPage;
import Interfaces.Newsfeed.Homepage.HomePageUI;
import org.openqa.selenium.WebDriver;

public class NewsfeedHomePage extends HeaderPage {
    WebDriver driver;
    public NewsfeedHomePage(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean formFirstUpdateInfoIsDisplay(WebDriver driver) {
        return checkIsElementIsDisplay(driver, HomePageUI.FORM_UPDATE_NEW_INFO);
    }

    public String getTitleOfFormFirstUpdateInfo() {
        return getTextElement(driver, HomePageUI.FORM_UPDATE_NEW_INFO_TITLE);
    }

    public void updateBirthdayOfUser(WebDriver driver) {
    }

    public void updateGenderOfUser(WebDriver driver) {
    }

    public void updateNationalOfUser(WebDriver driver) {
    }

    public void clickToButtonConfirmForUpdateInfo(WebDriver driver) {
    }

    public void changeLanguageNewsfeedToVI(WebDriver driver) {
    }

    public String getFullNameDisplayOnMyAccount(WebDriver driver) {
        return getTextElement(driver, HomePageUI.MY_ACCOUNT_FULL_NAME);
    }

    public void clickToEditProfile(WebDriver driver) {
        waitForElementClickable(driver,HomePageUI.MY_ACCOUNT_EDIT_PROFILE_BUTTON);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_EDIT_PROFILE_BUTTON);
    }
}
