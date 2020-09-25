package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.ContactAndBasicInfo_PageUI;
import Project.Newsfeed.PersonalWall.PersonalCommon;
import org.openqa.selenium.WebDriver;

public class PerAbout_BasicInfoAndContact_PageObject extends PersonalCommon {
    WebDriver driver;
    public PerAbout_BasicInfoAndContact_PageObject(WebDriver webDriver){
        driver = webDriver;
    }

    // Kiểm tra tab được điều hướng hiển thị
    public boolean checkContactAndBasicInfoTabIsDisplay(){
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.CONTACT_AND_BASIC_INFO_TAB);
        return checkElementDisplay(driver,ContactAndBasicInfo_PageUI.TITLE_PAGE);
    }

    public boolean checkContactAndBasicInfoCaseCreateAccountByEmail(){
        return true;
    }

    public boolean checkContactAndBasicInfoCaseCreateAccountByPhone(){
        return true;
    }



    // Phone section

    // Hàm lấy thông tin số điện thoại chính đang hiển thị
    public String getMainPhoneDisplay(){
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.CONTACT_AND_BASIC_INFO_TAB);
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.MAIN_PHONE_DATA);
        return getTextElement(driver, ContactAndBasicInfo_PageUI.MAIN_PHONE_DATA);
    }

    // Hàm thêm main phone
    public void clickToButtonAddNewMainPhone(){
        waitForElementClickable(driver, ContactAndBasicInfo_PageUI.BUTTON_ADD_NEW_MAIN_PHONE);
        clickToElement(driver, ContactAndBasicInfo_PageUI.BUTTON_ADD_NEW_MAIN_PHONE);
    }

    // Hàm Nhập thông tin main phone
    public void enterDataOfMobilePhoneAddress(String mainPhone){
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.MAIN_PHONE_FIELD);
        sendKeyToElement(driver, ContactAndBasicInfo_PageUI.MAIN_PHONE_FIELD, mainPhone);
    }

    // Hàm lấy thông báo lỗi ô main phone
    public String getErrorValidateOfMainPhoneField(){
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.MAIN_PHONE_ERROR_MESSAGE);
        return getTextElement(driver, ContactAndBasicInfo_PageUI.MAIN_PHONE_ERROR_MESSAGE);
    }

    // Hàm chỉnh sửa main phone
    public void clickToEditMainPhone(){
        waitForElementClickable(driver, ContactAndBasicInfo_PageUI.ICON_EDIT_MAIN_PHONE);
        clickToElement(driver, ContactAndBasicInfo_PageUI.ICON_EDIT_MAIN_PHONE);
    }

    // Hàm nhấn thêm số điện thoại khác vào danh sách
    public void clickToAddnewOtherPhone(){
        waitForElementClickable(driver,ContactAndBasicInfo_PageUI.BUTTON_ADD_OTHER_PHONE);
        clickToElement(driver, ContactAndBasicInfo_PageUI.BUTTON_ADD_OTHER_PHONE);
    }

    // Hàm xoá bất kỳ số điện thoại khác trong danh sách
    public void clickToRemoveRedirectOtherPhone(){
        waitForElementClickable(driver,ContactAndBasicInfo_PageUI.BUTTON_REMOVE_OTHER_PHONE);
        clickToElement(driver, ContactAndBasicInfo_PageUI.BUTTON_REMOVE_OTHER_PHONE);
    }

    // Hàm lưu thay đổi tất cả thay đổi của mục số điện thoại
    public void clickToSavePhoneInfo(){
        waitForElementClickable(driver, ContactAndBasicInfo_PageUI.BUTTON_SAVE_PHONE);
        clickToElement(driver, ContactAndBasicInfo_PageUI.BUTTON_SAVE_PHONE);
    }

    // Hàm huỷ lưu tất cả thay đổi của mục số điện thoại
    public void clickToCancelSavePhoneInfo(){
        waitForElementClickable(driver, ContactAndBasicInfo_PageUI.BUTTON_CANCEL_SAVE_CHANGE_PHONE);
        clickToElement(driver, ContactAndBasicInfo_PageUI.BUTTON_CANCEL_SAVE_CHANGE_PHONE);
    }

    // Mục Email

    // Kiểm tra Thông tin email hiển thị
    public String getEmailAddressDisplay(){
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.CONTACT_AND_BASIC_INFO_TAB);
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.EMAIL_DATA);
        return getTextElement(driver, ContactAndBasicInfo_PageUI.EMAIL_DATA);
    }

    // Hàm thêm Email
    public void clickToButtonAddNewEmail(){
        waitForElementClickable(driver, ContactAndBasicInfo_PageUI.BUTTON_ADD_EMAIL);
        clickToElement(driver, ContactAndBasicInfo_PageUI.BUTTON_ADD_EMAIL);
    }

    // Hàm nhập dữ liệu Email
    public void enterDataToEmailField(String email){
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.EMAIL_FIELD);
        sendKeyToElement(driver,ContactAndBasicInfo_PageUI.EMAIL_FIELD, email);
    }

    // Hàm lấy thông báo lỗi của ô Email
    public String getErrorMessageOfEmailField(){
        waitElementToVisible(driver,ContactAndBasicInfo_PageUI.EMAIL_ERROR_MESSAGE);
        return getTextElement(driver, ContactAndBasicInfo_PageUI.EMAIL_ERROR_MESSAGE);
    }

    // Hàm đồng ý cập nhật / Thêm mới email
    public void clickToUpdateEmail(){
        waitForElementClickable(driver, ContactAndBasicInfo_PageUI.BUTTON_SAVE_EMAIL);
        clickToElement(driver, ContactAndBasicInfo_PageUI.BUTTON_SAVE_EMAIL);
    }

    // Hàm huỷ cập nhật/ Thêm mới email
    public void clickToCancelUpdateEmail(){
        waitForElementClickable(driver, ContactAndBasicInfo_PageUI.BUTTON_CANCEL_SAVE_EMAIL);
        clickToElement(driver, ContactAndBasicInfo_PageUI.BUTTON_CANCEL_SAVE_EMAIL);
    }

    // Birthday
    // Hàm lấy thông tin ngày sinh đang hiển thị
    public String getBirthdayDisplay(){
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.CONTACT_AND_BASIC_INFO_TAB);
        return getTextElement(driver, ContactAndBasicInfo_PageUI.BIRTHDAY_DATA);
    }

    // Hàm nhấn vào để chỉnh sửa ngày sinh
    public void clickToEditBirthday(){
        waitForElementClickable(driver, ContactAndBasicInfo_PageUI.ICON_EDIT_BIRTHDAY);
        clickToElement(driver, ContactAndBasicInfo_PageUI.ICON_EDIT_BIRTHDAY);
    }

    // Hàm nhập thông tin ngày sinh của tài khoản
    public void enterDataTOBirhdayField(String birthday){
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.BIRTHDAY_FIELD);
        sendKeyToElement(driver, ContactAndBasicInfo_PageUI.BIRTHDAY_FIELD, birthday);
    }

    // Hàm lấy thông báo lỗi của field Ngày sinh
    public String getErrorMessageOfBirthday(){
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.BIRTHDAY_ERROR_MESSAGE);
        return getTextElement(driver, ContactAndBasicInfo_PageUI.BIRTHDAY_ERROR_MESSAGE);
    }


    // Hàm nhấn nút lưu thông tin ngày sinh
    public void clickToButtonUpdateBirthday(){
        waitForElementClickable(driver, ContactAndBasicInfo_PageUI.BUTTON_SAVE_BIRTHDAY);
        clickToElement(driver, ContactAndBasicInfo_PageUI.BUTTON_SAVE_BIRTHDAY);
    }

    // Hàm huỷ lưu thông tin ngày sinh
    public void clickToCancelUpadteBirthday(){
        waitForElementClickable(driver, ContactAndBasicInfo_PageUI.BUTTON_CANCEL_SAVE_BIRTHDAY);
        clickToElement(driver, ContactAndBasicInfo_PageUI.BUTTON_CANCEL_SAVE_BIRTHDAY);
    }

    // Giới tính - Contact and Basic info
    // Hàm lấy thông tin giới tính của tài khoản đang hiển thị
    public String getGender(){
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.CONTACT_AND_BASIC_INFO_TAB);
        return getTextElement(driver, ContactAndBasicInfo_PageUI.GENDER_DATA);
    }

    // Hàm nhấn vào chức năng chỉnh sửa giới tính
    public void clickToEditGenderOfUser(){
        waitForElementClickable(driver, ContactAndBasicInfo_PageUI.ICON_EDIT_GENDER);
        clickToElement(driver, ContactAndBasicInfo_PageUI.ICON_EDIT_GENDER);
    }

    // Hàm chọn giới tính
    public void selectGenderOption(String genderOption){
        selectItemInDropdownByText(driver, ContactAndBasicInfo_PageUI.GENDER_DROPDOWN, genderOption);
    }

    // Hàm lưu thông tin cập nhật giới tính
    public void clickToCancelSaveGenderInfo(){
        waitForElementClickable(driver, ContactAndBasicInfo_PageUI.BUTTON_SAVE_GENDER );
        clickToElement(driver, ContactAndBasicInfo_PageUI.BUTTON_SAVE_GENDER);
    }

    // Hàm huỷ thao tác cập nhật giới tính
    public void clickToSaveGenderInfo() {
        waitForElementClickable(driver, ContactAndBasicInfo_PageUI.BUTTON_CANCEL_SAVE_GENDER);
        clickToElement(driver, ContactAndBasicInfo_PageUI.BUTTON_CANCEL_SAVE_GENDER);

    }

    // Address - Contact and Basic info
    // Lấy thông tin địa chỉ hiển thị
    public String getAddressDisplay(){
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.CONTACT_AND_BASIC_INFO_TAB);
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.ADDRESS_DATA);
        return getTextElement(driver, ContactAndBasicInfo_PageUI.EMAIL_DATA);
    }

    // Hàm nhấn vào để mở Thêm / Chỉnh sửa địa chỉ
    public void clickToButtonAddNewAddress(){
        waitForElementClickable(driver, ContactAndBasicInfo_PageUI.BUTTON_ADD_ADDRESSS);
        clickToElement(driver, ContactAndBasicInfo_PageUI.BUTTON_ADD_ADDRESSS);
    }

    public void clickToButtonEditAddress(){
        waitForElementClickable(driver, ContactAndBasicInfo_PageUI.ICON_EDIT_ADDRESS);
        clickToElement(driver, ContactAndBasicInfo_PageUI.ICON_EDIT_ADDRESS);
    }

    // Hàm nhập giá trị ô Địa chỉ
    public void enterDataToAddressField(String address){
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.ADDRESS_FIELD);
        sendKeyToElement(driver,ContactAndBasicInfo_PageUI.ADDRESS_FIELD, address);
    }

    // Hàm nhập giá trị ô thành phố
    public void enterDataToCityField(String city){
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.CITY_FIELD);
        sendKeyToElement(driver, ContactAndBasicInfo_PageUI.CITY_FIELD, city);
    }

    //  Hàm nhập giá trị ô mã vùng
    public void enterDataToAreaCode(String areaCode){
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.AREA_CODE_FIELD);
        sendKeyToElement(driver, ContactAndBasicInfo_PageUI.AREA_CODE_FIELD, areaCode);
    }

    // Hàm lấy thông báo lỗi tại ô địa chỉ
    public String getErrorMessageOfAddressField(){
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.ADDRESS_ERROR_MESSAGE);
        return getTextElement(driver, ContactAndBasicInfo_PageUI.ADDRESS_ERROR_MESSAGE);
    }

    // Hàm lấy thông báo lỗi tại ô thành phố
    public String getErrorMessageOfCityField(){
        waitElementToVisible(driver, ContactAndBasicInfo_PageUI.CITY_ERROR_MESSAGE);
        return getTextElement(driver, ContactAndBasicInfo_PageUI.CITY_ERROR_MESSAGE);
    }

    // Hàm lưu thông tin giá trị của địa chỉ
    public void clickToSaveAddress(){
        waitForElementClickable(driver, ContactAndBasicInfo_PageUI.BUTTON_SAVE_ADDRESS);
        clickToElement(driver, ContactAndBasicInfo_PageUI.BUTTON_SAVE_ADDRESS);
    }

    // Hàm huỷ lưu thông tin giá trị của địa chỉ
    public void clickToCancelSaveAddress(){
        waitForElementClickable(driver, ContactAndBasicInfo_PageUI.BUTTON_CANCEL_SAVE_ADDRESS);
        clickToElement(driver, ContactAndBasicInfo_PageUI.BUTTON_CANCEL_SAVE_ADDRESS);
    }

}
