package Common.HelperFunction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.Currency;
import java.util.Date;
import java.util.Random;

public abstract class AbstractTest extends AbstractPage {

    protected final Log log;
    protected AbstractTest(){
        log = LogFactory.getLog(getClass());
    }

    protected void closeBrowserAndDriver(WebDriver driver) {
        try {
            // get ra tên của OS và convert qua chữ thường
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            // Khai báo 1 biến command line để thực thi
            String cmd = "";
            if (driver != null) {
                driver.quit();
            }

            if (driver.toString().toLowerCase().contains("chrome")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill chromedriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                }
            } else if (driver.toString().toLowerCase().contains("internetexplorer")) {
                if (osName.toLowerCase().contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            } else if (driver.toString().toLowerCase().contains("firefox")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill geckodriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                }
            }

            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();

            log.info("---------- QUIT BROWSER SUCCESS ----------");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }


    protected int randomNumber(int number){
        Random rd = new Random();
        return rd.nextInt(number);
    }

    protected String randomPassword(int numPassChar) {
        String text = null;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder bd = new StringBuilder(numPassChar);
        for (int i = 0; i < numPassChar; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            text = bd.append(AlphaNumericString.charAt(index)).toString();
        }
        return text;
    }
    protected String randomName(int numPassChar) {
        String text = null;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder bd = new StringBuilder(numPassChar);
        for (int i = 0; i < numPassChar; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            text = bd.append(AlphaNumericString.charAt(index)).toString();
        }
        return text;
    }

    protected String randomVirtualEmail(){
        String userName = "huyho";
        String domainEmail = "@mailinator.com";
        Random random = new Random();
        return userName + random.nextInt(2000000) + domainEmail;
    }
    protected String getEmailWithoutDomain(String email) {
        String[] splits = email.split("@");
        return splits[0];
    }
    protected String getFullName(String firstName, String lastName) {
        return lastName.trim() + " " + firstName.trim();
    }
    protected String getFullName(String firstName,String middleName, String lastName) {
       if(firstName.trim() == ""){
           return middleName.trim() + " " + lastName.trim();
       }
       else if(middleName.trim()==""){
           return firstName.trim() + " " + lastName.trim();
       }
       else if(lastName.trim()==""){
            return firstName.trim() + " " + middleName.trim();
        }
       else
           return firstName.trim() + middleName.trim() + lastName.trim();
    }
    private boolean checkTrue(boolean condition) {
        boolean pass = true;
        try {
            if (condition == true) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    protected boolean verifyTrue(boolean condition) {
        return checkTrue(condition);
    }
    private boolean checkFailed(boolean condition) {
        boolean pass = true;
        try {
            if (condition == false) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    protected boolean verifyFalse(boolean condition) {
        return checkFailed(condition);
    }
    private boolean checkEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            log.info(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    protected boolean verifyEquals(Object actual, Object expected) {
        return checkEquals(actual, expected);
    }



    protected String getCurrentDay() {
        DateTime nowUTC = new DateTime();
        int day = nowUTC.getDayOfMonth();
        if (day < 10) {
            String dayValue = "0" + day;
            return dayValue;
        }
        return day + "";
    }
    protected String getCurrentMonth() {
        DateTime now = new DateTime();
        int month = now.getMonthOfYear();
        if (month < 10) {
            String monthValue = "0" + month;
            return monthValue;
        }
        return month + "";
    }
    protected String getCurrentYear() {
        DateTime now = new DateTime();
        return now.getYear() + "";
    }
    protected String getToday() {
        return getCurrentDay() + "/" + getCurrentMonth() + "/" + getCurrentYear();
    }
    protected String getBirthdayOnHaLo(String day, String month, String year){
        return day+ "-" + month + "-" + year;
    }



    // Xử lý trong chuỗi
    protected String removeAllWhitespace(String data){
        String sentence = data.trim();
        return sentence.replaceAll(" ", "");
    }


    protected String getCurrencySymbol(String currency){
        Currency cur = Currency.getInstance(currency);
        return  cur.getSymbol();
    }

}
