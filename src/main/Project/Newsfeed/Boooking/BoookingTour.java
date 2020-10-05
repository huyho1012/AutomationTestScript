package Project.Newsfeed.Boooking;

import Interfaces.hahalolo_newsfeed.Booking.Newsfeed_Booking_Common_PageUI;
import Interfaces.hahalolo_newsfeed.Booking.Newsfeed_Booking_Tour_PageUI;
import org.openqa.selenium.WebDriver;

public class BoookingTour extends BookingCommon {
    WebDriver driver;
    public BoookingTour (WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkTourBookingStep1IsDisplay(WebDriver driver){
        return checkElementIsDisplayed(driver, Newsfeed_Booking_Common_PageUI.TITLE_BOOKING_STEP,"Thông tin chuyến đi");
    }

    public String getBasicPriceDisplayOnStep1(WebDriver driver) {
        waitElementToVisible(driver, Newsfeed_Booking_Common_PageUI.TITLE_BOOKING_STEP,"Thông tin chuyến đi");
        return getTextElement(driver, Newsfeed_Booking_Tour_PageUI.BASIC_PRICE_ON_DETAIL_STEP1);
    }

    public String getDepartureDateDisplayOnStep1(WebDriver driver) {
        waitElementToVisible(driver, Newsfeed_Booking_Common_PageUI.TITLE_BOOKING_STEP,"Thông tin chuyến đi");
        return getTextElement(driver, Newsfeed_Booking_Tour_PageUI.DEPARTURE_DATE_ON_DETAIL_STEP1);
    }

    public String getDeparturePlaceOnStep1(WebDriver driver) {
        waitElementToVisible(driver, Newsfeed_Booking_Common_PageUI.TITLE_BOOKING_STEP,"Thông tin chuyến đi");
        return getTextElement(driver, Newsfeed_Booking_Tour_PageUI.DEPARTURE_PLACE_ON_DETAIL_STEP1);
    }

    public String getDestinationPlaceDOnStep1(WebDriver driver) {
        waitElementToVisible(driver, Newsfeed_Booking_Common_PageUI.TITLE_BOOKING_STEP,"Thông tin chuyến đi");
        return getTextElement(driver, Newsfeed_Booking_Tour_PageUI.DESTINATION_ON_DETAIL_STEP1);
    }

    public String getValuePriceByTypeAge(WebDriver driver, String typeAge){
        waitElementToVisible(driver, Newsfeed_Booking_Common_PageUI.TITLE_BOOKING_STEP,"Thông tin chuyến đi");
        return getTextElement(driver, Newsfeed_Booking_Tour_PageUI.PRICE_OF_TYPE_AGE,typeAge);
    }

    public boolean checkTourBookingStep2IsDisplay(WebDriver driver){
        return checkElementIsDisplayed(driver, Newsfeed_Booking_Common_PageUI.TITLE_BOOKING_STEP,"Chi tiết khách du lịch");
    }

    public void choosePerTitleOfTourLeader(WebDriver driver) {
    }

    public String getDefaultDataOfLeaderTraveller(WebDriver driver, String namefield) {
        waitElementToVisible(driver, Newsfeed_Booking_Common_PageUI.TITLE_BOOKING_STEP,"Chi tiết khách du lịch");
        return getTextElement(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_LEADER_INFO,namefield);
    }

    public void enterDataToDynamicFieldOnTourLeader(WebDriver driver, String nameField, String valueData) {
        waitElementToVisible(driver, Newsfeed_Booking_Common_PageUI.TITLE_BOOKING_STEP,"Chi tiết khách du lịch");
        waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_LEADER_INFO,nameField);
        sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_LEADER_INFO,valueData, nameField);
    }

    public void enterRequestNote(WebDriver driver,  String requestNote) {
        waitElementToVisible(driver, Newsfeed_Booking_Common_PageUI.TITLE_BOOKING_STEP,"Chi tiết khách du lịch");
        waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.REQUEST_NOTE_TEXTAREA);
        sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.REQUEST_NOTE_TEXTAREA,requestNote);
    }

    public void chooseOptionImTourist() {
    }

    public void chooseNumberAdult(WebDriver driver, int numberAdult) {

        waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.DROPDOWN_CHOOSE_PERSON_BY_TYPE,"Người lớn");
        sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.NUMBER_PER_BY_TYPE_AGE, String.valueOf(numberAdult),"Người lớn");
    }

    public void chooseNumberChild(WebDriver driver, int numberChild) {
        if(checkElementIsDisplayed(driver, Newsfeed_Booking_Tour_PageUI.DROPDOWN_CHOOSE_PERSON_BY_TYPE,"Trẻ em")) {
            waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.NUMBER_PER_BY_TYPE_AGE,"Trẻ em");
            sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.NUMBER_PER_BY_TYPE_AGE,String.valueOf(numberChild),"Trẻ em");
        }
    }

    public void chooseNumberYoungChild(WebDriver driver,int numberYoungChild) {
        if(checkElementIsDisplayed(driver, Newsfeed_Booking_Tour_PageUI.DROPDOWN_CHOOSE_PERSON_BY_TYPE,"Trẻ nhỏ")) {
            waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.NUMBER_PER_BY_TYPE_AGE, "Trẻ nhỏ");
            sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.NUMBER_PER_BY_TYPE_AGE, String.valueOf(numberYoungChild), "Trẻ nhỏ");
        }
    }

    public void chooseNumberOfInfant(WebDriver driver , int numberYoungChild) {
        if(checkElementIsDisplayed(driver, Newsfeed_Booking_Tour_PageUI.DROPDOWN_CHOOSE_PERSON_BY_TYPE,"Em bé")) {
            waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.NUMBER_PER_BY_TYPE_AGE, "Em bé");
            sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.NUMBER_PER_BY_TYPE_AGE, String.valueOf(numberYoungChild), "Em bé");
        }
    }

    public boolean checBookingTourStep3IsDisplay() {
        return true;
    }

    public void enterValueOfAdullInfo(WebDriver driver,int numberAdult, String fullname, String bithday, String gender, String address) {
        if(checkElementIsSelected(driver, Newsfeed_Booking_Tour_PageUI.CHECKBOX_TRAVEL_LEADER)){
            for(int i = 1; i<= numberAdult; i++){
                // Enter fullname
                waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Người lớn",String.valueOf(i+1), "ov402");
                sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,fullname,"Người lớn", String.valueOf(i+1), "ov402");
                // Enter birthday
                waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,String.valueOf(i+1), "Người lớn", "od403");
                sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,bithday,String.valueOf(i+1),"Người lớn", "od403");
                // Choose gender
                selectItemInCustomDropdown(driver, Newsfeed_Booking_Tour_PageUI.GENDER_DROPDOWN_ON_TRAVELLER, Newsfeed_Booking_Tour_PageUI.GENDER_ITEM_ON_ADULT_INFO, gender, "Người lớn", String.valueOf(i+1));
                // Enter address
                waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,String.valueOf(i+1), "Người lớn", "ov405");
                sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,address, String.valueOf(i+1),"Người lớn", "ov405");
            }
        }
        else {
            for(int i = 1; i<= numberAdult; i++){
                // Enter fullname
                waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Người lớn", String.valueOf(i), "ov402");
                sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,fullname,"Người lớn", String.valueOf(i), "ov402");
                // Enter birthday
                waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Người lớn",String.valueOf(i), "od403");
                sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,bithday,"Người lớn", String.valueOf(i), "od403");
                // Choose gender
                selectItemInCustomDropdown(driver, Newsfeed_Booking_Tour_PageUI.GENDER_DROPDOWN_ON_TRAVELLER, Newsfeed_Booking_Tour_PageUI.GENDER_ITEM_ON_ADULT_INFO,gender,"Người lớn", String.valueOf(i));
                // Enter address
                waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Người lớn", String.valueOf(i), "ov405");
                sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,address,"Người lớn", String.valueOf(i),"ov405");
            }
        }
    }

    public void enterValueOfChildInfo(WebDriver driver,int numberChild, String fullname, String bithday, String gender, String address) {
        for(int i = 1; i<= numberChild; i++){
            // Enter fullname
            waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Trẻ em",String.valueOf(i), "ov402");
            sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,fullname,"Trẻ em",String.valueOf(i), "ov402");
            // Enter birthday
            waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Trẻ em",String.valueOf(i), "od403");
            sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,bithday,"Trẻ em", String.valueOf(i), "od403");
            // Choose gender
            selectItemInCustomDropdown(driver, Newsfeed_Booking_Tour_PageUI.GENDER_DROPDOWN_ON_TRAVELLER, Newsfeed_Booking_Tour_PageUI.GENDER_ITEM_ON_ADULT_INFO,gender,"Trẻ em" , String.valueOf(i));
            // Enter address
            waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Trẻ em", String.valueOf(i), "ov405");
            sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,address,"Trẻ em",String.valueOf(i), "ov405");
        }
    }

    public void enterValueOfYoungChildInfo(WebDriver driver,int numberYoungChild, String fullname, String bithday, String gender, String address) {
        for(int i = 1; i<= numberYoungChild; i++){
            // Enter fullname
            waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Trẻ nhỏ", String.valueOf(i), "ov402");
            sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,fullname,"Trẻ nhỏ", String.valueOf(i),"ov402");
            // Enter birthday
            waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Trẻ nhỏ", String.valueOf(i), "od403");
            sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,bithday,"Trẻ nhỏ", String.valueOf(i), "od403");
            // Choose gender
            selectItemInCustomDropdown(driver, Newsfeed_Booking_Tour_PageUI.GENDER_DROPDOWN_ON_TRAVELLER, Newsfeed_Booking_Tour_PageUI.GENDER_ITEM_ON_ADULT_INFO,gender,"Trẻ nhỏ" , String.valueOf(i));
            // Enter address
            waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Trẻ nhỏ", String.valueOf(i),"ov405");
            sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,address,"Trẻ nhỏ", String.valueOf(i), "ov405");
        }
    }

    public void enterValueOfIfantInfo(WebDriver driver,int numberInfant, String fullname, String bithday, String gender, String address)  {
        for(int i = 1; i<= numberInfant; i++){
            // Enter fullname
            waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Em bé", String.valueOf(i), "ov402");
            sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO, fullname,"Em bé", String.valueOf(i), "ov402");
            // Enter birthday
            waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Em bé", String.valueOf(i), "od403");
            sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO, bithday,"Em bé", String.valueOf(i), "od403");
            // Choose gender
            selectItemInCustomDropdown(driver, Newsfeed_Booking_Tour_PageUI.GENDER_DROPDOWN_ON_TRAVELLER, Newsfeed_Booking_Tour_PageUI.GENDER_ITEM_ON_ADULT_INFO, gender,"Em bé" , String.valueOf(i));
            // Enter address
            waitElementToVisible(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Em bé", String.valueOf(i), "ov405");
            sendKeyToElement(driver, Newsfeed_Booking_Tour_PageUI.DYNAMIC_FIELD_ON_ADULT_INFO, address ,"Em bé", String.valueOf(i),"ov405");
        }
    }

    public Object getCurrencySymbolPriceDisplayOnSidebar() {
        return null;
    }

    public Object getCurrencySymbolServicePriceDisplayOnSidebar() {
        return null;
    }

    public Object getCurrencySymbolVATDisplayOnSidebar() {
        return null;
    }

    public Object getCurrencySymbolTotalPriceDisplayOnSidebar() {
        return null;
    }

    public Object getCurrencySymbolTourPriceDisplayOnDetailStep1() {
        return null;
    }

    public Object getCurrencySymbolAdultPriceDisplayOnPriceTable() {
        return null;
    }

    public Object getCurrencySymbolChildPriceDisplayOnPriceTable() {
        return null;
    }

    public Object getCurrencySymbolYoungChildPriceDisplayOnPriceTable() {
        return null;
    }

    public Object getCurrencySymbolBabyPriceDisplayOnPriceTable() {
        return null;
    }

    public Object getCurrencySymbolChildPriceDisplayOnSidebar() {
        return null;
    }

    public Object getCurrencySymbolAdultPriceDisplayOnSidebar() {
        return null;
    }

    public Object getCurrencySymbolYoungChildPriceDisplayOnSidebar() {
        return null;
    }

    public Object getCurrencySymbolBabyPriceDisplayOnSidebar() {
        return null;
    }

    public Object getCurSymbolTotalPriceOfAdultItemOnTravellerInfo() {
        return null;
    }

    public Object getCurSymbolTotalPriceOfChildItemOnTravellerInfo() {
        return null;
    }

    public Object getCurSymbolTotalPriceOfYoungChildItemOnTravellerInfo() {
        return null;
    }

    public Object getCurSymbolTotalPriceOfBabyItemOnTravellerInfo() {
        return null;
    }
}
