package Testcase.PersonalPageWall.About.BasicInfoAndContact;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.About.PerAbout_BasicInfoAndContact_PageObject;
import Project.Newsfeed.PersonalWall.About.PerAbout_Overview_PageObject;
import Project.Shared.Login_PageObject;
import Project.Shared.SignUp_PageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Testcase_ComponentTest_PhoneNumber_Function extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    Login_PageObject newsfeedLoginPage;
    NewsfeedHomepage newsfeedHomepage;
    PerAbout_Overview_PageObject perOverviewTab;
    PerAbout_BasicInfoAndContact_PageObject perBasicInfoTab;
    SignUp_PageObject signUpPage;

    String numberPhone;
    String otherPhone;

    @Parameters("browser")
    @BeforeClass
    public void preconditionTest(String browserName){
        driverManager = BrowserInitialization.getBrowser(browserName);
        driver = driverManager.getDriver(GlobalVariables.NEWSFEED_URL);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);
        newsfeedLoginPage.clickToChangeLanguageToVI(driver);

        log.info("Prestep 1 - Login Hahalolo");
        newsfeedLoginPage.LoginNewsfeedHahalolo(GlobalVariables.USER_EMAIL_ACCOUNT,"123456");
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Prestep 2 - Check Login successfully");
        verifyTrue(newsfeedHomepage.checkNewsfeedDisplay());

        log.info("Prestep 3 - Go to Personal About");
        newsfeedHomepage.clickToEditProfile();
        perOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("Prestep 4. Check personal about overview display successfully");
        verifyTrue(perOverviewTab.checkPerAboutOverviewTabIsDisplay());

        log.info("Prestep 5. Go to Personal About - Basic And Contact Info");
        perOverviewTab.clickToTabItemOnAbout(driver, "#about_contact");
        perBasicInfoTab = PageGeneration.createperBasicInfoAndContactPage(driver);

        log.info("Prestep 6. Check personal about Basic And Contact Info display successfully");
        verifyTrue(perBasicInfoTab.checkContactAndBasicInfoTabIsDisplay());
    }

    @Test
    public void TC_01_EditPhoneNumberWithInvalidPhone(){
        log.info("Prepare step - Open main phone form");
        perBasicInfoTab.clickToEditMainPhone();

        log.info("Case - Make main phone blank");
        numberPhone ="";
        log.info("Step 1 - Remove phone number");
        perBasicInfoTab.enterDataToMainPhoneField(numberPhone);
        verifyEquals(perBasicInfoTab.getAttributeValueOfMainPhoneField(), perBasicInfoTab.formatDataOfPhoneField(numberPhone));
        log.info("Step 2. Click to Save button");
        perBasicInfoTab.clickToSavePhoneInfo();
        log.info("Step 3. Check error validation");
        verifyEquals(perBasicInfoTab.getErrorValidateOfMainPhoneField(),"Số điện thoại là bắt buộc.");

        log.info("Case - Main phone contains all whitespace");
        numberPhone = "       ";
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToMainPhoneField(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfMainPhoneField(),perBasicInfoTab.formatDataOfPhoneField(numberPhone));
        log.info("Step 3. Check error validation");
        perBasicInfoTab.clickToSavePhoneInfo();
        verifyEquals(perBasicInfoTab.getErrorValidateOfMainPhoneField(),"Số điện thoại là bắt buộc.");

        log.info("Case - Main phone contains only characters");
        numberPhone = "abcdefgh";
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToMainPhoneField(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfMainPhoneField(),perBasicInfoTab.formatDataOfPhoneField(numberPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToSavePhoneInfo();
        log.info("Step 4. Check error validation");
        verifyEquals(perBasicInfoTab.getErrorValidateOfMainPhoneField(),"Số điện thoại là bắt buộc.");

        log.info("Case - Main phone contains only special characters");
        numberPhone = "@@@@@@@@@@@";
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToMainPhoneField(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfMainPhoneField(),perBasicInfoTab.formatDataOfPhoneField(numberPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToSavePhoneInfo();
        log.info("Step 4. Check error validation");
        verifyEquals(perBasicInfoTab.getErrorValidateOfMainPhoneField(),"Số điện thoại là bắt buộc.");

        log.info("Case - Main phone contains less than 8 characters");
        numberPhone = "1234567";
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToMainPhoneField(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfMainPhoneField(),perBasicInfoTab.formatDataOfPhoneField(numberPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToSavePhoneInfo();
        log.info("Step 4. Check error validation");
        verifyEquals(perBasicInfoTab.getErrorValidateOfMainPhoneField(),"Giới hạn tối thiểu của Số điện thoại là 8 kí tự");

        log.info("Case - Main phone contains less than 20 characters");
        numberPhone = String.valueOf(randomNumber(21));
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToMainPhoneField(perBasicInfoTab.formatDataOfPhoneField(numberPhone));
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfMainPhoneField(),perBasicInfoTab.formatDataOfPhoneField(numberPhone));

        log.info("Case - Main phone is combine character + numberic and number <8");
        numberPhone = "huy1234567";
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToMainPhoneField(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfMainPhoneField(),perBasicInfoTab.formatDataOfPhoneField(numberPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToSavePhoneInfo();
        log.info("Step 4. Check error validation");
        verifyEquals(perBasicInfoTab.getErrorValidateOfMainPhoneField(),"Giới hạn tối thiểu của Số điện thoại là 8 kí tự");

        log.info("Case - Main phone is combine character + numberic and number >20");
        numberPhone = "huy123456789ho123456789doan132";
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToMainPhoneField(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfMainPhoneField(),perBasicInfoTab.formatDataOfPhoneField(numberPhone));

        log.info("Case - Main phone is combine character + numberic and number 8-20");
        numberPhone = "Haha9191HoHuy3423";
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToMainPhoneField(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfMainPhoneField(),perBasicInfoTab.formatDataOfPhoneField(numberPhone));

        log.info("Case - Main phone is script code");
        numberPhone = GlobalVariables.SCRPIT_CODE;
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToMainPhoneField(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfMainPhoneField(),perBasicInfoTab.formatDataOfPhoneField(numberPhone));

        log.info("Case - Main phone is HTML code");
        numberPhone = GlobalVariables.HTML_CODE;
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToMainPhoneField(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfMainPhoneField(),perBasicInfoTab.formatDataOfPhoneField(numberPhone));

        perBasicInfoTab.clickToCancelSavePhoneInfo();
    }
    @Test
    public void TC_02_Check_Action_Add_Other_Phone(){
        log.info("Prepare step - Open main phone form");
        perBasicInfoTab.clickToEditMainPhone();
        perBasicInfoTab.clickToAddnewOtherPhone();

        log.info("Case - Make other phone blank");
        otherPhone = "";
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToOtherPhone(otherPhone);
        verifyEquals(perBasicInfoTab.getAttributeValueOfOtherPhoneField(), perBasicInfoTab.formatDataOfPhoneField(otherPhone));
        log.info("Step 2. Click to Save button");
        perBasicInfoTab.clickToSavePhoneInfo();

        log.info("Case - Other phone contains all whitespace");
        otherPhone = "       ";
        perBasicInfoTab.clickToEditMainPhone();
        perBasicInfoTab.clickToAddnewOtherPhone();
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToOtherPhone(otherPhone);
        log.info("Step 2 - Verify other phone value display");
        verifyEquals(perBasicInfoTab.getAttributeValueOfOtherPhoneField(),perBasicInfoTab.formatDataOfPhoneField(otherPhone));
        log.info("Step 3. Check error validation");
        perBasicInfoTab.clickToSavePhoneInfo();

        log.info("Case - Other phone contains only characters");
        perBasicInfoTab.clickToEditMainPhone();
        perBasicInfoTab.clickToAddnewOtherPhone();
        otherPhone = "abcdefgh";
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToOtherPhone(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfOtherPhoneField(),perBasicInfoTab.formatDataOfPhoneField(otherPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToSavePhoneInfo();


        log.info("Case - Main phone contains only special characters");
        perBasicInfoTab.clickToEditMainPhone();
        perBasicInfoTab.clickToAddnewOtherPhone();
        otherPhone = "@@@@@@@@@@@";
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToOtherPhone(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfOtherPhoneField(),perBasicInfoTab.formatDataOfPhoneField(otherPhone ));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToSavePhoneInfo();

        log.info("Case - Main phone contains less than 8 characters");
        perBasicInfoTab.clickToEditMainPhone();
        perBasicInfoTab.clickToAddnewOtherPhone();
        otherPhone = "1234567";
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToOtherPhone(otherPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfOtherPhoneField(),perBasicInfoTab.formatDataOfPhoneField(otherPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToSavePhoneInfo();
        log.info("Step 4. Check error validation");
        verifyEquals(perBasicInfoTab.getErrorValidateOfOtherPhoneField(),"Giới hạn tối thiểu của Số điện thoại là 8 kí tự");

        log.info("Case - Main phone contains less than 20 characters");
        otherPhone = String.valueOf(randomNumber(21));
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToOtherPhone(perBasicInfoTab.formatDataOfPhoneField(otherPhone));
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfOtherPhoneField(),perBasicInfoTab.formatDataOfPhoneField(otherPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToSavePhoneInfo();

        log.info("Case - Other phone is combine character + numberic and number <8");
        otherPhone = "huy1234567";
        perBasicInfoTab.clickToEditMainPhone();
        perBasicInfoTab.clickToAddnewOtherPhone();
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToOtherPhone(otherPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfOtherPhoneField(),perBasicInfoTab.formatDataOfPhoneField(otherPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToSavePhoneInfo();
        log.info("Step 4. Check error validation");
        verifyEquals(perBasicInfoTab.getErrorValidateOfOtherPhoneField(),"Giới hạn tối thiểu của Số điện thoại là 8 kí tự");

        log.info("Case - Other phone is combine character + numberic and number >20");
        otherPhone = "huy123456789ho123456789doan132";
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToOtherPhone(otherPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfOtherPhoneField(),perBasicInfoTab.formatDataOfPhoneField(otherPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToSavePhoneInfo();

        log.info("Case - Main phone is combine character + numberic and number 8-20");
        otherPhone = "Haha9191HoHuy3423";
        perBasicInfoTab.clickToEditMainPhone();
        perBasicInfoTab.clickToAddnewOtherPhone();
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToOtherPhone(otherPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfOtherPhoneField(),perBasicInfoTab.formatDataOfPhoneField(otherPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToSavePhoneInfo();

        log.info("Case - Main phone is script code");
        otherPhone = GlobalVariables.SCRPIT_CODE;
        perBasicInfoTab.clickToEditMainPhone();
        perBasicInfoTab.clickToAddnewOtherPhone();
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToOtherPhone(otherPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfOtherPhoneField(),perBasicInfoTab.formatDataOfPhoneField(otherPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToSavePhoneInfo();

        log.info("Case - Main phone is HTML code");
        otherPhone = GlobalVariables.HTML_CODE;
        perBasicInfoTab.clickToEditMainPhone();
        perBasicInfoTab.clickToAddnewOtherPhone();
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToOtherPhone(otherPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getAttributeValueOfOtherPhoneField(),perBasicInfoTab.formatDataOfPhoneField(otherPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToSavePhoneInfo();
    }

    public void TC03_Check_Function_Add_Phone_Number_With_Case_New_Account(){
        log.info("Logout account");
        perBasicInfoTab.clickToItemOnSettingMenu(driver,"");
        signUpPage = PageGeneration.createFormRegister(driver);
        signUpPage.signUpWithNewAccountByEmail("","","","","");

        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);
        newsfeedHomepage.clickToEditProfile();
        perOverviewTab.clickToTabItemOnAbout(driver,"");

        verifyTrue(perBasicInfoTab.checkContactAndBasicInfoCaseCreateAccountByPhone());

        perBasicInfoTab.clickToButtonAddNewMainPhone();
        perBasicInfoTab.enterDataToMainPhoneField("");
        perBasicInfoTab.clickToSavePhoneInfo();

        verifyEquals(perBasicInfoTab.getMainPhoneDisplay(),"");

        perBasicInfoTab.clickToEditMainPhone();
        perBasicInfoTab.clickToAddnewOtherPhone();
        perBasicInfoTab.enterDataToOtherPhone("");
        perBasicInfoTab.clickToSavePhoneInfo();

        verifyEquals(perBasicInfoTab.getOtherPhoneDisplay(),"");

        perBasicInfoTab.clickToEditMainPhone();
        perBasicInfoTab.clickToRemoveRedirectOtherPhone();
        perBasicInfoTab.clickToSavePhoneInfo();

        verifyEquals(perBasicInfoTab.getOtherPhoneDisplay(),"");


    }
}
