package Testcase;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.Timeline.NewsfeedPersonalTimeline;
import Project.Shared.Login_PageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UploadAvatar extends AbstractTest {

    WebDriver driver;
    DriverManager driverManager;
    Login_PageObject newsfeedLoginPageObject;
    NewsfeedHomepage newsfeedHomepage;
    NewsfeedPersonalTimeline personalTimeline;

    @Parameters("browser")
    @BeforeClass
    public void openNewBrowser(String browserName){
        driverManager = BrowserInitialization.getBrowser(browserName);
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        newsfeedLoginPageObject = PageGeneration.createNewsfeedLoginPage(driver);
//        newsfeedLoginPage.Login(driver, "balo_04@mailinator.com", "123456");
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);
        verifyTrue(newsfeedHomepage.checkNewsfeedDisplay());
        newsfeedHomepage.changeLanguageNewsfeedToVI();
    }

//    @BeforeTest
//    public void goToPersonalPage(){
//
////      verifyTrue(personalTimeline.checkPersonalTimePageIsDislay());
////      verifyEquals(personalTimeline.getFullNameOfUserDisplayOnHeader(),"");
//    }

    @Test
    public void Tescase01_Check_Validate_Of_File_Can_Use_To_Upload_Avatar_By_Local_Image(){
        newsfeedHomepage.clickToAvatarOnHeader(driver);
        personalTimeline = PageGeneration.createPersonalTimeLinePage(driver);
        log.info("Upload image has format jpg");
        personalTimeline.clickToUploadAvatarByLocalImage(driver,"FormatFile\\a1.jpg");
        personalTimeline.crossImage(driver);

        log.info("Upload image has format png");
        personalTimeline.clickToUploadAvatarByLocalImage(driver,"FormatFile\\a2.png");
        personalTimeline.crossImage(driver);

        log.info("Upload image has format gif");
        personalTimeline.clickToUploadAvatarByLocalImage(driver,"FormatFile\\gif.gif");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(driver),"Tập tin không đúng định dạng");

        log.info("Upload image has format ico");
        personalTimeline.clickToUploadAvatarByLocalImage(driver,"FormatFile\\ico.ico");
        personalTimeline.crossImage(driver);

        log.info("Upload image has format bmp");
        personalTimeline.clickToUploadAvatarByLocalImage(driver,"FormatFile\\image.bmp");
        personalTimeline.crossImage(driver);

        log.info("Upload image has format jpeg");
        personalTimeline.clickToUploadAvatarByLocalImage(driver,"FormatFile\\image1.jpeg");
        personalTimeline.crossImage(driver);

        log.info("Upload image has format tiff");
        personalTimeline.clickToUploadAvatarByLocalImage(driver,"FormatFile\\tiff.tiff");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(driver),"Tập tin không đúng định dạng");

        log.info("Upload image has format webp");
        personalTimeline.clickToUploadAvatarByLocalImage(driver,"FormatFile\\webp.webp");
        personalTimeline.crossImage(driver);
        log.info("Upload image has format tif");

        personalTimeline.clickToUploadAvatarByLocalImage(driver,"FormatFile\\tif.tif");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(driver),"Tập tin không đúng định dạng");

    }

    @Test
    public void Tescase02_Check_Validate_Of_File_Can_Use_To_Upload_Cover_By_Local_Image(){

        log.info("Upload image has format jpg");
        personalTimeline.clickToUploadCoverByLocalImage(driver,"FormatFile\\a1.jpg");
        personalTimeline.saveChangeImage(driver);

        log.info("Upload image has format png");
        personalTimeline.clickToUploadCoverByLocalImage(driver,"FormatFile\\a2.png");
        personalTimeline.saveChangeImage(driver);

        log.info("Upload image has format gif");
        personalTimeline.clickToUploadCoverByLocalImage(driver,"FormatFile\\gif.gif");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(driver),"Tập tin không đúng định dạng");

        log.info("Upload image has format ico");
        personalTimeline.clickToUploadCoverByLocalImage(driver,"FormatFile\\ico.ico");
        personalTimeline.saveChangeImage(driver);

        log.info("Upload image has format bmp");
        personalTimeline.clickToUploadCoverByLocalImage(driver,"FormatFile\\image.bmp");
        personalTimeline.saveChangeImage(driver);

        log.info("Upload image has format jpeg");
        personalTimeline.clickToUploadCoverByLocalImage(driver,"FormatFile\\image1.jpeg");
        personalTimeline.saveChangeImage(driver);

        log.info("Upload image has format tiff");
        personalTimeline.clickToUploadCoverByLocalImage(driver,"FormatFile\\tiff.tiff");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(driver),"Tập tin không đúng định dạng");

        log.info("Upload image has format webp");
        personalTimeline.clickToUploadCoverByLocalImage(driver,"FormatFile\\webp.webp");
        personalTimeline.saveChangeImage(driver);
        log.info("Upload image has format tif");

        personalTimeline.clickToUploadCoverByLocalImage (driver,"FormatFile\\tif.tif");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(driver),"Tập tin không đúng định dạng ne");

    }
}
