package Project.Wallet;

import Common.HandleFunction.AbstractPage;
import Interfaces.Wallet.WalletHomepageUI;
import org.openqa.selenium.WebDriver;

public class WalletHomePage extends AbstractPage {
    WebDriver driver;
    public WalletHomePage(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkBusinessPaymentAccountPageDisplay() {
        waitForPageLoading(driver);
        if (checkElementDisplay(driver, WalletHomepageUI.MENU_WALLET) && checkElementDisplay(driver, WalletHomepageUI.AVAILABLE_COLLUM)
                && checkElementDisplay(driver, WalletHomepageUI.WAITING_COLLUM) && checkElementDisplay(driver, WalletHomepageUI.FROZEN_COLLUM)
                && checkElementDisplay(driver, WalletHomepageUI.PENDING_COLLUM)
                && getTextElement(driver, WalletHomepageUI.TYPE_DISPLAYED_ON_DROPDOWN).equalsIgnoreCase("Tài khoản thanh toán doanh nghiệp")) {
            return true;
        } return false;
    }

    public String getPaymentAccName() {
        waitForPageLoading(driver);
        waitElementToVisible(driver, WalletHomepageUI.MENU_WALLET);
        return getTextElement(driver, WalletHomepageUI.PAYMENT_ACCOUNT_NAME);
    }
}
