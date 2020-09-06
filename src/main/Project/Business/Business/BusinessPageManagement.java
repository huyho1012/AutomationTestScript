package Project.Business.Business;

import org.openqa.selenium.WebDriver;

public class BusinessPageManagement {
    WebDriver driver;
    public BusinessPageManagement(WebDriver webDriver){
        driver = webDriver;
    }

    public void clickButtonCreateNewPage(WebDriver driver) {
    }

    public void choosePageType(WebDriver driver) {
    }

    public void enterPageNameToCreate(WebDriver driver, String s) {
    }

    public void clickToCreatePage(WebDriver driver) {
    }

    public void clickPageManagementLinkToGoDetail(WebDriver driver) {
    }

    public boolean checkPageDisplaySuccess() {
        return true;
    }

    public boolean checkPopupCreatePageDisplay() {
        return true;
    }

    public boolean checkCreatedPageSuccess() {
        return true;
    }

    public boolean getOwnerOfDirectPage() {
        return true;
    }

    public String getPageIdOfDirectPage() {
        return null;
    }
}
