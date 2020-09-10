package Project.Business.Business;

import Interfaces.Business.Business.BusinessInfoPageUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class BusinessInfoPage extends HeaderPage {
    WebDriver driver;
    public BusinessInfoPage(WebDriver webDriver){
        driver = webDriver;
    }

    public String getOwnerNameIsDisplay(WebDriver driver) {
        waitElementToVisible(driver, BusinessInfoPageUI.BUSINESS_INFORMATION_PAGE);
        return getTextElement(driver,BusinessInfoPageUI.OWNER_NAME_DISPLAYED);
    }

    public String getOwnerEmailIsDisplay(WebDriver driver) {
        waitElementToVisible(driver, BusinessInfoPageUI.BUSINESS_INFORMATION_PAGE);
        return getTextElement(driver,BusinessInfoPageUI.OWNER_EMAIL_DISPLAYED);
    }

    public void openBackendLoginPage(WebDriver driver) {
    }

    public boolean checkBusinessInfoPageIsDisplay() {
        waitElementToVisible(driver, BusinessInfoPageUI.BUSINESS_INFORMATION_PAGE);
        return getTextElement(driver, BusinessInfoPageUI.BUSINESS_INFORMATION_TITLE_PAGE).equalsIgnoreCase("Quản lý thông tin kinh doanh");
    }
}
