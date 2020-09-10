package Project.Business.Tour.Setting;

import Interfaces.Business.Tour.GeneralSetting.TourGeneralSettingPageUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class TourGeneralSettingPage extends HeaderPage {
    WebDriver driver;
    public TourGeneralSettingPage(WebDriver webDriver){
        driver = webDriver;
    }


    public void clickToItemOnTourInformationNav(WebDriver driver, String itemMenu){
        waitForElementClickable(driver, TourGeneralSettingPageUI.NAVBAR_MENU, itemMenu);
        clickToElement(driver,TourGeneralSettingPageUI.NAVBAR_MENU, itemMenu);
    }

    public void enterPrepaymentAmount(WebDriver driver, String s) {
    }

    public void enterCancellationAmount(WebDriver driver, String s) {
    }

    public void enterDayAllowToCancel(WebDriver driver, String s) {
    }

    public void clickToSaveButton(WebDriver driver) {
        waitForElementClickable(driver, TourGeneralSettingPageUI.BUTTON_SAVE_ON_BODY);
        clickToElement(driver,TourGeneralSettingPageUI.BUTTON_SAVE_ON_BODY);
    }

    public void clickToSettingVAT(WebDriver driver) {
    }

    public void chooseOptionVATInclude(WebDriver driver) {
        waitForElementClickable(driver, TourGeneralSettingPageUI.VAT_OPTION_1);
        clickToElement(driver, TourGeneralSettingPageUI.VAT_OPTION_1);
    }
    public void chooseOptionAddVAT(WebDriver driver, String valueVAT) {
        waitForElementClickable(driver, TourGeneralSettingPageUI.VAT_OPTION_2);
        clickToElement(driver, TourGeneralSettingPageUI.VAT_OPTION_2);
        waitElementToVisible(driver,TourGeneralSettingPageUI.VAT_VALUE_FIELD);
        sendKeyToElement(driver,TourGeneralSettingPageUI.VAT_VALUE_FIELD,valueVAT);
    }

    public void enterDataValueToTextFieldOnAgeSettingTab(WebDriver driver, String nameField, String valueData){
        waitElementToVisible(driver, TourGeneralSettingPageUI.DYNAMIC_TEXT_FIELD,nameField);
        sendKeyToElement(driver,TourGeneralSettingPageUI.DYNAMIC_TEXT_FIELD,valueData,nameField);
    }

    public void enterDataValueToTextFieldOnNotiOrder(WebDriver driver, String nameField, String valueData){
        waitElementToVisible(driver, TourGeneralSettingPageUI.DYNAMIC_TEXT_FIELD,nameField);
        sendKeyToElement(driver,TourGeneralSettingPageUI.DYNAMIC_TEXT_FIELD,valueData,nameField);
    }

    public void clickToEnableMode(WebDriver driver) {
        waitElementToVisible(driver,TourGeneralSettingPageUI.TITLE_OF_GENERAL_INFO);
        waitForElementClickable(driver,TourGeneralSettingPageUI.ENABLE_MODE);
        clickToElement(driver,TourGeneralSettingPageUI.ENABLE_MODE);
        setTimeDelay(1);
    }

    public void enterValueOnEmailAddress(WebDriver driver, String s) {
    }

    public void enterValueOnPhone(WebDriver driver, String s) {
    }

    public void clickToTopicTourOnMenu(WebDriver driver) {
    }

    public boolean checkTabPrepaymentAmountDisplay() {
        return true;
    }

    public boolean checkVATSettingPageDisplay(WebDriver driver) {
        waitElementToVisible(driver,TourGeneralSettingPageUI.TITLE_OF_GENERAL_INFO);
        if(getAttributeValue(driver,TourGeneralSettingPageUI.NAVBAR_MENU,"class","vat").contains("active")){
            return true;
        }
        else
            return false;
    }

    public boolean checkAgeSettingPageDisplay(WebDriver driver){
        waitElementToVisible(driver,TourGeneralSettingPageUI.TITLE_OF_GENERAL_INFO);
        if(getAttributeValue(driver,TourGeneralSettingPageUI.NAVBAR_MENU,"class","age").contains("active")){
            return true;
        }
        else
            return false;

    }

    public boolean checkNotiForOrderSettingPageDisplay(WebDriver driver) {
        waitElementToVisible(driver,TourGeneralSettingPageUI.TITLE_OF_GENERAL_INFO);
        if(getAttributeValue(driver,TourGeneralSettingPageUI.NAVBAR_MENU,"class","mail").contains("active")){
            return true;
        }
        else
            return false;
    }

    public void enterDataValueToTextFieldOnPrepaymentTab(WebDriver driver, String nameField, String valueData) {
        waitElementToVisible(driver, TourGeneralSettingPageUI.DYNAMIC_TEXT_FIELD,nameField);
        sendKeyToElement(driver,TourGeneralSettingPageUI.DYNAMIC_TEXT_FIELD,valueData,nameField);
    }
}
