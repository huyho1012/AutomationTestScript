package Project.Wallet;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_wallet.WalletHomepageUI;
import org.openqa.selenium.WebDriver;

public class WalletHomePage extends AbstractPage {
    WebDriver driver;
    public WalletHomePage(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkBusinessPaymentAccountPageDisplay() {
        waitForPageLoading(driver);
        return checkElementIsDisplayed(driver, WalletHomepageUI.MENU_WALLET) && checkElementIsDisplayed(driver, WalletHomepageUI.AVAILABLE_COLLUM)
                && checkElementIsDisplayed(driver, WalletHomepageUI.WAITING_COLLUM) && checkElementIsDisplayed(driver, WalletHomepageUI.FROZEN_COLLUM)
                && checkElementIsDisplayed(driver, WalletHomepageUI.PENDING_COLLUM)
                && getTextElement(driver, WalletHomepageUI.TYPE_DISPLAYED_ON_DROPDOWN).equalsIgnoreCase("Tài khoản thanh toán doanh nghiệp");
    }

    public String getPaymentAccName() {
        waitForPageLoading(driver);
        waitElementToVisible(driver, WalletHomepageUI.MENU_WALLET);
        return getTextElement(driver, WalletHomepageUI.PAYMENT_ACCOUNT_NAME);
    }
}
