package Common.HandleFunction;

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

public class PageGeneration {

    public static LoginPage createLoginPage(WebDriver driver){
        return new LoginPage(driver);
    }
    public static SignUpPage createFormRegister(WebDriver driver){
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

    public static BackendVerifyBusinessManagement createVerifyBusinessManagement(WebDriver driver) {
        return new BackendVerifyBusinessManagement(driver);
    }

    public static LoginPage createWalletLoginPage(WebDriver driver) {
        return new LoginPage(driver);
    }

    public static WalletOverviewPage createWalletOverviewPage(WebDriver driver) {
        return new WalletOverviewPage(driver);
    }

    public static BusinessPageManagement clickToPageListManagement(WebDriver driver) {
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

    public static TourDetailPage createTourDetailPage(WebDriver driver) {
        return new TourDetailPage(driver);
    }

    public static WalletHomePage createWalletHomepage(WebDriver driver) {
        return new WalletHomePage(driver);
    }

    public static TourInfoTab createTourInfoTab(WebDriver driver) {
        return new TourInfoTab(driver);
    }

    public static BusinessPageManagement openCreatePagePopup(WebDriver driver) {
        return  new BusinessPageManagement(driver);
    }
}
