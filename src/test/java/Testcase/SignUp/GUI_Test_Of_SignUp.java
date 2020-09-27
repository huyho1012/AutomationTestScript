package Testcase.SignUp;

import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Shared.Login_PageObject;
import Project.Shared.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GUI_Test_Of_SignUp extends AbstractTest {
    WebDriver driver;
    Login_PageObject newsfeedLoginPageObject;
    SignUpPage signUpPage;
    @Test(enabled = false)
    public void Testcase_Register_01_Check_SignUpForm_With_Eng_Language(){
        newsfeedLoginPageObject.clickToChangeToEng(driver);
        signUpPage = PageGeneration.createFormRegister(driver);
        log.info("Check Title Of SignUp form when");
        verifyEquals(signUpPage.getTitleOfFormSignUp(),"Join Hahalolo Now!");
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
        newsfeedLoginPageObject.clickToChangeLanguageToVI();
        log.info("Check Title Of SignUp form when");
        verifyEquals(signUpPage.getTitleOfFormSignUp(),"Tham gia Hahalolo ngay!");
        log.info("Check placeholder of fields");
        verifyEquals(signUpPage.getPlaceholderOfDynamicField(),"Tên");
        verifyEquals(signUpPage.getPlaceholderOfDynamicField(),"Họ");
        verifyEquals(signUpPage.getPlaceholderOfDynamicField(),"Điện thoại hoặc Email");
        verifyEquals(signUpPage.getPlaceholderOfDynamicField(),"Mật khẩu");
        verifyEquals(signUpPage.getPlaceholderOfDynamicField(),"Mật khẩu xác nhận");
        verifyEquals(signUpPage.getContentOfSignUpButton(),"Đăng ký");
    }
}
