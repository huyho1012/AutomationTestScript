package Testcase;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.PersonalAboutPage;
import Project.Shared.Login.LoginPage;
import Project.Shared.SingUp.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase_Register extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper data = DataHelper.getData();
    SignUpPage signUpPage;
    LoginPage newsfeedLoginPage;
    NewsfeedHomepage newsfeedPage;
    PersonalAboutPage personalAboutPage;
    // Khai báo giá trị nhập vào
    String email = randomVirtualEmail();
    String firstName = data.getFirstName();
    String lastName = data.getFirstName();
    String confirmPass,password;
    String HTML_CODE ="M";
    String SCRIPT_CODE= "";
    String verifyCode;

    @Parameters("browser")
    @BeforeClass
    public void openBrowser(String urlPage){
        log.info("Precondition - Create driver browser");
        driverManager = BrowserInitialization.getBrowser(urlPage);
        log.info("Precondition - Go to NewsFeed Login");
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        newsfeedLoginPage = PageGeneration.createLoginPage(driver);
    }
    @Test(enabled = false)
    public void Testcase_Register_01_Check_SignUpForm_With_Eng_Language(){
        newsfeedLoginPage.clickToChangeToEng(driver);
        signUpPage = PageGeneration.createFormRegister(driver);
        log.info("Check Title Of SignUp form when");
        verifyEquals(signUpPage.getTitleOfFormSignUp(driver),"Join Hahalolo Now!");
        log.info("Check placeholder of fields");
        verifyEquals(signUpPage.getPlaceholderOfDynamicField(),"First name");
        verifyEquals(signUpPage.getPlaceholderOfDynamicField(),"Last name");
        verifyEquals(signUpPage.getPlaceholderOfDynamicField(),"Phone number or Email");
        verifyEquals(signUpPage.getPlaceholderOfDynamicField(),"Password");
        verifyEquals(signUpPage.getPlaceholderOfDynamicField(),"Confirm Password");
        verifyEquals(signUpPage.getContentOfSignUpButton(),"Sign Up");
    }
    @Test(enabled = false)
    public void Testcase_Register_02_Check_SignUpForm_With_VI_Language(){
        log.info("Check Title Of SignUp form when");
        verifyEquals(signUpPage.getTitleOfFormSignUp(driver),"Tham gia Hahalolo ngay!");
        log.info("Check placeholder of fields");
        verifyEquals(signUpPage.getPlaceholderOfDynamicField(),"Tên");
        verifyEquals(signUpPage.getPlaceholderOfDynamicField(),"Họ");
        verifyEquals(signUpPage.getPlaceholderOfDynamicField(),"Điện thoại hoặc Email");
        verifyEquals(signUpPage.getPlaceholderOfDynamicField(),"Mật khẩu");
        verifyEquals(signUpPage.getPlaceholderOfDynamicField(),"Mật khẩu xác nhận");
        verifyEquals(signUpPage.getContentOfSignUpButton(),"Đăng ký");
    }
    @Test
    public void Testcase_Register_03_Check_Register_New_Account_With_Invalid_FirstName(){
        log.info("Precondition");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv103", lastName);
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108", email);
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv109","123456");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver, "repeatPassword","123456");
        log.info("Step 1. Do Enter First name");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv104","");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv104"),"Tên là bắt buộc.");
        log.info("Step 2. Enter First name whitespace");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv104","    ");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv104"),"Tên là bắt buộc.");
        log.info("Step 3. First name contains numChar");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv104","12345647");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv104"),"Tên không chứa số.");
        log.info("Step 4. First name contains AlphaNumberChar");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv104","Huy12");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv104"),"Tên không chứa số.");
        log.info("Step 5. First name contains SpecialChar");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv104","H@ang @anh");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv104"),"Tên không chứa ký tự đặc biệt.");
        log.info("Step 6 - First name is Script code");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv104", SCRIPT_CODE);
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver, "nv104"),"Tên không chứa ký tự đặc biệt.");
        log.info("Step 7 - Input First name is HTML Code");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv104",HTML_CODE);
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv104"),"Tên không chứa ký tự đặc biệt.");
    }
    @Test
    public void Testcase_Register_04_Check_Register_New_Account_With_Invalid_LastName(){
        log.info("Precondition");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv104",firstName);
        log.info("Step 1. Do not input Last name");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv103", "");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv103"),"Họ là bắt buộc.");
        log.info("Step 2. Last name contains whitespace");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv103","    ");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv103"),"Họ là bắt buộc.");
        log.info("Step 3. Last name contains NumChar");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv103","12345647");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv103"),"Họ không chứa số.");
        log.info("Step 4. Last name contains Alpha number character");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv103","Hồ 12");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv103"),"Họ không chứa số.");
        log.info("Step 5. Last name contains specialChar");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv103","H@ Do@an");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv103"),"Họ không chứa ký tự đặc biệt.");
        log.info("Step 6. Last name contains Script Code");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver, "nv103", SCRIPT_CODE);
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv103"),"Họ không chứa ký tự đặc biệt.");
        log.info("Step 7. Last name contains HTML Code");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv103",HTML_CODE);
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv103"),"Họ không chứa ký tự đặc biệt.");
    }
    @Test
    public void Testcase_Register_05_Check_Register_New_Account_With_Invalid_Username() {
        log.info("Precondition");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv103",lastName);
        log.info("Step 1. Do not input Email");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108","");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv108"), "Tài khoản là bắt buộc.");
        log.info("Step 2. Input email contains Whitespace");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108","   ");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv108"), "Tài khoản là bắt buộc.");
        log.info("Step 3. Input email not have domain");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108","huyho12@gmail.");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv108"), "Tài khoản không hợp lệ.");
        log.info("Step 4. Input existed email");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108","balo_04@mailinator.com");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv108"), "Tài khoản đã tồn tại trên hệ thống Hahalolo");
        log.info("Step 5. Input email contains special char");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108","huy!@hoho@mailinator.com");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv108"), "Tài khoản không hợp lệ.");
        log.info("Step 6. Input email contains whitespace on first");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108"," huy@mailinator.com");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv108"), "Tài khoản không hợp lệ.");
        log.info("Step 7. Input email contains whitespace on middle");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108","huy ho@mailinator.com");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv108"), "Tài khoản không hợp lệ.");
        log.info("Step 8. Input email contains whitespace on last");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108","huyho@mailinator.com ");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv108"), "Tài khoản không hợp lệ.");
        log.info("Step 9. Input invalid Phone");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108","09022222");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv108"), "Số điện thoại không hợp lệ.");
        log.info("Step 10. Input Existed Phone");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108","0936709449");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv108"), "Tài khoản đã tồn tại trên hệ thống Hahalolo");
        log.info("Step 11. Input Phone contains phone code(+84)");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108","+840936709449");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv108"), "Tài khoản không hợp lệ.");
    }

    @Test
    public void Testcase_Register_05_Check_Register_New_Account_With_Invalid_Password(){
        log.info("Precondition");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108",email);
        log.info("Step 1. Enter blank Password");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv109","");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv109"),"Mật khẩu là bắt buộc.");
        log.info("Step 2. Enter Password <6 chars");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv109","12345");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv109"),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");
        log.info("Step 3. Enter Password > 128 chars");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv109",randomPassword(129));
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv109"),"Giới hạn tối đa của Mật khẩu là 128 kí tự");
        log.info("Step 4. Enter Password contains whitespace");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv109","123 456");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv109"),"Mật khẩu không chứa kí tự trắng.");
    }
    @Test
    public void Testcase_Register_05_Check_Register_New_Account_With_Invalid_Confirm_Password(){
        log.info("Precondition");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv109","123456");
        log.info("Step 1. Do not input Confirm Password");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"repeatPassword","");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"repeatPassword"),"Mật khẩu xác nhận là bắt buộc.");
        log.info("Step 2. Enter Confirm Password contains whitespace");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"repeatPassword","123 456");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"repeatPassword"),"Mật khẩu xác nhận không chứa kí tự trắng.");
        log.info("Step 3. Enter Confirm Password <6 chars");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"repeatPassword","12345");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");
        log.info("Step 4. Enter ConfirmPassword > 128 chars");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"repeatPassword",randomPassword(129));
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");
        log.info("Step 5. Enter Password not same confirm pass");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"repeatPassword","1234567");
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");
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
    public void TC08_RegisterAccountWithEmailIsUppercase() {
        signUpPage.refreshPage(driver);
        log.info("Step 1. Input FirstName");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv104", firstName);
        log.info("Step 2. Input LastName");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv103", lastName);
        log.info("Step 3. Input email");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108",email.toUpperCase());
        log.info("Step 4. Input Password");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv109","123456");
        log.info("Step 5. Input ConfirmPass");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"repeatPassword","123456");
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
    public void TC09_RegisterAccountWithEmailContainsMoreThan2Idots() {
        log.info("Step 1. Input FirstName");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv104", firstName);
        log.info("Step 2. Input LastName");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv103", lastName);
        log.info("Step 3. Input Email");
        email = randomVirtualEmail();
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108",email);
        log.info("Step 4. Input Password");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv109","123456");
        log.info("Step 5. Input ConfirmPass");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"repeatPassword","123456");
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
    public void TC10_RegisterAccountWithPhoneHaveAreaCode() {
        log.info("Step 1. Input FirstName");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv104", firstName);
        log.info("Step 2. Input LastName");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver, "nv103", lastName);
        log.info("Step 3. Input Phone");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver, "nv108","840936709449");
        log.info("Step 4. Input Password");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv109","123456");
        log.info("Step 5. Input ConfirmPass");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"repeatPassword","123456");
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
