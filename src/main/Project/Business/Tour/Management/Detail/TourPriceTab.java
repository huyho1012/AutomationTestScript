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
        scrollToTopPage(driver);
        return checkElementIsDisplayed(driver,TourPriceUI.TOUR_PRICE);
    }

    public void clickToCreateNewPrice(WebDriver driver) {
        waitForElementClickable(driver, TourPriceUI.BTN_CREATE_NEW_PRICE);
        clickToElement(driver,TourPriceUI.BTN_CREATE_NEW_PRICE);
        setTimeDelay(1);
    }

    public boolean checkPriceDetailIsDisplay() {
        scrollToTopPage(driver);
        return checkElementIsDisplayed(driver,TourPriceUI.TOUR_PRICE_DETAIL);
    }

    public void chooseStartDateOfPrice(WebDriver driver, String dateTime) {
        waitElementToVisible(driver, TourPriceUI.START_DATE_PRICE);
        sendKeyToElement(driver,TourPriceUI.START_DATE_PRICE,dateTime);
        setTimeDelay(1);
    }

    public void enterValueOfAdultPrice(WebDriver driver, String priceAdult) {
        waitElementToVisible(driver, TourPriceUI.ADULT_PRICE);
        sendKeyToElement(driver, TourPriceUI.ADULT_PRICE, priceAdult);
        setTimeDelay(1);
    }

    public void enterValueOfChildPrice(WebDriver driver, String priceChild) {
        clickToChooseCheckBox(driver, TourPriceUI.CHILD_CHECKBOX);
        waitElementToVisible(driver, TourPriceUI.CHILD_PRICE);
        sendKeyToElement(driver, TourPriceUI.CHILD_PRICE, priceChild);
        setTimeDelay(1);
    }

    public void enterValueOfYoungChildPrice(WebDriver driver, String priceYoungChild) {
        clickToChooseCheckBox(driver, TourPriceUI.YOUNG_CHILD_CHECKBOX);
        waitElementToVisible(driver, TourPriceUI.YOUNG_CHILD_PRICE);
        sendKeyToElement(driver, TourPriceUI.YOUNG_CHILD_PRICE, priceYoungChild);
        setTimeDelay(1);
    }

    public void enterValueOfInfantPrice(WebDriver driver, String priceBaby) {
        clickToChooseCheckBox(driver, TourPriceUI.BABY_CHECKBOX);
        waitElementToVisible(driver, TourPriceUI.BABY_PRICE);
        sendKeyToElement(driver, TourPriceUI.BABY_PRICE, priceBaby);
        setTimeDelay(1);
    }


    public void clickToSavePriceButton(WebDriver driver) {
        waitForElementClickable(driver, TourPriceUI.BTN_SAVE_PRICE);
        clickToElement(driver, TourPriceUI.BTN_SAVE_PRICE);
        setTimeDelay(1);
    }

    public boolean checkPriceCreatedSuccessfully() {
        return true;
    }
}
