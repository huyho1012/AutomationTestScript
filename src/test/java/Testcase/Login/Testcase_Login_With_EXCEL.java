package Testcase.Login;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.ExcelUitls.ExcelUtil;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Shared.Login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Testcase_Login_With_EXCEL extends AbstractTest {
    DriverManager driverManager;
    LoginPage newsfeedLogin;
    NewsfeedHomepage newsFeedHomePage;
    WebDriver driver;
    @Parameters({"browser"})
    @BeforeTest
    public void preconditionTest(String browserName) {
        ExcelUtil.setExcelFileSheet();
        log.info("Precondition - Step 1. Create Browser Driver ");
        driverManager = BrowserInitialization.getBrowser(browserName);
        log.info("Precondition - Step 2. Open browser and go to Newsfeed login");
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);
        log.info("Precondition - Step 3.  Verify url page");
        verifyEquals(newsfeedLogin.getCurrentURL(driver), "https://test-newsfeed.hahalolo.com/auth/signin");
        log.info("Precondition - Step 4. Verify icon Google play display");
        verifyTrue(newsfeedLogin.checkGooglePlayIconIsDisplay(driver));
        log.info("Precondition - Step 5. Verify icon App store display");
        verifyTrue(newsfeedLogin.checkAppStoreIconIsDisplay(driver));
        log.info("Precondition - Step 6. Change system language To Vi");
        newsfeedLogin.clickToChangeLanguageToVI(driver);
        setTimeDelay(1);
    }

    @Test
    public void Testcase_Newsfeed_Login_01_Login_With_Invalid_Information(){
        newsfeedLogin.Login(ExcelUtil.getRowData(1));
        ExcelUtil.setRowNumber(1);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver),ExcelUtil.getCellData(1,4));
        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),ExcelUtil.getCellData(1,5));
    }
    @Test
    public void Testcase_Newsfeed_Login_02_Login_With_UserName_Not_Existed_On_Hahalolo() {
        newsfeedLogin.Login(ExcelUtil.getRowData(2));
        ExcelUtil.setRowNumber(2);
        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver), ExcelUtil.getCellData(2, 5));
    }
    @Test
    public void Testcase_Newsfeed_Login_03_Login_With_Password_Incorrect(){
        newsfeedLogin.Login(ExcelUtil.getRowData(3));
        ExcelUtil.setRowNumber(3);
        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver), ExcelUtil.getCellData(3, 5));
    }
    @Test
    public void Testcase_Newsfeed_Login_04_Login_With_Invalid_Password(){
        log.info("Step 1. Blank password");
        newsfeedLogin.Login(ExcelUtil.getRowData(4));
        ExcelUtil.setRowNumber(4);
        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver), ExcelUtil.getCellData(4, 5));

        log.info("Step 2. Enter white space");
        newsfeedLogin.Login(ExcelUtil.getRowData(5));
        ExcelUtil.setRowNumber(5);
        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver), ExcelUtil.getCellData(5, 5));

        log.info("Step 3. Password less than 6 chars");
        newsfeedLogin.Login(ExcelUtil.getRowData(6));
        ExcelUtil.setRowNumber(6);
        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver), ExcelUtil.getCellData(6, 5));

        log.info("Step 4. Password more than 129 chars");
        newsfeedLogin.Login(ExcelUtil.getRowData(7));
        ExcelUtil.setRowNumber(7);
        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver), ExcelUtil.getCellData(7, 5));

        log.info("Step 5. Password contains one white space");
        newsfeedLogin.Login(ExcelUtil.getRowData(8));
        ExcelUtil.setRowNumber(8);
        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver), ExcelUtil.getCellData(8, 5));
    }
    @Test
    public void Testcase_Newsfeed_Login_05_Login_With_Invalid_Account() {
        newsfeedLogin.enterPasswordToLogin(driver, "123456");
        log.info("Step 1 - Blank Username");
        newsfeedLogin.Login(ExcelUtil.getRowData(9));
        ExcelUtil.setRowNumber(9);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), ExcelUtil.getCellData(9, 4));

        log.info("Step 2. Enter username all white space");
        newsfeedLogin.Login(ExcelUtil.getRowData(10));
        ExcelUtil.setRowNumber(10);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), ExcelUtil.getCellData(10, 4));

        log.info("Step 3. Email not contains domain");
        newsfeedLogin.Login(ExcelUtil.getRowData(11));
        ExcelUtil.setRowNumber(11);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), ExcelUtil.getCellData(11, 4));

        log.info("Step 4. Email contain whitespace on first position");
        newsfeedLogin.Login(ExcelUtil.getRowData(12));
        ExcelUtil.setRowNumber(12);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), ExcelUtil.getCellData(12, 4));

        log.info("Step 5. Email contain whitespace on last position");
        newsfeedLogin.Login(ExcelUtil.getRowData(13));
        ExcelUtil.setRowNumber(13);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), ExcelUtil.getCellData(13, 4));

        log.info("Step 6. Email contain whitespace on middle position");
        newsfeedLogin.Login(ExcelUtil.getRowData(14));
        ExcelUtil.setRowNumber(14);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), ExcelUtil.getCellData(14, 4));

        log.info("Step 7 - Invalid email contain special character");
        newsfeedLogin.Login(ExcelUtil.getRowData(15));
        ExcelUtil.setRowNumber(15);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), ExcelUtil.getCellData(15, 4));

        log.info("Step 8 - Phone contain whitespace on first position");
        newsfeedLogin.Login(ExcelUtil.getRowData(16));
        ExcelUtil.setRowNumber(16);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), ExcelUtil.getCellData(16, 4));

        log.info("Step 9 - Phone contain whitespace on middle position");
        newsfeedLogin.Login(ExcelUtil.getRowData(17));
        ExcelUtil.setRowNumber(17);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), ExcelUtil.getCellData(17, 4));

        log.info("Step 10 - Phone contain whitespace on last position");
        newsfeedLogin.Login(ExcelUtil.getRowData(18));
        ExcelUtil.setRowNumber(18);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), ExcelUtil.getCellData(18, 4));

        log.info("Step 11 - Phone less than 8 number chars");
        newsfeedLogin.Login(ExcelUtil.getRowData(19));
        ExcelUtil.setRowNumber(19);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), ExcelUtil.getCellData(19, 4));

        log.info("Step 12 - Phone greater than 20 number chars");
        newsfeedLogin.Login(ExcelUtil.getRowData(20));
        ExcelUtil.setRowNumber(20);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), ExcelUtil.getCellData(20, 4));

        log.info("Step 13 - Invalid phone contains phone area with Character '+'");
        newsfeedLogin.Login(ExcelUtil.getRowData(21));
        ExcelUtil.setRowNumber(21);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), ExcelUtil.getCellData(21, 4));
    }
    @Test
    public void Testcase_Newsfeed_Login_06_Login_With_Valid_Account(){
        newsfeedLogin.Login(ExcelUtil.getRowData(22));
        ExcelUtil.setRowNumber(22);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
        log.info("Step 4. Verify Login success");
        verifyTrue(newsFeedHomePage.checkNewsfeedDisplay());
        log.info("Step 5. Logout account");
        newsFeedHomePage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);
        log.info("Step 6. Check Logout account success");
        verifyTrue(newsfeedLogin.checkNewsfeedLoginPageDisplay(driver));
    }
    @Test
    public void Testcase_Newsfeed_Login_07_Login_With_Uppercase_Email(){
        newsfeedLogin.Login(ExcelUtil.getRowData(23));
        ExcelUtil.setRowNumber(23);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
        log.info("Step 4. Verify Login success");
        verifyTrue(newsFeedHomePage.checkNewsfeedDisplay());
        log.info("Step 5 - Logout account");
        newsFeedHomePage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);
        log.info("Step 6 - Check Logout account success");
        verifyTrue(newsfeedLogin.checkNewsfeedLoginPageDisplay(driver));
    }
    @Test
    public void Testcase_Newsfeed_Login_08_Login_With_Valid_Phone(){
        newsfeedLogin.Login(ExcelUtil.getRowData(24));
        ExcelUtil.setRowNumber(24);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
        log.info("Step 4. Verify Login success");
        verifyTrue(newsFeedHomePage.checkNewsfeedDisplay());
        log.info("Step 5 - Logout account");
        newsFeedHomePage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);
        log.info("Step 6 - Check Logout account success");
        verifyTrue(newsfeedLogin.checkNewsfeedLoginPageDisplay(driver));
    }
    @Test(enabled = false)
    public void Testcase_Newsfeed_Login_98_Login_With_Phone_contains_PhoneCode(){
        log.info("Step 1 - Enter username");
        newsfeedLogin.enterUserNameToLogin(driver,"840936709449");
        log.info("Step 2 - Enter password");
        newsfeedLogin.enterPasswordToLogin(driver,"20b87bis");
        log.info("Step 3 - Click Login button");
        newsfeedLogin.clickToLoginButton(driver);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
        log.info("Step 4. Verify Login success");
        verifyTrue(newsFeedHomePage.checkNewsfeedDisplay());
        log.info("Step 5 - Logout account");
        newsFeedHomePage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);
        log.info("Step 6 - Check Logout account success");
        verifyTrue(newsfeedLogin.checkNewsfeedLoginPageDisplay(driver));
    }
}
