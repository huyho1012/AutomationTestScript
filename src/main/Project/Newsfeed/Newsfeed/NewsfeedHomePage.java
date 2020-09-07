package Project.Newsfeed.Newsfeed;

import Interfaces.Newsfeed.Homepage.HomePageUI;
import org.openqa.selenium.WebDriver;

public class NewsfeedHomePage extends HeaderPage {
    WebDriver driver;
    public NewsfeedHomePage(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean formFirstUpdateInfoIsDisplay() {
        waitElementToVisible(driver,HomePageUI.UPDATE_INFO_BUTTON);
        if(checkIsElementIsDisplay(driver, HomePageUI.FORM_UPDATE_NEW_INFO)){
            System.out.println(checkIsElementIsDisplay(driver, HomePageUI.FORM_UPDATE_NEW_INFO));
            return true;
        }else {
            System.out.println(checkIsElementIsDisplay(driver, HomePageUI.FORM_UPDATE_NEW_INFO));
            return false;
        }

    }

    public String getTitleOfFormFirstUpdateInfo() {
        System.out.println(getTextElement(driver, HomePageUI.FORM_UPDATE_NEW_INFO_TITLE));
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
        setTimeDelay(1);
    }
    public String getGenderOfUser(WebDriver driver, String valueGender) {
        return getTextElement(driver,HomePageUI.GENDER_OPTION,valueGender);
    }

    public void updateNationalOfUser(WebDriver driver, String countryName) {
        waitForElementClickable(driver,HomePageUI.COUNTRY_DROPDOWN);
        clickToElement(driver, HomePageUI.COUNTRY_DROPDOWN);
        clickToElement(driver, HomePageUI.COUNTRY_ITEM,countryName);
        setTimeDelay(1);
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

    public boolean checkNewsfeedDisplay(WebDriver driver) {
        waitElementToVisible(driver,HomePageUI.UPDATE_INFO_BUTTON);
        boolean s1 = getCurrentURL(driver).contains("https://www.hahalolo.com/");
        boolean s2 = getPageTitle(driver).contains("Bảng tin | Hahalolo");
        return getCurrentURL(driver).contains("https://www.hahalolo.com") && getPageTitle(driver).contains("Bảng tin | Hahalolo");
    }
}
