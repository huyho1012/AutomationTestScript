package Testcase.PersonalPageWall.About.BasicInfoAndContact;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.About.PerAbout_BasicInfoAndContact_PageObject;
import Project.Newsfeed.PersonalWall.About.PerAbout_Overview_PageObject;
import Project.Shared.Login_PageObject;
import Project.Shared.SignUp_PageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Testcase_Component_AddressFunction extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    Login_PageObject newsfeedLoginPage;
    PerAbout_BasicInfoAndContact_PageObject perAboutBasicInfoTab;
    PerAbout_Overview_PageObject perOverviewTab;
    NewsfeedHomepage newsfeedHomepage;
    SignUp_PageObject signupPage;

    DataHelper data;
    String address, city, areaCode;
    @Parameters("browser")
    @BeforeTest
    public void preStepConditionStep(String browserName){
        data = DataHelper.getData();
        driverManager = BrowserInitialization.getBrowser(browserName);
        log.info("Open browser and go to Newsfeed Login page");
        driver = driverManager.getDriver(GlobalVariables.NEWSFEED_URL);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Change language to VI");
        newsfeedLoginPage.clickToChangeLanguageToVI(driver);

        log.info("Login newsfeed");
        newsfeedLoginPage.Login(GlobalVariables.USER_ACCOUNT, "123456");
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Go to Personal about - Overview");
        newsfeedHomepage.clickToEditProfile();
        perOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("Go to Personal About - Basic info and contact");
        perOverviewTab.clickToTabItemOnAbout(driver,"#about_contact");
        perAboutBasicInfoTab = PageGeneration.createperBasicInfoAndContactPage(driver);
    }

    @Test(groups = {"Address"})
    public void TC_01_Update_Address_Information_With_Address_Data_Is_Invalid(){
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();

        log.info("Case blank");
        log.info("Remove address");
        perAboutBasicInfoTab.enterDataToAddressField("");
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify error message of Address field");
        verifyEquals(perAboutBasicInfoTab.getErrorMessageOfAddressField(),"Địa chỉ là bắt buộc.");

        log.info("Case Address contains all whitespace ");
        log.info("Enter address");
        perAboutBasicInfoTab.enterDataToAddressField("        ");
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify error message of Address field");
        verifyEquals(perAboutBasicInfoTab.getErrorMessageOfAddressField(),"Địa chỉ là bắt buộc.");
    }

    @Test(groups = {"Address"})
    public void TC_02_Update_Address_Information_With_Address_Data_Is_Uppercase(){
        address = data.getAddress().toUpperCase();
        log.info("Enter address");
        perAboutBasicInfoTab.enterDataToAddressField(address);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify Address info display correctly");
        verifyEquals(perAboutBasicInfoTab.getAddressDisplay(),address);
    }

    @Test(groups = {"Address"})
    public void TC_03_Update_Address_Information_With_Address_Data_Is_Lowercase(){
        address = data.getAddress().toLowerCase();
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter address");
        perAboutBasicInfoTab.enterDataToAddressField(address);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify Address info display correctly");
        verifyEquals(perAboutBasicInfoTab.getAddressDisplay(),address);
    }

    @Test(groups = {"Address"})
    public void TC_04_Update_Address_Information_With_Address_Data_Is_Only_Number(){
        address = "1234124";
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter address");
        perAboutBasicInfoTab.enterDataToAddressField(address);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify Address info display correctly");
        verifyEquals(perAboutBasicInfoTab.getAddressDisplay(),address);
    }

    @Test(groups = {"Address"})
    public void TC_05_Update_Address_Information_With_Addreess_Data_Combine_Characters_And_Number(){
        address = "400/8A Ung văn khiêm Phường 20 quận Bình thạnh";
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter address");
        perAboutBasicInfoTab.enterDataToAddressField(address);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify Address info display correctly");
        verifyEquals(perAboutBasicInfoTab.getAddressDisplay(),address);
    }

    @Test(groups = {"Address"})
    public void TC_06_Update_Address_Information_With_Address_Data_Contains_Special_Characters(){
        address = "!@#$$&%*@#";
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter address");
        perAboutBasicInfoTab.enterDataToAddressField(address);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify Address info display correctly");
        verifyEquals(perAboutBasicInfoTab.getAddressDisplay(),address);
    }

    @Test(groups = {"Address"})
    public void TC_07_Update_Address_Information_With_Address_Data_Is_HTML_CODE(){
        address = GlobalVariables.HTML_CODE;
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter address");
        perAboutBasicInfoTab.enterDataToAddressField(address);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify Address info display correctly");
        verifyEquals(perAboutBasicInfoTab.getAddressDisplay(),address);
    }

    @Test(groups = {"Address"})
    public void TC_08_Update_Address_Information_With_Address_Data_Is_SCRIPT_CODE(){
        address = GlobalVariables.SCRPIT_CODE;
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter address");
        perAboutBasicInfoTab.enterDataToAddressField(address);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify Address info display correctly");
        verifyEquals(perAboutBasicInfoTab.getAddressDisplay(),address);
    }

    @Test(groups = {"Address"})
    public void TC_09_Update_Address_Information_With_Address_Data_Contains_Whitespace_On_First(){
        address = " " + data.getAddress();
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter address");
        perAboutBasicInfoTab.enterDataToAddressField(address);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify Address info display correctly");
        verifyEquals(perAboutBasicInfoTab.getAddressDisplay(),address.trim());
    }

    @Test(groups = {"Address"})
    public void TC_10_Update_Address_Information_With_Address_Data_Contains_Whitespace_On_Last(){
        address = data.getAddress() + " ";
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter address");
        perAboutBasicInfoTab.enterDataToAddressField(address);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify Address info display correctly");
        verifyEquals(perAboutBasicInfoTab.getAddressDisplay(),address.trim());
    }

    @Test(groups = {"City"})
    public void TC_11_Update_Address_Information_With_City_Data_Is_Invalid() {
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();

        log.info("Case city blank");
        log.info("Remove City");
        perAboutBasicInfoTab.enterDataToCityField("");
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Check error validate message");
        verifyEquals(perAboutBasicInfoTab.getErrorMessageOfCityField(),"Thành phố là bắt buộc.");

        log.info("Case city blank");
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToCityField("        ");
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Check error validate message");
        verifyEquals(perAboutBasicInfoTab.getErrorMessageOfCityField(),"Thành phố là bắt buộc.");
    }

    @Test(groups = {"City"})
    public void TC_12_Update_Address_Information_With_City_Data_Is_Uppercase() {
        city = data.getCity().toUpperCase();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToCityField(city);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfCityIsDisplay(),city);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }
    @Test(groups = {"City"})
    public void TC_13_Update_Address_Information_With_City_Data_Is_Lowercase(){
        city = data.getCity().toLowerCase();
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToCityField(city);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfCityIsDisplay(),city);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"City"})
    public void TC_14_Update_Information_With_City_Data_Is_Only_Number(){
        city ="12343242";
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToCityField(city);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfCityIsDisplay(),city);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"City"})
    public void TC_15_Update_Address_Information_With_City_Data_Combine_Characters_And_Number(){
        city ="Hồ Chí Minh 12";
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToCityField(city);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfCityIsDisplay(),city);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"City"})
    public void TC_16_Update_Address_Information_With_City_Data_Contains_Special_Characters(){
        city ="@#$$%%@!";
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToCityField(city);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfCityIsDisplay(),city);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"City"})
    public void TC_17_Update_Address_Information_With_City_Data_Is_HTML_CODE(){
        city = GlobalVariables.HTML_CODE;
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToCityField(city);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfCityIsDisplay(),city);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"City"})
    public void TC_18_Update_Address_Information_With_City_Data_Is_SCRIPT_CODE(){
        city = GlobalVariables.SCRPIT_CODE;
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToCityField(city);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfCityIsDisplay(),city);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"City"})
    public void TC_19_Update_Address_Information_With_City_Data_Contains_Whitespace_On_First(){
        city = " " + data.getCity();
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToCityField(city);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfCityIsDisplay(),city);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"City"})
    public void TC_20_Update_Address_Information_With_City_Data_Contains_Whitespace_On_Last(){
        city =  data.getCity() + " ";
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToCityField(city);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfCityIsDisplay(),city);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"AreaCode"})
    public void TC_21_Update_Address_Information_With_AreaCode_Data_Is_Blank() {
        areaCode = "";
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Remove Area code");
        perAboutBasicInfoTab.enterDataToAreaCode(areaCode);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfAreaCodeIsDisplay(),areaCode);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"AreaCode"})
    public void TC_22_Update_Address_Information_With_AreaCode_Data_Contains_All_Whitespace(){
        areaCode = "        ";
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter Area code");
        perAboutBasicInfoTab.enterDataToAreaCode(areaCode);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfAreaCodeIsDisplay(),areaCode);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"AreaCode"})
    public void TC_23_Update_Address_Information_With_AreaCode_Data_Is_Uppercase(){
        areaCode = "AAAAAAA";
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToAreaCode(areaCode);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfAreaCodeIsDisplay(),areaCode);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"AreaCode"})
    public void TC_24_Update_Address_Information_With_AreaCode_Data_Is_Lowercase(){
        areaCode = "aaaaaaaaa";
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToAreaCode(areaCode);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfAreaCodeIsDisplay(),areaCode);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"AreaCode"})
    public void TC_25_Update_Information_With_AreaCode_Data_Is_Only_Number(){
        areaCode = "12343242";
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToAreaCode(areaCode);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfAreaCodeIsDisplay(),areaCode);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"AreaCode"})
    public void TC_26_Update_Address_Information_With_AreaCode_Data_Combine_Characters_And_Number(){
        areaCode = "13232AVV";
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToAreaCode(areaCode);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfAreaCodeIsDisplay(),areaCode);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"AreaCode"})
    public void TC_27_Update_Address_Information_With_AreaCode_Data_Contains_Special_Characters(){
        areaCode = "@$%$@#@";
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToAreaCode(areaCode);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfAreaCodeIsDisplay(),areaCode);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"AreaCode"})
    public void TC_28_Update_Address_Information_With_AreaCode_Data_Is_HTML_CODE(){
        areaCode = GlobalVariables.HTML_CODE;
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToAreaCode(areaCode);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfAreaCodeIsDisplay(),areaCode);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"AreaCode"})
    public void TC_29_Update_Address_Information_With_AreaCode_Data_Is_SCRIPT_CODE(){
        areaCode = GlobalVariables.SCRPIT_CODE;
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToAreaCode(GlobalVariables.SCRPIT_CODE);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfAreaCodeIsDisplay(),areaCode);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"AreaCode"})
    public void TC_30_Update_Address_Information_With_AreaCode_Data_Contains_Whitespace_On_First(){
        areaCode = "  " + data.getAreaCode();
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToAreaCode(areaCode);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfAreaCodeIsDisplay(),areaCode);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test(groups = {"AreaCode"})
    public void TC_31_Update_Address_Information_With_AreaCode_Data_Contains_Whitespace_On_Last(){
        areaCode = data.getAreaCode() + "  ";
        log.info("Click to edit Address");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        log.info("Enter City");
        perAboutBasicInfoTab.enterDataToAreaCode(areaCode);
        log.info("Click save button");
        perAboutBasicInfoTab.clickToSaveAddress();
        log.info("Verify data after save");
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfAreaCodeIsDisplay(),areaCode);
        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @Test
    public void TC_32_Check_Address_Function_When_User_Create_New_Account(){
        perAboutBasicInfoTab.clickToItemOnSettingMenu(driver,"ic-logout-c");
        signupPage = PageGeneration.createFormRegister(driver);
        String firstName = data.getFirstName();
        String lastname = data.getLastName();
        String email = randomVirtualEmail();
        signupPage.signUpWithNewAccountByEmail(firstName,lastname,email,"123456" , "123456");
        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);
        newsfeedHomepage.clickCancelUpdateNewInfo();

        newsfeedHomepage.clickToEditProfile();
        perOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);

        perOverviewTab.clickToTabItemOnAbout(driver, "#about_contact");
        perAboutBasicInfoTab = PageGeneration.createperBasicInfoAndContactPage(driver);

        verifyTrue(perAboutBasicInfoTab.checkAddressSectionNotHaveData());

        perAboutBasicInfoTab.clickToButtonAddNewAddress();
        verifyTrue(perAboutBasicInfoTab.checkFormAddOrEditAddressDisplay());

        areaCode = data.getAreaCode();
        city = data.getCity();
        address = data.getAddress();
        perAboutBasicInfoTab.enterDataToAddressField(address);
        perAboutBasicInfoTab.enterDataToCityField(city);
        perAboutBasicInfoTab.enterDataToAreaCode(areaCode);

        perAboutBasicInfoTab.clickToSaveAddress();

        verifyEquals(perAboutBasicInfoTab.getAddressDisplay(),address);
        perAboutBasicInfoTab.clickToButtonEditAddress();
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfAreaCodeIsDisplay(),areaCode);
        verifyEquals(perAboutBasicInfoTab.getAttributeValueOfCityIsDisplay(),city);

        perAboutBasicInfoTab.clickToCancelSaveAddress();
    }

    @AfterClass(alwaysRun = true)
    public void clossBrowser(){
        closeBrowserAndDriver(driver);
    }

}
