package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.PersonalAbout_WorkAndEducation_PageUI;
import org.openqa.selenium.*;

public class PerAbout_WorkAndEducation_PageObject extends PerAbout_Common_PageObject {

    WebDriver driver;

    public PerAbout_WorkAndEducation_PageObject(WebDriver webDriver) {
        driver = webDriver;
    }

    public void clickButtonToAddNewWorkplace() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.ADD_NEW_WORKPLACE_BUTTON);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.ADD_NEW_WORKPLACE_BUTTON);
    }

    public void clickToEditWorkplaceItembyIndex(int indexWorkplace) {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.OPTION_DROPDOWN_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.OPTION_DROPDOWN_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        setTimeDelay(1);
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.EDIT_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.EDIT_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
    }

    public void clickToEditWorkplaceItembyName(String companyName) {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.OPTION_DROPDOWN_WORKPLACE_BY_NAME, companyName);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.OPTION_DROPDOWN_WORKPLACE_BY_NAME, companyName);
        setTimeDelay(1);
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.EDIT_FUNCTION_WORKPLACE_BY_NAME, companyName);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.EDIT_FUNCTION_WORKPLACE_BY_NAME, companyName);
    }

    public void clickToRemoveWorkplaceItemByIndex(String indexWorkplace) {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.OPTION_DROPDOWN_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.OPTION_DROPDOWN_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        setTimeDelay(1);
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.REMOVE_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.REMOVE_WORKPLACE_BY_INDEX, String.valueOf(indexWorkplace));
    }

    public void clickToRemoveWorkplaceItembyName(String companyName) {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.OPTION_DROPDOWN_WORKPLACE_BY_NAME, companyName);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.OPTION_DROPDOWN_WORKPLACE_BY_NAME, companyName);
        setTimeDelay(1);
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.REMOVE_WORKPLACE_BY_NAME, companyName);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.REMOVE_WORKPLACE_BY_NAME, companyName);
    }

    public void enterDataToCompanyNameOfWorkspace(String companyName) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_COMPANY_NAME_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_COMPANY_NAME_FIELD, companyName);
        setTimeDelay(1);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_COMPANY_ITEM);
        setTimeDelay(1);
    }

    public void enterDataToPositionOfWorkspace(String positionJob) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_DESCRIPTION_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_DESCRIPTION_FIELD, positionJob);
        setTimeDelay(1);

    }

    public void enterDataToAddressOfWorkspace(String address) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_ADDRESS_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_ADDRESS_FIELD, address);
        setTimeDelay(1);
    }

    public void enterDataToDescriptionOfWorkspace(String description) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_DESCRIPTION_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_DESCRIPTION_FIELD, description);
    }

    public void checkOptionTimePeriod() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_TIME_PERIOD_CHECKBOX);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_TIME_PERIOD_CHECKBOX);
    }


    public void chooseStartTimeOfWorkplace(String dateStart, String monthStart, String yearStart) {
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_ITEM, yearStart, "workplaceVM.yearFrom");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_ITEM, monthStart, "workplaceVM.monthFrom");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_ITEM, dateStart, "workplaceVM.dayFrom");
    }

    public void chooseEndimeOfWorkplace(String dateSEnd, String monthEnd, String yearEnd) {
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_ITEM, yearEnd, "workplaceVM.yearTo");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_ITEM, monthEnd, "workplaceVM.monthTo");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_ITEM, dateSEnd, "workplaceVM.dayTo");
    }

    public void chooseScopeOfWorkPlace(String scopeName) {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SCOPE_DROPDOWN);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SCOPE_DROPDOWN);
        setTimeDelay(1);
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.SCOPE_ITEM_DROPDOWN, scopeName);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.SCOPE_ITEM_DROPDOWN, scopeName);
    }

    public void clickButtonToSaveWorkplace() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.BUTTON_SAVE_CHANGE_WORKPLACE);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.BUTTON_SAVE_CHANGE_WORKPLACE);
    }

    public void cancelSaveWorkPlace() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.CANCEL_ADD_WORKPLACE);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.CANCEL_ADD_WORKPLACE);
    }

    public String getCompanyOfWorkplace() {
        return getTextElement(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_COMPANY_NAME);
    }

    public String getPositionOfWorkplace() {
        return getTextElement(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_POSITION);

    }

    public String getAddressOfWorkplace() {
        return getTextElement(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_ADDRESS);
    }

    public String getScopeOfWorkplace() {
        return getTextElement(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SCOPE);
    }



    // Highschool section

    public String getDataNameOfHighschoolDisplay() {
        return getTextElement(driver, PersonalAbout_WorkAndEducation_PageUI.HIGHSCHOOL_NAME);
    }

    public String getAddressDataOfHighschoolDisplay() {
        return getTextElement(driver, PersonalAbout_WorkAndEducation_PageUI.HIGHSCHOOL_ADDRESS);
    }

    public String getTypeScopeOfHighschoolDisplay() {
        return getTextElement(driver, PersonalAbout_WorkAndEducation_PageUI.HIGHSCHOOL_SCOPE);
    }

    public void clickButtonToAddnewHighschool() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.ADD_NEW_HIGHSCHOOL_BUTTON);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.ADD_NEW_HIGHSCHOOL_BUTTON);
    }

    public void enterDataToHighschoolName(String highschoolName) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducation_PageUI.HIGHSCHOOL_NAME_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducation_PageUI.HIGHSCHOOL_NAME_FIELD, highschoolName);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.HIGHSCHOOL_NAME_ITEM);
        setTimeDelay(1);
    }

    public void enterDataToHighschoolAddress(String highschoolAddress) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducation_PageUI.HIGHSCHOOL_ADDRESS);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducation_PageUI.HIGHSCHOOL_ADDRESS, highschoolAddress);
    }

    public void enterDataToHighschoolDescription(String highschoolDesc) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducation_PageUI.HIGHSCHOOL_DESCRIPTION_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducation_PageUI.HIGHSCHOOL_DESCRIPTION_FIELD, highschoolDesc);
    }

    public void chooseStartTimeAndEndTimeOfHighschool() {
        selectStartDateOfHighschool("","","");
        selectEndDateOfHighschool("","","");
    }

    private void selectStartDateOfHighschool(String dateStart, String monthStart, String yearStart) {
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_ITEM, yearStart, "universityVM.yearFrom");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_ITEM, monthStart, "universityVM.monthFrom");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_ITEM, dateStart, "universityVM.dayFrom");
    }

    private void selectEndDateOfHighschool(String dateEnd, String monthEnd, String yearEnd) {
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_ITEM, yearEnd, "universityVM.yearTo");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_ITEM, monthEnd, "universityVM.monthTo");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_ITEM, dateEnd, "universityVM.dayTo");
    }

    public void checkOptionGruatedOfHighschool() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.CHECKBOX_GRADUATED_OF_HIGHSCHOOL);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.CHECKBOX_GRADUATED_OF_HIGHSCHOOL);
    }

    public void chooseScopeOfHighschool(String scopeName) {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.HIGHSCHOOL_SCOPE_DOWN);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.HIGHSCHOOL_SCOPE_DOWN);
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.HIGHSCHOOL_SCOPE_ITEM, scopeName);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.HIGHSCHOOL_SCOPE_ITEM, scopeName);
    }

    public void clickButtonToSaveHighSchoolItem() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.BUTTON_SAVE_CHANGE_HIGHSCHOOL);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.BUTTON_SAVE_CHANGE_HIGHSCHOOL);
    }

    public void clickButtonToCancelSaveHighschoolItem() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.BUTTON_CANCEL_SAVE_CHANGE_HiGHSCHOOL);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.BUTTON_CANCEL_SAVE_CHANGE_HiGHSCHOOL);
    }

    // University section
    public String getUniveristyName() {
        return getTextElement(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_NAME);
    }

    public String getAddressOfUniversity() {
        return getTextElement(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_ADDRESS);
    }

    public String getScopeOfUniversity() {
        return getTextElement(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_SCOPE);
    }

    public void clickButtonToAddNewUniveristy() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.ADD_NEW_UNIVERSITY_BUTTON);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.ADD_NEW_UNIVERSITY_BUTTON);

    }
    public void enterDataToUniveristyNameField(String univeristyName) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_NAME_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_NAME_FIELD,univeristyName);
    }

    public void enterDataToUniversityAddressField(String universityAddress) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_ADDRESS_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_ADDRESS_FIELD,universityAddress);
    }

    public void enterDataToUniversityDescField(String universityDesc) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_DESC_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_DESC_FIELD,universityDesc);
    }

    private void selectStartDateOfUniversity(String dateStart, String monthStart, String yearStart) {
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_SELECTED_DATE_ITEM, yearStart, "universityVM.yearFrom");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_SELECTED_DATE_ITEM, monthStart, "universityVM.monthFrom");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.WORKPLACE_SELECTED_DATE_ITEM, dateStart, "universityVM.dayFrom");
    }

    private void selectEndDateOfUniversity(String dateEnd, String monthEnd, String yearEnd) {
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_SELECTED_DATE_ITEM, yearEnd, "universityVM.yearTo");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_SELECTED_DATE_ITEM, monthEnd, "universityVM.monthTo");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_SELECTED_DATE_ITEM, dateEnd, "universityVM.dayTo");
    }

    public void chooseTimeRangeStudyOfUniversity() {
        selectStartDateOfUniversity("","","");
        selectEndDateOfUniversity("","","");
    }

    public void clickToChooseScopeOfUniversity(String scopeName) {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_SCOPE_DROPDOWN);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_SCOPE_DROPDOWN);
        setTimeDelay(1);
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_SCOPE_ITEM);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.UNIVERSITY_SCOPE_ITEM,scopeName);
    }

    public void clickToButtonToSaveUniversity() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducation_PageUI.BUTTON_SAVE_CHANGE_UNIVERSITY);
        clickToElement(driver, PersonalAbout_WorkAndEducation_PageUI.BUTTON_SAVE_CHANGE_UNIVERSITY);
    }

    public boolean checkFormAddWorkplaceIsDisplay() {
        return true;
    }

    public Object getTimeRangeOfWorkplace() {
        return null;
    }
}