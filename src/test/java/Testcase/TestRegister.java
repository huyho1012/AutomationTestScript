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
import Project.Newsfeed.Newsfeed.NewsfeedHomePage;
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
    NewsfeedHomePage newsfeedHomePage;
    PersonalAboutPage perAboutPage;
    GeneralAccountSetting generalAccSetting;
    BusinessOverviewPage businessOverviewPage;
    BusinessDashboardPage businessDashboardPage;
    BusinessVerificationPage businessVerifyPage;
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
    String businessName, ownerName,ownerEmail;
    // Define business verification properties
    String companyName ,otherCompanyName, abbCompanyName, taxCodeCompany, representativeName, registrationAddress, zipCode, companyPhone, companyEmail ,businessScope;
    String fileUploadImage2 = "image2.jpg";
    // Define payment account properties
    String paymentAccountName;
    // Define tour info properties

    @Parameters("browser")
    @BeforeClass
    public void preconditionStep(String browserName) {
        log.info("Precondition - Step 1 - Create Browser Driver ");
        driverManager = BrowserInitialization.getBrowser(browserName);
        log.info("Precondition - Step 2 - Open browser and go to Newsfeed login");
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        loginPage = PageGeneration.createLoginPage(driver);
        log.info("Precondition - Step 3 - Check and confirm Newsfeed page display success");
        log.info("Precondition - Step 3.1 - Check and confirm Newsfeed page display success - Verify url page");
        verifyEquals(loginPage.getCurrentURL(driver),"https://test-newsfeed.hahalolo.com/auth/signin");
        log.info("Precondition - Step 3.2 - Check and confirm Newsfeed page display success - Verify icon Google play display");
        verifyTrue(loginPage.checkGooglePlayIconIsDisplay(driver));
        log.info("Precondition - Step 3.2 - Check and confirm Newsfeed page display success - Verify icon App store display");
        verifyTrue(loginPage.checkAppStoreIconIsDisplay(driver));
        log.info("Precondition - Step 4 - Change system language To Ví");
        log.info("Precondition - Step 4.1 - Change system language To Ví - Select action change VI");
        loginPage.clickToChangeLanguageToVI(driver);
        signUpPage = PageGeneration.createFormRegister(driver);
        log.info("Precondition - Step 4.2 - Change system language To Ví - Check Halo slogan");
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
    }
    @Test
    public void TC01_Booking_and_Payment_Workflow(){
        log.info("Step 1 - Check title of form Signup");
        verifyEquals(signUpPage.getTitleOfFormSignUp(driver),"Tham gia Hahalolo ngay!");
        log.info("Step 2 - Sign up new account");
        log.info("Step 2.1 - Sign up new account - Enter first name");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv104", firstNameUser);
        log.info("Step 2.2 - Sign up new account - Enter last name");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv103", lastNameUser);
        log.info("Step 2.3 - Sign up new account - Enter email");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108", emailUser);
        log.info("Step 2.4 - Sign up new account - Enter password");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv109", passwordUser);
        log.info("Step 2.5 - Sign up new account - Enter confirm password");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"repeatPassword", confirmPassUser);
        log.info("Step 2.6 - Sign up new account - Click to sign up new account");
        signUpPage.clickSignUpButton();
        signUpPage.setTimeDelay(4);
        log.info("Step 3 - Verify new account");
        log.info("Step 3.1 - Verify new account - Check page display success");
        verifyEquals(signUpPage.getPageTitle(driver),"Kích hoạt tài khoản | Hahalolo");
        verifyTrue(signUpPage.checkVerifyPageDisplay());
        log.info("Step 3.2 - Verify new account - Check type of verify account");
        verifyTrue(signUpPage.getTitleOfVerifyForm().endsWith("email"));
        log.info("Step 3.3 - Verify new account - Check registered email display on form");
        verifyEquals(signUpPage.getUserAccountToDisplay(),emailUser);
        log.info("Step 3.4 - Verify new account - Get code on Mailinator");
        String code = signUpPage.getVerifyCodeByEmail(emailUser);
        log.info("Step 3.5 - Verify new account - Paste code to verify code field");
        signUpPage.enterVerifyCodeToVerifyAccount(driver,code);
        log.info("Step 3.6 - Verify new account - Click Verify button");
        signUpPage.clickToVerifyAccount(driver);
        newsfeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
        newsfeedHomePage.setTimeDelay(5);
        log.info("Step 4 - Newsfeed Homepage");
        log.info("Step 4.1 - Newsfeed Homepage - Check page display success");
