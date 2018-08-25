package pageobject;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HotlineSearchResultPage {

    @FindBy(xpath = "(//a[contains(@data-eventlabel, 'Samsung')])[1]")
    private WebElement samsungCheckbox;

//    @FindBy(xpath = "//ul[contains(@class, 'products-list cell-list')]//i[contains(@class, 'check')]")
//    private WebElement compareCheckbox;

    @FindBys
            (@FindBy(xpath = "//ul[contains(@class, 'products-list cell-list')]//i[contains(@class, 'check')]"))
    private List<WebElement> compareCheckbox;

    @FindBy(xpath = "(//label[contains(@class, 'checkbox-compare')])[1]")
    private WebElement samsungGalaxyNote9Checkbox;

    @FindBy(xpath = "(//label[contains(@class, 'checkbox-compare')])[2]")
    private WebElement samsungGalaxyS8Checkbox;

    @FindBy(xpath = "(//label[contains(@class, 'checkbox-compare')])[3]")
    private WebElement samsungGalaxyS9Checkbox;

    @FindBy(xpath = "//li[contains(@class, 'product-item')]//a[contains(text(), 'Xiaomi Redmi Note 5 4/64GB Black')]")
    private WebElement xiaomiRedmiNote5;

    @FindBy(xpath = "//div[contains(@data-dropdown-target, 'compare')]")
    private WebElement compareBtn;

    @FindBy(xpath = "//a[contains(@href, 'cmp')]")
    private WebElement numberOfCompareItems;

    @FindBy (xpath = "//a[contains(text() ,'Очистить список')]")
    private WebElement clearListOfCompareBtn;

    @FindBy (xpath = "//div[contains(@data-lazy-content, 'compare')]//p")
    private WebElement textOfEmptyCompareBlock;

    @FindBy(xpath = "//li[contains(@class, 'product-item')]//a[contains(text(), 'Xiaomi Redmi Note 5 4/64GB Black')]" +
            "//..//..//..//..//div[contains(@class, 'item-price stick-bottom')]//a[contains(@class, 'btn-orange')]")
    private WebElement xiaomiRedmiNote5CompareBtn;

    @FindBy(xpath = "//li[contains(@class, 'product-item')]//a[contains(text(), 'Xiaomi Redmi Note 5 4/64GB Black')]" +
            "//..//..//..//..//div[contains(@class, 'item-price stick-bottom')]//div[2]")
    private WebElement xiaomiRedmiNote5MinMaxPrice;

    @FindBy(xpath = "//span[@class='cell-md-none']")
    private WebElement filterTextItem;

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public HotlineSearchResultPage(final WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickOnSamsungCheckbox() {
        webDriverWait.until(ExpectedConditions.visibilityOf(samsungCheckbox));
        samsungCheckbox.click();
    }

    public void clickOnsamsungGalaxyNote9Checkbox() {
        samsungGalaxyNote9Checkbox.click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", samsungGalaxyNote9Checkbox);
    }

    public void clickOnsamsungGalaxyS8Checkbox() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", samsungGalaxyS8Checkbox);
    }

    public void clickOnsamsungGalaxyS9Checkbox() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", samsungGalaxyS9Checkbox);
    }

    public void clickOnCompareBtn() {
        compareBtn.click();
    }

    public String getNumberOfCompareItems() {
        return numberOfCompareItems.getText();
    }

    public void clearListOfCompare() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clearListOfCompareBtn);
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(clearListOfCompareBtn));
//        clearListOfCompareBtn.click();
    }

    public String getTextOfEmptyCompareBlock() {
        return textOfEmptyCompareBlock.getText();
    }

    public String getXiaomiRedmiNote5MinPrice() {
        String minPrice = xiaomiRedmiNote5MinMaxPrice.getText();
        return StringUtils.substringBeforeLast(minPrice, " – ");
    }

    public String getXiaomiRedmiNote5MaxPrice() {
        String maxPrice = xiaomiRedmiNote5MinMaxPrice.getText();
        return StringUtils.substringBetween(maxPrice," – "," грн");
    }

    public HotlineXiaomiRedmiNote5ViewPage clickOnXiaomiRedmiNote5CompareBtn() {
        xiaomiRedmiNote5CompareBtn.click();
        return new HotlineXiaomiRedmiNote5ViewPage(driver);
    }

    public void waitMerchToBeDisplayed() {
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(filterTextItem, "Отобрано"));
    }
}
