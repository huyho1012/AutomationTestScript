package Testcase.PersonalPageWall.About.BasicInfoAndContact;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.About.PerAbout_BasicInfoAndContact_PageObject;
import Project.Newsfeed.PersonalWall.About.PerAbout_Overview_PageObject;
import Project.Shared.Login_PageObject;
import Project.Shared.SignUp_PageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase_ComponentTest_GenderFunction extends AbstractTest {
    WebDriver driver;
    DataHelper dataHelper;
    DriverManager driverManager;
    Login_PageObject newsfeedLoginPage;
    NewsfeedHomepage newsfeedHomepage;
    SignUp_PageObject signUpPage;
    PerAbout_Overview_PageObject perAboutOverviewTab;
    PerAbout_BasicInfoAndContact_PageObject perAboutBasicInfoTab;
    String genderName;
    String genderOnIntroduce;
    String languageSystem;
    String genderValue;

    @Parameters("browser")
    @BeforeClass
    public void preconditionStep(String browserName){
        dataHelper = DataHelper.getData();
        log.info("Create browser driver");
        driverManager = BrowserInitialization.getBrowser(browserName);

        log.info("Open browser and go to Newsfeed Login page");
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Change language to Vi");
        newsfeedLoginPage.clickToChangeLanguageToVI(driver);
        languageSystem = newsfeedLoginPage.getLanguageOfSystemHahalolo(driver);

        log.info("Login to newsfeed");
        newsfeedLoginPage.Login(GlobalVariables.USER_ACCOUNT,"123456");
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Newsfeed page display successfully");
        verifyTrue(newsfeedHomepage.checkNewsfeedDisplay());

        log.info("Click to Edit profile");
        newsfeedHomepage.clickToEditProfile();
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("Check Personal About - Overview");
        verifyTrue(perAboutOverviewTab.checkPerAboutOverviewTabIsDisplay());
        String genderOnWidget = perAboutOverviewTab.getGenderDisplayOnIntroduceWidget();

        log.info("Go to personal about - Basic and Contact Info");
        perAboutOverviewTab.clickToTabItemOnAbout(driver,"#about_contact");
        perAboutBasicInfoTab = PageGeneration.createperBasicInfoAndContactPage(driver);

        log.info("Check Basic And Contact Info display");
        verifyTrue(perAboutBasicInfoTab.checkContactAndBasicInfoTabIsDisplay());
        verifyEquals(perAboutBasicInfoTab.getGenderDisplayOnBasicInfoAndContact(), genderOnWidget);
    }

    @Test
    public void TC01_Update_Gender_Type_Male(){
        log.info("Prepare data");
        genderValue = "M";
        log.info("1. Click to edit gender");
        perAboutBasicInfoTab.clickToEditGender();

        log.info("2. Check form edit gender display successfully");
        verifyTrue(perAboutBasicInfoTab.checkFormEditGenderOfUserIsDisplay());

        log.info("3. Choose gender type is Male");
        perAboutBasicInfoTab.selectGenderOption(genderValue);
        genderName = perAboutBasicInfoTab.getGenderNameByValue(languageSystem, genderValue);

        log.info("4. Click to save gender");
        perAboutBasicInfoTab.clickButtonToSaveGender();

        log.info("5. Verify gender display after changing is correctly");
        verifyEquals(perAboutBasicInfoTab.getGenderDisplayOnBasicInfoAndContact(),genderName);

        log.info("5. Go back to Personal About - Overview");
        perAboutBasicInfoTab.clickToTabItemOnAbout(driver,"#about_overview");
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("6. Verify gender on introduce Widget update");
        genderOnIntroduce = perAboutOverviewTab.getGenderDisplayOnIntroduceWidget();
        verifyEquals(genderOnIntroduce, genderName);
    }

    @Test
    public void TC02_Update_Gender_Type_FeMale(){
        log.info("Prepare data");
        genderValue = "F";

        log.info("Prepare step");
        perAboutOverviewTab.clickToTabItemOnAbout(driver,"#about_contact");
        perAboutBasicInfoTab  = PageGeneration.createperBasicInfoAndContactPage(driver);

        log.info("1. Click to edit gender");
        perAboutBasicInfoTab.clickToEditGender();

        log.info("2. Choose gender type is Female");
        perAboutBasicInfoTab.selectGenderOption(genderValue);
        genderName = perAboutBasicInfoTab.getGenderNameByValue(languageSystem, genderValue);

        log.info("3. Click to save gender");
        perAboutBasicInfoTab.clickButtonToSaveGender();

        log.info("4. Verify gender display after changing is Female");
        verifyEquals(perAboutBasicInfoTab.getGenderDisplayOnBasicInfoAndContact(),genderName);

        log.info("5. Go back to Personal About - Overview");
        perAboutBasicInfoTab.clickToTabItemOnAbout(driver,"#about_overview");
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("6. Verify gender on introduce Widget update");
        verifyEquals(perAboutOverviewTab.getGenderDisplayOnIntroduceWidget(), genderName);
    }

    @Test
    public void TC03_Update_Gender_Type_Other(){
        log.info("Prepare data");
        genderValue = "N";

        log.info("Prepare step");
        perAboutOverviewTab.clickToTabItemOnAbout(driver,"#about_contact");
        perAboutBasicInfoTab  = PageGeneration.createperBasicInfoAndContactPage(driver);

        log.info("1. Click to edit gender");
        perAboutBasicInfoTab.clickToEditGender();

        log.info("2. Choose gender type is Other");
        perAboutBasicInfoTab.selectGenderOption(genderValue);
        genderName = perAboutBasicInfoTab.getGenderNameByValue(languageSystem, genderValue);

        log.info("3. Click to save gender");
        perAboutBasicInfoTab.clickButtonToSaveGender();

        log.info("4. Verify gender display after changing is Other");
        verifyEquals(perAboutBasicInfoTab.getGenderDisplayOnBasicInfoAndContact(),genderName);

        log.info("5. Go back to Personal About - Overview");
        perAboutBasicInfoTab.clickToTabItemOnAbout(driver,"#about_overview");
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("6. Verify gender on introduce Widget update");
        verifyEquals(perAboutOverviewTab.getGenderDisplayOnIntroduceWidget(), genderName);

        log.info("End Step - Logout");
        perAboutOverviewTab.clickToItemOnSettingMenu(driver,"ic-logout-c");
        signUpPage = PageGeneration.createFormRegister(driver);
    }

    @Test(description = "M = Male, F = Female, N = Other")
    public void TC04_Check_Update_Gender_With_New_Account(){
        log.info("Step 1. Register with new account");
        log.info("Step 1.1 Prepare data before register account");
        String firstName = dataHelper.getFirstName();
        String lastName = dataHelper.getLastName();
        String email = randomVirtualEmail();
        log.info("Step 1.2 Register account");
        signUpPage.signUpWithNewAccountByEmail(firstName,lastName,email,"123456","123456");
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);
        log.info("Step 1.3 Verify register new account successfully");
        verifyTrue(newsfeedHomepage.checkNewsfeedDisplayOnFirstTime());

        log.info("Step 2. Update new information");
        log.info("Step 2.1. Prepaid data for update information");
        genderValue = "M";
        log.info("Step 2.1. Update information");
        newsfeedHomepage.updateNewInformationOfAccount("12","10","1992",genderValue,"Albania");

        log.info("Step 3. Verify gender information of user");
        log.info("Step 3.1 Go to Overview Tab");
        newsfeedHomepage.clickToEditProfile();
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);
        verifyTrue(perAboutOverviewTab.checkPerAboutOverviewTabIsDisplay());
        log.info("Step 3.2 Go to Basic info and contact Tab");
        perAboutOverviewTab.clickToTabItemOnAbout(driver,"#about_contact");
        perAboutBasicInfoTab  = PageGeneration.createperBasicInfoAndContactPage(driver);
        log.info("Step 3.3 Verify Avatar default image display correctsponding with gender type");
        genderName = perAboutBasicInfoTab.getGenderNameByValue(languageSystem, genderValue);
        verifyTrue(perAboutOverviewTab.checkAvatarUserDisplayWithGenderType(driver, genderName));
        log.info("Step 3.4. Check Gender on Basic and Contact Info tab display correctly");
        verifyEquals(perAboutBasicInfoTab.getGenderDisplayOnBasicInfoAndContact(), genderName);

        log.info("4 Edit gender sser with type gender is Other");
        log.info("Step 4.1 Click to Edit icon of gender");
        perAboutBasicInfoTab.clickToEditGender();
        log.info("Step 4.2 Check form edit gender display");
        verifyTrue(perAboutBasicInfoTab.checkFormEditGenderOfUserIsDisplay());
        log.info("Step 4.3 Choose gender");
        genderValue = "N";
        perAboutBasicInfoTab.chooseGenderType(genderValue);
        genderName = perAboutBasicInfoTab.getGenderNameByValue(languageSystem,genderValue);
        log.info("Step 4.4. Click Save button for updating gender");
        perAboutBasicInfoTab.clickButtonToSaveGender();
        log.info("Step 4.5 Check gender display on Basic info and contact");
        verifyEquals(perAboutBasicInfoTab.getGenderDisplayOnBasicInfoAndContact(),genderName);
        log.info("Step 4.6. Back to Overview tab");
        perAboutBasicInfoTab.clickToTabItemOnAbout(driver,"#about_overview");
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);
        log.info("Step 4.7 Check gender on Introduce widget");
        verifyEquals(perAboutOverviewTab.getGenderDisplayOnIntroduceWidget(),genderName);
        log.info("Step 4.8 Reload personal page for upload avatar");
        perAboutOverviewTab.refreshPage(driver);
        log.info("Step 4.9 Check Avatar display with genderName");
        verifyTrue(perAboutOverviewTab.checkAvatarUserDisplayWithGenderType(driver, genderName));
        log.info("Step 4.10. Go To Basic info and contact tab");
        perAboutOverviewTab.clickToTabItemOnAbout(driver,"#about_contact");
        perAboutBasicInfoTab  = PageGeneration.createperBasicInfoAndContactPage(driver);

        log.info("Step 5. Edit gender with Gender type is Female");
        log.info("Step 5.1. Click Edit button to open form Edit Gender");
        perAboutBasicInfoTab.clickToEditGender();
        log.info("Step 5.2 Check form edit gender display");
        verifyTrue(perAboutBasicInfoTab.checkFormEditGenderOfUserIsDisplay());
        log.info("Step 5.3. Choose gender");
        genderValue = "F";
        perAboutBasicInfoTab.chooseGenderType(genderValue);
        genderName = perAboutBasicInfoTab.getGenderNameByValue(languageSystem, genderValue);
        log.info("Step 5.4. Click save button for updating gender");
        perAboutBasicInfoTab.clickButtonToSaveGender();
        log.info("Step 5.5 Check gender display on Basic info and contact");
        verifyEquals(perAboutBasicInfoTab.getGenderDisplayOnBasicInfoAndContact(),genderName);
        log.info("Step 5.6 Back to Overview tab");
        perAboutBasicInfoTab.clickToTabItemOnAbout(driver,"#about_overview");
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);
        log.info("Step 5.7 Check gender on Introduce widget");
        verifyEquals(perAboutOverviewTab.getGenderDisplayOnIntroduceWidget(),genderName);
        log.info("Step 5.8 Reload personal page for upload avatar");
        perAboutOverviewTab.refreshPage(driver);
        log.info("Step 5.9 Check Avatar display with genderName");
        verifyTrue(perAboutOverviewTab.checkAvatarUserDisplayWithGenderType(driver, genderName));
        log.info("Step 5.10 Logout account");
        perAboutOverviewTab.clickToItemOnSettingMenu(driver,"ic-logout-c");
    }
}
