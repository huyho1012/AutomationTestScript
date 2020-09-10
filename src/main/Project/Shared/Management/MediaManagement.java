package Project.Shared.Management;

import Common.HandleFunction.AbstractPage;
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
        clickToElement(driver,MediaManagementUI.SELECT_BUTTON);
    }
}
