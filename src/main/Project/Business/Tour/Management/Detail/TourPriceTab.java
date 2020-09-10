package Project.Business.Tour.Management.Detail;

import Project.Business.Tour.Management.TourCommon;
import org.openqa.selenium.WebDriver;

public class TourPriceTab extends TourCommon {
    WebDriver driver;
    public TourPriceTab(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPriceTabDisplaySuccess() {
        return true;
    }

    public void clickToCreateNewPrice(WebDriver driver) {
    }

    public boolean checkPriceDetailIsDisplay() {
        return true;
    }

    public void chooseStartDateOfPrice(WebDriver driver) {
    }

    public void enterValueOfAdultPrice(WebDriver driver, String s) {
    }

    public void enterValueOfChildPrice(WebDriver driver, String s) {
    }

    public void enterValueOfYoungChildPrice(WebDriver driver, String s) {
    }

    public void enterValueOfInfantPrice(WebDriver driver, String s) {
    }

    public void clickToSavePriceButton(WebDriver driver) {
    }

    public boolean checkPriceCreatedSuccessfully() {
        return true;
    }
}
