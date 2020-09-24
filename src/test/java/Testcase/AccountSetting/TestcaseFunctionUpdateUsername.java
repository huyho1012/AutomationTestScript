package Testcase.AccountSetting;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.AccountSetting.GeneralSetting;
import Project.Newsfeed.Newsfeed.NewsfeedHomepage;
import Project.Newsfeed.PersonalWall.About.PersonalAboutPage;
import Project.Shared.Login.LoginPage;
import Project.Shared.SingUp.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestcaseFunctionUpdateUsername extends AbstractTest {
    DriverManager driverManager;
    DataHelper data;
    WebDriver driver;
    LoginPage loginNewsfeedPage;
    NewsfeedHomepage newsFeedHomePage;
    GeneralSetting accountSetting;
    SignUpPage signUpPage;
    PersonalAboutPage personalAboutPage;
    String account = "balo_04@mailinator.com";
    String passWord = "123456";
    String htmlCode ="<p>HelloWord</p>";
    String scriptCode ="<script>destroyWebsite();</script>";
    String userName;

    @Parameters("browser")
    @BeforeTest
    public void Precondition(String browserName){
        data = DataHelper.getData();
        driverManager = BrowserInitialization.getBrowser(browserName);
        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);

        // Mở trang Hahalolo Login
        loginNewsfeedPage = PageGeneration.createNewsfeedLoginPage(driver);

        // Đắng nhập vào Hahalolo - Newsfeed
        loginNewsfeedPage.Login(account,passWord);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);

        // Thay đổi ngôn ngữ hiển thị của newsfeed sang Tiếng việt
        newsFeedHomePage.changeLanguageNewsfeedToVI();

        // Nhán vào chức năng Thiết lập tài khoản
        newsFeedHomePage.clickToItemOnSettingMenu(driver,"ic-cog-c");
        accountSetting = PageGeneration.createGeneralAccountSettingPage(driver);

        // Kiểm tra trang thiết lập tài khoản hiển thị
        verifyTrue(accountSetting.checkAccountGeneralSettingIsDisplay());

        // Nhấn nút chỉnh sửa thông tin định danh người dùng
        accountSetting.clickToButtonEditUsername();
    }

    @Test
    public void Testcase01_Update_Username_With_Invalid_Information(){
        // Nhập định danh người dùng rỗng
        accountSetting.enterDataToUsernameField("");
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());

        // Nhập định danh người dùng chứa toàn ký tự trắng
        accountSetting.enterDataToUsernameField("  ");
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Phải có ít nhất 5 kí tự");

        // Nhập định danh người dùng có khoảng trắng ở giữa dữ liệu
        accountSetting.enterDataToUsernameField("huy hodoan");
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Có chứa ký tự không hợp lệ.");

        // Nhập định danh người dùng chứa dấu chấm ở cuối dữ liệu
        accountSetting.enterDataToUsernameField("huyhodoan.");
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Có chứa ký tự đặc biệt không đúng chỗ");

        // Nhập tên người dùng chứa ký tự đặc biệt
        accountSetting.enterDataToUsernameField("huyhodo@an");
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Có chứa ký tự không hợp lệ.");

        // Nhập định danh người dùng có số lượng ký tự ít hơn 5
        accountSetting.enterDataToUsernameField("huya");
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Phải có ít nhất 5 kí tự");

        // Nhập định danh người dùng có số lượng ký tự nhiều hơn 50
        accountSetting.enterDataToUsernameField(randomName(51));
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Tên người dùng vượt số ký tự tối đa cho phép");

        // Nhập định danh người dùng là 1 đoạn script
        accountSetting.enterDataToUsernameField(scriptCode);
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Có chứa ký tự không hợp lệ.");

        // Nhập định danh người dùng là 1 đoạn html
        accountSetting.enterDataToUsernameField(htmlCode);
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Có chứa ký tự không hợp lệ.");

        // Nhập định danh người dùng có dấu
        accountSetting.enterDataToUsernameField("huayhô");
        verifyFalse(accountSetting.checkButtonSaveChangeOfUsername());
        verifyEquals(accountSetting.getErrMessOnUsername() ,"Có chứa ký tự không hợp lệ.");

        accountSetting.cancelSaveChangeUsername();
    }

    @Test
    public void Testcase02_Update_Username_With_Valid_Username() {
        userName = removeAllWhitespace(data.getFirstName()).toLowerCase();
        System.out.println(userName);
        // Step 1 - Nhấn vào nút cập nhật định danh người dùng
        accountSetting.clickToButtonEditUsername();

        // Step 2 - Nhập vào đinh danh người dùng hợp lệ
        accountSetting.enterDataToUsernameField(userName);

        // Step 3 - Kiểm tra hiển thị thông báo định danh người dùng hợp lệ
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");

        // Step 4 - Kiểm tra nút lưu thay đổi cho phép nhấn hay chưa
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername());

        // Step 5 - Nhấn nút lưu thay đổi thông tin định danh người dùng
        accountSetting.clickToButtonSaveChangeUserName();

        // Step 6 - Kiểm tra định danh người dùng thay đổi thành công
        verifyTrue(accountSetting.getUserIdentityNameDisplay().endsWith(userName));
    }

    @Test
    public void Testcase03_Update_Username_With_Username_Has_Capital_Letters() {
        userName = "HuyHoDoan" + randomNumber(22000);
        System.out.println(userName);
        // Step 1 - Nhấn vào nút cập nhật định danh người dùng
        accountSetting.clickToButtonEditUsername();

        // Step 2 - Nhập vào đinh danh người dùng hợp lệ có chứa ký tự viết hoa
        accountSetting.enterDataToUsernameField(userName);

        // Step 3 - Kiểm tra hiển thị thông báo định danh người dùng hợp lệ
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");

        // Step 4 - Kiểm tra nút lưu thay đổi cho phép nhấn hay chưa
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername());

        // Step 5 - Nhấn nút lưu thay đổi thông tin định danh người dùng
        accountSetting.clickToButtonSaveChangeUserName();

        // Step 6 - Kiểm tra định danh người dùng thay đổi thành công
        verifyTrue(accountSetting.getUserIdentityNameDisplay().endsWith(userName));
    }

    @Test
    public void Testcase04_Update_Username_With_Username_Is_Number() {
        userName = String.valueOf(randomNumber(1000000000));
        System.out.println(userName);
        // Step 1 - Nhấn vào nút cập nhật định danh người dùng
        accountSetting.clickToButtonEditUsername();

        // Step 2 - Nhập vào đinh danh người dùng là một chuỗi số
        accountSetting.enterDataToUsernameField(userName);

        // Step 3 - Kiểm tra hiển thị thông báo định danh người dùng hợp lệ
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");

        // Step 4 - Kiểm tra nút lưu thay đổi cho phép nhấn hay chưa
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername());

        // Step 5 - Nhấn nút lưu thay đổi thông tin định danh người dùng
        accountSetting.clickToButtonSaveChangeUserName();

        // Step 6 - Kiểm tra định danh người dùng thay đổi thành công
        verifyTrue(accountSetting.getUserIdentityNameDisplay().endsWith(userName));
    }
    @Test
    public void Testcase05_Update_Username_With_Username_Is_AlphaNumber(){
        userName = removeAllWhitespace(data.getFirstName()) + randomNumber(20000);
        System.out.println(userName);
        // Step 1 - Nhấn vào nút cập nhật định danh người đùng
        accountSetting.clickToButtonEditUsername();

        // Step 2 - Nhập vào đinh danh người dùng là một chuỗi ký tự số
        accountSetting.enterDataToUsernameField(userName);

        // Step 3 - Kiểm tra hiển thị thông báo định danh người dùng hợp lệ
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");

        // Step 4 - Kiểm tra nút lưu thay đổi cho phép nhấn hay chưa
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername());

        // Step 5 - Nhấn nút lưu thay đổi thông tin định danh người dùng
        accountSetting.clickToButtonSaveChangeUserName();

        // Step 6 - Kiểm tra định danh người dùng thay đổi thành công
        verifyTrue(accountSetting.getUserIdentityNameDisplay().endsWith(userName));
    }

    @Test
    public void Testcase06_Update_Username_With_Username_is_All_Uppercase(){
        userName = removeAllWhitespace(data.getFirstName()).toUpperCase();
        System.out.println(userName);
        // Step 1 - Nhấn vào nút cập nhật định danh người đùng
        accountSetting.clickToButtonEditUsername();

        // Step 2 - Nhập vào đinh danh người dùng là một chuỗi ký tự số
        accountSetting.enterDataToUsernameField(userName);

        // Step 3 - Kiểm tra hiển thị thông báo định danh người dùng hợp lệ
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");

        // Step 4 - Kiểm tra nút lưu thay đổi cho phép nhấn hay chưa
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername());

        // Step 5 - Nhấn nút lưu thay đổi thông tin định danh người dùng
        accountSetting.clickToButtonSaveChangeUserName();

        // Step 6 - Kiểm tra định danh người dùng thay đổi thành công
        verifyTrue(accountSetting.getUserIdentityNameDisplay().endsWith(userName));
        setTimeDelay(1);
        accountSetting.clickToItemOnSettingMenu(driver,"ic-logout-c");
        signUpPage = PageGeneration.createFormRegister(driver);
    }

    @Test(enabled = false)
    public void TC_05_Update_UserName_With_Data_Has_More_Diot_Not_End_Position(){
        userName = "huy.hodoan."+randomNumber(300000);
        System.out.println(userName);
        // Step 1 - Nhấn vào nút cập nhật định danh người đùng
        accountSetting.clickToButtonEditUsername();

        // Step 2 - Nhập vào đinh danh người dùng chứa nhiều dấu châm và vị trị dấu chám không nằm cuối
        accountSetting.enterDataToUsernameField(userName);

        // Step 3 - Kiểm tra hiển thị thông báo định danh người dùng hợp lệ
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");

        // Step 4 - Kiểm tra nút lưu thay đổi cho phép nhấn hay chưa
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername());

        // Step 5 - Nhấn nút lưu thay đổi thông tin định danh người dùng
        accountSetting.clickToButtonSaveChangeUserName();

        // Step 6 - Kiểm tra định danh người dùng thay đổi thành công
        verifyTrue(accountSetting.getUserIdentityNameDisplay().endsWith(userName));

        // End step - Logout
        setTimeDelay(1);
        accountSetting.clickToItemOnSettingMenu(driver,"ic-logout-c");
        signUpPage = PageGeneration.createFormRegister(driver);
    }

    @Test
    public void Testcase07_CheckDefaultUsernameAndUpdateValidUsernameCaseNewAccount(){
        // Prepare data
        String firstName  = "Huy";
        String lastName = "Hô";
        String email = randomVirtualEmail();
        String password = "123456";
        String confirmPass = "123456";

        // Step 1 - Đăng ký tài khoản mới với thông tin như sau
        signUpPage.signUpWithNewAccountByEmail(firstName, lastName, email, password, confirmPass);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);

        // Step 2 - Kiểm trả người dùng đăng ký thành công
        verifyTrue(newsFeedHomePage.checkNewsfeedDisplayOnFirstTime(driver));

        // Step 3 - Nhấn nút Huỷ cập nhật thông tin người dùng
        newsFeedHomePage.clickCancelUpdateNewInfo();

        // Step 4 - Nhán vào chức năng Thiết lập tài khoản
        newsFeedHomePage.clickToItemOnSettingMenu(driver,"ic-cog-c");
        accountSetting = PageGeneration.createGeneralAccountSettingPage(driver);

        // Step 5 - Kiểm tra trang thiết lập chung tài khoản hiển thị hay không
        verifyTrue(accountSetting.checkAccountGeneralSettingIsDisplay());

        // Step 6 - Kiểm tra định danh người dùng hiển thị mặc định lúc mới dc tài khoản
        verifyEquals(accountSetting.getMessageNoUsername(),"Bạn chưa thiết lập tên người dùng");

        // Step 7 - Nhấn nút chihnr sửa định danh người dùng
        accountSetting.clickToButtonEditUsername();

        userName = "huy.hodoan."+randomNumber(300000);
        System.out.println(userName);
        // Step 8 - Nhập tên định danh người dùng hợp lệ
        accountSetting.enterDataToUsernameField(userName);

        // Step 9 - Kiểm tra hiển thị thông báo định danh người dùng hợp lệ
        verifyEquals(accountSetting.getErrMessOnUsername(), "Tên người dùng khả dụng");

        // Step 10 - Kiểm tra nút lưu thay đổi cho phép nhấn hay chưa
        verifyTrue(accountSetting.checkButtonSaveChangeOfUsername());

        // Step 11 - Nhấn nút lưu thay đổi thông tin định danh người dùng
        accountSetting.clickToButtonSaveChangeUserName();

        // Step 12 - Kiểm tra định danh người dùng thay đổi thành công
        verifyTrue(accountSetting.getUserIdentityNameDisplay().endsWith(userName));

        // Step 13 - Lưu link đường dẫn tên định danh người dùng
        String urlUserName = accountSetting.getUserIdentityNameDisplay();

        // Step 14 - Nhấn vào trang cá nhân của người dùng
        accountSetting.clickToAvatarOnHeader(driver);
        personalAboutPage = PageGeneration.createPerTAboutPage(driver);

        // Step 15 - Kiểm tra link đinh danh người dùng tại màn hình thay đổi dịnh danh người dung với link của người dùng tại trang cá nhân
        verifyEquals(personalAboutPage.getCurrentURL(driver),urlUserName);

    }

}
