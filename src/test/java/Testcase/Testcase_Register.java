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
    String HTML_CODE ="";
    String SCRIPT_CODE= "";

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
    public void TC02_CheckValidationLastName(){
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

        log.info("Step 6. LLast name contains Script Code");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver, "nv103", SCRIPT_CODE);
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv103"),"Họ không chứa ký tự đặc biệt.");

        log.info("Step 7.1 - Last name contains HTML Code");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv103",HTML_CODE);
        signUpPage.clickSignUpButton();
        verifyEquals(signUpPage.getValidErrMessageOfDynamicOnFormSignUp(driver,"nv103"),"Họ không chứa ký tự đặc biệt.");
    }

    @Test
    public void  TC03_ValidationOfEmail() {
        log.info("Restore field lastname with valid value");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103",lastName);

        log.info("Step 1.1 - Do not input Email");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","");

        log.info("Step 1.1 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 1.2 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản là bắt buộc.");

        log.info("Step 2.1 - Input email contains Whitespace");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","   ");

        log.info("Step 2.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 2.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản là bắt buộc.");

        log.info("Step 3.1 - Input invalid email");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","huyho12@gmail.");

        log.info("Step 3.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 3.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản không hợp lệ.");

        log.info("Step 4.1 - Input existed email");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","balo_04@mailinator.com");

        log.info("Step 4.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 4.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản đã tồn tại trên hệ thống Hahalolo");

        log.info("Step 5.1 - Input email contains special char");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","huy!@hoho@mailinator.com");

        log.info("Step 5.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 5.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản không hợp lệ.");

        log.info("Step 6.1 - Input email contains whitespace on first");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108"," huy@mailinator.com");

        log.info("Step 6.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 6.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản không hợp lệ.");

        log.info("Step 7.1 - Input email contains whitespace on middle");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","huy ho@mailinator.com");

        log.info("Step 7.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 7.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản không hợp lệ.");

        log.info("Step 8.1 - Input email contains whitespace on last");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","huyho@mailinator.com ");

        log.info("Step 8.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 8.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản không hợp lệ.");
    }

    @Test
    public void TC04_ValidateOfUsernameWithPhone() {
        log.info("Step 1.1 - Input invalid Phone");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","09022222");

        log.info("Step 1.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 1.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Số điện thoại không hợp lệ.");

        log.info("Step 2.1 - Input Existed Phone");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","0936709449");

        log.info("Step 2.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 2.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản đã tồn tại trên hệ thống Hahalolo");

        log.info("Step 3.1 - Input Phone contains phone code(+84)");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","+840936709449");

        log.info("Step 3.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 3.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản không hợp lệ.");
    }

    @Test
    public void TC05_ValidationOFPasswordField(){
        log.info("Step 1 - Input Email");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108",email);

        log.info("Step 2.1 - Do not Input Blank Password");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109","");

        log.info("Step 2.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 2.3 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv109"),"Mật khẩu là bắt buộc.");

        log.info("Step 3.1 - Enter Password <6 chars");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109","12345");

        log.info("Step 3.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 3.3 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv109"),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");

        log.info("Step 4.1 - Enter Password > 128 chars");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109",randomPassword(129));

        log.info("Step 4.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 4.2 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv109"),"Giới hạn tối đa của Mật khẩu là 128 kí tự");

        log.info("Step 5.1 Enter Password contains whitespace");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109","123 456");

        log.info("Step 5.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 5.3 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv109"),"Mật khẩu không chứa kí tự trắng.");
    }

    @Test
    public void TC06_ValidationOFConfirmPasswordField(){
        log.info("Change password in previous step from invalid to valid");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109","123456");

        log.info("Step 1 - Do not input Confirm Password");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword","");

        log.info("Step 1.1 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 1.2 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("repeatPassword"),"Mật khẩu xác nhận là bắt buộc.");

        log.info("Step 2.1 Enter Confirm Password <6 chars");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword","12345");

        log.info("Step 2.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 2.3 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");

        log.info("Step 3.1 Enter ConfirmPassword > 128 chars");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword",randomPassword(129));

        log.info("Step 3.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 3.2 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");

        log.info("Step 4.1 Enter Confirm Password contains whitespace");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword","123 456");

        log.info("Step 4.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 4.3 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("repeatPassword"),"Mật khẩu xác nhận không chứa kí tự trắng.");

        log.info("Step 5.1 Enter Password not same confirm pass");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword","1234567");

        log.info("Step 5.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();

        log.info("Step 5.3 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");
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
        newsfeedLoginPage.refreshPage(driver);

        log.info("Step 1 - Input FirstName");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv104", firstName);

        log.info("Step 2 - Input LastName");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103", lastName);

        log.info("Step 3 - Input email");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108",email.toUpperCase());

        log.info("Step 4 - Input Password");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109","123456");

        log.info("Step 5 - Input ConfirmPass");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword","123456");

        log.info("Step 6 - Click SignUp button and verify email of account display");
        newsfeedLoginPage.clickSignUpButton();
        verifyPage = PageGenerator.createVerifyAccountPage(driver);
        verifyTrue(verifyPage.checkTitlePageVerifyEmail());
        verifyEquals(verifyPage.getAccountDisplayOnRegisterPage(), email);

        log.info("Step 7 - Input verify code and verify account");
        verifyPage.inputVerifyDataOnField(verifyPage.copyVerifyCodeOnMail(email));
        verifyPage.clickVerifyButton();

        log.info("Step 8 - Go to Newsfeed and cancel update info");
        newsfeedPage = PageGenerator.createTabNewsfeed(driver);
        newsfeedPage.setTimeDelay(1);
        newsfeedPage.targetToFirstUpdateInfoPopup(driver);
        updateInfo = PageGenerator.createUpdateInfoPopup(driver);
        updateInfo.clickCancelUpdateNewInfo();

        log.info("Step 9 - Go To Personal about and check email display on WidgetIntro");
        newsfeedPage.clickEditProfile();
        personalOVerViewTab = PageGenerator.getPersonalOverviewTab(driver);
        verifyEquals(personalOVerViewTab.getUserEmailDisplayOnIntroduceWidget(), email);

        log.info("Step 10 - Logout account");
        personalOVerViewTab.clickItemOnSettingMenu(driver,"ic-logout-c");
        newsfeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
    }
    @Test
    public void TC09_RegisterAccountWithEmailContainsMoreThan2Idots() {
        log.info("Step 1 - Input FirstName");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv104", firstName);

        log.info("Step 2 - Input LastName");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103", lastName);

        log.info("Step 3 - Input Email");
        email ="huy.ho.ho"+randomEmail()+"@mailinator.com";
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108",email);

        log.info("Step 4 - Input Password");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109","123456");

        log.info("Step 5 - Input ConfirmPass");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword","123456");

        log.info("Step 6 - Click SignUp button and verify email of account display");
        newsfeedLoginPage.clickSignUpButton();
        verifyPage = PageGenerator.createVerifyAccountPage(driver);
        verifyTrue(verifyPage.checkTitlePageVerifyEmail());
        verifyEquals(verifyPage.getAccountDisplayOnRegisterPage(), email);

        log.info("Step 7 - Input verify code and verify account");
        verifyPage.inputVerifyDataOnField(verifyPage.copyVerifyCodeOnMail(email));
        verifyPage.clickVerifyButton();

        log.info("Step 8 - Go to Newsfeed and cancel update info");
        newsfeedPage = PageGenerator.createTabNewsfeed(driver);
        newsfeedPage.setTimeDelay(1);
        updateInfo= newsfeedPage.targetToFirstUpdateInfoPopup(driver);
        updateInfo.clickCancelUpdateNewInfo();

        log.info("Step 9 - Go To Personal about and check email display on WidgetIntro");
        newsfeedPage.clickEditProfile();
        personalOVerViewTab = PageGenerator.getPersonalOverviewTab(driver);
        verifyEquals(personalOVerViewTab.getUserEmailDisplayOnIntroduceWidget(), email);

        log.info("Step 5.1 - Click Logout");
        personalOVerViewTab.clickItemOnSettingMenu(driver,"ic-logout-c");
        newsfeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
    }
    @Test (enabled = false)
    public void TC10_RegisterAccountWithPhoneHaveAreaCode() {
        log.info("Step 1 - Input FirstName");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv104", firstName);

        log.info("Step 2 - Input LastName");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103", lastName);

        log.info("Step 3 - Input Phone");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","840936709449");

        log.info("Step 4 - Input Password");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109","123456");

        log.info("Step 5 - Input ConfirmPass");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword","123456");

        log.info("Step 6 - Click SignUp button and verify phone of account display");
        newsfeedLoginPage.clickSignUpButton();
        verifyPage = PageGenerator.createVerifyAccountPage(driver);
        verifyTrue(verifyPage.checkTitlePageVerifyPhone());
        verifyEquals(verifyPage.getAccountDisplayOnRegisterPage(), "840936709449");

        log.info("Step 7 - Input verify code and verify account");
        verifyPage.copyVerifyCodeOnMail(verifyPage.copyVerifyCodeOnMail(email));
        verifyPage.clickVerifyButton();

        log.info("Step 8 - Go to Newsfeed and cancel update info");
        newsfeedPage = PageGenerator.createTabNewsfeed(driver);
        newsfeedPage.targetToFirstUpdateInfoPopup(driver);
        updateInfo = PageGenerator.createUpdateInfoPopup(driver);
        updateInfo.clickCancelUpdateNewInfo();

        log.info("Step 9 - Go To Personal about and check email display on WidgetIntro");
        newsfeedPage.clickEditProfile();
        personalOVerViewTab = PageGenerator.getPersonalOverviewTab(driver);
        verifyEquals(personalOVerViewTab.getUserEmailDisplayOnIntroduceWidget(), email);

        log.info("Step 10 - Click Logout");
        personalOVerViewTab.clickItemOnSettingMenu(driver,"ic-logout-c");
        newsfeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
    }
}
