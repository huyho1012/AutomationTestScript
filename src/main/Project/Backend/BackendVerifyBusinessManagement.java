package Project.Backend;

import Common.HandleFunction.AbstractPage;
import org.openqa.selenium.WebDriver;

public class BackendVerifyBusinessManagement extends AbstractPage {
    WebDriver driver;
    public BackendVerifyBusinessManagement(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterEmailBusinessForSearch(WebDriver driver, String s) {
    }

    public void clickToFilterButton(WebDriver driver) {
    }

    public void clickVerifyButton(WebDriver driver) {
    }

    public void clickConfirmButtonOnPopup(WebDriver driver) {
    }

    public void goToWalletLoginPage(WebDriver driver) {
    }

    public boolean checkPageIsDisplaySuccess() {
        return true;
    }

    public Object getStatusOfBusinessVerification() {
        return null;
    }
}
