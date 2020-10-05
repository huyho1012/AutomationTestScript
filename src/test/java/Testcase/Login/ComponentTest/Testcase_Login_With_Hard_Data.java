package Testcase.Login.ComponentTest;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.About.PerAbout_Overview_PageObject;
import Project.Shared.Login_PageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

    public class Testcase_Login_With_Hard_Data extends AbstractTest {
        WebDriver driver;
        DriverManager driverManager;
        Login_PageObject newsfeedLogin;
        NewsfeedHomepage newsFeedHomePage;
        PerAbout_Overview_PageObject perAboutOverviewPage;
      
        String accountUser;
        String accountPassword;

        @Parameters("browser")
        @BeforeTest
        public void preconditionTest(String browserName) {
            log.info("Create Driver ");
            driverManager = BrowserInitialization.getBrowser(browserName);
            log.info("Open browser and go to Newsfeed login");
            driver = driverManager.getDriver(GlobalVariables.NEWSFEED_URL);
            newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);
            log.info("Change system language to Vietnamese");
            newsfeedLogin.clickToChangeLanguageToVI(driver);
        }

        @Test
        public void TC01_Login_With_Invalid_Information(){
            accountPassword = "";
            accountUser = "";
            log.info("Step 1. Do not enter Username");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info("Step 2. Do not enter Password");
            newsfeedLogin.enterPasswordToLogin(accountPassword);
            log.info("Step 3. Click button Login");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 4. Verify error message of field Password");
            verifyEquals(newsfeedLogin.getMessageOfUsernameField(),"Tài khoản là bắt buộc.");
            log.info("Step 3. Verify message of field Password");
            verifyEquals(newsfeedLogin.getMessageOfPasswordField(),"Mật khẩu là bắt buộc.");
        }

        @Test
        public void TC02_Login_With_Account_Not_Existed_On_Hahalolo(){
            accountUser = "admin_tester_lala00002@mailinator.com";
            accountPassword = "12345678";
            log.info(" Step 1. Enter Username");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info(" Step 2. Enter Password");
            newsfeedLogin.enterPasswordToLogin(accountPassword);
            log.info(" Step 3. Click button Login");
            newsfeedLogin.clickToLoginButton();
            log.info(" Step 4. Verify error message");
            verifyEquals(newsfeedLogin.getMessageOfPasswordField(),"Tên tài khoản hoặc mật khẩu sai");
        }

        @Test
        public void TC03_Login_With_Incorrect_Password(){
            accountUser = "balo_04@mailinator.com";
            accountPassword = "12345678";
            log.info(" Step 1. Enter Username");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info(" Step 2. Enter incorrect Password");
            newsfeedLogin.enterPasswordToLogin(accountPassword);
            log.info(" Step 3. Click button Login");
            newsfeedLogin.clickToLoginButton();
            log.info(" Step 4. Verify error message");
            verifyEquals(newsfeedLogin.getMessageOfPasswordField(),"Tên tài khoản hoặc mật khẩu sai");
        }

        @Test
        public void TC04_Login_Check_Negative_Case_Of_Field_Password(){
            accountUser = "balo_04@mailinator.com";

            log.info("Case Password is blank");
            accountPassword = "";;
            log.info("Step 1. Enter password");
            newsfeedLogin.enterPasswordToLogin(accountPassword);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Password");
            verifyEquals(newsfeedLogin.getMessageOfPasswordField(),"Mật khẩu là bắt buộc.");

            log.info("Case Password contains all white space");
            accountPassword = "      ";
            log.info("Step 1. Enter password");
            newsfeedLogin.enterPasswordToLogin(accountPassword);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Password");
            verifyEquals(newsfeedLogin.getMessageOfPasswordField(),"Mật khẩu là bắt buộc.");

            log.info("Case Password contains less than 6 chars");
            accountPassword = "12345";
            log.info("Step 1. Enter password");
            newsfeedLogin.enterPasswordToLogin(accountPassword);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Password");
            verifyEquals(newsfeedLogin.getMessageOfPasswordField(),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");

            log.info("Case Password contains more than 129 characters");
            accountPassword = randomPassword(129);
            log.info("Step 1. Enter password");
            newsfeedLogin.enterPasswordToLogin(accountPassword);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Password");
            verifyEquals(newsfeedLogin.getMessageOfPasswordField(),"Giới hạn tối đa của Mật khẩu là 128 kí tự");

            log.info("Case Password contains white space on middle position");
            accountPassword = "1234 56";
            log.info("Step 1. Enter password");
            newsfeedLogin.enterPasswordToLogin(accountPassword);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Password");
            verifyEquals(newsfeedLogin.getMessageOfPasswordField(),"Mật khẩu không chứa kí tự trắng.");
        }

        @Test
        public void TC05_Login_Check_Negative_Case_Of_Field_Username() {
            newsfeedLogin.enterPasswordToLogin("123456");

            log.info("Case Username is blank");
            accountUser = "";
            log.info("Step 1. Enter email");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Username");
            verifyEquals(newsfeedLogin.getMessageOfUsernameField(), "Tài khoản là bắt buộc.");

            log.info("Case Username contains all white spaces");
            accountUser = "      ";
            log.info("Step 1. Enter email");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Username");
            verifyEquals(newsfeedLogin.getMessageOfUsernameField(), "Tài khoản là bắt buộc.");

            log.info("Case Email have not contains domain");
            accountUser = "huyho1210@gmail.";
            log.info("Step 1. Enter email");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Username");
            verifyEquals(newsfeedLogin.getMessageOfUsernameField(), "Tài khoản không hợp lệ.");

            log.info("Case Email contains whitespace on first position");
            accountUser = " "+ GlobalVariables.USER_EMAIL_ACCOUNT;
            log.info("Step 1. Enter email");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Username");
            verifyEquals(newsfeedLogin.getMessageOfUsernameField(), "Tài khoản không hợp lệ.");

            log.info("Case Email contains whitespace on last position");
            accountUser = GlobalVariables.USER_EMAIL_ACCOUNT + " ";
            log.info("Step 1. Enter email");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Username");
            verifyEquals(newsfeedLogin.getMessageOfUsernameField(),"Tài khoản không hợp lệ.");

            log.info("Case Email contains whitespace on middle position");
            accountUser = "huyho 1210@gmail.com";
            log.info("Step 1. Enter email");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Username");
            verifyEquals(newsfeedLogin.getMessageOfUsernameField(),"Tài khoản không hợp lệ.");

            log.info("Case Email contains special character");
            accountUser = "huyh@1210@gmail.com";
            log.info("Step 1. Enter email");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Username");
            verifyEquals(newsfeedLogin.getMessageOfUsernameField(),"Tài khoản không hợp lệ.");

            log.info("Case Phone number contains whitespace on first position");
            accountUser = " "+ GlobalVariables.USER_PHONE_ACCOUNT;
            log.info("Step 1. Enter phone number");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Username");
            verifyEquals(newsfeedLogin.getMessageOfUsernameField(),"Tài khoản không hợp lệ.");

            log.info("Case - Contain whitespace on middle position");
            accountUser = "0936 709449";
            log.info("Step 1. Enter phone number");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Username");
            verifyEquals(newsfeedLogin.getMessageOfUsernameField(),"Tài khoản không hợp lệ.");

            log.info("Case Phone number contains whitespace on last position");
            accountUser = GlobalVariables.USER_PHONE_ACCOUNT + " ";
            log.info("Step 1. Enter phone number");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Username");
            verifyEquals(newsfeedLogin.getMessageOfUsernameField(),"Tài khoản không hợp lệ.");

            log.info("Case Phone number contains character Less than 8");
            accountUser = String.valueOf(randomNumber(7));
            log.info("Step 1. Enter phone number");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Username");
            verifyEquals(newsfeedLogin.getMessageOfUsernameField(), "Tài khoản không hợp lệ.");

            log.info("Case Phone number contains characters more than 20");
            accountUser = String.valueOf(randomNumber(21));
            log.info("Step 1. Enter phone number");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Username");
            verifyEquals(newsfeedLogin.getMessageOfUsernameField(), "Tài khoản không hợp lệ.");

            log.info("Case Phone number contains phone area with character + ");
            accountUser = "+840936709449" ;
            log.info("Step 1. Enter phone number");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info("Step 2. Click Login button");
            newsfeedLogin.clickToLoginButton();
            log.info("Step 3. Verify message of field Username");
            verifyEquals(newsfeedLogin.getMessageOfUsernameField(), "Tài khoản không hợp lệ.");
        }

        @Test
        public void TC06_Login_With_Account_Register_By_Email(){
            accountUser = GlobalVariables.USER_EMAIL_ACCOUNT;
            accountPassword = GlobalVariables.USER_EMAIL_PASSWORD;
            log.info("Step 1. Enter username");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info("Step 2. Enter password");
            newsfeedLogin.enterPasswordToLogin(accountPassword);
            log.info("Step 3. Click Login button");
            newsfeedLogin.clickToLoginButton();
            newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
            log.info("Step 4. Verify Hahalolo Newsfeed display successfully");
            verifyTrue(newsFeedHomePage.checkNewsfeedDisplay());
            log.info("Step 5. Go to Personal About Overview");
            newsFeedHomePage.clickToEditProfile();
            perAboutOverviewPage = PageGeneration.createPerAboutOverviewTab(driver);
            log.info("Step 6. Check personal about overview display successfully");
            verifyTrue(perAboutOverviewPage.checkPerAboutOverviewTabIsDisplay());
            log.info("Step 7. Check email display on Introduce widget");
            verifyEquals(perAboutOverviewPage.getEmailIsDisplayOnIntroduceWidget(),accountUser);
            log.info("Step 8. Logout account");
            newsFeedHomePage.clickToItemOnSettingMenu(driver,"ic-logout-c");
            newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);
        }

        @Test
        public void TC07_Login_With_Account_Register_By_PhoneNumber(){
            accountUser = GlobalVariables.USER_PHONE_ACCOUNT;
            accountPassword = GlobalVariables.USER_PHONE_PASSWORD;

            log.info("Step 1. Enter username");
            newsfeedLogin.enterUserNameToLogin(accountUser);
            log.info("Step 2. Enter password");
            newsfeedLogin.enterPasswordToLogin(accountPassword);
            log.info("Step 3. Click Login button");
            newsfeedLogin.clickToLoginButton();
            newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
            log.info("Step 4. Verify Hahalolo Newsfeed display successfully");
            verifyTrue(newsFeedHomePage.checkNewsfeedDisplay());
            log.info("Step 5. Go to Personal About Overview");
            newsFeedHomePage.clickToEditProfile();
            perAboutOverviewPage = PageGeneration.createPerAboutOverviewTab(driver);
            log.info("Step 6. Check personal about overview display successfully");
            verifyTrue(perAboutOverviewPage.checkPerAboutOverviewTabIsDisplay());
            log.info("Step 7. Check phone display on Introduce widget");
            verifyEquals(perAboutOverviewPage.getPhoneNumberDisplayOnIntroduceWidget(),accountUser);
            log.info("Step 8. Logout account");
            newsFeedHomePage.clickToItemOnSettingMenu(driver,"ic-logout-c");
            newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);
        }

        @Test
        public void TC08_Login_With_Email_Is_Uppercase_Email() {
            accountUser = GlobalVariables.USER_EMAIL_ACCOUNT;
            accountPassword = GlobalVariables.USER_EMAIL_PASSWORD;

            log.info("Step 1. Enter username");
            newsfeedLogin.enterUserNameToLogin(accountUser.toUpperCase());
            log.info("Step 2. Enter password");
            newsfeedLogin.enterPasswordToLogin(accountPassword);
            log.info("Step 3. Click Login button");
            newsfeedLogin.clickToLoginButton();
            newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
            log.info("Step 4. Verify Hahalolo Newsfeed display successfully");
            verifyTrue(newsFeedHomePage.checkNewsfeedDisplay());
            log.info("Step 5. Go to Personal About Overview");
            newsFeedHomePage.clickToEditProfile();
            perAboutOverviewPage = PageGeneration.createPerAboutOverviewTab(driver);
            log.info("Step 6. Check personal about overview display successfully");
            verifyTrue(perAboutOverviewPage.checkPerAboutOverviewTabIsDisplay());
            log.info("Step 7. Check phone display on Introduce widget");
            verifyEquals(perAboutOverviewPage.getPhoneNumberDisplayOnIntroduceWidget(), accountUser);
            log.info("Step 8. Logout account");
            newsFeedHomePage.clickToItemOnSettingMenu(driver, "ic-logout-c");
            newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);
        }
    }

