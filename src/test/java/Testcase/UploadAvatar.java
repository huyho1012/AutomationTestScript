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
    Login_PageObject newsfeedLoginPage;
    NewsfeedHomepage newsfeedHomepage;
    NewsfeedPersonalTimeline personalTimeline;

    String accountEmail = GlobalVariables.USER_EMAIL_ACCOUNT;
    String accountPass = GlobalVariables.USER_EMAIL_PASSWORD;

    @Parameters("browser")
    @BeforeClass
    public void openNewBrowser(String browserName){
        log.info("Create Driver");
        driverManager = BrowserInitialization.getBrowser(browserName);
        log.info("Open Browser and Go to Newsfeed Hahalolo");
        driver = driverManager.getDriver(GlobalVariables.NEWSFEED_URL);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);
        log.info("Change Newsfeed Hahalolo system to VI");
        newsfeedLoginPage.clickToChangeLanguageToVI(driver);
        log.info("Login Newsfeed Hahalolo");
        newsfeedLoginPage.LoginNewsfeedHahalolo(accountEmail, accountPass);
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);
        log.info("Verify Newsfeed Homepage display successfully");
        verifyTrue(newsfeedHomepage.checkNewsfeedDisplay());
        log.info("Go to personal wall");
        newsfeedHomepage.clickToAvatarOnHeader(driver);
        personalTimeline = PageGeneration.createPersonalTimeLinePage(driver);
    }

    @Test
    public void TC01_Check_Update_Avatar_By_Image_Format(){
        log.info("Image format is jpg");
        personalTimeline.clickToUploadAvatarByLocalImage("FormatFile\\a1.jpg");
        personalTimeline.crossAvatarImage();

        log.info("Image format is png");
        personalTimeline.clickToUploadAvatarByLocalImage("FormatFile\\a2.png");
        personalTimeline.crossAvatarImage();

        log.info("Image format is gif");
        personalTimeline.clickToUploadAvatarByLocalImage("FormatFile\\gif.gif");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(driver),"Tập tin không đúng định dạng");

        log.info("Image format is ico");
        personalTimeline.clickToUploadAvatarByLocalImage("FormatFile\\ico.ico");
        personalTimeline.crossAvatarImage();

        log.info("Image format is bmp");
        personalTimeline.clickToUploadAvatarByLocalImage("FormatFile\\image.bmp");
        personalTimeline.crossAvatarImage();

        log.info("Image format is jpeg");
        personalTimeline.clickToUploadAvatarByLocalImage("FormatFile\\image1.jpeg");
        personalTimeline.crossAvatarImage();

        log.info("Image format is tiff");
        personalTimeline.clickToUploadAvatarByLocalImage("FormatFile\\tiff.tiff");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(driver),"Tập tin không đúng định dạng");

        log.info("Image format is webp");
        personalTimeline.clickToUploadAvatarByLocalImage("FormatFile\\webp.webp");
        personalTimeline.crossAvatarImage();

        log.info("Image format is tif");
        personalTimeline.clickToUploadAvatarByLocalImage("FormatFile\\tif.tif");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(driver),"Tập tin không đúng định dạng");
    }

    @Test
    public void TC02_Check_Update_Cover_By_Image_Format(){
        log.info("Image format is jpg");
        personalTimeline.clickToUploadCoverByLocalImage(driver,"FormatFile\\a1.jpg");
        personalTimeline.saveChangeImage(driver);

        log.info("Image format is png");
        personalTimeline.clickToUploadCoverByLocalImage(driver,"FormatFile\\a2.png");
        personalTimeline.saveChangeImage(driver);

        log.info("Image format is gif");
        personalTimeline.clickToUploadCoverByLocalImage(driver,"FormatFile\\gif.gif");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(driver),"Tập tin không đúng định dạng");

        log.info("Image format is ico");
        personalTimeline.clickToUploadCoverByLocalImage(driver,"FormatFile\\ico.ico");
        personalTimeline.saveChangeImage(driver);

        log.info("Image format is bmp");
        personalTimeline.clickToUploadCoverByLocalImage(driver,"FormatFile\\image.bmp");
        personalTimeline.saveChangeImage(driver);

        log.info("Image format is jpeg");
        personalTimeline.clickToUploadCoverByLocalImage(driver,"FormatFile\\image1.jpeg");
        personalTimeline.saveChangeImage(driver);

        log.info("Image format is tiff");
        personalTimeline.clickToUploadCoverByLocalImage(driver,"FormatFile\\tiff.tiff");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(driver),"Tập tin không đúng định dạng");

        log.info("Image format is webp");
        personalTimeline.clickToUploadCoverByLocalImage(driver,"FormatFile\\webp.webp");
        personalTimeline.saveChangeImage(driver);

        log.info("Image format is tif");
        personalTimeline.clickToUploadCoverByLocalImage (driver,"FormatFile\\tif.tif");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(driver),"Tập tin không đúng định dạng ne");
    }
}
