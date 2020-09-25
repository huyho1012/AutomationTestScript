package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.WorkEducationUI;
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
      waitForElementClickable(driver, WorkEducationUI.ADD_NEW_WORKPLACE);
      clickToElement(driver, WorkEducationUI.ADD_NEW_WORKPLACE);
    }

    // Hàm mở form chỉnh sửa thông tin nơi làm việc theo index
    public void clickToEditWorkplaceItembyIndex(int indexWorkplace){
        waitForElementClickable(driver, WorkEducationUI.OPTION_OF_ITEM_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        clickToElement(driver, WorkEducationUI.OPTION_OF_ITEM_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        setTimeDelay(1);
        waitForElementClickable(driver, WorkEducationUI.EDIT_ITEM_WORKPLACE_BY_INDEX,String.valueOf(indexWorkplace));
        clickToElement(driver, WorkEducationUI.EDIT_ITEM_WORKPLACE_BY_INDEX,String.valueOf(indexWorkplace));
    }

    // Hàm mở form chỉnh sửa thông tin nơi làm việc theo tên của công ty
    public void clickToEditWorkplaceItembyName(String companyName){
        waitForElementClickable(driver, WorkEducationUI.OPTION_OF_ITEM_WORKPLACE_BY_NAME, companyName);
        clickToElement(driver, WorkEducationUI.OPTION_OF_ITEM_WORKPLACE_BY_NAME, companyName);
        setTimeDelay(1);
        waitForElementClickable(driver, WorkEducationUI.EDIT_ITEM_WORKPLACE_BY_NAME,companyName);
        clickToElement(driver, WorkEducationUI.EDIT_ITEM_WORKPLACE_BY_NAME,companyName);
    }

    // Hàm xoá thông tin nơi làm việc theo vị trí index
    public void clickToRemoveWorkplaceItemByIndex(String indexWorkplace){
        waitForElementClickable(driver, WorkEducationUI.OPTION_OF_ITEM_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        clickToElement(driver, WorkEducationUI.OPTION_OF_ITEM_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        setTimeDelay(1);
        waitForElementClickable(driver, WorkEducationUI.REMOVE_ITEM_WORKPLACE_BY_INDEX,String.valueOf(indexWorkplace));
        clickToElement(driver, WorkEducationUI.REMOVE_ITEM_WORKPLACE_BY_INDEX,String.valueOf(indexWorkplace));
    }

    // Hàm xoá thông tin nơi làm việc lấy theo tên của công ty
    public void clickToRemoveWorkplaceItembyName(String companyName){
        waitForElementClickable(driver, WorkEducationUI.OPTION_OF_ITEM_WORKPLACE_BY_NAME, companyName);
        clickToElement(driver, WorkEducationUI.OPTION_OF_ITEM_WORKPLACE_BY_NAME, companyName);
        setTimeDelay(1);
        waitForElementClickable(driver, WorkEducationUI.REMOVE_ITEM_WORKPLACE_BY_NAME,companyName);
        clickToElement(driver, WorkEducationUI.REMOVE_ITEM_WORKPLACE_BY_NAME,companyName);
    }

    // Nhập Tên công ty của nơi làm việc
    public void enterDataToCompanyField(String companyName){
        waitElementToVisible(driver, WorkEducationUI.COMPANY_WORKPLACE);
        sendKeyToElement(driver, WorkEducationUI.COMPANY_WORKPLACE, companyName);
        sendKeyBoardToElement(driver, WorkEducationUI.COMPANY_WORKPLACE, Keys.ENTER);
    }

    // Nhập chức vụ của bạn tại nơi làm việc
    public void enterDataToJobPositionField(String positionJob){
        waitElementToVisible(driver, WorkEducationUI.POSITION_WORLPLACE);
        sendKeyToElement(driver, WorkEducationUI.POSITION_WORLPLACE, positionJob);
    }

    // Nhập địa chỉ nơi làm việc
    public void enterDataToAddressField(String address){
        waitElementToVisible(driver, WorkEducationUI.ADDRESS_WORKPLACE);
        sendKeyToElement(driver, WorkEducationUI.ADDRESS_WORKPLACE, address);
    }

    // Nhập mô tả của nghề nghiệp
    public void enterDataToDescription(String description){
        waitElementToVisible(driver, WorkEducationUI.DESC_WORLPLACE);
        sendKeyToElement(driver, WorkEducationUI.DESC_WORLPLACE, description);
    }

    // Chọn - Bỏ chọn option làm tới hiện nay
    public void checkOptionTimePeriod(){
        waitForElementClickable(driver, WorkEducationUI.CHECKBOX_TIME_PERIOD);
        clickToElement(driver , WorkEducationUI.CHECKBOX_TIME_PERIOD);
    }

    // Nhấn lưu nơi làm việc
    public void clickToSaveWorkplace(){
        waitForElementClickable(driver, WorkEducationUI.SAVE_WORKPLACE);
        clickToElement(driver, WorkEducationUI.SAVE_WORKPLACE);
    }

    // Bỏ lưu nơi làm việc
    public void cancelSaveWorkPlace(){
        waitForElementClickable(driver, WorkEducationUI.CANCEL_ADD_WORKPLACE);
        clickToElement(driver, WorkEducationUI.CANCEL_ADD_WORKPLACE);
    }

    // Chức năng chọn ngày bắt đầu case
    public void chooseWorkplaceStartDateCaseNew(String dateItem, String monthItem, String yearItem){
        selectItemInCustomDropdown(driver, WorkEducationUI.DATE_DROPDOWN_OF_WORKPLACE, WorkEducationUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, yearItem, "workplaceVM.yearFrom");
        selectItemInCustomDropdown(driver, WorkEducationUI.DATE_DROPDOWN_OF_WORKPLACE, WorkEducationUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, monthItem, "workplaceVM.monthFrom");
        selectItemInCustomDropdown(driver, WorkEducationUI.DATE_DROPDOWN_OF_WORKPLACE, WorkEducationUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, dateItem, "workplaceVM.dayFrom");
    }

    // Chức năng chọn ngày kết thúc case tạo mới
    public void chooseWorkplaceEndDateCaseNew(String dateItem, String monthItem, String yearItem){
        selectItemInCustomDropdown(driver, WorkEducationUI.DATE_DROPDOWN_OF_WORKPLACE, WorkEducationUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, yearItem, "workplaceVM.yearTo");
        selectItemInCustomDropdown(driver, WorkEducationUI.DATE_DROPDOWN_OF_WORKPLACE, WorkEducationUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, monthItem, "workplaceVM.monthTo");
        selectItemInCustomDropdown(driver, WorkEducationUI.DATE_DROPDOWN_OF_WORKPLACE, WorkEducationUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, dateItem, "workplaceVM.dayTo");
    }

    // Chức năng chọn ngày bắt đầu case chỉnh sửa
    public void chooseWorkplaceStartDateCaseEdit(String dateItem, String monthItem, String yearItem){
        selectItemInCustomDropdown(driver, WorkEducationUI.DATE_DROPDOWN_OF_WORKPLACE, WorkEducationUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, yearItem, "workplaceVM.yearFrom");
        selectItemInCustomDropdown(driver, WorkEducationUI.DATE_DROPDOWN_OF_WORKPLACE, WorkEducationUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, monthItem, "workplaceVM.monthFrom");
        selectItemInCustomDropdown(driver, WorkEducationUI.DATE_DROPDOWN_OF_WORKPLACE, WorkEducationUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, dateItem, "workplaceVM.dayFrom");
    }

    // Chức năng chọn ngày kết thúc case chỉnh sửa
    public void chooseWorkplaceEndDateCaseEdit(String dateItem, String monthItem, String yearItem){
        selectItemInCustomDropdown(driver, WorkEducationUI.DATE_DROPDOWN_OF_WORKPLACE, WorkEducationUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, yearItem, "workplaceVM.yearTo");
        selectItemInCustomDropdown(driver, WorkEducationUI.DATE_DROPDOWN_OF_WORKPLACE, WorkEducationUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, monthItem, "workplaceVM.monthTo");
        selectItemInCustomDropdown(driver, WorkEducationUI.DATE_DROPDOWN_OF_WORKPLACE, WorkEducationUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, dateItem, "workplaceVM.dayTo");
    }


    // Chức năng thêm trường đại học
    public void clickToAddNewUniversity(){
        waitForElementClickable(driver, WorkEducationUI.ADD_NEW_UNIVERSITY);
        clickToElement(driver, WorkEducationUI.ADD_NEW_UNIVERSITY);
    }

    // Chức năng thêm trường trung học
    public void clickToAddNewHighschool(){
        waitForElementClickable(driver, WorkEducationUI.ADD_NEW_HIGHSCHOOL);
        clickToElement(driver, WorkEducationUI.ADD_NEW_HIGHSCHOOL);
    }

}

