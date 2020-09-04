package Project.Business.Business;

import Common.HandleFunction.AbstractPage;
import Interfaces.Business.BusinessVerificationUI;
import org.openqa.selenium.WebDriver;

public class BusinessVerificationPage extends AbstractPage {
    WebDriver driver;

    public BusinessVerificationPage(WebDriver webDriver) {
        driver = webDriver;
    }

    public void enterValueToDynamicFieldOfVerifyForm(WebDriver driver, String nameField, String valueData) {

    }

    public void chooseRegistrationDate(WebDriver driver, String valueDay, String valueMonth, String valueYear) {
        selectItemInDropdownByValue(driver, BusinessVerificationUI.SELECT_DAY_DROPDOWN, valueDay);
        selectItemInDropdownByValue(driver, BusinessVerificationUI.SELECT_MONTH_DROPDOWN, valueDay);
        selectItemInDropdownByValue(driver, BusinessVerificationUI.SELECT_YEAR_DROPDOWN, valueDay);
    }

    public void clickEnterToSearchAddress(WebDriver driver) {
    }

    public void clickToUploadDocumentVerify(WebDriver driver) {
    }

    public void clickToSendRequestVerify(WebDriver driver) {
    }

    public void clickToBackBusinessManagementPage(WebDriver driver) {
    }
}