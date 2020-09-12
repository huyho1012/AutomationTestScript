package Testcase;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;

import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Business.Business.*;
import Project.Business.Promotion.TourPromotion;
import Project.Business.Tour.Management.Detail.*;
import Project.Backend.BackendHomePage;
import Project.Backend.BackendVerifyBusiManagement;
import Project.Business.Tour.*;
import Project.Business.Tour.Management.List.TourManagementPage;
import Project.Business.Promotion.Promotion;
import Project.Business.Tour.Setting.PubishPage;
import Project.Business.Tour.Setting.TourGeneralSettingPage;
import Project.Business.Tour.Topic.TourTopicPage;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.PersonalAboutPage;
import Project.Newsfeed.AccountSetting.GeneralAccountSetting;
import Project.Shared.Login.LoginPage;
import Project.Shared.SingUp.SignUpPage;
import Project.Wallet.WalletHomePage;
import Project.Wallet.WalletOverviewPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import sun.jvm.hotspot.debugger.Page;

public class TestRegister extends AbstractTest {
    DriverManager driverManager;
    DataHelper data = new DataHelper();
    WebDriver driver;

    // Object model
    NewsfeedHomepage newsfeedHomePage;
    PersonalAboutPage perAboutPage;
    GeneralAccountSetting generalAccSetting;
    BusinessOverviewPage businessOverviewPage;
    BusinessDashboardPage businessDashboardPage;
    BusinessVerificationRequest businessVerifyPage;
    BusinessInfoPage businessInfoPage;
    BusinessPageManagement businessPageList;
    BackendHomePage backendHomePage;
    BackendVerifyBusiManagement verifyBusinessManagementPage;
    TourDashboardPage tourDashboardPage;
    TourGeneralSettingPage tourGeneralSettingPage;
    TourTopicPage tourTopicPage;
    TourManagementPage tourManagementPage;
    WalletOverviewPage walletOverviewPage;
    WalletHomePage walletHomePage;
    LoginPage loginPage;
    SignUpPage signUpPage;

    PubishPage pubishPage;

    TourInfoTab tourInfoTab;
    TourPartTab tourPartTab;
    TourPriceTab tourPriceTab;
    TourSchedulerTab tourSchedulerTab;
    TourServiceTab tourServiceTab;
    TourPromotionTab tourPromoTab;
    TourSettingTab tourSettingTab;
    TourServicePrice tourServicePriceTab;

    Promotion promotionListPage;
    TourPromotion  tourPromotionPage;


    // Define user properties
    String firstNameUser, lastNameUser, emailUser, passwordUser, confirmPassUser, birthdayUser, genderUser, fullName;
    // Define business properties
    String businessName, ownerName, ownerEmail, ownerPhone;
    // Define business verification properties
    String companyName, otherCompanyName, abbCompanyName, taxCodeCompany, representativeName, registrationAddress, zipCode, companyPhone, companyEmail, businessScope;
    String fileUploadImage2 = "image2.jpg";
    String fileUploadImage1 = "image1.jpg";
    // Define payment account properties
    String paymentAccountName;
    // Define tour info properties
    String pageTourName;
    String tourName;
    String topicName;

    String partName, partDay, partTime, partAddress, partDesc;
    String startDateTour, endTDateTour;

    @Parameters("browser")
    @BeforeClass
    public void preconditionStep(String browserName) {
        log.info("Precondition - Step 1. Create Browser Driver ");
        driverManager = BrowserInitialization.getBrowser(browserName);
        log.info("Precondition - Step 2. Open browser and go to Newsfeed login");
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        loginPage = PageGeneration.createLoginPage(driver);
        log.info("Precondition - Step 3.  Verify url page");
        verifyEquals(loginPage.getCurrentURL(driver), "https://test-newsfeed.hahalolo.com/auth/signin");
        log.info("Precondition - Step 4. Verify icon Google play display");
        verifyTrue(loginPage.checkGooglePlayIconIsDisplay(driver));
        log.info("Precondition - Step 5. Verify icon App store display");
        verifyTrue(loginPage.checkAppStoreIconIsDisplay(driver));
        log.info("Precondition - Step 6. Change system language To Vi");
        loginPage.clickToChangeLanguageToVI(driver);
//        signUpPage = PageGeneration.createFormRegister(driver);
//        log.info("Precondition - Step 7. Check Halo slogan");
//        verifyTrue(signUpPage.checkContentOfHaLoStartApp(driver));
    }

    @BeforeTest
    public void generateDataForTesting() {
        firstNameUser = data.getFirstName();
        lastNameUser = data.getLastName();
        emailUser = randomVirtualEmail();
        passwordUser = "1234567";
        confirmPassUser = "1234567";

        businessName = data.getCompanyName();
        ownerName = data.getFullName();
        ownerPhone = "0936709449";
        ownerEmail = randomVirtualEmail();
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

        pageTourName = "Tour Bình Ba";
        partAddress = "400A Điện biên phủ , Bình Thạnh ";
        partDesc = "haehahaha";
        startDateTour = "20/10/2020";
        endTDateTour = "30/12/2020";
    }