//        verifyTrue(newsfeedHomePage.checkNewsfeedDisplay(driver));
        verifyEquals(newsfeedHomePage.getCurrentURL(driver),"https://test-newsfeed.hahalolo.com/");
        verifyEquals(newsfeedHomePage.getPageTitle(driver),"Bảng tin | Hahalolo");
        log.info("Step 4.2 - Newsfeed Homepage - Update info");
        log.info("Step 4.2.1 - Newsfeed Homepage - Update info - Check Update info popup display");
        verifyTrue(newsfeedHomePage.formFirstUpdateInfoIsDisplay());
        verifyEquals(newsfeedHomePage.getTitleOfFormFirstUpdateInfo(),"Xác minh tài khoản thành công!");
        log.info("Step 4.2.1 - Newsfeed Homepage - Update info - Update birthday");
        newsfeedHomePage.updateBirthdayOfUser(driver,"12","10","1992");
        birthdayUser = getBirthdayOnHaLo("12","10","1992");
        log.info("Step 4.2.2 - Newsfeed Homepage - Update info - Update gender");
        newsfeedHomePage.updateGenderOfUser(driver,"male");
        genderUser = newsfeedHomePage.getGenderOfUser(driver,"male");
        log.info("Step 4.2.3 - Newsfeed Homepage - Update info - Update nationality");
        newsfeedHomePage.updateNationalOfUser(driver,"VN");
        log.info("Step 4.2.4 - Newsfeed Homepage - Update info - Click to confirm button");
        newsfeedHomePage.clickToButtonConfirmForUpdateInfo(driver);
        log.info("Step 4.3 - Newsfeed Homepage - Verify information");
        log.info("Step 4.3.1 - Newsfeed Homepage - Verify information - Change language system before checking");
        newsfeedHomePage.changeLanguageNewsfeedToVI(driver);
        log.info("Step 4.3.2 - Newsfeed Homepage - Verify information - Verify full name My account widget display correct");
        fullName = newsfeedHomePage.getFullNameDisplayOnMyAccount(driver);
        verifyEquals(fullName, getFullName(firstNameUser,lastNameUser));
        log.info("Step 4.3.3 - Newsfeed Homepage - Verify information - Go to personal About page");
        newsfeedHomePage.clickToEditProfile(driver);
        perAboutPage = PageGeneration.createPerTAboutPage(driver);
        perAboutPage.setTimeDelay(4);
        log.info("Step 4.3.4 - Newsfeed Homepage - Verify information - Verify Personal About page display");
        verifyTrue(perAboutPage.checkPageIsDisplay());
        verifyEquals(perAboutPage.getPageTitle(driver),"Giới thiệu - Trang cá nhân | Hahalolo");
        log.info("Step 4.3.5- Newsfeed Homepage - Verify information - Verify email on Introduce widget display correct");
        verifyEquals(perAboutPage.getEmailIsDisplayOnIntroduceWidget(),emailUser);
        log.info("Step 4.3.6 - Newsfeed Homepage - Verify information - Verify birthday on Introduce widget display correct");
        verifyEquals(perAboutPage.getBirthdayDisplayOnIntroduceWidget(),birthdayUser);
        log.info("Step 4.3.7 - Newsfeed Homepage - Verify information - Verify gender on Introduce widget display correct");
        verifyEquals(perAboutPage.getGenderDisplayOnIntroduceWidget(),genderUser);
        log.info("Step 4.3.8 - Newsfeed Homepage - Verify information - Go to Account Setting page");
        perAboutPage.clickToItemOnSettingMenu(driver,"ic-cog-c");
        generalAccSetting = PageGeneration.createGeneralAccountSettingPage(driver);
        generalAccSetting.setTimeDelay(4);
        log.info("Step 4.3.8 - Newsfeed Homepage - Verify information - Verify Account Setting page display");
        verifyTrue(generalAccSetting.checkAccountSettingPageIsDisplay());
        verifyEquals(generalAccSetting.getPageTitle(driver),"Cài đặt tài khoản | Hahalolo");
        log.info("Step 4.3.9 - Newsfeed Homepage - Verify information - Verify FullName on Update FullName function display correct");
        log.info("Step 4.3.9.1 - Newsfeed Homepage - Verify information - Verify FullName on Update FullName with full name user input");
        verifyEquals(generalAccSetting.getFullNameIsDisplay(),getFullName(firstNameUser,lastNameUser));
        log.info("Step 4.3.9.2 - Newsfeed Homepage - Verify information - Verify FullName on Update FullName with full name on My Account widget");
        verifyEquals(generalAccSetting.getFullNameIsDisplay(),fullName);
        log.info("Step 5 - Business Homepage");
        log.info("Step 5.1 - Business Homepage - Go to business Page");
        generalAccSetting.clickToItemOnSettingMenu(driver,"ic-business-c");
        businessOverviewPage = PageGeneration.createBusinessOverviewPage(driver);
        businessOverviewPage.switchWindowByTitle(driver,"Hahalolo - Business Account");
        generalAccSetting.setTimeDelay(2);
        log.info("Step 5.2.1 - Business Homepage - Overview Business page - Check page with case new account display");
        verifyEquals(businessOverviewPage.getPageTitle(driver),"Hahalolo - Business Account");
        verifyTrue(businessOverviewPage.checkBusinessOverviewWithNewAccount(driver));
        log.info("Step 5.2.2 - Business Homepage - Overview Business page - Click button Create new business");
        businessOverviewPage.clickToCreateNewBusiness(driver);
        log.info("Step 5.3.1 - Business Homepage - Create Business popup - Check popup display");
        verifyTrue(businessOverviewPage.checkCreateBusinessPopupDisplay());
        log.info("Step 5.3.2 - Business Homepage - Create Business popup - Choose type Enterprise");
        businessOverviewPage.chooseTypeOfBusiness(driver, "type-business");
        log.info("Step 5.3.3 - Business Homepage - Create Business popup - Enter business name");
        businessOverviewPage.enterBusinessName(driver, businessName);
        log.info("Step 5.3.4 - Business Homepage - Create Business popup - Update new owner name");
        businessOverviewPage.enterValueToUpdateOwnerName(driver, ownerName);
        log.info("Step 5.3.5 - Business Homepage - Create Business popup - Update new owner email");
        businessOverviewPage.enterValueToUpdateBusinessEmail(driver,ownerEmail);
        log.info("Step 5.3.6 - Business Homepage - Create Business popup - Click button finish for creating new business");
        businessOverviewPage.clickButtonToCreateBusiness(driver);
        businessDashboardPage = PageGeneration.createBusinessDashboardPage(driver);
        log.info("Step 5.4 - Business Homepage - Verify business information");
        log.info("Step 5.4.1 - Business Homepage - Verify business information - Check new business is created successfully");
