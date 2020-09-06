package Project.Wallet;

import Common.HandleFunction.AbstractPage;
import org.openqa.selenium.WebDriver;

public class WalletHomePage extends AbstractPage {
    WebDriver driver;
    public WalletHomePage(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPageIsDisplaySuccessfully() {
        return true;
    }

    public Object getNameOfPaymentAccountDíplayOnPage() {
        return null;
    }
}
