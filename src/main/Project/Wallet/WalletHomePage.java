package Project.Wallet;

import Common.HandleFunction.AbstractPage;
import Interfaces.Wallet.WalletHomePageUI;
import org.openqa.selenium.WebDriver;

public class WalletHomePage extends AbstractPage {
    WebDriver driver;
    public WalletHomePage(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPageIsDisplaySuccessfully() {
        waitForPageLoading(driver);
        if (checkIsElementIsDisplay(driver, WalletHomePageUI.MENU_WALLET) && checkIsElementIsDisplay(driver,WalletHomePageUI.AVAILABLE_COLLUM)
                && checkIsElementIsDisplay(driver,WalletHomePageUI.WAITING_COLLUM) &&  checkIsElementIsDisplay(driver,WalletHomePageUI.FROZEN_COLLUM)
                && checkIsElementIsDisplay(driver, WalletHomePageUI.PENDING_COLLUM)
                && getTextElement(driver, WalletHomePageUI.TYPE_DISPLAYED_ON_DROPDOWN).equalsIgnoreCase("Tài khoản thanh toán doanh nghiệp")) {
            return true
        }
        else {
            return false;
        }
    }

    public String getNameOfPaymentAccountDíplayOnPage() {
        waitForPageLoading(driver);
        waitElementToVisible(driver, WalletHomePageUI.MENU_WALLET);
        return getTextElement(driver,WalletHomePageUI.PAYMENT_ACCOUNT_NAME);
    }
}
