package Common.HelperFunction;


import Project.Business.Promotion.DetailPromo;
import Project.Business.Promotion.Promotion;
import Project.Business.Promotion.TourPromotion;
import Project.Business.Tour.Setting.PubishPage;
import Project.Shared.Login.LoginPage;
import Project.Backend.BackendHomePage;
import Project.Backend.BackendVerifyBusiManagement;
import Project.Business.Business.*;
import Project.Business.Tour.Management.Detail.*;
import Project.Business.Tour.Management.List.TourManagementPage;
import Project.Business.Tour.Setting.TourGeneralSettingPage;
import Project.Business.Tour.Topic.TourTopicPage;
import Project.Business.Tour.TourDashboardPage;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.PersonalAboutPage;
import Project.Newsfeed.AccountSetting.GeneralAccountSetting;
import Project.Shared.SingUp.SignUpPage;
import Project.Wallet.WalletHomePage;
import Project.Wallet.WalletOverviewPage;
import org.openqa.selenium.WebDriver;

public class PageGeneration {

    public static LoginPage createNewsfeedLoginPage(WebDriver driver) {
        return new LoginPage(driver);
    }

    public static SignUpPage createFormRegister(WebDriver driver) {
        return new SignUpPage(driver);
    }

    public static NewsfeedHomepage createNewsfeedHomepage(WebDriver driver) {
        return new NewsfeedHomepage(driver);
    }

    public static PersonalAboutPage createPerTAboutPage(WebDriver driver) {
        return new PersonalAboutPage(driver);
    }

    public static GeneralAccountSetting createGeneralAccountSettingPage(WebDriver driver) {
        return new GeneralAccountSetting(driver);
    }

    public static BusinessOverviewPage createBusinessOverviewPage(WebDriver driver) {
        return new BusinessOverviewPage(driver);
    }

    public static BusinessDashboardPage createBusinessDashboardPage(WebDriver driver) {
        return new BusinessDashboardPage(driver);
    }

    public static BusinessVerificationRequest createVerifyBusinessTypeEnterpriseForm(WebDriver driver) {
        return new BusinessVerificationRequest(driver);
    }

    public static BusinessInfoPage createBusinessInfoPage(WebDriver driver) {
        return new BusinessInfoPage(driver);
    }

    public static LoginPage createLoginBackEndPage(WebDriver driver) {
        return new LoginPage(driver);
    }

    public static BackendHomePage createBackendHomepage(WebDriver driver) {
        return new BackendHomePage(driver);
    }

    public static BackendVerifyBusiManagement createVerifyBusinessManagement(WebDriver driver) {
        return new BackendVerifyBusiManagement(driver);
    }

    public static LoginPage createWalletLoginPage(WebDriver driver) {
        return new LoginPage(driver);
    }

    public static WalletOverviewPage createWalletOverviewPage(WebDriver driver) {
        return new WalletOverviewPage(driver);
    }

    public static BusinessPageManagement goToPageListManagement(WebDriver driver) {
        return new BusinessPageManagement(driver);
    }

    public static TourDashboardPage createTourDashboardPage(WebDriver driver) {
        return new TourDashboardPage(driver);
    }

    public static TourGeneralSettingPage createTourGeneralSettingPage(WebDriver driver) {
        return new TourGeneralSettingPage(driver);
    }

    public static TourTopicPage createTourTopicListPage(WebDriver driver) {
        return new TourTopicPage(driver);
    }

    public static TourManagementPage createTourManagementPage(WebDriver driver) {
        return new TourManagementPage(driver);
    }

    public static WalletHomePage createWalletHomepage(WebDriver driver) {
        return new WalletHomePage(driver);
    }

    public static TourInfoTab createTourInfoTab(WebDriver driver) {
        return new TourInfoTab(driver);
    }

    public static BusinessPageManagement openCreatePagePopup(WebDriver driver) {
        return new BusinessPageManagement(driver);
    }

    public static TourPartTab createTourPartTab(WebDriver driver) {
        return new TourPartTab(driver);
    }

    public static TourPriceTab createTourPriceTab(WebDriver driver) {
        return new TourPriceTab(driver);
    }

    public static TourServiceTab createTourServiceTab(WebDriver driver) {
        return new TourServiceTab(driver);
    }

    public static TourSchedulerTab createTourSchedulerTab(WebDriver driver) {
        return new TourSchedulerTab(driver);
    }

    public static TourPromotionTab createTourPromotionTab(WebDriver driver) {
        return new TourPromotionTab(driver);
    }

    public static TourSettingTab createTourSettingTab(WebDriver driver) {
        return new TourSettingTab(driver);
    }

    public static TourServicePrice createTourServicePriceTab(WebDriver driver) {
        return new TourServicePrice(driver);
    }

    public static TourPromotion goToCreateEditPromotionPage(WebDriver driver) {
        return new TourPromotion(driver);
    }

    public static PubishPage createPageSetting(WebDriver driver) {
        return new PubishPage(driver);
    }

    public static DetailPromo createViewDetailPromoPage(WebDriver driver) {
        return new DetailPromo(driver);
    }
}