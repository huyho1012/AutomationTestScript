package Testcase.PersonalPageWall;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.About.PerAbout_DetailsAboutYou_PageObject;
import Project.Newsfeed.PersonalWall.About.PerAbout_Overview_PageObject;
import Project.Shared.Login.LoginPage;
import Project.Shared.SingUp.SignUpPage;
import org.openqa.selenium.WebDriver;

public class ComponentTestcase extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;

    String emailUser, passwordUser;
    LoginPage newsfeedLoginPage;
    NewsfeedHomepage newsfeedHomepage;

    PerAbout_Overview_PageObject perOverviewTab;
    PerAbout_DetailsAboutYou_PageObject perDetailAboutTab;
    SignUpPage signUpPage;


    public void preconditionStep(String browserName){
        emailUser = "balo_04@mailinator.com";
        passwordUser = "123456";
        log.info("Precondition Step 1 - Create browser driver");
        driverManager = BrowserInitialization.getBrowser(browserName);

        log.info("Precondition Step 2 - Go to Newsfeed Login");
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);

        newsfeedLoginPage.clickToChangeLanguageToVI();
        log.info("Preconditon Step 3 - Login newsfeed");
        newsfeedLoginPage.Login(emailUser, passwordUser);
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);
    }

    public void goToPersonalAboutTabDetailsAboutYou(){
        log.info("Step 1 - GO to Personal wall - About - Overview");
        newsfeedHomepage.clickToEditProfile(driver);
        perOverviewTab = PageGeneration.createPersonalOverviewPage(driver);

        log.info("Step 1 - GO to Personal wall - About");
        perOverviewTab.clickToTabItemOnAbout("");
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
