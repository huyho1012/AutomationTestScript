package Testcase.SignUp;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.AccountSetting.GeneralAccountSetting;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.About.PerAbout_Overview_Common_PageObjectObject;
import Project.Shared.Login_PageObject;
import Project.Shared.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Component_Test_Of_SignUp extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper data = DataHelper.getData();
    SignUpPage signUpPage;
    Login_PageObject newsfeedLoginPageObject;
    NewsfeedHomepage newsfeedPage;
    PerAbout_Overview_Common_PageObjectObject overviewPage;
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
        newsfeedLoginPageObject.clickToChangeLanguageToVI();
        signUpPage = PageGeneration.createFormRegister(driver);
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
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv103", lastName);
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108", email);
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv109","123456");
        signUpPage.enterDataValueToDynamicOnFormSignUp("repeatPassword","123456");

        log.info("Step 1. Do Enter First name");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv104","");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên là bắt buộc.");

        log.info("Step 2. Enter First name whitespace");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv104","    ");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên là bắt buộc.");

        log.info("Step 3. First name contains numChar");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv104","12345647");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên không chứa số.");

        log.info("Step 4. First name contains AlphaNumberChar");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv104","Huy12");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên không chứa số.");

        log.info("Step 5. First name contains SpecialChar");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv104","H@ang @anh");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên không chứa ký tự đặc biệt.");

        log.info("Step 6 - First name is Script code");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv104", GlobalVariables.SCRPIT_CODE);
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp( "nv104"),"Tên không chứa ký tự đặc biệt.");

        log.info("Step 7 - Input First name is HTML Code");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv104",GlobalVariables.HTML_CODE);
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên không chứa ký tự đặc biệt.");

        log.info("Prepare data");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv104",firstName);
    }
    @Test
    public void TC02_Register_Account_With_Invalid_LastName(){
        log.info("Step 1. Do not input Last name");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv103", "");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ là bắt buộc.");

        log.info("Step 2. Last name contains whitespace");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv103","    ");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ là bắt buộc.");

        log.info("Step 3. Last name contains NumChar");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv103","12345647");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ không chứa số.");

        log.info("Step 4. Last name contains Alpha number character");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv103","Hồ 12");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ không chứa số.");

        log.info("Step 5. Last name contains specialChar");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv103","H@ Do@an");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ không chứa ký tự đặc biệt.");

        log.info("Step 6. Last name contains Script Code");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv103", GlobalVariables.SCRPIT_CODE);
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ không chứa ký tự đặc biệt.");

        log.info("Step 7. Last name contains HTML Code");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv103",GlobalVariables.HTML_CODE);
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ không chứa ký tự đặc biệt.");

        log.info("Prepare data");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv103", lastName);
    }
    @Test
    public void TC03_Register_Account_With_Invalid_Email() {
        log.info("Email is blank");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108", "");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản là bắt buộc.");

        log.info("Email contains all white characters");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108", "   ");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản là bắt buộc.");

        log.info("Email does not have a domain");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108", "huyho12@gmail.");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Existed email on Hahalolo");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108", "balo_04@mailinator.com");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản đã tồn tại trên hệ thống Hahalolo");

        log.info("Email contains special characters");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108", "huy!@hoho@mailinator.com");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Email contains whitespace on first position");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108", " huy@mailinator.com");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Email contains whitespace on middle position");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108", "huy ho@mailinator.com");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Email contains whitespace on last position");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108", "huyho@mailinator.com ");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");
    }
    @Test
    public void TC03_Register_Account_With_Invalid_Phonenumber() {
        log.info("Phone is blank");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108", "");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản là bắt buộc.");

        log.info("Phone contains all white characters");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108", "   ");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản là bắt buộc.");

        log.info("Phone number less than 8");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108","0902222");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Phone number greather than 20");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108",String.valueOf(randomNumber(21)));
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Phone number invalid with phone area");
        signUpPage.choosePhoneCode("(+84) Viet Nam");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108", "0541565555");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Số điện thoại không hợp lệ.");

        log.info("Existed Phone");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108","0936709449");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản đã tồn tại trên hệ thống Hahalolo");

        log.info("Phone contains phone code(+84)");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108","+840936709449");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Precondition");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108",email);
    }
    @Test
    public void TC04_Register_Account_With_Invalid_Password(){

        log.info("Step 1. Enter blank Password");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv109","");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv109"),"Mật khẩu là bắt buộc.");

        log.info("Step 2. Enter Password <6 chars");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv109","12345");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv109"),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");

        log.info("Step 3. Enter Password > 128 chars");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv109",randomPassword(129));
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv109"),"Giới hạn tối đa của Mật khẩu là 128 kí tự");

        log.info("Step 4. Enter Password contains whitespace");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv109","123 456");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv109"),"Mật khẩu không chứa kí tự trắng.");

        log.info("Precondition");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv109","123456");
    }
    @Test
    public void TC05_Register_Account_With_Invalid_Confirm_Password(){
        log.info("Step 1. Do not input Confirm Password");
        signUpPage.enterDataValueToDynamicOnFormSignUp("repeatPassword","");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("repeatPassword"),"Mật khẩu xác nhận là bắt buộc.");

        log.info("Step 2. Enter Confirm Password contains whitespace");
        signUpPage.enterDataValueToDynamicOnFormSignUp("repeatPassword","123 456");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("repeatPassword"),"Mật khẩu xác nhận không chứa kí tự trắng.");

        log.info("Step 3. Enter Confirm Password <6 chars");
        signUpPage.enterDataValueToDynamicOnFormSignUp("repeatPassword","12345");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");

        log.info("Step 4. Enter ConfirmPassword > 128 chars");
        signUpPage.enterDataValueToDynamicOnFormSignUp("repeatPassword",randomPassword(129));
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");

        log.info("Step 5. Enter Password not same confirm pass");
        signUpPage.enterDataValueToDynamicOnFormSignUp("repeatPassword","1234567");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");
    }
    @Test
    public void TC06_Register_Account_With_UpperCase_Email() {
        signUpPage.refreshPage(driver);
        log.info("Step 1. Input FirstName");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv104", firstName);

        log.info("Step 2. Input LastName");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv103", lastName);

        log.info("Step 3. Input email");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108",email.toUpperCase());

        log.info("Step 4. Input Password");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv109","123456");

        log.info("Step 5. Input ConfirmPass");
        signUpPage.enterDataValueToDynamicOnFormSignUp("repeatPassword","123456");

        log.info("Step 6. Click SignUp button and verify email of account display");
        signUpPage.clickSignUpButton();
        verifyTrue(signUpPage.getTitleOfVerifyForm().endsWith("email"));
        verifyEquals(signUpPage.getUserAccountToDisplay(), email);

        log.info("Step 7. Input verify code and verify account");
        verifyCode = signUpPage.getVerifyCodeByEmail(email);
        signUpPage.enterVerifyCodeToVerifyAccount(driver, verifyCode);
        signUpPage.clickToVerifyAccount(driver);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 8. Check form update info display");
        newsfeedPage.checkNewsfeedDisplayOnFirstTime(driver);

        log.info("Step 9. Click cancel update information");
        newsfeedPage.clickCancelUpdateNewInfo();
        String fullName = newsfeedPage.getFullNameDisplayOnMyAccount();

        log.info("Step 10. Go To Personal about");
        newsfeedPage.clickToEditProfile(driver);
        overviewPage = PageGeneration.createPersonalOverviewPage(driver);

        log.info("Step 11. Check email display");
        verifyEquals(overviewPage.getEmailIsDisplayOnIntroduceWidget(), email);

        log.info("Step 12 - Logout account");
        overviewPage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        signUpPage = PageGeneration.createFormRegister(driver);
    }
    @Test
    public void TC07_Register_Account_ContainsMoreThan2Idots() {
        log.info("Step 1. Input FirstName");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv104", firstName);

        log.info("Step 2. Input LastName");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv103", lastName);

        log.info("Step 3. Input Email");
        email = randomVirtualEmail();
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108",email);

        log.info("Step 4. Input Password");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv109","123456");

        log.info("Step 5. Input ConfirmPass");
        signUpPage.enterDataValueToDynamicOnFormSignUp("repeatPassword","123456");

        log.info("Step 6. Click SignUp button and verify account display");
        signUpPage.clickSignUpButton();
        verifyTrue(signUpPage.getTitleOfVerifyForm().endsWith("email"));
        verifyEquals(signUpPage.getUserAccountToDisplay(), email);

        log.info("Step 7. Input verify code and verify account");
        verifyCode = signUpPage.getVerifyCodeByEmail(email);
        signUpPage.enterVerifyCodeToVerifyAccount(driver,verifyCode);
        signUpPage.clickToVerifyAccount(driver);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 8. Check form update info display");
        newsfeedPage.checkNewsfeedDisplayOnFirstTime(driver);

        log.info("Step 9. Click cancel update");
        newsfeedPage.clickCancelUpdateNewInfo();
        String fullName = newsfeedPage.getFullNameDisplayOnMyAccount();

        log.info("Step 10. Go To Personal about -Overview");
        newsfeedPage.clickToEditProfile(driver);
        overviewPage = PageGeneration.createPersonalOverviewPage(driver);

        log.info("Step 11. Check email display");
        verifyEquals(overviewPage.getEmailIsDisplayOnIntroduceWidget(), email);

        log.info("Step 12. Logout account");
        overviewPage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        signUpPage = PageGeneration.createFormRegister(driver);
    }
    @Test (enabled = false)
    public void Testcase_Register_10_Check_Register_Phone_Have_AreaCode() {
        log.info("Step 1. Input FirstName");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv104", firstName);

        log.info("Step 2. Input LastName");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv103", lastName);

        log.info("Step 3. Input Phone");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108","840936709449");

        log.info("Step 4. Input Password");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv109","123456");

        log.info("Step 5. Input ConfirmPass");
        signUpPage.enterDataValueToDynamicOnFormSignUp("repeatPassword","123456");

        log.info("Step 6. Click SignUp button and verify phone of account display");
        signUpPage.clickSignUpButton();
        verifyTrue(signUpPage.getTitleOfVerifyForm().contains("Số điện thoại"));
        verifyEquals(signUpPage.getUserAccountToDisplay(), "840936709449");

        log.info("Step 7. Input verify code and verify account");
        verifyCode = signUpPage.getVerifyCodeByEmail(email);
        signUpPage.enterVerifyCodeToVerifyAccount(driver,verifyCode);
        signUpPage.clickToVerifyAccount(driver);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 8. Check form update info display");
        newsfeedPage.checkNewsfeedDisplayOnFirstTime(driver);

        log.info("Step 9. Click cancel update");
        newsfeedPage.clickCancelUpdateNewInfo();
        String fullName = newsfeedPage.getFullNameDisplayOnMyAccount();

        log.info("Step 10. Go To Personal about");
        newsfeedPage.clickToEditProfile(driver);
        overviewPage = PageGeneration.createPersonalOverviewPage(driver);

        log.info("Step 11. Check email display");
        verifyEquals(overviewPage.getEmailIsDisplayOnIntroduceWidget(), email);

        log.info("Step 12 - Logout account");
        overviewPage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        signUpPage = PageGeneration.createFormRegister(driver);
    }

    public void TC07_Register_Account_With_Uppercase_Firstname(){
        log.info("Step 1. Input FirstName");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv104", firstName.toUpperCase());

        log.info("Step 2. Input LastName");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv103", lastName);

        log.info("Step 3. Input Phone");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108",email);

        log.info("Step 4. Input Password");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv109","123456");

        log.info("Step 5. Input ConfirmPass");
        signUpPage.enterDataValueToDynamicOnFormSignUp("repeatPassword","123456");

        log.info("Step 6. Click SignUp button");
        signUpPage.clickSignUpButton();

        log.info("Step 6. Verify form register account by email display successfully");
        verifyTrue(signUpPage.getTitleOfVerifyForm().endsWith("email"));
        verifyEquals(signUpPage.getUserAccountToDisplay(), email);

        log.info("Step 7. Input verify code");
        verifyCode = signUpPage.getVerifyCodeByEmail(email);
        signUpPage.enterVerifyCodeToVerifyAccount(driver,verifyCode);

        log.info("Step 7. Click verify button");
        signUpPage.clickToVerifyAccount(driver);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 8. Check verify account succesfully and check form update info is display");
        newsfeedPage.checkNewsfeedDisplayOnFirstTime(driver);

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
