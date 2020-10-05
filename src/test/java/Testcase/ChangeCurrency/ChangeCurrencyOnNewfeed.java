package Testcase.ChangeCurrency;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;

import Project.Newsfeed.Boooking.BoookingTour;
import Project.Newsfeed.Newsfeed.Header.ChangeCurrency_PageObject;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PageWall.TourDetail;
import Project.Shared.Login_PageObject;
import org.openqa.selenium.WebDriver;

public class ChangeCurrencyOnNewfeed extends AbstractTest {

    WebDriver driver;
    DriverManager driverManager;
    Login_PageObject newsfeedLoginPage;
    NewsfeedHomepage newsfeedHomepage;
    ChangeCurrency_PageObject currencyModel;

    TourDetail tourDetailBooking;
    BoookingTour tourBooking;

    public void precondition(String browserName) {

        log.info("Create browser driver");
        driverManager = BrowserInitialization.getBrowser(browserName);

        log.info("Open Hahalolo newsfeed login");
        driver = driverManager.getDriver(GlobalVariables.NEWSFEED_URL);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Change language system to Vietnamese");
        newsfeedLoginPage.clickToChangeLanguageToVI(driver);

        log.info("Login Hahalolo");
        newsfeedLoginPage.Login(GlobalVariables.USER_ACCOUNT, "123456");
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Login Newsfeed Hahalolo successfullyu");
        verifyTrue(newsfeedHomepage.checkNewsfeedDisplay());
    }

    public void TC_01_Check_Action_Close_Model_Change_Currency_By_Clicking_Icon_Close(){

        log.info("Step 1 - Open currency popup");
        newsfeedHomepage.clickToCurrencyIcon();
        currencyModel = PageGeneration.openModelChangeCurrency(driver);

        log.info("Step 2. Check Model Change currency is display successfully");
        verifyTrue(currencyModel.checkModelChangeCurrencyIsDisplay());

        log.info("Step 3. Click icon close on Model Change currency");
        currencyModel.clickCloseModelChangeCurrency();
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 4. Verify model change currency close successfully");
        verifyTrue(newsfeedHomepage.checkModelCurrencyCloseSuccess());
    }

    public void TC_02_Check_Action_Close_Model_Change_Currency_By_Click_Over_Model(){

        log.info("Step 1 - Open currency popup");
        newsfeedHomepage.clickToCurrencyIcon();
        currencyModel = PageGeneration.openModelChangeCurrency(driver);

        log.info("Step 2. Check Model Change currency is display successfully");
        verifyTrue(currencyModel.checkModelChangeCurrencyIsDisplay());

        log.info("Step 3. Click icon close on Model Change currency");
        currencyModel.clickOverChangeCurrencyModel();
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 4. Verify model change currency close successfully");
        verifyTrue(newsfeedHomepage.checkModelCurrencyCloseSuccess());
    }

    public void TC_03_Check_Action_Close_Model_Change_Currency_By_Clickinng_Close_Button(){
        log.info("Step 1 - Open currency popup");
        newsfeedHomepage.clickToCurrencyIcon();
        currencyModel = PageGeneration.openModelChangeCurrency(driver);

        log.info("Step 2. Check Model Change currency is display successfully");
        verifyTrue(currencyModel.checkModelChangeCurrencyIsDisplay());

        log.info("Step 3. Click icon close on Model Change currency");
        currencyModel.clickToButtonCloseOnModel();
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 4. Verify model change currency close successfully");
        verifyTrue(newsfeedHomepage.checkModelCurrencyCloseSuccess());
    }

