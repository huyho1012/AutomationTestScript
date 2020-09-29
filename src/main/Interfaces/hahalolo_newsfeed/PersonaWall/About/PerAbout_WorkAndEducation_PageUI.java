package Interfaces.hahalolo_newsfeed.PersonaWall.About;

public class PerAbout_WorkAndEducation_PageUI {

    public static final String SCOPE_DROPDOWN = "";
    public static final String SCOPE_ITEM_DROPDOWN = "";


    // List Workplace
    public static final String ADD_NEW_WORKPLACE = "//div[contains(@data-bind,'doOpen.formAddWorkplace')]//button";

    public static final String OPTION_OF_ITEM_WORKPLACE_BY_NAME = "//div[@id='workplace']//a[contains(@data-bind,'nv211')][contains(text(),'%s')]/ancestor::div[@class= 'infocard__content']/following-sibling::div//span[@data-toggle ='dropdown']";
    public static final String EDIT_ITEM_WORKPLACE_BY_NAME = "//div[@id='workplace']//a[contains(@data-bind,'nv211')][contains(text()='%s')]/ancestor::div[@class= 'infocard__content']/following-sibling::div//div[contains(@data-bind,'formEditWorkplace')]";
    public static final String REMOVE_ITEM_WORKPLACE_BY_NAME = "//div[@id='workplace']//a[contains(@data-bind,'nv211')][contains(text()='%s')]/ancestor::div[@class= 'infocard__content']/following-sibling::div//div[contains(@data-bind,'openConfirmDelete')]";

    public static final String OPTION_OF_ITEM_WORKPLACE_BY_INDEX = "//div[@id='workplace']//ul[contains(@class,'list-user')][position()='%s']//span[@data-toggle ='dropdown']";
    public static final String EDIT_ITEM_WORKPLACE_BY_INDEX = "//div[@id='workplace']//ul[contains(@class,'list-user')][position()='%s']//div[contains(@data-bind,'formEditWorkplace')]";
    public static final String REMOVE_ITEM_WORKPLACE_BY_INDEX = "//div[@id='workplace']//ul[contains(@class,'list-user')][position()='%s']//div[contains(@data-bind,'openConfirmDelete')]";

    // Form Edit - Add new work
    public static final String COMPANY_WORKPLACE_DROPDOWWN_ITEM = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@name = 'nv211']/following-sibling::div//div[@class='selectize-dropdown-content']//div[position()=1]" ;
    public static final String COMPANY_WORKPLACE = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@name = 'nv211']/following-sibling::div//input";
    public static final String POSITION_WORLPLACE = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@name = 'nv212']";
    public static final String ADDRESS_WORKPLACE = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@name = 'nv213']";
    public static final String DESC_WORLPLACE = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@name = 'nv214']";
    public static final String CHECKBOX_TIME_PERIOD = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@id = 'working']/following-sibling::label";
    public static final String DATE_DROPDOWN_OF_WORKPLACE = "//div[contains(@data-bind,'workplaceVM.cid')]//select[contains(@data-bind,'%s')]/following-sibling::div/div[contains(@class,'selectize-input')]";
    public static final String ITEM_DATE_DROPDOWN_OF_WORKPLACE = "//div[contains(@data-bind,'workplaceVM.cid')]//select[contains(@data-bind,'%s')]/following-sibling::div//div[@class='selectize-dropdown-content']//div";

    public static final String SAVE_WORKPLACE_BUTTON = "";

    public static final String LIST_WORKPLACE = "//div[@id ='workplace']//ul[contains(@class,'list-user')]" ;
    public static final String COMPANY_WORKPLACE_DATA = "//div[@id ='workplace']//ul[contains(@class,'list-user')]//a[contains(@data-bind,'nv211')]";
    public static final String POSITION_WORKPLACE_DATA = "//div[@id ='workplace']//ul[contains(@class,'list-user')]//span[contains(@data-bind,'nv212')]";
    public static final String TIME_RANGE_OF_WORKPLACE_DATA = "";
    public static final String ADDRESS_WORKPLACE_DATA = "//div[@id ='workplace']//ul[contains(@class,'list-user')]//span[contains(@data-bind,'nv213')]";
    public static final String SCOPE_WORKPLACE_DATA = "//div[@id ='workplace']//ul[contains(@class,'list-user')]//i";


    public static final String SAVE_WORKPLACE = "//button[contains(@data-bind,'doAdd.workplace')]";
    public static final String CANCEL_ADD_WORKPLACE = "//button[contains(@data-bind,'doCancel.addWorkplace')]";
    public static final String SEARCH_LOCATION_WORKPLACE = "//div[@id = 'workplace']//input[@name = 'nv213']/following-sibling::div/button";

    // List University
    public static final String ADD_NEW_UNIVERSITY = "//div[contains(@data-bind,'doOpen.formAddUniversity')]";

    public static final String OPTION_OF_ITEM_UNIVERSITY_BY_NAME = "//div[@id='education']//a[contains(@data-bind,'nv211')][contains(text(),'%s')]/ancestor::div[@class= 'infocard__content']/following-sibling::div//span[@data-toggle ='dropdown']";
    public static final String REMOVE_ITEM_UNIVERSITY_BY_NAME = "//div[@id='education']//a[contains(@data-bind,'nv211')][contains(text()='%s')]/ancestor::div[@class= 'infocard__content']/following-sibling::div//div[contains(@data-bind,'openConfirmDelete')]";
    public static final String EDIT_ITEM_UNIVERSITY_BY_NAME = "//div[@id='education']//a[contains(@data-bind,'nv211')][contains(text()='%s')]/ancestor::div[@class= 'infocard__content']/following-sibling::div//div[contains(@data-bind,'formEditWorkplace')]";

    public static final String OPTION_OF_ITEM_UNIVERSITY_BY_INDEX = "//div[@id='education']//ul[contains(@class,'list-user')][position()='%s']//span[@data-toggle ='dropdown']";
    public static final String EDIT_ITEM_UNIVERSITY_BY_INDEX = "//div[@id='education']//ul[contains(@class,'list-user')][position()='%s']//div[contains(@data-bind,'formEditUniversity')]";
    public static final String REMOVE_ITEM_UNIVERSITY_BY_INDEX = "//div[@id='education']//ul[contains(@class,'list-user')][position()='%s']//div[contains(@data-bind,'openConfirmDelete')]";

    // Form Add new University/ Edit University


    public static final String ADD_NEW_HIGHSCHOOL = "";
    public static final String EDIT_WORKPLACE_FUNCTION = "";




    public static final String SCOPE_DROPDOWN_OF_HIGHSCHOOL = "";
    public static final String SCOPE_ITEM_OF_HIGHSCHOOL = "";

    public static final String UNIVERSITY_NAME_FIELD ="" ;

    public static final String HIGHSCHOOL_NAME_FIELD ="" ;
    public static final String HIGHSCHOOL_NAME_ITEM_DROPDOWN = "";
    public static final String HIGHSCHOOL_ADDRESS ="";
    public static final String HIGHSCHOOL_DESCRIPTION = "";

    public static final String BUTTON_SAVE_CHANGE_HIGHSCHOOL = "";
}