package Testcase.Login.ComponentTest;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.ExcelUitls.ExcelUtil;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Shared.Login_PageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Testcase_Login_With_EXCEL extends AbstractTest {
    DriverManager driverManager;
    Login_PageObject newsfeedLogin;
    NewsfeedHomepage newsFeedHomePage;
    WebDriver driver;
    @Parameters({"browser"})
    @BeforeTest
    public void preconditionTest(String browserName) {
        ExcelUtil.setExcelFileSheet();

        log.info("Precondition - Step 1. Create Browser Driver ");
        driverManager = BrowserInitialization.getBrowser(browserName);

        log.info("Precondition - Step 2. Open browser and go to Newsfeed login");
        driver = driverManager.getDriver(GlobalVariables.NEWSFEED_URL);
        newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Precondition - Step 3. Change system language To Vi");
        newsfeedLogin.clickToChangeLanguageToVI(driver);
    }

    @Test
    public void TC01_Login_With_Invalid_Information(){
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(1));
        ExcelUtil.setRowNumber(1);
        verifyEquals(newsfeedLogin.getMessageOfUsernameField(),ExcelUtil.getCellData(1,4));
        verifyEquals(newsfeedLogin.getMessageOfPasswordField(),ExcelUtil.getCellData(1,5));
    }

    @Test
    public void TC02_Login_With_Account_Not_Exist_On_Hahalolo() {
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(2));
        ExcelUtil.setRowNumber(2);
        verifyEquals(newsfeedLogin.getMessageOfPasswordField(), ExcelUtil.getCellData(2, 5));
    }

    @Test
    public void TC03_Login_With_Incorrect_Password(){
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(3));
        ExcelUtil.setRowNumber(3);
        verifyEquals(newsfeedLogin.getMessageOfPasswordField(), ExcelUtil.getCellData(3, 5));
    }

    @Test
    public void T04_Login_With_Invalid_Password(){
        log.info("Step 1. Blank password");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(4));
        ExcelUtil.setRowNumber(4);
        verifyEquals(newsfeedLogin.getMessageOfPasswordField(), ExcelUtil.getCellData(4, 5));

        log.info("Step 2. All white space");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(5));
        ExcelUtil.setRowNumber(5);
        verifyEquals(newsfeedLogin.getMessageOfPasswordField(), ExcelUtil.getCellData(5, 5));

        log.info("Step 3. Password less than 6 chars");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(6));
        ExcelUtil.setRowNumber(6);
        verifyEquals(newsfeedLogin.getMessageOfPasswordField(), ExcelUtil.getCellData(6, 5));

        log.info("Step 4. Password more than 129 chars");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(7));
        ExcelUtil.setRowNumber(7);
        verifyEquals(newsfeedLogin.getMessageOfPasswordField(), ExcelUtil.getCellData(7, 5));

        log.info("Step 5. Password contains one white space");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(8));
        ExcelUtil.setRowNumber(8);
        verifyEquals(newsfeedLogin.getMessageOfPasswordField(), ExcelUtil.getCellData(8, 5));
    }

    @Test
    public void TC05_Login_With_Invalid_Account() {
        log.info("Step 1 - Blank Username");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(9));
        ExcelUtil.setRowNumber(9);
        verifyEquals(newsfeedLogin.getMessageOfUsernameField(), ExcelUtil.getCellData(9, 4));

        log.info("Step 2. Enter username all white space");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(10));
        ExcelUtil.setRowNumber(10);
        verifyEquals(newsfeedLogin.getMessageOfUsernameField(), ExcelUtil.getCellData(10, 4));

        log.info("Step 3. Email not contains domain");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(11));
        ExcelUtil.setRowNumber(11);
        verifyEquals(newsfeedLogin.getMessageOfUsernameField(), ExcelUtil.getCellData(11, 4));

        log.info("Step 4. Email contain whitespace on first position");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(12));
        ExcelUtil.setRowNumber(12);
        verifyEquals(newsfeedLogin.getMessageOfUsernameField(), ExcelUtil.getCellData(12, 4));

        log.info("Step 5. Email contain whitespace on last position");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(13));
        ExcelUtil.setRowNumber(13);
        verifyEquals(newsfeedLogin.getMessageOfUsernameField(), ExcelUtil.getCellData(13, 4));

        log.info("Step 6. Email contain whitespace on middle position");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(14));
        ExcelUtil.setRowNumber(14);
        verifyEquals(newsfeedLogin.getMessageOfUsernameField(), ExcelUtil.getCellData(14, 4));

        log.info("Step 7 - Invalid email contain special character");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(15));
        ExcelUtil.setRowNumber(15);
        verifyEquals(newsfeedLogin.getMessageOfUsernameField(), ExcelUtil.getCellData(15, 4));

        log.info("Step 8 - Phone contain whitespace on first position");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(16));
        ExcelUtil.setRowNumber(16);
        verifyEquals(newsfeedLogin.getMessageOfUsernameField(), ExcelUtil.getCellData(16, 4));

        log.info("Step 9 - Phone contain whitespace on middle position");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(17));
        ExcelUtil.setRowNumber(17);
        verifyEquals(newsfeedLogin.getMessageOfUsernameField(), ExcelUtil.getCellData(17, 4));

        log.info("Step 10 - Phone contain whitespace on last position");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(18));
        ExcelUtil.setRowNumber(18);
        verifyEquals(newsfeedLogin.getMessageOfUsernameField(), ExcelUtil.getCellData(18, 4));

        log.info("Step 11 - Phone less than 8 number chars");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(19));
        ExcelUtil.setRowNumber(19);
        verifyEquals(newsfeedLogin.getMessageOfUsernameField(), ExcelUtil.getCellData(19, 4));

        log.info("Step 12 - Phone greater than 20 number chars");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(20));
        ExcelUtil.setRowNumber(20);
        verifyEquals(newsfeedLogin.getMessageOfUsernameField(), ExcelUtil.getCellData(20, 4));

        log.info("Step 13 - Invalid phone contains phone area with Character '+'");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(21));
        ExcelUtil.setRowNumber(21);
        verifyEquals(newsfeedLogin.getMessageOfUsernameField(), ExcelUtil.getCellData(21, 4));
    }

    @Test
    public void TC06_Login_With_Valid_Account(){
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(22));
        ExcelUtil.setRowNumber(22);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
        log.info("Step 4. Verify Login success");
        verifyTrue(newsFeedHomePage.checkNewsfeedDisplay());
        log.info("Step 5. Logout account");
        newsFeedHomePage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);
        log.info("Step 6. Check Logout account success");
        verifyTrue(newsfeedLogin.checkNewsfeedLoginPageIsDisplayed());
    }
    @Test
    public void TC07_Login_With_Uppercase_Email(){
        log.info("Step 1. Login account");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(23));
        ExcelUtil.setRowNumber(23);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 2. Verify Login success");
        verifyTrue(newsFeedHomePage.checkNewsfeedDisplay());

        log.info("Step 3 - Logout account");
        newsFeedHomePage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Step 4 - Check Logout account success");
        verifyTrue(newsfeedLogin.checkNewsfeedLoginPageIsDisplayed());
    }

    @Test
    public void TC08_Login_With_Valid_Phone(){
        log.info("Step 1. Login account");
        newsfeedLogin.LoginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(24));
        ExcelUtil.setRowNumber(24);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 2. Verify login success");
        verifyTrue(newsFeedHomePage.checkNewsfeedDisplay());

        log.info("Step 3 - Logout account");
        newsFeedHomePage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Step 4 - Check Logout account success");
        verifyTrue(newsfeedLogin.checkNewsfeedLoginPageIsDisplayed());
    }
}
