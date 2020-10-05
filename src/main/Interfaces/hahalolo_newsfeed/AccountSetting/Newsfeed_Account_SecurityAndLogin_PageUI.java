package Interfaces.hahalolo_newsfeed.AccountSetting;

public class Newsfeed_Account_SecurityAndLogin_PageUI {
    public static final String BUTTON_LOGOUT_ALL = "//a[contains(@data-bind,'logOutAllDevice')]";
    public static final String POPUP_CONFIRM_LOGOUT_ALL_SESSION = "//div[contains(@class,'modal__delete-common')]";
    public static final String BUTTON_CONFIRM_LOGOUT_ALL = "//div[contains(@class,'modal__delete-common')]//button[contains(@data-bind,'onConfirm')]";
    public static final String BUTTON_CANCEL_LOGOUT_ALL = "//div[contains(@class,'modal__delete-common')]//button[contains(@data-bind,'onCancel')]";

    public static final String ICON_CHANGE_PASSWORD = "//ul//i[contains(@class,'fa-edit')]";
    public static final String CURRENT_PASS = "//input[@name = 'currentPassword']";
    public static final String NEW_PASS = "//input[@name = 'newPassword']";
    public static final String CONFIRM_NEW_PASS = "//input[@name = 'reNewPassword']";

    public static final String LINK_FORGOT = "//a[contains(@data-bind,'userProfileVM.forgotpw')]";
    public static final String BUTTON_CONFIRM_CHANGE_PASS = "//button[contains(@data-bind, 'userProfileVM.onSavePassword')]";
    public static final String BUTTON_CANCEL_CHANGE_PASS = "//button[contains(@data-bind, 'userProfileVM.onCancelSavePwd')]";

    public static final String MESSAGE_OF_CURRENT_PASS = "//input[@name = 'currentPassword']/following-sibling::div[contains(@class, 'invalid-feedback')]";
    public static final String MESSAGE_OF_NEW_PASS = "//input[@name = 'newPassword']/following-sibling::div[contains(@class, 'invalid-feedback')]";
    public static final String MESSAGE_OF_CONFIRM_NEW_PASS = "//input[@name = 'reNewPassword']/following-sibling::div[contains(@class, 'invalid-feedback')]";
}
