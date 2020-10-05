package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.AboutCommonUI;
import Interfaces.hahalolo_newsfeed.PersonaWall.Per_Common_PageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PerAbout_Overview_PageObject extends PerAbout_Common_PageObject {
    WebDriver driver;
    public PerAbout_Overview_PageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPerAboutOverviewTabIsDisplay(){
        waitElementToVisible(driver, Per_Common_PageUI.PER_ABOUT);
        waitElementToVisible(driver, Per_Common_PageUI.ABOUT_MENU);
        return getAttributeValue(driver, Per_Common_PageUI.ABOUT_ITEM_MENU,"class","#about_overview").endsWith("active");
    }
    public void clickAddWorkPlaceButtonToNavigateToWorkAndEducation(){
        waitForElementClickable(driver, AboutCommonUI.BUTTON_ADD_WORKSPACE);
        clickToElement(driver, AboutCommonUI.BUTTON_ADD_WORKSPACE);
    }

    public void clickEditOnWorkplaceSectionToNavigateToWorkAndEducation(){
        waitForElementClickable(driver, AboutCommonUI.BUTTON_EDIT_WORKPLACE);
        clickToElement(driver, AboutCommonUI.BUTTON_EDIT_WORKPLACE);
    }

    public boolean checkWorkplaceSectionWithCaseNoData(){
        return checkElementIsDisplayed(driver, AboutCommonUI.BUTTON_ADD_WORKSPACE);
    }

    public boolean checkWorkplaceSectionWithCaseHaveoData(){
       return checkElementIsDisplayed(driver, AboutCommonUI.BUTTON_EDIT_WORKPLACE);
    }

    public String getJobPositionOfWorkPlace(){
        String jobPosition = null;
        List<WebElement> listWorkPlace = findElements(driver, AboutCommonUI.WORKPLACE_LIST);
        for(WebElement item : listWorkPlace) {
            jobPosition =  getTextElement(driver, AboutCommonUI.JOB_POSITION_OF_WORKPLACE_ITEM);
            return jobPosition;
        }
       return null;
    }

    public String getCompanyNameOfWorkPlace(){
        String companyName;
        List<WebElement> listWorkPlace = findElements(driver, AboutCommonUI.WORKPLACE_LIST);
        for(WebElement item : listWorkPlace) {
            companyName =  getTextElement(driver, AboutCommonUI.COMPANY_NAME_OF_WORKPLACE_ITEM);
            return companyName;
        }
        return null;
    }

    // Section education
    public void clickAddEducationButtonToNavigateToWorkdAndEducation(){
        waitForElementClickable(driver, AboutCommonUI.BUTTON_ADD_EDUCATION);
        clickToElement(driver, AboutCommonUI.BUTTON_ADD_EDUCATION);
    }

    public void clickEditOnEducationSectionToNavigateToTabWorkAndEducation(){
        waitForElementClickable(driver, AboutCommonUI.BUTTON_EDIT_EDUCATION);
        clickToElement(driver, AboutCommonUI.BUTTON_EDIT_EDUCATION);
    }

    public boolean checkEducationSectionWithCaseNoData(){
        return checkElementIsDisplayed(driver, AboutCommonUI.BUTTON_ADD_WORKSPACE);
    }

    public boolean checkEducationSectionWithCaseHaveoData(){
        return checkElementIsDisplayed(driver, AboutCommonUI.BUTTON_EDIT_EDUCATION);
    }

    public String getUniversityName(){
        String universityName;
        List<WebElement> listUniveristy = findElements(driver, AboutCommonUI.UNIVERSITY_LIST);
        for(WebElement item : listUniveristy) {
            universityName =  getTextElement(driver, AboutCommonUI.UNIVERSITY_ITEM);
            return universityName;
        }
        return null;
    }

    public String getHighschoolName(){
        String highschoolName;
        List<WebElement> listHighschool = findElements(driver, AboutCommonUI.HIGHSCHOOL_LIST);
        for(WebElement item : listHighschool) {
            highschoolName =  getTextElement(driver, AboutCommonUI.HIGHSCHOOL_ITEM);
            return highschoolName;
        }
        return null;
    }

    public void clickAddCurrentCityAndHomeTownButtonToNavigateToPlaceYouLived(){
        waitForElementClickable(driver, AboutCommonUI.BUTTON_ADD_LIVING_PLACE);
        clickToElement(driver, AboutCommonUI.BUTTON_ADD_LIVING_PLACE);
    }

    public void clickEditOnPlaceLivingSectionToNavigateToTabPlaceYouLived(){
        waitForElementClickable(driver, AboutCommonUI.BUTTON_EDIT_PLACE_LIVING);
        clickToElement(driver, AboutCommonUI.BUTTON_EDIT_PLACE_LIVING);
    }

    public boolean checkHomeTownAndCurrentCitySectionWithCaseNoData(){
        return checkElementIsDisplayed(driver, AboutCommonUI.BUTTON_ADD_LIVING_PLACE);
    }

    public boolean checkHomeTownAndCurrentCitySectionWithCaseHaveoData(){
        return checkElementIsDisplayed(driver, AboutCommonUI.BUTTON_EDIT_PLACE_LIVING);
    }

    public String getCurrentCity(){
        return getTextElement(driver, AboutCommonUI.CURRENT_LIVING_ITEM);
    }

    public String getHomeTown(){
        return  getTextElement(driver, AboutCommonUI.HOMETOWN_ITEM);
    }


    public String getEmailIsDisplayOnIntroduceWidget() {
        return getTextElement(driver, AboutCommonUI.WIDGET_INTRO_EMAIL);
    }

    public String getBirthdayDisplayOnIntroduceWidget() {
        return getTextElement(driver, AboutCommonUI.WIDGET_INTRO_BIRTHDAY);
    }

    public String getGenderDisplayOnIntroduceWidget() {
        waitElementToVisible(driver, AboutCommonUI.WIDGET_INTRO_GENDER);
        return getTextElement(driver, AboutCommonUI.WIDGET_INTRO_GENDER);
    }

    public String getAddressDisplayOnIntroduceWidget(){
        waitElementToVisible(driver, AboutCommonUI.WIDGET_INTRO_ADDRESS);
        return getTextElement(driver, AboutCommonUI.WIDGET_INTRO_ADDRESS);
    }

    public void clickToEditBasicInfoAndContact(){
        waitForElementClickable(driver, AboutCommonUI.BUTTON_EDIT_BASIC_INFO_AND_CONTACT);
        clickToElement(driver, AboutCommonUI.BUTTON_EDIT_BASIC_INFO_AND_CONTACT);
    }

    public boolean checkOverViewTabCaseNewAccount() {
        return checkEducationSectionWithCaseNoData() && checkHomeTownAndCurrentCitySectionWithCaseNoData() && checkWorkplaceSectionWithCaseNoData();
    }
}
