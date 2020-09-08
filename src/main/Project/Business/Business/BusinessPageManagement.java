package Project.Business.Business;

import Common.HandleFunction.AbstractPage;
import Interfaces.Business.Business.BusinessPageManagementUI;
import org.openqa.selenium.WebDriver;

public class BusinessPageManagement extends AbstractPage {
    WebDriver driver;
    public BusinessPageManagement(WebDriver webDriver){
        driver = webDriver;
    }

    public void choosePageType(WebDriver driver, String pageType) {
        clickToElementByJS(driver, BusinessPageManagementUI.PAGE_CATEGORY_ITEM,pageType);
    }

    public void enterPageNameToCreate(WebDriver driver, String pageName) {
        waitElementToVisible(driver,BusinessPageManagementUI.PAGE_NAME_FIELD);
        sendKeyToElement(driver, BusinessPageManagementUI.PAGE_NAME_FIELD, pageName);
    }

    public void clickToCreatePage(WebDriver driver) {
        waitElementToVisible(driver,BusinessPageManagementUI.POPUP_CREATE_NEW_PAGE);
        waitForElementClickable(driver, BusinessPageManagementUI.BUTTON_CREATE_PAGE);
    }

    public void clickPageManagementLinkToGoDetail(WebDriver driver, String pageName) {
        waitForElementClickable(driver,BusinessPageManagementUI.PAGE_MANAGEMENT,pageName);
        clickToElement(driver,BusinessPageManagementUI.PAGE_MANAGEMENT,pageName);
    }

    public boolean checkPageDisplaySuccess(WebDriver driver) {
        return getPageTitle(driver).contains("Hahalolo - Business Pages");

    }

    public boolean checkPopupCreatePageDisplay() {
        return getAttributeValue(driver, BusinessPageManagementUI.POPUP_CREATE_NEW_PAGE,"style").contains("display: block");
    }

    public boolean checkCreatedPageSuccess(WebDriver driver, String pageName) {
        if(getTextElement(driver, BusinessPageManagementUI.PAGE_NAME_ON_DETAIL).contains(pageName)
                && getTextElement(driver, BusinessPageManagementUI.PAGE_NAME_ON_PAGE_LIST).contains(pageName)){
            return true;
        } else
            return false;
    }

    public String getOwnerOfDirectPage(WebDriver driver, String pageName) {
        return getTextElement(driver,BusinessPageManagementUI.OWNER_PAGE_NAME,pageName);
    }

    public String getPageIdOfDirectPage(WebDriver driver, String pageName) {
        return getTextElement(driver,BusinessPageManagementUI.ID_OF_PAGE_NAME,pageName);
    }
}
