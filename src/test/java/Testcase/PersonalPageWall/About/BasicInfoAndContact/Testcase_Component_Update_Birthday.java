package Testcase.PersonalPageWall.About.BasicInfoAndContact;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.About.PerAbout_BasicInfoAndContact_PageObject;
import Project.Newsfeed.PersonalWall.About.PerAbout_Overview_PageObject;
import Project.Shared.Login_PageObject;
import Project.Shared.SignUp_PageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase_Component_Update_Birthday extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper dataHelper;
    String birthday;

    Login_PageObject newsfeedLoginPage;
    NewsfeedHomepage newsfeedHomepage;
    PerAbout_Overview_PageObject perAboutOverviewTab;
    PerAbout_BasicInfoAndContact_PageObject perAboutBasicTab;
    SignUp_PageObject signUpPage;

    @Parameters("browser")
    @BeforeClass
    public void preconditionTest(String browserName){
        log.info("Create browser driver");
        driverManager = BrowserInitialization.getBrowser(browserName);
        log.info("Open browser and go to Newsfeed Login page");
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Change language to Vi");
        newsfeedLoginPage.clickToChangeLanguageToVI(driver);

        log.info("Login to newsfeed");
        newsfeedLoginPage.Login(GlobalVariables.USER_ACCOUNT,"123456");
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Newsfeed page display successfully");
        verifyTrue(newsfeedHomepage.checkNewsfeedDisplay());
        log.info("Click to Edit profile");
        newsfeedHomepage.clickToEditProfile();
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);
        log.info("Check Personal About - Overview");
        verifyTrue(perAboutOverviewTab.checkPerAboutOverviewTabIsDisplay());
        String birthdayOnWidget = perAboutOverviewTab.getBirthdayDisplayOnIntroduceWidget();
        log.info("Go to Personal About - Basic info and contact");
        perAboutOverviewTab.clickToTabItemOnAbout(driver,"#about_contact");
        perAboutBasicTab = PageGeneration.createperBasicInfoAndContactPage(driver);
        log.info("Check birthday display");
        verifyEquals(birthdayOnWidget, perAboutBasicTab.getBirthdayDisplay());
    }

    @Test
    public void TC01_Update_Birthday_Of_User(){
        birthday = "12-10-1992";
        log.info("Click To update birhday");
        perAboutBasicTab.clickToEditBirthday();
        log.info("Check Update Birthday form display");
        verifyTrue(perAboutBasicTab.checkFormUpdateBirthdayIsDisplay());

        log.info("Enter birthday");
        perAboutBasicTab.enterDataTOBirhdayField(birthday);

        log.info("Change scope of birthday");
        perAboutBasicTab.changeScopeOfBirthday("Công khai");

        log.info("Click to save change birthday");
        perAboutBasicTab.clickToButtonSaveBirthday();

        log.info("Check birthday change successfully");
        verifyEquals(perAboutBasicTab.getBirthdayDisplay(),"12-10-1992");
    }

    @Test
    public void TC02_Update_Birthday_Of_User_Less_Than_13_Years_Old(){
        birthday = "01-10-2020";
        log.info("Click To update birhday");
        perAboutBasicTab.clickToEditBirthday();
        log.info("Check Update Birthday form display");
        verifyTrue(perAboutBasicTab.checkFormUpdateBirthdayIsDisplay());

        log.info("Enter birthday");
        perAboutBasicTab.enterDataTOBirhdayField(birthday);

        log.info("Change scope of birthday");
        perAboutBasicTab.changeScopeOfBirthday("Công khai");

        log.info("Click to save change birthday");
        perAboutBasicTab.clickToButtonSaveBirthday();

        log.info("Check error Validation");
        verifyEquals(perAboutBasicTab.getErrorMessageOfBirthday(),"");
    }

    @Test
    public void TC03_Update_Birthday_Of_User_Invalid_Birthday(){
        log.info("Click To update birhday");
        perAboutBasicTab.clickToEditBirthday();
        log.info("Check Update Birthday form display");
        verifyTrue(perAboutBasicTab.checkFormUpdateBirthdayIsDisplay());

        log.info("Case blank");
        log.info("Enter birthday");
        perAboutBasicTab.enterDataTOBirhdayField("");
        log.info("Click to save change birthday");
        perAboutBasicTab.clickToButtonSaveBirthday();
        log.info("Check error Validation");
        verifyEquals(perAboutBasicTab.getErrorMessageOfBirthday(),"Ngày không hợp lệ");

        log.info("Case enter all whitespace");
        log.info("Enter birthday");
        perAboutBasicTab.enterDataTOBirhdayField("          ");
        log.info("Click to save change birthday");
        perAboutBasicTab.clickToButtonSaveBirthday();
        log.info("Check error Validation");
        verifyEquals(perAboutBasicTab.getErrorMessageOfBirthday(),"Ngày không hợp lệ");

        log.info("Case enter character");
        log.info("Enter birthday");
        perAboutBasicTab.enterDataTOBirhdayField("fsdfdsfd");
        log.info("Click to save change birthday");
        perAboutBasicTab.clickToButtonSaveBirthday();
        log.info("Check error Validation");
        verifyEquals(perAboutBasicTab.getErrorMessageOfBirthday(),"Ngày không hợp lệ");

        log.info("Case enter special character");
        log.info("Enter birthday");
        perAboutBasicTab.enterDataTOBirhdayField("@@@@@@");
        log.info("Click to save change birthday");
        perAboutBasicTab.clickToButtonSaveBirthday();
        log.info("Check error Validation");
        verifyEquals(perAboutBasicTab.getErrorMessageOfBirthday(),"Ngày không hợp lệ");

        log.info("Case enter HTML code");
        log.info("Enter birthday");
        perAboutBasicTab.enterDataTOBirhdayField(GlobalVariables.HTML_CODE);
        log.info("Click to save change birthday");
        perAboutBasicTab.clickToButtonSaveBirthday();
        log.info("Check error Validation");
        verifyEquals(perAboutBasicTab.getErrorMessageOfBirthday(),"Ngày không hợp lệ");

        log.info("Case enter Script code");
        log.info("Enter birthday");
        perAboutBasicTab.enterDataTOBirhdayField(GlobalVariables.SCRPIT_CODE);
        log.info("Click to save change birthday");
        perAboutBasicTab.clickToButtonSaveBirthday();
        log.info("Check error Validation");
        verifyEquals(perAboutBasicTab.getErrorMessageOfBirthday(),"Ngày không hợp lệ");
    }
}
