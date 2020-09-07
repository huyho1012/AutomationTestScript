package Project.Business.Business;

import Common.HandleFunction.AbstractPage;
import Interfaces.Business.BusinessDashboardPageUI;
import Interfaces.Business.BusinessVerificationUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class BusinessDashboardPage extends HeaderPage {

    WebDriver driver;
    public BusinessDashboardPage(WebDriver webDriver){
        driver = webDriver;
    }

    public String getStatusVerifyOfBusiness() {
        waitForPageLoading(driver);
        waitElementToVisible(driver,BusinessDashboardPageUI.DASHBOARD_BUSINESS_PAGE);
        return getTextElement(driver, BusinessDashboardPageUI.TITLE_CONTENT_VERIFY_BUSINESS);
    }

    public void clickToVerifyBusiness(WebDriver driver) {
        waitForElementClickable(driver, BusinessDashboardPageUI.SEND_VERIFY_BUTTON);
        clickToElement(driver,BusinessDashboardPageUI.SEND_VERIFY_BUTTON );
    }


    public boolean checkPageIsDisplaySuccessfully() {
        return true;
    }

    public void clickCreatePageNowButton() {
    }

    public Object getContentTitleOfSectionNoPage() {
        return null;
    }

    public boolean checkTitleCreateBusinessSuccess() {
        return getTextElement(driver, BusinessDashboardPageUI.TITLE_CREATE_NEW_BUSINESS_SUCCESS).equalsIgnoreCase("Chúc mừng bạn đã tạo tài khoản doanh nghiệp!");
    }
}
