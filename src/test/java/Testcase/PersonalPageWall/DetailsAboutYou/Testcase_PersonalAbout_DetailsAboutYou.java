package Testcase.PersonalPageWall.DetailsAboutYou;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.About.PerAbout_BasicInfoAndContact_PageObject;
import Project.Newsfeed.PersonalWall.About.PerAbout_Overview_Common_PageObjectObject;
import Project.Shared.Login_PageObject;
import Project.Shared.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase_PersonalAbout_DetailsAboutYou extends AbstractTest {
    DataHelper dataHelper;
    WebDriver driver;
    DriverManager driverManager;
    Login_PageObject newsfeedLoginPageObject;
    SignUpPage signUpPage;

    NewsfeedHomepage newsfeedHomepage;
    PerAbout_Overview_Common_PageObjectObject perOverviewPage;
    PerAbout_BasicInfoAndContact_PageObject perBasicInfoAndContactPage;

    String firstName, lastName, email, password, confirmPass;
    String dayBirth, monthBirth, yearBirth, gender, nationality;
    @BeforeTest
    public void precondition(String browserName){
        dataHelper = DataHelper.getData();

        log.info("Precondition step 1 - Create driver browser");
        driverManager = BrowserInitialization.getBrowser(browserName);

        log.info("Precondition step 2 - Go to Newsfeed hahalolo");
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        newsfeedLoginPageObject = PageGeneration.createNewsfeedLoginPage(driver);
        log.info("Precondition step 3 - Check Newsfeed Login display successfully");
        verifyTrue(newsfeedLoginPageObject.checkNewsfeedLoginPageDisplay());
    }

    @Test
    public void Testcase01_Check_Information_When_User_Create_New_Account_Email(){
        log.info("Step 1 - Register new account");
        // Thay đổi ngôn ngữ hệ thống để đồng nhất dữ liệu - Tiếng việt)
        newsfeedLoginPageObject.clickToChangeLanguageToVI();
        signUpPage = PageGeneration.createFormRegister(driver);
        // Đăng ký tài khoản

        firstName = dataHelper.getFirstName();
        lastName = dataHelper.getLastName();
        email = randomVirtualEmail();
        password = "123456";
        confirmPass = "123456";
        signUpPage.signUpWithNewAccountByEmail(firstName, lastName, email, password, confirmPass);
        String fullNameOfUser = getFullName(lastName, firstName);
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);
        log.info("Step 2 - Update new information");
        // Kiểm tra trang newsfeed hiển thị với trường hợp tạo mới thành công
        verifyTrue(newsfeedHomepage.checkNewsfeedDisplayOnFirstTime(driver));
        // Cập nhật thông tin người dùng tại lần đầu tiên đăng nhập
        dayBirth ="12";
        monthBirth = "10";
        yearBirth = "1992";
        gender ="male";
        nationality = "";
        newsfeedHomepage.updateNewInformationOfAccount(dayBirth, monthBirth, yearBirth, gender, nationality);
        String birthday = getBirthdayOnHaLo(dayBirth,monthBirth,yearBirth);
        // Lấy thông tin hiển tên người dùng hiển thị tại My Account
        String fullNameOnMyAccount = newsfeedHomepage.getFullNameDisplayOnMyAccount();
        // Kiểm tra hiển thị tại wigdet MyAccount với tên người dùng dc tạo ra từ dữ liệu form đăng ký
        verifyEquals(fullNameOfUser, fullNameOnMyAccount);
        log.info("Step 3 - Go To Personal About");
        newsfeedHomepage.clickToEditProfile(driver);
        perOverviewPage = PageGeneration.createPersonalOverviewPage(driver);
        // Kiểm tra người dùng vào đúng trang tài khoản của mình
        verifyTrue(perOverviewPage.checkPersonalPageIsDisplay(fullNameOfUser));
        // Lấy các thông tin hiển tại Widget Introduce
        String genderOnPerIntroduce = perOverviewPage.getGenderDisplayOnIntroduceWidget();
        String emailOnPerIntroduce = perOverviewPage.getEmailIsDisplayOnIntroduceWidget();
        String birthdayOnPerIntroduce = perOverviewPage.getBirthdayDisplayOnIntroduceWidget();

        log.info("Step 4 - Go to Personal - Basic info and contact");
        perOverviewPage.clickToTabItemOnAbout("#about_contact");
        perBasicInfoAndContactPage = PageGeneration.createperBasicInfoAndContactPage(driver);
        // Kiểm tra tab Thông tin cơ bản và liên hệ loading thành công;
        // Kiểm tra hiển thị của trang
        perBasicInfoAndContactPage.checkContactAndBasicInfoCaseCreateAccountByEmail();
        log.info("Step 5 - Check Email Information");

    }
}
