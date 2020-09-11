package Project.Wallet;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_wallet.WalletOverviewUI;
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

    public void clickCreateBusinessPaymentAccount(WebDriver driver ) {
        waitForElementClickable(driver,WalletOverviewUI.BUTTON_CREATE_BUSI_PAYMENT_ACCOUNT);
        clickToElement(driver,WalletOverviewUI.BUTTON_CREATE_BUSI_PAYMENT_ACCOUNT);
    }

    public boolean checkPageIsDisplayedSuccessfully() {
        return(checkElementDisplay(driver, WalletOverviewUI.TITLE_OVERVIEW_WALLET));
    }

    public boolean checkCreatePaymentAccountPopupIsDisplay() {
        System.out.println(getAttributeValue(driver,WalletOverviewUI.POPUP_CREATE_PAYMENT_ACCOUNT,"style"));
        return getAttributeValue(driver, WalletOverviewUI.POPUP_CREATE_PAYMENT_ACCOUNT, "style").contains("display: block");
    }

    public void clickToFinishButton(WebDriver driver) {
        waitForElementClickable(driver,WalletOverviewUI.FINISH_BUTTON);
        clickToElement(driver, WalletOverviewUI.FINISH_BUTTON);
        setTimeDelay(1);
    }
}
