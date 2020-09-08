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
       waitElementToVisible(driver, BusinessDashboardPageUI.DASBOARD_PAGE);
       if(getTextElement(driver, BusinessDashboardPageUI.DASBOARD_TITLE).equalsIgnoreCase("Quản lý tài khoản kinh doanh")
           && checkElementDisplay(driver, BusinessDashboardPageUI.FORM_BUSI_INFO) && checkElementDisplay(driver, BusinessDashboardPageUI.FORM_BUSI_PAGE)
           && checkElementDisplay(driver, BusinessDashboardPageUI.FORM_BUSI_STAFF)){
           return true;
       }
       else return false;
    }

    public void clickCreatePageNowButton() {
        waitElementToVisible(driver, BusinessDashboardPageUI.DASBOARD_PAGE);
        waitForElementClickable(driver, BusinessDashboardPageUI.BUTTON_CREATE_PAGE_NOW);
        clickToElement(driver, BusinessDashboardPageUI.BUTTON_CREATE_PAGE_NOW);
        setTimeDelay(1);
    }

    public String getContentTitleOfSectionNoPage() {
        waitElementToVisible(driver, BusinessDashboardPageUI.DASBOARD_PAGE);
        return getTextElement(driver, BusinessDashboardPageUI.PAGE_SECTION_TITLE);
    }

    public boolean checkTitleCreateBusinessSuccess() {
        return getTextElement(driver, BusinessDashboardPageUI.TITLE_CREATE_NEW_BUSINESS_SUCCESS).equalsIgnoreCase("Chúc mừng bạn đã tạo tài khoản doanh nghiệp!");
    }
}
