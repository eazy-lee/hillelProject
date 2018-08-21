package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = "//div[contains(@data-dropdown-target, 'compare')]")
    private WebElement compareBtn;

    @FindBy(xpath = "//a[contains(@href, 'cmp')]")
    private WebElement numberOfCompareItems;

    private WebDriver driver;
    private WebDriverWait webDriverWait;
//    private Actions actions;

    public HotlineSearchResultPage(final WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        actions = new Actions(driver);
    }

    public void clickOnSamsungCheckbox() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(samsungCheckbox));
        samsungCheckbox.click();
    }

    public void clickOnsamsungGalaxyNote9Checkbox() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", samsungGalaxyNote9Checkbox);
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
        String searchResultTitle = numberOfCompareItems.getText();
        return searchResultTitle;
    }


//    public void clickOnCompareBtnOnFirstThreeItems() {
//
//        for (WebElement elements : compareCheckbox) {
//            elements.getSize();
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].click();", elements);
//        }
//    }
}