    public void TC_04_ChangeCurrencyOfHahalolOSystem(){
        log.info("Step 1 - Open currency popup");
        newsfeedHomepage.clickToCurrencyIcon();
        currencyModel = PageGeneration.openModelChangeCurrency(driver);

        log.info("Step 2. Check Model Change currency is display successfully");
        verifyTrue(currencyModel.checkModelChangeCurrencyIsDisplay());


        log.info("Step 3. Click to choose curency");
        String currencyCode = "";
        currencyModel.clickToChangeCurrencyOnModelChange(currencyCode);
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 4. Verify Change curency successfully");
        verifyTrue(newsfeedHomepage.checkModelCurrencyCloseSuccess());
        verifyEquals(newsfeedHomepage.getCurrencyCodeDisplayOnHeader(),currencyCode);

        String currencySymbol = getCurrencySymbol(currencyCode);

        log.info("Step 5. Go to Newsfeed Tab Tour");
        newsfeedHomepage.clickToTabItemOnNewsfeedNavigationMenu("");

        log.info("Step 6. Verify currency symbol");
        verifyEquals(newsfeedHomepage.getCurrencySymbolOnTourProduct(), currencySymbol);

        log.info("Step 5. Go to Newsfeed Tab Hotel");
        newsfeedHomepage.clickToTabItemOnNewsfeedNavigationMenu("");

        log.info("Step 6. Verify currency symbol");
        verifyEquals(newsfeedHomepage.getCurrencySymbolOnHotelProduct(), currencySymbol);

        log.info("Step 5. Go to Newsfeed Tab Shopping");
        newsfeedHomepage.clickToTabItemOnNewsfeedNavigationMenu("");

        log.info("Step 6. Verify currency symbol");
        verifyEquals(newsfeedHomepage.getCurrencySymbolOnShoppingProductPost(), currencySymbol);

        log.info("Step. Go to Tour Detail");
        newsfeedHomepage.openURL(driver,"");
        tourDetailBooking = PageGeneration.createTourDetailBookingPage(driver);

        verifyEquals(tourDetailBooking.getCurrencyOnPriceFromSection(), currencySymbol);

        log.info("Step - Go to Tour scheduler");
        tourDetailBooking.clickToSchedulerTab();

        verifyTrue(tourDetailBooking.checkTourSchedulerTabIsDisplay());

        verifyEquals(tourDetailBooking.getCurrencySymbolOfTourItemOnScheduler(), currencyCode);

        log.info("Step - Go to booking Tour");
        tourDetailBooking.chooseDepatureDateWantBooking();
        tourBooking = PageGeneration.createTourBookingPage(driver);

        verifyEquals(tourBooking.getCurrencySymbolPriceDisplayOnSidebar(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolServicePriceDisplayOnSidebar(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolVATDisplayOnSidebar(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolTotalPriceDisplayOnSidebar(),currencyCode);

        verifyEquals(tourBooking.getCurrencySymbolTourPriceDisplayOnDetailStep1(),currencyCode);

        verifyEquals(tourBooking.getCurrencySymbolAdultPriceDisplayOnPriceTable(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolChildPriceDisplayOnPriceTable(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolYoungChildPriceDisplayOnPriceTable(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolBabyPriceDisplayOnPriceTable(),currencyCode);

        tourBooking.clickToNextStep(driver);

        verifyTrue(tourBooking.checkTourBookingStep2IsDisplay(driver));
        verifyEquals(tourBooking.getCurrencySymbolAdultPriceDisplayOnSidebar(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolChildPriceDisplayOnSidebar(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolYoungChildPriceDisplayOnSidebar(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolBabyPriceDisplayOnSidebar(), currencyCode);

        verifyEquals(tourBooking.getCurSymbolTotalPriceOfAdultItemOnTravellerInfo(),currencyCode);
        verifyEquals(tourBooking.getCurSymbolTotalPriceOfChildItemOnTravellerInfo(),currencyCode);
        verifyEquals(tourBooking.getCurSymbolTotalPriceOfYoungChildItemOnTravellerInfo(),currencyCode);
        verifyEquals(tourBooking.getCurSymbolTotalPriceOfBabyItemOnTravellerInfo(), currencyCode);

    }
}
