package Project.Business.Business;

import Common.HandleFunction.AbstractPage;
import Interfaces.Business.BusinessDashboardPageUI;
import org.openqa.selenium.WebDriver;

public class BusinessDashboardPage extends AbstractPage {

    WebDriver driver;
    public BusinessDashboardPage(WebDriver webDriver){
        driver = webDriver;
    }

    public String getStatusVerifyOfBusiness() {
        return null;
    }

    public void clickToVerifyBusiness(WebDriver driver) {
        waitForElementClickable(driver, BusinessDashboardPageUI.SEND_VERIFY_BUTTON);
        clickToElement(driver,BusinessDashboardPageUI.SEND_VERIFY_BUTTON );
    }

    public void clickToBusinessInfoTab(WebDriver driver) {
    }

    public void clickToPageItemOnMenu(WebDriver driver) {
    }
}
