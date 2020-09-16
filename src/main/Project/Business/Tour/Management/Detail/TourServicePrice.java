package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.TourServicePriceUI;
import Project.Business.Tour.Management.TourCommon;
import org.openqa.selenium.WebDriver;

public class TourServicePrice extends TourCommon {
    WebDriver driver;
    public TourServicePrice(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkTourServicePriceTab(WebDriver driver) {
         waitElementToVisible(driver, TourServicePriceUI.TAB_PRICE_SERVICE);
         return true;
    }

    public void clickButtonCreateNewPrice() {
        waitForElementClickable(driver, TourServicePriceUI.BUTTON_CREATE_PRICE);
        clickToElement(driver, TourServicePriceUI.BUTTON_CREATE_PRICE);
    }

    public void enterPriceOfService(WebDriver driver, String price) {
        int positionField = 0;
        if(!checkPageHaveServicePrice()){
            waitElementToVisible(driver, TourServicePriceUI.SERVICE_PRICE_FIELD, String.valueOf(1));
            sendKeyToElement(driver, TourServicePriceUI.SERVICE_PRICE_FIELD, price, String.valueOf(1));
        }
        else {
            int n = findElements(driver, TourServicePriceUI.SERVICE_PRICE_LIST).size();
            waitElementToVisible(driver, TourServicePriceUI.SERVICE_PRICE_FIELD, String.valueOf(n+1));
            sendKeyToElement(driver, TourServicePriceUI.SERVICE_PRICE_FIELD, price, String.valueOf(n+1));
        }

    }

    private boolean checkPageHaveServicePrice() {
        waitElementToVisible(driver, TourServicePriceUI.TAB_PRICE_SERVICE);
        if(checkElementDisplay(driver,TourServicePriceUI.SELECTED_SERIVCE)){
            return  true;
        }
        else return false;
    }

    public void choooseServiceOnDropdown() {
        int positionField = 0;
        if(!checkPageHaveServicePrice()){
            waitElementToVisible(driver, TourServicePriceUI.SERVICE_DROP_LiST, String.valueOf(1));
            selectItemInCustomDropdownByScroll(driver, TourServicePriceUI.SERVICE_PRICE_FIELD, TourServicePriceUI.SERVICE_DROP_ITEM,"Phòng view công viên", String.valueOf(1));
        }
        else {
            int n = findElements(driver, TourServicePriceUI.SERVICE_PRICE_LIST).size();
            waitElementToVisible(driver, TourServicePriceUI.SERVICE_DROP_LiST, String.valueOf(n+1));
            selectItemInCustomDropdownByScroll(driver, TourServicePriceUI.SERVICE_PRICE_FIELD, TourServicePriceUI.SERVICE_DROP_ITEM,"Phòng view công viên", String.valueOf(n+1));
        }
    }


}
