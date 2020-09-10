package Interfaces.Shared;

public class LOCATION_PLACE_MODEL {
    public static final String TITLE_FORM = "//div[contains(@class, 'js-place-modal')]//h5[text() ='Chọn vị trí của bạn']";
    public static final String EXPECTED_LOCATION = "//h6/following-sibling::div[text()= '%s']";
    public static final String ADD_LOCATION_BUTTON = "//div[contains(@class, 'js-place-modal')]//button[text() ='Thêm địa điểm']";
    public static final String MAP_CONTENT = "//div[contains(@class,'js-map-content')]";
}
