package Testcase.SignUp;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.AccountSetting.GeneralAccountSetting;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.About.PerAbout_Overview_PageObject;
import Project.Shared.Login_PageObject;
import Project.Shared.SignUp_PageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Component_Test_Of_SignUp extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper data = DataHelper.getData();
    SignUp_PageObject signUpPageObject;
    Login_PageObject newsfeedLoginPageObject;
    NewsfeedHomepage newsfeedPage;
    PerAbout_Overview_PageObject overviewPage;
    GeneralAccountSetting generalSettingAccountPage;
    // Khai báo giá trị nhập vào
    String email, firstName, lastName;
    String verifyCode;

    @Parameters("browser")
    @BeforeClass
    public void openBrowser(String urlPage){
        log.info("Precondition - Create driver browser");
        driverManager = BrowserInitialization.getBrowser(urlPage);

        log.info("Precondition - Go to NewsFeed Login");
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        newsfeedLoginPageObject = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Step 9. Change language to Vietnamese");
        newsfeedLoginPageObject.clickToChangeLanguageToVI(driver);
        signUpPageObject = PageGeneration.createFormRegister(driver);
    }
    @BeforeMethod
    public void prepareData(){
        email = randomVirtualEmail();
        firstName = data.getFirstName();
        lastName = data.getFirstName();
    }
    @Test
    public void TC01_Register_Account_With_Invalid_FirstName(){
        log.info("Prepare data");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103", lastName);
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", email);
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv109","123456");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("repeatPassword","123456");

        log.info("Step 1. Do Enter First name");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104","");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên là bắt buộc.");

        log.info("Step 2. Enter First name whitespace");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104","    ");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên là bắt buộc.");

        log.info("Step 3. First name contains numChar");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104","12345647");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên không chứa số.");

        log.info("Step 4. First name contains AlphaNumberChar");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104","Huy12");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên không chứa số.");

        log.info("Step 5. First name contains SpecialChar");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104","H@ang @anh");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên không chứa ký tự đặc biệt.");

        log.info("Step 6 - First name is Script code");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104", GlobalVariables.SCRPIT_CODE);
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp( "nv104"),"Tên không chứa ký tự đặc biệt.");

        log.info("Step 7 - Input First name is HTML Code");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104",GlobalVariables.HTML_CODE);
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên không chứa ký tự đặc biệt.");

        log.info("Prepare data");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104",firstName);
    }
    @Test
    public void TC02_Register_Account_With_Invalid_LastName(){
        log.info("Step 1. Do not input Last name");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103", "");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ là bắt buộc.");

        log.info("Step 2. Last name contains whitespace");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103","    ");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ là bắt buộc.");

        log.info("Step 3. Last name contains NumChar");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103","12345647");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ không chứa số.");

        log.info("Step 4. Last name contains Alpha number character");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103","Hồ 12");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ không chứa số.");

        log.info("Step 5. Last name contains specialChar");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103","H@ Do@an");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ không chứa ký tự đặc biệt.");

        log.info("Step 6. Last name contains Script Code");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103", GlobalVariables.SCRPIT_CODE);
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ không chứa ký tự đặc biệt.");

        log.info("Step 7. Last name contains HTML Code");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103",GlobalVariables.HTML_CODE);
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ không chứa ký tự đặc biệt.");

        log.info("Prepare data");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103", lastName);
    }
    @Test
    public void TC03_Register_Account_With_Invalid_Email() {
        log.info("Email is blank");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", "");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản là bắt buộc.");

        log.info("Email contains all white characters");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", "   ");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản là bắt buộc.");

        log.info("Email does not have a domain");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", "huyho12@gmail.");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Existed email on Hahalolo");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", "balo_04@mailinator.com");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản đã tồn tại trên hệ thống Hahalolo");

        log.info("Email contains special characters");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", "huy!@hoho@mailinator.com");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Email contains whitespace on first position");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", " huy@mailinator.com");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Email contains whitespace on middle position");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", "huy ho@mailinator.com");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Email contains whitespace on last position");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", "huyho@mailinator.com ");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");
    }
    @Test
    public void TC03_Register_Account_With_Invalid_Phonenumber() {
        log.info("Phone is blank");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", "");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản là bắt buộc.");

        log.info("Phone contains all white characters");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", "   ");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản là bắt buộc.");

        log.info("Phone number less than 8");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108","0902222");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Phone number greather than 20");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108",String.valueOf(randomNumber(21)));
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Phone number invalid with phone area");
        signUpPageObject.choosePhoneCode("(+84) Viet Nam");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", "0541565555");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Số điện thoại không hợp lệ.");

        log.info("Existed Phone");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108","0936709449");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản đã tồn tại trên hệ thống Hahalolo");

        log.info("Phone contains phone code(+84)");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108","+840936709449");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Precondition");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108",email);
    }
    @Test
    public void TC04_Register_Account_With_Invalid_Password(){

        log.info("Step 1. Enter blank Password");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv109","");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv109"),"Mật khẩu là bắt buộc.");

        log.info("Step 2. Enter Password <6 chars");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv109","12345");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv109"),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");

        log.info("Step 3. Enter Password > 128 chars");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv109",randomPassword(129));
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv109"),"Giới hạn tối đa của Mật khẩu là 128 kí tự");

        log.info("Step 4. Enter Password contains whitespace");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv109","123 456");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv109"),"Mật khẩu không chứa kí tự trắng.");

        log.info("Precondition");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv109","123456");
    }
    @Test
    public void TC05_Register_Account_With_Invalid_Confirm_Password(){
        log.info("Step 1. Do not input Confirm Password");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("repeatPassword","");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("repeatPassword"),"Mật khẩu xác nhận là bắt buộc.");

        log.info("Step 2. Enter Confirm Password contains whitespace");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("repeatPassword","123 456");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("repeatPassword"),"Mật khẩu xác nhận không chứa kí tự trắng.");

        log.info("Step 3. Enter Confirm Password <6 chars");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("repeatPassword","12345");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");

        log.info("Step 4. Enter ConfirmPassword > 128 chars");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("repeatPassword",randomPassword(129));
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");

        log.info("Step 5. Enter Password not same confirm pass");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("repeatPassword","1234567");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");
    }
    @Test
    public void TC06_Register_Account_With_UpperCase_Email() {
        signUpPageObject.refreshPage(driver);
        log.info("Step 1. Input FirstName");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104", firstName);

        log.info("Step 2. Input LastName");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103", lastName);

        log.info("Step 3. Input email");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108",email.toUpperCase());

        log.info("Step 4. Input Password");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv109","123456");

        log.info("Step 5. Input ConfirmPass");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("repeatPassword","123456");

        log.info("Step 6. Click SignUp button and verify email of account display");
        signUpPageObject.clickSignUpButton();
        verifyTrue(signUpPageObject.getTitleOfVerifyForm().endsWith("email"));
        verifyEquals(signUpPageObject.getUserAccountToDisplay(), email);

        log.info("Step 7. Input verify code and verify account");
        verifyCode = signUpPageObject.getVerifyCodeByEmail(email);
        signUpPageObject.enterVerifyCodeToVerifyAccount(verifyCode);
        signUpPageObject.clickToVerifyAccount();
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 8. Check form update info display");
        newsfeedPage.checkNewsfeedDisplayOnFirstTime();

        log.info("Step 9. Click cancel update information");
        newsfeedPage.clickCancelUpdateNewInfo();
        String fullName = newsfeedPage.getFullNameDisplayOnMyAccount();

        log.info("Step 10. Go To Personal about");
        newsfeedPage.clickToEditProfile();
        overviewPage = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("Step 11. Check email display");
        verifyEquals(overviewPage.getEmailIsDisplayOnIntroduceWidget(), email);

        log.info("Step 12 - Logout account");
        overviewPage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        signUpPageObject = PageGeneration.createFormRegister(driver);
    }
    @Test
    public void TC07_Register_Account_ContainsMoreThan2Idots() {
        log.info("Step 1. Input FirstName");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104", firstName);

        log.info("Step 2. Input LastName");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103", lastName);

        log.info("Step 3. Input Email");
        email = randomVirtualEmail();
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108",email);

        log.info("Step 4. Input Password");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv109","123456");

        log.info("Step 5. Input ConfirmPass");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("repeatPassword","123456");

        log.info("Step 6. Click SignUp button and verify account display");
        signUpPageObject.clickSignUpButton();
        verifyTrue(signUpPageObject.getTitleOfVerifyForm().endsWith("email"));
        verifyEquals(signUpPageObject.getUserAccountToDisplay(), email);

        log.info("Step 7. Input verify code and verify account");
        verifyCode = signUpPageObject.getVerifyCodeByEmail(email);
        signUpPageObject.enterVerifyCodeToVerifyAccount(verifyCode);
        signUpPageObject.clickToVerifyAccount();
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 8. Check form update info display");
        newsfeedPage.checkNewsfeedDisplayOnFirstTime();

        log.info("Step 9. Click cancel update");
        newsfeedPage.clickCancelUpdateNewInfo();
        String fullName = newsfeedPage.getFullNameDisplayOnMyAccount();

        log.info("Step 10. Go To Personal about -Overview");
        newsfeedPage.clickToEditProfile();
        overviewPage = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("Step 11. Check email display");
        verifyEquals(overviewPage.getEmailIsDisplayOnIntroduceWidget(), email);

        log.info("Step 12. Logout account");
        overviewPage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        signUpPageObject = PageGeneration.createFormRegister(driver);
    }
    @Test (enabled = false)
    public void Testcase_Register_10_Check_Register_Phone_Have_AreaCode() {
        log.info("Step 1. Input FirstName");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104", firstName);

        log.info("Step 2. Input LastName");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103", lastName);

        log.info("Step 3. Input Phone");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108","840936709449");

        log.info("Step 4. Input Password");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv109","123456");

        log.info("Step 5. Input ConfirmPass");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("repeatPassword","123456");

        log.info("Step 6. Click SignUp button and verify phone of account display");
        signUpPageObject.clickSignUpButton();
        verifyTrue(signUpPageObject.getTitleOfVerifyForm().contains("Số điện thoại"));
        verifyEquals(signUpPageObject.getUserAccountToDisplay(), "840936709449");

        log.info("Step 7. Input verify code and verify account");
        verifyCode = signUpPageObject.getVerifyCodeByEmail(email);
        signUpPageObject.enterVerifyCodeToVerifyAccount(verifyCode);
        signUpPageObject.clickToVerifyAccount();
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 8. Check form update info display");
        newsfeedPage.checkNewsfeedDisplayOnFirstTime();

        log.info("Step 9. Click cancel update");
        newsfeedPage.clickCancelUpdateNewInfo();
        String fullName = newsfeedPage.getFullNameDisplayOnMyAccount();

        log.info("Step 10. Go To Personal about");
        newsfeedPage.clickToEditProfile();
        overviewPage = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("Step 11. Check email display");
        verifyEquals(overviewPage.getEmailIsDisplayOnIntroduceWidget(), email);

        log.info("Step 12 - Logout account");
        overviewPage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        signUpPageObject = PageGeneration.createFormRegister(driver);
    }

    public void TC07_Register_Account_With_Uppercase_Firstname(){
        log.info("Step 1. Input FirstName");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104", firstName.toUpperCase());

        log.info("Step 2. Input LastName");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103", lastName);

        log.info("Step 3. Input Phone");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108",email);

        log.info("Step 4. Input Password");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv109","123456");

        log.info("Step 5. Input ConfirmPass");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("repeatPassword","123456");

        log.info("Step 6. Click SignUp button");
        signUpPageObject.clickSignUpButton();

        log.info("Step 6. Verify form register account by email display successfully");
        verifyTrue(signUpPageObject.getTitleOfVerifyForm().endsWith("email"));
        verifyEquals(signUpPageObject.getUserAccountToDisplay(), email);

        log.info("Step 7. Input verify code");
        verifyCode = signUpPageObject.getVerifyCodeByEmail(email);
        signUpPageObject.enterVerifyCodeToVerifyAccount(verifyCode);

        log.info("Step 7. Click verify button");
        signUpPageObject.clickToVerifyAccount();
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 8. Check verify account succesfully and check form update info is display");
        newsfeedPage.checkNewsfeedDisplayOnFirstTime();

        log.info("Step 9. Click cancel update information");
        newsfeedPage.clickCancelUpdateNewInfo();
        String fullName = newsfeedPage.getFullNameDisplayOnMyAccount();

        log.info("Step 9. Verify fullname display on My account");
        verifyEquals(newsfeedPage.getFullNameDisplayOnMyAccount(),"");

        log.info("Step 10. Go to General Account Setting");
        newsfeedPage.clickToItemOnSettingMenu(driver,"");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);

        log.info("Step 10. Verify General Account Setting display successfully");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplay(),"");

    }

    public void TC07_Register_Account_With_Lowercase_Firstname(){

    }

    public void TC07_Register_Account_With_Firstname_Has_Whitespace_On_First_Position(){

    }

    public void TC07_Register_Account_With_Firstname_Has_Whitespace_On_Last_Position(){

    }

    public void TC07_Register_Account_With_Firstname_Has_Whitespace_On_Middle_Position(){

    }

    public void TC07_Register_Account_With_Uppercase_LastName(){

    }

    public void TC07_Register_Account_With_Lowercase_LastName(){

    }

    public void TC07_Register_Account_With_LastName_Has_Whitespace_On_First_Position(){

    }

    public void TC07_Register_Account_With_LastName_Has_Whitespace_On_Last_Position(){

    }

    public void TC07_Register_Account_With_LastName_Has_Whitespace_On_Middle_Position(){

    }
}
