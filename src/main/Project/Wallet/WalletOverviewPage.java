package Project.Wallet;

import Common.HandleFunction.AbstractPage;
import Interfaces.Wallet.WalletOverviewUI;
import org.openqa.selenium.WebDriver;

public class WalletOverviewPage extends AbstractPage {
    WebDriver driver;
    public WalletOverviewPage(WebDriver webDriver){
        driver = webDriver;
    }

    public void clickButtonCreateWallet(WebDriver driver) {
    }

    public void enterPaymentAccountName(WebDriver driver, String paymentAccountName) {
        waitElementToVisible(driver,WalletOverviewUI.PAYMENT_ACCOUNT_NAME_FIELD);
        sendKeyToElement(driver,WalletOverviewUI.PAYMENT_ACCOUNT_NAME_FIELD,paymentAccountName);
    }

    public void chooseCurrencyOfAccount(WebDriver driver, String currencyName) {
        selectItemInCustomDropdown(driver, WalletOverviewUI.CURRENCY_DROPDOWN, WalletOverviewUI.CURRENCY_ITEM, currencyName);
    }

    public void clickCreateBusinessPaymentAccount(WebDriver drive ) {
        waitForElementClickable(driver,WalletOverviewUI.BUTTON_CREATE_BUSINESS_PAYMENT_ACCOUNT);
        clickToElement(driver,WalletOverviewUI.BUTTON_CREATE_BUSINESS_PAYMENT_ACCOUNT);
    }

    public boolean checkPageIsDisplayedSuccessfully() {
        if(checkIsElementIsDisplay(driver, WalletOverviewUI.TITLE_OVERVIEW_WALLET)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkCreatePaymentAccountPopupIsDisplay() {
        return true;
    }

    public void clickToFinishButtonToCreatePaymentAccount(WebDriver driver) {
        waitForElementClickable(driver,WalletOverviewUI.FINISH_BUTTON);
        clickToElement(driver, WalletOverviewUI.FINISH_BUTTON);
    }
}
