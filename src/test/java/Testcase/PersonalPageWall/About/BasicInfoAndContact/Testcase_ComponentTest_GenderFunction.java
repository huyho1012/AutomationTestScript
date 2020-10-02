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
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase_ComponentTest_GenderFunction extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    Login_PageObject newsfeedLoginPage;
    NewsfeedHomepage newsfeedHomepage;
    PerAbout_Overview_PageObject perAboutOverviewTab;
    PerAbout_BasicInfoAndContact_PageObject perAboutBasicInfoTab;


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
    public void UpdateGenderOptionUser(){
        perAboutBasicInfoTab.clickToEditGenderOfUser();
        perAboutBasicInfoTab.chooseGenderType();
        perAboutBasicInfoTab.clickToSaveGenderInfo();

        String genderOnBasicInfo = perAboutBasicInfoTab.getGender();
        verifyEquals(genderOnBasicInfo,"");

        perAboutBasicInfoTab.clickToTabItemOnAbout(driver,"");
        String genderOnWidget = perAboutOverviewTab.getGenderDisplayOnIntroduceWidget();
        verifyEquals(genderOnBasicInfo, genderOnWidget);
    }

}
