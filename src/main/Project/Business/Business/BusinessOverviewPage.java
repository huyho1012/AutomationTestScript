package Project.Business.Business;

import Common.HandleFunction.AbstractTest;
import Interfaces.Business.BusinessOverviewUI;
import org.openqa.selenium.WebDriver;

public class BusinessOverviewPage extends AbstractTest {
    WebDriver driver;
    public BusinessOverviewPage(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkBusinessOverviewWithNewAccount(WebDriver driver) {
        return checkIsElementIsDisplay(driver, BusinessOverviewUI.CREATE_NEW_BUSINESS_ACCOUNT_BUTTON)
                && getTextElement(driver, BusinessOverviewUI.TITLE_OVERVIEW_BUSINESS).equalsIgnoreCase("Tạo tài khoản kinh doanh")
                && getTextElement(driver, BusinessOverviewUI.CONTENT_OVERVIEW_BUSINESS).equalsIgnoreCase("Bạn chưa sở hữu tài khoản kinh doanh, khởi tạo ngay để bắt đầu quá trình hoạt động kinh doanh trên Hahalolo cho doanh nghiệp của bạn. Với một tài khoản kinh doanh trên Hahalolo, bạn có thể điều hành, quản lý và phát triển doanh nghiệp một cách toàn diện.");
    }

    public void clickToCreateNewBusiness(WebDriver driver) {
        waitForElementClickable(driver, BusinessOverviewUI.CREATE_NEW_BUSINESS_ACCOUNT_BUTTON);
        clickToElement(driver, BusinessOverviewUI.CREATE_NEW_BUSINESS_ACCOUNT_BUTTON);
        setTimeDelay(1);
    }

    public void chooseTypeOfBusiness(WebDriver driver, String typeBusiness) {
        waitForElementClickable(driver, BusinessOverviewUI.TYPE_BUSINESS_CHECKBOX,typeBusiness);
        clickToElement(driver, BusinessOverviewUI.TYPE_BUSINESS_CHECKBOX,typeBusiness);
        setTimeDelay(1);
    }

    public void enterBusinessName(WebDriver driver, String businessName) {
        sendKeyToElement(driver,BusinessOverviewUI.BUSINESS_NAME_FIELD,businessName);
    }

    public void enterValueToUpdateOwnerName(WebDriver driver, String ownerName) {
        sendKeyToElement(driver,BusinessOverviewUI.OWNER_NAME_FIELD,ownerName);
    }

    public void enterValueToUpdateBusinessEmail(WebDriver driver, String businessEmail) {
        sendKeyToElement(driver,BusinessOverviewUI.BUSINESS_EMAIL_FIELD,businessEmail);
    }

    public void clickButtonToCreateBusiness(WebDriver driver) {
        waitForElementClickable(driver, BusinessOverviewUI.FINISH_CREATE_BUSINESS_BUTTON);
        clickToElement(driver, BusinessOverviewUI.FINISH_CREATE_BUSINESS_BUTTON);
    }

    public void clickToAccountManagementButton(WebDriver driver) {
    }

    public boolean checkOverViewPageWithHaveBusiness() {
        return true;
    }

    public boolean checkCreateBusinessPopupDisplay() {
        return checkIsElementIsDisplay(driver, BusinessOverviewUI.POP_UP_CREATE_BUSINESS,"show");
    }
}
