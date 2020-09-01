package Common.HandleFunction;

import Project.Shared.Login.LoginPage;
import Project.Shared.SingUp.SignUpPage;
import org.openqa.selenium.WebDriver;

public class PageGeneration {

    public static LoginPage createLoginPage(WebDriver driver){
        return new LoginPage(driver);
    }
    public static SignUpPage createFormRegister(WebDriver driver){
        return new SignUpPage(driver);
    }
}
