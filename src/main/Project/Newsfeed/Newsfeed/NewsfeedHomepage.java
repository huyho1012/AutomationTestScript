package Project.Newsfeed.Newsfeed;

import Interfaces.hahalolo_newsfeed.HeaderPageUI;
import Interfaces.hahalolo_newsfeed.Homepage.HomePageUI;
import org.openqa.selenium.WebDriver;

public class NewsfeedHomepage extends HeaderPage {
    WebDriver driver;
    public NewsfeedHomepage(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean formFirstUpdateInfoIsDisplay() {
        waitElementToVisible(driver,HomePageUI.UPDATE_INFO_BUTTON);
        return checkElementDisplay(driver, HomePageUI.FORM_UPDATE_NEW_INFO);
    }

    public String getTitleOfFormFirstUpdateInfo() {
        return getTextElement(driver, HomePageUI.FORM_UPDATE_NEW_INFO_TITLE);
    }

    public void updateBirthdayOfUser(WebDriver driver, String dayItem, String monthItem, String yearItem) {
        selectItemInCustomDropdown(driver,HomePageUI.DYNAMIC_BIRTHDAY_DROPDOWN, HomePageUI.DYNAMIC_BIRTHDAY_ITEM,dayItem,"day");
        setTimeDelay(1);
        selectItemInCustomDropdown(driver,HomePageUI.DYNAMIC_BIRTHDAY_DROPDOWN, HomePageUI.DYNAMIC_BIRTHDAY_ITEM,monthItem,"month");
        setTimeDelay(1);
        selectItemInCustomDropdown(driver,HomePageUI.DYNAMIC_BIRTHDAY_DROPDOWN, HomePageUI.DYNAMIC_BIRTHDAY_ITEM,yearItem,"year");
        setTimeDelay(1);
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
        setTimeDelay(1);
    }

    public void changeLanguageNewsfeedToVI() {
        waitForElementClickable(driver,HomePageUI.FOOTER_VI_LANGUAGE);
        clickToElement(driver, HomePageUI.FOOTER_VI_LANGUAGE);
        setTimeDelay(3);
    }

    public String getFullNameDisplayOnMyAccount(WebDriver driver) {
        return getTextElement(driver, HomePageUI.MY_ACCOUNT_FULL_NAME);
    }

    public void clickToEditProfile(WebDriver driver) {
        waitForElementClickable(driver,HomePageUI.MY_ACCOUNT_EDIT_PROFILE_BUTTON);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_EDIT_PROFILE_BUTTON);
        setTimeDelay(1);
    }

    public boolean checkNewsfeedDisplay(){
        waitElementToVisible(driver, HeaderPageUI.MAIN_SEARCH);
        return getCurrentURL(driver).equals("https://test-newsfeed.hahalolo.com/") && getPageTitle(driver).equalsIgnoreCase("Bảng tin | Hahalolo");
    }

    public boolean checkNewsfeedDisplayOnFirstTime(WebDriver driver) {
        return checkNewsfeedDisplay() && checkElementDisplay(driver, HomePageUI.FORM_UPDATE_NEW_INFO);
    }

    public void clickCancelUpdateNewInfo() {
        waitForElementClickable(driver, HomePageUI.CANCEL_UPDATE_INFO);
        clickToElement(driver, HomePageUI.CANCEL_UPDATE_INFO);
        setTimeDelay(1);
    }


    public boolean checkSiteCommunityIsDisplay(WebDriver driver){
        return checkElementDisplay(driver, HomePageUI.COMMUNITY_SITES_NAME);
    }

    public void checkCountOfSite(WebDriver driver){
        int countNumber = countElementNumber(driver,HomePageUI.COMMUNITY_SITES_NUMBERLIST);
        int countCurrent = countElementNumber(driver, HomePageUI.COMMUNITY_SITES_LIST);
        do{
            clickToElement(driver,HomePageUI.COMMUNITY_SITES_VIEW_MORE);
        } while (countCurrent == countNumber);
        clickToElement(driver, HomePageUI.COMMUNITY_SITES_NAME,"Page Cộng Đồng 1");
    }
    public void goToSite(WebDriver driver) {
        waitElementToVisible(driver, HomePageUI.COMMUNITY_SITES_LIST);
        int countCurrent = countElementNumber(driver, HomePageUI.COMMUNITY_SITES_LIST);
//        do {
//            int n = 0;
//            if (getTextElement(driver, HomePageUI.COMMUNITY_SITES_LIST).contains("Page Cộng Đồng 1")) {
//                waitForElementClickable(driver,HomePageUI.COMMUNITY_SITES_NAME, "Page Cộng Đồng 1");
//                clickToElementByJS(driver, HomePageUI.COMMUNITY_SITES_NAME, "Page Cộng Đồng 1");
//                System.out.println("Do action 1");
//            }
//            else{
//                clickToElement(driver, HomePageUI.COMMUNITY_SITES_VIEW_MORE);
//                setTimeDelay(3);
//                System.out.println("Click View more");
//            }
//        } while (n == countCurrent);
//        System.out.println(countCurrent);
//        System.out.println(countNumber);

        for( int i =1 ; i <= countCurrent; i++){
            if (getTextElement(driver, HomePageUI.COMMUNITY_SITES_LIST).contains("Page Cộng Đồng 1")) {
                waitForElementClickable(driver,HomePageUI.COMMUNITY_SITES_NAME, "Page Cộng Đồng 1");
                clickToElementByJS(driver, HomePageUI.COMMUNITY_SITES_NAME, "Page Cộng Đồng 1");
                System.out.println("Do action click to page");
            }
            else {
                if(i %3 ==0){
                    clickToElement(driver, HomePageUI.COMMUNITY_SITES_VIEW_MORE);
                    System.out.println("Do action click show more");
                }
            }
        }

    }

}
