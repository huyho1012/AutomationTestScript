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
        waitForElementClickable(driver,BusinessPageManagementUI.PAGE_MANAGEMENT_LINK,pageName);
        clickToElement(driver,BusinessPageManagementUI.PAGE_MANAGEMENT_LINK,pageName);
        setTimeDelay(1);
    }

    public boolean checkPageDisplaySuccess(WebDriver driver) {
        waitElementToVisible(driver,BusinessPageManagementUI.HEADER_TITLE_PAGE);
        if(checkElementDisplay(driver, BusinessPageManagementUI.BUTTON_CREATE_PAGE) && getTextElement(driver,BusinessPageManagementUI.HEADER_TITLE_PAGE).equalsIgnoreCase("Danh sách trang")){
            return true;
        }
        else
            return false;
    }

    public boolean checkPopupCreatePageDisplay() {
        return checkElementDisplay(driver, BusinessPageManagementUI.POPUP_CREATE_NEW_PAGE);
    }

    public boolean checkCreatedPageSuccess(WebDriver driver, String pageName) {
        waitElementToVisible(driver, BusinessPageManagementUI.BUTTON_CREATE_NEW_PAGE);
        waitElementToVisible(driver, BusinessPageManagementUI.BUTTON_ASSIGNED_PAGE);
        return getTextElement(driver, BusinessPageManagementUI.PAGE_NAME_ON_DETAIL).contains(pageName)
                && getTextElement(driver, BusinessPageManagementUI.PAGE_NAME_ON_LIST).contains(pageName);
    }

    public String getOwnerOfDirectPage(WebDriver driver, String pageName) {
        System.out.println("Ownern of page: " + getTextElement(driver, BusinessPageManagementUI.OWNER_PAGE,pageName));
        return getTextElement(driver, BusinessPageManagementUI.OWNER_PAGE, pageName);
    }

    public String getPageIdOfDirectPage(WebDriver driver, String pageName) {
        System.out.println("Ownern of page: " + getTextElement(driver, BusinessPageManagementUI.ID_PAGE,pageName));
        return getTextElement(driver,BusinessPageManagementUI.ID_PAGE,pageName);
    }

    public void clickToCreatePageToDisplayPopupCreatePage() {
        waitForElementClickable(driver, BusinessPageManagementUI.BUTTON_CREATE_NEW_PAGE);
        clickToElement(driver, BusinessPageManagementUI.BUTTON_CREATE_NEW_PAGE);
    }
}
