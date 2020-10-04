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

public class Testcase_ComponentTest_SIgnUpAccount extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper data = DataHelper.getData();
    SignUp_PageObject signUpPageObject;
    Login_PageObject newsfeedLoginPageObject;
    NewsfeedHomepage newsfeedPage;
    PerAbout_Overview_PageObject overviewPage;
    GeneralAccountSetting generalSettingAccountPage;
    // Khai báo giá trị nhập vào
    String email, firstName, lastName, password, phone, confirmPass;
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
    @Test
    public void TC01_Register_Account_With_Invalid_FirstName(){
        log.info("Prepare data");
        email = randomVirtualEmail();
        lastName = data.getFirstName();
        password = "123456";
        confirmPass = "123456";
        log.info("Enter all field before check validate of first name");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103", lastName);
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", email);
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv109", password);
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("repeatPassword", confirmPass);

        log.info("Case: First name blank");
        firstName = "";
        log.info("Step 1. Enter a first name");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104", firstName);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Firstname");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên là bắt buộc.");

        log.info("Case: First name contains all whitespace");
        firstName = "    ";
        log.info("Step 1. Enter a first name");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104", firstName);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Firstname");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên là bắt buộc.");

        log.info("Case: First name contains only number");
        firstName = String.valueOf(randomNumber(20));
        log.info("Step 1. Enter a first name");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104", firstName);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Firstname");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên không chứa số.");

        log.info("Case: First name contains AlphaNumberChar");
        firstName =  data.getFirstName()+ randomNumber(10);
        log.info("Step 1. Enter a first name");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104", firstName);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Firstname");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên không chứa số.");

        log.info("Case. First name contains Special characters");
        firstName = "H@ang @anh";
        log.info("Step 1. Enter a first name");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104", firstName);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Firstname");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên không chứa ký tự đặc biệt.");

        log.info("Case: First name is Script code");
        firstName = GlobalVariables.SCRPIT_CODE;
        log.info("Step 1. Enter a first name");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104", firstName);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Firstname");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp( "nv104"),"Tên không chứa ký tự đặc biệt.");

        log.info("Case: First name is HTML Code");
        firstName = GlobalVariables.HTML_CODE;
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104", firstName);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Firstname");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC02_Register_Account_With_Invalid_LastName(){
        firstName = data.getFirstName();
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv104",firstName);

        log.info("Case: Last name is blank");
        lastName = "";
        log.info("Step 1. Enter a last name");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103", lastName);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Lastname");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ là bắt buộc.");

        log.info("Case: Last name contains all whitespace");
        lastName = "    ";
        log.info("Step 1. Enter a last name");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103",lastName);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Lastname");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ là bắt buộc.");

        log.info("Case: Last name contains only number");
        lastName = String.valueOf(randomNumber(12));
        log.info("Step 1. Enter a last name");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103", lastName);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Lastname");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ không chứa số.");

        log.info("Case: Last name contains Alpha number character");
        log.info("Step 1. Enter a last name");
        lastName = data.getLastName()+ randomNumber(12);
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103",lastName);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Lastname");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ không chứa số.");

        log.info("Case: Last name contains specialChar");
        log.info("Step 1. Enter a last name");
        lastName ="H@ Do@an";
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103",lastName);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Lastname");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ không chứa ký tự đặc biệt.");

        log.info("Case: Last name is Script Code");
        log.info("Step 1. Enter a last name");
        lastName =  GlobalVariables.SCRPIT_CODE;
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103", lastName);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ không chứa ký tự đặc biệt.");

        log.info("Case: Last name is HTML Code");
        log.info("Step 1. Enter a last name");
        lastName =  GlobalVariables.HTML_CODE;
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103", lastName);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Lastname");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC03_Register_Account_With_Invalid_Email() {
        lastName = data.getLastName();
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv103", lastName);

        log.info("Case: Email is blank");
        email = "";
        log.info("Step 1. Enter a Email");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", email);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Email");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản là bắt buộc.");

        log.info("Case: Email contains all white characters");
        email = "    ";
        log.info("Step 1. Enter a Email");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", email);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Email");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản là bắt buộc.");

        log.info("Case: Email does not have a domain");
        email = "huyho12@gmail.";
        log.info("Step 1. Enter a Email");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", email);
        log.info("Step 2. Click signup button");
        log.info("Step 3. Check error validation display on field Email");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Case: Existed email");
        log.info("Step 1. Enter a Email");
        email = "balo_04@mailinator.com";
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", email);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Email");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản đã tồn tại trên hệ thống Hahalolo");

        log.info("Case: Email contains special characters");
        email = "huy!@hoho@mailinator.com";
        log.info("Step 1. Enter a Email");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", email);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Email");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Case: Email contains whitespace on first position");
        email = " huy@mailinator.com";
        log.info("Step 1. Enter a Email");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", email);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Email");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Case: Email contains whitespace on middle position");
        email = "huy ho@mailinator.com";
        log.info("Step 1. Enter a Email");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", email);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Email");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Case: Email contains whitespace on last position");
        email = "huyho@mailinator.com ";
        log.info("Step 1. Enter a Email");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", email);
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        log.info("Step 3. Check error validation display on field Email");
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");
    }
    @Test
    public void TC03_Register_Account_With_Invalid_Phonenumber() {
        log.info("Case: Phone is blank");
        log.info("Step 1. Enter a Phone");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", "");
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản là bắt buộc.");

        log.info("Phone contains all white characters");
        log.info("Step 1. Enter a Phone");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", "   ");
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản là bắt buộc.");

        log.info("Phone number less than 8");
        log.info("Step 1. Enter a Phone");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108","0902222");
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Phone number greather than 20");
        log.info("Step 1. Enter a Phone");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108",String.valueOf(randomNumber(21)));
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản không hợp lệ.");

        log.info("Phone number invalid with phone area");
        log.info("Step 1. Enter a Phone");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108", "0541565555");
        signUpPageObject.choosePhoneCode("(+84) Viet Nam");
        log.info("Step 3. Click signup button");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Số điện thoại không hợp lệ.");

        log.info("Existed Phone");
        log.info("Step 1. Enter a Phone");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108","0936709449");
        log.info("Step 2. Click signup button");
        signUpPageObject.clickSignUpButton();
        verifyEquals(signUpPageObject.getValidErrMessageOfDynamicOnFormSignUp("nv108"), "Tài khoản đã tồn tại trên hệ thống Hahalolo");

        log.info("Phone contains phone code(+84)");
        log.info("Step 1. Enter a Phone");
        signUpPageObject.enterDataValueToDynamicOnFormSignUp("nv108","+840936709449");
        log.info("Step 2. Click signup button");
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
    public void TC06_Register_Account_With_Email_Is_UpperCase() {
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
    public void TC07_Register_Account_With_Email_Contains_More_Two_Dots() {
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
    public void TC08_Register_Account_With_Phone_Contains_PhoneCode() {
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

    public void TC09_Register_Account_With_Uppercase_Firstname(){
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

        generalSettingAccountPage.clickToItemOnSettingMenu(driver,"");
        signUpPageObject = PageGeneration.createFormRegister(driver);

    }

    public void TC10_Register_Account_With_Lowercase_Firstname(){
        firstName = data.getFirstName().toLowerCase();
        lastName = data.getLastName();
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedDisplayOnFirstTime());

        log.info("Click to cancel update information");
        newsfeedPage.clickCancelUpdateNewInfo();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemOnSettingMenu(driver,"");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkAccountGeneralSettingIsDisplay());

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplay(), fullName);
    }

    public void TC11_Register_Account_With_Firstname_Has_Whitespace_On_First_Position(){
        firstName = " " + data.getFirstName();
        lastName = data.getLastName();
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedDisplayOnFirstTime());

        log.info("Click to cancel update information");
        newsfeedPage.clickCancelUpdateNewInfo();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemOnSettingMenu(driver,"");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkAccountGeneralSettingIsDisplay());

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplay(), fullName);
    }

    public void TC12_Register_Account_With_Firstname_Has_Whitespace_On_Last_Position(){
        firstName = data.getFirstName() + " ";
        lastName = data.getLastName();
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedDisplayOnFirstTime());

        log.info("Click to cancel update information");
        newsfeedPage.clickCancelUpdateNewInfo();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemOnSettingMenu(driver,"");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkAccountGeneralSettingIsDisplay());

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplay(), fullName);
    }

    public void TC13_Register_Account_With_Firstname_Has_More_Than_2_Whitespace_On_Middle_Position(){
        firstName = "Huy Hồ";
        lastName = data.getLastName();
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedDisplayOnFirstTime());

        log.info("Click to cancel update information");
        newsfeedPage.clickCancelUpdateNewInfo();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemOnSettingMenu(driver,"");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkAccountGeneralSettingIsDisplay());

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplay(), fullName);
    }

    public void TC14_Register_Account_With_Uppercase_LastName(){
        firstName = data.getFirstName();
        lastName = data.getLastName().toUpperCase();
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedDisplayOnFirstTime());

        log.info("Click to cancel update information");
        newsfeedPage.clickCancelUpdateNewInfo();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemOnSettingMenu(driver,"");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkAccountGeneralSettingIsDisplay());

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplay(), fullName);
    }

    public void TC15_Register_Account_With_Lowercase_LastName(){
        firstName = data.getFirstName();
        lastName = data.getLastName().toLowerCase();
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedDisplayOnFirstTime());

        log.info("Click to cancel update information");
        newsfeedPage.clickCancelUpdateNewInfo();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemOnSettingMenu(driver,"");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkAccountGeneralSettingIsDisplay());

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplay(), fullName);
    }

    public void TC16_Register_Account_With_LastName_Has_Whitespace_On_First_Position(){
        firstName = data.getFirstName();
        lastName = "  " + data.getLastName();
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedDisplayOnFirstTime());

        log.info("Click to cancel update information");
        newsfeedPage.clickCancelUpdateNewInfo();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemOnSettingMenu(driver,"");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkAccountGeneralSettingIsDisplay());

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplay(), fullName);

    }

    public void TC17_Register_Account_With_LastName_Has_Whitespace_On_Last_Position(){
        firstName = data.getFirstName();
        lastName = data.getLastName() + "  ";
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedDisplayOnFirstTime());

        log.info("Click to cancel update information");
        newsfeedPage.clickCancelUpdateNewInfo();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemOnSettingMenu(driver,"");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkAccountGeneralSettingIsDisplay());

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplay(), fullName);

    }

    public void TC18_Register_Account_With_LastName_Has_Whitespace_On_Middle_Position() {
        firstName = data.getFirstName();
        lastName = "Hồ   Doãn";
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedDisplayOnFirstTime());

        log.info("Click to cancel update information");
        newsfeedPage.clickCancelUpdateNewInfo();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemOnSettingMenu(driver,"");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkAccountGeneralSettingIsDisplay());

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplay(), fullName);
    }
}
