package Testcase;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.HandleFunction.AbstractTest;
import Common.HandleFunction.PageGeneration;
import Interfaces.Business.BusinessDashboardPageUI;
import Project.Business.Business.*;
import Project.Business.Tour.Management.TourInfoTab;
import Project.Backend.BackendHomePage;
import Project.Backend.BackendVerifyBusinessManagement;
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

    DataHelper data = new DataHelper();

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
        signUpPage = PageGeneration.createFormRegister(driver);

    }
    @Test
    public void Test(){
        email = randomVirtualEmail();
        password = "1234567";
        confirmPass = "1234567";
        firstName = data.getFirstName();
        lastName = data.getLastName();

        log.info("Step 1 - Check title of form Signup");
        verifyEquals(signUpPage.getTitleOfFormSignUp(driver),"Tham gia Hahalolo ngay!");

        log.info("Step 2.1 - Enter first name");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv104", firstName);

        log.info("Step 2.2 - Enter last name");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv103", lastName);

        log.info("Step 2.3 - Enter email");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv108", email);

        log.info("Step 2.4 - Enter password");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"nv109", password);

        log.info("Step 2.5 - Enter confirm password");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,"repeatPassword", confirmPass);

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
        newsfeedHomePage.setTimeDelay(5);
        verifyEquals(newsfeedHomePage.getCurrentURL(driver),"https://test-newsfeed.hahalolo.com/");
        verifyEquals(newsfeedHomePage.getPageTitle(driver),"Bảng tin | Hahalolo");

        log.info("Step 5 - Update information on first time login");
        log.info("Step 5.1 - Update information - Verify form update information is display");
        verifyTrue(newsfeedHomePage.formFirstUpdateInfoIsDisplay());
        verifyEquals(newsfeedHomePage.getTitleOfFormFirstUpdateInfo(),"Xác minh tài khoản thành công!");

        log.info("Step 5.2 - Update information - Update birthday");
        newsfeedHomePage.updateBirthdayOfUser(driver,"12","10","1992");
        birthday = getBirthdayOnHaLo("12","10","1992");

        log.info("Step 5.3 - Update information - Update gender");
        newsfeedHomePage.updateGenderOfUser(driver,"male");
        gender = newsfeedHomePage.getGenderOfUser(driver,"male");

        log.info("Step 5.4 - Update information - Update nationality");
        newsfeedHomePage.updateNationalOfUser(driver,"VN");

        log.info("Step 5.5 - Update information - Click to confirm button");
        newsfeedHomePage.clickToButtonConfirmForUpdateInfo(driver);

        log.info("Step 6 - Verify information of account");
        log.info("Step 6.1 - Verify information of account - Change language system to Vi");
        newsfeedHomePage.changeLanguageNewsfeedToVI(driver);

        log.info("Step 6.2 - Verify information of account - Get full name on My account");
        fullName = newsfeedHomePage.getFullNameDisplayOnMyAccount(driver);

        log.info("Step 6.3 - Verify information of account - Verify full name register with full on display on My account");
        verifyEquals(fullName,getFullName(firstName,lastName));

        log.info("Step 6.4 - Verify information of account - Go to personal About");
        newsfeedHomePage.setTimeDelay(2);
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
        generalAccSetting.setTimeDelay(5);
        verifyTrue(generalAccSetting.checkAccountSettingPageIsDisplay());
        verifyEquals(generalAccSetting.getPageTitle(driver),"Cài đặt tài khoản | Hahalolo");
        log.info("Step 6.10 - Verify account information - Verify full name display On Setting Account with Full name on Register step and My account");
        verifyEquals(generalAccSetting.getFullNameIsDisplay(),getFullName(firstName,lastName));
        verifyEquals(generalAccSetting.getFullNameIsDisplay(),fullName);

        log.info("Step 7 - Create new business");
        log.info("Step 7.1 - Create new business - Go to business Page");
        generalAccSetting.clickToItemOnSettingMenu(driver,"ic-business-c");
        generalAccSetting.setTimeDelay(2);
        businessOverviewPage = PageGeneration.createBusinessOverviewPage(driver);
        businessOverviewPage.switchWindowByTitle(driver,"Hahalolo - Business Account");
//        verifyTrue(businessOverviewPage.checkBusinessOverviewWithNewAccount(driver));

        log.info("Step 7.2 - Create new business - Click button Create new business");
        businessOverviewPage.clickToCreateNewBusiness(driver);

        log.info("Step 7.3 - Create new business - Choose business type - Enterprise");
        businessOverviewPage.chooseTypeOfBusiness(driver, "type-business");

        log.info("Step 7.4 - Create new business - Enter business name");
        String businessName= "Hahalolo Company";
        businessOverviewPage.enterBusinessName(driver, businessName);

        log.info("Step 7.5 - Create new business - Update owner name");
        String ownerName= "Hồ Doãn Quốc Huy";
        businessOverviewPage.enterValueToUpdateOwnerName(driver, ownerName);

        log.info("Step 7.6 - Create new business - Update owner email");
        String businessEmail = "huyho1210@gmail.com";
        businessOverviewPage.enterValueToUpdateBusinessEmail(driver,businessEmail);

        log.info("Step 7.7 - Create new business - Click create business");
        businessOverviewPage.clickButtonToCreateBusiness(driver);
        businessDashboardPage = PageGeneration.createBusinessDashboardPage(driver);

        log.info("Step 8.1 - Verify business - Check status verification of business");
//        verifyEquals(businessDashboardPage.getStatusVerifyOfBusiness(),"");

        log.info("Step 8.2 - Send business verification - Click button verify business");
        businessDashboardPage.clickToVerifyBusiness(driver);
        businessVerifyPage = PageGeneration.createVerifyBusinessTypeEnterpriseForm(driver);

        log.info("Step 8.3 - Send business verification - Check Enterprise verification request display success");
