package Testcase.CommunitySite;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.GlobalVariables;

import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Shared.Login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Community extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;

    LoginPage newsfeedLogin;
    NewsfeedHomepage newsfeedHomepage;
    @Parameters({"browser"})
    @BeforeTest
    public void preconditionTest(String browserName) {
        log.info("Precondition - Step 1. Create Browser Driver ");
        driverManager = BrowserInitialization.getBrowser(browserName);
        log.info("Precondition - Step 2. Open browser and go to Newsfeed login");
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);
        log.info("Precondition - Step 3. Change system language To Vi");
        newsfeedLogin.clickToChangeLanguageToVI(driver);
        newsfeedLogin.Login(driver,"balo_04@mailinator.com","123456");
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);
    }
    @Test
    public void Test() {
        log.info("Precondition - Step 1. Create Browser Driver ");
       newsfeedHomepage.checkNewsfeedDisplay();
       newsfeedHomepage.goToSite(driver);
    }
}
