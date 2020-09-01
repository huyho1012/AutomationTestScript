package Testcase;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.HandleFunction.AbstractTest;
import Common.HandleFunction.PageGeneration;
import Project.Shared.Login.LoginPage;
import Project.Shared.SingUp.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestRegister extends AbstractTest {
    DriverManager driverManager;
    WebDriver driver;
    LoginPage loginPage;
    @Parameters("browser")
    @BeforeClass
    public void preconditionStep(String browserName) {
        driverManager = BrowserInitialization.getBrowser(browserName);
        driver = driverManager.getDriver("https://test-newsfeed.hahalolo.com/auth/signin");
        loginPage = PageGeneration.createLoginPage(driver);
    }
    @Test
    public void Test(){
        loginPage.enterUserNameToLogin(driver,"balo_04@mailinator.com");
        loginPage.enterPasswordToLogin(driver,"123456");
        loginPage.clickToLoginButton(driver);
    }
}
