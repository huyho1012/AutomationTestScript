package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.PerAbout_WorkAndEducation_PageUI;
import Project.Newsfeed.PersonalWall.PersonalCommon;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PerAbout_WorkAndEducation_PageObject extends PersonalCommon {

    WebDriver driver;

    public PerAbout_WorkAndEducation_PageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkWorkAndEducationTabIsDisplay(){
        return true;
    }
    // Hàm mở form thêm mới nơi làm việc
    public void clickToAddNewWorkPlace(){
      waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.ADD_NEW_WORKPLACE);
      clickToElement(driver, PerAbout_WorkAndEducation_PageUI.ADD_NEW_WORKPLACE);
    }

    // Hàm mở form chỉnh sửa thông tin nơi làm việc theo index
    public void clickToEditWorkplaceItembyIndex(int indexWorkplace){
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.OPTION_OF_ITEM_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.OPTION_OF_ITEM_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        setTimeDelay(1);
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.EDIT_ITEM_WORKPLACE_BY_INDEX,String.valueOf(indexWorkplace));
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.EDIT_ITEM_WORKPLACE_BY_INDEX,String.valueOf(indexWorkplace));
    }

    // Hàm mở form chỉnh sửa thông tin nơi làm việc theo tên của công ty
    public void clickToEditWorkplaceItembyName(String companyName){
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.OPTION_OF_ITEM_WORKPLACE_BY_NAME, companyName);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.OPTION_OF_ITEM_WORKPLACE_BY_NAME, companyName);
        setTimeDelay(1);
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.EDIT_ITEM_WORKPLACE_BY_NAME,companyName);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.EDIT_ITEM_WORKPLACE_BY_NAME,companyName);
    }

    // Hàm xoá thông tin nơi làm việc theo vị trí index
    public void clickToRemoveWorkplaceItemByIndex(String indexWorkplace){
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.OPTION_OF_ITEM_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.OPTION_OF_ITEM_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        setTimeDelay(1);
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.REMOVE_ITEM_WORKPLACE_BY_INDEX,String.valueOf(indexWorkplace));
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.REMOVE_ITEM_WORKPLACE_BY_INDEX,String.valueOf(indexWorkplace));
    }

    // Hàm xoá thông tin nơi làm việc lấy theo tên của công ty
    public void clickToRemoveWorkplaceItembyName(String companyName){
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.OPTION_OF_ITEM_WORKPLACE_BY_NAME, companyName);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.OPTION_OF_ITEM_WORKPLACE_BY_NAME, companyName);
        setTimeDelay(1);
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.REMOVE_ITEM_WORKPLACE_BY_NAME,companyName);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.REMOVE_ITEM_WORKPLACE_BY_NAME,companyName);
    }

    // Nhập Tên công ty của nơi làm việc
    public void enterDataToCompanyField(String companyName){
        waitElementToVisible(driver, PerAbout_WorkAndEducation_PageUI.COMPANY_WORKPLACE);
        sendKeyToElement(driver, PerAbout_WorkAndEducation_PageUI.COMPANY_WORKPLACE, companyName);
        sendKeyBoardToElement(driver, PerAbout_WorkAndEducation_PageUI.COMPANY_WORKPLACE, Keys.ENTER);
    }

    // Nhập chức vụ của bạn tại nơi làm việc
    public void enterDataToJobPositionField(String positionJob){
        waitElementToVisible(driver, PerAbout_WorkAndEducation_PageUI.POSITION_WORLPLACE);
        sendKeyToElement(driver, PerAbout_WorkAndEducation_PageUI.POSITION_WORLPLACE, positionJob);
    }

    // Nhập địa chỉ nơi làm việc
    public void enterDataToAddressField(String address){
        waitElementToVisible(driver, PerAbout_WorkAndEducation_PageUI.ADDRESS_WORKPLACE);
        sendKeyToElement(driver, PerAbout_WorkAndEducation_PageUI.ADDRESS_WORKPLACE, address);
    }

    // Nhập mô tả của nghề nghiệp
    public void enterDataToDescription(String description){
        waitElementToVisible(driver, PerAbout_WorkAndEducation_PageUI.DESC_WORLPLACE);
        sendKeyToElement(driver, PerAbout_WorkAndEducation_PageUI.DESC_WORLPLACE, description);
    }

    // Chọn - Bỏ chọn option làm tới hiện nay
    public void checkOptionTimePeriod(){
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.CHECKBOX_TIME_PERIOD);
        clickToElement(driver , PerAbout_WorkAndEducation_PageUI.CHECKBOX_TIME_PERIOD);
    }

    // Nhấn lưu nơi làm việc
    public void clickToSaveWorkplace(){
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.SAVE_WORKPLACE);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.SAVE_WORKPLACE);
    }

    // Bỏ lưu nơi làm việc
    public void cancelSaveWorkPlace(){
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.CANCEL_ADD_WORKPLACE);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.CANCEL_ADD_WORKPLACE);
    }

    // Chức năng chọn ngày bắt đầu case
    public void chooseWorkplaceStartDateCaseNew(String dateItem, String monthItem, String yearItem){
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, yearItem, "workplaceVM.yearFrom");
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, monthItem, "workplaceVM.monthFrom");
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, dateItem, "workplaceVM.dayFrom");
    }

    // Chức năng chọn ngày kết thúc case tạo mới
    public void chooseWorkplaceEndDateCaseNew(String dateItem, String monthItem, String yearItem){
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, yearItem, "workplaceVM.yearTo");
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, monthItem, "workplaceVM.monthTo");
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, dateItem, "workplaceVM.dayTo");
    }

    // Chức năng chọn ngày bắt đầu case chỉnh sửa
    public void chooseWorkplaceStartDateCaseEdit(String dateItem, String monthItem, String yearItem){
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, yearItem, "workplaceVM.yearFrom");
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, monthItem, "workplaceVM.monthFrom");
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, dateItem, "workplaceVM.dayFrom");
    }

    // Chức năng chọn ngày kết thúc case chỉnh sửa
    public void chooseWorkplaceEndDateCaseEdit(String dateItem, String monthItem, String yearItem){
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, yearItem, "workplaceVM.yearTo");
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, monthItem, "workplaceVM.monthTo");
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, dateItem, "workplaceVM.dayTo");
    }


    // Chức năng thêm trường đại học
    public void clickToAddNewUniversity(){
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.ADD_NEW_UNIVERSITY);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.ADD_NEW_UNIVERSITY);
    }

    // Chức năng thêm trường trung học
    public void clickToAddNewHighschool(){
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.ADD_NEW_HIGHSCHOOL);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.ADD_NEW_HIGHSCHOOL);
    }

}