//        verifyTrue(businessDashboardPage.checkTitleCreateBusinessSuccess());
        log.info("Step 5.4.2 - Business Homepage - Verify business information - Check status verification");
        verifyEquals(businessDashboardPage.getStatusVerifyOfBusiness(),"Xác minh tài khoản kinh doanh của bạn");
        log.info("Step 5.4.2 - Business Homepage - Verify business information - Click button verify business");
        businessDashboardPage.clickToVerifyBusiness(driver);
        businessVerifyPage = PageGeneration.createVerifyBusinessTypeEnterpriseForm(driver);
        log.info("Step 5.5 - Business Homepage - Send business verification");
        log.info("Step 5.5.1 - Business Homepage - Send business verification - Check Enterprise verification request display success");
        verifyEquals(businessVerifyPage.getTitleOfFormVerificationRequest(),"XÁC MINH THÔNG TIN KINH DOANH DOANH NGHIỆP");
        log.info("Step 5.5.2 - Business Homepage - Send business verification - Enter company name");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv102", companyName);
        log.info("Step 5.5.3 - Business Homepage - Send business verification - Enter other company name");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv103", otherCompanyName);
        log.info("Step 5.5.4 - Business Homepage - Send business verification - Enter Abbreviated company name");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv104",abbCompanyName);
        log.info("Step 5.5.5 - Business Homepage - Send business verification - Enter Tax code");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv105",taxCodeCompany);
        log.info("Step 5.5.6 - Business Homepage - Send business verification - Choose Registration date");
        businessVerifyPage.chooseRegistrationDate(driver,"10","8","2018");
        log.info("Step 5.5.7 - Business Homepage - Send business verification - Enter Representative name");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv107", representativeName);
        log.info("Step 5.5.8 - Business Homepage - Send business verification - Enter Registration address");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv110",registrationAddress);
        log.info("Step 5.5.9 - Business Homepage - Send business verification - Click search Registration address");
        businessVerifyPage.clickEnterToSearchAddress(driver);
        log.info("Step 5.5.10.1- Business Homepage - Send business verification - Choose place popup - Check popup display");
        verifyTrue(businessVerifyPage.checkFormChooseLocationIsDisplay());
        log.info("Step 5.5.10.2 - Business Homepage - Send business verification - Choose place popup - Choose a place");
        businessVerifyPage.chooseLocation(driver, "400/8b Ung Văn Khiêm, Phường 25, Bình Thạnh, Thành phố Hồ Chí Minh, Vietnam");
        log.info("Step 5.5.11 - Business Homepage - Send business verification - Enter zipcode");
        businessVerifyPage.enterValueToZipCodeField(driver,zipCode);
        log.info("Step 5.5.12 - Business Homepage - Send business verification - Enter company phone");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv109", companyPhone);
        log.info("Step 5.5.13 - Business Homepage - Send business verification - Enter company email");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv108", companyEmail);
        log.info("Step 5.5.14 - Business Homepage - Send business verification - Enter business scope");
        businessVerifyPage.enterValueToBusinessScopeTextarea(driver,businessScope);
        log.info("Step 5.5.15 - Business Homepage - Send business verification - Business verification papers");
        businessVerifyPage.clickToUploadDocumentVerify(driver, fileUploadImage2);
        log.info("Step 5.5.16 - Business Homepage - Send business verification - Click send verify request");
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
        verifyBusinessManagementPage.setTimeDelay(1);
        log.info("Step 6.3.6 - Confirm verification - Business verification management - Choose status verification");
        verifyBusinessManagementPage.chooseStatusVerification(driver, "Đang chờ xác minh");
        log.info("Step 6.3.7 - Confirm verification - Business verification management - Click button Filter");
        verifyBusinessManagementPage.clickToFilterButton(driver);
        log.info("Step 6.3.8 - Confirm verification - Business verification management - Check business display correct with filter");

        log.info("Step 6.3.9 - Confirm verification - Business verification management  - Click button Verify for redirect business");
        verifyBusinessManagementPage.clickVerifyButton(driver, businessName, ownerName,ownerEmail);
        log.info("Step 6.3.10 - Confirm verification - Business verification management  - Click button confirm verify business");
        verifyBusinessManagementPage.clickConfirmButtonOnPopup(driver);
        log.info("Step 6.3.11 - Confirm verification - Business verification management  - Check business verify success");
        verifyEquals(verifyBusinessManagementPage.getStatusOfBusinessVerification(),"Đã xác minh");
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
        walletOverviewPage.setTimeDelay(2);
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
        walletOverviewPage.clickToFinishButtonToCreatePaymentAccount(driver);
        walletHomePage = PageGeneration.createWalletHomepage(driver);
        log.info("Step 10.4 - Create Payment account - Wallet homepage");
        log.info("Step 10.4.1 - Create Payment account - Wallet homepage - Check page display success");
        verifyTrue(walletHomePage.checkPageIsDisplaySuccessfully());
        log.info("Step 10.4.2 - Create Payment account - Wallet homepage - Check payment Account is created successfully");
        verifyEquals(walletHomePage.getNameOfPaymentAccountDíplayOnPage(),paymentAccountName);
        log.info("Step 11.1 - Create Page Tour - Overview Business page");
        log.info("Step 11.1.1 - Create Page Tour - Overview Business page - Back to Business page");
        walletHomePage.openURL(driver,GlobalVariables.businessURL);
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
        verifyEquals(businessDashboardPage.getStatusVerifyOfBusiness(),"");
        log.info("Step 11.2.3 - Create Page Tour - Dashboard Business page - Check business have no page");
        verifyEquals(businessDashboardPage.getContentTitleOfSectionNoPage(),"");
        log.info("Step 11.2.4 - Create Page Tour - Dashboard Business page - Click button Create page now");
        businessDashboardPage.clickCreatePageNowButton();
        businessPageList = PageGeneration.openCreatePagePopup(driver);
        log.info("Step 11.3 - Create Page Tour - Create new page popup");
        log.info("Step 11.3.1 - Create Page Tour - Create new page popup - Check popup display");
        verifyTrue(businessPageList.checkPopupCreatePageDisplay());
        log.info("Step 11.3.2 - Create Page Tour - Create new page popup - Choose page type");
        businessPageList.choosePageType(driver);
        log.info("Step 11.3.3 - Create Page Tour - Create new page popup - Enter page name");
        businessPageList.enterPageNameToCreate(driver,pageTourName);
        log.info("Step 11.3.4 - Create Page Tour - Create new page popup - Click button to create page");
        businessPageList.clickToCreatePage(driver);
        setTimeDelay(2);
        log.info("Step 12.1 - Create Tour - Business page management");
        log.info("Step 12.1.1 - Create Tour - Business page management - Check page display success");
        verifyTrue(businessPageList.checkPageDisplaySuccess());
        log.info("Step 12.1.2 -  Create Tour - Business page management - Verify page created success");
        verifyTrue(businessPageList.checkCreatedPageSuccess());
        log.info("Step 12.1.3 - Create Page Tour - Business page management - Verify page information");
        verifyTrue(businessPageList.getOwnerOfDirectPage());
        String pageID = businessPageList.getPageIdOfDirectPage();
        log.info("Step 12.1.4 - Create Page Tour - Business page management - Go to page detail");
        businessPageList.clickPageManagementLinkToGoDetail(driver);
        tourDashboardPage = PageGeneration.createTourDashboardPage(driver);
        log.info("Step 12.2 - Create Page Tour - Tour Dashboard");
        log.info("Step 12.2.1 - Create Page Tour - TTour Dashboard - Check page display success");
        verifyTrue(tourDashboardPage.checkPageIsDisplay());
        log.info("Step 12.2.2 - Create Page Tour - TTour Dashboard - Click Setting General on Nav-bar menu");
        tourDashboardPage.gotoTourGeneralSettingPage();
        tourGeneralSettingPage = PageGeneration.createTourGeneralSettingPage(driver);
        setTimeDelay(2);
