package Interfaces.hahalolo_newsfeed.PersonaWall.About;

public class PersonalAbout_Overview_PageUI {
    // Workplace
    public static final String BUTTON_ADD_WORKSPACE = "//div[contains(@data-bind,'btnAddWork')]";
    public static final String BUTTON_EDIT_WORKPLACE = "//div[contains(@data-bind,'workplaceKbCol')]/following-sibling::button";
    public static final String WORKPLACE_LIST = "//div[contains(@data-bind,'workplaceKbCol')]";
    public static final String JOB_POSITION_OF_WORKPLACE_ITEM = "//div[contains(@data-bind,'workplaceKbCol')]//span[contains(@data-bind,'nv212')]";
    public static final String COMPANY_NAME_OF_WORKPLACE_ITEM = "//div[contains(@data-bind,'workplaceKbCol')]//span[contains(@data-bind,'nv211')]";

    // Education
    public static final String BUTTON_ADD_EDUCATION = "//div[contains(@data-bind,'btnAddUniversity')]" ;
    public static final String BUTTON_EDIT_EDUCATION = "//div[contains(@data-bind,'universityKbCol')]/ancestor::div[@class = 'infocard__content']/following-sibling::button";
    public static final String UNIVERSITY_LIST = "//div[contains(@data-bind,'universityKbCol')]";
    public static final String UNIVERSITY_ITEM = "//div[contains(@data-bind,'universityKbCol')]//a[contains(@data-bind, 'nv211')]";
    public static final String HIGHSCHOOL_LIST = "//div[contains(@data-bind,'highschoolKbCol')]";
    public static final String HIGHSCHOOL_ITEM = "//div[contains(@data-bind,'highschoolKbCol')]//a[contains(@data-bind, 'nv211')]";

    // Living and place
    public static final String BUTTON_ADD_LIVING_PLACE = "//div[contains(@data-bind,'btnAddPlace')]";
    public static final String BUTTON_EDIT_PLACE_LIVING = "//a[contains(@data-bind,'homeTownVM.nv211')]/ancestor::div[@class = 'infocard__content']/following-sibling::button";
    public static final String CURRENT_LIVING_ITEM = "//a[contains(@data-bind,'currentCityVM.nv211')]";
    public static final String HOMETOWN_ITEM = "//a[contains(@data-bind,'homeTownVM.nv211')]";

    // Widget User information
    public static final String BUTTON_EDIT_BASIC_INFO_AND_CONTACT = "//a[@href = '#about_contact']";
    public static final String WIDGET_INTRO_PHONE = "//td[contains(@data-bind,'contactAndBasicInfoVM.nv217')]";
    public static final String WIDGET_INTRO_ADDRESS = "//td[contains(@data-bind,'contactAndBasicInfoVM.nv218')]";
    public static final String WIDGET_INTRO_EMAIL = "//span[contains(@data-bind,'contactAndBasicInfoVM.nv215')]";
    public static final String WIDGET_INTRO_BIRTHDAY = "//span[contains(@data-bind,'contactAndBasicInfoVM.nd206')]" ;
    public static final String WIDGET_INTRO_GENDER = "//span[contains(@data-bind,'contactAndBasicInfoVM.gender')]" ;



}
