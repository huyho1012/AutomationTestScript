package Interfaces.hahalolo_newsfeed.PersonaWall.About;

public class WorkEducationUI {

    // List Workplace
    public static final String ADD_NEW_WORKPLACE = "//div[contains(@data-bind,'doOpen.formAddWorkplace')]";

    public static final String OPTION_OF_ITEM_WORKPLACE_BY_NAME = "//div[@id='workplace']//a[contains(@data-bind,'nv211')][contains(text(),'%s')]/ancestor::div[@class= 'infocard__content']/following-sibling::div//span[@data-toggle ='dropdown']";
    public static final String EDIT_ITEM_WORKPLACE_BY_NAME = "//div[@id='workplace']//a[contains(@data-bind,'nv211')][contains(text()='%s')]/ancestor::div[@class= 'infocard__content']/following-sibling::div//div[contains(@data-bind,'formEditWorkplace')]";
    public static final String REMOVE_ITEM_WORKPLACE_BY_NAME ="//div[@id='workplace']//a[contains(@data-bind,'nv211')][contains(text()='%s')]/ancestor::div[@class= 'infocard__content']/following-sibling::div//div[contains(@data-bind,'openConfirmDelete')]";

    public static final String OPTION_OF_ITEM_WORKPLACE_BY_INDEX = "//div[@id='workplace']//ul[contains(@class,'list-user')][position()='%s']//span[@data-toggle ='dropdown']";
    public static final String EDIT_ITEM_WORKPLACE_BY_INDEX = "//div[@id='workplace']//ul[contains(@class,'list-user')][position()='%s']//div[contains(@data-bind,'formEditWorkplace')]";
    public static final String REMOVE_ITEM_WORKPLACE_BY_INDEX ="//div[@id='workplace']//ul[contains(@class,'list-user')][position()='%s']//div[contains(@data-bind,'openConfirmDelete')]";

    // Form Edit - Add new work
    public static final String COMPANY_WORKPLACE = "//div[@id = 'workplace']//input[@name = 'nv211']";
    public static final String POSITION_WORLPLACE = "//div[@id = 'workplace']//input[@name = 'nv212']";
    public static final String ADDRESS_WORKPLACE = "//div[@id = 'workplace']//input[@name = 'nv213']";
    public static final String DESC_WORLPLACE = "//div[@id = 'workplace']//input[@name = 'nv214']";
    public static final String CHECKBOX_TIME_PERIOD = "//input[@id = 'working']/following-sibling::label";

    public static final String DATE_DROPDOWN_OF_WORKPLACE = "//select[contains(@data-bind,'%s')]/following-sibling::div/div[contains(@class,'selectize-input')]";
    public static final String ITEM_DATE_DROPDOWN_OF_WORKPLACE = "//select[contains(@data-bind,'%s')]/following-sibling::div//div[@class='selectize-dropdown-content']//div";
    public static final String SAVE_WORKPLACE = "//button[contains(@data-bind,'doAdd.workplace')]";
    public static final String CANCEL_ADD_WORKPLACE = "//button[contains(@data-bind,'doCancel.addWorkplace')]";
    public static final String SEARCH_LOCATION = "//div[@id = 'workplace']//input[@name = 'nv213']/following-sibling::div/button";

    // List University
    public static final String ADD_NEW_UNIVERSITY = "//div[contains(@data-bind,'doOpen.formAddUniversity')]";

    public static final String OPTION_OF_ITEM_UNIVERSITY_BY_NAME = "//div[@id='education']//a[contains(@data-bind,'nv211')][contains(text(),'%s')]/ancestor::div[@class= 'infocard__content']/following-sibling::div//span[@data-toggle ='dropdown']";
    public static final String REMOVE_ITEM_UNIVERSITY_BY_NAME ="//div[@id='education']//a[contains(@data-bind,'nv211')][contains(text()='%s')]/ancestor::div[@class= 'infocard__content']/following-sibling::div//div[contains(@data-bind,'openConfirmDelete')]";
    public static final String EDIT_ITEM_UNIVERSITY_BY_NAME = "//div[@id='education']//a[contains(@data-bind,'nv211')][contains(text()='%s')]/ancestor::div[@class= 'infocard__content']/following-sibling::div//div[contains(@data-bind,'formEditWorkplace')]";

    public static final String OPTION_OF_ITEM_UNIVERSITY_BY_INDEX = "//div[@id='education']//ul[contains(@class,'list-user')][position()='%s']//span[@data-toggle ='dropdown']";
    public static final String EDIT_ITEM_UNIVERSITY_BY_INDEX = "//div[@id='education']//ul[contains(@class,'list-user')][position()='%s']//div[contains(@data-bind,'formEditUniversity')]";
    public static final String REMOVE_ITEM_UNIVERSITY_BY_INDEX ="//div[@id='education']//ul[contains(@class,'list-user')][position()='%s']//div[contains(@data-bind,'openConfirmDelete')]";

    // Form Add new University/ Edit University


    public static final String ADD_NEW_HIGHSCHOOL = "" ;
    public static final String EDIT_WORKPLACE_FUNCTION = "";


;


    public static final String SAVE_WORKPLACE_BUTTON = "";

}