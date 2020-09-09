package Testcase;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HandleFunction.AbstractTest;
import Common.HandleFunction.PageGeneration;
import Project.Business.Business.*;
import Project.Business.Tour.Management.TourInfoTab;
import Project.Backend.BackendHomePage;
import Project.Backend.BackendVerifyBusinessManagement;
import Project.Business.Tour.*;
import Project.Business.Tour.Management.TourManagementPage;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.PersonalAboutPage;
import Project.Newsfeed.UserSetting.GeneralAccountSetting;
import Interfaces.Newsfeed.StartApp.Login.LoginPage;
import Project.Shared.SingUp.SignUpPage;
import Project.Wallet.WalletHomePage;
import Project.Wallet.WalletOverviewPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
    BackendVerifyBusinessManagement verifyBusinessManagementPage;
    TourDashboardPage tourDashboardPage;
    TourGeneralSettingPage tourGeneralSettingPage;
    TourTopicPage tourTopicPage;
    TourManagementPage tourManagementPage;
    TourDetailPage tourDetailPage;
    TourInfoTab tourInformationTab;
    WalletOverviewPage walletOverviewPage;
    WalletHomePage walletHomePage;
    LoginPage loginPage;
    SignUpPage signUpPage;

    // Define user properties
    String firstNameUser, lastNameUser, emailUser, passwordUser, confirmPassUser, birthdayUser , genderUser, fullName;
    // Define business properties
    String businessName, ownerName,ownerEmail, ownerPhone;
    // Define business verification properties
    String companyName ,otherCompanyName, abbCompanyName, taxCodeCompany, representativeName, registrationAddress, zipCode, companyPhone, companyEmail ,businessScope;
    String fileUploadImage2 = "image2.jpg";
    // Define payment account properties
    String paymentAccountName;
    // Define tour info properties
    String pageTourName;

    @Parameters("browser")
    @BeforeClass
    public void preconditionStep(String browserName) {
        log.info("Precondition - Step 1. Create Browser Driver ");
        driverManager = BrowserInitialization.getBrowser(browserName);
        log.info("Precondition - Step 2. Open browser and go to Newsfeed login");
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        loginPage = PageGeneration.createLoginPage(driver);
        log.info("Precondition - Step 3.  Verify url page");
        verifyEquals(loginPage.getCurrentURL(driver),"https://test-newsfeed.hahalolo.com/auth/signin");
        log.info("Precondition - Step 4. Verify icon Google play display");
        verifyTrue(loginPage.checkGooglePlayIconIsDisplay(driver));
        log.info("Precondition - Step 5. Verify icon App store display");
        verifyTrue(loginPage.checkAppStoreIconIsDisplay(driver));
        log.info("Precondition - Step 6. Change system language To Vi");
        loginPage.clickToChangeLanguageToVI(driver);
        signUpPage = PageGeneration.createFormRegister(driver);
        log.info("Precondition - Step 7. Check Halo slogan");
        verifyTrue(signUpPage.checkContentOfHaLoStartApp(driver));
    }
    @BeforeTest
    public void generateDataForTesting(){
        firstNameUser = data.getFirstName();
        lastNameUser = data.getLastName();
        emailUser = randomVirtualEmail();
        passwordUser = "1234567";
        confirmPassUser = "1234567";

        businessName= data.getCompanyName();
        ownerName= data.getFullName();
        ownerEmail = randomVirtualEmail();
        companyName=  data.getCompanyName();
        otherCompanyName= data.getCompanyName();
        abbCompanyName= data.getCompanyName();
        taxCodeCompany= data.getTaxCode();
        representativeName = data.getFullName();
        registrationAddress= "Hahalolo";
        zipCode=  data.getZipCode();
        companyPhone= data.getCompanyPhone();
        companyEmail= data.getCompanyEmail();
        businessScope= "Buôn bán văn phòng phẩm";
        paymentAccountName = "Test Payment Account";

        pageTourName = "Tour Bình Ba";
    }
    @Test
    public void TC01_Sign_Up_With_New_Account(){
        log.info("Step 1. Check title Signup form");
        verifyEquals(signUpPage.getTitleOfFormSignUp(driver),"Tham gia Hahalolo ngay!");
        log.info("Step 2. Enter first name");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv104", firstNameUser);
        log.info("Step 3. Enter last name");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv103", lastNameUser);
        log.info("Step 4. Enter email");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108", emailUser);
        log.info("Step 5. Enter password");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv109", passwordUser);
        log.info("Step 6. Enter confirm password");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"repeatPassword", confirmPassUser);
        log.info("Step 7. Click sign up button");
        signUpPage.clickSignUpButton();
    }
    @Test void TC02_Verify_New_Account(){
        log.info("Step 1.Check page display");
        verifyTrue(signUpPage.checkVerifyPageDisplay());
        log.info("Step 2.Check type of account");
        verifyTrue(signUpPage.getTitleOfVerifyForm().endsWith("email"));
        log.info("Step 3.Check registered email");
        verifyEquals(signUpPage.getUserAccountToDisplay(),emailUser);
        log.info("Step 4.Get code on Mailinator");
        String code = signUpPage.getVerifyCodeByEmail(emailUser);
        log.info("Step 5.Paste code to verifyCode field");
        signUpPage.enterVerifyCodeToVerifyAccount(driver,code);
        log.info("Step 6.Click Verify button");
        signUpPage.clickToVerifyAccount(driver);
        newsfeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
        setTimeDelay(5);
    }
    @Test
    public void TC03_Update_New_Info_When_First_Time() {
        log.info("Step 1.Check newsfeed on first time login");
        setTimeDelay(3);
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
    @Test
    public void TC04_Check_Information_Of_Account() {
        log.info("Step1.Change language before checking");
        newsfeedHomePage.changeLanguageNewsfeedToVI(driver);
        log.info("Step 2.Compare Fullname display on My account widget with User Fullname");
        fullName = newsfeedHomePage.getFullNameDisplayOnMyAccount(driver);
        verifyEquals(fullName, getFullName(firstNameUser,lastNameUser));
        log.info("Step 3.Go Personal about");
        newsfeedHomePage.clickToEditProfile(driver);
        perAboutPage = PageGeneration.createPerTAboutPage(driver);
        log.info("Step 4.Check Personall about page display");
        verifyTrue(perAboutPage.checkPageIsDisplay(getFullName(firstNameUser,lastNameUser)));
        log.info("Step 5.Verify email on Introduce widget display correct");
        verifyEquals(perAboutPage.getEmailIsDisplayOnIntroduceWidget(),emailUser);
        log.info("Step 6.Verify birthday on Introduce widget display correct");
        verifyEquals(perAboutPage.getBirthdayDisplayOnIntroduceWidget(),birthdayUser);
        log.info("Step 7.Verify gender on Introduce widget display correct");
        verifyEquals(perAboutPage.getGenderDisplayOnIntroduceWidget(),genderUser);
        log.info("Step 8.Go to Account setting page");
        perAboutPage.clickToItemOnSettingMenu(driver,"ic-cog-c");
        generalAccSetting = PageGeneration.createGeneralAccountSettingPage(driver);
        setTimeDelay(4);
        log.info("Step 9.Check Account Setting page display");
        verifyTrue(generalAccSetting.checkAccountSettingPageIsDisplay());
        verifyEquals(generalAccSetting.getPageTitle(driver),"Cài đặt tài khoản | Hahalolo");
        log.info("Step 10.Check FullName display");
        verifyEquals(generalAccSetting.getFullNameIsDisplay(),getFullName(firstNameUser,lastNameUser));
        log.info("Step 11.Check FullName display");
        verifyEquals(generalAccSetting.getFullNameIsDisplay(),fullName);
        log.info("Step 12.Logout newsfeed");
        generalAccSetting.clickToItemOnSettingMenu(driver, "ic-logout-c");
        loginPage = PageGeneration.createLoginPage(driver);
    }
    @Test
    public void TC05_Login_To_Newsfeed() {
        log.info("Step 1.Check Login newsfeed page");
        verifyTrue(loginPage.checkNewsfeedLoginPageDisplay(driver));
        log.info("Step 2.Enter email address");
        loginPage.enterUserNameToLogin(driver, emailUser);
        log.info("Step 3.Enter password");
        loginPage.enterPasswordToLogin(driver, passwordUser);
        log.info("Step 4.Click Login button");
        loginPage.clickToLoginButton(driver);
        newsfeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
    }

    @Test
    public void TC06_Create_New_Busienss() {
        log.info("Step 1.Check Newsfeed Homepage display");
        newsfeedHomePage.checkNewsfeedDisplay(driver);
        setTimeDelay(1);
        log.info("Step 2.Go to business Page");
        newsfeedHomePage.clickToItemOnSettingMenu(driver, "ic-business-c");
        businessOverviewPage = PageGeneration.createBusinessOverviewPage(driver);
        businessOverviewPage.switchWindowByTitle(driver, "Hahalolo - Business Account");
        setTimeDelay(2);
        log.info("Step 3.Check business overview page with no account");
        verifyTrue(businessOverviewPage.checkBusinessOverviewWithNewAccount(driver));
        log.info("Step 4.Click Create new business");
        businessOverviewPage.clickToCreateNewBusiness(driver);
        log.info("Step 5.Check popup display");
        verifyTrue(businessOverviewPage.checkCreateBusinessPopupDisplay());
        log.info("Step 6.Choose type Enterprise");
        businessOverviewPage.chooseTypeOfBusiness(driver, "type-business");
        log.info("Step 7.Enter business name");
        businessOverviewPage.enterBusinessName(driver, businessName);
        log.info("Step 8.Update new owner name");
        businessOverviewPage.enterValueToUpdateOwnerName(driver, ownerName);
        log.info("Step 9.Update new owner email");
        businessOverviewPage.enterValueToUpdateBusinessEmail(driver, ownerEmail);
        log.info("Step 10.Click button finish");
        businessOverviewPage.clickButtonToCreateBusiness(driver);
        businessDashboardPage = PageGeneration.createBusinessDashboardPage(driver);
    }
    @Test
    public void TC06_Check_Business_Info_And_Send_Request() {
        log.info("Step 1.Check new business is created");
//        verifyTrue(businessDashboardPage.checkTitleCreateBusinessSuccess());
        log.info("Step 2.Check status verification");
        verifyEquals(businessDashboardPage.getStatusVerifyOfBusiness(),"Xác minh tài khoản kinh doanh của bạn");
        log.info("Step 3.Click button verify business");
        businessDashboardPage.clickToVerifyBusiness(driver);
        businessVerifyPage = PageGeneration.createVerifyBusinessTypeEnterpriseForm(driver);
        log.info("Step 4.Check Enterprise verification request display success");
        verifyEquals(businessVerifyPage.getTitleOfFormVerificationRequest(),"XÁC MINH THÔNG TIN KINH DOANH DOANH NGHIỆP");
        log.info("Step 5.Enter company name");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv102", companyName);
        log.info("Step 6.Enter other company name");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv103", otherCompanyName);
        log.info("Step 7.Enter Abbreviated company name");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv104",abbCompanyName);
        log.info("Step 8.Enter Tax code");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv105",taxCodeCompany);
        log.info("Step 9.Choose Registration date");
        businessVerifyPage.chooseRegistrationDate(driver,"10","8","2018");
        log.info("Step 10.Enter Representative name");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv107", representativeName);
        log.info("Step 11.Enter Registration address");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv110",registrationAddress);
        log.info("Step 12.Click search Registration address");
        businessVerifyPage.clickEnterToSearchAddress(driver);
        log.info("Step 13.Check popup Choose Place display");
        verifyTrue(businessVerifyPage.checkFormChooseLocationIsDisplay());
        log.info("Step 14.Choose a place");
        businessVerifyPage.chooseLocation(driver, "400/8b Ung Văn Khiêm, Phường 25, Bình Thạnh, Thành phố Hồ Chí Minh, Vietnam");
        log.info("Step 15.Enter zipcode");
        businessVerifyPage.enterValueToZipCodeField(driver,zipCode);
        log.info("Step 16.Enter company phone");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv109", companyPhone);
        log.info("Step 17.Enter company email");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv108", companyEmail);
        log.info("Step 18.Enter business scope");
        businessVerifyPage.enterValueToBusinessScopeTextarea(driver,businessScope);
        log.info("Step 19.Upload Business verification papers");
        businessVerifyPage.clickToUploadDocumentVerify(driver, fileUploadImage2);
        log.info("Step 20.Click send verify request");
        businessVerifyPage.clickToSendRequestVerify(driver);
        log.info("Step 5.5.17 - Business Homepage - Send business verification - Check verify business is sent successfully");
        verifyEquals(businessVerifyPage.getTitleOfFormSendRequestSuccess(),"Yêu cầu xác minh doanh nghiệp đã được gửi");
        log.info("Step 5.5.18 - Business Homepage - Send business verification - Click button to go back Business Management");
        businessVerifyPage.clickToBackBusinessManagementPage(driver);
        businessDashboardPage = PageGeneration.createBusinessDashboardPage(driver);
        log.info("Step 5.6 - Business Homepage - Check business information");
        log.info("Step 5.6.1 - Business Homepage - Check business information - Check status verification");
        verifyEquals(businessDashboardPage.getStatusVerifyOfBusiness(),"Đang chờ xác minh thông tin kinh doanh");
        log.info("Step 5.6.2 - Business Homepage - Check business information - Go to Business Info");
        businessDashboardPage.clickItemOnBusinessNavMenu(driver,"menu-settings-info");
        businessInfoPage = PageGeneration.createBusinessInfoPage(driver);
        log.info("Step 5.6.3 - Business Homepage - Check business information - Check page display success");
        verifyTrue(businessInfoPage.checkBusinessInfoPageIsDisplay());
        log.info("Step 5.6.4 - Business Homepage - Check business information - Check owner name display success");
        verifyEquals(businessInfoPage.getOwnerNameIsDisplay(driver),ownerName);
        log.info("Step 5.6.5 - Business Homepage - Check business information - Check owner email display success");
        verifyEquals(businessInfoPage.getOwnerEmailIsDisplay(driver),ownerEmail);
        log.info("Step 6 - Confirm business verification");
        log.info("Step 6.1 - Confirm business verification - Backend Login");
        log.info("Step 6.1.1 - Confirm business verification - Backend Login - Go to Backend Login");
        businessInfoPage.openURL(driver,GlobalVariables.backendURL);
        loginPage = PageGeneration.createLoginBackEndPage(driver);
        log.info("Step 6.1.2 - Confirm business verification - Backend Login - Go to Backend Login");
        verifyTrue(loginPage.checkBackendLoginPageDisplay());
        log.info("Step 6.1.3 - Confirm business verification - Backend Login - Enter admin account");
        loginPage.enterUserNameToLogin(driver,GlobalVariables.ADMIN_ACCOUNT);
        log.info("Step 6.1.4 - Confirm business verification - Backend Login - Enter admin password");
        loginPage.enterPasswordToLogin(driver, GlobalVariables.ADMIN_PASSWORD);
        log.info("Step 6.1.5 - Confirm business verification - Backend Login - Enter captcha code");
        loginPage.enterCaptchaCodeToLogin(driver,"");
        loginPage.setTimeDelay(15);
        log.info("Step 6.1.6 - Confirm business verification - Backend Login - Click Login button");
        loginPage.clickToLoginButton(driver);
        backendHomePage = PageGeneration.createBackendHomepage(driver);
        setTimeDelay(2);
        log.info("Step 6.2 - Confirm business verification - Backend Homepage");
        log.info("Step 6.2.1 - Confirm business verification - Backend Homepage - Check page display success");
        verifyTrue(backendHomePage.checkBusinessHomePageIsDisplaySuccess());
        log.info("Step 6.2.2 - Confirm business verification - Backend Homepage - Check language system and change to Vi");
        backendHomePage.changeLanguageOfSystemToVi(driver);
        log.info("Step 6.2.3 - Confirm business verification - Backend Homepage - Go to business verification management");
        backendHomePage.clickToItemOnNavbarMenu(driver,"Xác minh doanh nghiệp");
        verifyBusinessManagementPage = PageGeneration.createVerifyBusinessManagement(driver);
        verifyBusinessManagementPage.setTimeDelay(2);
        log.info("Step 6.3 - Confirm verification");
        log.info("Step 6.3.1 - Confirm verification - Business verification management - Check page is displayed");
        verifyTrue(verifyBusinessManagementPage.checkPageIsDisplaySuccess());
        log.info("Step 6.3.2 - Confirm verification - Business verification management - Enter keyword for searching");
        verifyBusinessManagementPage.enterEmailBusinessForSearch(driver, ownerEmail);
        log.info("Step 6.3.3 - Confirm verification - Business verification management - Enter start date");
        verifyBusinessManagementPage.chooseStartDateForFilter(driver, getToday());
        log.info("Step 6.3.4 - Confirm verification - Business verification management - Enter end date");
        verifyBusinessManagementPage.chooseEndDateForFilter(driver, getToday());
        log.info("Step 6.3.5 - Confirm verification - Business verification management - Choose business type filter");
        verifyBusinessManagementPage.chooseTypeBusiness(driver, "Doanh nghiệp");
        setTimeDelay(3);
        log.info("Step 6.3.6 - Confirm verification - Business verification management - Choose status verification");
        verifyBusinessManagementPage.chooseStatusVerification(driver, "Đang chờ xác minh");
        log.info("Step 6.3.7 - Confirm verification - Business verification management - Click button Filter");
        setTimeDelay(3);
        verifyBusinessManagementPage.clickToFilterButton(driver);
        log.info("Step 6.3.8 - Confirm verification - Business verification management - Check business display correct with filter");

        log.info("Step 6.3.9 - Confirm verification - Business verification management  - Click button Verify for redirect business");
        verifyBusinessManagementPage.clickVerifyButton(driver, businessName, ownerName,ownerEmail);
        log.info("Step 6.3.10 - Confirm verification - Business verification management  - Click button confirm verify business");
        verifyBusinessManagementPage.clickConfirmButtonOnPopup(driver);
        log.info("Step 6.3.11 - Confirm verification - Business verification management  - Check business verify success");
        setTimeDelay(1);
        verifyEquals(verifyBusinessManagementPage.getStatusOfBusinessVerification(driver,businessName,ownerName,ownerEmail),"Đã xác minh");
        log.info("Step 10.1 - Create Payment account - Login Wallet");
        log.info("Step 10.1.1 - Create Payment account - Login Wallet - Go to Login Wallet");
        verifyBusinessManagementPage.negativeToURLByJS(driver,GlobalVariables.walletURL);
        loginPage = PageGeneration.createWalletLoginPage(driver);
        setTimeDelay(1);
        log.info("Step 10.1.2 - Create Payment account - Login Wallet - Check page display success");
        verifyTrue(loginPage.checkWalletLoginPageIsDisplay());
        log.info("Step 10.1.3 - Create Payment account - Login Wallet  - Enter email address");
        loginPage.enterUserNameToLogin(driver,emailUser);
        log.info("Step 10.1.4 - Create Payment account - Login Wallet  - Enter password");
        loginPage.enterPasswordToLogin(driver,passwordUser);
        log.info("Step 10.1.5 - Create Payment account - Login Wallet  - Enter captcha code");
        loginPage.enterCaptchaCodeToLogin(driver,"");
        setTimeDelay(15);
        log.info("Step 10.1.6 - Create Payment account - Login Wallet  - Click Login button");
        loginPage.clickToLoginButton(driver);
        walletOverviewPage = PageGeneration.createWalletOverviewPage(driver);
        setTimeDelay(2);
        log.info("Step 10.2 - Create Payment account - Overview Wallet page");
        log.info("Step 10.2.1 - Create Payment account - Overview Wallet page - Check page display success");
        verifyTrue(walletOverviewPage.checkPageIsDisplayedSuccessfully());
        log.info("Step 10.2.2 - Create Payment account - Overview Wallet page  - Click button Create payment account");
        walletOverviewPage.clickCreateBusinessPaymentAccount(driver);
        log.info("Step 10.3 - Create Payment account - Create Payment Account popup");
        log.info("Step 10.3.1 - Create Payment account - Create Payment Account popup - Check popup display success");
        verifyTrue(walletOverviewPage.checkCreatePaymentAccountPopupIsDisplay());
        log.info("Step 10.3.2 - Create Payment account - Create payment account popup  - Enter payment account name");
        walletOverviewPage.enterPaymentAccountName(driver,paymentAccountName);
        log.info("Step 10.3.3 - Create Payment account - Create payment account popup  - Choose default used currency");
        walletOverviewPage.chooseCurrencyOfAccount(driver,"VND - Vietnamese Dong");
        log.info("Step 10.3.4 - Create Payment account - Create payment account popup  - Click button Finish to create payment account");
        walletOverviewPage.clickToFinishButton(driver);
        walletHomePage = PageGeneration.createWalletHomepage(driver);
        log.info("Step 10.4 - Create Payment account - Wallet homepage");
        log.info("Step 10.4.1 - Create Payment account - Wallet homepage - Check page display success");
        verifyTrue(walletHomePage.checkBusinessPaymentAccountPageDisplay());
        log.info("Step 10.4.2 - Create Payment account - Wallet homepage - Check payment Account is created successfully");
        verifyEquals(walletHomePage.getPaymentAccName(),paymentAccountName);
        log.info("Step 11.1 - Create Page Tour - Overview Business page");
        log.info("Step 11.1.1 - Create Page Tour - Overview Business page - Back to Business page");
        walletHomePage.openURL(driver, GlobalVariables.businessURL);
        businessOverviewPage = PageGeneration.createBusinessOverviewPage(driver);
        setTimeDelay(2);
        log.info("Step 11.1.2 - Create Page Tour - Overview Business page - Check page display success");
        verifyTrue(businessOverviewPage.checkOverViewPageWithHaveBusiness());
        log.info("Step 11.1.3 - Create Page Tour - Overview Business page - Click to button Business Management");
        businessOverviewPage.clickToAccountManagementButton(driver);
        businessDashboardPage = PageGeneration.createBusinessDashboardPage(driver);
        setTimeDelay(2);
        log.info("Step 11.2 - Create Page Tour - Dashboard Business page");
        log.info("Step 11.2.1 - Create Page Tour - Dashboard Business page - Check page display success");
        verifyTrue(businessDashboardPage.checkPageIsDisplaySuccessfully());
        log.info("Step 11.2.2 - Create Page Tour - Dashboard Business page - Check verify business status");
        verifyEquals(businessDashboardPage.getStatusVerifyOfBusiness(),"Thông tin kinh doanh");
        log.info("Step 11.2.3 - Create Page Tour - Dashboard Business page - Check business have no page");
        verifyEquals(businessDashboardPage.getContentTitleOfSectionNoPage(),"Tạo trang đầu tiên của bạn");
        log.info("Step 11.2.4 - Create Page Tour - Dashboard Business page - Click button Create page now");
        businessDashboardPage.clickCreatePageNowButton();
        businessPageList = PageGeneration.openCreatePagePopup(driver);
        log.info("Step 11.3 - Create Page Tour - Create new page popup");
        log.info("Step 11.3.1 - Create Page Tour - Create new page popup - Check popup display");
        verifyTrue(businessPageList.checkPopupCreatePageDisplay());
        log.info("Step 11.3.2 - Create Page Tour - Create new page popup - Choose page type");
        businessPageList.choosePageType(driver, "H001");
        log.info("Step 11.3.3 - Create Page Tour - Create new page popup - Enter page name");
        businessPageList.enterPageNameToCreate(driver ,pageTourName);
        log.info("Step 11.3.4 - Create Page Tour - Create new page popup - Click button to create page");
        businessPageList.clickToCreatePage(driver);
        setTimeDelay(2);
        log.info("Step 11.3.4 - Go to BusiPage Management");
        businessPageList.clickItemOnBusinessNavMenu(driver,"menu-settings-pages");
        log.info("Step 12.1 - BusiPage management");
        log.info("Step 12.1.1. BusiPage management - Check page display success");
        verifyTrue(businessPageList.checkPageDisplaySuccess(driver));
        log.info("Step 12.1.2. BusiPage management - Verify page created success");
        verifyTrue(businessPageList.checkCreatedPageSuccess(driver,pageTourName));
        log.info("Step 12.1.3. BusiPage management - Verify page information");
        verifyEquals(businessPageList.getOwnerOfDirectPage(driver,pageTourName), emailUser);
        String pageID = businessPageList.getPageIdOfDirectPage(driver, pageTourName);
        log.info("Step 12.1.4 - Tour Dashboard - Go to page detail");
        businessPageList.clickPageManagementLinkToGoDetail(driver,pageTourName);
        tourDashboardPage = PageGeneration.createTourDashboardPage(driver);
        setTimeDelay(2);
        log.info("Step 12.2 - Create Page Tour - Tour Dashboard");
        log.info("Step 12.2.1 - Create Page Tour - Tour Dashboard - Check page display success");
        verifyTrue(tourDashboardPage.checkPageIsDisplay(driver, pageTourName));
        log.info("Step 12.2.2 - Create Page Tour - Tour Dashboard - Click Setting General on Nav-bar menu");
        tourDashboardPage.clickItemOnTourNavMenu(driver,"Thông tin");
        tourGeneralSettingPage = PageGeneration.createTourGeneralSettingPage(driver);
        setTimeDelay(2);
        log.info("Step 13.1 - Update Tour General Information - Cancel Prepayment Policy");
        log.info("Step 13.1.1 - Update Tour General Information - Cancel Prepayment Policy - Check page display success");
        verifyTrue(tourGeneralSettingPage.checkTabPrepaymentAmountDisplay());
        log.info("Step 13.1.2 - Update Tour General Information - Cancel Prepayment Policy - Enter Prepayment amount");
        tourGeneralSettingPage.enterDataValueToTextFieldOnPrepaymentTab(driver,"sn305","prepayValue");
        log.info("Step 13.1.3 - Update Tour General Information - Cancel Prepayment Policy - Enter Cancellation amount");
        tourGeneralSettingPage.enterDataValueToTextFieldOnPrepaymentTab(driver,"sn306","cancelAmount");
        log.info("Step 13.1.4 - Update Tour General Information - Cancel Prepayment Policy - Enter Day allow cancellation");
        tourGeneralSettingPage.enterDataValueToTextFieldOnPrepaymentTab(driver,"sn307","dayAllowCancel");
        log.info("Step 13.1.5 - Update Tour General Information - Cancel Prepayment Policy - Click save button");
        tourGeneralSettingPage.clickToSaveButton(driver);
        log.info("Step 13.1.6 - Update General Information - Click Setting VAT");
        tourGeneralSettingPage.clickToItemOnTourInformationNav(driver, "vat");
        log.info("Step 13.2 - Update Tour General Information - Setting VAT - Check page display");
        verifyTrue(tourGeneralSettingPage.checkVATSettingPageDisplay(driver));
        log.info("Step 13.2 - Update Tour General Information - Setting VAT - Choose optiom VAT");
        tourGeneralSettingPage.chooseOptionVAT(driver,"1");
        log.info("Step 13.2 - Update Tour General Information - Setting VAT - Click to save button");
        tourGeneralSettingPage.clickToSaveButton(driver);
        log.info("Step 13.2 - Update Tour General Information - Click to Age setting");
        tourGeneralSettingPage.clickToItemOnTourInformationNav(driver, "age");
        log.info("Step 13.2 - Update Tour General Information - Age Setting - Check tab display");
        verifyTrue(tourGeneralSettingPage.checkAgeSettingPageDisplay(driver));
        log.info("Step 13.2 - Update Tour General Information - Age Setting - Enter Adult age");
        tourGeneralSettingPage.enterDataValueToTextFieldOnAgeSettingTab(driver,"sn351","12");
        log.info("Step 13.2 - Update Tour General Information - Age Setting - Enter Child age");
        tourGeneralSettingPage.enterDataValueToTextFieldOnAgeSettingTab(driver,"sn352","6");
        log.info("Step 13.2 - Update Tour General Information - Age Setting - Enter Young Child age");
        tourGeneralSettingPage.enterDataValueToTextFieldOnAgeSettingTab(driver,"sn354","2");
        log.info("Step 13.2 - General Info - Age Setting - Click to save button");
        tourGeneralSettingPage.clickToSaveButton(driver);
        log.info("Step 13.2 - General Info - Click Noti order setting");
        tourGeneralSettingPage.clickToItemOnTourInformationNav(driver, "mail");
        log.info("Step 13.2 - General Info - Noti order setting - Check tab display");
        verifyTrue(tourGeneralSettingPage.checkNotiForOrderSettingPageDisplay(driver));
        log.info("Step 13.2. General Info - Noti order setting - Enable setting");
        tourGeneralSettingPage.clickToEnableMode(driver);
        log.info("Step 13.2. General Info - Noti order setting - Enter email");
        tourGeneralSettingPage.enterDataValueToTextFieldOnNotiOrder(driver,"sv453",ownerEmail);
        log.info("Step 13.2. General Info - Noti order setting - Enter phone");
        tourGeneralSettingPage.enterDataValueToTextFieldOnNotiOrder(driver,"sv454",ownerPhone);
        log.info("Step 13.2. General Info - Noti order setting - Click button save");
        tourGeneralSettingPage.clickToSaveButton(driver);
//
        log.info("Step 13.2. Tour topic - Go to Topic page");
        tourGeneralSettingPage.clickItemOnTourNavMenu(driver,"Topics");
        tourTopicPage = PageGeneration.createTourTopicListPage(driver);
        log.info("Step 13.2. Tour topic - Check page display with case no topic");
        verifyTrue(tourTopicPage.checkPageWithCaseNoTopicDisplay());
        log.info("Step 13.2. Tour topic - Click create topic");
        tourTopicPage.clickCreateTopic(driver);
        log.info("Step 13.2. Tour topic - Check create topic display");
        verifyTrue(tourTopicPage.checkPopupCreateTopicDisplay());
        log.info("Step 13.2. Tour topic - Choose topic image");
        tourTopicPage.chooseTopicImage();
        log.info("Step 13.2. Tour topic - Choose topic language");
        tourTopicPage.chooseLanguageOfTopic(driver);
        log.info("Step 13.2. Tour topic - Enter topic name");
        tourTopicPage.enterTopicName(driver,"Topic name");
        log.info("Step 13.2. Tour topic - Enter topic description");
        tourTopicPage.enterTopicDescription(driver,"Topic description");
        log.info("Step 13.2. Tour topic - Enter topic description");
        tourTopicPage.clickToSaveButton(driver);
        log.info("Step 13.2. Tour topic - Verify topic created success");
        verifyTrue(tourTopicPage.checkCreatedTopicDisplay(driver));
        log.info("Step 13.2. Tour - Go to Tour management");
        tourTopicPage.clickItemOnTourNavMenu(driver,"Tours");
        tourManagementPage = PageGeneration.createTourManagementPage(driver);
        log.info("Step 13.2. Tour - Check page display with case no topic");
        verifyTrue(tourManagementPage.checkPageWithCaseNoTourDisplay());
        log.info("Step 13.2. Tour - Click button create tour");
        tourManagementPage.clickToCreateTour(driver);
        log.info("Step 13.2. Tour topic - Check create tour popup display");
        verifyTrue(tourTopicPage.checkPopupCreateTourDisplay());
        log.info("Step 13.2. Tour - Enter tour name");
        tourManagementPage.enterValueOfTourName(driver,"");
        log.info("Step 13.2. Tour - Choose tour type");
        tourManagementPage.chooseTourType(driver);
        log.info("Step 13.2. Tour - Choose tour topic");
        tourManagementPage.chooseTourTopic(driver);
        log.info("Step 13.2. Tour - Click Create button");
        tourManagementPage.clickSaveButtonToCreateTour(driver);
        tourInformationTab = PageGeneration.createTourInfoTab(driver);
        log.info("Step 13.2. Tour info - Complete update infor");
//        log.info("Update data on Tour information tab");
//        log.info("Update data on Tour information tab - Enter sku code");
//        String skuCode = "";
//        tourInformationTab.enterValueOfTourToDynamicFieldOnInformationTab(driver, "tv102",skuCode);
//
//        log.info("Update data on Tour information tab - Enter Total day of Tour");
//        String totalDay = "";
//        tourInformationTab.enterValueOfTourToDynamicFieldOnInformationTab(driver, "tn123",totalDay);
//
//        log.info("Update data on Tour information tab - Enter Basic Price of Tour");
//        String basicPrice = "";
//        tourInformationTab.enterValueOfTourToDynamicFieldOnInformationTab(driver,"tn133", basicPrice);
//
//        log.info("Update data on Tour information tab - Enter Allow booking date of Tour");
//        String allowBookingDate = "";
//        tourInformationTab.enterValueOfTourToDynamicFieldOnInformationTab(driver,"tn130", allowBookingDate);
//
//        log.info("Update data on Tour information tab - Enter Address start Tour");
//        String addresss = "";
//        tourInformationTab.enterValueOfTourToDynamicFieldOnInformationTab(driver,"address", addresss);
//
//        log.info("Update data on Tour information tab - Update country");
//        String countryName = "";
//        tourInformationTab.chooseItemOnDropdownOnUpdateLocation(driver,"country",countryName);
//
//        log.info("Update data on Tour information tab - Update city/State");
//        String cityName = "";
//        tourInformationTab.chooseItemOnDropdownOnUpdateLocation(driver,"city",cityName);
//
//        log.info("Update data on Tour information tab - Update District/ County");
//        String districtName = "";
//        tourInformationTab.chooseItemOnDropdownOnUpdateLocation(driver,"region",districtName);
//
//        log.info("Update data on Tour information tab - Enter Short description");
//        String shortDescription = "";
//        tourInformationTab.enterValueOfShortDesc(driver, shortDescription);
//
//        log.info("Update data on Tour information tab - Enter Private regulations");
//        String privateRegulations = "";
//        tourInformationTab.enterValueOfTourToDynamicSummerNoteOnInformationTab(driver, "tv152", privateRegulations);
//
//        log.info("Update data on Tour information tab - Enter Policy");
//        String policy = "";
//        tourInformationTab.enterValueOfTourToDynamicSummerNoteOnInformationTab(driver, "tv153", policy);
//
//        log.info("Update data on Tour information tab - Enter Installment policy");
//        String policyInstallment = "";
//        tourInformationTab.enterValueOfTourToDynamicSummerNoteOnInformationTab(driver, "tv155", policyInstallment);
//
//
//        log.info("Update data on Tour information tab - Choose Tour Logo");
//        tourInformationTab.chooseImageToUpdateTourInfo(driver,"uploadLogo");
//
//        log.info("Update data on Tour information tab - Choose Tour Cover");
//        tourInformationTab.chooseImageToUpdateTourInfo(driver, "uploadCover");
//
//        log.info("Update data on Tour information tab - Choose Tour Gallery");
//        tourInformationTab.chooseImageToUpdateTourInfo(driver, "uploadGalleries");
//
//        log.info("Update data on Tour information tab - Click to Save Tour button");
//        tourInformationTab.clickToButtonSaveTour();
//
//        log.info("Update data on Tour information tab - Click to Part Tour tab");
//        tourInformationTab.clickToItemOfNavigationMenu(driver);
//
//        // Tab Tour part
//        tourPartTab = PageGeneration.createTourPartTab(driver);
//        tourPartTab.clickToCreateNewPartButton();
//        tourPartTab.enterValueToPartNameField(driver, partName);
//        tourPartTab.enterValueDateOfPart(driver, dayOfPart);
//        tourPartTab.enterValueOfPartTime(driver,timePart);
//        tourPartTab.enterValueOfAddress(driver, address);
//        tourPartTab.chooseCountry(driver);
//        tourPartTab.chooseCityState(driver);
//        tourPartTab.chooseWard(driver);
//        tourPartTab.enterValueOfPartShortDescription(driver,"");
//        tourPartTab.chooseTransportItem(driver);
//        tourPartTab.choosePartLogo(driver);
//        tourPartTab.clickToButtonSavePart(driver);
//        tourPartTab.clickToPriceOnTourNavigationMenu(driver);
//
//
//        // Tab Tour part
//        tourPriceTab = PageGeneration.createTourPriceTab(driver);
//        tourPriceTab.clickToCreateNewPrice(driver);
//        tourPriceTab.chooseStartDateOfPrice(driver);
//        tourPriceTab.enterValueOfAdultPrice(driver,"");
//        tourPriceTab.enterValueOfChildPrice(driver,"");
//        tourPriceTab.enterValueOfYoungChildPrice(driver, "");
//        tourPriceTab.enterValueOfInfantPrice(driver,"");
//        tourPriceTab.clickToSavePriceButton(driver);
//        tourPriceTab.clickToSchedulerSetting(driver);
//
//
//        // Tab Tour scheduler
//        tourScheduler = PageGeneration.createTourScheduler(driver);
//        tourScheduler.chooseDateToOpenSaleTour(driver);
//
//        tourScheduler.clickToServiceSetting(driver);

    }
}
