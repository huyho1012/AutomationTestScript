package Testcase.PersonalPageWall.About.BasicInfoAndContact;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
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

public class Testcase_ComponentTest_GenderFunction extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    Login_PageObject newsfeedLoginPage;
    NewsfeedHomepage newsfeedHomepage;
    SignUp_PageObject signUpPage;
    PerAbout_Overview_PageObject perAboutOverviewTab;
    PerAbout_BasicInfoAndContact_PageObject perAboutBasicInfoTab;
    String genderChange;
    String genderOnIntroduce;
    String genderOnBasicInfo;
    String gender;


    @Parameters("browser")
    @BeforeClass
    public void preconditionStep(String browserName){
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
        String genderOnWidget = perAboutOverviewTab.getGenderDisplayOnIntroduceWidget();
        log.info("Go to personal about - Basic and Contact Info");
        perAboutOverviewTab.clickToTabItemOnAbout(driver,"");
        perAboutBasicInfoTab = PageGeneration.createperBasicInfoAndContactPage(driver);

        log.info("Check Basic And Contact Info display");
        verifyTrue(perAboutBasicInfoTab.checkContactAndBasicInfoTabIsDisplay());
        verifyEquals(perAboutBasicInfoTab.getGender(), genderOnWidget);
    }

    @Test
    public void TC01_Update_Gender_Type_Male(){
        genderChange = "Nam";
        log.info("Click to edit gender");
        perAboutBasicInfoTab.clickToEditGenderOfUser();
        log.info("Choose gender type is Male");
        perAboutBasicInfoTab.chooseGenderType(genderChange);
        log.info("Click to save gender");
        perAboutBasicInfoTab.clickToSaveGenderInfo();

        log.info("Verify gender display after changing is correctly");
        String genderOnBasicInfo = perAboutBasicInfoTab.getGender();
        verifyEquals(genderOnBasicInfo,"");

        log.info("Go back to Personal About - Overview");
        perAboutBasicInfoTab.clickToTabItemOnAbout(driver,"");

        log.info("Verify again new gender updated with gender display on introduce Widget");
        String genderOnWidget = perAboutOverviewTab.getGenderDisplayOnIntroduceWidget();
        verifyEquals(genderOnBasicInfo, genderOnWidget);
    }

    @Test
    public void TC02_Update_Gender_Type_FeMale(){
        genderChange = "Nữ";
        log.info("Click to edit gender");
        perAboutBasicInfoTab.clickToEditGenderOfUser();
        log.info("Choose gender type is Female");
        perAboutBasicInfoTab.chooseGenderType(genderChange);
        log.info("Click to save gender");
        perAboutBasicInfoTab.clickToSaveGenderInfo();

        log.info("Verify gender display after changing is Female");
        String genderOnBasicInfo = perAboutBasicInfoTab.getGender();
        verifyEquals(genderOnBasicInfo,"");

        log.info("Go back to Personal About - Overview");
        perAboutBasicInfoTab.clickToTabItemOnAbout(driver,"");

        log.info("Verify again new gender updated with gender display on introduce Widget");
        String genderOnWidget = perAboutOverviewTab.getGenderDisplayOnIntroduceWidget();
        verifyEquals(genderOnBasicInfo, genderOnWidget);
    }

    @Test
    public void TC03_Update_Gender_Type_Other(){
        genderChange = "Nữ";
        log.info("Click to edit gender");
        perAboutBasicInfoTab.clickToEditGenderOfUser();
        log.info("Choose gender type is Female");
        perAboutBasicInfoTab.chooseGenderType(genderChange);
        log.info("Click to save gender");
        perAboutBasicInfoTab.clickToSaveGenderInfo();

        log.info("Verify gender display after changing is Other");
        String genderOnBasicInfo = perAboutBasicInfoTab.getGender();
        verifyEquals(genderOnBasicInfo,"");

        log.info("Go back to Personal About - Overview");
        perAboutBasicInfoTab.clickToTabItemOnAbout(driver,"");

        log.info("Verify again new gender updated with gender display on introduce Widget");
        String genderOnWidget = perAboutOverviewTab.getGenderDisplayOnIntroduceWidget();
        verifyEquals(genderOnBasicInfo, genderOnWidget);

        log.info("Logout");
        perAboutOverviewTab.clickToItemOnSettingMenu(driver,"");
        signUpPage = PageGeneration.createFormRegister(driver);
    }

    @Test
    public void TC04_Check_Update_Gender_With_New_Account(){
        log.info("Sign Up new account");
        gender = "";
        signUpPage.signUpWithNewAccountByEmail("","","","","");
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);
        log.info("Verify register successfully");
        verifyTrue(newsfeedHomepage.checkNewsfeedDisplayOnFirstTime());
        log.info("Update information");
        newsfeedHomepage. updateNewInformationOfAccount("","","",gender,"");
        log.info("Go to personal about - overview");
        newsfeedHomepage.clickToEditProfile();
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);
        log.info("Go To personal about - Basic info and contact");
        perAboutOverviewTab.clickToTabItemOnAbout(driver,"");
        perAboutBasicInfoTab = PageGeneration.createperBasicInfoAndContactPage(driver);
        log.info("Verify default image of avatar with type gender = Male");
        verifyEquals(perAboutBasicInfoTab.getImageURLOfAvatar(driver),"");
        log.info("Verify gender display on Basic info tab is Male");
        verifyEquals(perAboutBasicInfoTab.getGender(),gender);
        log.info("Click Edit Gender");
        perAboutBasicInfoTab.clickToEditGenderOfUser();
        log.info("Choose gender = Other");
        gender = "";
        perAboutBasicInfoTab.chooseGenderType(gender);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveGenderInfo();
        log.info("Verify gender display on Basic Info and Contact is Other");
        verifyEquals(perAboutBasicInfoTab.getGender(),gender);
        log.info("Back to Overview tab");
        perAboutBasicInfoTab.clickToTabItemOnAbout(driver,"");
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);
        log.info("Verify gender display on Introduce widget is Other");
        verifyEquals(perAboutOverviewTab.getGenderDisplayOnIntroduceWidget(),gender);
        log.info("Verify Avatar display with correct gender is Other");
        verifyEquals(perAboutOverviewTab.getImageURLOfAvatar(driver),"");
        log.info("Go To personal about - Basic info and contact");
        perAboutOverviewTab.clickToTabItemOnAbout(driver,"");
        perAboutBasicInfoTab = PageGeneration.createperBasicInfoAndContactPage(driver);
        log.info("Click Edit Gender");
        perAboutBasicInfoTab.clickToEditGenderOfUser();
        log.info("Choose gender = Female");
        gender = "";
        perAboutBasicInfoTab.chooseGenderType(gender);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveGenderInfo();
        log.info("Back to Overview tab");
        perAboutBasicInfoTab.clickToTabItemOnAbout(driver,"");
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);
        log.info("Verify gender display on Introduce widget is Female");
        verifyEquals(perAboutOverviewTab.getGenderDisplayOnIntroduceWidget(),gender);
        log.info("Verify Avatar display with correct gender is Female");
        verifyEquals(perAboutOverviewTab.getImageURLOfAvatar(driver),"");
    }

}
