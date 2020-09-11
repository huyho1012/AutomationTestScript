package Project.Shared.Management;

import Common.HelperFunction.AbstractPage;
import Interfaces.Shared.MediaManagementUI;
import org.openqa.selenium.WebDriver;

public class MediaManagement extends AbstractPage {
    WebDriver driver;
    public MediaManagement(WebDriver webDriver){
        driver = webDriver;
    }

    public void uploadImageFromLocalToMedia(WebDriver driver, String fileName){
        waitElementToVisible(driver, MediaManagementUI.UPLOAD_BUTTON);
        clickToElement(driver, MediaManagementUI.UPLOAD_BUTTON);
        uploadMultipleFileByAutoIT(driver,fileName);
        setTimeDelay(1);
    }
    public void selectOneImageOnMedia(WebDriver driver){
        waitElementToVisible(driver,MediaManagementUI.MEDIA_MANAGEMENT_POPUP);
        clickToElement(driver, MediaManagementUI.ROOT_IMAGE);
        waitForElementClickable(driver,MediaManagementUI.SELECT_BUTTON);
        clickToElement(driver,MediaManagementUI.SELECT_BUTTON);
        setTimeDelay(1);
    }
    public void selectMoreImageOnMedia(WebDriver driver){
        waitElementToVisible(driver,MediaManagementUI.MEDIA_MANAGEMENT_POPUP);
        int n = findElements(driver, MediaManagementUI.ROOT_LIST_IMAGE).size();
        for(int i =0 ;i <n ; i++) {
            clickToElement(driver, MediaManagementUI.ROOT_IMAGE, String.valueOf(i));
        }
        clickToElement(driver,MediaManagementUI.SELECT_BUTTON);
    }
}
