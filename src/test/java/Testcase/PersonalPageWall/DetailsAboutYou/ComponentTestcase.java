package Testcase.PersonalPageWall.DetailsAboutYou;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.About.PerAbout_DetailsAboutYou_PageObject;
import Project.Newsfeed.PersonalWall.About.PerAbout_Overview_PageObject;
import Project.Shared.Login_PageObject;
import Project.Shared.SignUp_PageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ComponentTestcase extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;

    // Khai báo param
    String emailUser, passwordUser;

    // Khai báo Page Object
    Login_PageObject newsfeedLoginPageObject;
    NewsfeedHomepage newsfeedHomepage;
    PerAbout_Overview_PageObject perOverviewTab;
    PerAbout_DetailsAboutYou_PageObject perDetailAboutTab;
    SignUp_PageObject signUpPageObject;

    @Test
    public void preconditionStep(String browserName){
        emailUser = "balo_04@mailinator.com";
        passwordUser = "123456";

        log.info("Precondition Step 1 - Create browser driver");
        driverManager = BrowserInitialization.getBrowser(browserName);

        log.info("Precondition Step 2 - Go to Newsfeed Login");
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        newsfeedLoginPageObject = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Precondition Step 3 - Change language system to VI");
        newsfeedLoginPageObject.clickToChangeLanguageToVI(driver);

        log.info("Preconditon Step 4 - Login newsfeed");
        newsfeedLoginPageObject.Login(emailUser, passwordUser);
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);
    }

    public void goToPersonalAboutTabDetailsAboutYou(){
        log.info("Step 1 - GO to Personal wall - About - Overview");
        newsfeedHomepage.clickToEditProfile();
        perOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("Step 1 - GO to Personal wall - About");
        perOverviewTab.clickToTabItemOnAbout(driver,"");
        perDetailAboutTab = PageGeneration.createPersonalDetailsAboutYouTab(driver);
    }
    public void Testcase01_Add_New_Introduce_With_Invalid_Info(){
        perDetailAboutTab.clickToButtonAddNewIntroduce();


        log.info("Step 1 - GO to Personal wall - About");
        perDetailAboutTab.enterDataToFavoriteQuoteField("");


    }

    public void Testcase01_Add_New_Address_With_Invalid_City(){

    }
}
