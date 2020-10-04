package Testcase.SignUp;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;

import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;

import Project.Newsfeed.AccountSetting.GeneralAccountSetting;

import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.About.*;
import Project.Shared.Login_PageObject;
import Project.Shared.SignUp_PageObject;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Regression_Test_Of_SignUp extends AbstractTest {
    DriverManager driverManager;
    DataHelper data = new DataHelper();
    WebDriver driver;

    // Object model
    Login_PageObject loginNewsfeedPage;
    SignUp_PageObject signUpPage;
    NewsfeedHomepage newsfeedHomePage;

    PerAbout_Overview_PageObject perAboutOverviewTab;
    PerAbout_BasicInfoAndContact_PageObject perAboutBasicInfoTab;
    PerAbout_DetailsAboutYou_PageObject perAboutDetailAboutTab;
    PerAbout_PlacesYouLived_PageObject perAboutPlaceYouLivedTab;
    PerAbout_WorkAndEducation_PageObject  perAboutWorkEducationTab;


    GeneralAccountSetting generalAccSetting;

    // Define user properties
    String firstNameUser, lastNameUser, emailUser, passwordUser, confirmPassUser, genderUser, fullName;
    String avatarUserImage, coverUserImage;
    // Define business properties
    String businessName, ownerName, ownerEmail, ownerPhone;
    // Define business verification properties
    String companyName, otherCompanyName, abbCompanyName, taxCodeCompany, representativeName, registrationAddress, zipCode, companyPhone, companyEmail, businessScope;
    // Define payment account properties
    String paymentAccountName;
    // Define tour info properties
    String pageTourName;
    String startDateTour, endTDateTour;

    String languageSystem;

    @Parameters("browser")
    @BeforeClass
    public void preconditionStep(String browserName) {
        log.info("Create Driver ");
        driverManager = BrowserInitialization.getBrowser(browserName);
        log.info("Open Browser and Go to Newsfeed login");
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        loginNewsfeedPage = PageGeneration.createNewsfeedLoginPage(driver);
        log.info("Check Hahalolo login page display");
        verifyTrue(loginNewsfeedPage.checkNewsfeedLoginPageDisplay());
        log.info("Change system language To Vi");
        loginNewsfeedPage.clickToChangeLanguageToVI(driver);
        signUpPage = PageGeneration.createFormRegister(driver);
        languageSystem = signUpPage.getLanguageOfSystemHahalolo(driver);
    }

    @BeforeTest
    public void generateDataForTesting() {
        avatarUserImage= "User\\avatarUser.png";
        coverUserImage = "User\\coverUser.jpg";

        // Generate thông tin chủ sở hữu
        ownerName = data.getFullName();
        ownerPhone = "0936709449";
        ownerEmail = randomVirtualEmail();
        // Generate thông tin doanh nghiệp
        businessName = data.getCompanyName();

        // Generate thông tin xác minh tài khoản Enterprise
        companyName = data.getCompanyName();
        otherCompanyName = data.getCompanyName();
        abbCompanyName = data.getCompanyName();
        taxCodeCompany = data.getTaxCode();
        representativeName = data.getFullName();
        registrationAddress = "Hahalolo";
        zipCode = data.getZipCode();
        companyPhone = data.getCompanyPhone();
        companyEmail = data.getCompanyEmail();
        businessScope = "Buôn bán văn phòng phẩm";
        paymentAccountName = "Test Payment Account";

        // Generate thông tin Tour
        pageTourName = "Tour Bình Ba";

        // Generate thông tin part

        startDateTour = "20/10/2020";
        endTDateTour = "30/11/2020";
    }

    @Test
    public void TC01_Newsfeed_Sign_Up_New_Account() {
        log.info("Register with new account");
        log.info("Step 1 - Prepare data for register");
        firstNameUser = data.getFirstName();
        lastNameUser = data.getLastName();
        emailUser = randomVirtualEmail();
        passwordUser = "1234567";
        confirmPassUser = "1234567";

        log.info("Step 2 - Register account with email");
        signUpPage.signUpWithNewAccountByEmail(firstNameUser,lastNameUser,emailUser,passwordUser,confirmPassUser);
        fullName = getFullName(firstNameUser, lastNameUser);
        signUpPage.clickToVerifyAccount();
        newsfeedHomePage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 3. Verify register account successfully");
        verifyTrue(newsfeedHomePage.checkNewsfeedDisplayOnFirstTime());

        log.info("Update account information on first time login");
        log.info("Step 1. Check form Upđate Information display");
        verifyEquals(newsfeedHomePage.getTitleOfFormFirstUpdateInfo(), "Xác minh tài khoản thành công!");
        log.info("Step 2. Repare data for update information");
        String dayBirth = "12";
        String monthBirth = "10";
        String yearBirth = "1992";
        String genderType = "M";
        String nationality = "";
        log.info("Step 3. Update information");
        newsfeedHomePage.updateNewInformationOfAccount(dayBirth,monthBirth,yearBirth,genderType,nationality);
        String birthdayUser = getBirthdayOnHaLo(dayBirth,monthBirth,yearBirth);
        String genderName = newsfeedHomePage.getGenderOfUser(driver,genderType);

        log.info("Verify account information");
        log.info("Step 1. Check fullname display on Widget My account");
        String fullNameOnMyWidget = newsfeedHomePage.getFullNameDisplayOnMyAccount();
        verifyEquals(fullNameOnMyWidget, fullName);
        log.info("Step 2. Go to Personal About Overview");
        newsfeedHomePage.clickToEditProfile();
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);
        log.info("Step 3. Check Personal About Overview page display");
        verifyTrue(perAboutOverviewTab.checkPersonalPageIsDisplay(driver,fullName));
        verifyTrue(perAboutOverviewTab.checkPerAboutOverviewTabIsDisplay());
        verifyTrue(perAboutOverviewTab.checkOverViewTabCaseNewAccount());
        log.info("Step 4. Check email display on introduce widget");
        verifyEquals(perAboutOverviewTab.getEmailIsDisplayOnIntroduceWidget(), emailUser);
        log.info("Step 5. Check birthday display on widget introduce");
        verifyEquals(perAboutOverviewTab.getBirthdayDisplayOnIntroduceWidget(), birthdayUser);
        log.info("Step 6. Check gender display on widget Introduce");
        verifyEquals(perAboutOverviewTab.getGenderDisplayOnIntroduceWidget(), genderName);

        log.info("Update avatar User");
        log.info("Step 1. Check Avatar display default");
        verifyTrue(perAboutOverviewTab.checkAvatarUserDisplayWithGenderType(driver,genderName));
        String avatarBeforeChange = perAboutOverviewTab.getImageURLOfAvatar(driver);
        log.info("Step 2. Update avatar user");
        perAboutOverviewTab.clickToUploadAvatarByLocalImage(driver,avatarUserImage);
        perAboutOverviewTab.crossImage(driver);
        log.info("Step 3. Check user update avatar succesfully");
        verifyFalse(perAboutOverviewTab.checkUploadAvatarUserSuccess(driver,avatarBeforeChange));

        log.info("Update Cover");
        log.info("Step 1. Check Cover image display default");
        verifyTrue(perAboutOverviewTab.checkCoverImageDisplayWithCaseNoImage(driver));
        String coverBeforeChange = perAboutOverviewTab.getImageOfCover(driver);
        log.info("Step 2. Upload cover image");
        perAboutOverviewTab.clickToUploadCoverByLocalImage(driver,coverUserImage);
        perAboutOverviewTab.saveChangeImage(driver);
        log.info("Step 3. Check user update cover succesfully");
        verifyFalse(perAboutOverviewTab.checkCoverImageUploadSuccessfully(driver,coverBeforeChange));

        log.info("Add new workplace");
        log.info("Step 1. Go to Work and Eduction tab");
        perAboutOverviewTab.clickToTabItemOnAbout(driver,"#about_work");
        perAboutWorkEducationTab = PageGeneration.createPerAboutWorkEducationTab(driver);
        log.info("Step 2. Click to Add new workplace");
        verifyTrue(perAboutWorkEducationTab.checkTabIsSelected(driver,"#about_work"));
        perAboutWorkEducationTab.clickButtonToAddNewWorkplace();
        log.info("Step 3. Prepare data");
        String companyName = data.getCompanyName();
        String jobPosition = "Tester";
        String addressCompany = data.getAddress();
        String workplaceDesc = "Manual Testing";
        log.info("Step 4. Check form Add Workplace display");
        verifyTrue(perAboutWorkEducationTab.checkFormAddWorkplaceIsDisplay());
        log.info("Step 5. Enter a Company name");
        perAboutWorkEducationTab.enterDataToCompanyNameOfWorkspace(companyName);
        log.info("Step 6. Enter position");
        perAboutWorkEducationTab.enterDataToPositionOfWorkspace(jobPosition);
        log.info("Step 7. Enter Address company");
        perAboutWorkEducationTab.enterDataToAddressOfWorkspace(addressCompany);
        log.info("Step 8. Enter Workplace description");
        perAboutWorkEducationTab.enterDataToDescriptionOfWorkspace(workplaceDesc);
        log.info("Step 9. Choose option time period");
        perAboutWorkEducationTab.checkOptionTimePeriod();
        log.info("Step 10. Update time range of workplace");
        perAboutWorkEducationTab.chooseStartTimeOfWorkplace("","","");
        log.info("Step 11. Choose scope");
        perAboutWorkEducationTab.chooseScopeOfWorkPlace("");
        log.info("Step 12. Click button save");
        perAboutWorkEducationTab.clickButtonToSaveWorkplace();

        log.info("Check information of workplace");
        log.info("Step 1. Check company name of workplace");
        verifyEquals(perAboutWorkEducationTab.getCompanyOfWorkplace(),companyName;
        log.info("Step 2. Check position of workplace");
        verifyEquals(perAboutWorkEducationTab.getPositionOfWorkplace(),"");
        log.info("Step 3. Check timerange of workplace");
        verifyEquals(perAboutWorkEducationTab.getTimeRangeOfWorkplace(),"");
        log.info("Step 4. Check Address of workplace");
        verifyEquals(perAboutWorkEducationTab.getAddressOfWorkplace(),"");
        log.info("Step 5. Check Scope of workplace");
        verifyEquals(perAboutWorkEducationTab.getScopeOfWorkplace(),"");

        log.info("Add new highschool");
        perAboutWorkEducationTab.clickButtonToAddnewHighschool();

        log.info("Step - Enter a highschool name");
        perAboutWorkEducationTab.enterDataToHighschoolName("");

        log.info("Step - Enter a address of highschool");
        perAboutWorkEducationTab.enterDataToHighschoolAddress("");

        log.info("Step - Enter a description of highschool");
        perAboutWorkEducationTab.enterDataToHighschoolDescription("");

        log.info("Step - Update Time range of Highschool");
        perAboutWorkEducationTab.chooseStartTimeAndEndTimeOfHighschool();

        log.info("Step - Choose scope");
        perAboutWorkEducationTab.chooseScopeOfHighschool("");

        log.info("Step - Click button save");
        perAboutWorkEducationTab.clickButtonToSaveHighSchoolItem();

        log.info("Check information of highschool which have been already existed");
        log.info("Step - Check name of highschool");
        verifyEquals(perAboutWorkEducationTab.getDataNameOfHighschoolDisplay(),"");

        log.info("Step - Check address of highschool");
        verifyEquals(perAboutWorkEducationTab.getAddressDataOfHighschoolDisplay(),"");

        log.info("Step - Check scope of highschool");
        verifyEquals(perAboutWorkEducationTab.getTypeScopeOfHighschoolDisplay(),"");

        log.info("Add new university");
        perAboutWorkEducationTab.clickButtonToAddNewUniveristy();

        log.info("Step - Enter a university name");
        perAboutWorkEducationTab.enterDataToUniveristyNameField("");

        log.info("Step - Enter a address of university");
        perAboutWorkEducationTab.enterDataToUniversityAddressField("");

        log.info("Step - Enter a description of university");

        perAboutWorkEducationTab.enterDataToUniversityDescField("");

        log.info("Step - Update Time range of university");
        perAboutWorkEducationTab.chooseTimeRangeStudyOfUniversity();

        log.info("Step - Choose scope");
        perAboutWorkEducationTab.clickToChooseScopeOfUniversity("");

        log.info("Step - Click button save");
        perAboutWorkEducationTab.clickToButtonToSaveUniversity();

        log.info("Check information of university which have been already existed");
        log.info("Step - Check name of university");
        verifyEquals(perAboutWorkEducationTab.getUniveristyName(),"");

        log.info("Step - Check address of highschool");
        verifyEquals(perAboutWorkEducationTab.getAddressOfUniversity(),"");

        log.info("Step - Check scope of highschool");
        verifyEquals(perAboutWorkEducationTab.getScopeOfUniversity(),"");

        log.info("Step 33. Go to Place you lived");
        perAboutWorkEducationTab.clickToTabItemOnAbout(driver,"#about_location");
        perAboutPlaceYouLivedTab = PageGeneration.createPerAboutPlaceLivingTab(driver);

        log.info("Step 34. Check Tab Place you lived display");
        verifyTrue(perAboutPlaceYouLivedTab.checkDisplayOfPerAboutWithCaseCreateNewAccount());

        log.info("Create Current city");

        log.info("Step 1. Click to Crate new curren city");

        log.info("Step. Enter data to current city");

        log.info("Step. Click Enter for Searching Address");

        log.info("Step. Choose item address on Model");

        log.info("Step. Choose scope of Current city");

        log.info("Step. Click save button");

        log.info("Check information of Current city");
        log.info("Step. Check address of Current city");

        log.info("Step. Check scope of Current city");

        log.info("Create Hometown");

        log.info("Step 1. Click to Crate new Hometown");

        log.info("Step. Enter data to Hometown");

        log.info("Step. Click Enter for Searching Address");

        log.info("Step. Choose item address on Model");

        log.info("Step. Choose scope of Hometown");

        log.info("Step. Click save button");

        log.info("Check information of Hometown");
        log.info("Step. Check address of Hometown");

        log.info("Step. Check scope of Hometown");

        log.info("Go to Basic info and Contact tab");

        log.info("Step - Check Contact and Basic info tab display");

        log.info("Step 38. Check Email display");

        log.info("Step 39. Check Birthday display");

        log.info("Step 40. Check gender display");

        log.info(" Add main phone");
        log.info("Step 1. Click to button Add new phone");
        log.info("Step 2. Enter data to main phone field");

        log.info("Step 3. Click button add other phone");
        log.info("Step 4. Enter data to other phone field");

        log.info("Step 5. Click Save button");

        log.info("Verify phone information");
        log.info("Step 1. Verify main phone display");

        log.info("Step 2. Verify other phone display");

        log.info("Update birthday");
        log.info("Step 1. Click button edit birthday");

        log.info("Step 2. Enter data of Birthday");

        log.info("Step - Choose scope");

        log.info("Step 3. Click Save button");

        log.info("Verify birthday change successdfully");

        log.info("Add new address");
        log.info("Step 1 - Check case no address");

        log.info("Step 2 - Click to add new address");

        log.info("Step 3 - Enter address");

        log.info("Step 3 - Enter city");

        log.info("Step 3 - Enter area code");

        log.info("Step - Click save button");

        log.info("Step - Check address information display");

        log.info("Update gender");
        log.info("Step - Click to edit gender");

        log.info("Step - Choose gender");

        log.info("Step - Choose scope");

        log.info("Step - Click save button");

        log.info("Step - Check gender update successfully");

        log.info("Go to Details about you");

        log.info("Check Detail About you tab is display");

        log.info("Add new introduce");

        log.info("Enter data of introduce");

        log.info("Click Save button");

        log.info("Add other name");

        log.info("Enter data of other name");

        log.info("Click Save button");

        log.info("Step 46. Add new favorite quotes");

        log.info("Enter data of favorite quotes");

        log.info("Click Save button");

        log.info("Step 8.Go to Account setting page");
        perAboutOverviewTab.clickToItemOnSettingMenu(driver, "ic-cog-c");
        generalAccSetting = PageGeneration.createGeneralAccountSettingPage(driver);

        log.info("Step 9.Check Account Setting page display");
        verifyTrue(generalAccSetting.checkAccountGeneralSettingIsDisplay());
        verifyEquals(generalAccSetting.getPageTitle(driver), "Cài đặt tài khoản | Hahalolo");

        log.info("Step 10.Check FullName display");
        verifyEquals(generalAccSetting.getFullNameIsDisplay(), newsfeedHomePage.getFullNameDisplayOnMyAccount());

        log.info("Step . Update full name");

        log.info("Step. Check message display on Username function");

        log.info("Step. Update username");
        log.info("Step. Go to Personal Wall");
        log.info("Step. Check url personal with username link");

    }
//
//    @Test
//    public void TC05_Login_Newsfeed_With_Old_Account() {
//        log.info("Step 1.Check Login newsfeed page");
//        verifyTrue(loginNewsfeedPage.checkAppStoreIconIsDisplay(driver));
//        log.info("Step 2.Enter email address");
//        loginNewsfeedPage.enterUserNameToLogin(driver, "balo_04@mailinator.com");
//        log.info("Step 3.Enter password");
//        loginNewsfeedPage.enterPasswordToLogin(driver, "123456");
//        log.info("Step 4.Click Login button");
//        loginNewsfeedPage.clickToLoginButton(driver);
//        newsfeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
//        log.info("Step 1.Check Newsfeed Homepage display");
//        newsfeedHomePage.checkNewsfeedDisplay();
//    }
//    @Test(enabled = false)
//    public void TC06_Business_Create_New_Business() {
//        log.info("Step 1.Go to business Page");
//        newsfeedHomePage.clickToItemOnSettingMenu(driver, "ic-business-c");
//        businessOverviewPage = PageGeneration.createBusinessOverviewPage(driver);
//        businessOverviewPage.switchWindowByTitle(driver, "Hahalolo - Business Account");
//        log.info("Step 2.Check business overview page with no account");
//        verifyTrue(businessOverviewPage.checkBusinessOverviewWithNewAccount(driver));
//        log.info("Step 3.Click Create new business");
//        businessOverviewPage.clickToCreateNewBusiness(driver);
//        log.info("Step 4.Check popup display");
//        verifyTrue(businessOverviewPage.checkCreateBusinessPopupDisplay());
//        log.info("Step 5.Choose type Enterprise");
//        businessOverviewPage.chooseTypeOfBusiness(driver, "type-business");
//        log.info("Step 6.Enter business name");
//        businessOverviewPage.enterBusinessName(driver, businessName);
//        log.info("Step 7.Update new owner name");
//        businessOverviewPage.enterValueToUpdateOwnerName(driver, ownerName);
//        log.info("Step 8.Update new owner email");
//        businessOverviewPage.enterValueToUpdateBusinessEmail(driver, ownerEmail);
//        log.info("Step 9.Click button finish");
//        businessOverviewPage.clickButtonToCreateBusiness(driver);
//        businessDashboardPage = PageGeneration.createBusinessDashboardPage(driver);
//    }
//    @Test(enabled = false)
//    public void TC07_Business_Send_Enterprise_Verification_Request() {
//        log.info("Step 1.Check new business is created");
////        verifyTrue(businessDashboardPage.checkTitleCreateBusinessSuccess());
//        log.info("Step 2.Check status verification");
//        verifyEquals(businessDashboardPage.getStatusVerifyOfBusiness(), "Xác minh tài khoản kinh doanh của bạn");
//        log.info("Step 3.Click button verify business");
//        businessDashboardPage.clickToVerifyBusiness(driver);
//        businessVerifyPage = PageGeneration.createVerifyBusinessTypeEnterpriseForm(driver);
//        log.info("Step 4.Check Enterprise verification request display success");
//        verifyEquals(businessVerifyPage.getTitleOfFormVerificationRequest(), "XÁC MINH THÔNG TIN KINH DOANH DOANH NGHIỆP");
//        log.info("Step 5.Enter company name");
//        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver, "bv102", companyName);
//        log.info("Step 6.Enter other company name");
//        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver, "bv103", otherCompanyName);
//        log.info("Step 7.Enter Abbreviated company name");
//        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver, "bv104", abbCompanyName);
//        log.info("Step 8.Enter Tax code");
//        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver, "bv105", taxCodeCompany);
//        log.info("Step 9.Choose Registration date");
//        businessVerifyPage.chooseRegistrationDate(driver, "10", "8", "2018");
//        log.info("Step 10.Enter Representative name");
//        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver, "bv107", representativeName);
//        log.info("Step 11.Enter Registration address");
//        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver, "bv110", registrationAddress);
//        log.info("Step 12.Click search Registration address");
//        businessVerifyPage.clickEnterToSearchAddress(driver);
//        log.info("Step 13.Check popup Choose Place display");
//        verifyTrue(businessVerifyPage.checkFormChooseLocationIsDisplay());
//        log.info("Step 14.Choose a place");
//        businessVerifyPage.chooseLocation(driver, "400/8b Ung Văn Khiêm, Phường 25, Bình Thạnh, Thành phố Hồ Chí Minh, Vietnam");
//        log.info("Step 15.Enter zipcode");
//        businessVerifyPage.enterValueToZipCodeField(driver, zipCode);
//        log.info("Step 16.Enter company phone");
//        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver, "bv109", companyPhone);
//        log.info("Step 17.Enter company email");
//        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver, "bv108", companyEmail);
//        log.info("Step 18.Enter business scope");
//        businessVerifyPage.enterValueToBusinessScopeTextarea(driver, businessScope);
//        log.info("Step 19.Upload Business verification papers");
//        businessVerifyPage.clickToUploadDocumentVerify(driver, fileUploadImage2);
//        log.info("Step 20.Click send verify request");
//        businessVerifyPage.clickToSendRequestVerify(driver);
//    }
//    @Test(enabled = false)
//    public void TC08_Business_Check_Business_Info() {
//        log.info("Step 1. Check verificication request has already sent");
//        verifyEquals(businessVerifyPage.getTitleOfFormSendRequestSuccess(driver), "Yêu cầu xác minh doanh nghiệp đã được gửi");
//        log.info("Step 2. Click button to go back Business Management");
//        businessVerifyPage.clickToBackBusinessManagementPage(driver);
//        log.info("Step 3. Check status verification");
//        verifyEquals(businessDashboardPage.getStatusVerifyOfBusiness(), "Đang chờ xác minh thông tin kinh doanh");
//        log.info("Step 4. Go to Business Info");
//        businessDashboardPage.clickItemOnBusinessNavMenu(driver, "menu-settings-info");
//        businessInfoPage = PageGeneration.createBusinessInfoPage(driver);
//        log.info("Step 5. Check display of Businessi info page");
//        verifyTrue(businessInfoPage.checkBusinessInfoPageIsDisplay());
//        log.info("Step 6. Check owner name display success");
//        verifyEquals(businessInfoPage.getOwnerNameIsDisplay(driver), ownerName);
//        log.info("Step 7. Check owner email display success");
//        verifyEquals(businessInfoPage.getOwnerEmailIsDisplay(driver), ownerEmail);
//    }
//    @Test(enabled = false)
//    public void TC09_Backend_Confirm_Business_Verification() {
//        log.info("Step 1. Go to Backend Login");
//        businessInfoPage.openURL(driver, GlobalVariables.backendURL);
//        loginNewsfeedPage = PageGeneration.createLoginBackEndPage(driver);
//        log.info("Step 2. Check Backend Login display");
//        verifyTrue(loginNewsfeedPage.checkBackendLoginPageDisplay());
//        log.info("Step 3. Enter admin account");
//        loginNewsfeedPage.enterUserNameToLogin(driver, GlobalVariables.ADMIN_ACCOUNT);
//        log.info("Step 4. Enter admin password");
//        loginNewsfeedPage.enterPasswordToLogin(driver, GlobalVariables.ADMIN_PASSWORD);
//        log.info("Step 5. Enter captcha code");
//        loginNewsfeedPage.enterCaptchaCodeToLogin(driver, "");
//        setTimeDelay(15);
//        log.info("Step 6. Click Login button");
//        loginNewsfeedPage.clickToLoginButton(driver);
//        backendHomePage = PageGeneration.createBackendHomepage(driver);
//        setTimeDelay(2);
//        log.info("Step 7.Check Backend homepage display");
//        verifyTrue(backendHomePage.checkBusinessHomePageIsDisplaySuccess());
//        log.info("Step 8. Change language system to Vi");
//        backendHomePage.changeLanguageOfSystemToVi(driver);
//        log.info("Step 9. Go to business verification management");
//        backendHomePage.clickToItemOnNavbarMenu(driver, "Xác minh doanh nghiệp");
//        verifyBusinessManagementPage = PageGeneration.createVerifyBusinessManagement(driver);
//        log.info("Step 10. Check Business verification management page display");
//        verifyTrue(verifyBusinessManagementPage.checkPageIsDisplaySuccess());
//        log.info("Step 11. Enter keyword for searching");
//        verifyBusinessManagementPage.enterEmailBusinessForSearch(driver, ownerEmail);
//        log.info("Step 12. Choose start date");
//        verifyBusinessManagementPage.chooseStartDateForFilter(driver, getToday());
//        log.info("Step 13. Choose end date");
//        verifyBusinessManagementPage.chooseEndDateForFilter(driver, getToday());
//        log.info("Step 14. Choose business type");
//        verifyBusinessManagementPage.chooseTypeBusiness(driver, "Doanh nghiệp");
//        log.info("Step 15. Choose status verification");
//        verifyBusinessManagementPage.chooseStatusVerification(driver, "Đang chờ xác minh");
//        log.info("Step 16. Click button Filter");
//        verifyBusinessManagementPage.clickToFilterButton(driver);
//        log.info("Step 17. Check business display correct with filter");
//
//        log.info("Step 18. Click button Verify for redirect business");
//        verifyBusinessManagementPage.clickVerifyButton(driver, businessName, ownerName, ownerEmail);
//        log.info("Step 19. Check popup Confirm verification business display");
//        verifyTrue(verifyBusinessManagementPage.checkConfirmPopupDisplay(driver));
//        log.info("Step 20. Click button confirm");
//        verifyBusinessManagementPage.clickConfirmButtonOnPopup(driver);
//        log.info("Step 21. Check business verify success");
//        verifyEquals(verifyBusinessManagementPage.getStatusOfBusinessVerification(driver, businessName, ownerName, ownerEmail), "Đã xác minh");
//    }
//    @Test(enabled = false)
//    public void TC10_Wallet_Create_Payment_Account_Type_Business() {
//        log.info("Step 1. Go to Login Wallet");
//        loginNewsfeedPage.negativeToURLByJS(driver, GlobalVariables.walletURL);
//        loginNewsfeedPage = PageGeneration.createWalletLoginPage(driver);
//        log.info("Step 2. Check Login wallet page display");
//        verifyTrue(loginNewsfeedPage.checkWalletLoginPageIsDisplay());
//        log.info("Step 3. Enter email address");
//        loginNewsfeedPage.enterUserNameToLogin(driver, emailUser);
//        log.info("Step 4. Enter password");
//        loginNewsfeedPage.enterPasswordToLogin(driver, passwordUser);
//        log.info("Step 5. Enter captcha code");
//        loginNewsfeedPage.enterCaptchaCodeToLogin(driver, "");
//        setTimeDelay(15);
//        log.info("Step 6.Click Login button");
//        loginNewsfeedPage.clickToLoginButton(driver);
//        walletOverviewPage = PageGeneration.createWalletOverviewPage(driver);
//        log.info("Step 7 Check Wallet overview page display success");
//        verifyTrue(walletOverviewPage.checkPageIsDisplayedSuccessfully());
//        log.info("Step 8. Click button Create payment account");
//        walletOverviewPage.clickCreateBusinessPaymentAccount(driver);
//        log.info("Step 9. Check popup Create new business display");
//        verifyTrue(walletOverviewPage.checkCreatePaymentAccountPopupIsDisplay());
//        log.info("Step 10. Enter payment account name");
//        walletOverviewPage.enterPaymentAccountName(driver, paymentAccountName);
//        log.info("Step 11. Choose currency");
//        walletOverviewPage.chooseCurrencyOfAccount(driver, "VND - Vietnamese Dong");
//        log.info("Step 12. Click button Finish to create payment account");
//        walletOverviewPage.clickToFinishButton(driver);
//        walletHomePage = PageGeneration.createWalletHomepage(driver);
//        log.info("Step 13. Check Wallet homepage display success");
//        verifyTrue(walletHomePage.checkBusinessPaymentAccountPageDisplay());
//        log.info("Step 14.Check payment Account is created successfully");
//        verifyEquals(walletHomePage.getPaymentAccName(), paymentAccountName);
//    }
//    @Test(enabled = false)
//    public void TC11_Business_Create_Page_Tour_With_Case_New() {
//        log.info("Step 1. Back to Business page");
//        loginNewsfeedPage.openURL(driver, GlobalVariables.businessURL);
//        businessOverviewPage = PageGeneration.createBusinessOverviewPage(driver);
//        log.info("Step 2. Check Overview Business page display");
//        verifyTrue(businessOverviewPage.checkOverViewPageWithHaveBusiness());
//        log.info("Step 3. Click to button Business Management");
//        businessOverviewPage.clickToAccountManagementButton(driver);
//        businessDashboardPage = PageGeneration.createBusinessDashboardPage(driver);
//        log.info("Step 4. Check Dashboard Business page display success");
//        verifyTrue(businessDashboardPage.checkPageIsDisplaySuccessfully());
//        log.info("Step 5. Check verify business status");
//        verifyEquals(businessDashboardPage.getStatusVerifyOfBusiness(), "Thông tin kinh doanh");
//        log.info("Step 6. Check business have no page");
//        verifyEquals(businessDashboardPage.getContentTitleOfSectionNoPage(), "Tạo trang đầu tiên của bạn");
//        log.info("Step 7. Click button Create page now");
//        businessDashboardPage.clickCreatePageNowButton();
//        businessPageList = PageGeneration.openCreatePagePopup(driver);
//        log.info("Step 8. Check Create new page popup display");
//        verifyTrue(businessPageList.checkPopupCreatePageDisplay());
//        log.info("Step 9. Choose page type");
//        businessPageList.choosePageType(driver, "H001");
//        log.info("Step 10. Enter page name");
//        businessPageList.enterPageNameToCreate(driver, pageTourName);
//        log.info("Step 11. Click button to create page");
//        businessPageList.clickToCreatePage(driver);
//        log.info("Step 12. Go to BusiPage Management");
//        businessPageList.clickItemOnBusinessNavMenu(driver, "menu-settings-pages");
//        log.info("Step 13. Check Business page managemennt display");
//        verifyTrue(businessPageList.checkPageDisplaySuccess(driver));
//        log.info("Step 14. Check page have been created successfully");
//        verifyTrue(businessPageList.checkCreatedPageSuccess(driver, pageTourName));
//        log.info("Step 15. Verify page information");
//        verifyEquals(businessPageList.getOwnerOfDirectPage(driver, pageTourName), emailUser);
//        String pageID = businessPageList.getPageIdOfDirectPage(driver, pageTourName);
//        log.info("Step 16. Go to Tour Dashboard");
//        businessPageList.clickPageManagementLinkToGoDetail(driver, pageTourName);
//        tourDashboardPage = PageGeneration.createTourDashboardPage(driver);
//    }
//    @Test
//    public void TC12_Business_Create_New_Page_Tour() {
//        log.info("Step 1. Back to Business page");
//        loginNewsfeedPage.openURL(driver, GlobalVariables.businessURL);
//        businessOverviewPage = PageGeneration.createBusinessOverviewPage(driver);
//        log.info("Step 2. Check Overview Business page display");
//        verifyTrue(businessOverviewPage.checkOverViewPageWithHaveBusiness());
//        log.info("Step 3. Click to button Business Management");
//        businessOverviewPage.clickToAccountManagementButton(driver);
//        businessDashboardPage = PageGeneration.createBusinessDashboardPage(driver);
//        log.info("Step 4. Check Dashboard Business page display success");
//        verifyTrue(businessDashboardPage.checkPageIsDisplaySuccessfully());
//        log.info("Step 5. Check verify business status");
//        verifyEquals(businessDashboardPage.getStatusVerifyOfBusiness(), "Thông tin kinh doanh");
//        businessDashboardPage.clickItemOnBusinessNavMenu(driver, "menu-settings-pages");
//        businessPageList = PageGeneration.goToPageListManagement(driver);
//        log.info("Step 5. Click button Create Page");
//        businessPageList.clickToCreatePageToDisplayPopupCreatePage();
//        log.info("Step 8. Check Create new page popup display");
//        verifyTrue(businessPageList.checkPopupCreatePageDisplay());
//        log.info("Step 9. Choose page type");
//        businessPageList.choosePageType(driver, "H001");
//        log.info("Step 10. Enter page name");
//        businessPageList.enterPageNameToCreate(driver, pageTourName);
//        log.info("Step 11. Click button to create page");
//        businessPageList.clickToCreatePage(driver);
//        log.info("Step 16. Go to Tour Dashboard");
//        businessPageList.clickPageManagementLinkToGoDetail(driver, pageTourName);
//        tourDashboardPage = PageGeneration.createTourDashboardPage(driver);
//    }
//    @Test
//    public void TC13_Tour_Update_Prepayment_Cancellation_On_General_Information() {
//        log.info("Step 1. Check Tour Dashboard page display");
//        verifyTrue(tourDashboardPage.checkPageIsDisplay(driver, pageTourName));
//        log.info("Step 2. Click to Setting General");
//        tourDashboardPage.clickItemOnTourNavMenu(driver, "Thông tin");
//        tourGeneralSettingPage = PageGeneration.createTourGeneralSettingPage(driver);
//        log.info("Step 3.Check Prepaymend And Cancellation policy display");
//        verifyTrue(tourGeneralSettingPage.checkTabPrepaymentAmountDisplay());
//        log.info("Step 4. Enter Prepayment amount");
//        tourGeneralSettingPage.enterDataValueToTextFieldOnPrepaymentTab(driver, "sn305", "10");
//        log.info("Step 5. Enter Cancellation amount");
//        tourGeneralSettingPage.enterDataValueToTextFieldOnPrepaymentTab(driver, "sn306", "5");
//        log.info("Step 6. Enter Day allow cancellation");
//        tourGeneralSettingPage.enterDataValueToTextFieldOnPrepaymentTab(driver, "sn307", "1");
//        log.info("Step 7. Click save button");
//        tourGeneralSettingPage.clickToSaveButton(driver);
//    }
//    @Test
//    public void TC14_Tour_Update_VAT_On_General_Information() {
//        log.info("Step 1. Click Setting VAT");
//        tourGeneralSettingPage.clickToItemOnTourInformationNav(driver, "vat");
//        log.info("Step 2. Check Setting VAT tab display");
//        verifyTrue(tourGeneralSettingPage.checkVATSettingPageDisplay(driver));
//        log.info("Step 3. Choose option VAT");
//        tourGeneralSettingPage.chooseOptionVATInclude(driver);
//        log.info("Step 4. Click to save button");
//        tourGeneralSettingPage.clickToSaveButton(driver);
//    }
//    @Test
//    public void TC15_Tour_Update_Age_On_General_Information() {
//        log.info("Step 1. Click to Age setting");
//        tourGeneralSettingPage.clickToItemOnTourInformationNav(driver, "age");
//        log.info("Step 2. Check Age setting tab display");
//        verifyTrue(tourGeneralSettingPage.checkAgeSettingPageDisplay(driver));
//        log.info("Step 3. Enter Adult age");
//        tourGeneralSettingPage.enterDataValueToTextFieldOnAgeSettingTab(driver, "sn351", "12");
//        log.info("Step 4. Enter Child age");
//        tourGeneralSettingPage.enterDataValueToTextFieldOnAgeSettingTab(driver, "sn352", "6");
//        log.info("Step 5. Enter Young Child age");
//        tourGeneralSettingPage.enterDataValueToTextFieldOnAgeSettingTab(driver, "sn354", "2");
//        log.info("Step 6. Click to save button");
//        tourGeneralSettingPage.clickToSaveButton(driver);
//    }
//    @Test
//    public void TC16_Tour_Update_Notice_Order_On_General_Information() {
//        log.info("Step 1. Click Noti order setting");
//        tourGeneralSettingPage.clickToItemOnTourInformationNav(driver, "mail");
//        log.info("Step 2.Check  Noti order tab display");
//        verifyTrue(tourGeneralSettingPage.checkNotiForOrderSettingPageDisplay(driver));
//        log.info("Step 3. Enable setting");
//        tourGeneralSettingPage.clickToEnableMode(driver);
//        log.info("Step 4. Enter email");
//        tourGeneralSettingPage.enterDataValueToTextFieldOnNotiOrder(driver, "sv453", ownerEmail);
//        log.info("Step 5. Enter phone");
//        tourGeneralSettingPage.enterDataValueToTextFieldOnNotiOrder(driver, "sv454", ownerPhone);
//        log.info("Step 6. Click button save");
//        tourGeneralSettingPage.clickToSaveButton(driver);
//    }
//    @Test
//    public void TC17_Tour_Publish_Page() {
//        log.info("Step 1. Go to Setting Page");
//        tourGeneralSettingPage.clickItemOnTourNavMenu(driver,"Tổng quan");
//        pubishPage = PageGeneration.createPageSetting(driver);
//        log.info("Step 2. Check General setting page display");
//        verifyTrue(pubishPage.checkPublishPageIsDisplay(driver));
//        log.info("Step 4. Publish Tour Page");
//        pubishPage.publishPage(driver);
//        log.info("Step 5. Check status publish page");
//        verifyTrue(pubishPage.checkStatusOfPage(driver));
//    }
//    @Test
//    public void TC18_Tour_Create_New_Topic() {
//        log.info("Step 1. Go to Topic page");
//        pubishPage.clickItemOnTourNavMenu(driver, "Chủ đề");
//        tourTopicPage = PageGeneration.createTourTopicListPage(driver);
//        log.info("Step 2. Check Topic page case no topic");
//        verifyTrue(tourTopicPage.checkPageWithCaseNoTopicDisplay());
//        log.info("Step 3. Click create topic");
//        tourTopicPage.clickCreateTopic(driver);
//        log.info("Step 4. Check popup Create topic display");
//        verifyTrue(tourTopicPage.checkPopupCreateTopicDisplay());
//        log.info("Step 5. Choose topic image");
//        tourTopicPage.chooseTopicImage(driver, fileUploadImage2);
//        log.info("Step 6. Choose topic language");
//        tourTopicPage.chooseLanguageOfTopic(driver, "vi");
//        log.info("Step 7. Enter topic name");
//        topicName = "Tháng 1";
//        tourTopicPage.enterTopicName(driver, topicName);
//        log.info("Step 8. Enter topic description");
//        tourTopicPage.enterTopicDescription(driver, "Topic description");
//        log.info("Step 9. Click Save Button");
//        tourTopicPage.clickToSaveButton(driver);
//        log.info("Step 10. Verify topic have been created successfully");
//        verifyTrue(tourTopicPage.checkCreatedTopicDisplay(driver));
//    }
//    @Test
//    public void TC19_Tour_Create_New_Tour() {
//        log.info("Step 1. Go to Tour management");
//        tourTopicPage.clickItemOnTourNavMenu(driver, "Tours");
//        tourManagementPage = PageGeneration.createTourManagementPage(driver);
//        log.info("Step 2. Check Tour management with case no Tour");
//        verifyTrue(tourManagementPage.checkPageWithCaseNoTourDisplay());
//        // Get language system
//        languageOnTourPage = tourManagementPage.getLanguageDefaultDsiplayOnFilterLang(driver);
//        log.info("Step 3. Click button create tour");
//        tourManagementPage.clickStartCreateTourButtonOnCenterListPage(driver);
//        log.info("Step 4. Check popup Create tour display");
//        verifyTrue(tourManagementPage.checkPopupCreateTourDisplay());
//        log.info("Step 5. Enter tour name");
//        tourName = "Tour Vũng tàu - Phan thiết";
//        tourManagementPage.enterValueOfTourName(driver, tourName);
//        log.info("Step 6. Choose tour type");
//        tourManagementPage.chooseTourType(driver, "Tour nội địa");
//        log.info("Step 7. Choose tour topic");
//        tourManagementPage.chooseTourTopic(driver, topicName);
//        log.info("Step 8. Click Create button");
//        tourManagementPage.clickToButtonSaveOnPopup(driver);
//        tourInfoTab = PageGeneration.createTourInfoTab(driver);
//    }
//    @Test
//    public void TC20_Tour_Detail_Update_Information() {
//        log.info("Step 1. Check Tab Tour of Tour Detail display");
//        verifyTrue(tourInfoTab.checkTourInfoTabDisplay());
//
//        log.info("Step 2. Choose Vietnamese language");
//        tourInfoTab.chooseLanguage(driver, "Tiếng Việt");
//
//        log.info("Step 3. Choose Vietnamese language");
//        tourInfoTab.choooseCurrency(driver, "VND");
//
//        log.info("Step 4. Enter sku code");
//        String skuTour = "HKTT_101";
//        tourInfoTab.enterValueToDynamicField(driver, "tv102", skuTour);
//
//        log.info("Step 5. Enter Total day");
//        String totalDayTour = "1";
//        tourInfoTab.enterValueToDynamicField(driver, "tn123", totalDayTour);
//
//        log.info("Step 6. Enter Basic Price");
//        String basicPriceTour = "1000000";
//        tourInfoTab.enterValueToDynamicField(driver, "tn133", basicPriceTour);
//
//        log.info("Step 7. Enter Allow booking date");
//        String allowBookingDateTour = "2";
//        tourInfoTab.enterValueToDynamicField(driver, "tn130", allowBookingDateTour);
//
//        log.info("Step 8. Enter Tour Address");
//        String addressTour = "400 Điện Biên Phủ P25, Quận Bình Thạnh";
//        tourInfoTab.enterValueToDynamicField(driver, "address", addressTour);
//
//        log.info("Step 9. Choose country");
//        tourInfoTab.chooseItemToUpdateLocation(driver, "country", "Vietnam");
//
//        log.info("Step 10. Choose City/State");
//        tourInfoTab.chooseItemToUpdateLocation(driver, "city", "Ho Chi Minh City");
//
//        log.info("Step 11. Choose District/ County");
//        tourInfoTab.chooseItemToUpdateLocation(driver, "region", "Quận Bình Thạnh");
//
//        log.info("Step 12. Enter Short description");
//        String shortDescTour = "Test Mô tả ngắn của tour";
//        tourInfoTab.enterValueOfShortDesc(driver, shortDescTour);
//
//        log.info("Step 13. Enter Private regulations");
//        String privateRegulTour = "Quy đinh riêng";
//        tourInfoTab.enterValueOfTourToDynamicSummerNoteOnInformationTab(driver, "tv152", privateRegulTour);
//
//        log.info("Step 14. Enter Policy");
//        String policyTour = "Chính sách Tour";
//        tourInfoTab.enterValueOfTourToDynamicSummerNoteOnInformationTab(driver, "tv153", policyTour);
//
//        log.info("Step 15. Enter Installment policy");
//        String policyInstallmentTour = "Chính sách trả góp";
//        tourInfoTab.enterValueOfTourToDynamicSummerNoteOnInformationTab(driver, "tv155", policyInstallmentTour);
//
//        log.info("Step 16. Choose Tour Logo");
//        String logoTour = "tourLogo.jpg";
//        tourInfoTab.updateLogo(driver, logoTour);
//
//        log.info("Step 17. Choose Tour Cover");
//        String coverTour = "tourCover.jpg";
//        tourInfoTab.updateCover(driver, coverTour);
//
//        log.info("Step 18 .Choose Tour Gallery");
//        String galleryTourImage1 = "galleryTour1.jpg";
//        String galleryTourImage2 = "galleryTour2.jpg";
//        String galleryTourImage3 = "galleryTour3.jpg";
//        tourInfoTab.updateTourGallery(driver, galleryTourImage1,galleryTourImage2,galleryTourImage3);
//
//        log.info("Step 19. Click to Save Tour button");
//        tourInfoTab.clickToButtonSaveTour();
//    }
//    @Test
//    public void TC21_Tour_Detail_Create_New_Part() {
//        log.info("Step 1. Click to Part");
//        tourInfoTab.clickToItemOfNavigationMenu(driver, "#tour-parts");
//        tourPartTab = PageGeneration.createTourPartTab(driver);
//
//        log.info("Step 2. Check Part tab display");
//        verifyTrue(tourPartTab.checkPartTabDisplaySuccess());
//
//        log.info("Step 3. Check Tour Part not have part");
//        verifyTrue(tourPartTab.checkPartTabDisplaySuccess());
//
//        log.info("Step 3. Click to create new part");
//        tourPartTab.clickToCreateNewPartButton();
//
//        log.info("Step 3. Check Part Detail display");
//        verifyTrue(tourPartTab.checkPartDetailDisplay());
//
//        log.info("Step 4. Enter part name");
//        partName = "Sài Gòn - Đà Nẵng";
//        tourPartTab.enterValueToDynamicFieldOnPartTab(driver, "tv302", partName);
//
//        log.info("Step 5. Enter day of part");
//        partDay = "1";
//        tourPartTab.enterValueToDynamicFieldOnPartTab(driver, "tn305", partDay);
//
//        log.info("Step 6. Enter part time");
//        partTime = "12:00";
//        tourPartTab.enterValueToDynamicFieldOnPartTab(driver, "tv306", partTime);
//
//        log.info("Step 7. Enter part address");
//        partAddress = "400A Điện biên phủ , Bình Thạnh ";
//        tourPartTab.enterValueToDynamicFieldOnPartTab(driver, "address", partAddress);
//
//        log.info("Step 8. Choose Country");
//        tourPartTab.chooseItemToUpdateLocation(driver, "country", "Vietnam");
//
//        log.info("Step 9. Choose City/state");
//        tourPartTab.chooseItemToUpdateLocation(driver, "city", "Ho Chi Minh City");
//
//        log.info("Step 9. Choose District/ County");
//        tourPartTab.chooseItemToUpdateLocation(driver, "region", "Quận Bình Thạnh");
//
//        log.info("Step 9. Enter part description");
//        partDesc = "Hồ chí minh xứ sở của những dramma bật nhất VN";
//        tourPartTab.enterValueToShortDescription(driver, partDesc);
//
//        log.info("Step 12. Choose transport item");
//        tourPartTab.chooseNewTransportItem(driver, "car");
//
//        log.info("Step 13. Update Part Logo");
//        String partLogo = "partTour.jpg";
//        tourPartTab.choosePartLogo(driver, partLogo);
//
//        log.info("Step 14. Click button Save Part");
//        tourPartTab.clickToButtonSavePart(driver);
//
//        log.info("Step 15. Check part have been created successfully");
//        verifyTrue(tourPartTab.checkPartHasBeenCreatedSuccessfully());
//    }
//    @Test
//    public void TC22_Tour_Detail_Create_New_Price() {
//        log.info("Step 1. Go to price tab");
//        tourPartTab.clickToItemOfNavigationMenu(driver, "#tour-prices");
//        tourPriceTab = PageGeneration.createTourPriceTab(driver);
//
//        log.info("Step 2. Check Price tab display");
//        verifyTrue(tourPriceTab.checkPriceTabDisplaySuccess());
//
//        log.info("Step 3. Click to button Create new price");
//        tourPriceTab.clickToCreateNewPrice(driver);
//
//        log.info("Step 4. Check Price tab display");
//        verifyTrue(tourPriceTab.checkPriceDetailIsDisplay());
//
//        log.info("Step 5. Choose start date");
//        tourPriceTab.chooseStartDateOfPrice(driver, startDateTour);
//
//        log.info("Step 6. Enter adult price");
//        tourPriceTab.enterValueOfAdultPrice(driver, "300000");
//
//        log.info("Step 7. Enter child prirce");
//        tourPriceTab.enterValueOfChildPrice(driver, "250000");
//
//        log.info("Step 8. Enter young child price");
//        tourPriceTab.enterValueOfYoungChildPrice(driver, "100000");
//
//        log.info("Step 8. Enter infant price");
//        tourPriceTab.enterValueOfInfantPrice(driver, "50000");
//
//        log.info("Step 8. Click to save pricel");
//        tourPriceTab.clickToSavePriceButton(driver);
//
//        log.info("Step 15. Check price have been created successfully");
//        verifyTrue(tourPriceTab.checkPriceCreatedSuccessfully());
//    }
//    @Test
//    public void TC23_Tour_Detail_Choose_Date_For_Open_Sale_Tour() {
//        log.info("Step 1. Go to price tab");
//        tourPartTab.clickToItemOfNavigationMenu(driver, "#tour-schedulers");
//        tourSchedulerTab = PageGeneration.createTourSchedulerTab(driver);
//
//        log.info("Step 2. Check Scheduler tab display");
//        verifyTrue(tourSchedulerTab.checkSchedulerTabDisplaySuccess());
//        log.info("Step 4. Choose End Date");
//        tourSchedulerTab.chooseEndDate(driver, endTDateTour);
//
//        log.info("Step 3. Choose start Date");
//        tourSchedulerTab.chooseStartDate(driver,startDateTour);
//
//        log.info("Step 5. Click button setting");
//        tourSchedulerTab.scrollToTopPage(driver);
//        tourSchedulerTab.clickButtonSetting(driver);
//    }
//    @Test
//    public void TC24_Tour_Detail_Update_Services_Provided() {
//        log.info("Step 1. Go to Tour services tab");
//        tourSchedulerTab.clickToItemOfNavigationMenu(driver, "#tour-services");
//        tourServiceTab = PageGeneration.createTourServiceTab(driver);
//
//        log.info("Step 2. Check Tour services tab display");
//        verifyTrue(tourServiceTab.checkTourServiceTabDisplaySuccess());
//
//        log.info("Step 3. Choose Tour services");
//        tourServiceTab.addServicesApply(driver,2);
//
//        log.info("Step 4. Click button setting");
//
//        tourServiceTab.clickUpdateButton(driver);
////        log.info("Step 5. Check service is added");
////        tourServiceTab.checkHaloTourIsAdded(driver);
//    }
//    @Test(enabled = false)
//    public void TC25_Tour_Detail_Create_New_Promotion_Apply() {
//        log.info("Step 1. Go to Tour promotion tab");
//        tourServiceTab.clickToItemOfNavigationMenu(driver, "#tour-promotions");
//        tourPromoTab = PageGeneration.createTourPromotionTab(driver);
//
//        log.info("Step 2. Check Tour promotion tab display");
//        verifyTrue(tourPromoTab.checkPromotionTabDislay());
//
//        log.info("Step 3. Check no Promotion apply on Tour");
//        verifyEquals(tourPromoTab.getMessageNotFoundPromo(), "Không tìm thấy dữ liệu.");
//
//        log.info("Step 4. Click Create promotion button");
//        tourPromoTab.clickToCreatePromotionButton();
//        tourPromotionPage = PageGeneration.goToCreateEditPromotionPage(driver);
//        tourPromotionPage.switchWindowByTitle(driver, "Hahalolo - Tour Create Promotion");
//
//        log.info("Step 5. Enter promotion name");
//        promoName = "Khuyến mãi mùa 1";
//        tourPromotionPage.enterPromoName(driver, promoName);
//
//        log.info("Step 6. Enter promotion desc");
//        promoDesc = "Khuyến mãi ưu đãi lớn cho người thuộc lứa tuổi học sinh - sinh viên";
//        tourPromotionPage.enterPromoDesc(driver, promoDesc);
//
//        log.info("Step 7. Choose language promotion");
//        promoLang = "Tiếng Việt";
//        tourPromotionPage.chooseLanguagePromotion(driver, promoLang);
//
//        log.info("Step 8. Choose currency promotion");
//        promoCurrency = "VND";
//         tourPromotionPage.chooseCurrencyPromotion(driver, promoCurrency);
//
//        log.info("Step 9. Add promotion image");
//        promoImage = "promoImage.jpg";
//        tourPromotionPage.clickAddImagePromo(driver, promoImage);
//
////        log.info("Step 10. Choose promotion time range");
////        promoTimeApplied = "12-10-202020-10-2021";
////        tourPromotionPage.enterDateRangeApply(driver, promoTimeApplied);
//        setTimeDelay(15);
//
//        log.info("Step 11. Choose Promotion type based on order total");
//        tourPromotionPage.chooseTypePromo(driver, 1);
//        typeDiscount = tourPromotionPage.getTextOfDiscountType(driver,1 );
//
//        log.info("Step 12. Choose promotion type is Fixed amount");
//        tourPromotionPage.chooseTypeDiscount(driver, 1);
//        typePromo = tourPromotionPage.getTextOfPromoType(driver,1 );
//
//        log.info("Step 13. Enter discount value");
//        discountValue1 = "400000";
//        tourPromotionPage.enterDiscountAmount(driver, discountValue1);
//
//        log.info("Step 14. Enter min order value");
//        minOrderValue1 = "50000000";
//        tourPromotionPage.enterMinOrderValue(driver, minOrderValue1);
//
////        log.info("Step 15. Choose sample mode");
////        tourPromotionPage.chooseModeSimple(driver);
//
//        log.info("Step 16. Choose Tour apply promotion");
//        tourPromotionPage.clickIconAddTourToSelectedList(driver, tourName);
//
//        log.info("Step 17. Publish promotion");
//        tourPromotionPage.publicPromotion(driver);
//
//        log.info("Step 18. Click button Save");
//        tourPromotionPage.clickSaveButton(driver);
//    }
//    @Test(enabled = false)
//    public void TC26_Tour_Detail_Check_Promotion_Detail() {
//        log.info("Step 1. Check detail promotion");
//        viewDetailPromoPage = PageGeneration.createViewDetailPromoPage(driver);
//        verifyTrue(viewDetailPromoPage.checkViewDetailPromotionDisplay());
//
//        log.info("Step 2. Check Promotion Name");
//        verifyEquals(viewDetailPromoPage.getPromoNameOnDetail(),promoName);
//
//        log.info("Step 3. Check Promotion Description");
//        verifyEquals(viewDetailPromoPage.getPromoDescOnDetail(),promoDesc);
//
//        log.info("Step 4. Check Promotion status");
//        verifyEquals(viewDetailPromoPage.getStatusOnDetail(),promoStatus);
//
//        log.info("Step 5. Check Promotion language");
//        verifyEquals(viewDetailPromoPage.getLanguageOnDetail(),promoLang);
//
//        log.info("Step 6. Check Promotioncurrency");
//        verifyEquals(viewDetailPromoPage.getCurrencyOnDetail(),promoCurrency);
//
//        log.info("Step 7. Check Promotion Time Applied");
//        verifyEquals(viewDetailPromoPage.getDateRangeOnDetail(),promoTimeApplied);
//
//        log.info("Step 8. Check Promotion discount type");
//        verifyEquals(viewDetailPromoPage.geDiscountTypeOnDetail(),typeDiscount);
//
//        log.info("Step 9. Check Promotion type");
//        verifyEquals(viewDetailPromoPage.getPromoTypeOnDetail(),typeDiscount);
////
////        log.info("Step 10. Check Applied tour type");
////        verifyEquals(viewDetailPromoPage.getTourTypeAppliedOnDetail(),"");
////
////        log.info("Step 11. Check Applied tour applied");
////        verifyEquals(viewDetailPromoPage.getListTourAppliedOnPromoDetail(),"");
////
////        log.info("Step 12. Check Min order value and discount amount display");
////        verifyTrue(tourPromotionPage.getPromotionDisountLevel());
//    }
//    @Test(enabled = false)
//    public void TC26_Tour_Detail_Create_Service_Price() {
//        log.info("Step 1. Go to Tour Managment");
//        tourServiceTab.clickItemOnTourNavMenu(driver,"Tours");
//        tourManagementPage = PageGeneration.createTourManagementPage(driver);
//        log.info("Step 2. Check Tour Managerment display");
//        verifyTrue(tourManagementPage.checkPageWithCaseHaveTourDisplay(driver));
//        log.info("Step 3. Click to View detail for tour");
//        tourManagementPage.clickEditButtonOfDirectTour(driver);
//        tourInfoTab = PageGeneration.createTourInfoTab(driver);
//        log.info("Step 4. Check tour detail display");
//        tourInfoTab.checkTourInfoTabDisplay();
//        log.info("Step 1. Click to Service price");
//        tourInfoTab.clickItemOnTourNavMenu(driver,"#tour-service-price");
//        tourServicePriceTab = PageGeneration.createTourServicePriceTab(driver);
//        log.info("Step 2. Check Service price display");
//        verifyTrue(tourServicePriceTab.checkTourServicePriceTab(driver));
//        log.info("Step 3. Click button Adđ service price");
//        tourServicePriceTab.clickButtonCreateNewPrice();
//        log.info("Step 4. Input service price");
//        tourServicePriceTab.enterPriceOfService(driver,"300000");
//        log.info("Step 5. Chooose service ");
//        tourServicePriceTab.choooseServiceOnDropdown();
//        log.info("Step 6. Click save price service ");
//        tourServicePriceTab.choooseServiceOnDropdown();
//    }
//    @Test
//    public void TC27_Tour_Detail_Publish_Tour() {
//        log.info("Step 1. Click to Setting page");
//        tourServiceTab.clickToItemOfNavigationMenu(driver,"#tour-settings");
//        tourSettingTab = PageGeneration.createTourSettingTab(driver);
//        log.info("Step 2. Check Setting Tour display");
//        verifyTrue(tourSettingTab.checkSettingTourPageDisplay(driver));
//        log.info("Step 3. Click to publish Tour");
//        tourSettingTab.publishTour();
//        log.info("Step 4. Click button Save");
//        tourSettingTab.clickToSaveButton();
//        log.info("Step 5. Verify Tour is published");
//        verifyTrue(tourSettingTab.checkSettingTourPageDisplay(driver));
//    }
//    @Test
//    public void TC28_Tour_Detail_View_Page_On_Newsfeed() {
//        log.info("Step 1. Go back to Tour");
//        tourSettingTab.clickToBackTourManagement(driver);
//        tourManagementPage = PageGeneration.createTourManagementPage(driver);
////        log.info("Step 2. Check Tour management page display");
////        verifyTrue(tourManagementPage.checkPageWithCaseHaveTourDisplay(driver));
//        log.info("Step 3. Click to view detail Tour");
//        tourManagementPage.clickTOViewDetailOfDirectTour(driver, tourName);
//        tourDetailForBooking = PageGeneration.createTourDetailBookingPage(driver);
//        System.out.println(tourName + " | Chi tiết tour - Page Wall | Hahalolo");
//        tourDetailForBooking.switchWindowByTitle(driver,tourName + " | Chi tiết tour - Page Wall | Hahalolo");
//        log.info("Step 4. Check Tour Detail Booking page display");
//        verifyTrue(tourDetailForBooking.checkTourDetailBookingPageIsDisplay());
//        linkPaymentTour = tourDetailForBooking.getCurrentURL(driver);
//        System.out.println(linkPaymentTour);
//        log.info("Step 5. Logout");
//        tourDetailForBooking.clickToItemOnSettingMenu(driver, "ic-logout-c");
//        loginNewsfeedPage = PageGeneration.createNewsfeedLoginPage(driver);
//        log.info("Step 6. Enter username");
//        loginNewsfeedPage.enterUserNameToLogin(driver, "balo_04@mailinator.com");
//        log.info("Step 7. Enter pasword");
//        loginNewsfeedPage.enterPasswordToLogin(driver, "123456");
//        log.info("Step 8. Click to button login");
//        loginNewsfeedPage.clickToLoginButton(driver);
//        newsfeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
////        log.info("Step 9. Check login success");
////        verifyTrue(newsfeedHomePage.checkNewsfeedDisplay());
//        log.info("Step 10. Go to Tour Detail for booking");
//        System.out.println(linkPaymentTour);
//        newsfeedHomePage.openURL(driver, linkPaymentTour);
//        tourDetailForBooking = PageGeneration.createTourDetailBookingPage(driver);
//        log.info("Step 11. Check Tour Detail for booking display");
//        verifyTrue(tourDetailForBooking.checkTourDetailBookingPageIsDisplay());
//        log.info("Step 11. Click to scheduler tab for choose departure date");
//        tourDetailForBooking.clickToSchedulerTab();
//        verifyTrue(tourDetailForBooking.checkTourSchedulerTabIsDisplay());
//        log.info("Step 11. Choose date for booking");
//        tourDetailForBooking.chooseDepatureDateWantBooking();
//        tourBookingPage = PageGeneration.createTourBookingPage(driver);
//        log.info("Step 11. Verify booking tour step 1 is đisplay");
//        verifyTrue(tourBookingPage.checkTourBookingStep1IsDisplay(driver));
//    }
//    @Test
//    public void TC29_Booking_Tour_Step1() {
//        log.info("Step 1. Verify tour Name on header");
////        verifyEquals(tourBookingPage.getTourNameDisplayOnBookingStep(driver), "");
////
////        log.info("Step 2. Verify tour price on detail");
////        verifyEquals(tourBookingPage.getBasicPriceDisplayOnStep1(driver), "");
////
////        log.info("Step 3. Verify tour departure date on detail");
////        verifyEquals(tourBookingPage.getDepartureDateDisplayOnStep1(driver), "");
////
////        log.info("Step 4. Verify tour departure place on detail");
////        verifyEquals(tourBookingPage.getDeparturePlaceOnStep1(driver), "");
////
////        log.info("Step 4. Verify tour destination place on detail");
////        verifyEquals(tourBookingPage.getDeparturePlaceOnStep1(driver), "");
////
////        log.info("Step 4. Verify tour price of Adult");
////        verifyEquals(tourBookingPage.getValuePriceByTypeAge(driver, "Người lớn"), "");
////
////        log.info("Step 4. Verify tour price of Child");
////        verifyEquals(tourBookingPage.getValuePriceByTypeAge(driver, "Trẻ em"), "");
////
////        log.info("Step 4. Verify tour price of Young Child");
////        verifyEquals(tourBookingPage.getValuePriceByTypeAge(driver, "Trẻ nhỏ"), "");
////
////        log.info("Step 4. Verify tour price of Young Child");
////        verifyEquals(tourBookingPage.getValuePriceByTypeAge(driver, "Em bé"), "");
//
//        log.info("Step 4. Go To step 2");
//        tourBookingPage.clickToNextStep(driver);
//
//        log.info("Step 11. Verify booking step 2 is đisplay");
//        verifyTrue(tourBookingPage.checkTourBookingStep2IsDisplay(driver));
//    }
//    @Test
//    public void TC30_Booking_Step2_Update_Leader_Info() {
//        log.info("Step 4. Check and verify load default on Tour leader");
////        verifyEquals(tourBookingPage.getDefaultDataOfLeaderTraveller(driver, "ov402"), "");
////        verifyEquals(tourBookingPage.getDefaultDataOfLeaderTraveller(driver, "nv208"), "");
////        verifyEquals(tourBookingPage.getDefaultDataOfLeaderTraveller(driver, "ov405"), "");
//
//        log.info("Step 4. Update per title of Leader info");
//        tourBookingPage.choosePerTitleOfTourLeader(driver);
//        log.info("Step 4. Update full name of Leader Info");
//        tourBookingPage.enterDataToDynamicFieldOnTourLeader(driver, "ov402", "Hồ Doãn Quốc Huy");
//        log.info("Step 4. Update Email of Leader Info");
//        tourBookingPage.enterDataToDynamicFieldOnTourLeader(driver, "nv208", "huyho1210@gmail.com");
//        log.info("Step 4. Update Phone number of Leader Info");
//        tourBookingPage.enterDataToDynamicFieldOnTourLeader(driver, "nv231", "0936709449");
//        log.info("Step 4. Update Address of Leader Info");
//        tourBookingPage.enterDataToDynamicFieldOnTourLeader(driver, "ov405", "400A Điện Biên Phủ, Phường 25, Quận Bình Thạnh, Thành phố Hồ Chí Minh");
//        log.info("Step 4. Update Request note");
//        tourBookingPage.enterRequestNote(driver, "Tour du lịch cho các thành viên trong gia đình, cần tìm tour có hướng dẫn viên kinh nghiệm");
//    }
//    @Test
//    public void TC31_Booking_Step2_Update_Traveller_Info() {
//        log.info("Step 1. Choose number of Adult");
//        tourBookingPage.chooseNumberAdult(driver,2);
//
//        log.info("Step 2. Choose number of Child");
//        tourBookingPage.chooseNumberChild(driver, 2);
//
//        log.info("Step 3. Choose number of Young Child");
//        tourBookingPage.chooseNumberYoungChild(driver,2);
//
//        log.info("Step 4. Choose number of Infant Child");
//        tourBookingPage.chooseNumberOfInfant(driver,2);
//        log.info("Step 4. Update info of Adult traveller");
//        tourBookingPage.enterValueOfAdullInfo(driver,2,data.getFullName(),"12/10/1992","Nam","Hồ Chí Minh");
//
//        log.info("Step 4. Update info of Child traveller");
//        tourBookingPage.enterValueOfChildInfo(driver,2,data.getFullName(),"12/10/2010","Nam","Hồ Chí Minh");
//
//        log.info("Step 4. Update info of Young Child traveller");
//        tourBookingPage.enterValueOfYoungChildInfo(driver,2,data.getFullName(),"12/10/2017","Nam","Hồ Chí Minh");
//
//        log.info("Step 4. Update info of Infant traveller");
//        tourBookingPage.enterValueOfIfantInfo(driver,2,data.getFullName(),"12/10/2019","Nam","Hồ Chí Minh");
//
//        log.info("Step 4. Click to step 3");
//        tourBookingPage.clickToNextStep(driver);
//        log.info("Step 4. Check step 3 is díplay");
//        verifyTrue(tourBookingPage.checBookingTourStep3IsDisplay());
//    }
//    @Test
//    public void TC32_Booking_Step3_ConfirmTravllerInfo() {
//        log.info("Step 1. Click to step 4");
//        tourBookingPage.clickToNextStep(driver);
//        paymentInfoPage = PageGeneration.createPaymentInfo(driver);
//        log.info("Step 4. Check step 3 is díplay");
//        verifyTrue(paymentInfoPage.checkPaymentBillinginfoIsDisplay());
//    }
//    @Test
//    public void TC33_Booking_Step4_PaymentInfo_Update_Billing_Info() {
//        log.info("Step 14. Enter lastname on Billing info");
//        paymentInfoPage.enterDataToDynamicFieldOnBillingInfoTab(driver, "nv203", "Hồ");
//        log.info("Step 14. Enter firstname and surname on Billing info");
//        paymentInfoPage.enterDataToDynamicFieldOnBillingInfoTab(driver, "nv204", "Hoàng Anh Khoa");
//        log.info("Step 14. Enter company name on Billing info");
//        paymentInfoPage.enterDataToDynamicFieldOnBillingInfoTab(driver, "companyName", "Hahalolo Company");
//        log.info("Step 14. Choose country on Billing info");
//        paymentInfoPage.chooseCountryOnBillingInfoTab(driver, "United Kingdom");
//        log.info("Step 14. Enter address on Billing info");
//        paymentInfoPage.enterDataToDynamicFieldOnBillingInfoTab(driver, "address", "London");
//        log.info("Step 14. Enter city on Billing info");
//        paymentInfoPage.enterDataToDynamicFieldOnBillingInfoTab(driver, "province", "London , Bith");
//        log.info("Step 14. Enter state on Billing info");
//        paymentInfoPage.enterDataToDynamicFieldOnBillingInfoTab(driver, "state", "London , Jame");
//        log.info("Step 14. Enter zipcode on Billing info");
//        paymentInfoPage.enterDataToDynamicFieldOnBillingInfoTab(driver, "zipCode", "13123213");
//        log.info("Step 14. Enter phone on Billing info");
//        paymentInfoPage.enterDataToDynamicFieldOnBillingInfoTab(driver, "nv231", "093566666666");
//        log.info("Step 14. Enter email on Billing info");
//        paymentInfoPage.enterDataToDynamicFieldOnBillingInfoTab(driver, "nv208", "huyho66@gmail.com");
//        log.info("Step 14. Click save to update billing info");
//        paymentInfoPage.clickButtonSaveBillingInfo();
//    }
//    @Test
//    public void TC34_Booking_Step4_Payment_With_Stripe() {
//        log.info("Step 4. Check payment method display");
//        paymentInfoPage.checkPaymentMethodIsDisplay();
//
//        log.info("Step 2. Choose payment method");
//        paymentInfoPage.choosePaymentMethodStripe();
//        stripePayment = PageGeneration.createPaymentWithStripe(driver);
//
//        log.info("Step 3. Check visa payment display");
//        verifyTrue(stripePayment.checkStripeSectionIsDisplay());
//
//        log.info("Step 4. Enter card number on visa method");
//        stripePayment.enterCardnumber(driver,"4242424242424242");
//
//        log.info("Step 5 . choose expired date on visa method");
//        stripePayment.chooseExpirteDate(driver,"12","2022");
//
//        log.info("Step 6. Enter ccv code");
//        stripePayment.enterValueToCcvCodeField(driver,"123");
//
//        log.info("Step 7.  Enter cardholdername");
//        stripePayment.enterValueToCardholderName(driver,"HO DOAN QUOC HUY");
//
//        log.info("Step 14. Click to aggree rule");
//        stripePayment.clickToAggreeRule(driver);
//
//
//        log.info("Step 14. Click to payment button");
//        stripePayment.clickButtonPayment(driver);
//
//        log.info("Step 14. Check payment tour success");
//        paymentInfoPage = PageGeneration.createPageBookingSuccess(driver);
//        verifyTrue(paymentInfoPage.checkPaymentSuccessIsDisplay());
//    }
//    @Test(enabled = false)
//    public void TC28_Confirm_Order_On_Handnote() {
//        log.info("Step 1. Go to handnote");
//        paymentInfoPage.clickHereLinkToGoHandnote(driver);
//        handnoteTourPage = PageGeneration.createTourHandnotePage(driver);
//        log.info("Step 1. Check handnote-tab tour display");
//        verifyTrue(handnoteTourPage.checkHandnoteTourPageIsDisplay());
//    }
}