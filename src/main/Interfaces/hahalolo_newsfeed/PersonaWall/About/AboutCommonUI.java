package Interfaces.hahalolo_newsfeed.PersonaWall.About;

public class AboutCommonUI {
    // Menu
    public static final String ABOUT_NAVIGATION_MENU = "//nav[contains(@class,'personal-about-nav')]";
    public static final String ITEM_ON_ABOUT_NAVIGATION_MENU = "//nav[contains(@class,'personal-about-nav')]/div[@data-target = '%s']";

    // Workplace
    public static final String BUTTON_ADD_WORK_SPACE = "//div[contains(@data-bind,'btnAddWork')]";
    public static final String BUTTON_EDIT_WORKPLACE = "//div[contains(@data-bind,'workplaceKbCol')]/following-sibling::button";
    public static final String WORKPLACE_LIST = "//div[contains(@data-bind,'workplaceKbCol')]/following-sibling::button";
    public static final String TITLE_JOB_ITEM = "//div[contains(@data-bind,'workplaceKbCol')]//div[position()='%s']//span[contains(@data-bind,'nv212')]";
    public static final String COMPANY_ITEM = "//div[contains(@data-bind,'workplaceKbCol')]//div[position()='%s']//span[contains(@data-bind,'nv211')]";

    // Education
    public static final String BUTTON_ADD_EDUCATION = "//div[contains(@data-bind,'btnAddUniversity')]" ;
    public static final String BUTTON_EDIT_EDUCATION = "//div[contains(@data-bind,'universityKbCol')]/ancestor::div[@class = 'infocard__content']/following-sibling::button";
    public static final String UNIVERSITY_LIST = "//div[contains(@data-bind,'universityKbCol')]";
    public static final String UNIVERSITY_ITEM = "//div[contains(@data-bind,'universityKbCol')]//a[contains(@data-bind, 'nv211')][position()='%s']";
    public static final String HIGHSCHOOL_LIST = "//div[contains(@data-bind,'highschoolKbCol')]";
    public static final String HIGHSCHOOL_ITEM = "//div[contains(@data-bind,'highschoolKbCol')]//a[contains(@data-bind, 'nv211')][position()='%s']";

    // Living and place
    public static final String BUTTON_ADD_LIVING_PLACE = "//div[contains(@data-bind,'btnAddPlace')]";
    public static final String BUTTON_EDIT_PLACE_LIVING = "//a[contains(@data-bind,'homeTownVM.nv211')]/ancestor::div[@class = 'infocard__content']/following-sibling::button";
    public static final String CURRENT_LIVING_ITEM = "//a[contains(@data-bind,'currentCityVM.nv211')]";
    public static final String HOMETOWN_ITEM = "//a[contains(@data-bind,'homeTownVM.nv211')]";





    // Widget User information
    public static final String BUTTON_EDIT_BASIC_INFO_AND_CONTACT = "//a[@href = '#about_contact']";
    public static final String WIDGET_INTRO_PHONE = "//td[contains(@data-bind,'contactAndBasicInfoVM.nv217')]";
    public static final String WIDGET_INTRO_ADDRESS =  "//td[contains(@data-bind,'contactAndBasicInfoVM.nv218')]";
    public static final String WIDGET_INTRO_EMAIL = "//span[contains(@data-bind,'contactAndBasicInfoVM.nv215')]";
    public static final String WIDGET_INTRO_BIRTHDAY = "//span[contains(@data-bind,'contactAndBasicInfoVM.nd206')]" ;
    public static final String WIDGET_INTRO_GENDER = "//span[contains(@data-bind,'contactAndBasicInfoVM.gender')]" ;





}
