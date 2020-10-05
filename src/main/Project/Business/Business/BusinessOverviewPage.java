package Project.Business.Business;

import Common.HelperFunction.AbstractTest;
import Interfaces.hahalolo_business.Business.Business_Overview_PageUI;
import org.openqa.selenium.WebDriver;

public class BusinessOverviewPage extends AbstractTest {
    WebDriver driver;
    public BusinessOverviewPage(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkBusinessOverviewWithNewAccount(WebDriver driver) {
        waitElementToVisible(driver, Business_Overview_PageUI.OVERVIEW_DASHBOARD);
        return checkElementIsDisplayed(driver, Business_Overview_PageUI.CREATE_NEW_BUSINESS_ACCOUNT_BUTTON)
                && getTextElement(driver, Business_Overview_PageUI.TITLE_OVERVIEW_BUSINESS).equalsIgnoreCase("Tạo tài khoản kinh doanh")
                && getTextElement(driver, Business_Overview_PageUI.CONTENT_OVERVIEW_BUSINESS).equalsIgnoreCase("Bạn chưa sở hữu tài khoản kinh doanh, khởi tạo ngay để bắt đầu quá trình hoạt động kinh doanh trên Hahalolo cho doanh nghiệp của bạn. Với một tài khoản kinh doanh trên Hahalolo, bạn có thể điều hành, quản lý và phát triển doanh nghiệp một cách toàn diện.");
    }

    public boolean checkOverViewPageWithHaveBusiness() {
        return checkElementIsDisplayed(driver, Business_Overview_PageUI.BUTTON_BUSI_MANAGEMENT)
                && getTextElement(driver, Business_Overview_PageUI.TITLE_OVERVIEW_BUSINESS).equalsIgnoreCase("Quản lý tài khoản");
    }

    public void clickToCreateNewBusiness(WebDriver driver) {
        waitForElementClickable(driver, Business_Overview_PageUI.CREATE_NEW_BUSINESS_ACCOUNT_BUTTON);
        clickToElement(driver, Business_Overview_PageUI.CREATE_NEW_BUSINESS_ACCOUNT_BUTTON);
        setTimeDelay(1);
    }

    public void chooseTypeOfBusiness(WebDriver driver, String typeBusiness) {
        waitForElementClickable(driver, Business_Overview_PageUI.TYPE_BUSINESS_CHECKBOX,typeBusiness);
        clickToElement(driver, Business_Overview_PageUI.TYPE_BUSINESS_CHECKBOX,typeBusiness);
        setTimeDelay(1);
    }

    public void enterBusinessName(WebDriver driver, String businessName) {
        sendKeyToElement(driver, Business_Overview_PageUI.BUSINESS_NAME_FIELD,businessName);
    }

    public void enterValueToUpdateOwnerName(WebDriver driver, String ownerName) {
        sendKeyToElement(driver, Business_Overview_PageUI.OWNER_NAME_FIELD,ownerName);
    }

    public void enterValueToUpdateBusinessEmail(WebDriver driver, String businessEmail) {
        sendKeyToElement(driver, Business_Overview_PageUI.BUSINESS_EMAIL_FIELD,businessEmail);
    }

    public void clickButtonToCreateBusiness(WebDriver driver) {
        waitForElementClickable(driver, Business_Overview_PageUI.FINISH_CREATE_BUSINESS_BUTTON);
        clickToElement(driver, Business_Overview_PageUI.FINISH_CREATE_BUSINESS_BUTTON);
    }

    public void clickToAccountManagementButton(WebDriver driver) {
        waitForElementClickable(driver, Business_Overview_PageUI.BUTTON_BUSI_MANAGEMENT);
        clickToElement(driver, Business_Overview_PageUI.BUTTON_BUSI_MANAGEMENT);
        setTimeDelay(1);
    }

    public boolean checkCreateBusinessPopupDisplay() {
        return checkElementIsDisplayed(driver, Business_Overview_PageUI.POP_UP_CREATE_BUSINESS,"show");
    }
}
