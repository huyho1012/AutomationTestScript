package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.PerAbout_WorkAndEducation_PageUI;
import org.openqa.selenium.*;

public class PerAbout_WorkAndEducation_PageObject extends PerAbout_Common_PageObject {

    WebDriver driver;

    public PerAbout_WorkAndEducation_PageObject(WebDriver webDriver) {
        driver = webDriver;
    }

    public void clickButtonToAddNewWorkplace() {
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.ADD_NEW_WORKPLACE);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.ADD_NEW_WORKPLACE);
    }

    public void clickToEditWorkplaceItembyIndex(int indexWorkplace) {
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.OPTION_OF_ITEM_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.OPTION_OF_ITEM_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        setTimeDelay(1);
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.EDIT_ITEM_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.EDIT_ITEM_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
    }

    public void clickToEditWorkplaceItembyName(String companyName) {
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.OPTION_OF_ITEM_WORKPLACE_BY_NAME, companyName);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.OPTION_OF_ITEM_WORKPLACE_BY_NAME, companyName);
        setTimeDelay(1);
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.EDIT_ITEM_WORKPLACE_BY_NAME, companyName);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.EDIT_ITEM_WORKPLACE_BY_NAME, companyName);
    }

    public void clickToRemoveWorkplaceItemByIndex(String indexWorkplace) {
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.OPTION_OF_ITEM_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.OPTION_OF_ITEM_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        setTimeDelay(1);
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.REMOVE_ITEM_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.REMOVE_ITEM_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
    }

    // Hàm xoá thông tin nơi làm việc lấy theo tên của công ty
    public void clickToRemoveWorkplaceItembyName(String companyName) {
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.OPTION_OF_ITEM_WORKPLACE_BY_NAME, companyName);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.OPTION_OF_ITEM_WORKPLACE_BY_NAME, companyName);
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.REMOVE_ITEM_WORKPLACE_BY_NAME, companyName);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.REMOVE_ITEM_WORKPLACE_BY_NAME, companyName);
    }

    // Form Add new Workplace
    public void enterDataToCompanyNameOfWorkspace(String companyName) {
        waitElementToVisible(driver, PerAbout_WorkAndEducation_PageUI.COMPANY_WORKPLACE);
        sendKeyToElement(driver, PerAbout_WorkAndEducation_PageUI.COMPANY_WORKPLACE, companyName);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.COMPANY_WORKPLACE_DROPDOWWN_ITEM);
        setTimeDelay(1);

    }

    public void enterDataToPositionOfWorkspace(String positionJob) {
        waitElementToVisible(driver, PerAbout_WorkAndEducation_PageUI.POSITION_WORLPLACE);
        sendKeyToElement(driver, PerAbout_WorkAndEducation_PageUI.POSITION_WORLPLACE, positionJob);
        setTimeDelay(1);

    }

    public void enterDataToAddressOfWorkspace(String address) {
        waitElementToVisible(driver, PerAbout_WorkAndEducation_PageUI.ADDRESS_WORKPLACE);
        sendKeyToElement(driver, PerAbout_WorkAndEducation_PageUI.ADDRESS_WORKPLACE, address);
        setTimeDelay(1);
    }

    public void enterDataToDescriptionOfWorkspace(String description) {
        waitElementToVisible(driver, PerAbout_WorkAndEducation_PageUI.DESC_WORLPLACE);
        sendKeyToElement(driver, PerAbout_WorkAndEducation_PageUI.DESC_WORLPLACE, description);
    }

    public void checkOptionTimePeriod() {
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.CHECKBOX_TIME_PERIOD);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.CHECKBOX_TIME_PERIOD);
    }


    public void chooseStartTimeOfWorkplace(String dateStart, String monthStart, String yearStart) {
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, yearStart, "workplaceVM.yearFrom");
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, monthStart, "workplaceVM.monthFrom");
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, dateStart, "workplaceVM.dayFrom");
    }

    public void chooseEndimeOfWorkplace(String dateSEnd, String monthEnd, String yearEnd) {
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, yearEnd, "workplaceVM.yearTo");
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, monthEnd, "workplaceVM.monthTo");
        selectItemInCustomDropdown(driver, PerAbout_WorkAndEducation_PageUI.DATE_DROPDOWN_OF_WORKPLACE, PerAbout_WorkAndEducation_PageUI.ITEM_DATE_DROPDOWN_OF_WORKPLACE, dateSEnd, "workplaceVM.dayTo");
    }


    public void chooseStartTimeAndEndTimeOfWorkspace(String dateItem, String monthItem, String yearItem) {
        if (checkTimePeriodIsSelected()) {
            chooseStartTimeOfWorkplace("12", "10", "2010");
        } else {
            chooseStartTimeOfWorkplace("", "", "");
            chooseEndimeOfWorkplace("", "", "");
        }
    }

    private boolean checkTimePeriodIsSelected() {
        return true;
    }

    public void chooseScopeOfWorkPlace(String scopeName) {
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.SCOPE_DROPDOWN_OF_WORKPLACE);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.SCOPE_DROPDOWN_OF_WORKPLACE);
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.SCOPE_ITEM_OF_WORKPLACE, scopeName);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.SCOPE_ITEM_OF_WORKPLACE, scopeName);
    }

    public void clickButtonToSaveWorkplace() {
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.SAVE_WORKPLACE);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.SAVE_WORKPLACE);
    }

    public void cancelSaveWorkPlace() {
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.CANCEL_ADD_WORKPLACE);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.CANCEL_ADD_WORKPLACE);
    }

    public String getCompanyOfWorkplace() {
        return getTextElement(driver, PerAbout_WorkAndEducation_PageUI.COMPANY_WORKPLACE_DATA);
    }

    public String getPositionOfWorkplace() {
        return getTextElement(driver, PerAbout_WorkAndEducation_PageUI.POSITION_WORKPLACE_DATA);
    }

    public String getAddressOfWorkplace() {
        return getTextElement(driver, PerAbout_WorkAndEducation_PageUI.ADDRESS_WORKPLACE_DATA);
    }

    public String getScopeOfWorkplace() {
        return getTextElement(driver, PerAbout_WorkAndEducation_PageUI.SCOPE_WORKPLACE_DATA);
    }



    // Highschool section

    public String getDataNameOfHighschoolDisplay() {
        return getTextElement(driver, PerAbout_WorkAndEducation_PageUI.DATA_NAME_OF_HIGHSCHOOL);
    }

    public String getAddressDataOfHighschoolDisplay() {
        return getTextElement(driver, PerAbout_WorkAndEducation_PageUI.DATA_ADDRESS_OF_HIGHSCHOOL);
    }

    public String getTypeScopeOfHighschoolDisplay() {
        return getTextElement(driver, PerAbout_WorkAndEducation_PageUI.DATA_SCOPE_OF_HIGHSCHOOL);
    }

    public void clickButtonToAddnewHighschool() {
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.ADD_NEW_HIGHSCHOOL);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.ADD_NEW_HIGHSCHOOL);
    }

    public void enterDataToHighschoolName(String highschoolName) {
        waitElementToVisible(driver, PerAbout_WorkAndEducation_PageUI.HIGHSCHOOL_NAME_FIELD);
        sendKeyToElement(driver, PerAbout_WorkAndEducation_PageUI.HIGHSCHOOL_NAME_FIELD, highschoolName);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.HIGHSCHOOL_NAME_DROPDOWWN_ITEM);
        setTimeDelay(1);
    }

    public void enterDataToHighschoolAddress(String highschoolAddress) {
        waitElementToVisible(driver, PerAbout_WorkAndEducation_PageUI.HIGHSCHOOL_ADDRESS);
        sendKeyToElement(driver, PerAbout_WorkAndEducation_PageUI.HIGHSCHOOL_ADDRESS, highschoolAddress);
    }

    public void enterDataToHighschoolDescription(String highschoolDesc) {
        waitElementToVisible(driver, PerAbout_WorkAndEducation_PageUI.HIGHSCHOOL_ADDRESS);
        sendKeyToElement(driver, PerAbout_WorkAndEducation_PageUI.HIGHSCHOOL_ADDRESS, highschoolDesc);
    }

    public void chooseStartTimeAndEndTimeOfHighschool() {
        selectStartDateOfHighschool();
        selectEndDateOfHighschool();
    }

    private void selectStartDateOfHighschool() {
    }

    private void selectEndDateOfHighschool() {
    }

    public void checkOptionGruatedOfHighschool() {
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.CHECKBOX_GRADUATED_OF_HIGHSCHOOL);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.CHECKBOX_GRADUATED_OF_HIGHSCHOOL);
    }

    public void chooseScopeOfHighschool(String scopeName) {
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.HIGHSCHOOL_SCOPE_DOWN);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.HIGHSCHOOL_SCOPE_DOWN);
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.HIGHSCHOOL_SCOPE_ITEM, scopeName);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.HIGHSCHOOL_SCOPE_ITEM, scopeName);
    }

    public void clickButtonToSaveHighSchoolItem() {
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.BUTTON_SAVE_CHANGE_HIGHSCHOOL);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.BUTTON_SAVE_CHANGE_HIGHSCHOOL);
    }

    public void clickButtonToCancelSaveHighschoolItem() {
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.BUTTON_CANCEL_SAVE_CHANGE_HiGHSCHOOL);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.BUTTON_CANCEL_SAVE_CHANGE_HiGHSCHOOL);
    }

    // University section

    public String getUniveristyName() {
        return getTextElement(driver, PerAbout_WorkAndEducation_PageUI.DATA_NAME_OF_UNIVERSITY);
    }

    public String getAddressOfUniversity() {
        return getTextElement(driver, PerAbout_WorkAndEducation_PageUI.DATA_ADDRESS_OF_UNIVERSITY);
    }

    public String getScopeOfUniversity() {
        return getTextElement(driver, PerAbout_WorkAndEducation_PageUI.DATA_SCOPE_OF_UNIVERSITY);
    }

    public void clickButtonToAddNewUniveristy() {
        waitForElementClickable(driver, PerAbout_WorkAndEducation_PageUI.ADD_NEW_UNIVERSITY);
        clickToElement(driver, PerAbout_WorkAndEducation_PageUI.ADD_NEW_UNIVERSITY);

    }
    public void enterDataToUniveristyNameField(String univeristyName) {
        waitElementToVisible(driver, PerAbout_WorkAndEducation_PageUI.UNIVERSITY_NAME_FIELD);
        sendKeyToElement(driver, PerAbout_WorkAndEducation_PageUI.UNIVERSITY_NAME_FIELD,univeristyName);
    }

    public void enterDataToUniversityAddressField(String universityAddress) {
        waitElementToVisible(driver, PerAbout_WorkAndEducation_PageUI.UNIVERSITY_ADDRESS_FIELD);
        sendKeyToElement(driver, PerAbout_WorkAndEducation_PageUI.UNIVERSITY_ADDRESS_FIELD,universityAddress);
    }

    public void enterDataToUniversityDescField() {
    }

    public void chooseTimeRangeStudyOfUniversity() {
    }

    public void clickToChooseScopeOfUniversity() {
    }

    public void clickToButtonToSaveUniversity() {
    }
}