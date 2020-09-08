package Project.Business.Tour;

import Common.HandleFunction.AbstractTest;
import Interfaces.Business.Tour.TourGeneralSettingPageUI;
import org.openqa.selenium.WebDriver;

public class TourGeneralSettingPage extends AbstractTest {
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

    public void chooseOptionVAT(WebDriver driver, String option) {
        if(option == ""){
            clickToElement(driver, TourGeneralSettingPageUI.VAT_OPTION_1);
        }
        else {
            String vatValue = "5";
            clickToElement(driver,TourGeneralSettingPageUI.VAT_OPTION_2);
            waitElementToVisible(driver, TourGeneralSettingPageUI.VAT_VALUE_FIELD, vatValue);
        }
    }

    public void clickToSettingAge(WebDriver driver) {
    }

    public void enterValueOfAdultAge(WebDriver driver, String s) {
    }

    public void enterValueOfChildAge(WebDriver driver, String s) {
    }

    public void enterValueOfYoungChildAge(WebDriver driver, String s) {
    }

    public void clickToSettingOrderNoti(WebDriver driver) {
    }

    public void clickToEnableAllowNotiOrder(WebDriver driver) {
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
        return true;
    }

    public boolean checkAgeSettingPageDisplay(WebDriver driver) {
        return true;
    }

    public boolean checkNotiForOrderSettingPageDisplay(WebDriver driver) {
        return true;
    }

    public void enterDataValueToTextFieldOnPrepaymentTab(WebDriver driver, String nameField, String valueData) {
        waitElementToVisible(driver, TourGeneralSettingPageUI.DYNAMIC_TEXT_FIELD,nameField);
        sendKeyToElement(driver,TourGeneralSettingPageUI.DYNAMIC_TEXT_FIELD,nameField,valueData);
    }
}
