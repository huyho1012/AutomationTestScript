package Project.Backend;

import Common.HandleFunction.AbstractPage;
import Interfaces.Backend.BackEndCommonUI;
import org.openqa.selenium.WebDriver;

public class BackendHomePage extends AbstractPage {
    WebDriver driver;
    public BackendHomePage(WebDriver webDriver){
        driver = webDriver;
    }
    
    public boolean checkBusinessHomePageIsDisplaySuccess() {
        return true;
    }
    

    public void clickToItemOnNavbarMenu(WebDriver driver, String fieldName) {
        scrollIntoElementByJS(driver,BackEndCommonUI.ITEM_ON_NAVBAR_MENU,fieldName);
        clickToElementByJS(driver, BackEndCommonUI.ITEM_ON_NAVBAR_MENU,fieldName);
    }

    public void changeLanguageOfSystemToVi(WebDriver driver) {
    }
}
