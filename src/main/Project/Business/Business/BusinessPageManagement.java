package Project.Business.Business;

import Interfaces.hahalolo_business.Business.BusinessPageManagementUI;
import Project.Newsfeed.Newsfeed.HeaderPage;
import org.openqa.selenium.WebDriver;

public class BusinessPageManagement extends HeaderPage {
    WebDriver driver;
    public BusinessPageManagement(WebDriver webDriver){
        driver = webDriver;
    }

    public void choosePageType(WebDriver driver, String pageType) {
        clickToElementByJS(driver, BusinessPageManagementUI.PAGE_CATEGORY_ITEM,pageType);
        setTimeDelay(1);
    }

    public void enterPageNameToCreate(WebDriver driver, String pageName) {
        waitElementToVisible(driver,BusinessPageManagementUI.PAGE_NAME_FIELD);
        sendKeyToElement(driver, BusinessPageManagementUI.PAGE_NAME_FIELD, pageName);
        setTimeDelay(1);
    }

    public void clickToCreatePage(WebDriver driver) {
        waitElementToVisible(driver,BusinessPageManagementUI.POPUP_CREATE_NEW_PAGE);
        waitForElementClickable(driver, BusinessPageManagementUI.BUTTON_CREATE_PAGE);
        clickToElement(driver,BusinessPageManagementUI.BUTTON_CREATE_PAGE);
        setTimeDelay(1);
    }

    public void clickPageManagementLinkToGoDetail(WebDriver driver, String pageName) {
        waitForElementClickable(driver,BusinessPageManagementUI.PAGE_MANAGEMENT,pageName);
        clickToElement(driver,BusinessPageManagementUI.PAGE_MANAGEMENT,pageName);
        setTimeDelay(1);
    }

    public boolean checkPageDisplaySuccess(WebDriver driver) {
        return getPageTitle(driver).contains("Hahalolo - Business Pages");
    }

    public boolean checkPopupCreatePageDisplay() {
        System.out.println("Style of popup " + getAttributeValue(driver, BusinessPageManagementUI.POPUP_CREATE_NEW_PAGE,"style"));
        return getAttributeValue(driver, BusinessPageManagementUI.POPUP_CREATE_NEW_PAGE,"style").contains("display: block");
    }

    public boolean checkCreatedPageSuccess(WebDriver driver, String pageName) {
        waitElementToVisible(driver, BusinessPageManagementUI.BUTTON_OPEN_CREATE_PAGE_POPUP);
        waitElementToVisible(driver, BusinessPageManagementUI.BUTTON_ASSIGNED_PAGE);
        System.out.println("Page name on Details: " + getTextElement(driver, BusinessPageManagementUI.PAGE_NAME_ON_DETAIL));
        System.out.println("Page name on list: " + getTextElement(driver, BusinessPageManagementUI.PAGE_NAME_ON_PAGE_LIST));
        return getTextElement(driver, BusinessPageManagementUI.PAGE_NAME_ON_DETAIL).contains(pageName)
                && getTextElement(driver, BusinessPageManagementUI.PAGE_NAME_ON_PAGE_LIST).contains(pageName);
    }

    public String getOwnerOfDirectPage(WebDriver driver, String pageName) {
        System.out.println("Ownern of page: " + getTextElement(driver, BusinessPageManagementUI.OWNER_PAGE_NAME,pageName));
        return getTextElement(driver, BusinessPageManagementUI.OWNER_PAGE_NAME, pageName);
    }

    public String getPageIdOfDirectPage(WebDriver driver, String pageName) {
        System.out.println("Ownern of page: " + getTextElement(driver, BusinessPageManagementUI.ID_OF_PAGE_NAME,pageName));
        return getTextElement(driver,BusinessPageManagementUI.ID_OF_PAGE_NAME,pageName);
    }

    public void clickToCreatePageToDisplayPopupCreatePage() {
        waitForElementClickable(driver, BusinessPageManagementUI.BUTTON_OPEN_CREATE_PAGE_POPUP);
        clickToElement(driver, BusinessPageManagementUI.BUTTON_OPEN_CREATE_PAGE_POPUP);
    }
}
