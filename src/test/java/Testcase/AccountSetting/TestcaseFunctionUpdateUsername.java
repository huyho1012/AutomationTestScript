package Testcase.AccountSetting;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.AccountSetting.GeneralAccountSetting;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.About.PerAbout_Common_PageObject;
import Project.Shared.Login_PageObject;
import Project.Shared.SignUp_PageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestcaseFunctionUpdateUsername extends AbstractTest {
    DriverManager driverManager;
    DataHelper data;
    WebDriver driver;
    Login_PageObject loginNewsfeedPage;
    NewsfeedHomepage newsFeedHomePage;
    GeneralAccountSetting accountSetting;
    SignUp_PageObject signUpPageObject;
    PerAbout_Common_PageObject perAboutCommonPageObject;
    String htmlCode ="<p>HelloWord</p>";
    String scriptCode ="<script>destroyWebsite();</script>";
    String userName;

    @Parameters("browser")
    @BeforeTest
    public void Precondition(String browserName){
        log.info("Prepare data");
        data = DataHelper.getData();

        log.info("Create driver");
        driverManager = BrowserInitialization.getBrowser(browserName);

        log.info("Open Hahalolo Newsfeed login");
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        loginNewsfeedPage = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Change language of system to VI");
        loginNewsfeedPage.clickToChangeLanguageToVI(driver);

        log.info("Login to Hahalolo");
        loginNewsfeedPage.Login(GlobalVariables.USER_ACCOUNT,GlobalVariables.USER_PASSWORD);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Go To Account setting");
        // Nhán vào chức năng Thiết lập tài khoản
        newsFeedHomePage.clickToItemOnSettingMenu(driver,"ic-cog-c");
        accountSetting = PageGeneration.createGeneralAccountSettingPage(driver);

        log.info("Verify General Account setting");
        verifyTrue(accountSetting.checkAccountGeneralSettingIsDisplay());

        log.info("Click to Edit username");
        accountSetting.clickToButtonEditUsername();
    }

    @Test
    public void TC01_Update_Username_With_Invalid_Information(){
        log.info("Case username is blank");
        log.info("Step 1. Enter username");
        accountSetting.enterDataToUsernameField("");
        log.info("Step 2. Check status of button save change");
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());

        log.info("Case username contains all whitespace");
        log.info("Step 1. Enter username");
        accountSetting.enterDataToUsernameField("  ");
        log.info("Step 2. Check status of button save change");
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        log.info("Step 3. Verify message of function Change username");
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Phải có ít nhất 5 kí tự");

        log.info("Case username contains whitespace on middle data");
        log.info("Step 1. Enter username");
        accountSetting.enterDataToUsernameField("huy hodoan");
        log.info("Step 2. Check status of button save change");
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        log.info("Step 3. Verify message of function Change username");
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Có chứa ký tự không hợp lệ.");

        log.info("Case username contains dot on last position");
        log.info("Step 1. Enter username");
        accountSetting.enterDataToUsernameField("huyhodoan.");
        log.info("Step 2. Check status of button save change");
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        log.info("Step 3. Verify message of function Change username");
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Có chứa ký tự đặc biệt không đúng chỗ");

        log.info("Case username contains special characters");
        log.info("Step 1. Enter username");
        accountSetting.enterDataToUsernameField("huyhodo@an");
        log.info("Step 2. Check status of button save change");
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        log.info("Step 3. Verify message of function Change username");
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Có chứa ký tự không hợp lệ.");

        log.info("Case username contains less than 5 characters");
        log.info("Step 1. Enter username");
        accountSetting.enterDataToUsernameField("huya");
        log.info("Step 2. Check status of button save change");
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        log.info("Step 3. Verify message of function Change username");
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Phải có ít nhất 5 kí tự");

        log.info("Case username contains greather than 50 characters");
        log.info("Step 1. Enter username");
        accountSetting.enterDataToUsernameField(randomName(51));
        log.info("Step 2. Check status of button save change");
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        log.info("Step 3. Verify message of function Change username");
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Tên người dùng vượt số ký tự tối đa cho phép");

        log.info("Case username contains script code");
        log.info("Step 1. Enter username");
        accountSetting.enterDataToUsernameField(GlobalVariables.SCRPIT_CODE);
        log.info("Step 2. Check status of button save change");
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        log.info("Step 3. Verify message of function Change username");
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Có chứa ký tự không hợp lệ.");

        log.info("Case username contains HTML code");
        log.info("Step 1. Enter username");
        accountSetting.enterDataToUsernameField(GlobalVariables.HTML_CODE);
        log.info("Step 2. Check status of button save change");
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        log.info("Step 3. Verify message of function Change username");
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Có chứa ký tự không hợp lệ.");

        log.info("Case username contains mark");
        log.info("Step 1. Enter username");
        accountSetting.enterDataToUsernameField("huayhô");
        log.info("Step 2. Check status of button save change");
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        log.info("Step 3. Verify message of function Change username");
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Có chứa ký tự không hợp lệ.");

        log.info("End step. Cancel function change username");
        accountSetting.cancelSaveChangeUsername();
    }

    @Test
    public void TC02_Update_Username_With_Valid_Username() {
        log.info("Prepare data");
        userName = removeAllWhitespace(data.getFirstName()).toLowerCase();

        log.info("Step 1. Open function Edit username");
        accountSetting.clickToButtonEditUsername();

        log.info("Step 2. Enter username");
        accountSetting.enterDataToUsernameField(userName);

        log.info("Step 3. Verify message of Fucntion Change username");
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");

        log.info("Step 4. Verify status of button save change username");
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername());

        log.info("Step 5. Click to save change username");
        accountSetting.clickToButtonSaveChangeUserName();

        log.info("Step 6. Verify username has been change successfully");
        verifyTrue(accountSetting.getUserIdentityNameDisplay().endsWith(userName));
    }

    @Test
    public void TC03_Update_Username_With_Username_Has_Capital_Letters() {
        log.info("Prepare data");
        userName = "HuyHoDoan" + randomNumber(22000);

        log.info("Step 1. Open function Edit username");
        accountSetting.clickToButtonEditUsername();

        log.info("Step 2. Enter username");
        accountSetting.enterDataToUsernameField(userName);

        log.info("Step 3. Verify message of Fucntion Change username");
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");

        log.info("Step 4. Verify status of button save change username");
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername());

        log.info("Step 5. Click to save change username");
        accountSetting.clickToButtonSaveChangeUserName();

        log.info("Step 6. Verify username has been change successfully");
        verifyTrue(accountSetting.getUserIdentityNameDisplay().endsWith(userName));
    }

    @Test
    public void TC04_Update_Username_With_Username_Is_Number() {
        log.info("Prepare data");
        userName = String.valueOf(randomNumber(1000000000));

        log.info("Step 1. Open function Edit username");
        accountSetting.clickToButtonEditUsername();

        log.info("Step 2. Enter username");
        accountSetting.enterDataToUsernameField(userName);

        log.info("Step 3. Verify message of Fucntion Change username");
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");

        log.info("Step 4. Verify status of button save change username");
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername());

        log.info("Step 5. Click to save change username");
        accountSetting.clickToButtonSaveChangeUserName();

        log.info("Step 6. Verify username has been change successfully");
        verifyTrue(accountSetting.getUserIdentityNameDisplay().endsWith(userName));
    }
    @Test
    public void TC05_Update_Username_With_Username_Is_AlphaNumber(){
        log.info("Prepare data");
        userName = removeAllWhitespace(data.getFirstName()) + randomNumber(20000);

        log.info("Step 1. Open function Edit username");
        accountSetting.clickToButtonEditUsername();

        log.info("Step 2. Enter username");
        accountSetting.enterDataToUsernameField(userName);

        log.info("Step 3. Verify message of Fucntion Change username");
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");

        log.info("Step 4. Verify status of button save change username");
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername());

        log.info("Step 5. Click to save change username");
        accountSetting.clickToButtonSaveChangeUserName();

        log.info("Step 6. Verify username has been change successfully");
        verifyTrue(accountSetting.getUserIdentityNameDisplay().endsWith(userName));
    }

    @Test
    public void TC06_Update_Username_With_Username_is_All_Uppercase(){
        log.info("Prepare data");
        userName = removeAllWhitespace(data.getFirstName()).toUpperCase();

        log.info("Step 1. Open function Edit username");
        accountSetting.clickToButtonEditUsername();

        log.info("Step 2. Enter username");
        accountSetting.enterDataToUsernameField(userName);

        log.info("Step 3. Verify message of Fucntion Change username");
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");

        log.info("Step 4. Verify status of button save change username");
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername());

        log.info("Step 5. Click to save change username");
        accountSetting.clickToButtonSaveChangeUserName();

        log.info("Step 6. Verify username has been change successfully");
        verifyTrue(accountSetting.getUserIdentityNameDisplay().endsWith(userName));

    }

    @Test
    public void TC07_Update_UserName_With_Data_Has_Endwith_Is_Dot(){
        log.info("Prepare data");
        userName = "huy.hodoan."+randomNumber(300000);

        log.info("Step 1. Open function Edit username");
        accountSetting.clickToButtonEditUsername();

        log.info("Step 2. Enter username");
        accountSetting.enterDataToUsernameField(userName);

        log.info("Step 3. Verify message of Fucntion Change username");
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");

        log.info("Step 4. Verify status of button save change username");
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername());

        log.info("Step 5. Click to save change username");
        accountSetting.clickToButtonSaveChangeUserName();

        log.info("Step 6. Verify username has been change successfully");
        verifyTrue(accountSetting.getUserIdentityNameDisplay().endsWith(userName));

        log.info("End step. Logot account");
        accountSetting.clickToItemOnSettingMenu(driver,"ic-logout-c");
        signUpPageObject = PageGeneration.createFormRegister(driver);
    }

    @Test
    public void TC7_Update_Username_With_Case_NewAccount(){
        log.info("Prepare data");
        String firstName  = data.getFirstName();
        String lastName = data.getLastName();
        String email = randomVirtualEmail();
        userName = "huy.hodoan."+randomNumber(300000);

        log.info("Step 1. Register new account");
        signUpPageObject.signUpWithNewAccountByEmail(firstName, lastName, email, "123456", "123456");
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 2. Verify register new account successfully");
        verifyTrue(newsFeedHomePage.checkNewsfeedDisplayOnFirstTime());

        log.info("Step 3. Cancel update new info");
        newsFeedHomePage.clickCancelUpdateNewInfo();

        log.info("Step 4. Go to General account setting");
        newsFeedHomePage.clickToItemOnSettingMenu(driver,"ic-cog-c");
        accountSetting = PageGeneration.createGeneralAccountSettingPage(driver);

        log.info("Step 5. Verify General account display successfully");
        verifyTrue(accountSetting.checkAccountGeneralSettingIsDisplay());

        log.info("Step 6. Check content of Function Change username");
        verifyEquals(accountSetting.getMessageNoUsername(),"Bạn chưa thiết lập tên người dùng");

        log.info("Step 7. Open function Edit username");
        accountSetting.clickToButtonEditUsername();

        log.info("Step 2. Enter username");
        accountSetting.enterDataToUsernameField(userName);

        log.info("Step 3. Verify message of Fucntion Change username");
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");

        log.info("Step 4. Verify status of button save change username");
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername());

        log.info("Step 5. Click to save change username");
        accountSetting.clickToButtonSaveChangeUserName();

        log.info("Step 6. Verify username has been change successfully");
        verifyTrue(accountSetting.getUserIdentityNameDisplay().endsWith(userName));

        String urlUserName = accountSetting.getUserIdentityNameDisplay();

        log.info("Step 6. Go to Personal About - Overview");
        accountSetting.clickToAvatarOnHeader(driver);
        perAboutCommonPageObject = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("Step 6. Verify personal URL with urlUsername");
        verifyEquals(perAboutCommonPageObject.getCurrentURL(driver),urlUserName);

    }

}
