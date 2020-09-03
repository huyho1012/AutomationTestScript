package Testcase;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.HandleFunction.AbstractTest;
import Common.HandleFunction.PageGeneration;
import Interfaces.Newsfeed.Homepage.NewsfeedHomePage;
import Project.Shared.Login.LoginPage;
import Project.Shared.SingUp.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import sun.jvm.hotspot.debugger.Page;

public class TestRegister extends AbstractTest {
    DriverManager driverManager;
    WebDriver driver;
    NewsfeedHomePage newsfeedHomePage;
    PersonalAboutPage perAboutPage;
    GeneralAccountSetting generalAccSetting;
    businessOverviewPage busiOverviewPage;
    SignUpPage signUpPage;
    String firstName, lastName, email, password, confirmPass, birthday , gender;
    @Parameters("browser")
    @BeforeClass
    public void preconditionStep(String browserName) {
        driverManager = BrowserInitialization.getBrowser(browserName);
        driver = driverManager.getDriver("https://test-newsfeed.hahalolo.com/auth/signin");
        signUpPage = PageGeneration.createFormRegister(driver);
    }
    @Test
    public void Test(){
        email = randomVirtualEmail();
        password = "1234567";
        confirmPass = "1234567";
        firstName = "Huy";
        lastName = "Hồ";
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,firstName,"");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,lastName,"");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,email,"");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,password,"");
        signUpPage.enterDataValueToDynamicOnFormSignUp(driver,confirmPass,"");
        signUpPage.clickSignUpButton(driver);

        verifyTrue(signUpPage.getTitleOfVerifyForm(driver).endsWith("email"));
        verifyEquals(signUpPage.getUserAccountToDisplay(driver),email);
        String code = signUpPage.getVerifyCodeByEmail(email);
        signUpPage.enterVerifyCodeToVerifyAccount(driver,code);
        signUpPage.clickToVerifyAccount(driver);
        newsfeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
        newsfeedHomePage.setTimeDelay(1);
        verifyTrue(newsfeedHomePage.formFirstUpdateInfoIsDisplay(driver));
        newsfeedHomePage.clickToUpdateBirthday(driver);
        newsfeedHomePage.clickToUpdateGender(driver);
        newsfeedHomePage.clickToUpdateGender(driver);
        newsfeedHomePage.clickToUpdateCountry(driver);
        newsfeedHomePage.clickToConfirmUpdate(driver);
        newsfeedHomePage.changeLanguageNewsfeedToVI(driver);

        String fullName = newsfeedHomePage.getFullNameDisplayOnMyAccounbt(driver);
        newsfeedHomePage.clickToEditProfile(driver);
        perAboutPage = PageGeneration.createPerTAboutPage(driver);
        verifyEquals(perAboutPage.getEmailIsDisplayOnIntroduceWidget(),email);
        verifyEquals(perAboutPage.getBirthdayDisplayOnIntroduceWidget(),birthday);
        verifyEquals(perAboutPage.getGenderDisplayOnIntroduceWidget(),gender);


        newsfeedHomePage.changeLanguageNewsfeedToVI(driver);
        newsfeedHomePage.setTimeDelay(1);
        perAboutPage.clickToAccountSetting(driver);
        generalAccSetting = PageGeneration.createGeneralAccountSettingPage(driver);
        generalAccSetting.setTimeDelay(1);
        verifyEquals(generalAccSetting.getFullNameIsDisplay(driver),"");

        generalAccSetting.clickToBussinessAccount(driver);
        busiOverviewPage = PageGeneration.createBusinessOverviewPage(driver);
        verifyTrue(busiOverviewPage.checkBusinessOverviewPageWhenNoBusi(driver));
        busiOverviewPage.clickToCreateNewBusiness(driver);
        busiOverviewPage.chooseTypeOfBusiness(driver, ""),
        busiOverviewPage.enterBusinessName(driver,"");
        busiOverviewPage.enterToUpdateOwnerName(driver,"");
        busiOverviewPage.enterToUpdateBussinessEmail(driver,"");
        busiOverviewPage.clickToCreateBussiness(driver);
        busiDashboardPage = PageGeneration.createBusiDashboard(driver);
        verifyTrue(busiDashboardPage.checkStatusVerifyOfBusiness);
        busiDashboardPage.clickToVerifyBusiness(driver);
        businessVerifyPage = PageGeneration.createVerifyBusinessForm(driver);

        businessVerifyPage.enterValueToDynamicFieldOnVerifyBusinessForm(driver,"",companyName);
        businessVerifyPage.enterValueToDynamicFieldOnVerifyBusinessForm(driver,"",otherCompanyName);
        businessVerifyPage.enterValueToDynamicFieldOnVerifyBusinessForm(driver,"",abbCompanyName);
        businessVerifyPage.enterValueToDynamicFieldOnVerifyBusinessForm(driver,"",taxCode);
        businessVerifyPage.enterValueToDynamicFieldOnVerifyBusinessForm(driver,"",representativeName);
        businessVerifyPage.enterValueToDynamicFieldOnVerifyBusinessForm(driver,"",registrationAddress);
        businessVerifyPage.clickEnterToSearchAddress(driver);
        businessVerifyPage.enterValueToDynamicFieldOnVerifyBusinessForm(driver,"",zipCode);
        businessVerifyPage.enterValueToDynamicFieldOnVerifyBusinessForm(driver,"",companyPhone);
        businessVerifyPage.enterValueToDynamicFieldOnVerifyBusinessForm(driver,"",companyEmail);
        businessVerifyPage.enterValueToDynamicFieldOnVerifyBusinessForm(driver,"",businessScope);
        businessVerifyPage.clickToUploadDocumentVerify(driver, filename);
        businessVerifyPage.clickToSendRequestVerify(driver);

        businessVerify.clickToBackBusiManagementPage(driver);
        busiDashboardPage = PageGeneration.createBusiDashboard(driver);
        busiDashboardPage.clickToBusiInfo(driver);
        busiInfoPage = PageGeneration.createBusiInfoPage(driver);
        verifyTrue(busiInfoPage.checkOwnerNameIsDisplay(driver),"");
        verifyTrue(busiInfoPage.checkOwnerEmailIsDisplay(driver),"");

        busiInfoPage.openBackendLoginPage(driver);
        loginBackendPage = PageGeneration.createLoginBackEndPage(driver);
        loginBackendPage.enterValueOfAdmindUsername(driver,"");
        loginBackendPage.enterValueOfPassWordUsername(driver,"");
        loginBackendPage.enterCaptchaCode(driver,"");
        loginBackendPage.clickToLoginButton(driver);
        backendHomepage = PageGeneration.createBackendDashboard(driver);
        backendHomepage.clickToVerifyBusinessMenu(driver);

        verifyBusinessBackend = PageGeneration.createVerifyBussinessManagement(driver);
        verifyBusinessBackend.enterEmailBusinessForSearch(driver, "");
        verifyBusinessBackend.clickToFilterButton(driver);
        verifyBusinessBackend.clickVerifyButton(driver);
        verifyBusinessBackend.clickConfirmButtonOnPopup(driver);

        // Tạo tài khoản thanh toán
        verifyBusinessBackend.goToWalletLoginPage(driver);
        walletLoginPage = PageGeneration.createWalletLoginPage(driver);
        walletLoginPage.enterUsernameToLoginWallet(driver,"");
        walletLoginPage.enterPasswordToLoginWallet(driver,"");
        walletLoginPage.enterCaptchaToLoginWallet(driver,"");
        walletLoginPage.clickToButtonLoginForWallet(driver);

        walletOverviewPage = PageGeneration.createWalletOverview(driver);
        walletOverviewPage.clickButtonCreateWallet(driver);
        walletOverviewPage.enterPaymentAccountName(driver,"");
        walletOverviewPage.chooseCurrencyOfAccount(driver);
        walletOverviewPage.clickCreateAccountButton(driver);

        walletHomePage = PageGeneration.createWalletHomepage(driver);

        // Tạo Trang Tour
        walletHomePage.goToBussinessPage(driver,URL_BUSI);
        busiOverviewPage = PageGeneration.createBusinessOverviewPage(driver);
        busiOverviewPage.clickToAccountManagementButton(driver);
        busiDashboardPage = PageGeneration.createBusiDashboard(driver);
        busiDashboardPage.clickToPageItemOnMenu(driver);
        busiPageManagementPage = PageGeneration.clickToPageManagementpage(driver);
        busiPageManagementPage.clickButtonCreateNewPage(driver);
        busiPageManagementPage.choosePageType(driver);
        busiPageManagementPage.enterPageNameToCreate(driver,"");
        busiPageManagementPage.clickToCreatePage(driver);
        busiPageManagementPage.clickToTourPageDetail(driver);
        tourDashboardPage = PageGeneration.createTourDashboardPage(driver);
        // Cập nhật Tour information
        tourGeneralSetting.enterPrepaymentAmount(driver,"");
        tourGeneralSetting.enterCancellationAmount(driver,"");
        tourGeneralSetting.enterDayAllowToCancel(driver,"");
        tourGeneralSetting.clickToSaveButton(driver);

        tourGeneralSetting.clickToSettingVAT(driver);
        tourGeneralSetting.chooseOptionVAT(driver);
        tourGeneralSetting.clickToSaveButton(driver);

        tourGeneralSetting.clickToSettingAge(driver);
        tourGeneralSetting.enterValueOfAdultAge(driver,"");
        tourGeneralSetting.enterValueOfChildAge(driver,"");
        tourGeneralSetting.enterValueOfYoungChildAge(driver,"");
        tourGeneralSetting.clickToSaveButton(driver);

        tourGeneralSetting.clickToSettingOrderNoti(driver);
        tourGeneralSetting.clickToEnableAllowNotiOrder(driver);
        tourGeneralSetting.enterValueOnEmailAddress(driver,"");
        tourGeneralSetting.enterValueOnPhone(driver,"");
        tourGeneralSetting.clickToSaveButton(driver);

        // Tạo Topic
        tourGeneralSetting.clickToTopicTourOnMenu(driver);
        tourTopicPage = PageGeneration.createTourTopicListPage(driver);
        tourTopicPage.clickCreateTopic(driver);
        tourTopicPage.chooseTopicImage();
        tourTopicPage.chooseLanguageOfTopic(driver);
        tourTopicPage.enterTopicName(driver,"");
        tourTopicPage.enterTopicDescription(driver,"");
        tourTopicPage.clickToSaveButton(driver);

        // Tạo Tour
        tourTopicPage.clickToTourOnMenu(driver);
        tourListPage = PageGeneration.createTourListPage(driver);
        tourListPage.clickToCreateTour(driver);
        tourListPage.enterTourName(driver,"");
        tourListPage.chooseTourType(driver);
        tourListPage.chooseTourTopic(driver);
        tourListPage.clickSaveButtonToCreateTour(driver);

        tourDetailPage = PageGeneration.createTourDetailDetails(driver);
        tourDetailPage.clickToTourInfoTab(driver);
        tourDetailPage.enterValueToSKUField(driver, skuCode);
        tourDetailPage.enterValueOfTotalTour(driver, totalDay);
        tourDetailPage.enterValueOfPriceBasic(driver, basicPrice);
        tourDetailPage.enterValueOfTimeAllowBooking(driver, timeAllowBooking);
        tourDetailPage.enterValueOfTAddress(driver, timeAllowBooking);
        tourDetailPage.chooseCountry(driver);
        tourDetailPage.chooseCityState(driver);
        tourDetailPage.chooseWard(driver);
        tourDetailPage.enterValueOfShortDesc(driver, shortDesc);
        tourDetailPage.enterValueOPrivateRegulations(driver, regulation);
        tourDetailPage.enterValueOPolicy(driver, policy);
        tourDetailPage.enterValueOInstallmentPolicy(driver, installmentPolicy);
        tourDetailPage.chooseTourLogo(driver);
        tourDetailPage.chooseTourCover(driver);
        tourDetailPage.chooseTourGallery(driver);
        tourDetailPage.clickToButtonSave;
        tourDetailPage.clickToPartOnNav(driver);

    }
}
