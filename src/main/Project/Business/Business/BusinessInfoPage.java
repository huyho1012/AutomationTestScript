package Project.Business.Business;

import Interfaces.hahalolo_business.Business.Business_Information_PageUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class BusinessInfoPage extends HeaderPage {
    WebDriver driver;
    public BusinessInfoPage(WebDriver webDriver){
        driver = webDriver;
    }

    public String getOwnerNameIsDisplay(WebDriver driver) {
        waitElementToVisible(driver, Business_Information_PageUI.BUSINESS_INFORMATION_PAGE);
        return getTextElement(driver, Business_Information_PageUI.OWNER_NAME);
    }

    public String getOwnerEmailIsDisplay(WebDriver driver) {
        waitElementToVisible(driver, Business_Information_PageUI.BUSINESS_INFORMATION_PAGE);
        return getTextElement(driver, Business_Information_PageUI.OWNER_EMAIL);
    }

    public void openBackendLoginPage(WebDriver driver) {
    }

    public boolean checkBusinessInfoPageIsDisplay() {
        waitElementToVisible(driver, Business_Information_PageUI.BUSINESS_INFORMATION_PAGE);
        return getTextElement(driver, Business_Information_PageUI.BUSINESS_INFORMATION_TITLE_PAGE).equalsIgnoreCase("Quản lý thông tin kinh doanh");
    }
}
