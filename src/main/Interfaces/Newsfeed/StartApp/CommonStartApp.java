package Interfaces.Newsfeed.StartApp;


import Common.HandleFunction.AbstractTest;
import Project.Shared.Login.LoginUI;
import org.openqa.selenium.WebDriver;

public class CommonStartApp extends AbstractTest {

    String content1= "Bạn thích";
    String content2= "đi du lịch?";
    String content3= "Bạn muốn tìm hiểu";
    String content4= "thông tin về những điểm đến?";
    String content5= "Hãy đăng nhập nhanh chóng chỉ với";
    String content6= "thao tác nhỏ để trải nghiệm và cảm nhận";
    String content7= "các tiện ích tuyệt vời của chúng tôi.";

    public boolean checkContentOfHaLoStartApp(WebDriver driver) {
        waitElementToVisible(driver, LoginUI.LOGIN_BUTTON);
        return getTextElement(driver, StartingCommonUI.NEWSFEED_HALO_CONTENT_1).equalsIgnoreCase(content1)
                && getTextElement(driver, StartingCommonUI.NEWSFEED_HALO_CONTENT_2).equalsIgnoreCase(content2)
                && getTextElement(driver, StartingCommonUI.NEWSFEED_HALO_CONTENT_3).equalsIgnoreCase(content3)
                && getTextElement(driver, StartingCommonUI.NEWSFEED_HALO_CONTENT_4).equalsIgnoreCase(content4)
                && getTextElement(driver, StartingCommonUI.NEWSFEED_HALO_CONTENT_5).equalsIgnoreCase(content5)
                && getTextElement(driver, StartingCommonUI.NEWSFEED_HALO_CONTENT_6).equalsIgnoreCase(content6)
                && getTextElement(driver, StartingCommonUI.NEWSFEED_HALO_CONTENT_7).equalsIgnoreCase(content7);
    }
    public boolean checkGooglePlayIconIsDisplay(WebDriver driver){
        waitElementToVisible(driver, LoginUI.LOGIN_BUTTON);
        return checkElementDisplay(driver, StartingCommonUI.GOOGLE_PLAY);
    }
    public boolean checkAppStoreIconIsDisplay(WebDriver driver){
        waitElementToVisible(driver, LoginUI.LOGIN_BUTTON);
        return checkElementDisplay(driver, StartingCommonUI.APP_STORE);
    }
    public void clickToAppStoreLink(WebDriver driver){
        waitForElementClickable(driver, StartingCommonUI.APP_STORE);
        clickToElement(driver, StartingCommonUI.APP_STORE);
    }
    public void clickToCHPlayLink(WebDriver driver){
        waitForElementClickable(driver, StartingCommonUI.GOOGLE_PLAY);
        clickToElement(driver, StartingCommonUI.GOOGLE_PLAY);
    }
}
