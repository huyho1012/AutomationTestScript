package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.PersonalAbout_Overview_PageUI;
import Interfaces.hahalolo_newsfeed.PersonaWall.Personal_Common_PageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PerAbout_Overview_PageObject extends PerAbout_Common_PageObject {
    WebDriver driver;
    public PerAbout_Overview_PageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPerAboutOverviewTabIsDisplay(){
        waitElementToVisible(driver, Personal_Common_PageUI.PER_ABOUT);
        waitElementToVisible(driver, Personal_Common_PageUI.ABOUT_MENU);
        return getAttributeValue(driver, Personal_Common_PageUI.ABOUT_ITEM_MENU,"class","#about_overview").endsWith("active");
    }
    public void clickAddWorkPlaceButtonToNavigateToWorkAndEducation(){
        waitForElementClickable(driver, PersonalAbout_Overview_PageUI.BUTTON_ADD_WORKSPACE);
        clickToElement(driver, PersonalAbout_Overview_PageUI.BUTTON_ADD_WORKSPACE);
    }

    public void clickEditOnWorkplaceSectionToNavigateToWorkAndEducation(){
        waitForElementClickable(driver, PersonalAbout_Overview_PageUI.BUTTON_EDIT_WORKPLACE);
        clickToElement(driver, PersonalAbout_Overview_PageUI.BUTTON_EDIT_WORKPLACE);
    }

    public boolean checkWorkplaceSectionWithCaseNoData(){
        return checkElementIsDisplayed(driver, PersonalAbout_Overview_PageUI.BUTTON_ADD_WORKSPACE);
    }

    public boolean checkWorkplaceSectionWithCaseHaveoData(){
       return checkElementIsDisplayed(driver, PersonalAbout_Overview_PageUI.BUTTON_EDIT_WORKPLACE);
    }

    public String getJobPositionOfWorkPlace(){
        String jobPosition = null;
        List<WebElement> listWorkPlace = findElements(driver, PersonalAbout_Overview_PageUI.WORKPLACE_LIST);
        for(WebElement item : listWorkPlace) {
            jobPosition =  getTextElement(driver, PersonalAbout_Overview_PageUI.JOB_POSITION_OF_WORKPLACE_ITEM);
            return jobPosition;
        }
       return null;
    }

    public String getCompanyNameOfWorkPlace(){
        String companyName;
        List<WebElement> listWorkPlace = findElements(driver, PersonalAbout_Overview_PageUI.WORKPLACE_LIST);
        for(WebElement item : listWorkPlace) {
            companyName =  getTextElement(driver, PersonalAbout_Overview_PageUI.COMPANY_NAME_OF_WORKPLACE_ITEM);
            return companyName;
        }
        return null;
    }

    // Section education
    public void clickAddEducationButtonToNavigateToWorkdAndEducation(){
        waitForElementClickable(driver, PersonalAbout_Overview_PageUI.BUTTON_ADD_EDUCATION);
        clickToElement(driver, PersonalAbout_Overview_PageUI.BUTTON_ADD_EDUCATION);
    }

    public void clickEditOnEducationSectionToNavigateToTabWorkAndEducation(){
        waitForElementClickable(driver, PersonalAbout_Overview_PageUI.BUTTON_EDIT_EDUCATION);
        clickToElement(driver, PersonalAbout_Overview_PageUI.BUTTON_EDIT_EDUCATION);
    }

    public boolean checkEducationSectionWithCaseNoData(){
        return checkElementIsDisplayed(driver, PersonalAbout_Overview_PageUI.BUTTON_ADD_WORKSPACE);
    }

    public boolean checkEducationSectionWithCaseHaveoData(){
        return checkElementIsDisplayed(driver, PersonalAbout_Overview_PageUI.BUTTON_EDIT_EDUCATION);
    }

    public String getUniversityName(){
        String universityName;
        List<WebElement> listUniveristy = findElements(driver, PersonalAbout_Overview_PageUI.UNIVERSITY_LIST);
        for(WebElement item : listUniveristy) {
            universityName =  getTextElement(driver, PersonalAbout_Overview_PageUI.UNIVERSITY_ITEM);
            return universityName;
        }
        return null;
    }

    public String getHighschoolName(){
        String highschoolName;
        List<WebElement> listHighschool = findElements(driver, PersonalAbout_Overview_PageUI.HIGHSCHOOL_LIST);
        for(WebElement item : listHighschool) {
            highschoolName =  getTextElement(driver, PersonalAbout_Overview_PageUI.HIGHSCHOOL_ITEM);
            return highschoolName;
        }
        return null;
    }

    public void clickAddCurrentCityAndHomeTownButtonToNavigateToPlaceYouLived(){
        waitForElementClickable(driver, PersonalAbout_Overview_PageUI.BUTTON_ADD_LIVING_PLACE);
        clickToElement(driver, PersonalAbout_Overview_PageUI.BUTTON_ADD_LIVING_PLACE);
    }

    public void clickEditOnPlaceLivingSectionToNavigateToTabPlaceYouLived(){
        waitForElementClickable(driver, PersonalAbout_Overview_PageUI.BUTTON_EDIT_PLACE_LIVING);
        clickToElement(driver, PersonalAbout_Overview_PageUI.BUTTON_EDIT_PLACE_LIVING);
    }

    public boolean checkHomeTownAndCurrentCitySectionWithCaseNoData(){
        return checkElementIsDisplayed(driver, PersonalAbout_Overview_PageUI.BUTTON_ADD_LIVING_PLACE);
    }

    public boolean checkHomeTownAndCurrentCitySectionWithCaseHaveoData(){
        return checkElementIsDisplayed(driver, PersonalAbout_Overview_PageUI.BUTTON_EDIT_PLACE_LIVING);
    }

    public String getCurrentCity(){
        return getTextElement(driver, PersonalAbout_Overview_PageUI.CURRENT_LIVING_ITEM);
    }

    public String getHomeTown(){
        return  getTextElement(driver, PersonalAbout_Overview_PageUI.HOMETOWN_ITEM);
    }


    public String getEmailIsDisplayOnIntroduceWidget() {
        return getTextElement(driver, PersonalAbout_Overview_PageUI.WIDGET_INTRO_EMAIL);
    }

    public String getBirthdayDisplayOnIntroduceWidget() {
        return getTextElement(driver, PersonalAbout_Overview_PageUI.WIDGET_INTRO_BIRTHDAY);
    }

    public String getGenderDisplayOnIntroduceWidget() {
        waitElementToVisible(driver, PersonalAbout_Overview_PageUI.WIDGET_INTRO_GENDER);
        return getTextElement(driver, PersonalAbout_Overview_PageUI.WIDGET_INTRO_GENDER);
    }

    public String getAddressDisplayOnIntroduceWidget(){
        waitElementToVisible(driver, PersonalAbout_Overview_PageUI.WIDGET_INTRO_ADDRESS);
        return getTextElement(driver, PersonalAbout_Overview_PageUI.WIDGET_INTRO_ADDRESS);
    }

    public String getPhoneNumberDisplayOnIntroduceWidget(){
        waitElementToVisible(driver, PersonalAbout_Overview_PageUI.WIDGET_INTRO_PHONE);
        return getTextElement(driver, PersonalAbout_Overview_PageUI.WIDGET_INTRO_PHONE);
    }

    public void clickToEditBasicInfoAndContact(){
        waitForElementClickable(driver, PersonalAbout_Overview_PageUI.BUTTON_EDIT_BASIC_INFO_AND_CONTACT);
        clickToElement(driver, PersonalAbout_Overview_PageUI.BUTTON_EDIT_BASIC_INFO_AND_CONTACT);
    }

    public boolean checkOverViewTabCaseNewAccount() {
        return checkEducationSectionWithCaseNoData() && checkHomeTownAndCurrentCitySectionWithCaseNoData() && checkWorkplaceSectionWithCaseNoData();
    }
}
