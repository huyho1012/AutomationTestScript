package Interfaces.Wallet;

public class WalletOverviewUI {
    public static final String TITLE_OVERVIEW_WALLET = "";
    public static final String BUTTON_CREATE_BUSINESS_PAYMENT_ACCOUNT = "";
    public static final String PAYMENT_ACCOUNT_NAME_FIELD = "//input[@name = 'walletName']";
    public static final String CURRENCY_DROPDOWN = "//select[@name = 'busCurrency']/following-sibling::div//input";
    public static final String CURRENCY_ITEM = "//select[@name = 'busCurrency']/following-sibling::div[contains(@class,'selectize-control')]//div[@class='option']";
    public static final String FINISH_BUTTON = "//buton[contains(@data-bind,'onCreateWallet')]";
}
