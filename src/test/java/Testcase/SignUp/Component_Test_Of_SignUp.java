package Testcase.SignUp;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.About.PersonalAboutPage;
import Project.Shared.Login.LoginPage;
import Project.Shared.SingUp.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Component_Test_Of_SignUp extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper data = DataHelper.getData();
    SignUpPage signUpPage;
    LoginPage newsfeedLoginPage;
    NewsfeedHomepage newsfeedPage;
    PersonalAboutPage personalAboutPage;
    // Khai báo giá trị nhập vào
    String email, firstName, lastName;
    String HTML_CODE, SCRIPT_CODE;
    String verifyCode;

    @Parameters("browser")
    @BeforeClass
    public void openBrowser(String urlPage){
        log.info("Precondition - Create driver browser");
        driverManager = BrowserInitialization.getBrowser(urlPage);
        log.info("Precondition - Go to NewsFeed Login");
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);
        log.info("Step 9. Change language to Vietnamese");
        newsfeedLoginPage.clickToChangeLanguageToVI(driver);
        signUpPage = PageGeneration.createFormRegister(driver);
    }
    @BeforeMethod
    public void prepareData(){
        email = randomVirtualEmail();
        firstName = data.getFirstName();
        lastName = data.getFirstName();
        HTML_CODE ="<p>HelloWord</p>";
        SCRIPT_CODE= "<script>destroyWebsite();</script>";
    }
    @Test
    public void Testcase_Register_01_Check_Register_New_Account_With_Invalid_FirstName(){
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
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv104", SCRIPT_CODE);
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp( "nv104"),"Tên không chứa ký tự đặc biệt.");
        log.info("Step 7 - Input First name is HTML Code");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv104",HTML_CODE);
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv104"),"Tên không chứa ký tự đặc biệt.");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv104",firstName);
    }
    @Test
    public void Testcase_Register_02_Check_Register_New_Account_With_Invalid_LastName(){
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
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv103", SCRIPT_CODE);
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ không chứa ký tự đặc biệt.");
        log.info("Step 7. Last name contains HTML Code");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv103",HTML_CODE);
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp("nv103"),"Họ không chứa ký tự đặc biệt.");

        signUpPage.enterDataValueToDynamicOnFormSignUp("nv103", lastName);
    }
    @Test
    public void Testcase_Register_03_Check_Register_New_Account_With_Invalid_Email() {
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
    public void Testcase_Register_03_Check_Register_New_Account_With_Invalid_Phonenumber() {
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
    }
    @Test
    public void Testcase_Register_06_Check_Register_New_Account_With_Invalid_Password(){
        log.info("Precondition");
        signUpPage.enterDataValueToDynamicOnFormSignUp("nv108",email);
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


        signUpPage.enterDataValueToDynamicOnFormSignUp("nv109","123456");
    }
    @Test
    public void Testcase_Register_07_Check_Register_New_Account_With_Invalid_Confirm_Password(){
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
    //    @Test
//    public void TC07_ValidationOFPhoneCode() {
//        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword","123456");
//        log.info("Step 1.1 - Input Phone");
//        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","840936709449");
//        log.info("Step 2.1 - Phone area code");
//        newsfeedLoginPage.removePhoneCode();
//        log.info("Step 4.2 - Click SignUp button");
//        newsfeedLoginPage.clickSignUpButton();
//        verifyEquals(newsfeedLoginPage.getErrValidationOfPhoneCode(),"Mã vùng là bắt buộc.");
//    }
    @Test
    public void Testcase_Register_08_Check_Register_New_Account_With_UpperCase_Email() {
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
        log.info("Step 10. Go To Personal about");
        newsfeedPage.clickToEditProfile(driver);
        personalAboutPage = PageGeneration.createPerTAboutPage(driver);
        log.info("Step 11. Check email display");
        verifyEquals(personalAboutPage.getEmailIsDisplayOnIntroduceWidget(), email);
        log.info("Step 12 - Logout account");
        personalAboutPage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        signUpPage = PageGeneration.createFormRegister(driver);
    }
    @Test
    public void Testcase_Register_09_Check_Register_New_Account_ContainsMoreThan2Idots() {
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
        log.info("Step 10. Go To Personal about");
        newsfeedPage.clickToEditProfile(driver);
        personalAboutPage = PageGeneration.createPerTAboutPage(driver);
        log.info("Step 11. Check email display");
        verifyEquals(personalAboutPage.getEmailIsDisplayOnIntroduceWidget(), email);
        log.info("Step 12. Logout account");
        personalAboutPage.clickToItemOnSettingMenu(driver,"ic-logout-c");
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
        log.info("Step 10. Go To Personal about");
        newsfeedPage.clickToEditProfile(driver);
        personalAboutPage = PageGeneration.createPerTAboutPage(driver);
        log.info("Step 11. Check email display");
        verifyEquals(personalAboutPage.getEmailIsDisplayOnIntroduceWidget(), email);
        log.info("Step 12 - Logout account");
        personalAboutPage.clickToItemOnSettingMenu(driver,"ic-logout-c");
        signUpPage = PageGeneration.createFormRegister(driver);
    }
}