//        // Cập nhật Tour information
//        tourGeneralSettingPage.enterPrepaymentAmount(driver,"");
//        tourGeneralSettingPage.enterCancellationAmount(driver,"");
//        tourGeneralSettingPage.enterDayAllowToCancel(driver,"");
//        tourGeneralSettingPage.clickToSaveButton(driver);
//
//        tourGeneralSettingPage.clickToSettingVAT(driver);
//        tourGeneralSettingPage.chooseOptionVAT(driver);
//        tourGeneralSettingPage.clickToSaveButton(driver);
//
//        tourGeneralSettingPage.clickToSettingAge(driver);
//        tourGeneralSettingPage.enterValueOfAdultAge(driver,"");
//        tourGeneralSettingPage.enterValueOfChildAge(driver,"");
//        tourGeneralSettingPage.enterValueOfYoungChildAge(driver,"");
//        tourGeneralSettingPage.clickToSaveButton(driver);
//
//        tourGeneralSettingPage.clickToSettingOrderNoti(driver);
//        tourGeneralSettingPage.clickToEnableAllowNotiOrder(driver);
//        tourGeneralSettingPage.enterValueOnEmailAddress(driver,"");
//        tourGeneralSettingPage.enterValueOnPhone(driver,"");
//        tourGeneralSettingPage.clickToSaveButton(driver);
//
//        // Tạo Topic
//        tourGeneralSettingPage.clickToTopicTourOnMenu(driver);
//        tourTopicPage = PageGeneration.createTourTopicListPage(driver);
//        tourTopicPage.clickCreateTopic(driver);
//        tourTopicPage.chooseTopicImage();
//        tourTopicPage.chooseLanguageOfTopic(driver);
//        tourTopicPage.enterTopicName(driver,"");
//        tourTopicPage.enterTopicDescription(driver,"");
//        tourTopicPage.clickToSaveButton(driver);
//
//        // Tạo Tour
//        tourTopicPage.clickToTourOnMenu(driver);
//        tourManagementPage = PageGeneration.createTourManagementPage(driver);
//        tourManagementPage.clickToCreateTour(driver);
//        tourManagementPage.enterValueOfTourName(driver,"");
//        tourManagementPage.chooseTourType(driver);
//        tourManagementPage.chooseTourTopic(driver);
//        tourManagementPage.clickSaveButtonToCreateTour(driver);
//
//
//        // Tab Tour info
//        tourInformationTab = PageGeneration.createTourInfoTab(driver);
//
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
