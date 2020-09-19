package Testcase.AccountSetting;

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
    String firstName, lastName, middleName;

    @Parameters("browser")
    @BeforeTest
    public void preconnditionTest(String browserName) {
        driverManager = BrowserInitialization.getBrowser(browserName);
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);
        newsfeedLoginPage.Login(driver, "balo_04@mailinator.com", "123456");
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);
        newsfeedHomepage.changeLanguageNewsfeedToVI();
        newsfeedHomepage.clickToItemOnSettingMenu(driver, "ic-cog-c");
        generalAccountSetting = PageGeneration.createGeneralAccountSettingPage(driver);
        generalAccountSetting.checkAccountSettingPageIsDisplay(driver);
    }

    @Test
    public void Testcase01_Update_Fullname_With_Invalid_FirstName() {
        log.info("Step 1 - Click button Edit");
        generalAccountSetting.clickToButtonEditFullName(driver);
        log.info("Step 2 - Check form Update full name display");
        verifyTrue(generalAccountSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 3 - FirstName is blank");
        generalAccountSetting.enterDataToFirstNameField(driver, "");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfFirstName(driver), "Tên là bắt buộc.");

        log.info("Step 4 - FirstName contains all white space");
        generalAccountSetting.enterDataToFirstNameField(driver, "   ");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfFirstName(driver), "Tên là bắt buộc.");

        log.info("Step 5 - FirstName contains only number");
        generalAccountSetting.enterDataToFirstNameField(driver, "123456");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfFirstName(driver), "Tên không chứa số.");

        log.info("Step 6 - FirstName is combine of number + characters");
        generalAccountSetting.enterDataToFirstNameField(driver, "Huy23");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfFirstName(driver), "Tên không chứa số.");

        log.info("Step 7 - FirstName contains special characters");
        generalAccountSetting.enterDataToFirstNameField(driver, "Hu@n H@ồng");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfFirstName(driver), "Tên không chứa ký tự đặc biệt.");

        log.info("Step 6 - FirstName contains HTML code");
        generalAccountSetting.enterDataToFirstNameField(driver, htmlCode);
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfFirstName(driver), "Tên không chứa ký tự đặc biệt.");

        log.info("Step 7 - FirstName contains Script code");
        generalAccountSetting.enterDataToFirstNameField(driver, scriptCode);
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfFirstName(driver), "Tên không chứa ký tự đặc biệt.");

        log.info("Step 8 - FirstName contains more than 2 whitespace between 2 word");
        generalAccountSetting.enterDataToFirstNameField(driver, "Huy  Quốc");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfFirstName(driver), "Tên không được nhập quá 2 kí tự trắng.");

        generalAccountSetting.enterDataToFirstNameField(driver, "Quốc Huy");
    }

    @Test
    public void Testcase02_Update_Fullname_With_Invalid_LastName() {
        log.info("Step 1 - Lastname is blank");
        generalAccountSetting.enterDataToLastnameField(driver, "");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfLastName(driver), "Họ là bắt buộc.");

        log.info("Step 2 - Lastname contains all white space");
        generalAccountSetting.enterDataToLastnameField(driver, "   ");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfLastName(driver), "Họ là bắt buộc.");

        log.info("Step 3 - Lastname contains only number");
        generalAccountSetting.enterDataToLastnameField(driver, "123456");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfLastName(driver), "Họ không chứa số.");

        log.info("Step 4 - Lastname combine of number + characters");
        generalAccountSetting.enterDataToLastnameField(driver, "Hồ1");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfLastName(driver), "Họ không chứa số.");

        log.info("Step 5 - Lastname contains special characters");
        generalAccountSetting.enterDataToLastnameField(driver, "H@ Do@n");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfLastName(driver), "Họ không chứa ký tự đặc biệt.");

        log.info("Step 6 - Lastname contains HTML code");
        generalAccountSetting.enterDataToLastnameField(driver, htmlCode);
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfLastName(driver), "Họ không chứa ký tự đặc biệt.");

        log.info("Step 7 - Lastname contains Script code");
        generalAccountSetting.enterDataToLastnameField(driver, scriptCode);
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfLastName(driver), "Họ không chứa ký tự đặc biệt.");

        log.info("Step 8 - FirstName contains more than 2 whitespace between 2 word");
        generalAccountSetting.enterDataToLastnameField(driver, "Hồ  Doãn");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfLastName(driver), "Họ không được nhập quá 2 kí tự trắng.");

        generalAccountSetting.enterDataToLastnameField(driver, "Micheal");
    }

    @Test
    public void Testcase03_Update_Fullname_With_Invalid_Middlename() {
        log.info("Step 1 - Middle name contains Number");
        generalAccountSetting.enterDataToMidnameField(driver, "123456");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfMidName(driver), "Chữ lót không chứa số.");

        log.info("Step 2 - Middle name contains Alpha number");
        generalAccountSetting.enterDataToMidnameField(driver, "Huy12");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfMidName(driver), "Chữ lót không chứa số.");

        log.info("Step 3 - Middle name contains Script Code");
        generalAccountSetting.enterDataToMidnameField(driver, scriptCode);
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfMidName(driver), "Chữ lót không chứa ký tự đặc biệt.");

        log.info("Step 4 - Middle name contains HTML Code");
        generalAccountSetting.enterDataToMidnameField(driver, htmlCode);
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfMidName(driver), "Chữ lót không chứa ký tự đặc biệt.");

        log.info("Step 5 - Middle name contains special character");
        generalAccountSetting.enterDataToMidnameField(driver, "D@ãn");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageValidationOfMidName(driver), "Chữ lót không chứa ký tự đặc biệt.");

        // Close function Update fullname
        generalAccountSetting.clickCancelUpdateFullname(driver);
    }

    @Test
    public void Testcase04_Update_Fullname_With_Firstname_Uppercase() {
        firstName = "QUỐC HUY";
        lastName = "Hồ";
        middleName = "Doãn";

        log.info("Prepair");
        generalAccountSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalAccountSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalAccountSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalAccountSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalAccountSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalAccountSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalAccountSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalAccountSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalAccountSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void Testcase05_Update_Fullname_With_Firstname_Lowercase() {
        firstName = "quốc huy";
        lastName = "Hồ";
        middleName = "Doãn";

        log.info("Prepair");
        generalAccountSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalAccountSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalAccountSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalAccountSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalAccountSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalAccountSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalAccountSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalAccountSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalAccountSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void Testcase06_Update_Fullname_With_Firstname_Have_Whitespace_At_First_Position() {
        firstName = "  Quốc Huy";
        lastName = "Hồ";
        middleName = "Doãn";

        log.info("Prepair");
        generalAccountSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalAccountSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalAccountSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalAccountSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalAccountSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalAccountSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalAccountSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalAccountSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalAccountSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void Testcase07_Update_Fullname_With_Firstname_Have_Whitespace_At_Last_Position() {
        firstName = "Quốc HUy  ";
        lastName = "Hồ";
        middleName = "Doãn";

        log.info("Prepair");
        generalAccountSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalAccountSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalAccountSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalAccountSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalAccountSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalAccountSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalAccountSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalAccountSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalAccountSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void Testcase08_Update_Fullname_With_Lastname_Have_Lowercase() {
        firstName = "Quốc huy";
        lastName = "hồ";
        middleName = "Doãn";

        log.info("Prepair");
        generalAccountSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalAccountSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalAccountSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalAccountSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalAccountSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalAccountSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalAccountSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalAccountSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalAccountSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void Testcase09_Update_Fullname_With_Lastname_Have_Uppercase() {
        firstName = "Quốc Huy";
        lastName = "HỒ";
        middleName = "Doãn";

        log.info("Prepair");
        generalAccountSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalAccountSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalAccountSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalAccountSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalAccountSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalAccountSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalAccountSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalAccountSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalAccountSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void Testcase10_Update_Fullname_With_Lastname_Have_Whitespace_At_First_Position() {
        firstName = "Quốc HUy";
        lastName = "   Hồ";
        middleName = "Doãn";

        log.info("Prepair");
        generalAccountSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalAccountSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalAccountSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalAccountSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalAccountSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalAccountSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalAccountSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalAccountSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalAccountSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void Testcase11Update_Fullname_With_Lastname_Have_Whitespace_At_Last_Position() {
        firstName = "Quốc HUy ";
        lastName = "Hồ   ";
        middleName = "Doãn";

        log.info("Prepair");
        generalAccountSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalAccountSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalAccountSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalAccountSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalAccountSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalAccountSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalAccountSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalAccountSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalAccountSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }
    @Test
    public void Testcase12_Update_Fullname_With_MiddleName_Have_Lowercase () {
        firstName = "Quốc HUy ";
        lastName = "Hồ";
        middleName = "doãn";

        log.info("Prepair");
        generalAccountSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalAccountSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalAccountSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalAccountSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalAccountSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalAccountSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalAccountSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalAccountSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalAccountSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }
    @Test
    public void Testcase13_Update_Fullname_With_MiddleNam_Have_Uppercase () {
        firstName = "Quốc HUy ";
        lastName = "Hồ";
        middleName = "DOÃN";

        log.info("Prepair");
        generalAccountSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalAccountSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalAccountSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalAccountSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalAccountSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalAccountSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalAccountSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalAccountSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalAccountSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }
    @Test
    public void Testcase14_Update_Fullname_With_MiddleName_Have_Whitespace_At_First_Position () {
            firstName = "Quốc Huy";
            lastName = "Hồ";
            middleName = " Doãn";

            log.info("Prepair");
            generalAccountSetting.clickToButtonEditFullName(driver);
            verifyTrue(generalAccountSetting.checkUpdateFullNameFormIsDisplay(driver));

            log.info("Step 1 - Enter first name");
            generalAccountSetting.enterDataToFirstNameField(driver, firstName);
            log.info("Step 2 - Enter middle name");
            generalAccountSetting.enterDataToMidnameField(driver, middleName);
            log.info("Step 3 - Enter last name");
            generalAccountSetting.enterDataToLastnameField(driver, lastName);
            log.info("Step 4 - Click to button Save changes");
            generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
            log.info("Step 5 - Check Confirm password popup is display");
            verifyTrue(generalAccountSetting.checkConfirmPasswordPopupIsDisplay(driver));
            log.info("Step 6 - Enter confirm pass");
            generalAccountSetting.enterDataToPasswordConfirm(driver, "123456");
            log.info("Step 7 - Click to confirm pass button");
            generalAccountSetting.clickToConfirmButton();
            log.info("Step 8 - Check full name after change");
            verifyEquals(generalAccountSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }
    @Test
    public void Testcase15_Update_Fullname_With_MiddleName_Have_Whitespace_At_Last_Position () {
        firstName = "Quốc Huy";
        lastName = "Hồ";
        middleName = "Doãn ";

        log.info("Prepair");
        generalAccountSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalAccountSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalAccountSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalAccountSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalAccountSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalAccountSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalAccountSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalAccountSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalAccountSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }
    @Test
    public void Testcase15_Update_Fullname_With_Invalid_Pass () {
        generalAccountSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalAccountSetting.checkUpdateFullNameFormIsDisplay(driver));
        generalAccountSetting.enterDataToMidnameField(driver, "Huy");
        generalAccountSetting.enterDataToMidnameField(driver, "Quốc");
        generalAccountSetting.enterDataToLastnameField(driver, "Hồ Doãn");
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyTrue(generalAccountSetting.checkConfirmPasswordPopupIsDisplay(driver));

        log.info("Step 1 - Wrong pass");
        generalAccountSetting.enterDataToPasswordConfirm(driver, "1123456");
        generalAccountSetting.clickToConfirmButton();
        verifyEquals(generalAccountSetting.getErrMessageValidationOfConfirmPass(driver), "Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác");

        log.info("Step 2 - Pasword blank");
        generalAccountSetting.enterDataToPasswordConfirm(driver, "");
        generalAccountSetting.clickToConfirmButton();
        verifyEquals(generalAccountSetting.getErrMessageValidationOfConfirmPass(driver), "Mật khẩu là bắt buộc.");

        log.info("Step 3 - Pasword contains all whitespace");
        generalAccountSetting.enterDataToPasswordConfirm(driver, "    ");
        generalAccountSetting.clickToConfirmButton();
        verifyEquals(generalAccountSetting.getErrMessageValidationOfConfirmPass(driver), "Mật khẩu là bắt buộc.");

        log.info("Step 4 - Pasword contains less than 6 chars");
        generalAccountSetting.enterDataToPasswordConfirm(driver, "12345");
        generalAccountSetting.clickToConfirmButton();
        verifyEquals(generalAccountSetting.getErrMessageValidationOfConfirmPass(driver), "Giới hạn tối thiểu của Mật khẩu là 6 kí tự");

        log.info("Step 5 - Pasword contains more than 128 chars");
        generalAccountSetting.enterDataToPasswordConfirm(driver, randomPassword(129));
        generalAccountSetting.clickToConfirmButton();
        verifyEquals(generalAccountSetting.getErrMessageValidationOfConfirmPass(driver), "");

        log.info("Step 6 - Pasword contains white space");
        generalAccountSetting.enterDataToPasswordConfirm(driver, "123 456");
        generalAccountSetting.clickToConfirmButton();
        verifyEquals(generalAccountSetting.getErrMessageValidationOfConfirmPass(driver), "Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác");

        log.info("Step 7 - Pasword contains script");
        generalAccountSetting.enterDataToPasswordConfirm(driver, scriptCode);
        generalAccountSetting.clickToConfirmButton();
        verifyEquals(generalAccountSetting.getErrMessageValidationOfConfirmPass(driver), "Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác");

        log.info("Step 7 - Pasword contains HTML");
        generalAccountSetting.enterDataToPasswordConfirm(driver, htmlCode);
        generalAccountSetting.clickToConfirmButton();
        verifyEquals(generalAccountSetting.getErrMessageValidationOfConfirmPass(driver), "Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác");

        generalAccountSetting.clickButtonToCancelSaveChangeFullName(driver);
    }
    @Test
    public void Testcase15_Update_Fullname_With_TOTAL_FULL_NAME_GREATER_THAN_75_CHARS () {
        firstName = randomName(100);
        lastName = "Hồ";
        middleName = "Doãn ";

        generalAccountSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalAccountSetting.checkUpdateFullNameFormIsDisplay(driver));
        generalAccountSetting.enterDataToFirstNameField(driver, firstName);
        generalAccountSetting.enterDataToMidnameField(driver, middleName);
        generalAccountSetting.enterDataToLastnameField(driver, lastName);
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageOfChangeFullName(driver),"Giới hạn tối đa của Họ và tên là 75 kí tự");

    }

    @Test
    public void Testcase15_Update_Fullname_With_TOTAL_FULL_NAME_GREATER_THAN_5_WORDS () {
        firstName = "Quốc Huy Doãn";
        lastName = "Hồ";
        middleName = "Doãn ";

        generalAccountSetting.enterDataToFirstNameField(driver, firstName);
        generalAccountSetting.enterDataToMidnameField(driver, middleName);
        generalAccountSetting.enterDataToLastnameField(driver, lastName);
        generalAccountSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalAccountSetting.getErrMessageOfChangeFullName(driver),"Họ và tên không lớn hơn 5 từ.̣");
    }
}

