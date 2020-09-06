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
        return false;
    }

    public void clickToCreateNewBusiness(WebDriver driver) {
        waitForElementClickable(driver, BusinessOverviewUI.CREATE_NEW_BUSINESS_ACCOUNT_BUTTON);
        clickToElement(driver, BusinessOverviewUI.CREATE_NEW_BUSINESS_ACCOUNT_BUTTON);

    }

    public void chooseTypeOfBusiness(WebDriver driver, String typeBusiness) {
        waitForElementClickable(driver, BusinessOverviewUI.TYPE_BUSINESS_CHECKBOX,typeBusiness);
        clickToElement(driver, BusinessOverviewUI.TYPE_BUSINESS_CHECKBOX,typeBusiness);
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
}
