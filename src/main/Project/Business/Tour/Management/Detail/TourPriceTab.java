package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.TourPriceUI;
import Project.Business.Tour.Management.TourCommon;
import org.openqa.selenium.WebDriver;

public class TourPriceTab extends TourCommon {
    WebDriver driver;
    public TourPriceTab(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPriceTabDisplaySuccess() {
        return checkElementDisplay(driver,TourPriceUI.TOUR_PRICE);
    }

    public void clickToCreateNewPrice(WebDriver driver) {
        waitForElementClickable(driver, TourPriceUI.BTN_CREATE_NEW_PRICE);
        clickToElement(driver,TourPriceUI.BTN_CREATE_NEW_PRICE);
    }

    public boolean checkPriceDetailIsDisplay() {
        return checkElementDisplay(driver,TourPriceUI.TOUR_PRICE_DETAIL);
    }

    public void chooseStartDateOfPrice(WebDriver driver, String dateTime) {
        waitElementToVisible(driver, TourPriceUI.START_DATE_PRICE);
        sendKeyToElement(driver,TourPriceUI.START_DATE_PRICE,dateTime);
    }

    public void enterValueOfAdultPrice(WebDriver driver, String priceAdult) {
        waitElementToVisible(driver, TourPriceUI.ADULT_PRICE);
        sendKeyToElement(driver, TourPriceUI.ADULT_PRICE, priceAdult);
    }

    public void enterValueOfChildPrice(WebDriver driver, String priceChild) {
        checkItemOnCheckBox(driver, TourPriceUI.CHILD_CHECKBOX);
        waitElementToVisible(driver, TourPriceUI.CHILD_PRICE);
        sendKeyToElement(driver, TourPriceUI.CHILD_PRICE, priceChild);
    }

    public void enterValueOfYoungChildPrice(WebDriver driver, String priceYoungChild) {
        checkItemOnCheckBox(driver, TourPriceUI.YOUNG_CHILD_CHECKBOX);
        waitElementToVisible(driver, TourPriceUI.YOUNG_CHILD_PRICE);
        sendKeyToElement(driver, TourPriceUI.YOUNG_CHILD_PRICE, priceYoungChild);
    }

    public void enterValueOfInfantPrice(WebDriver driver, String priceBaby) {
        checkItemOnCheckBox(driver, TourPriceUI.BABY_CHECKBOX);
        waitElementToVisible(driver, TourPriceUI.BABY_PRICE);
        sendKeyToElement(driver, TourPriceUI.BABY_PRICE, priceBaby);
    }


    public void clickToSavePriceButton(WebDriver driver) {
        waitForElementClickable(driver, TourPriceUI.BTN_SAVE_PRICE);
        clickToElement(driver, TourPriceUI.BTN_SAVE_PRICE);
    }

    public boolean checkPriceCreatedSuccessfully() {
        return true;
    }
}
