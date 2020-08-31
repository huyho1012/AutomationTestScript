package Common.HandleFunction;

import com.google.inject.internal.cglib.core.$Local;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {
    private Actions action;
    private WebDriverWait explicitWait;
    private Alert alert;
    private Select select;
    private WebElement element;
    private List<WebElement> elements;
    private JavascriptExecutor jsExecutor;
    public void openURL(WebDriver driver, String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }
    public String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }
    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }
    public void clickBackToPage(WebDriver driver) {
        driver.navigate().back();
    }
    public void clickForwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }
    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }
    public void acceptAlert(WebDriver driver) {
        alertPresence(driver);
        driver.switchTo().alert();
        alert.accept();
    }
    public void cancelAlert(WebDriver driver) {
        alertPresence(driver);
        driver.switchTo().alert();
        alert.dismiss();
    }
    public String getTextAlert(WebDriver driver) {
        alertPresence(driver);
        driver.switchTo().alert();
        return alert.getText();
    }
    public void sendKeyToAlert(WebDriver driver, String valueName) {
        alertPresence(driver);
        driver.switchTo().alert();
        alert.sendKeys(valueName);
    }
    public void alertPresence(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }
    public void switchWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindow = driver.getWindowHandles();
        for (String current : allWindow) {
            if (current.equals(parentID)) {
                driver.switchTo().window(current);
                break;
            }
        }
    }
    public void switchWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindow = driver.getWindowHandles();
        for (String currentTab : allWindow) {
            driver.switchTo().window(currentTab);
            String titleCurrentTab = getPageTitle(driver);
            if (titleCurrentTab.equals(title)) {
                break;
            }
        }
    }
    public void closeAllTabWithoutParentWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindow = driver.getWindowHandles();
        for (String currentTab : allWindow) {
            if (!currentTab.equals(parentID)) {
                driver.switchTo().window(currentTab);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }
    public WebElement findElement(WebDriver driver, String locator) {
        return driver.findElement(By.xpath(locator));
    }
    public List<WebElement> findElements(WebDriver driver, String locator) {
        return driver.findElements(By.xpath(locator));
    }
    public void clickToElement(WebDriver driver, String locator) {
        element = findElement(driver, locator);
    }
    public void sendKeyToElement(WebDriver driver, String locator, String valueName) {
        element = findElement(driver, locator);
        element.clear();
        element.sendKeys(valueName);
    }
    public String getTextElement(WebDriver driver, String locator) {
        element = findElement(driver, locator);
        return element.getText();
    }
    public String getAttributeValue(WebDriver driver, String locator, String valueAttribute) {
        element = findElement(driver, locator);
        return element.getAttribute(valueAttribute);
    }
    public boolean checkIsElementIsDisplay(WebDriver driver, String locator){
        element = findElement(driver, locator);
        return  element.isDisplayed();
    }
    public boolean checkIsElementIsEnable(WebDriver driver, String locator){
        element = findElement(driver, locator);
        return  element.isDisplayed();
    }
    public boolean checkIsElementIsSelected(WebDriver driver, String locator){
        element = findElement(driver, locator);
        return  element.isSelected();
    }
    public void selectItemInDropdownByValue(WebDriver driver, String dropdown, String value) {
        element = findElement(driver, dropdown);
        select = new Select(element);
        select.selectByValue(value);
    }
    public void selectItemInDropdownByText(WebDriver driver, String dropdown, String textValue) {
        element = findElement(driver, dropdown);
        select = new Select(element);
        select.selectByVisibleText(textValue);
    }
    public void deselectItemInDropdownByValue(WebDriver driver, String dropdown, String value) {
        element = findElement(driver, dropdown);
        select = new Select(element);
        select.deselectByValue(value);
    }
    public void deselectItemInDropdownByText(WebDriver driver, String dropdown, String textValue) {
        element = findElement(driver, dropdown);
        select = new Select(element);
        select.deselectByVisibleText(textValue);
    }
    public void deselectAllItemOnDropdown(WebDriver driver, String dropdown) {
        element = findElement(driver, dropdown);
        select = new Select(element);
        select.deselectAll();
    }
    public String getFirstSelectedItemOnDropdown(WebDriver driver, String dropdown) {
        element = findElement(driver, dropdown);
        select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }
    public boolean checkDropdownIsMultiple(WebDriver driver, String drodown) {
        element = findElement(driver, drodown);
        select = new Select(element);
        return select.isMultiple();
    }
    public void selectItemInCustomDropdown(WebDriver driver, String customDropdown, String itemOnDropdown, String expectedValue){
        waitForElementClickable(driver, customDropdown);
        clickToElement(driver,customDropdown);
        explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(itemOnDropdown)));
        elements = findElements(driver,itemOnDropdown);
        for(WebElement item: elements){
            if(item.getText().contains(expectedValue)){
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);",item);
                item.click();
                break;
            }
        }
    }
    public void checkItemOnCheckBox(WebDriver driver, String locator){
        element = findElement(driver, locator);
        if(!element.isSelected()){
           element.click();
        }
    }
    public void uncheckItemOnCheckBox(WebDriver driver, String locator){
        element = findElement(driver, locator);
        if(element.isSelected()) {
            element.click();
        }
    }
    public int countElementNumber(WebDriver driver, String locator){
        elements = findElements(driver,locator);
        return elements.size();
    }
    public void switchToIframeOrFrame(WebDriver driver, String locator){
        element = findElement(driver, locator);
        driver.switchTo().frame(element);
    }
    public void switchToDefaultContent(WebDriver driver){
       driver.switchTo().defaultContent();
    }

    public void doubleClickToElement(WebDriver driver, String locator){
        element = findElement(driver,locator);
        action = new Actions(driver);
        action.doubleClick(element).perform();
    }

    public void hoverToElement(WebDriver driver, String locator){
        element = findElement(driver,locator);
        action = new Actions(driver);
        action.moveToElement(element).perform();
    }
    public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key){
        element = findElement(driver, locator);
        action = new Actions(driver);
        action.sendKeys(element,key);
    }
    public void rightClickToElement(WebDriver driver, String locator){
        element = findElement(driver,locator);
        action = new Actions(driver);
        action.contextClick(element).perform();
    }
    public Object executeForBrowser(WebDriver driver, String javaSript) {
        jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(javaSript);
    }
    public boolean verifyTextInInnerText(WebDriver driver,String textExpected) {
        jsExecutor = (JavascriptExecutor)driver;
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }
    public void negativeToURLByJS(WebDriver driver, String urlPage){
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("window.location = '" + urlPage + "'");
    }
    public void scrollToBottomPage() {
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    public void highlightElement(WebDriver driver, String locator) {
        element = findElement(driver,locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 5px solid red; border-style: dashed;");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }
    public void clickToElementByJS(WebDriver driver, String locator){
        element = findElement(driver,locator);
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].click();",element);
    }
    public void scrollIntoElementByJS(WebDriver driver, String locator){
        element = findElement(driver,locator);
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    public void sendKeyToElementByJS(WebDriver driver, String locator, String value){
        element = findElement(driver,locator);
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value','"+value+"')",element);
    }
    public void removeAttributeOfElementByJS(WebDriver driver, String locator, String attributeName){
        element = findElement(driver,locator);
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('"+attributeName+"')",element);
    }
    public void waitElementToVisible(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
    public void waitForElementToPresence(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }
    public void waitForElementClickable(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }
    public void waitForElementInvisible(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

}



