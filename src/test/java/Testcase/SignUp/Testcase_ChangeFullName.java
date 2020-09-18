package Testcase.SignUp;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.AccountSetting.GeneralAccountSetting;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Shared.Login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase_ChangeFullName extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    LoginPage newsfeedLoginPage;
    NewsfeedHomepage newsfeedHomepage;
    GeneralAccountSetting generalAccountSetting;
    String htmlCode = "<h>HelloWord</h>";
    String scriptCode = "<script>destroyWebsite();</script>";

    @Parameters("browser")
    @BeforeTest
    public void preconnditionTest(String browserName){
        driverManager = BrowserInitialization.getBrowser(browserName);
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);
        newsfeedLoginPage.Login(driver, "balo_04@mailinator.com","123456");
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);
        newsfeedHomepage.changeLanguageNewsfeedToVI();
        newsfeedHomepage.clickToItemOnSettingMenu(driver,"ic-cog-c");
        generalAccountSetting.checkAccountSettingPageIsDisplay();
        log.info("Step 1 - Click button Edit Full name");
        generalAccountSetting.clickToButtonEditFullName();
        log.info("Step 2 - Check form Update full name display");
        verifyTrue(generalAccountSetting.checkUpdateFullNameFormIsDisplay());
    }

    @Test
    public void Testcase01_Update_Fullname_With_Invalid_FirstName(){
        log.info("Step 1 - FirstName is blank");
        generalAccountSetting.enterDataToFirstNameField(driver,"");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfFirstName(driver),"Tên là bắt buộc.");

        log.info("Step 2 - FirstName contains all white space");
        generalAccountSetting.enterDataToFirstNameField(driver,"   ");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfFirstName(driver),"Tên là bắt buộc.");

        log.info("Step 3 - FirstName contains only number");
        generalAccountSetting.enterDataToFirstNameField(driver,"123456");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfFirstName(driver),"Tên không chứa số.");

        log.info("Step 4 - FirstName is combine of number + characters");
        generalAccountSetting.enterDataToFirstNameField(driver,"Huy23");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfFirstName(driver),"Tên không chứa số.");

        log.info("Step 5 - FirstName contains special characters");
        generalAccountSetting.enterDataToFirstNameField(driver,"Hu@n H@ồng");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfFirstName(driver),"Tên không chứa ký tự đặc biệt.");

        log.info("Step 6 - FirstName contains HTML code");
        generalAccountSetting.enterDataToFirstNameField(driver, htmlCode);
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfFirstName(driver),"Tên không chứa ký tự đặc biệt.");

        log.info("Step 7 - FirstName contains Script code");
        generalAccountSetting.enterDataToFirstNameField(driver, scriptCode);
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfFirstName(driver),"Tên không chứa ký tự đặc biệt.");

        log.info("Step 8 - FirstName contains more than 2 whitespace between 2 word");
        generalAccountSetting.enterDataToFirstNameField(driver, "Huy  Quốc");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfFirstName(driver),"Tên không được nhập quá 2 kí tự trắng.");

        generalAccountSetting.enterDataToFirstNameField(driver, "Quốc Huy");
    }

    @Test
    public void Testcase02_Update_Fullname_With_Invalid_LastName(){
        log.info("Step 1 - Lastname is blank");
        generalAccountSetting.enterDataToLastnameField(driver,"");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfLastName(driver),"Họ là bắt buộc.");

        log.info("Step 2 - Lastname contains all white space");
        generalAccountSetting.enterDataToLastnameField(driver,"   ");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfLastName(driver),"Họ là bắt buộc.");

        log.info("Step 3 - Lastname contains only number");
        generalAccountSetting.enterDataToLastnameField(driver,"123456");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfLastName(driver),"Họ không chứa số.");

        log.info("Step 4 - Lastname combine of number + characters");
        generalAccountSetting.enterDataToLastnameField(driver,"Hồ1");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfLastName(driver),"Họ không chứa số.");

        log.info("Step 5 - Lastname contains special characters");
        generalAccountSetting.enterDataToLastnameField(driver,"H@ Do@n");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfLastName(driver),"Họ không chứa ký tự đặc biệt.");

        log.info("Step 6 - Lastname contains HTML code");
        generalAccountSetting.enterDataToLastnameField(driver, htmlCode);
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfLastName(driver),"Họ không chứa ký tự đặc biệt.");

        log.info("Step 7 - Lastname contains Script code");
        generalAccountSetting.enterDataToLastnameField(driver, scriptCode);
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfLastName(driver),"Họ không chứa ký tự đặc biệt.");

        log.info("Step 8 - FirstName contains more than 2 whitespace between 2 word");
        generalAccountSetting.enterDataToLastnameField(driver, "Hồ  Doãn");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfLastName(driver),"Họ không được nhập quá 2 kí tự trắng.");

        generalAccountSetting.enterDataToLastnameField(driver, "Micheal");
    }
    @Test
    public void Testcase03_Update_Fullname_With_Invalid_Midlename(){
        log.info("Step 1 - Middle name contains Number");
        generalAccountSetting.enterDataToMidnameField(driver,"123456");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfMidName(driver),"Chữ lót không chứa số.");

        log.info("Step 2 - Middle name contains Alpha number");
        generalAccountSetting.enterDataToMidnameField(driver,"Huy12");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfMidName(driver),"Chữ lót không chứa số.");

        log.info("Step 3 - Middle name contains Script Code");
        generalAccountSetting.enterDataToMidnameField(driver, scriptCode);
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfMidName(driver),"Chữ lót không chứa ký tự đặc biệt.");

        log.info("Step 4 - Middle name contains HTML Code");
        generalAccountSetting.enterDataToMidnameField(driver, htmlCode);
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfMidName(driver),"Chữ lót không chứa ký tự đặc biệt.");

        log.info("Step 5 - Middle name contains special character");
        generalAccountSetting.enterDataToMidnameField(driver,"D@ãn");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfMidName(driver),"Chữ lót không chứa ký tự đặc biệt.");

        generalAccountSetting.enterDataToMidnameField(driver, "Quách");

    }
    @Test
    public void Testcase04_Update_Fullname_With_Firstname_Uppercase() {
        log.info("Step 1 - Enter first name");
        generalAccountSetting.enterDataToFirstNameField(driver, "QUÔC HUY");
        log.info("Step 2 - Click to button Save changes");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 3 - Check Confirm password popup is display");
        verifyTrue(generalAccountSetting.checkConfirmPasswordPopupIsDisplay());
        log.info("Step 4 - Enter confirm pass");
        generalAccountSetting.enterDataToPasswordConfirm(driver,"confirmPwd","123456");
        log.info("Step 5 - Click to confirm pass button");
        generalAccountSetting.clickToConfirmButton();
        log.info("Step 6 - Check full name after change");
        verifyEquals(generalAccountSetting.getFullNameIsDisplay(), "");
    }
    @Test
    public void Testcase02_Update_Fullname_With_Firstname_Lowercase() {
        log.info("Step 1 - Click button Edit Full name");
        generalAccountSetting.clickToButtonEditFullName();
        log.info("Step 2 - Check form Update full name display");
        verifyTrue(generalAccountSetting.checkUpdateFullNameFormIsDisplay());
        log.info("Step 3 - Enter first name");
        generalAccountSetting.enterDataToFirstNameField(driver, , "quoc huy");
        log.info("Step 4 - Click to button Save changes");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalAccountSetting.checkConfirmPasswordPopupIsDisplay());
        log.info("Step 6 - Enter confirm pass");
        generalAccountSetting.enterDataToPasswordConfirm(driver, "confirmPwd", "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalAccountSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalAccountSetting.getFullNameIsDisplay(), "");
    }
    @Test
    public void Testcase02_Update_Fullname_With_Firstname_Have_Whitespace_At_First_Position{
        log.info("Step 3 - First Name - Whitespace on first");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"firstName","  Huy");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 4 - First Name - Whitespace on last");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"firstName","Huy  ");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 5 - First Name -  Valid");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"firstName","Huy");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }
    @Test
    public void TC05_LastName_Check_Validation_Positive() {
        log.info("Step 1 - Last Name - Uppercase");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName","HỒ DOÃN");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 2 - Last Name - Lowercase");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName","hồ doãn");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 3 - Last Name - Whitespace on first");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName","  Hồ");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 4 - Last Name - Whitespace on last");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName","Hồ  ");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 5 - Last Name - Valid");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName","Hồ");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");

    }
    @Test
    public void TC05_Middle_Name_Check_Validation_Positive() {
        log.info("Step 1 - Middle Name - Blank");
        accountGeneralSetting.removeValueOnFieldOnFullName(driver,"middleName");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 1 - Middle Name - Whitespace");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName" ,"      ");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 1 - Middle Name - Uppercase");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName","DOÃN QUỐC");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 2 - Middle Name - Lowercase");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName","doãn quốc");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 3 - Middle Name - Whitespace on first");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName","  doãn quốc");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 4 - Middle Name - Whitespace on last");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName","Doãn quốc  ");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 5 - Middle Name - Valid");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName","Doãn Quốc");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }
}
