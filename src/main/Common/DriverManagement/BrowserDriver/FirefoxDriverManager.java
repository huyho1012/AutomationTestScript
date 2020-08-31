package DriverManagement.BrowserDriver;

import DriverManagement.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {
    @Override
    protected void createDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
}
