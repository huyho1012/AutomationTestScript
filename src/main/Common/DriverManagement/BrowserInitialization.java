package DriverManagement;

import DriverManagement.BrowserDriver.*;
import DriverManagement.DriverManager;

public class BrowserInitialization {
        public static DriverManager getBrowser(String browserName){
            DriverManager driverManager;
            // Initialization Chrome browser with Chrome Driver
            if ((browserName).equals("Chrome")) {
                driverManager = new ChromeDriverManager();
            }
            //Initialization Firefox browser with Firefox Driver
            else if (browserName.equals("Firefox")) {
                driverManager = new FirefoxDriverManager();
            }
            //Initialization Internet Explore browser with IE Driver
            else if (browserName.equals("Internet Explore")) {
                driverManager = new IEDriverManager();
            }
            //Initialization Coc coc browser with Chrome driver
            else if (browserName.equals("Coc coc")) {
                driverManager = new CocCocDriverManager();
            }
            //Initialization Microsoft Edge browser with Edge driver
            else if (browserName.equals("Edge")) {
                driverManager = new EdgeDriverManager();
            }
            //Initialization Chrome Headless mode with Chrome driver
            else if (browserName.equals("Chrome-headless")) {
                driverManager = new ChromeHeadLessDriverManager();
            }
            //Initialization Firefox Headless mode with Firefox driver
            else if (browserName.equals("Firefox-headless")){
                driverManager = new FirefoxHeadLessDriverManager();
            }
            //Initialization Opera browser with Firefox driver
            return driverManager = new OperaDriverManager();
        }
}
