package Interfaces.hahalolo_newsfeed.PersonaWall.About;

public class PerAbout_PlacesYouLived_PageUI {

    public static final String CURRENT_CITY_DATA =  "//ul[contains(@data-bind, 'currentCityVM')]//a[contains(@data-bind,'nv211')]";
    public static final String ADD_NEW_CURRENT_CITY ="//div[contains(@data-bind,'doOpen.formAddCurrentCity')]";
    public static final String ICON_EDIT_CURRENT_CITY = "//button[contains(@data-bind,'formEditCurrentCity')]";
    public static final String CURRENT_CITY_FIELD = "//label[contains(@data-bind,'txtCurrentCity')]/parent::div//input[@name = 'nv213']";
    public static final String BUTTON_SAVE_CURRENT_CITY = "//button[contains(@data-bind,'doAdd.currentCity')]";
    public static final String BUTTON_CANCEL_SAVE_CURRENT_CITY = "//button[contains(@data-bind,'doCancel.currentCity')]";

    public static final String HOME_TOWN_DATA = "//ul[contains(@data-bind, 'homeTownVM')]//a[contains(@data-bind,'nv211')]" ;
    public static final String ADD_NEW_HOMETOWN ="//div[contains(@data-bind,'doOpen.formAddLocationYouLive')]";
    public static final String ICON_EDIT_HOMETOWN = "//button[contains(@data-bind,'formEditLocationYouLive')]";
    public static final String HOMETOWN_FIELD = "//label[contains(@data-bind,'txtHomeTown')]/parent::div//input[@name = 'nv213']";
    public static final String BUTTON_SAVE_HOMETOWN = "//button[contains(@data-bind,'doAdd.locationYouLive')]";
    public static final String BUTTON_CANCEL_SAVE_HOMETOWN = "//button[contains(@data-bind,'doCancel.locationYouLive')]";


}
