package Testcase.Login.ComponentTest;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Shared.Login_PageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

    public class Testcase_Login_With_Hard_Data extends AbstractTest {
        DriverManager driverManager;
        Login_PageObject newsfeedLogin;
        NewsfeedHomepage newsFeedHomePage;
        WebDriver driver;

        @Parameters("browser")
        @BeforeTest
        public void preconditionTest(String browserName) {
            log.info("Precondition - Step 1. Create Browser Driver ");
            driverManager = BrowserInitialization.getBrowser(browserName);

            log.info("Precondition - Step 2. Open browser and go to Newsfeed login");
            driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
            newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);

            log.info("Precondition - Step 3. Change system language to Vietnamese");
            newsfeedLogin.clickToChangeLanguageToVI();
        }

        @Test
        public void TC01_Login_With_Invalid_Information(){
            log.info(" Step 1. Do not enter Username");
            newsfeedLogin.enterUserNameToLogin(driver,"");

            log.info(" Step 2. Do not enter Password");
            newsfeedLogin.enterPasswordToLogin(driver,"");

            log.info(" Step 3. Click button Login");
            newsfeedLogin.clickToLoginButton(driver);

            log.info(" Step 4. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver),"Tài khoản là bắt buộc.");
            verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"Mật khẩu là bắt buộc.");
        }

        @Test
        public void TC02_Login_With_UserName_Not_Existed_On_Hahalolo(){
            log.info(" Step 1. Do not enter Username");
            newsfeedLogin.enterUserNameToLogin(driver,"admin_tester_lala00002@mailinator.com");

            log.info(" Step 2. Do not enter Password");
            newsfeedLogin.enterPasswordToLogin(driver,"12345678");

            log.info(" Step 3. Click button Login");
            newsfeedLogin.clickToLoginButton(driver);

            log.info(" Step 4. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"Tên tài khoản hoặc mật khẩu sai");
        }

        @Test
        public void TC03_Login_With_Password_Incorrect(){
            log.info(" Step 1. Do not enter Username");
            newsfeedLogin.enterUserNameToLogin(driver,"balo_04@mailinator.com");

            log.info(" Step 2. Do not enter Password");
            newsfeedLogin.enterPasswordToLogin(driver,"12345678");

            log.info(" Step 3. Click button Login");
            newsfeedLogin.clickToLoginButton(driver);

            log.info(" Step 4. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"Tên tài khoản hoặc mật khẩu sai");
        }

        @Test
        public void TC04_Login_With_Invalid_Password(){
            log.info("Case - Blank password");
            log.info("Step 1  - Enter password");
            newsfeedLogin.enterPasswordToLogin(driver,"");
            log.info("Step 2  - Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3  - Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"Mật khẩu là bắt buộc.");

            log.info("Case - white space");
            log.info("Step 1  - Enter password");
            newsfeedLogin.enterPasswordToLogin(driver,"      ");
            log.info("Step 2  - Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3  - Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"Mật khẩu là bắt buộc.");

            log.info("Case - Password less than 6 chars");
            log.info("Step 1  - Enter password");
            newsfeedLogin.enterPasswordToLogin(driver,"12345");
            log.info("Step 2  - Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3  - Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");

            log.info("Case - Password more than 129 chars");
            log.info("Step 1. Enter password");
            newsfeedLogin.enterPasswordToLogin(driver, randomPassword(129));
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"Giới hạn tối đa của Mật khẩu là 128 kí tự");

            log.info("Case - Password contains white space");
            log.info("Step 1. Enter password");
            newsfeedLogin.enterPasswordToLogin(driver,"1234 56");
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfPassword(driver),"Mật khẩu không chứa kí tự trắng.");
        }

        @Test
        public void TC05_Login_With_Invalid_Account() {
            newsfeedLogin.enterPasswordToLogin(driver, "123456");

            log.info("Case - Blank Username");
            log.info("Step 1. Enter email");
            newsfeedLogin.enterUserNameToLogin(driver, "");
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản là bắt buộc.");

            log.info("Case - All white space");
            log.info("Step 1. Enter email");
            newsfeedLogin.enterUserNameToLogin(driver, "      ");
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản là bắt buộc.");

            log.info("Case - Not contains domain");
            log.info("Step 1. Enter email");
            newsfeedLogin.enterUserNameToLogin(driver, "huyho1210@gmail.");
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");

            log.info("Case - Contain whitespace on first position");
            log.info("Step 1. Enter email");
            newsfeedLogin.enterUserNameToLogin(driver, " huyho1210@gmail.com");
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");

            log.info("Case - Contain whitespace on last position");
            log.info("Step 1. Enter email");
            newsfeedLogin.enterUserNameToLogin(driver, "huyho1210@gmail.com ");
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");

            log.info("Case - Contain whitespace on middle position");
            log.info("Step 1. Enter email");
            newsfeedLogin.enterUserNameToLogin(driver, "huyho 1210@gmail.com");
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");

            log.info("Case - Contain special character");
            log.info("Step 1. Enter email");
            newsfeedLogin.enterUserNameToLogin(driver, "huyh@1210@gmail.com");
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");
        }

        @Test
        public void TC06_Login_With_Invalid_Phone(){
            log.info("Case - Contain whitespace on first position");
            log.info("Step 1. Enter phone number");
            newsfeedLogin.enterUserNameToLogin(driver, " 0936709449");
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");

            log.info("Case - Contain whitespace on middle position");
            log.info("Step 1. Enter phone number");
            newsfeedLogin.enterUserNameToLogin(driver, "0936 709449");
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");

            log.info("Case - Contain whitespace on last position");
            log.info("Step 1. Enter phone number");
            newsfeedLogin.enterUserNameToLogin(driver, "0936709449 ");
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");

            log.info("Case - Less than 8 number chars");
            log.info("Step 1. Enter phone number");
            newsfeedLogin.enterUserNameToLogin(driver, "0123451");
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");


            log.info("Case - Greater than 20 number chars");
            log.info("Step 1. Enter phone number");
            newsfeedLogin.enterUserNameToLogin(driver, String.valueOf(randomNumber(21)));
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");

            log.info("Case - Contains phone area with Character '+'");
            log.info("Step 1. Enter phone number");
            newsfeedLogin.enterUserNameToLogin(driver, "+840936709449");
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton(driver);
            log.info("Step 3. Verify error message");
            verifyEquals(newsfeedLogin.getErrorMessageOfUsername(driver), "Tài khoản không hợp lệ.");
        }

        @Test
        public void TC07_Login_With_Valid_Account(){
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
            newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);
            log.info("Step 6. Check Logout account success");
            verifyTrue(newsfeedLogin.checkNewsfeedLoginPageDisplay());
        }

        @Test
        public void TC08_Login_With_Uppercase_Email(){
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
            newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);
            log.info("Step 6 - Check Logout account success");
            verifyTrue(newsfeedLogin.checkNewsfeedLoginPageDisplay());
        }

        @Test
        public void TC09_Login_With_Valid_Phone(){
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
            newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);
            log.info("Step 6 - Check Logout account success");
            verifyTrue(newsfeedLogin.checkNewsfeedLoginPageDisplay());
        }
    }

