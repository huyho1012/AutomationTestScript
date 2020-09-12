package Testcase;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Shared.Login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase_Login extends AbstractTest {
    DriverManager driverManager;
    LoginPage newsfeedLogin;
    NewsfeedHomepage newsFeedHomePage;
    DataHelper data = new DataHelper();
    String htmlCode = "";
    String scriptCode = "";
    WebDriver driver;

    @BeforeTest
    public void preconditionTest(String browserName){
        log.info("Precondition - Step 1. Create Browser Driver ");
        driverManager = BrowserInitialization.getBrowser(browserName);
        log.info("Precondition - Step 2. Open browser and go to Newsfeed login");
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        newsfeedLogin = PageGeneration.createLoginPage(driver);
        log.info("Precondition - Step 3.  Verify url page");
        verifyEquals(newsfeedLogin.getCurrentURL(driver), "https://test-newsfeed.hahalolo.com/auth/signin");
        log.info("Precondition - Step 4. Verify icon Google play display");
        verifyTrue(newsfeedLogin.checkGooglePlayIconIsDisplay(driver));
        log.info("Precondition - Step 5. Verify icon App store display");
        verifyTrue(newsfeedLogin.checkAppStoreIconIsDisplay(driver));
        log.info("Precondition - Step 6. Change system language To Vi");
        newsfeedLogin.clickToChangeLanguageToVI(driver);
    }
    @Test
    public void Testcase_Newsfeed_Login_01_Login_With_Invalid_Information(){
        log.info(" Step 1. Do not enter Username");
        newsfeedLogin.enterUserNameToLogin(driver,"");
        log.info(" Step 2. Do not enter Password");
        newsfeedLogin.enterPasswordToLogin(driver,"");
        log.info(" Step 3. Click button Login");
        newsfeedLogin.clickToLoginButton(driver);

        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver),"Tài khoản là bắt buộc.");
        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"Mật khẩu là bắt buộc.");
    }
    @Test
    public void Testcase_Newsfeed_Login_02_Login_With_UserName_Not_Existed_On_Hahalolo(){
        log.info(" Step 1. Do not enter Username");
        newsfeedLogin.enterUserNameToLogin(driver,"admin_tester_lala00002@mailinator.com");
        log.info(" Step 2. Do not enter Password");
        newsfeedLogin.enterPasswordToLogin(driver,"12345678");
        log.info(" Step 3. Click button Login");
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"TTên tài khoản hoặc mật khẩu sai");
    }
    @Test
    public void Testcase_Newsfeed_Login_03_Login_With_Password_Incorrect(){
        log.info(" Step 1. Do not enter Username");
        newsfeedLogin.enterUserNameToLogin(driver,"balo_04@mailinator.com");
        log.info(" Step 2. Do not enter Password");
        newsfeedLogin.enterPasswordToLogin(driver,"12345678");
        log.info(" Step 3. Click button Login");
        newsfeedLogin.clickToLoginButton(driver);

        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"TTên tài khoản hoặc mật khẩu sai");
    }
    @Test
    public void Testcase_Newsfeed_Login_04_Login_With_Invalid_Password(){
        log.info("Step 1. Blank password");
        newsfeedLogin.enterPasswordToLogin(driver,"");
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"Mật khẩu là bắt buộc.");
        log.info("Step 2. Enter white space");
        newsfeedLogin.enterPasswordToLogin(driver,"      ");
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"Mật khẩu là bắt buộc.");
        log.info("Step 3. Password less than 6 chars");
        newsfeedLogin.enterPasswordToLogin(driver,"12345");
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");
        log.info("Step 4. Password more than 129 chars");
        newsfeedLogin.enterPasswordToLogin(driver, randomPassword(129));
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"Giới hạn tối đa của Mật khẩu là 128 kí tự");
        log.info("Step 5. Password contains HTML Code");
        newsfeedLogin.enterPasswordToLogin(driver, htmlCode);
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"Mật khẩu không chứa kí tự trắng.");
        log.info("Step 6. Password contains Script Code");
        newsfeedLogin.enterPasswordToLogin(driver,scriptCode);
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"Mật khẩu không chứa kí tự trắng.");
        log.info("Step 7. Password contains white space");
        newsfeedLogin.enterPasswordToLogin(driver,"1234 56");
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"Mật khẩu không chứa kí tự trắng.");
    }
    @Test
    public void Testcase_Newsfeed_Login_05_Login_With_Invalid_Account() {
        newsfeedLogin.enterPasswordToLogin(driver, "123456");
        log.info("Step 1 - Blank Username");
        newsfeedLogin.enterUserNameToLogin(driver, "");
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản là bắt buộc.");
        log.info("Step 2. Enter username all white space");
        newsfeedLogin.enterUserNameToLogin(driver,"      ");
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver),"Tài khoản là bắt buộc.");
        log.info("Step 3. Email not contains domain");
        newsfeedLogin.enterUserNameToLogin(driver, "huyho1210@gmail.");
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");
        log.info("Step 4. Email contain whitespace on first position");
        newsfeedLogin.enterUserNameToLogin(driver, " huyho1210@gmail.com");
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");
        log.info("Step 5. Email contain whitespace on last position");
        newsfeedLogin.enterUserNameToLogin(driver, "huyho1210@gmail.com ");
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");
        log.info("Step 6. Email contain whitespace on middle position");
        newsfeedLogin.enterUserNameToLogin(driver, "huyho 1210@gmail.com");
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");
        log.info("Step 7 - Invalid email contain special character");
        newsfeedLogin.enterUserNameToLogin(driver, "huyh@1210@gmail.com");
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");
        log.info("Step 8 - Phone contain whitespace on first position");
        newsfeedLogin.enterUserNameToLogin(driver, " 0936709449");
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");
        log.info("Step 9 - Phone contain whitespace on middle position");
        newsfeedLogin.enterUserNameToLogin(driver, "0936 709449");
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");
        log.info("Step 10 - Phone contain whitespace on last position");
        newsfeedLogin.enterUserNameToLogin(driver, "0936709449 ");
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");
        log.info("Step 11 - Phone less than 8 number chars");
        newsfeedLogin.enterUserNameToLogin(driver, "0123451");
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");
        log.info("Step 12 - Phone greater than 20 number chars");
        newsfeedLogin.enterUserNameToLogin(driver, String.valueOf(randomNumber(21)));
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");
        log.info("Step 13 - Invalid phone contains phone area with Character '+'");
        newsfeedLogin.enterUserNameToLogin(driver, "+840936709449");
        newsfeedLogin.clickToLoginButton(driver);
        verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");
    }
    @Test
    public void Testcase_Newsfeed_Login_06_Login_With_Valid_Account(){
        log.info("Step 1. Enter username");
        newsfeedLogin.enterUserNameToLogin(driver,"balo_04@mailinator.com");
        log.info("Step 2. Enter password");
        newsfeedLogin.enterPasswordToLogin(driver,"123456");
        log.info("Step 3. Click Login button");
        newsfeedLogin.clickToLoginButton(driver);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
        log.info("Step 4. Verify Login success");
        verifyTrue(newsFeedHomePage.checkNewsfeedDisplay());
        log.info("Step 5. Logout account");
        newsFeedHomePage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        newsfeedLogin = PageGeneration.createLoginPage(driver);
        log.info("Step 6. Check Logout account success");
        verifyTrue(newsfeedLogin.checkNewsfeedLoginPageDisplay(driver));
    }
    @Test
    public void Testcase_Newsfeed_Login_06_Login_With_Uppercase_Email(){
        log.info("Step 1 - Enter username");
        newsfeedLogin.enterUserNameToLogin(driver,"BALO_04@mailinator.com");
        log.info("Step 2 - Enter password");
        newsfeedLogin.enterPasswordToLogin(driver,"123456");
        log.info("Step 3 - Click Login button");
        newsfeedLogin.clickToLoginButton(driver);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
        log.info("Step 4. Verify Login success");
        verifyTrue(newsFeedHomePage.checkNewsfeedDisplay());
        log.info("Step 5 - Logout account");
        newsFeedHomePage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        newsfeedLogin = PageGeneration.createLoginPage(driver);
        log.info("Step 6 - Check Logout account success");
        verifyTrue(newsfeedLogin.checkNewsfeedLoginPageDisplay(driver));
    }
    @Test
    public void Testcase_Newsfeed_Login_07_Login_With_Valid_Phone(){
        log.info("Step 1 - Enter username");
        newsfeedLogin.enterUserNameToLogin(driver,"0936709449");
        log.info("Step 2 - Enter password");
        newsfeedLogin.enterPasswordToLogin(driver,"20b87bis");
        log.info("Step 3 - Click Login button");
        newsfeedLogin.clickToLoginButton(driver);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
        log.info("Step 4. Verify Login success");
        verifyTrue(newsFeedHomePage.checkNewsfeedDisplay());
        log.info("Step 5 - Logout account");
        newsFeedHomePage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        newsfeedLogin = PageGeneration.createLoginPage(driver);
        log.info("Step 6 - Check Logout account success");
        verifyTrue(newsfeedLogin.checkNewsfeedLoginPageDisplay(driver));
    }
    @Test
    public void Testcase_Newsfeed_Login_08_Login_With_Phone_contains_PhoneCode(){
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
        newsfeedLogin = PageGeneration.createLoginPage(driver);
        log.info("Step 6 - Check Logout account success");
        verifyTrue(newsfeedLogin.checkNewsfeedLoginPageDisplay(driver));
    }
}
