package Testcase.SignUp;

import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Shared.Login_PageObject;
import Project.Shared.SignUp_PageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GUI_Test_Of_SignUp extends AbstractTest {
    WebDriver driver;
    Login_PageObject newsfeedLoginPageObject;
    SignUp_PageObject signUpPageObject;
    @Test(enabled = false)
    public void Testcase_Register_01_Check_SignUpForm_With_Eng_Language(){
        newsfeedLoginPageObject.clickToChangeToEng(driver);
        signUpPageObject = PageGeneration.createFormRegister(driver);
        log.info("Check Title Of SignUp form when");
        verifyEquals(signUpPageObject.getTitleOfFormSignUp(),"Join Hahalolo Now!");
        log.info("Check placeholder of fields");
        verifyEquals(signUpPageObject.getPlaceholderOfDynamicField(),"First name");
        verifyEquals(signUpPageObject.getPlaceholderOfDynamicField(),"Last name");
        verifyEquals(signUpPageObject.getPlaceholderOfDynamicField(),"Phone number or Email");
        verifyEquals(signUpPageObject.getPlaceholderOfDynamicField(),"Password");
        verifyEquals(signUpPageObject.getPlaceholderOfDynamicField(),"Confirm Password");
        verifyEquals(signUpPageObject.getContentOfSignUpButton(),"Sign Up");
    }
    @Test(enabled = false)
    public void Testcase_Register_02_Check_SignUpForm_With_VI_Language(){
        newsfeedLoginPageObject.clickToChangeLanguageToVI(driver);
        log.info("Check Title Of SignUp form when");
        verifyEquals(signUpPageObject.getTitleOfFormSignUp(),"Tham gia Hahalolo ngay!");
        log.info("Check placeholder of fields");
        verifyEquals(signUpPageObject.getPlaceholderOfDynamicField(),"Tên");
        verifyEquals(signUpPageObject.getPlaceholderOfDynamicField(),"Họ");
        verifyEquals(signUpPageObject.getPlaceholderOfDynamicField(),"Điện thoại hoặc Email");
        verifyEquals(signUpPageObject.getPlaceholderOfDynamicField(),"Mật khẩu");
        verifyEquals(signUpPageObject.getPlaceholderOfDynamicField(),"Mật khẩu xác nhận");
        verifyEquals(signUpPageObject.getContentOfSignUpButton(),"Đăng ký");
    }
}