//        verifyEquals(businessDashboardPage.getTitleOfFormVerificationRequest(),"");

        log.info("Step 8.4 - Send business verification - Enter company name");
        String companyName=  data.getCompanyName();
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv102",companyName);

        log.info("Step 8.5 - Send business verification - Enter other company name");
        String otherName= data.getCompanyName();
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv103",otherName);

        log.info("Step 8.6 - Send business verification - Enter Abbreviated company name");
        String abbName= data.getCompanyName();
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv104",abbName);

        log.info("Step 8.7 - Send business verification - Enter Tax code");
        String taxCode= data.getTaxCode();
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv105",taxCode);

        log.info("Step 8.8 - Send business verification - Choose Registration date");
        businessVerifyPage.chooseRegistrationDate(driver,"10","8","2018");

        log.info("Step 8.9 - Send business verification - Enter Representative name");
        String repName= data.getFullName();
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv107",repName);

        log.info("Step 8.9 - Send business verification - Enter Registration address");
        String registrationAddress= data.getFullAddress();
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv110",registrationAddress);

        log.info("Step 8.9 - Send business verification - Search with Registration address");
        businessVerifyPage.clickEnterToSearchAddress(driver);

        log.info("Step 8.9 - Send business verification - Enter zipcode");
        String zipCode=  data.getZipCode();
        businessVerifyPage.enterValueToZipCodeField(driver,zipCode);

        log.info("Step 8.9 - Send business verification - Enter company phone");
        String companyPhone= data.getCompanyPhone();
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv109",companyPhone);

        log.info("Step 8.9 - Send business verification - Enter company email");
        String companyEmail= data.getCompanyEmail();
        businessVerifyPage.enterValueToDynamicFieldOfVerifyForm(driver,"bv108",companyEmail);

        log.info("Step 8.9 - Send business verification - Enter business scope");
        String businessScope= "Buôn bán văn phòng phẩm";
        businessVerifyPage.enterValueToBusinessScopeTextarea(driver,businessScope);

//        log.info("Step 8.9 - Send business verification - Upload Documents - Business verification papers");
//        businessVerifyPage.clickToUploadDocumentVerify(driver);

        log.info("Step 8.9 - Send business verification - Click send verify request");
        businessVerifyPage.clickToSendRequestVerify(driver);

//        businessVerifyPage.clickToBackBusinessManagementPage(driver);
//        businessDashboardPage = PageGeneration.createBusiDashboardPage(driver);
//        businessDashboardPage.clickToBusinessInfoTab(driver);
//        businessInfoPage = PageGeneration.createBusinessInfoPage(driver);
//        verifyEquals(businessInfoPage.getOwnerNameIsDisplay(driver),"");
//        verifyEquals(businessInfoPage.getOwnerEmailIsDisplay(driver),"");
//
//        businessInfoPage.openBackendLoginPage(driver);
//        loginPage = PageGeneration.createLoginBackEndPage(driver);
//        loginPage.enterUserNameToLogin(driver,"");
//        loginPage.enterPasswordToLogin(driver,"");
//        loginPage.enterCaptchaCodeToLogin(driver,"");
//        loginPage.clickToLoginButton(driver);
//        backendHomePage = PageGeneration.createBackendHomepage(driver);
//        backendHomePage.clickToVerifyBusinessMenu(driver);
//
//        verifyBusinessManagementPage = PageGeneration.createVerifyBusinessManagement(driver);
//        verifyBusinessManagementPage.enterEmailBusinessForSearch(driver, "");
//        verifyBusinessManagementPage.clickToFilterButton(driver);
//        verifyBusinessManagementPage.clickVerifyButton(driver);
//        verifyBusinessManagementPage.clickConfirmButtonOnPopup(driver);
//
//        // Tạo tài khoản thanh toán
//        verifyBusinessManagementPage.goToWalletLoginPage(driver);
//        loginPage = PageGeneration.createWalletLoginPage(driver);
//        loginPage.enterUserNameToLogin(driver,"");
//        loginPage.enterPasswordToLogin(driver,"");
//        loginPage.enterCaptchaCodeToLogin(driver,"");
//        loginPage.clickToLoginButton(driver);
//
//        walletOverviewPage = PageGeneration.createWalletOverviewPage(driver);
//        walletOverviewPage.clickButtonCreateWallet(driver);
//        walletOverviewPage.enterPaymentAccountName(driver,"");
//        walletOverviewPage.chooseCurrencyOfAccount(driver);
//        walletOverviewPage.clickCreateAccountButton(driver);
//
//        walletHomePage = PageGeneration.createWalletHomepage(driver);
//
//        // Tạo Trang Tour
//        walletHomePage.openURL(driver,businessURL);
//        businessOverviewPage = PageGeneration.createBusinessOverviewPage(driver);
//        businessOverviewPage.clickToAccountManagementButton(driver);
//        businessDashboardPage = PageGeneration.createBusiDashboardPage(driver);
//        businessDashboardPage.clickToPageItemOnMenu(driver);
//        businessPageList = PageGeneration.clickToPageListManagement(driver);
//        businessPageList.clickButtonCreateNewPage(driver);
//        businessPageList.choosePageType(driver);
//        businessPageList.enterPageNameToCreate(driver,"");
//        businessPageList.clickToCreatePage(driver);
//        businessPageList.clickPageManagementLinkToGoDetail(driver);
//        tourDashboardPage = PageGeneration.createTourDashboardPage(driver);
//
//        tourDashboardPage.gotoTourGeneralSettingPage();
//        tourGeneralSettingPage = PageGeneration.createTourGeneralSettingPage(driver);
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
