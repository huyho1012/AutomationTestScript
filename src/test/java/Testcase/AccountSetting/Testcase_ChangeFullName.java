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
    GeneralAccountSetting generalSetting;
    String htmlCode = "<h>HelloWord</h>";
    String scriptCode = "<script>destroyWebsite();</script>";
    String firstName, lastName, middleName;

    @Parameters("browser")
    @BeforeTest
    public void preconnditionTest(String browserName) {
        driverManager = BrowserInitialization.getBrowser(browserName);
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);
//        newsfeedLoginPage.Login(driver, "balo_04@mailinator.com", "123456");
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);
        newsfeedHomepage.changeLanguageNewsfeedToVI();
        newsfeedHomepage.clickToItemOnSettingMenu(driver, "ic-cog-c");
        generalSetting = PageGeneration.createGeneralAccountSettingPage(driver);
    }

    @Test
    public void Testcase01_Update_Fullname_With_Invalid_FirstName() {
        log.info("Step 1 - Click button Edit");
        generalSetting.clickToButtonEditFullName(driver);
        log.info("Step 2 - Check form Update full name display");
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 3 - FirstName is blank");
        generalSetting.enterDataToFirstNameField(driver, "");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfFirstName(driver), "Tên là bắt buộc.");

        log.info("Step 4 - FirstName contains all white space");
        generalSetting.enterDataToFirstNameField(driver, "   ");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfFirstName(driver), "Tên là bắt buộc.");

        log.info("Step 5 - FirstName contains only number");
        generalSetting.enterDataToFirstNameField(driver, "123456");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfFirstName(driver), "Tên không chứa số.");

        log.info("Step 6 - FirstName is combine of number + characters");
        generalSetting.enterDataToFirstNameField(driver, "Huy23");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfFirstName(driver), "Tên không chứa số.");

        log.info("Step 7 - FirstName contains special characters");
        generalSetting.enterDataToFirstNameField(driver, "Hu@n H@ồng");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfFirstName(driver), "Tên không chứa ký tự đặc biệt.");

        log.info("Step 6 - FirstName contains HTML code");
        generalSetting.enterDataToFirstNameField(driver, htmlCode);
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfFirstName(driver), "Tên không chứa ký tự đặc biệt.");

        log.info("Step 7 - FirstName contains Script code");
        generalSetting.enterDataToFirstNameField(driver, scriptCode);
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfFirstName(driver), "Tên không chứa ký tự đặc biệt.");

        log.info("Step 8 - FirstName contains more than 2 whitespace between 2 word");
        generalSetting.enterDataToFirstNameField(driver, "Huy  Quốc");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfFirstName(driver), "Tên không được nhập quá 2 kí tự trắng.");

        generalSetting.enterDataToFirstNameField(driver, "Quốc Huy");
    }

    @Test
    public void Testcase02_Update_Fullname_With_Invalid_LastName() {
        log.info("Step 1 - Lastname is blank");
        generalSetting.enterDataToLastnameField(driver, "");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfLastName(driver), "Họ là bắt buộc.");

        log.info("Step 2 - Lastname contains all white space");
        generalSetting.enterDataToLastnameField(driver, "   ");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfLastName(driver), "Họ là bắt buộc.");

        log.info("Step 3 - Lastname contains only number");
        generalSetting.enterDataToLastnameField(driver, "123456");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfLastName(driver), "Họ không chứa số.");

        log.info("Step 4 - Lastname combine of number + characters");
        generalSetting.enterDataToLastnameField(driver, "Hồ1");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfLastName(driver), "Họ không chứa số.");

        log.info("Step 5 - Lastname contains special characters");
        generalSetting.enterDataToLastnameField(driver, "H@ Do@n");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfLastName(driver), "Họ không chứa ký tự đặc biệt.");

        log.info("Step 6 - Lastname contains HTML code");
        generalSetting.enterDataToLastnameField(driver, htmlCode);
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfLastName(driver), "Họ không chứa ký tự đặc biệt.");

        log.info("Step 7 - Lastname contains Script code");
        generalSetting.enterDataToLastnameField(driver, scriptCode);
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfLastName(driver), "Họ không chứa ký tự đặc biệt.");

        log.info("Step 8 - FirstName contains more than 2 whitespace between 2 word");
        generalSetting.enterDataToLastnameField(driver, "Hồ  Doãn");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfLastName(driver), "Họ không được nhập quá 2 kí tự trắng.");

        generalSetting.enterDataToLastnameField(driver, "Micheal");
    }

    @Test
    public void Testcase03_Update_Fullname_With_Invalid_Middlename() {
        log.info("Step 1 - Middle name contains Number");
        generalSetting.enterDataToMidnameField(driver, "123456");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfMidName(driver), "Chữ lót không chứa số.");

        log.info("Step 2 - Middle name contains Alpha number");
        generalSetting.enterDataToMidnameField(driver, "Huy12");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfMidName(driver), "Chữ lót không chứa số.");

        log.info("Step 3 - Middle name contains Script Code");
        generalSetting.enterDataToMidnameField(driver, scriptCode);
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfMidName(driver), "Chữ lót không chứa ký tự đặc biệt.");

        log.info("Step 4 - Middle name contains HTML Code");
        generalSetting.enterDataToMidnameField(driver, htmlCode);
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfMidName(driver), "Chữ lót không chứa ký tự đặc biệt.");

        log.info("Step 5 - Middle name contains special character");
        generalSetting.enterDataToMidnameField(driver, "D@ãn");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageValidationOfMidName(driver), "Chữ lót không chứa ký tự đặc biệt.");

        // Close function Update fullname
        generalSetting.clickCancelUpdateFullname(driver);
    }

    @Test
    public void Testcase04_Update_Fullname_With_Firstname_Uppercase() {
        firstName = "QUỐC HUY";
        lastName = "Hồ";
        middleName = "Doãn";

        log.info("Prepair");
        generalSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void Testcase05_Update_Fullname_With_Firstname_Lowercase() {
        firstName = "quốc huy";
        lastName = "Hồ";
        middleName = "Doãn";

        log.info("Prepair");
        generalSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void Testcase06_Update_Fullname_With_Firstname_Have_Whitespace_At_First_Position() {
        firstName = "  Quốc Huy";
        lastName = "Hồ";
        middleName = "Doãn";

        log.info("Prepair");
        generalSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void Testcase07_Update_Fullname_With_Firstname_Have_Whitespace_At_Last_Position() {
        firstName = "Quốc HUy  ";
        lastName = "Hồ";
        middleName = "Doãn";

        log.info("Prepair");
        generalSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void Testcase08_Update_Fullname_With_Lastname_Have_Lowercase() {
        firstName = "Quốc huy";
        lastName = "hồ";
        middleName = "Doãn";

        log.info("Prepair");
        generalSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void Testcase09_Update_Fullname_With_Lastname_Have_Uppercase() {
        firstName = "Quốc Huy";
        lastName = "HỒ";
        middleName = "Doãn";

        log.info("Prepair");
        generalSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void Testcase10_Update_Fullname_With_Lastname_Have_Whitespace_At_First_Position() {
        firstName = "Quốc HUy";
        lastName = "   Hồ";
        middleName = "Doãn";

        log.info("Prepair");
        generalSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void Testcase11Update_Fullname_With_Lastname_Have_Whitespace_At_Last_Position() {
        firstName = "Quốc HUy ";
        lastName = "Hồ   ";
        middleName = "Doãn";

        log.info("Prepair");
        generalSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }
    @Test
    public void Testcase12_Update_Fullname_With_MiddleName_Have_Lowercase () {
        firstName = "Quốc HUy ";
        lastName = "Hồ";
        middleName = "doãn";

        log.info("Prepair");
        generalSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }
    @Test
    public void Testcase13_Update_Fullname_With_MiddleNam_Have_Uppercase () {
        firstName = "Quốc HUy ";
        lastName = "Hồ";
        middleName = "DOÃN";

        log.info("Prepair");
        generalSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }
    @Test
    public void Testcase14_Update_Fullname_With_MiddleName_Have_Whitespace_At_First_Position () {
            firstName = "Quốc Huy";
            lastName = "Hồ";
            middleName = " Doãn";

            log.info("Prepair");
            generalSetting.clickToButtonEditFullName(driver);
            verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay(driver));

            log.info("Step 1 - Enter first name");
            generalSetting.enterDataToFirstNameField(driver, firstName);
            log.info("Step 2 - Enter middle name");
            generalSetting.enterDataToMidnameField(driver, middleName);
            log.info("Step 3 - Enter last name");
            generalSetting.enterDataToLastnameField(driver, lastName);
            log.info("Step 4 - Click to button Save changes");
            generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
            log.info("Step 5 - Check Confirm password popup is display");
            verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplay(driver));
            log.info("Step 6 - Enter confirm pass");
            generalSetting.enterDataToPasswordConfirm(driver, "123456");
            log.info("Step 7 - Click to confirm pass button");
            generalSetting.clickToConfirmButton();
            log.info("Step 8 - Check full name after change");
            verifyEquals(generalSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }
    @Test
    public void Testcase15_Update_Fullname_With_MiddleName_Have_Whitespace_At_Last_Position () {
        firstName = "Quốc Huy";
        lastName = "Hồ";
        middleName = "Doãn ";

        log.info("Prepair");
        generalSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay(driver));

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(driver, firstName);
        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(driver, middleName);
        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(driver, lastName);
        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplay(driver));
        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm(driver, "123456");
        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();
        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplay(driver), getFullName(firstName, middleName, lastName));
    }
    @Test
    public void Testcase15_Update_Fullname_With_Invalid_Pass () {
        generalSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay(driver));
        generalSetting.enterDataToMidnameField(driver, "Huy");
        generalSetting.enterDataToMidnameField(driver, "Quốc");
        generalSetting.enterDataToLastnameField(driver, "Hồ Doãn");
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplay(driver));

        log.info("Step 1 - Wrong pass");
        generalSetting.enterDataToPasswordConfirm(driver, "1123456");
        generalSetting.clickToConfirmButton();
        verifyEquals(generalSetting.getErrMessageValidationOfConfirmPass(driver), "Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác");

        log.info("Step 2 - Pasword blank");
        generalSetting.enterDataToPasswordConfirm(driver, "");
        generalSetting.clickToConfirmButton();
        verifyEquals(generalSetting.getErrMessageValidationOfConfirmPass(driver), "Mật khẩu là bắt buộc.");

        log.info("Step 3 - Pasword contains all whitespace");
        generalSetting.enterDataToPasswordConfirm(driver, "    ");
        generalSetting.clickToConfirmButton();
        verifyEquals(generalSetting.getErrMessageValidationOfConfirmPass(driver), "Mật khẩu là bắt buộc.");

        log.info("Step 4 - Pasword contains less than 6 chars");
        generalSetting.enterDataToPasswordConfirm(driver, "12345");
        generalSetting.clickToConfirmButton();
        verifyEquals(generalSetting.getErrMessageValidationOfConfirmPass(driver), "Giới hạn tối thiểu của Mật khẩu là 6 kí tự");

        log.info("Step 5 - Pasword contains more than 128 chars");
        generalSetting.enterDataToPasswordConfirm(driver, randomPassword(129));
        generalSetting.clickToConfirmButton();
        verifyEquals(generalSetting.getErrMessageValidationOfConfirmPass(driver), "");

        log.info("Step 6 - Pasword contains white space");
        generalSetting.enterDataToPasswordConfirm(driver, "123 456");
        generalSetting.clickToConfirmButton();
        verifyEquals(generalSetting.getErrMessageValidationOfConfirmPass(driver), "Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác");

        log.info("Step 7 - Pasword contains script");
        generalSetting.enterDataToPasswordConfirm(driver, scriptCode);
        generalSetting.clickToConfirmButton();
        verifyEquals(generalSetting.getErrMessageValidationOfConfirmPass(driver), "Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác");

        log.info("Step 7 - Pasword contains HTML");
        generalSetting.enterDataToPasswordConfirm(driver, htmlCode);
        generalSetting.clickToConfirmButton();
        verifyEquals(generalSetting.getErrMessageValidationOfConfirmPass(driver), "Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác");

        generalSetting.clickButtonToCancelSaveChangeFullName(driver);
    }
    @Test
    public void Testcase15_Update_Fullname_With_TOTAL_FULL_NAME_GREATER_THAN_75_CHARS () {
        firstName = randomName(100);
        lastName = "Hồ";
        middleName = "Doãn ";

        generalSetting.clickToButtonEditFullName(driver);
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay(driver));
        generalSetting.enterDataToFirstNameField(driver, firstName);
        generalSetting.enterDataToMidnameField(driver, middleName);
        generalSetting.enterDataToLastnameField(driver, lastName);
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageOfChangeFullName(driver),"Giới hạn tối đa của Họ và tên là 75 kí tự");

    }

    @Test
    public void Testcase15_Update_Fullname_With_TOTAL_FULL_NAME_GREATER_THAN_5_WORDS () {
        firstName = "Quốc Huy Doãn";
        lastName = "Hồ";
        middleName = "Doãn ";

        generalSetting.enterDataToFirstNameField(driver, firstName);
        generalSetting.enterDataToMidnameField(driver, middleName);
        generalSetting.enterDataToLastnameField(driver, lastName);
        generalSetting.clickButtonSaveChangesToUpdateFullname(driver);
        verifyEquals(generalSetting.getErrMessageOfChangeFullName(driver),"Họ và tên không lớn hơn 5 từ.̣");
    }
}

