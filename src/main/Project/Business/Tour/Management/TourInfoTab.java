package Project.Business.Tour.Management;

import Common.HandleFunction.AbstractPage;
import Interfaces.Business.Tour.Management.TourInfoTabUI;
import org.openqa.selenium.WebDriver;

public class TourInfoTab extends AbstractPage {
    WebDriver driver;
    public TourInfoTab(WebDriver webDriver){
        driver = webDriver;
    }



    public void enterValueToSKUField(WebDriver driver, String skuCode) {
        waitElementToVisible(driver, TourInfoTabUI.SKU_FIELD);
        sendKeyToElement(driver,TourInfoTabUI.SKU_FIELD, skuCode);
    }

    public void enterValueOfTotalTour(WebDriver driver, String totalDay) {
        waitElementToVisible(driver, TourInfoTabUI.TOTAL_DAY_FIELD);
        sendKeyToElement(driver,TourInfoTabUI.TOTAL_DAY_FIELD, totalDay);
    }

    public void enterValueOfPriceBasic(WebDriver driver, String basicPrice) {
        waitElementToVisible(driver, TourInfoTabUI.BASIC_PRICE_FIELD);
        sendKeyToElement(driver,TourInfoTabUI.BASIC_PRICE_FIELD, basicPrice);
    }

    public void enterValueOfTimeAllowBooking(WebDriver driver, String allowBookingTime) {
        waitElementToVisible(driver, TourInfoTabUI.ALLOW_BOOKING_FIELD);
        sendKeyToElement(driver,TourInfoTabUI.ALLOW_BOOKING_FIELD, allowBookingTime);
    }

    public void enterValueOfTAddress(WebDriver driver, String address) {
        waitElementToVisible(driver, TourInfoTabUI.ADDRESS_FIELD);
        sendKeyToElement(driver,TourInfoTabUI.ADDRESS_FIELD, address);
    }

    public void chooseCountry(WebDriver driver, String countryName) {
        selectItemInDropdownByText(driver,TourInfoTabUI.COUNTRY_DROPDOWN, countryName);
    }

    public void chooseCityState(WebDriver driver, String cityName) {
        selectItemInDropdownByText(driver,TourInfoTabUI.CITY_DROPDOWN, cityName);
    }

    public void chooseWard(WebDriver driver, String wardName) {
        selectItemInDropdownByText(driver,TourInfoTabUI.WARD_DROPDOWN, wardName);
    }

    public void enterValueOfShortDesc(WebDriver driver, String shortDesc) {
        waitElementToVisible(driver, TourInfoTabUI.SHORT_DESC_TEXT_AREA);
        sendKeyToElement(driver,TourInfoTabUI.SHORT_DESC_TEXT_AREA, shortDesc);
    }

    public void enterValueOPrivateRegulations(WebDriver driver, String regulation) {
        waitElementToVisible(driver, TourInfoTabUI.REGULATION_TEXT_AREA);
        sendKeyToElement(driver,TourInfoTabUI.REGULATION_TEXT_AREA, regulation);
    }

    public void enterValueOPolicy(WebDriver driver, String policy) {
        waitElementToVisible(driver, TourInfoTabUI.POLICY_TEXT_AREA);
        sendKeyToElement(driver,TourInfoTabUI.POLICY_TEXT_AREA, policy);
    }

    public void enterValueOInstallmentPolicy(WebDriver driver, String installmentPolicy) {
        waitElementToVisible(driver, TourInfoTabUI.INSTALLMENT_POLICY_TEXT_AREA);
        sendKeyToElement(driver,TourInfoTabUI.INSTALLMENT_POLICY_TEXT_AREA, installmentPolicy);
    }

    public void chooseTourLogo(WebDriver driver) {
    }

    public void chooseTourCover(WebDriver driver) {
    }

    public void chooseTourGallery(WebDriver driver) {
    }

    public void clickToButtonSaveTour() {
        waitForElementClickable(driver,TourInfoTabUI.SAVE_TOUR_BUTTON);
        clickToElement(driver,TourInfoTabUI.SAVE_TOUR_BUTTON);
    }
}
