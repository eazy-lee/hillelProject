package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HotlineMainPage {

    @FindBy(xpath = "//li[contains(@class, 'mobile')]")
    private WebElement smartphonesMobilePhonesMenuItem;

    @FindBy(xpath = "//li[contains(@data-menu-id, '1697')]")
    private WebElement smartphonesMobilePhonesSmartwathesSubMunuItem;

    @FindBy(xpath = "//a[contains(@class, 'mobilnye-telefony-i-smartfony')]")
    private WebElement smartphonesMobilePhonesItem;

    private Actions actions;
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public HotlineMainPage(final WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }

    public void mouseOverOnSamrtphonesMenuItem() {
        actions.moveToElement(smartphonesMobilePhonesMenuItem).build().perform();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(smartphonesMobilePhonesSmartwathesSubMunuItem));
    }

    public void mouseOverOnsmartphonesMobilePhonesSmartwathesSubMunuItem() {
        actions.moveToElement(smartphonesMobilePhonesSmartwathesSubMunuItem).build().perform();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(smartphonesMobilePhonesItem));
    }

    public HotlineSearchResultPage clickOnsmartphonesMobilePhonesItem() {
        smartphonesMobilePhonesItem.click();
        return new HotlineSearchResultPage(driver);
    }

//    public void clickTest() {
//        smartphonesMobilePhonesItem.click();
//    }

}
