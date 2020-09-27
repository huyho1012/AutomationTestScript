package Project.Newsfeed.Newsfeed;

import Interfaces.hahalolo_newsfeed.Header.HeaderPageUI;
import Interfaces.hahalolo_newsfeed.Homepage.HomePageUI;
import org.openqa.selenium.WebDriver;

public class  NewsfeedHomepage extends HeaderPage {
    WebDriver driver;
    public NewsfeedHomepage(WebDriver webDriver){
        driver = webDriver;
    }

    // Chức năng Cập nhật thông tin tài khoản
    // Hàm kiểm tra form cập nhật thông tin đối với trường hợp đắng ký mới
    public boolean formFirstUpdateInfoIsDisplay() {
        waitElementToVisible(driver,HomePageUI.UPDATE_INFO_BUTTON);
        return checkElementDisplay(driver, HomePageUI.FORM_UPDATE_NEW_INFO);
    }

    //
    public String getTitleOfFormFirstUpdateInfo() {
        return getTextElement(driver, HomePageUI.FORM_UPDATE_NEW_INFO_TITLE);
    }

    // hàm cập nhậtNga
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
    }

    public String getFullNameDisplayOnMyAccount() {
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
    }

    public void updateNewInformationOfAccount(String dayItem, String monthItem, String yearItem, String gender, String nationality){
        updateBirthdayOfUser(driver, dayItem,monthItem,yearItem);
        setTimeDelay(2);
        updateGenderOfUser(driver, gender);
        setTimeDelay(2);
        updateNationalOfUser(driver, nationality);
    }

    public boolean checkModelCurrencyCloseSuccess() {
        return true;
    }

    public String getCurrencyCodeDisplayOnHeader() {
        return null;
    }

    public Object getCurrencySymbolOnTourProduct() {
        return null;
    }

    public void clickToTabItemOnNewsfeedNavigationMenu(String tabItem) {
    }

    public Object getCurrencySymbolOnHotelProduct() {
        return null;
    }

    public Object getCurrencySymbolOnShoppingProductPost() {
        return null;
    }
}
