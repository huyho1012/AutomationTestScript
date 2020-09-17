package Project.Newsfeed.Boooking;

import Interfaces.hahalolo_business.Tour.Management.TourCommonUI;
import Interfaces.hahalolo_newsfeed.Booking.BookingCommonUI;
import Interfaces.hahalolo_newsfeed.Booking.BookingTourUI;
import Project.Business.Tour.Management.TourCommon;
import org.openqa.selenium.WebDriver;

public class BoookingTour extends BookingCommon {
    WebDriver driver;
    public BoookingTour (WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkTourBookingStep1IsDisplay(){
        return checkElementDisplay(driver, BookingCommonUI.TITLE_BOOKING_STEP,"Thông tin chuyến đi");
    }

    public String getBasicPriceDisplayOnStep1() {
        waitElementToVisible(driver, BookingCommonUI.TITLE_BOOKING_STEP,"Thông tin chuyến đi");
        return getTextElement(driver, BookingTourUI.BASIC_PRICE_ON_DETAIL_STEP1);
    }

    public String getDepartureDateDisplayOnStep1() {
        waitElementToVisible(driver, BookingCommonUI.TITLE_BOOKING_STEP,"Thông tin chuyến đi");
        return getTextElement(driver, BookingTourUI.DEPARTURE_DATE_ON_DETAIL_STEP1);
    }

    public String getDeparturePlaceOnStep1() {
        waitElementToVisible(driver, BookingCommonUI.TITLE_BOOKING_STEP,"Thông tin chuyến đi");
        return getTextElement(driver, BookingTourUI.DEPARTURE_PLACE_ON_DETAIL_STEP1);
    }

    public String getDestinationPlaceDOnStep1() {
        waitElementToVisible(driver, BookingCommonUI.TITLE_BOOKING_STEP,"Thông tin chuyến đi");
        return getTextElement(driver, BookingTourUI.DESTINATION_ON_DETAIL_STEP1);
    }

    public String getValuePriceByTypeAge(WebDriver driver, String typeAge){
        waitElementToVisible(driver, BookingCommonUI.TITLE_BOOKING_STEP,"Thông tin chuyến đi");
        return getTextElement(driver, BookingTourUI.PRICE_OF_TYPE_AGE,typeAge);
    }


    public boolean checkTourBookingStep2IsDisplay(){
        return checkElementDisplay(driver, BookingCommonUI.TITLE_BOOKING_STEP,"Chi tiết khách du lịch");
    }

    public void choosePerTitleOfTourLeader() {
    }

    public String getDefaultDataOfLeaderTraveller(WebDriver driver, String namefield) {
        waitElementToVisible(driver, BookingCommonUI.TITLE_BOOKING_STEP,"Thông tin chuyến đi");
        return getTextElement(driver, BookingTourUI.DYNAMIC_FIELD_ON_LEADER_INFO,namefield);
    }

    public void enterDataToDynamicFieldOnTourLeader(WebDriver driver, String nameField, String valueData) {
        waitElementToVisible(driver, BookingCommonUI.TITLE_BOOKING_STEP,"Thông tin chuyến đi");
        waitElementToVisible(driver, BookingTourUI.DYNAMIC_FIELD_ON_LEADER_INFO,nameField);
        sendKeyToElement(driver, BookingTourUI.DYNAMIC_FIELD_ON_LEADER_INFO,valueData, nameField);
    }

    public void enterRequestNote(WebDriver driver,  String requestNote) {
        waitElementToVisible(driver, BookingCommonUI.TITLE_BOOKING_STEP,"Thông tin chuyến đi");
        waitElementToVisible(driver, BookingTourUI.REQUEST_NOTE_TEXTAREA);
        sendKeyToElement(driver, BookingTourUI.REQUEST_NOTE_TEXTAREA,requestNote);
    }

    public void chooseOptionImTourist() {
    }

    public void chooseNumberAdult(WebDriver driver, int numberAdult) {

        waitElementToVisible(driver, BookingTourUI.NUMBER_PER_BY_TYPE_AGE,String.valueOf(numberAdult),"");
        sendKeyToElement(driver, BookingTourUI.NUMBER_PER_BY_TYPE_AGE,String.valueOf(numberAdult),"");
    }

    public void chooseNumberChild(WebDriver driver, int numberChild) {
        if(checkElementDisplay(driver,BookingTourUI.DROPDOWN_CHOOSE_PERSON_BY_TYPE,"Trẻ em")) {
            waitElementToVisible(driver, BookingTourUI.NUMBER_PER_BY_TYPE_AGE,String.valueOf(numberChild),"Trẻ em");
            sendKeyToElement(driver, BookingTourUI.NUMBER_PER_BY_TYPE_AGE,String.valueOf(numberChild),"Trẻ em");
        }
    }

    public void chooseNumberYoungChild(WebDriver driver,int numberYoungChild) {
        if(checkElementDisplay(driver,BookingTourUI.DROPDOWN_CHOOSE_PERSON_BY_TYPE,"Trẻ em")) {
            waitElementToVisible(driver, BookingTourUI.NUMBER_PER_BY_TYPE_AGE, String.valueOf(numberYoungChild), "Trẻ nhỏ");
            sendKeyToElement(driver, BookingTourUI.NUMBER_PER_BY_TYPE_AGE, String.valueOf(numberYoungChild), "Trẻ nhỏ");
        }
    }

    public void chooseNumberOfInfant(WebDriver driver , int numberYoungChild) {
        if(checkElementDisplay(driver,BookingTourUI.DROPDOWN_CHOOSE_PERSON_BY_TYPE,"Em bé")) {
            waitElementToVisible(driver, BookingTourUI.NUMBER_PER_BY_TYPE_AGE, String.valueOf(numberYoungChild), "Em bé");
            sendKeyToElement(driver, BookingTourUI.NUMBER_PER_BY_TYPE_AGE, String.valueOf(numberYoungChild), "Em bé");
        }
    }

    public void clickToButtonContinueToStep3() {
    }

    public boolean checBookingTourStep3IsDisplay() {
        return true;
    }

    public void clickToButtonContinueToStep4() {
    }


    public void enterValueOfAdullInfo(WebDriver driver,int numberAdult, String fullname, String bithday, String gender, String address) {
        if(checkIsElementIsSelected(driver, BookingTourUI.CHECKBOX_TRAVEL_LEADER)){
            for(int i = 1; i<= numberAdult; i++){
                // Enter fullname
                waitElementToVisible(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Người lớn", "ov402", String.valueOf(i+1));
                sendKeyToElement(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,fullname,"Người lớn", "ov402", String.valueOf(i+1));
                // Enter birthday
                waitElementToVisible(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Người lớn", "od403", String.valueOf(i+1));
                sendKeyToElement(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,bithday,"Người lớn", "od403", String.valueOf(i+1));
                // Choose gender
                selectItemInCustomDropdown(driver, BookingTourUI.GENDER_DROPDOWN_ON_TRAVELLER, BookingTourUI.GENDER_ITEM_ON_ADULT_INFO, gender, "Người lớn", String.valueOf(i+1));
                // Enter address
                waitElementToVisible(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Người lớn", "ov405", String.valueOf(i+1));
                sendKeyToElement(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,address,"Người lớn", "ov405", String.valueOf(i+1));
            }
        }
        else {
            for(int i = 1; i<= numberAdult; i++){
                // Enter fullname
                waitElementToVisible(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Người lớn", "ov402", String.valueOf(i));
                sendKeyToElement(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,fullname,"Người lớn", "ov402",String.valueOf(i));
                // Enter birthday
                waitElementToVisible(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Người lớn", "od403", String.valueOf(i));
                sendKeyToElement(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,bithday,"Người lớn", "od403", String.valueOf(i));
                // Choose gender
                selectItemInCustomDropdown(driver, BookingTourUI.GENDER_DROPDOWN_ON_TRAVELLER, BookingTourUI.GENDER_ITEM_ON_ADULT_INFO,gender,"Người lớn", String.valueOf(i));
                // Enter address
                waitElementToVisible(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Người lớn", "ov405", String.valueOf(i));
                sendKeyToElement(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,address,"Người lớn", "ov405", String.valueOf(i));
            }

        }
    }

    public void enterValueOfChildInfo(WebDriver driver,int numberChild, String fullname, String bithday, String gender, String address) {
        for(int i = 1; i<= numberChild; i++){
            // Enter fullname
            waitElementToVisible(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Trẻ em", "ov402", String.valueOf(i));
            sendKeyToElement(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,fullname,"Trẻ em", "ov402",String.valueOf(i));
            // Enter birthday
            waitElementToVisible(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Trẻ em", "od403", String.valueOf(i));
            sendKeyToElement(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,bithday,"Trẻ em", "od403", String.valueOf(i));
            // Choose gender
            selectItemInCustomDropdown(driver, BookingTourUI.GENDER_DROPDOWN_ON_TRAVELLER, BookingTourUI.GENDER_ITEM_ON_ADULT_INFO,gender,"Trẻ em" , String.valueOf(i));
            // Enter address
            waitElementToVisible(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Trẻ em", "ov405", String.valueOf(i));
            sendKeyToElement(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,address,"Trẻ em", "ov405", String.valueOf(i));
        }
    }

    public void enterValueOfYoungChildInfo(WebDriver driver,int numberYoungChild, String fullname, String bithday, String gender, String address) {
        for(int i = 1; i<= numberYoungChild; i++){
            // Enter fullname
            waitElementToVisible(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Trẻ nhỏ", "ov402", String.valueOf(i));
            sendKeyToElement(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,fullname,"Trẻ nhỏ", "ov402",String.valueOf(i));
            // Enter birthday
            waitElementToVisible(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Trẻ nhỏ", "od403", String.valueOf(i));
            sendKeyToElement(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,bithday,"Trẻ nhỏ", "od403", String.valueOf(i));
            // Choose gender
            selectItemInCustomDropdown(driver, BookingTourUI.GENDER_DROPDOWN_ON_TRAVELLER, BookingTourUI.GENDER_ITEM_ON_ADULT_INFO,gender,"Trẻ nhỏ" , String.valueOf(i));
            // Enter address
            waitElementToVisible(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Trẻ nhỏ", "ov405", String.valueOf(i));
            sendKeyToElement(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,address,"Trẻ nhỏ", "ov405", String.valueOf(i));
        }
    }

    public void enterValueOfIfantInfo(WebDriver driver,int numberInfant, String fullname, String bithday, String gender, String address)  {
        for(int i = 1; i<= numberInfant; i++){
            // Enter fullname
            waitElementToVisible(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Em bé", "ov402", String.valueOf(i));
            sendKeyToElement(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,fullname,"Em bé", "ov402",String.valueOf(i));
            // Enter birthday
            waitElementToVisible(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Em bé", "od403", String.valueOf(i));
            sendKeyToElement(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,bithday,"Em bé", "od403", String.valueOf(i));
            // Choose gender
            selectItemInCustomDropdown(driver, BookingTourUI.GENDER_DROPDOWN_ON_TRAVELLER, BookingTourUI.GENDER_ITEM_ON_ADULT_INFO,gender,"Em bé" , String.valueOf(i));
            // Enter address
            waitElementToVisible(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,"Em bé", "ov405", String.valueOf(i));
            sendKeyToElement(driver, BookingTourUI.DYNAMIC_FIELD_ON_ADULT_INFO,address,"Em bé", "ov405", String.valueOf(i));
        }
    }
}
