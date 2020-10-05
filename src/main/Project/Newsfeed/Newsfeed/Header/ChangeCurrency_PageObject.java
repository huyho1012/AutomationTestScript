package Project.Newsfeed.Newsfeed.Header;

import Interfaces.hahalolo_newsfeed.Header.HeaderPageUI;
import Interfaces.hahalolo_newsfeed.Header.Model_Currency_PageUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class ChangeCurrency_PageObject extends HeaderPage {

    WebDriver driver;
    public ChangeCurrency_PageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkModelChangeCurrencyIsDisplay(){
        return checkElementIsDisplayed(driver, Model_Currency_PageUI.MODEL_CURRENCY);
    }

    public String getTextOfModelChangeCurrency(){
        waitElementToVisible(driver, Model_Currency_PageUI.MODEL_CURRENCY);
        return getTextElement(driver, Model_Currency_PageUI.TITLE_MODEL);
    }

    public String getCurrencyDisplayOnHeaderMenu(){
        waitElementToVisible(driver, HeaderPageUI.HOMEPAGE_LINK);
        return getTextElement(driver, HeaderPageUI.CURRENCY_ICON);
    }

    public void clickCloseModelChangeCurrency(){
        waitForElementClickable(driver, Model_Currency_PageUI.BUTTON_CLOSE_MODEL);
        clickToElement(driver, Model_Currency_PageUI.BUTTON_CLOSE_MODEL);
    }


    public void clickOverChangeCurrencyModel() {
    }

    public void clickToButtonCloseOnModel() {
    }

    public void clickToChangeCurrencyOnModelChange(String currencyCode) {
        waitElementToVisible(driver, Model_Currency_PageUI.MODEL_CURRENCY);
        waitForElementClickable(driver, Model_Currency_PageUI.CURRENCY_ITEM, currencyCode);
        clickToElement(driver, Model_Currency_PageUI.CURRENCY_ITEM,currencyCode);
    }
}
