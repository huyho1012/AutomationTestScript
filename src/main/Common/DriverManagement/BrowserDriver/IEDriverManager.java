package Common.DriverManagement.BrowserDriver;

import Common.DriverManagement.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IEDriverManager extends DriverManager {
    @Override
    protected void createDriver() {
        WebDriverManager.iedriver().arch32().setup();
    }
}
