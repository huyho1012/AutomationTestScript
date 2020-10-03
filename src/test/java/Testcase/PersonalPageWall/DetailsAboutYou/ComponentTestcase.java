package Testcase.PersonalPageWall.DetailsAboutYou;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.About.PerAbout_DetailsAboutYou_PageObject;
import Project.Newsfeed.PersonalWall.About.PerAbout_Overview_PageObject;
import Project.Shared.Login_PageObject;
import Project.Shared.SignUp_PageObject;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ComponentTestcase extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper dataHelper;

    Lorem lorem;

    // Khai báo param
    String languageSystem;
    String quotes;

    // Khai báo Page Object
    Login_PageObject newsfeedLoginPage;
    NewsfeedHomepage newsfeedHomepage;
    PerAbout_Overview_PageObject perOverviewTab;
    PerAbout_DetailsAboutYou_PageObject perDetailAboutTab;
    SignUp_PageObject signUpPageObject;

    @Parameters("browser")
    @BeforeClass
    public void preconditionStep(String browserName){
        dataHelper = DataHelper.getData();
        lorem = LoremIpsum.getInstance();
        log.info("Create browser driver");
        driverManager = BrowserInitialization.getBrowser(browserName);

        log.info("Open browser and go to Newsfeed Login");
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Change language system to VI");
        newsfeedLoginPage.clickToChangeLanguageToVI(driver);
        languageSystem = newsfeedLoginPage.getLanguageOfSystemHahalolo(driver);

        log.info("Login newsfeed");
        newsfeedLoginPage.Login(GlobalVariables.USER_ACCOUNT, "123456");
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);
        verifyTrue(newsfeedHomepage.checkNewsfeedDisplay());

        log.info("Go to Overview tab");
        newsfeedHomepage.clickToEditProfile();
        perOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);
        verifyTrue(perOverviewTab.checkPerAboutOverviewTabIsDisplay());

        log.info("Go to Details about you tab");
        perOverviewTab.clickToTabItemOnAbout(driver,"#about_details");
        perDetailAboutTab = PageGeneration.createPersonalDetailsAboutYouTab(driver);
    }

    @Test
    public void TC01_Update_Favorite_Quote_With_Blank_Data() {
        quotes = "";
        log.info("Click to Add faviore quotes");
        perDetailAboutTab.clickToAddFavoriteQuote();
        log.info("Enter favorite quotes");
        perDetailAboutTab.enterDataToFavoriteQuoteField(quotes);
        log.info("Click save favorite quotes");
        perDetailAboutTab.clickToSaveFavoriteQuote();
    }

    @Test
    public void TC02_Update_Favorite_Quote_With_Data_Contains_All_Whitespace() {
        quotes = "     ";
        log.info("Click to Add faviore");
        perDetailAboutTab.clickToAddFavoriteQuote();
        log.info("Enter favorite quotes");
        perDetailAboutTab.enterDataToFavoriteQuoteField(quotes);
        log.info("Click to save quotes");
        perDetailAboutTab.clickToSaveFavoriteQuote();
        verifyEquals(perDetailAboutTab.getFavoriteQuoteDataDisplay(),quotes);
    }

    @Test
    public void TC03_Update_FavoriteQuote_With_Data_Is_Paragarph(){
        quotes = String.valueOf(dataHelper.getDummyParagarph(2));
        log.info("Click to Edit favorite quotes");
        perDetailAboutTab.clickToButtonEditFavoriteQuote();
        log.info("Enter favorite quotes");
        perDetailAboutTab.enterDataToFavoriteQuoteField(quotes);
        log.info("Click to save quotes");
        perDetailAboutTab.clickToSaveFavoriteQuote();
        log.info("Verify favorite quotes");
        verifyEquals(perDetailAboutTab.getFavoriteQuoteDataDisplay(),quotes);
    }

    @Test
    public void TC03_Update_FavoriteQuote_With_Data_Is_One_Sentence(){
        quotes = lorem.getWords(10);
        log.info("Click to Edit favorite quotes");
        perDetailAboutTab.clickToButtonEditFavoriteQuote();
        log.info("Enter favorite quotes");
        perDetailAboutTab.enterDataToFavoriteQuoteField(quotes);
        log.info("Click to save quotes");
        perDetailAboutTab.clickToSaveFavoriteQuote();
        log.info("Verify favorite quotes");=
        verifyEquals(perDetailAboutTab.getFavoriteQuoteDataDisplay(),quotes);
    }

    @Test
    public void TC04_Update_FavoriteQuote_With_Data_Is_Only_Number(){
        quotes = String.valueOf(randomNumber(3000));
        log.info("Click to Edit favorite quotes");
        perDetailAboutTab.clickToButtonEditFavoriteQuote();
        log.info("Enter favorite quotes");
        perDetailAboutTab.enterDataToFavoriteQuoteField(quotes);
        log.info("Click to save quotes");
        perDetailAboutTab.clickToSaveFavoriteQuote();
        log.info("Verify favorite quotes");
        verifyEquals(perDetailAboutTab.getFavoriteQuoteDataDisplay(),quotes);
    }

    @Test
    public void TC05_Update_FavoriteQuote_With_Data_Is_Contains_Special_Characters(){
        quotes = "@#$%^&* %#@##$$";
        log.info("Click to Edit favorite quotes");
        perDetailAboutTab.clickToButtonEditFavoriteQuote();
        log.info("Enter favorite quotes");
        perDetailAboutTab.enterDataToFavoriteQuoteField(quotes);
        log.info("Click to save quotes");
        perDetailAboutTab.clickToSaveFavoriteQuote();
        log.info("Verify favorite quotes");
        verifyEquals(perDetailAboutTab.getFavoriteQuoteDataDisplay(),quotes);
    }
}
