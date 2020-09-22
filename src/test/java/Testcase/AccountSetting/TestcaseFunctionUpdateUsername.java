package Testcase.AccountSetting;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.AccountSetting.GeneralAccountSetting;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.About.PersonalAboutPage;
import Project.Shared.Login.LoginPage;
import Project.Shared.SingUp.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class TestcaseFunctionUpdateUsername extends AbstractTest {
    DriverManager driverManager;
    WebDriver driver;
    LoginPage loginNewsfeedPage;
    NewsfeedHomepage newsFeedHomePage;
    GeneralAccountSetting accountSetting;
    SignUpPage signUpPage;
    PersonalAboutPage personalAboutPage;
    String account = "balo_04@mailinator.com";
    String passWord = "123456";
    String htmlCode;
    String scriptCode;

    @BeforeTest
    public void Precondition(String browserName){
        driverManager = BrowserInitialization.getBrowser(browserName);
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        loginNewsfeedPage = PageGeneration.createNewsfeedLoginPage(driver);
        loginNewsfeedPage.Login(driver,account,passWord);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Precondition step 2.1 - AccountSetting page - Click Account Setting on menu");
        newsFeedHomePage.clickToItemOnSettingMenu(driver,"");
        accountSetting = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Step 1 - Click Edit Username");
        accountSetting.clickToButtonEditUsername();
    }

    public void TC_01_CheckValidationOfUser_Negative_Case(){
        log.info("Step 1 - Enter UserName blank");
        accountSetting.enterDataToUsernameField(driver,"");
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername(driver));

        log.info("Step 4 - Enter UserName whit all whitespace");
        accountSetting.enterDataToUsernameField(driver,"  ");
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername(driver));
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Phải có ít nhất 5 kí tự");

        log.info("Step 5 - Enter UserName contain whitespace on middle");
        accountSetting.enterDataToUsernameField(driver,"huy hodoan");
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername(driver));
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Có chứa ký tự không hợp lệ.");

        log.info("Step 6 - Enter UserName contain diots on end");
        accountSetting.enterDataToUsernameField(driver,"huyhodoan.");
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername(driver));
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Có chứa ký tự đặc biệt không đúng chỗ");

        log.info("Step 7 - Enter UserName contain special character");
        accountSetting.enterDataToUsernameField(driver,"huyhodo@an");
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername(driver));
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Có chứa ký tự không hợp lệ.");

        log.info("Step 8 - Enter UserName less than 5 character");
        accountSetting.enterDataToUsernameField(driver,"huya");
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername(driver));
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Phải có ít nhất 5 kí tự   ");

        log.info("Step 9 - Enter UserName contain exceed 50 characters");
        accountSetting.enterDataToUsernameField(driver,randomName(51));
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername(driver));
        verifyEquals(accountSetting.getErrMessOnUsername() ," Tên người dùng vượt số ký tự tối đa cho phép");

        log.info("Step 10 - Enter UserName contain script code");
        accountSetting.enterDataToUsernameField(driver, scriptCode);
        verifyEquals(accountSetting.getErrMessOnUsername() ,"  Có chứa ký tự không hợp lệ.");
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername(driver));

        log.info("Step 11 - Enter UserName contain HTML code");
        accountSetting.enterDataToUsernameField(driver, htmlCode);
        verifyEquals(accountSetting.getErrMessOnUsername() ,"  Có chứa ký tự không hợp lệ.");
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername(driver));

        log.info("Step 12 - Enter UserName contain marks");
        accountSetting.enterDataToUsernameField(driver,"huayhô");
        verifyEquals(accountSetting.getErrMessOnUsername() ,"  Có chứa ký tự không hợp lệ.");
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername(driver));
    }

    public void TC_02_Update_UserName_With_ValidData() {
        accountSetting.clickToButtonEditUsername();
        log.info("Step 2 - Enter UserName valid");
        accountSetting.enterDataToUsernameField(driver,"huyhodoan");
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");
        accountSetting.clickToButtonSaveChangeUserName(driver);
        verifyEquals(accountSetting.getUserIdentityNameDisplay(driver), "huyhodoan");
    }


    public void TC_03_Update_UserName_With_Data_Has_Uppercase() {
        accountSetting.clickToButtonEditUsername();
        log.info("Step 2 - Enter UserName valid");
        accountSetting.enterDataToUsernameField(driver,"HuyhoDoan");
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");
        accountSetting.clickToButtonSaveChangeUserName(driver);
        verifyEquals(accountSetting.getUserIdentityNameDisplay(driver), "");
    }

    public void TC_04_Update_UserName_With_Data_Has_Contains_All_Number() {
        accountSetting.clickToButtonEditUsername();
        log.info("Step 2 - Enter UserName valid");
        accountSetting.enterDataToUsernameField(driver,"123456789");
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");
        accountSetting.clickToButtonSaveChangeUserName(driver);
        verifyEquals(accountSetting.getUserIdentityNameDisplay(driver), "");
    }

    public void TC_05_Update_UserName_With_Data_Has_Contains_Alpha_Number(){
        accountSetting.clickToButtonEditUsername();
        log.info("Step 2 - Enter UserName valid");
        accountSetting.enterDataToUsernameField(driver,"huyhodoan1210");
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");
        accountSetting.clickToButtonSaveChangeUserName(driver);
        verifyEquals(accountSetting.getUserIdentityNameDisplay(driver), "huyhodoan1210");
    }

    public void TC_05_Update_UserName_With_Data_Has_Contains_Diots_On_Middle(){
        accountSetting.clickToButtonEditUsername();
        log.info("Step 2 - Enter UserName valid");
        accountSetting.enterDataToUsernameField(driver,"huy.hodoan.1210");
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");
        accountSetting.clickToButtonSaveChangeUserName(driver);
        verifyEquals(accountSetting.getUserIdentityNameDisplay(driver), "huy.hodoan.1210");

        accountSetting.clickToItemOnSettingMenu(driver,"");
        signUpPage = PageGeneration.createFormRegister(driver);
    }

    public void checkDefaultUsernameAndUpdateValidUsernameCaseNewAccount(){
        signUpPage.enterDataValueToDynamicOnFormSignUp("firstname", "");
        signUpPage.enterDataValueToDynamicOnFormSignUp("lastname", "");
        signUpPage.enterDataValueToDynamicOnFormSignUp("email", "");
        signUpPage.enterDataValueToDynamicOnFormSignUp("password", "");
        signUpPage.enterDataValueToDynamicOnFormSignUp("confirmpassword", "");
        signUpPage.clickSignUpButton();
        verifyTrue(signUpPage.getTitleOfVerifyForm().contains(""));
        verifyEquals(signUpPage.getUserAccountToDisplay(), "");
        String code = signUpPage.getVerifyCodeByEmail("");
        signUpPage.enterVerifyCodeToVerifyAccount(driver,code);
        signUpPage.clickToVerifyAccount(driver);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
        newsFeedHomePage.clickToItemOnSettingMenu(driver,"");
        accountSetting = PageGeneration.createGeneralAccountSettingPage(driver);
        verifyEquals(accountSetting.checkUserNameIsDisplay(),"");
        accountSetting.clickToButtonEditUsername();
        accountSetting.enterDataToUsernameField(driver,"huy.hodoan.1210");
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");
        accountSetting.clickToButtonSaveChangeUserName(driver);
        verifyEquals(accountSetting.getUserIdentityNameDisplay(driver), "huy.hodoan.1210");
        String urlUserName = accountSetting.getUserIdentityNameDisplay(driver);

        accountSetting.clickToItemOnSettingMenu(driver,"");
        personalAboutPage = PageGeneration.createPerTAboutPage(driver);

        verifyEquals(personalAboutPage.getCurrentURL(driver),urlUserName);

    }

}
