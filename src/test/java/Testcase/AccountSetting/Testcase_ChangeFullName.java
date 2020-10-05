package Testcase.AccountSetting;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.AccountSetting.GeneralAccountSetting;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Shared.Login_PageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase_ChangeFullName extends AbstractTest {
    DataHelper data;
    WebDriver driver;
    DriverManager driverManager;
    Login_PageObject newsfeedLoginPageObject;
    NewsfeedHomepage newsfeedHomepage;
    GeneralAccountSetting generalSetting;

    String firstName, lastName, middleName;

    @Parameters("browser")
    @BeforeTest
    public void preconnditionTest(String browserName) {

        data = DataHelper.getData();

        log.info("Pre step 1 - Create Browser driver");
        driverManager = BrowserInitialization.getBrowser(browserName);

        log.info("Pre step 2 - Go to Newsfeed");
        driver = driverManager.getDriver(GlobalVariables.NEWSFEED_URL);
        newsfeedLoginPageObject = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Pre step 3 - Change language system to VI");
        newsfeedHomepage.changeLanguageNewsfeedToVI();

        log.info("Pre step 4 - Login to Newsfeed");
        newsfeedLoginPageObject.LoginNewsfeedHahalolo(GlobalVariables.USER_EMAIL_ACCOUNT, "123456");
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Pre step 5 - Go To Account setting");
        newsfeedHomepage.clickToItemOnSettingMenu(driver, "ic-cog-c");
        generalSetting = PageGeneration.createGeneralAccountSettingPage(driver);

        log.info("Pre step 6 - Click to edit Fullname");
        generalSetting.clickToButtonEditFullName();
    }

    @Test
    public void TC01_Update_Fullname_With_Invalid_FirstName() {
        log.info("Case blank");
        log.info("Step 1. Enter first name");
        generalSetting.enterDataToFirstNameField("");
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateFirstName(), "Tên là bắt buộc.");

        log.info("Case contains all white space");
        log.info("Step 1. Enter first name");
        generalSetting.enterDataToFirstNameField("   ");
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateFirstName(), "Tên là bắt buộc.");

        log.info("Case contains only number");
        log.info("Step 1. Enter first name");
        generalSetting.enterDataToFirstNameField("123456");
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateFirstName(), "Tên không chứa số.");

        log.info("Case combine of number + characters");
        log.info("Step 1. Enter first name");
        generalSetting.enterDataToFirstNameField("Huy23");
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateFirstName(), "Tên không chứa số.");

        log.info("Case contains special characters");
        log.info("Step 1. Enter first name");
        generalSetting.enterDataToFirstNameField("Hu@n H@ồng");
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateFirstName(), "Tên không chứa ký tự đặc biệt.");

        log.info("Case contains HTML code");
        log.info("Step 1. Enter first name");
        generalSetting.enterDataToFirstNameField(GlobalVariables.HTML_CODE);
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateFirstName(), "Tên không chứa ký tự đặc biệt.");

        log.info("Step 7 - FirstName contains Script code");
        log.info("Step 1. Enter first name");
        generalSetting.enterDataToFirstNameField(GlobalVariables.SCRPIT_CODE);
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateFirstName(), "Tên không chứa ký tự đặc biệt.");

        log.info("Step 8 - FirstName contains more than 2 whitespace between 2 word");
        log.info("Step 1. Enter first name");
        generalSetting.enterDataToFirstNameField("Huy  Quốc");
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateFirstName(), "Tên không được nhập quá 2 kí tự trắng.");
    }
    @Test
    public void TC02_Update_Fullname_With_Invalid_LastName() {
        generalSetting.enterDataToFirstNameField("Quốc Huy");

        log.info("Lastname is blank");
        log.info("Step 1. Enter last name");
        generalSetting.enterDataToLastnameField( "");
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateLastName(), "Họ là bắt buộc.");

        log.info("Lastname contains all white space");
        log.info("Step 1. Enter last name");
        generalSetting.enterDataToLastnameField("   ");
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateLastName(), "Họ là bắt buộc.");

        log.info("Lastname contains only number");
        log.info("Step 1. Enter last name");
        generalSetting.enterDataToLastnameField("123456");
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateLastName(), "Họ không chứa số.");

        log.info("Lastname combine of number + characters");
        log.info("Step 1. Enter last name");
        generalSetting.enterDataToLastnameField("Hồ1");
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateLastName(), "Họ không chứa số.");

        log.info("Lastname contains special characters");
        log.info("Step 1. Enter last name");
        generalSetting.enterDataToLastnameField("H@ Do@n");
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateLastName(), "Họ không chứa ký tự đặc biệt.");

        log.info("Lastname contains HTML code");
        log.info("Step 1. Enter last name");
        generalSetting.enterDataToLastnameField(GlobalVariables.HTML_CODE);
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateLastName(), "Họ không chứa ký tự đặc biệt.");

        log.info("Lastname contains Script code");
        log.info("Step 1. Enter last name");
        generalSetting.enterDataToLastnameField(GlobalVariables.SCRPIT_CODE);
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateLastName(), "Họ không chứa ký tự đặc biệt.");

        log.info("Lastname contains more than 2 whitespace between 2 word");
        log.info("Step 1. Enter last name");
        generalSetting.enterDataToLastnameField("Hồ  Doãn");
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateLastName(), "Họ không được nhập quá 2 kí tự trắng.");
    }

    @Test
    public void Testcase03_Update_Fullname_With_Invalid_Middlename() {
        generalSetting.enterDataToLastnameField("Micheal");

        log.info("Middle name is number");
        log.info("Step 1. Enter Middle name");
        generalSetting.enterDataToMidnameField("123456");
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateMidName(), "Chữ lót không chứa số.");

        log.info("Middle name contains Alpha number");
        log.info("Step 1. Enter Middle name");
        generalSetting.enterDataToMidnameField("Huy12");
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateMidName(), "Chữ lót không chứa số.");

        log.info("Middle name contains Script Code");
        log.info("Step 1. Enter Middle name");
        generalSetting.enterDataToMidnameField(GlobalVariables.SCRPIT_CODE);
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateMidName(), "Chữ lót không chứa ký tự đặc biệt.");

        log.info("Middle name contains HTML Code");
        log.info("Step 1. Enter Middle name");
        generalSetting.enterDataToMidnameField(GlobalVariables.HTML_CODE);
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateMidName(), "Chữ lót không chứa ký tự đặc biệt.");

        log.info("Middle name contains special character");
        log.info("Step 1. Enter Middle name");
        generalSetting.enterDataToMidnameField("D@ãn");
        log.info("Step 2. Click to Login button");
        generalSetting.clickToSaveFullname();
        log.info("Step 3. Verify error message");
        verifyEquals(generalSetting.getMessageValidateMidName(), "Chữ lót không chứa ký tự đặc biệt.");

        generalSetting.clickCancelUpdateFullname();
    }

    @Test
    public void Testcase04_Update_Fullname_With_Firstname_Uppercase() {
        log.info("Prepare data");
        firstName =  data.getFirstName().toUpperCase();
        lastName = data.getLastName();
        middleName = data.getMiddleName();

        log.info("Prepare step");
        generalSetting.clickToButtonEditFullName();
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay());

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(firstName);

        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(middleName);

        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(lastName);

        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickToSaveFullname();

        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplayed());

        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm("123456");

        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();

        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameDisplay(), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void Testcase05_Update_Fullname_With_Firstname_Lowercase() {
        log.info("Prepare data");
        firstName =  data.getFirstName().toLowerCase();
        lastName = data.getLastName();
        middleName = data.getMiddleName();

        log.info("Prepare step");
        generalSetting.clickToButtonEditFullName();
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay());

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(firstName);

        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(middleName);

        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(lastName);

        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickToSaveFullname();

        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplayed());

        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm("123456");

        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();

        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameDisplay(), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void Testcase06_Update_Fullname_With_Firstname_Have_Whitespace_At_First_Position() {
        log.info("Prepare data");
        firstName = "  "+  data.getFirstName();
        lastName = data.getLastName();
        middleName = data.getMiddleName();

        log.info("Prepare step");
        generalSetting.clickToButtonEditFullName();
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay());

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(firstName);

        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(middleName);

        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(lastName);

        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickToSaveFullname();

        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplayed());

        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm( "123456");

        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();

        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameDisplay(), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void Testcase07_Update_Fullname_With_Firstname_Have_Whitespace_At_Last_Position() {
        log.info("Prepare data");
        firstName = data.getFirstName() +"  ";
        lastName = data.getLastName();
        middleName = data.getMiddleName();

        log.info("Prepare step");
        generalSetting.clickToButtonEditFullName();
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay());

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(firstName);

        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(middleName);

        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(lastName);

        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickToSaveFullname();

        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplayed());

        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm( "123456");

        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();

        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameDisplay(), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void TC08_Update_Fullname_With_Lastname_Have_Lowercase() {
        log.info("Prepare data");
        firstName = data.getFirstName();
        lastName = data.getLastName().toLowerCase();
        middleName = data.getMiddleName();

        log.info("Prepare step");
        generalSetting.clickToButtonEditFullName();
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay());

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(firstName);

        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(middleName);

        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(lastName);

        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickToSaveFullname();

        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplayed());

        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm("123456");

        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();

        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameDisplay(), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void TC09_Update_Fullname_With_Lastname_Have_Uppercase() {
        log.info("Prepare data");
        firstName = data.getFirstName();
        lastName = data.getLastName().toUpperCase();
        middleName = data.getMiddleName();

        log.info("Prepare step");
        generalSetting.clickToButtonEditFullName();
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay());

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(firstName);

        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(middleName);

        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(lastName);

        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickToSaveFullname();

        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplayed());

        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm( "123456");

        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();

        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameDisplay(), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void TC10_Update_Fullname_With_Lastname_Have_Whitespace_At_First_Position() {
        log.info("Prepare data");
        firstName = data.getFirstName();
        lastName = "  "+ data.getLastName();
        middleName = data.getMiddleName();

        log.info("Prepare step");
        generalSetting.clickToButtonEditFullName();
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay());

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(firstName);

        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(middleName);

        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(lastName);

        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickToSaveFullname();

        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplayed());

        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm( "123456");

        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();

        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameDisplay(), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void TC11_Update_Fullname_With_Lastname_Have_Whitespace_At_Last_Position() {
        log.info("Prepare data");
        firstName = data.getFirstName();
        lastName = data.getLastName() + "  ";
        middleName = data.getMiddleName();

        log.info("Prepare step");
        generalSetting.clickToButtonEditFullName();
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay());

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(firstName);

        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(middleName);

        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(lastName);

        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickToSaveFullname();

        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplayed());

        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm( "123456");

        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();

        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameDisplay(), getFullName(firstName, middleName, lastName));
    }
    @Test
    public void TC12_Update_Fullname_With_MiddleName_Have_Lowercase () {
        log.info("Prepare data");
        firstName = data.getFirstName();
        lastName = data.getLastName();
        middleName = data.getMiddleName().toLowerCase();

        log.info("Prepare step");
        generalSetting.clickToButtonEditFullName();
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay());

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(firstName);

        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(middleName);

        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(lastName);

        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickToSaveFullname();

        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplayed());

        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm("123456");

        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();

        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameDisplay(), getFullName(firstName, middleName, lastName));
    }
    @Test
    public void TC13_Update_Fullname_With_MiddleNam_Have_Uppercase () {
        log.info("Prepare data");
        firstName = data.getFirstName();
        lastName = data.getLastName();
        middleName = data.getMiddleName().toUpperCase();

        log.info("Prepare step");
        generalSetting.clickToButtonEditFullName();
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay());

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(firstName);

        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(middleName);

        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(lastName);

        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickToSaveFullname();

        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplayed());

        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm("123456");

        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();

        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameDisplay(), getFullName(firstName, middleName, lastName));
    }
    @Test
    public void TC14_Update_Fullname_With_MiddleName_Have_Whitespace_At_First_Position () {
        log.info("Prepare data");
        firstName = data.getFirstName();
        lastName = data.getLastName();
        middleName = "  "+ data.getMiddleName();

        log.info("Prepare step");
        generalSetting.clickToButtonEditFullName();
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay());

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(firstName);

        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(middleName);

        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(lastName);

        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickToSaveFullname();

        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplayed());

        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm("123456");

        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();

        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameDisplay(), getFullName(firstName, middleName, lastName));
    }

    @Test
    public void TC15_Update_Fullname_With_MiddleName_Have_Whitespace_At_Last_Position () {
        log.info("Prepare data");
        firstName = data.getFirstName();
        lastName = data.getLastName();
        middleName = data.getMiddleName()+ "   ";

        log.info("Prepare step");
        generalSetting.clickToButtonEditFullName();
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay());

        log.info("Step 1 - Enter first name");
        generalSetting.enterDataToFirstNameField(firstName);

        log.info("Step 2 - Enter middle name");
        generalSetting.enterDataToMidnameField(middleName);

        log.info("Step 3 - Enter last name");
        generalSetting.enterDataToLastnameField(lastName);

        log.info("Step 4 - Click to button Save changes");
        generalSetting.clickToSaveFullname();

        log.info("Step 5 - Check Confirm password popup is display");
        verifyTrue(generalSetting.checkConfirmPasswordPopupIsDisplayed());

        log.info("Step 6 - Enter confirm pass");
        generalSetting.enterDataToPasswordConfirm("123456");

        log.info("Step 7 - Click to confirm pass button");
        generalSetting.clickToConfirmButton();

        log.info("Step 8 - Check full name after change");
        verifyEquals(generalSetting.getFullNameDisplay(), getFullName(firstName, middleName, lastName));
    }
    @Test
    public void TC15_Update_Fullname_With_Invalid_Pass () {
        log.info("Prepare data");
        firstName = data.getFirstName();
        middleName = data.getMiddleName();
        lastName = data.getLastName();

        log.info("Prepare step");
        generalSetting.clickToButtonEditFullName();
        generalSetting.updateFullnameUser(firstName,middleName,lastName);

        log.info("Case Wrong pass");
        log.info("Step 1 - Enter Password");
        generalSetting.enterDataToPasswordConfirm("1123456");
        log.info("Step 2 - Click to confirm button");
        generalSetting.clickToConfirmButton();
        log.info("Step 3 - Verify error message");
        verifyEquals(generalSetting.getErrMessageValidationOfConfirmPass(driver), "Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác");

        log.info("Case Pasword is blank");
        log.info("Step 1 - Enter Password");
        generalSetting.enterDataToPasswordConfirm( "");
        log.info("Step 2 - Click to confirm button");
        generalSetting.clickToConfirmButton();
        log.info("Step 3 - Verify error message");
        verifyEquals(generalSetting.getErrMessageValidationOfConfirmPass(driver), "Mật khẩu là bắt buộc.");

        log.info("Case Pasword contains all whitespace");
        log.info("Step 1 - Enter Password");
        generalSetting.enterDataToPasswordConfirm( "    ");
        log.info("Step 2 - Click to confirm button");
        generalSetting.clickToConfirmButton();
        log.info("Step 3 - Verify error message");
        verifyEquals(generalSetting.getErrMessageValidationOfConfirmPass(driver), "Mật khẩu là bắt buộc.");

        log.info("Case Pasword contains less than 6 chars");
        log.info("Step 1 - Enter Password");
        generalSetting.enterDataToPasswordConfirm( "12345");
        log.info("Step 2 - Click to confirm button");
        generalSetting.clickToConfirmButton();
        log.info("Step 3 - Verify error message");
        verifyEquals(generalSetting.getErrMessageValidationOfConfirmPass(driver), "Giới hạn tối thiểu của Mật khẩu là 6 kí tự");

        log.info("Case Pasword contains more than 128 chars");
        log.info("Step 1 - Enter Password");
        generalSetting.enterDataToPasswordConfirm(randomPassword(129));
        log.info("Step 2 - Click to confirm button");
        generalSetting.clickToConfirmButton();
        log.info("Step 3 - Verify error message");
        verifyEquals(generalSetting.getErrMessageValidationOfConfirmPass(driver), "");

        log.info("Case Pasword contains white space");
        log.info("Step 1 - Enter Password");
        generalSetting.enterDataToPasswordConfirm("123 456");
        log.info("Step 2 - Click to confirm button");
        generalSetting.clickToConfirmButton();
        log.info("Step 3 - Verify error message");
        verifyEquals(generalSetting.getErrMessageValidationOfConfirmPass(driver), "Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác");

        log.info("Case Pasword contains script");
        log.info("Step 1 - Enter Password");
        generalSetting.enterDataToPasswordConfirm(GlobalVariables.SCRPIT_CODE);
        log.info("Step 2 - Click to confirm button");
        generalSetting.clickToConfirmButton();
        log.info("Step 3 - Verify error message");
        verifyEquals(generalSetting.getErrMessageValidationOfConfirmPass(driver), "Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác");

        log.info("Case Pasword contains HTML");
        log.info("Step 1 - Enter Password");
        generalSetting.enterDataToPasswordConfirm(GlobalVariables.HTML_CODE);
        log.info("Step 2 - Click to confirm button");
        generalSetting.clickToConfirmButton();
        log.info("Step 3 - Verify error message");
        log.info("Step 3 - Verify error message");
        verifyEquals(generalSetting.getErrMessageValidationOfConfirmPass(driver), "Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác");

        generalSetting.clickToCancelSaveChangeFullName();
    }
    @Test
    public void Testcase15_Update_Fullname_With_TOTAL_FULL_NAME_GREATER_THAN_75_CHARS () {
        firstName = randomName(100);
        lastName = "Hồ";
        middleName = "Doãn ";

        generalSetting.clickToButtonEditFullName();
        verifyTrue(generalSetting.checkUpdateFullNameFormIsDisplay());
        generalSetting.enterDataToFirstNameField(firstName);
        generalSetting.enterDataToMidnameField(middleName);
        generalSetting.enterDataToLastnameField(lastName);
        generalSetting.clickToSaveFullname();
        verifyEquals(generalSetting.getMessageFullNameFunction(),"Giới hạn tối đa của Họ và tên là 75 kí tự");

    }

    @Test
    public void Testcase15_Update_Fullname_With_TOTAL_FULL_NAME_GREATER_THAN_5_WORDS () {
        firstName = "Quốc Huy Doãn";
        lastName = "Hồ";
        middleName = "Doãn ";

        generalSetting.enterDataToFirstNameField(firstName);
        generalSetting.enterDataToMidnameField(middleName);
        generalSetting.enterDataToLastnameField(lastName);
        generalSetting.clickToSaveFullname();
        verifyEquals(generalSetting.getMessageFullNameFunction(),"Họ và tên không lớn hơn 5 từ.̣");
    }
}

