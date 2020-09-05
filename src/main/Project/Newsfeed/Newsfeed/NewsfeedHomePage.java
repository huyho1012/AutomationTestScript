package Project.Newsfeed.Newsfeed;

import Interfaces.Newsfeed.Homepage.HomePageUI;
import org.openqa.selenium.WebDriver;

public class NewsfeedHomePage extends HeaderPage {
    WebDriver driver;
    public NewsfeedHomePage(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean formFirstUpdateInfoIsDisplay(WebDriver driver) {
        System.out.println("dã vào đây");
        return checkIsElementIsDisplay(driver, HomePageUI.FORM_UPDATE_NEW_INFO);
    }

    public String getTitleOfFormFirstUpdateInfo() {
        System.out.println("dã vào đây");
        return getTextElement(driver, HomePageUI.FORM_UPDATE_NEW_INFO_TITLE);
    }

    public void updateBirthdayOfUser(WebDriver driver, String dayItem, String monthItem, String yearItem) {
        waitForElementClickable(driver,HomePageUI.DYNAMIC_BIRTHDAY_DROPDOWN,"day");
        clickToElement(driver, HomePageUI.DYNAMIC_BIRTHDAY_DROPDOWN ,"day");
        clickToElement(driver, HomePageUI.DYNAMIC_BIRTHDAY_ITEM,"day",dayItem);
        setTimeDelay(1);
        waitForElementClickable(driver,HomePageUI.DYNAMIC_BIRTHDAY_DROPDOWN,"month");
        clickToElement(driver, HomePageUI.DYNAMIC_BIRTHDAY_DROPDOWN,"month");
        clickToElement(driver, HomePageUI.DYNAMIC_BIRTHDAY_ITEM,"month",monthItem);
        setTimeDelay(1);
        waitForElementClickable(driver,HomePageUI.DYNAMIC_BIRTHDAY_DROPDOWN,"year");
        clickToElement(driver, HomePageUI.DYNAMIC_BIRTHDAY_DROPDOWN,"year");
        clickToElement(driver, HomePageUI.DYNAMIC_BIRTHDAY_ITEM,"year",yearItem);
    }

    public void updateGenderOfUser(WebDriver driver, String valueGender) {
        waitForElementClickable(driver,HomePageUI.GENDER_OPTION,valueGender);
        clickToElement(driver, HomePageUI.GENDER_OPTION,valueGender);
    }
    public String getGenderOfUser(WebDriver driver, String valueGender) {
        return getTextElement(driver,HomePageUI.GENDER_OPTION,valueGender);
    }

    public void updateNationalOfUser(WebDriver driver, String countryName) {
        waitForElementClickable(driver,HomePageUI.COUNTRY_DROPDOWN);
        clickToElement(driver, HomePageUI.COUNTRY_DROPDOWN);
        clickToElement(driver, HomePageUI.COUNTRY_ITEM,countryName);
    }

    public void clickToButtonConfirmForUpdateInfo(WebDriver driver) {
        waitForElementClickable(driver,HomePageUI.UPDATE_INFO_BUTTON);
        clickToElement(driver, HomePageUI.UPDATE_INFO_BUTTON);
    }

    public void changeLanguageNewsfeedToVI(WebDriver driver) {
        waitForElementClickable(driver,HomePageUI.FOOTER_VI_LANGUAGE);
        clickToElement(driver, HomePageUI.FOOTER_VI_LANGUAGE);
    }

    public String getFullNameDisplayOnMyAccount(WebDriver driver) {
        return getTextElement(driver, HomePageUI.MY_ACCOUNT_FULL_NAME);
    }

    public void clickToEditProfile(WebDriver driver) {
        waitForElementClickable(driver,HomePageUI.MY_ACCOUNT_EDIT_PROFILE_BUTTON);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_EDIT_PROFILE_BUTTON);
    }
}