    @Test(enabled = false)
    public void TC01_Sign_Up_With_New_Account() {
        log.info("Step 1. Check title Signup form");
        verifyEquals(signUpPage.getTitleOfFormSignUp(driver), "Tham gia Hahalolo ngay!");
        log.info("Step 2. Enter first name");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver, "nv104", firstNameUser);
        log.info("Step 3. Enter last name");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver, "nv103", lastNameUser);
        log.info("Step 4. Enter email");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver, "nv108", emailUser);
        log.info("Step 5. Enter password");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver, "nv109", passwordUser);
        log.info("Step 6. Enter confirm password");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver, "repeatPassword", confirmPassUser);
        log.info("Step 7. Click sign up button");
        signUpPage.clickSignUpButton();
    }

    @Test(enabled = false)
    public void TC02_Verify_New_Account() {
        log.info("Step 1.Check page display");
        verifyTrue(signUpPage.checkVerifyPageDisplay());
        log.info("Step 2.Check type of account");
        verifyTrue(signUpPage.getTitleOfVerifyForm().endsWith("email"));
        log.info("Step 3.Check registered email");
        verifyEquals(signUpPage.getUserAccountToDisplay(), emailUser);
        log.info("Step 4.Get code on Mailinator");
        String code = signUpPage.getVerifyCodeByEmail(emailUser);
        log.info("Step 5.Paste code to verifyCode field");
        signUpPage.enterVerifyCodeToVerifyAccount(driver, code);
        log.info("Step 6.Click Verify button");
        signUpPage.clickToVerifyAccount(driver);
        newsfeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
        setTimeDelay(5);
    }

    @Test(enabled = false)
    public void TC03_Update_New_Info_When_First_Time() {
        log.info("Step 1.Check newsfeed on first time login");
        verifyTrue(newsfeedHomePage.checkNewsfeedDisplayOnFirstTime(driver));
        log.info("Step 2.Check title Update information popup");
        verifyEquals(newsfeedHomePage.getTitleOfFormFirstUpdateInfo(), "Xác minh tài khoản thành công!");
        log.info("Step 3.Update birthday");
        newsfeedHomePage.updateBirthdayOfUser(driver, "12", "10", "1992");
        birthdayUser = getBirthdayOnHaLo("12", "10", "1992");
        log.info("Step 4.Update gender");
        newsfeedHomePage.updateGenderOfUser(driver, "male");
        genderUser = newsfeedHomePage.getGenderOfUser(driver, "male");
        log.info("Step 5.Update nationality");
        newsfeedHomePage.updateNationalOfUser(driver, "VN");
        log.info("Step 6.Click to confirm button");
        newsfeedHomePage.clickToButtonConfirmForUpdateInfo(driver);
    }

    @Test(enabled = false)
    public void TC04_Check_Information_Of_Account() {
        log.info("Step1.Change language before checking");
        newsfeedHomePage.changeLanguageNewsfeedToVI(driver);
        log.info("Step 2.Compare Fullname display on My account widget with User Fullname");
        fullName = newsfeedHomePage.getFullNameDisplayOnMyAccount(driver);
        verifyEquals(fullName, getFullName(firstNameUser, lastNameUser));
        log.info("Step 3.Go Personal about");
        newsfeedHomePage.clickToEditProfile(driver);
        perAboutPage = PageGeneration.createPerTAboutPage(driver);
        log.info("Step 4.Check Personall about page display");
        verifyTrue(perAboutPage.checkPageIsDisplay(getFullName(firstNameUser, lastNameUser)));
        log.info("Step 5.Verify email on Introduce widget display correct");
        verifyEquals(perAboutPage.getEmailIsDisplayOnIntroduceWidget(), emailUser);
        log.info("Step 6.Verify birthday on Introduce widget display correct");
        verifyEquals(perAboutPage.getBirthdayDisplayOnIntroduceWidget(), birthdayUser);
        log.info("Step 7.Verify gender on Introduce widget display correct");
        verifyEquals(perAboutPage.getGenderDisplayOnIntroduceWidget(), genderUser);
        log.info("Step 8.Go to Account setting page");
        perAboutPage.clickToItemOnSettingMenu(driver, "ic-cog-c");
        generalAccSetting = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Step 9.Check Account Setting page display");
        verifyTrue(generalAccSetting.checkAccountSettingPageIsDisplay());
        verifyEquals(generalAccSetting.getPageTitle(driver), "Cài đặt tài khoản | Hahalolo");
        log.info("Step 10.Check FullName display");
        verifyEquals(generalAccSetting.getFullNameIsDisplay(), getFullName(firstNameUser, lastNameUser));
        log.info("Step 11.Check FullName display");
        verifyEquals(generalAccSetting.getFullNameIsDisplay(), fullName);
        log.info("Step 12.Logout newsfeed");
        generalAccSetting.clickToItemOnSettingMenu(driver, "ic-logout-c");
        loginPage = PageGeneration.createLoginPage(driver);
    }

    @Test
    public void TC05_Login_To_Newsfeed() {
        log.info("Step 1.Check Login newsfeed page");
        verifyTrue(loginPage.checkAppStoreIconIsDisplay(driver));
        log.info("Step 2.Enter email address");
        loginPage.enterUserNameToLogin(driver, "balo_04@mailinator.com");
        log.info("Step 3.Enter password");
        loginPage.enterPasswordToLogin(driver, "123456");
        log.info("Step 4.Click Login button");
        loginPage.clickToLoginButton(driver);
        newsfeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
        log.info("Step 1.Check Newsfeed Homepage display");
        newsfeedHomePage.checkNewsfeedDisplay();
    }

    @Test(enabled = false)
    public void TC06_Create_New_Business() {
        log.info("Step 1.Go to business Page");
        newsfeedHomePage.clickToItemOnSettingMenu(driver, "ic-business-c");
        businessOverviewPage = PageGeneration.createBusinessOverviewPage(driver);
        businessOverviewPage.switchWindowByTitle(driver, "Hahalolo - Business Account");
        log.info("Step 2.Check business overview page with no account");
        verifyTrue(businessOverviewPage.checkBusinessOverviewWithNewAccount(driver));
        log.info("Step 3.Click Create new business");
        businessOverviewPage.clickToCreateNewBusiness(driver);
        log.info("Step 4.Check popup display");
        verifyTrue(businessOverviewPage.checkCreateBusinessPopupDisplay());
        log.info("Step 5.Choose type Enterprise");
        businessOverviewPage.chooseTypeOfBusiness(driver, "type-business");
        log.info("Step 6.Enter business name");
        businessOverviewPage.enterBusinessName(driver, businessName);
        log.info("Step 7.Update new owner name");
        businessOverviewPage.enterValueToUpdateOwnerName(driver, ownerName);
        log.info("Step 8.Update new owner email");
        businessOverviewPage.enterValueToUpdateBusinessEmail(driver, ownerEmail);
        log.info("Step 9.Click button finish");
        businessOverviewPage.clickButtonToCreateBusiness(driver);
        businessDashboardPage = PageGeneration.createBusinessDashboardPage(driver);
    }

    @Test(enabled = false)
    public void TC06_Send_Enterprise_Verification_Request() {
        log.info("Step 1.Check new business is created");
//        verifyTrue(businessDashboardPage.checkTitleCreateBusinessSuccess());
        log.info("Step 2.Check status verification");
        verifyEquals(businessDashboardPage.getStatusVerifyOfBusiness(), "Xác minh tài khoản kinh doanh của bạn");
        log.info("Step 3.Click button verify business");
        businessDashboardPage.clickToVerifyBusiness(driver);
        businessVerifyPage = PageGeneration.createVerifyBusinessTypeEnterpriseForm(driver);
        log.info("Step 4.Check Enterprise verification request display success");
        verifyEquals(businessVerifyPage.getTitleOfFormVerificationRequest(), "XÁC MINH THÔNG TIN KINH DOANH DOANH NGHIỆP");
        log.info("Step 5.Enter company name");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver, "bv102", companyName);
        log.info("Step 6.Enter other company name");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver, "bv103", otherCompanyName);
        log.info("Step 7.Enter Abbreviated company name");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver, "bv104", abbCompanyName);
        log.info("Step 8.Enter Tax code");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver, "bv105", taxCodeCompany);
        log.info("Step 9.Choose Registration date");
        businessVerifyPage.chooseRegistrationDate(driver, "10", "8", "2018");
        log.info("Step 10.Enter Representative name");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver, "bv107", representativeName);
        log.info("Step 11.Enter Registration address");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver, "bv110", registrationAddress);
        log.info("Step 12.Click search Registration address");
        businessVerifyPage.clickEnterToSearchAddress(driver);
        log.info("Step 13.Check popup Choose Place display");
        verifyTrue(businessVerifyPage.checkFormChooseLocationIsDisplay());
        log.info("Step 14.Choose a place");
        businessVerifyPage.chooseLocation(driver, "400/8b Ung Văn Khiêm, Phường 25, Bình Thạnh, Thành phố Hồ Chí Minh, Vietnam");
        log.info("Step 15.Enter zipcode");
        businessVerifyPage.enterValueToZipCodeField(driver, zipCode);
        log.info("Step 16.Enter company phone");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver, "bv109", companyPhone);
        log.info("Step 17.Enter company email");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver, "bv108", companyEmail);
        log.info("Step 18.Enter business scope");
        businessVerifyPage.enterValueToBusinessScopeTextarea(driver, businessScope);
        log.info("Step 19.Upload Business verification papers");
        businessVerifyPage.clickToUploadDocumentVerify(driver, fileUploadImage2);
        log.info("Step 20.Click send verify request");
        businessVerifyPage.clickToSendRequestVerify(driver);
    }

    @Test(enabled = false)
    public void TC07_Check_Business_Info() {
        log.info("Step 1. Check verificication request has already sent");
        verifyEquals(businessVerifyPage.getTitleOfFormSendRequestSuccess(driver), "Yêu cầu xác minh doanh nghiệp đã được gửi");
        log.info("Step 2. Click button to go back Business Management");
        businessVerifyPage.clickToBackBusinessManagementPage(driver);
        log.info("Step 3. Check status verification");
        verifyEquals(businessDashboardPage.getStatusVerifyOfBusiness(), "Đang chờ xác minh thông tin kinh doanh");
        log.info("Step 4. Go to Business Info");
        businessDashboardPage.clickItemOnBusinessNavMenu(driver, "menu-settings-info");
        businessInfoPage = PageGeneration.createBusinessInfoPage(driver);
        log.info("Step 5. Check display of Businessi info page");
        verifyTrue(businessInfoPage.checkBusinessInfoPageIsDisplay());
        log.info("Step 6. Check owner name display success");
        verifyEquals(businessInfoPage.getOwnerNameIsDisplay(driver), ownerName);
        log.info("Step 7. Check owner email display success");
        verifyEquals(businessInfoPage.getOwnerEmailIsDisplay(driver), ownerEmail);
    }

    @Test(enabled = false)
    public void TC08_Backend_Confirm_Business_Verification() {
        log.info("Step 1. Go to Backend Login");
        businessInfoPage.openURL(driver, GlobalVariables.backendURL);
        loginPage = PageGeneration.createLoginBackEndPage(driver);
        log.info("Step 2. Check Backend Login display");
        verifyTrue(loginPage.checkBackendLoginPageDisplay());
        log.info("Step 3. Enter admin account");
        loginPage.enterUserNameToLogin(driver, GlobalVariables.ADMIN_ACCOUNT);
        log.info("Step 4. Enter admin password");
        loginPage.enterPasswordToLogin(driver, GlobalVariables.ADMIN_PASSWORD);
        log.info("Step 5. Enter captcha code");
        loginPage.enterCaptchaCodeToLogin(driver, "");
        setTimeDelay(15);
        log.info("Step 6. Click Login button");
        loginPage.clickToLoginButton(driver);
        backendHomePage = PageGeneration.createBackendHomepage(driver);
        setTimeDelay(2);
        log.info("Step 7.Check Backend homepage display");
        verifyTrue(backendHomePage.checkBusinessHomePageIsDisplaySuccess());
        log.info("Step 8. Change language system to Vi");
        backendHomePage.changeLanguageOfSystemToVi(driver);
        log.info("Step 9. Go to business verification management");
        backendHomePage.clickToItemOnNavbarMenu(driver, "Xác minh doanh nghiệp");
        verifyBusinessManagementPage = PageGeneration.createVerifyBusinessManagement(driver);
        log.info("Step 10. Check Business verification management page display");
        verifyTrue(verifyBusinessManagementPage.checkPageIsDisplaySuccess());
        log.info("Step 11. Enter keyword for searching");
        verifyBusinessManagementPage.enterEmailBusinessForSearch(driver, ownerEmail);
        log.info("Step 12. Choose start date");
        verifyBusinessManagementPage.chooseStartDateForFilter(driver, getToday());
        log.info("Step 13. Choose end date");
        verifyBusinessManagementPage.chooseEndDateForFilter(driver, getToday());
        log.info("Step 14. Choose business type");
        verifyBusinessManagementPage.chooseTypeBusiness(driver, "Doanh nghiệp");
        log.info("Step 15. Choose status verification");
        verifyBusinessManagementPage.chooseStatusVerification(driver, "Đang chờ xác minh");
        log.info("Step 16. Click button Filter");
        verifyBusinessManagementPage.clickToFilterButton(driver);
        log.info("Step 17. Check business display correct with filter");

        log.info("Step 18. Click button Verify for redirect business");
        verifyBusinessManagementPage.clickVerifyButton(driver, businessName, ownerName, ownerEmail);
        log.info("Step 19. Check popup Confirm verification business display");
        verifyTrue(verifyBusinessManagementPage.checkConfirmPopupDisplay(driver));
        log.info("Step 20. Click button confirm");
        verifyBusinessManagementPage.clickConfirmButtonOnPopup(driver);
        log.info("Step 21. Check business verify success");
        verifyEquals(verifyBusinessManagementPage.getStatusOfBusinessVerification(driver, businessName, ownerName, ownerEmail), "Đã xác minh");
    }

    @Test(enabled = false)
    public void TC09_Wallet_Create_Payment_Account_Type_Business() {
        log.info("Step 1. Go to Login Wallet");
        loginPage.negativeToURLByJS(driver, GlobalVariables.walletURL);
        loginPage = PageGeneration.createWalletLoginPage(driver);
        log.info("Step 2. Check Login wallet page display");
        verifyTrue(loginPage.checkWalletLoginPageIsDisplay());
        log.info("Step 3. Enter email address");
        loginPage.enterUserNameToLogin(driver, emailUser);
        log.info("Step 4. Enter password");
        loginPage.enterPasswordToLogin(driver, passwordUser);
        log.info("Step 5. Enter captcha code");
        loginPage.enterCaptchaCodeToLogin(driver, "");
        setTimeDelay(15);
        log.info("Step 6.Click Login button");
        loginPage.clickToLoginButton(driver);
        walletOverviewPage = PageGeneration.createWalletOverviewPage(driver);
        log.info("Step 7 Check Wallet overview page display success");
        verifyTrue(walletOverviewPage.checkPageIsDisplayedSuccessfully());
        log.info("Step 8. Click button Create payment account");
        walletOverviewPage.clickCreateBusinessPaymentAccount(driver);
        log.info("Step 9. Check popup Create new business display");
        verifyTrue(walletOverviewPage.checkCreatePaymentAccountPopupIsDisplay());
        log.info("Step 10. Enter payment account name");
        walletOverviewPage.enterPaymentAccountName(driver, paymentAccountName);
        log.info("Step 11. Choose currency");
        walletOverviewPage.chooseCurrencyOfAccount(driver, "VND - Vietnamese Dong");
        log.info("Step 12. Click button Finish to create payment account");
        walletOverviewPage.clickToFinishButton(driver);
        walletHomePage = PageGeneration.createWalletHomepage(driver);
        log.info("Step 13. Check Wallet homepage display success");
        verifyTrue(walletHomePage.checkBusinessPaymentAccountPageDisplay());
        log.info("Step 14.Check payment Account is created successfully");
        verifyEquals(walletHomePage.getPaymentAccName(), paymentAccountName);
    }

    @Test(enabled = false)
    public void TC09_Business_Create_Page_Tour_With_Case_New() {
        log.info("Step 1. Back to Business page");
        loginPage.openURL(driver, GlobalVariables.businessURL);
        businessOverviewPage = PageGeneration.createBusinessOverviewPage(driver);
        log.info("Step 2. Check Overview Business page display");
        verifyTrue(businessOverviewPage.checkOverViewPageWithHaveBusiness());
        log.info("Step 3. Click to button Business Management");
        businessOverviewPage.clickToAccountManagementButton(driver);
        businessDashboardPage = PageGeneration.createBusinessDashboardPage(driver);
        log.info("Step 4. Check Dashboard Business page display success");
        verifyTrue(businessDashboardPage.checkPageIsDisplaySuccessfully());
        log.info("Step 5. Check verify business status");
        verifyEquals(businessDashboardPage.getStatusVerifyOfBusiness(), "Thông tin kinh doanh");
        log.info("Step 6. Check business have no page");
        verifyEquals(businessDashboardPage.getContentTitleOfSectionNoPage(), "Tạo trang đầu tiên của bạn");
        log.info("Step 7. Click button Create page now");
        businessDashboardPage.clickCreatePageNowButton();
        businessPageList = PageGeneration.openCreatePagePopup(driver);
        log.info("Step 8. Check Create new page popup display");
        verifyTrue(businessPageList.checkPopupCreatePageDisplay());
        log.info("Step 9. Choose page type");
        businessPageList.choosePageType(driver, "H001");
        log.info("Step 10. Enter page name");
        businessPageList.enterPageNameToCreate(driver, pageTourName);
        log.info("Step 11. Click button to create page");
        businessPageList.clickToCreatePage(driver);
        log.info("Step 12. Go to BusiPage Management");
        businessPageList.clickItemOnBusinessNavMenu(driver, "menu-settings-pages");
        log.info("Step 13. Check Business page managemennt display");
        verifyTrue(businessPageList.checkPageDisplaySuccess(driver));
        log.info("Step 14. Check page have been created successfully");
        verifyTrue(businessPageList.checkCreatedPageSuccess(driver, pageTourName));
        log.info("Step 15. Verify page information");
        verifyEquals(businessPageList.getOwnerOfDirectPage(driver, pageTourName), emailUser);
        String pageID = businessPageList.getPageIdOfDirectPage(driver, pageTourName);
        log.info("Step 16. Go to Tour Dashboard");
        businessPageList.clickPageManagementLinkToGoDetail(driver, pageTourName);
        tourDashboardPage = PageGeneration.createTourDashboardPage(driver);
    }

    @Test
    public void TC10_CreateNewPage() {
        log.info("Step 1. Back to Business page");
        loginPage.openURL(driver, GlobalVariables.businessURL);
        businessOverviewPage = PageGeneration.createBusinessOverviewPage(driver);
        log.info("Step 2. Check Overview Business page display");
        verifyTrue(businessOverviewPage.checkOverViewPageWithHaveBusiness());
        log.info("Step 3. Click to button Business Management");
        businessOverviewPage.clickToAccountManagementButton(driver);
        businessDashboardPage = PageGeneration.createBusinessDashboardPage(driver);
        log.info("Step 4. Check Dashboard Business page display success");
        verifyTrue(businessDashboardPage.checkPageIsDisplaySuccessfully());
        log.info("Step 5. Check verify business status");
        verifyEquals(businessDashboardPage.getStatusVerifyOfBusiness(), "Thông tin kinh doanh");
        businessDashboardPage.clickItemOnBusinessNavMenu(driver, "menu-settings-pages");
        businessPageList = PageGeneration.goToPageListManagement(driver);
        log.info("Step 5. Click button Create Page");
        businessPageList.clickToCreatePageToDisplayPopupCreatePage();
        log.info("Step 8. Check Create new page popup display");
        verifyTrue(businessPageList.checkPopupCreatePageDisplay());
        log.info("Step 9. Choose page type");
        businessPageList.choosePageType(driver, "H001");
        log.info("Step 10. Enter page name");
        businessPageList.enterPageNameToCreate(driver, pageTourName);
        log.info("Step 11. Click button to create page");
        businessPageList.clickToCreatePage(driver);
        log.info("Step 16. Go to Tour Dashboard");
        businessPageList.clickPageManagementLinkToGoDetail(driver, pageTourName);
        tourDashboardPage = PageGeneration.createTourDashboardPage(driver);
    }

    @Test
    public void TC11_Update_Prepayment_Cancellation_On_Tour_General_Information() {
        log.info("Step 1. Check Tour Dashboard page display");
        verifyTrue(tourDashboardPage.checkPageIsDisplay(driver, pageTourName));
        log.info("Step 2. Click to Setting General");
        tourDashboardPage.clickItemOnTourNavMenu(driver, "Thông tin");
        tourGeneralSettingPage = PageGeneration.createTourGeneralSettingPage(driver);
        log.info("Step 3.Check Prepaymend And Cancellation policy display");
        verifyTrue(tourGeneralSettingPage.checkTabPrepaymentAmountDisplay());
        log.info("Step 4. Enter Prepayment amount");
        tourGeneralSettingPage.enterDataValueToTextFieldOnPrepaymentTab(driver, "sn305", "10");
        log.info("Step 5. Enter Cancellation amount");
        tourGeneralSettingPage.enterDataValueToTextFieldOnPrepaymentTab(driver, "sn306", "5");
        log.info("Step 6. Enter Day allow cancellation");
        tourGeneralSettingPage.enterDataValueToTextFieldOnPrepaymentTab(driver, "sn307", "1");
        log.info("Step 7. Click save button");
        tourGeneralSettingPage.clickToSaveButton(driver);
    }

    @Test
    public void TC12_Update_VAT_On_Tour_General_Information() {
        log.info("Step 1. Click Setting VAT");
        tourGeneralSettingPage.clickToItemOnTourInformationNav(driver, "vat");
        log.info("Step 2. Check Setting VAT tab display");
        verifyTrue(tourGeneralSettingPage.checkVATSettingPageDisplay(driver));
        log.info("Step 3. Choose option VAT");
        tourGeneralSettingPage.chooseOptionVATInclude(driver);
        log.info("Step 4. Click to save button");
        tourGeneralSettingPage.clickToSaveButton(driver);
    }

    @Test
    public void TC13_Setting_Age_On_GeneralInfo() {
        log.info("Step 1. Click to Age setting");
        tourGeneralSettingPage.clickToItemOnTourInformationNav(driver, "age");
        log.info("Step 2. Check Age setting tab display");
        verifyTrue(tourGeneralSettingPage.checkAgeSettingPageDisplay(driver));
        log.info("Step 3. Enter Adult age");
        tourGeneralSettingPage.enterDataValueToTextFieldOnAgeSettingTab(driver, "sn351", "12");
        log.info("Step 4. Enter Child age");
        tourGeneralSettingPage.enterDataValueToTextFieldOnAgeSettingTab(driver, "sn352", "6");
        log.info("Step 5. Enter Young Child age");
        tourGeneralSettingPage.enterDataValueToTextFieldOnAgeSettingTab(driver, "sn354", "2");
        log.info("Step 6. Click to save button");
        tourGeneralSettingPage.clickToSaveButton(driver);
    }

    @Test
    public void TC14_Setting_Notice_Order_On_GeneralInfo() {
        log.info("Step 1. Click Noti order setting");
        tourGeneralSettingPage.clickToItemOnTourInformationNav(driver, "mail");
        log.info("Step 2.Check  Noti order tab display");
        verifyTrue(tourGeneralSettingPage.checkNotiForOrderSettingPageDisplay(driver));
        log.info("Step 3. Enable setting");
        tourGeneralSettingPage.clickToEnableMode(driver);
        log.info("Step 4. Enter email");
        tourGeneralSettingPage.enterDataValueToTextFieldOnNotiOrder(driver, "sv453", ownerEmail);
        log.info("Step 5. Enter phone");
        tourGeneralSettingPage.enterDataValueToTextFieldOnNotiOrder(driver, "sv454", ownerPhone);
        log.info("Step 6. Click button save");
        tourGeneralSettingPage.clickToSaveButton(driver);
    }
    @Test
    public void TC15_Publish_Page() {
        log.info("Step 1. Go to Setting Page");
        tourGeneralSettingPage.clickItemOnTourNavMenu(driver,"Tổng quan");
        pubishPage = PageGeneration.createPageSetting(driver);
        log.info("Step 2. Check General setting page display");
        verifyTrue(pubishPage.checkPublishPageIsDisplay(driver));
        log.info("Step 3. Check status default of new page");
        verifyTrue(pubishPage.checkStatusOfPublishButton(driver));
        log.info("Step 4. Publish Tour Page");
        pubishPage.publishPage(driver);
        log.info("Step 5. Check status publish page");
        verifyFalse(pubishPage.checkStatusOfPublishButton(driver));
    }

    @Test
    public void TC15_Create_New_Topic() {
        log.info("Step 1. Go to Topic page");
        pubishPage.clickItemOnTourNavMenu(driver, "Chủ đề");
        tourTopicPage = PageGeneration.createTourTopicListPage(driver);
        log.info("Step 2. Check Topic page case no topic");
        verifyTrue(tourTopicPage.checkPageWithCaseNoTopicDisplay());
        log.info("Step 3. Click create topic");
        tourTopicPage.clickCreateTopic(driver);
        log.info("Step 4. Check popup Create topic display");
        verifyTrue(tourTopicPage.checkPopupCreateTopicDisplay());
        log.info("Step 5. Choose topic image");
        tourTopicPage.chooseTopicImage(driver, fileUploadImage2);
        log.info("Step 6. Choose topic language");
        tourTopicPage.chooseLanguageOfTopic(driver, "vi");
        log.info("Step 7. Enter topic name");
        topicName = "Tháng 1";
        tourTopicPage.enterTopicName(driver, topicName);
        log.info("Step 8. Enter topic description");
        tourTopicPage.enterTopicDescription(driver, "Topic description");
        log.info("Step 9. Click Save Button");
        tourTopicPage.clickToSaveButton(driver);
        log.info("Step 10. Verify topic have been created successfully");
        verifyTrue(tourTopicPage.checkCreatedTopicDisplay(driver));
    }

    @Test
    public void TC16_Create_New_Tour() {
        log.info("Step 1. Go to Tour management");
        tourTopicPage.clickItemOnTourNavMenu(driver, "Tours");
        tourManagementPage = PageGeneration.createTourManagementPage(driver);
        log.info("Step 2. Check Tour management with case no Tour");
        verifyTrue(tourManagementPage.checkPageWithCaseNoTourDisplay());
        log.info("Step 3. Click button create tour");
        tourManagementPage.clickStartCreateTourButtonOnCenterListPage(driver);
        log.info("Step 4. Check popup Create tour display");
        verifyTrue(tourManagementPage.checkPopupCreateTourDisplay());
        log.info("Step 5. Enter tour name");
        tourName = "Tour Vũng tàu - Phan thiết";
        tourManagementPage.enterValueOfTourName(driver, tourName);
        log.info("Step 6. Choose tour type");
        tourManagementPage.chooseTourType(driver, "Tour nội địa");
        log.info("Step 7. Choose tour topic");
        tourManagementPage.chooseTourTopic(driver, topicName);
        log.info("Step 8. Click Create button");
        tourManagementPage.clickToButtonSaveOnPopup(driver);
        tourInfoTab = PageGeneration.createTourInfoTab(driver);
    }

    @Test
    public void TC17_Update_Tour_Information() {
        log.info("Step 1. Check Tab Tour of Tour Detail display");
        verifyTrue(tourInfoTab.checkTourInfoTabDisplay());
        log.info("Step 2. Enter sku code");
        String skuCode = "HKTT_101";
        tourInfoTab.enterValueToDynamicField(driver, "tv102", skuCode);
        log.info("Step 3. Enter Total day of Tour");
        String totalDay = "1";
        tourInfoTab.enterValueToDynamicField(driver, "tn123", totalDay);
        log.info("Step 4. Enter Basic Price of Tour");
        String basicPrice = "1000000";
        tourInfoTab.enterValueToDynamicField(driver, "tn133", basicPrice);
        log.info("Step 5. Enter Allow booking date of Tour");
        String allowBookingDate = "2";
        tourInfoTab.enterValueToDynamicField(driver, "tn130", allowBookingDate);
        log.info("Step 6. Enter Address");
        String addresss = "400 Điện Biên Phủ P25, Quận Bình Thạnh";
        tourInfoTab.enterValueToDynamicField(driver, "address", addresss);
        log.info("Step 7. Choose country");
        String countryName = "Vietnam";
        tourInfoTab.chooseItemToUpdateLocation(driver, "country", countryName);
        log.info("Step 8. Choose City/State");
        String cityName = "Ho Chi Minh City";
        tourInfoTab.chooseItemToUpdateLocation(driver, "city", cityName);
        log.info("Step 9. Choose District/ County");
        String districtName = "Quận Bình Thạnh";
        tourInfoTab.chooseItemToUpdateLocation(driver, "region", districtName);
        log.info("Step 10. Enter Short description");
        String shortDescription = "Test Mô tả ngắn của tour";
        tourInfoTab.enterValueOfShortDesc(driver, shortDescription);
        log.info("Step 11. Enter Private regulations");
        String privateRegulations = "Quy đinh riêng";
        tourInfoTab.enterValueOfTourToDynamicSummerNoteOnInformationTab(driver, "tv152", privateRegulations);
        log.info("Step 12. Enter Policy");
        String policy = "Chính sách Tour";
        tourInfoTab.enterValueOfTourToDynamicSummerNoteOnInformationTab(driver, "tv153", policy);
        log.info("Step 13. Enter Installment policy");
        String policyInstallment = "Chính sách trả góp";
        tourInfoTab.enterValueOfTourToDynamicSummerNoteOnInformationTab(driver, "tv155", policyInstallment);
        log.info("Step 14. Choose Tour Logo");
        tourInfoTab.updateLogo(driver, fileUploadImage2);
        log.info("Step 15. Choose Tour Cover");
        tourInfoTab.updateCover(driver, fileUploadImage2);
        log.info("Step 16 .Choose Tour Gallery");
        tourInfoTab.updateTourGallery(driver, fileUploadImage2);
        log.info("Step 17. Click to Save Tour button");
        tourInfoTab.clickToButtonSaveTour();
    }

    @Test
    public void TC18_Create_Part_Of_Tour() {
        log.info("Step 1. Click to Part tab");
        tourInfoTab.clickToItemOfNavigationMenu(driver, "#tour-parts");
        tourPartTab = PageGeneration.createTourPartTab(driver);
        log.info("Step 2. Check Part tab display");
        verifyTrue(tourPartTab.checkPartTabDisplaySuccess());
        tourPartTab.clickToCreateNewPartButton();
        log.info("Step 3. Check Part Detail display");
        verifyTrue(tourPartTab.checkPartDetailDisplay());
        log.info("Step 4. Enter part name");
        partName = "Sài Gòn - Đà Nẵng";
        tourPartTab.enterValueToDynamicFieldOnPartTab(driver, "tv302", partName);
        log.info("Step 5. Enter day of part");
        partDay = "1";
        tourPartTab.enterValueToDynamicFieldOnPartTab(driver, "tn305", partDay);
        log.info("Step 6. Enter part time");
        partTime = "12:00";
        tourPartTab.enterValueToDynamicFieldOnPartTab(driver, "tv306", partTime);
        log.info("Step 7. Enter part address");
        tourPartTab.enterValueToDynamicFieldOnPartTab(driver, "address", partAddress);
        log.info("Step 8. Choose Country");
        tourPartTab.chooseItemToUpdateLocation(driver, "country", "countryName");
        log.info("Step 9. Choose City/state");
        tourPartTab.chooseItemToUpdateLocation(driver, "city", "cityName");
        log.info("Step 9. Choose District/ County");
        tourPartTab.chooseItemToUpdateLocation(driver, "region", "districtName");
        log.info("Step 9. Enter part description");
        tourPartTab.enterValueToShortDescription(driver, partDesc);
        log.info("Step 12. Choose transport item");
        tourPartTab.chooseNewTransportItem(driver, "car");
        log.info("Step 13. Update Part Logo");
        tourPartTab.choosePartLogo(driver, fileUploadImage1);
        log.info("Step 14. Click button Save Part");
        tourPartTab.clickToButtonSavePart(driver);
        log.info("Step 15. Check part have been created successfully");
        verifyTrue(tourPartTab.checkPartHasBeenCreatedSuccessfully());
    }

    @Test
    public void TC19_Create_Price_Of_Tour() {
        log.info("Step 1. Go to price tab");
        tourPartTab.clickToItemOfNavigationMenu(driver, "#tour-prices");
        tourPriceTab = PageGeneration.createTourPriceTab(driver);
        log.info("Step 2. Check Part tab display");
        verifyTrue(tourPriceTab.checkPriceTabDisplaySuccess());
        log.info("Step 3. Click to button Create new price");
        tourPriceTab.clickToCreateNewPrice(driver);
        log.info("Step 4. Check Part tab display");
        verifyTrue(tourPriceTab.checkPriceDetailIsDisplay());
        log.info("Step 5. Enter day of part");

        tourPriceTab.chooseStartDateOfPrice(driver, startDateTour);
        log.info("Step 6. Enter day of part");
        tourPriceTab.enterValueOfAdultPrice(driver, "300000");
        log.info("Step 7. Enter day of part");
        tourPriceTab.enterValueOfChildPrice(driver, "300000");
        log.info("Step 8. Enter day of part");
        tourPriceTab.enterValueOfYoungChildPrice(driver, "300000");
        log.info("Step 8. Enter day of part");
        tourPriceTab.enterValueOfInfantPrice(driver, "300000");
        log.info("Step 8. Enter day of part");
        tourPriceTab.clickToSavePriceButton(driver);
        log.info("Step 15. Check price have been created successfully");
        verifyTrue(tourPriceTab.checkPriceCreatedSuccessfully());
    }

    @Test
    public void TC20_Create_Scheduler_Of_Tour() {
        log.info("Step 1. Go to price tab");
        tourPartTab.clickToItemOfNavigationMenu(driver, "#tour-schedulers");
        tourSchedulerTab = PageGeneration.createTourSchedulerTab(driver);
        log.info("Step 2. Check Scheduler tab display");
        verifyTrue(tourSchedulerTab.checkSchedulerTabDisplaySuccess());
        log.info("Step 3. Choose start Date");
        tourSchedulerTab.chooseStartDate(driver,startDateTour);
        log.info("Step 4. Choose End Date");
        tourSchedulerTab.chooseEndDate(driver, endTDateTour);
        log.info("Step 5. Click button setting");
        tourSchedulerTab.clickButtonSetting(driver);
    }

    @Test(enabled = false)
    public void TC15_Update_Services_Provided() {
        log.info("Step 1. Go to Tour services tab");
        tourSchedulerTab.clickToItemOfNavigationMenu(driver, "#tour-services");
        tourServiceTab = PageGeneration.createTourServiceTab(driver);
        log.info("Step 2. Check Tour services tab display");
        verifyTrue(tourServiceTab.checkTourServiceTabDisplaySuccess());
        log.info("Step 3. Choose Tour services");
        tourServiceTab.addServicesApply(driver);
        log.info("Step 4. Click button setting");
        tourServiceTab.clickUpdateButton(driver);
//        log.info("Step 5. Check service is added");
//        tourServiceTab.checkHaloTourIsAdded(driver);
    }

    @Test
    public void TC16_Create_New_Promotion_Apply() {
        log.info("Step 1. Go to Tour promotion tab");
        tourServiceTab.clickToItemOfNavigationMenu(driver, "#tour-promotions");
        tourPromoTab = PageGeneration.createTourPromotionTab(driver);
        log.info("Step 2. Check Tour promotion tab display");
        verifyTrue(tourPromoTab.checkPromotionTabDislay());
        log.info("Step 3. Check Tour promotion no promotion apply");
        verifyEquals(tourPromoTab.getMessageNotFoundPromo(), "Không tìm thấy dữ liệu.");
        log.info("Step 1. Click Create new promo");
        tourPromoTab.clickToCreatePromotionButton();

        tourPromotionPage = PageGeneration.goToCreateEditPromotionPage(driver);
        log.info("Step 1. Enter promotion name");
        tourPromotionPage.enterPromoName(driver, "");
        log.info("Step 1. Enter promotion desc");
        tourPromotionPage.enterPromoDesc(driver, "");
        log.info("Step 1. Choose language promotion");
        tourPromotionPage.chooseLanguagePromotion(driver, "");
        log.info("Step 1. Choose currency promotion");
        tourPromotionPage.chooseCurrencyPromotion(driver, "");
        log.info("Step 1. Add promotion image");
        tourPromotionPage.clickAddImagePromo(driver, "");
        log.info("Step 1. Choose promotion time range");
        tourPromotionPage.enterDateRangeApply(driver, "");
        log.info("Step 1. Choose discount type");
        tourPromotionPage.chooseTypeDiscount(driver, 1);
        log.info("Step 1. Choose promotion type");
        tourPromotionPage.chooseTypeDiscount(driver, 1);
        log.info("Step 1. Enter discount value");
        tourPromotionPage.enterDiscountAmount(driver, "");
        log.info("Step 1. Enter min order value");
        tourPromotionPage.enterMinOrderValue(driver, "");
        log.info("Step 1. Choose Apply Mode");
        tourPromotionPage.chooseModeSimple(driver);
        log.info("Step 1. Choose Tour apply promotion");
        tourPromotionPage.clickIconAddTourToSelectedList(driver);
        log.info("Step 1. Publish promotion");
        tourPromotionPage.scrollToTopPage(driver);
        tourPromotionPage.publicPromotion(driver);
        log.info("Step 1. Click button Save");
        tourPromotionPage.clickSaveButton(driver);
        log.info("Step 1. Check detail promotion");
        verifyTrue(tourPromotionPage.checkViewDetailPromotionDisplay());

        log.info("Step 1. Check info of promotion");
        log.info("Step 1. Check promotion name display");
        verifyEquals(tourPromotionPage.getPromotionNameDisplayOnPromoDetail(),"");
        log.info("Step 1. Check promotion description display");
        verifyEquals(tourPromotionPage.getPromotionDescDisplayOnPromoDetail(),"");
        log.info("Step 1. Check promotion status display");
        verifyEquals(tourPromotionPage.getPromotionStatusDisplayOnPromoDetail(),"");
        log.info("Step 1. Check promotion language display");
        verifyEquals(tourPromotionPage.getPromotionLanguageDisplayOnPromoDetail(),"");
        log.info("Step 1. Check promotion currency display");
        verifyEquals(tourPromotionPage.getPromotionCurrencyDisplayOnPromoDetail(),"");
        log.info("Step 1. Check promotion date range display");
        verifyEquals(tourPromotionPage.getPromotionDateRangeDisplayOnPromoDetail(),"");
        log.info("Step 1. Check discount type display");
        verifyEquals(tourPromotionPage.getPromotionDiscountTypeDisplayOnPromoDetail(),"");
        log.info("Step 1. Check promotion type display");
        verifyEquals(tourPromotionPage.getPromotionTypeDisplayOnPromoDetail(),"");
        log.info("Step 1. Check tour type applied display");
        verifyEquals(tourPromotionPage.getTourTypeAppliedDisplayOnPromoDetail(),"");
        log.info("Step 1. Check tour type applied display");
        verifyEquals(tourPromotionPage.getListTourAppliedOnPromoDetail(),"");
        log.info("Step 1. Check Min order value and discount amount display");
        verifyTrue(tourPromotionPage.getPromotionDisountLevel());
    }
    @Test
    public void TC17_Go_Back_To_Tour() {
        log.info("Step 1. Go to Tour Managment");
        tourPromotionPage.clickItemOnTourNavMenu(driver,"Tours");
        tourManagementPage = PageGeneration.createTourManagementPage(driver);
        log.info("Step 2. Check Tour Managerment display");
        verifyTrue(tourManagementPage.checkPageWithCaseHaveTourDisplay(driver));
        log.info("Step 3. Click to View detail for tour");
        tourManagementPage.clickEditButtonOfDirectTour(driver);
        tourInfoTab = PageGeneration.createTourInfoTab(driver);
        log.info("Step 4. Check tour detail display");
        tourInfoTab.checkTourInfoTabDisplay();
    }
    @Test
    public void TC17_Create_Service_Price() {
        log.info("Step 1. Click to Service price");
        tourInfoTab.clickItemOnTourNavMenu(driver,"");
        tourServicePriceTab = PageGeneration.createTourServicePriceTab(driver);
        log.info("Step 2. Check Service price display");
        verifyTrue(tourServicePriceTab.checkTourServicePriceTab(driver));
        log.info("Step 3. Click button Adđ service price");
        tourServicePriceTab.clickButtonCreateNewPrice();
        log.info("Step 4. Input service price");
        tourServicePriceTab.enterPriceOfService();
        log.info("Step 5. Chooose service ");
        tourServicePriceTab.choooseServiceOnDropdown();
        log.info("Step 6. Click save price service ");
        tourServicePriceTab.choooseServiceOnDropdown();
    }


    @Test
    public void TC17_Publish_Tour() {
        log.info("Step 1. Click to Setting page");
        tourInfoTab.clickItemOnTourNavMenu(driver,"");
        tourSettingTab = PageGeneration.createTourSettingTab(driver);
        log.info("Step 2. Check Setting Tour display");
        verifyTrue(tourSettingTab.checkSettingTourPageDisplay(driver));
        log.info("Step 3. Click button Adđ service price");
        tourServicePriceTab.checkPublishTour();
    }
}


