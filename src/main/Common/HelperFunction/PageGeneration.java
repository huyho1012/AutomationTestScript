package Common.HelperFunction;


import Project.Business.Promotion.DetailPromo;
import Project.Business.Promotion.TourPromotion;
import Project.Business.Tour.Setting.PubishPage;
import Project.Newsfeed.AccountSetting.GeneralAccountSetting;
import Project.Newsfeed.Boooking.BoookingTour;
import Project.Newsfeed.Boooking.PaymentGateWay.Stripe_PageObject;
import Project.Newsfeed.Boooking.PaymentInfo;
import Project.Newsfeed.Newsfeed.Header.ChangeCurrency_PageObject;
import Project.Newsfeed.PageWall.TourDetail;
import Project.Newsfeed.PersonalWall.About.*;
import Project.Newsfeed.PersonalWall.Handnote.Handnote_Tour;
import Project.Newsfeed.PersonalWall.Timeline.NewsfeedPersonalTimeline;
import Project.Shared.Login_PageObject;
import Project.Backend.BackendHomePage;
import Project.Backend.BackendVerifyBusiManagement;
import Project.Business.Business.*;
import Project.Business.Tour.Management.Detail.*;
import Project.Business.Tour.Management.List.TourManagementPage;
import Project.Business.Tour.Setting.TourGeneralSettingPage;
import Project.Business.Tour.Topic.TourTopicPage;
import Project.Business.Tour.TourDashboardPage;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Shared.SignUp_PageObject;
import Project.Wallet.WalletHomePage;
import Project.Wallet.WalletOverviewPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageGeneration {

    public static Login_PageObject createNewsfeedLoginPage(WebDriver driver) {
        return new Login_PageObject(driver);
    }

    public static SignUp_PageObject createFormRegister(WebDriver driver) {
        return new SignUp_PageObject(driver);
    }

    public static NewsfeedHomepage createNewsfeedHomepage(WebDriver driver) {
        return new NewsfeedHomepage(driver);
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

    public static Login_PageObject createLoginBackEndPage(WebDriver driver) {
        return new Login_PageObject(driver);
    }

    public static BackendHomePage createBackendHomepage(WebDriver driver) {
        return new BackendHomePage(driver);
    }

    public static BackendVerifyBusiManagement createVerifyBusinessManagement(WebDriver driver) {
        return new BackendVerifyBusiManagement(driver);
    }

    public static Login_PageObject createWalletLoginPage(WebDriver driver) {
        return new Login_PageObject(driver);
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

    public static TourDetail createTourDetailBookingPage(WebDriver driver) {
        return new TourDetail(driver);
    }

    public static BoookingTour createTourBookingPage(WebDriver driver) {
        return new BoookingTour(driver);
    }

    public static PaymentInfo createPaymentInfo(WebDriver driver) {
        return new PaymentInfo(driver);
    }

    public static Handnote_Tour createTourHandnotePage(WebDriver driver) {
        return new Handnote_Tour(driver);
    }

    public static Stripe_PageObject createPaymentWithStripe(WebDriver driver) {
        return new Stripe_PageObject(driver);
    }

    public static PaymentInfo createPageBookingSuccess(WebDriver driver) {
        return new PaymentInfo(driver);
    }

    public static NewsfeedPersonalTimeline createPersonalTimeLinePage(WebDriver driver) {
        return new NewsfeedPersonalTimeline(driver);
    }

    public static PerAbout_Overview_PageObject createPerAboutOverviewTab(WebDriver driver) {
        return new PerAbout_Overview_PageObject(driver);
    }

    public static PerAbout_WorkAndEducation_PageObject createPerAboutWorkEducationTab(WebDriver driver) {
        return new PerAbout_WorkAndEducation_PageObject(driver);
    }

    public static PerAbout_PlacesYouLived_PageObject createPerAboutPlaceLivingTab(WebDriver driver){
        return new PerAbout_PlacesYouLived_PageObject(driver);
    }
    public static PerAbout_BasicInfoAndContact_PageObject createperBasicInfoAndContactPage(WebDriver driver) {
        return new PerAbout_BasicInfoAndContact_PageObject(driver);
    }

    public static PerAbout_DetailsAboutYou_PageObject createPersonalDetailsAboutYouTab(WebDriver driver) {
        return new PerAbout_DetailsAboutYou_PageObject(driver);
    }

    public static ChangeCurrency_PageObject openModelChangeCurrency(WebDriver driver) {
        return new ChangeCurrency_PageObject(driver);
    }


}