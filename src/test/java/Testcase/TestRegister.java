package Testcase;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.HandleFunction.AbstractTest;
import Common.HandleFunction.PageGeneration;
import Interfaces.Business.BusinessDashboardPage;
import Project.Business.Tour.Management.TourInfoTab;
import Project.Backend.BackendHomePage;
import Project.Backend.BackendVerifyBusinessManagement;
import Project.Business.Business.BusinessInfoPage;
import Project.Business.Business.BusinessOverviewPage;
import Project.Business.Business.BusinessPageManagement;
import Project.Business.Business.BusinessVerificationPage;
import Project.Business.Tour.*;
import Project.Business.Tour.Management.TourManagementPage;
import Project.Newsfeed.Newsfeed.NewsfeedHomePage;
import Project.Newsfeed.PersonalWall.PersonalAboutPage;
import Project.Newsfeed.UserSetting.GeneralAccountSetting;
import Project.Shared.Login.LoginPage;
import Project.Shared.SingUp.SignUpPage;
import Project.Wallet.WalletHomePage;
import Project.Wallet.WalletOverviewPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestRegister extends AbstractTest {
    DriverManager driverManager;
    WebDriver driver;
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
    String firstName, lastName, email, password, confirmPass, birthday , gender;
    String newsfeedURL = "https://test-newsfeed.hahalolo.com/auth/signin";
    String businessURL = "https://test-business.hahalolo.com/";
    String backendURL = "https://test-backend.hahalolo.com/";
    String fullName;

    @Parameters("browser")
    @BeforeClass
    public void preconditionStep(String browserName) {
        log.info("Precondition - Step 1 - Create Browser Driver ");
        driverManager = BrowserInitialization.getBrowser(browserName);

        log.info("Precondition - Step 2 - Open browser and go to Newsfeed login");
        driver = driverManager.getDriver(newsfeedURL);
        loginPage = PageGeneration.createLoginPage(driver);

        log.info("Precondition - Change system language To Ví");
        loginPage.clickToChangeToVI(driver);

    }
    @Test
    public void Test(){
        email = randomVirtualEmail();
        password = "1234567";
        confirmPass = "1234567";
        firstName = "Huy";
        lastName = "Hồ";

        log.info("Step 1 - Check title of form Signup");
        verifyEquals(signUpPage.getTitleOfFormSignUp(driver),"Tham gia Hahalolo ngay!");

        log.info("Step 2.1 - Enter first name");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,firstName,"nv104");

        log.info("Step 2.2 - Enter last name");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,lastName,"nv103");

        log.info("Step 2.3 - Enter email");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,email,"nv108");

        log.info("Step 2.4 - Enter password");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,password,"nv109");

        log.info("Step 2.5 - Enter confirm password");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,confirmPass,"repeatPassword");

        log.info("Step 2.6 - Click to sign up new account - Go to verify account form");
        signUpPage.clickSignUpButton();

        log.info("Step 3.1 - Verify title of Verify account form");
        verifyTrue(signUpPage.getTitleOfVerifyForm().endsWith("email"));

        log.info("Step 3.2 - Verify account display on verify account form with email register on before step");
        verifyEquals(signUpPage.getUserAccountToDisplay(),email);

        log.info("Step 3.3 - Get code on email register");
        String code = signUpPage.getVerifyCodeByEmail(email);

        log.info("Step 3.4 - Paste code on email register to verify code field");
        signUpPage.enterVerifyCodeToVerifyAccount(driver,code);

        log.info("Step 3.5 - Click to verify button");
        signUpPage.clickToVerifyAccount(driver);
        newsfeedHomePage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 4 - Check newsfeed Homepage is display successfully");
        newsfeedHomePage.setTimeDelay(1);
        verifyEquals(newsfeedHomePage.getCurrentURL(driver),"https://test-newsfeed.hahalolo.com/");
        verifyEquals(newsfeedHomePage.getPageTitle(driver),"Bảng tin | Hahalolo");

        log.info("Step 5 - Update information on first time login");
        log.info("Step 5.1 - Update information - Verify form update information is display");
        verifyTrue(newsfeedHomePage.formFirstUpdateInfoIsDisplay(driver));
        verifyEquals(newsfeedHomePage.getTitleOfFormFirstUpdateInfo(),"");

        log.info("Step 5.2 - Update information - Update birthday");
        newsfeedHomePage.updateBirthdayOfUser(driver);

        log.info("Step 5.3 - Update information - Update gender");
        newsfeedHomePage.updateGenderOfUser(driver);

        log.info("Step 5.4 - Update information - Update nationality");
        newsfeedHomePage.updateNationalOfUser(driver);

        log.info("Step 5.5 - Update information - Click to confirm button");
        newsfeedHomePage.clickToButtonConfirmForUpdateInfo(driver);

        log.info("Step 6 - Verify information of account");
        log.info("Step 6.1 - Verify information of account - Change language system to Vi");
        newsfeedHomePage.changeLanguageNewsfeedToVI(driver);

        log.info("Step 6.2 - Verify information of account - Get full name on My account");
        fullName = newsfeedHomePage.getFullNameDisplayOnMyAccount(driver);

        log.info("Step 6.3 - Verify information of account - Verify full name register with full on display on My account");
        verifyEquals(fullName,"");

        log.info("Step 6.4 - Verify information of account - Go to personal About");
        newsfeedHomePage.clickToEditProfile(driver);
        perAboutPage = PageGeneration.createPerTAboutPage(driver);

        log.info("Step 6.5 - Verify information of account - Verify email on Introduce widget with registered email");
        verifyEquals(perAboutPage.getEmailIsDisplayOnIntroduceWidget(),email);

        log.info("Step 6.6 - Verify information of account - Verify birthday on Introduce widget with updated birthday on step Update Information");
        verifyEquals(perAboutPage.getBirthdayDisplayOnIntroduceWidget(),birthday);

        log.info("Step 6.7 - Verify information of account - Verify gender on Introduce widget with updated gender on step Update Information");
        verifyEquals(perAboutPage.getGenderDisplayOnIntroduceWidget(),gender);

        log.info("Step 6.8 - Verify information of account - Click to Account setting");
        perAboutPage.clickToItemOnSettingMenu(driver,"ic-cog-c");
        generalAccSetting = PageGeneration.createGeneralAccountSettingPage(driver);

        log.info("Step 6.9 - Verify account information - Click to Account setting");
        verifyTrue(generalAccSetting.checkAccountSettingPageIsDisplay());
        verifyEquals(generalAccSetting.getPageTitle(driver),"Cài đặt tài khoản | Hahalolo");
        generalAccSetting.setTimeDelay(1);

        log.info("Step 6.10 - Verify account information - Verify full name display On Setting Account with Full name on Register step and My account");
        verifyEquals(generalAccSetting.getFullNameIsDisplay(),"");
        verifyEquals(generalAccSetting.getFullNameIsDisplay(),fullName);

        log.info("Step 7 - Create new business");
        log.info("Step 7.1 - Create new business - Go to business Page");
        generalAccSetting.clickToItemOnSettingMenu(driver,"ic-business-c");
        businessOverviewPage = PageGeneration.createBusinessOverviewPage(driver);
        verifyTrue(businessOverviewPage.checkBusinessOverviewWithNewAccount(driver));

        log.info("Step 7.1 - Create new business - Click button Create new bussiness");
        businessOverviewPage.clickToCreateNewBusiness(driver);
        businessOverviewPage.chooseTypeOfBusiness(driver, "");
        businessOverviewPage.enterBusinessName(driver,"");
        businessOverviewPage.enterValueToUpdateOwnerName(driver,"");
        businessOverviewPage.enterValueToUpdateBusinessEmail(driver,"");
        businessOverviewPage.clickButtonToCreateBusiness(driver);
        businessDashboardPage = PageGeneration.createBusiDashboardPage(driver);
        verifyEquals(businessDashboardPage.getStatusVerifyOfBusiness(),"");
        businessDashboardPage.clickToVerifyBusiness(driver);
        businessVerifyPage = PageGeneration.createVerifyBusinessTypeEnterpriseForm(driver);

        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv102",companyName);
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv103",otherName);
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv104",abbName);
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv105",taxCode);
        businessVerifyPage.chooseRegistrationDate(driver,"","","");
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv107",repName);
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv110",registAddress);
        businessVerifyPage.clickEnterToSearchAddress(driver);
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"",zipCode);
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"",companyPhone);
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"",companyEmail);
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"",businessScope);
        businessVerifyPage.clickToUploadDocumentVerify(driver);
        businessVerifyPage.clickToSendRequestVerify(driver);

        businessVerifyPage.clickToBackBusinessManagementPage(driver);
        businessDashboardPage = PageGeneration.createBusiDashboardPage(driver);
        businessDashboardPage.clickToBusinessInfoTab(driver);
        businessInfoPage = PageGeneration.createBusinessInfoPage(driver);
        verifyEquals(businessInfoPage.getOwnerNameIsDisplay(driver),"");
        verifyEquals(businessInfoPage.getOwnerEmailIsDisplay(driver),"");

        businessInfoPage.openBackendLoginPage(driver);
        loginPage = PageGeneration.createLoginBackEndPage(driver);
        loginPage.enterUserNameToLogin(driver,"");
        loginPage.enterPasswordToLogin(driver,"");
        loginPage.enterCaptchaCodeToLogin(driver,"");
        loginPage.clickToLoginButton(driver);
        backendHomePage = PageGeneration.createBackendHomepage(driver);
        backendHomePage.clickToVerifyBusinessMenu(driver);

        verifyBusinessManagementPage = PageGeneration.createVerifyBusinessManagement(driver);
        verifyBusinessManagementPage.enterEmailBusinessForSearch(driver, "");
        verifyBusinessManagementPage.clickToFilterButton(driver);
        verifyBusinessManagementPage.clickVerifyButton(driver);
        verifyBusinessManagementPage.clickConfirmButtonOnPopup(driver);

        // Tạo tài khoản thanh toán
        verifyBusinessManagementPage.goToWalletLoginPage(driver);
        loginPage = PageGeneration.createWalletLoginPage(driver);
        loginPage.enterUserNameToLogin(driver,"");
        loginPage.enterPasswordToLogin(driver,"");
        loginPage.enterCaptchaCodeToLogin(driver,"");
        loginPage.clickToLoginButton(driver);

        walletOverviewPage = PageGeneration.createWalletOverviewPage(driver);
        walletOverviewPage.clickButtonCreateWallet(driver);
        walletOverviewPage.enterPaymentAccountName(driver,"");
        walletOverviewPage.chooseCurrencyOfAccount(driver);
        walletOverviewPage.clickCreateAccountButton(driver);

        walletHomePage = PageGeneration.createWalletHomepage(driver);

        // Tạo Trang Tour
        walletHomePage.openURL(driver,businessURL);
        businessOverviewPage = PageGeneration.createBusinessOverviewPage(driver);
        businessOverviewPage.clickToAccountManagementButton(driver);
        businessDashboardPage = PageGeneration.createBusiDashboardPage(driver);
        businessDashboardPage.clickToPageItemOnMenu(driver);
        businessPageList = PageGeneration.clickToPageListManagement(driver);
        businessPageList.clickButtonCreateNewPage(driver);
        businessPageList.choosePageType(driver);
        businessPageList.enterPageNameToCreate(driver,"");
        businessPageList.clickToCreatePage(driver);
        businessPageList.clickPageManagementLinkToGoDetail(driver);
        tourDashboardPage = PageGeneration.createTourDashboardPage(driver);

        tourDashboardPage.gotoTourGeneralSettingPage();
        tourGeneralSettingPage = PageGeneration.createTourGeneralSettingPage(driver);
        // Cập nhật Tour information
        tourGeneralSettingPage.enterPrepaymentAmount(driver,"");
        tourGeneralSettingPage.enterCancellationAmount(driver,"");
        tourGeneralSettingPage.enterDayAllowToCancel(driver,"");
        tourGeneralSettingPage.clickToSaveButton(driver);

        tourGeneralSettingPage.clickToSettingVAT(driver);
        tourGeneralSettingPage.chooseOptionVAT(driver);
        tourGeneralSettingPage.clickToSaveButton(driver);

        tourGeneralSettingPage.clickToSettingAge(driver);
        tourGeneralSettingPage.enterValueOfAdultAge(driver,"");
        tourGeneralSettingPage.enterValueOfChildAge(driver,"");
        tourGeneralSettingPage.enterValueOfYoungChildAge(driver,"");
        tourGeneralSettingPage.clickToSaveButton(driver);

        tourGeneralSettingPage.clickToSettingOrderNoti(driver);
        tourGeneralSettingPage.clickToEnableAllowNotiOrder(driver);
        tourGeneralSettingPage.enterValueOnEmailAddress(driver,"");
        tourGeneralSettingPage.enterValueOnPhone(driver,"");
        tourGeneralSettingPage.clickToSaveButton(driver);

        // Tạo Topic
        tourGeneralSettingPage.clickToTopicTourOnMenu(driver);
        tourTopicPage = PageGeneration.createTourTopicListPage(driver);
        tourTopicPage.clickCreateTopic(driver);
        tourTopicPage.chooseTopicImage();
        tourTopicPage.chooseLanguageOfTopic(driver);
        tourTopicPage.enterTopicName(driver,"");
        tourTopicPage.enterTopicDescription(driver,"");
        tourTopicPage.clickToSaveButton(driver);

        // Tạo Tour
        tourTopicPage.clickToTourOnMenu(driver);
        tourManagementPage = PageGeneration.createTourManagementPage(driver);
        tourManagementPage.clickToCreateTour(driver);
        tourManagementPage.enterValueOfTourName(driver,"");
        tourManagementPage.chooseTourType(driver);
        tourManagementPage.chooseTourTopic(driver);
        tourManagementPage.clickSaveButtonToCreateTour(driver);


        // Tab Tour info
        tourInformationTab = PageGeneration.createTourInfoTab(driver);
        tourInformationTab.enterValueToSKUField(driver, "");
        tourInformationTab.enterValueOfTotalTour(driver, "");
        tourInformationTab.enterValueOfPriceBasic(driver,"");
        tourInformationTab.enterValueOfTimeAllowBooking(driver,"");
        tourInformationTab.enterValueOfTAddress(driver,"");
        tourInformationTab.chooseCountry(driver,"");
        tourInformationTab.chooseCityState(driver,"");
        tourInformationTab.chooseWard(driver,"");
        tourInformationTab.enterValueOfShortDesc(driver, "");
        tourInformationTab.enterValueOPrivateRegulations(driver, "");
        tourInformationTab.enterValueOPolicy(driver, "");
        tourInformationTab.enterValueOInstallmentPolicy(driver, "");
        tourInformationTab.chooseTourLogo(driver);
        tourInformationTab.chooseTourCover(driver);
        tourInformationTab.chooseTourGallery(driver);
        tourInformationTab.clickToButtonSaveTour();
        tourInformationTab.clickToPartOnNav(driver);

        // Tab Tour part
        tourPartTab = PageGeneration.createTourPartTab(driver);
        tourPartTab.clickToCreateNewPartButton();
        tourPartTab.enterValueToPartNameField(driver, partName);
        tourPartTab.enterValueDateOfPart(driver, dayOfPart);
        tourPartTab.enterValueOfPartTime(driver,timePart);
        tourPartTab.enterValueOfAddress(driver, address);
        tourPartTab.chooseCountry(driver);
        tourPartTab.chooseCityState(driver);
        tourPartTab.chooseWard(driver);
        tourPartTab.enterValueOfPartShortDescription(driver,"");
        tourPartTab.chooseTransportItem(driver);
        tourPartTab.choosePartLogo(driver);
        tourPartTab.clickToButtonSavePart(driver);
        tourPartTab.clickToPriceOnTourNavigationMenu(driver);


        // Tab Tour part
        tourPriceTab = PageGeneration.createTourPriceTab(driver);
        tourPriceTab.clickToCreateNewPrice(driver);
        tourPriceTab.chooseStartDateOfPrice(driver);
        tourPriceTab.enterValueOfAdultPrice(driver,"");
        tourPriceTab.enterValueOfChildPrice(driver,"");
        tourPriceTab.enterValueOfYoungChildPrice(driver, "");
        tourPriceTab.enterValueOfInfantPrice(driver,"");
        tourPriceTab.clickToSavePriceButton(driver);
        tourPriceTab.clickToSchedulerSetting(driver);


        // Tab Tour scheduler
        tourScheduler = PageGeneration.createTourScheduler(driver);
        tourScheduler.chooseDateToOpenSaleTour(driver);

        tourScheduler.clickToServiceSetting(driver);

    }
}
