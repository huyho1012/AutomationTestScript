package Project.Business.Business;

import Interfaces.hahalolo_business.Business.Business_Dashboard_PageUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class BusinessDashboardPage extends HeaderPage {

    WebDriver driver;
    public BusinessDashboardPage(WebDriver webDriver){
        driver = webDriver;
    }

    public String getStatusVerifyOfBusiness() {
        waitForPageLoading(driver);
        waitElementToVisible(driver, Business_Dashboard_PageUI.DASHBOARD_BUSINESS_PAGE);
        return getTextElement(driver, Business_Dashboard_PageUI.TITLE_CONTENT_VERIFY_BUSINESS);
    }

    public void clickToVerifyBusiness(WebDriver driver) {
        waitForElementClickable(driver, Business_Dashboard_PageUI.SEND_VERIFY_BUTTON);
        clickToElement(driver, Business_Dashboard_PageUI.SEND_VERIFY_BUTTON );
    }


    public boolean checkPageIsDisplaySuccessfully() {
       waitElementToVisible(driver, Business_Dashboard_PageUI.DASBOARD_PAGE);
        return getTextElement(driver, Business_Dashboard_PageUI.DASBOARD_TITLE).equalsIgnoreCase("Quản lý tài khoản kinh doanh")
                && checkElementIsDisplayed(driver, Business_Dashboard_PageUI.FORM_BUSI_INFO) && checkElementIsDisplayed(driver, Business_Dashboard_PageUI.FORM_BUSI_PAGE)
                && checkElementIsDisplayed(driver, Business_Dashboard_PageUI.FORM_BUSI_STAFF);
    }

    public void clickCreatePageNowButton() {
        waitElementToVisible(driver, Business_Dashboard_PageUI.DASBOARD_PAGE);
        waitForElementClickable(driver, Business_Dashboard_PageUI.BUTTON_CREATE_PAGE_NOW);
        clickToElement(driver, Business_Dashboard_PageUI.BUTTON_CREATE_PAGE_NOW);
        setTimeDelay(1);
    }

    public String getContentTitleOfSectionNoPage() {
        waitElementToVisible(driver, Business_Dashboard_PageUI.DASBOARD_PAGE);
        return getTextElement(driver, Business_Dashboard_PageUI.PAGE_SECTION_TITLE);
    }

    public boolean checkTitleCreateBusinessSuccess() {
        return getTextElement(driver, Business_Dashboard_PageUI.TITLE_CREATE_NEW_BUSINESS_SUCCESS).equalsIgnoreCase("Chúc mừng bạn đã tạo tài khoản doanh nghiệp!");
    }
}
