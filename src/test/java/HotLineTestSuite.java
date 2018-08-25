import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.HotlineMainPage;
import pageobject.HotlineSearchResultPage;
import pageobject.HotlineXiaomiRedmiNote5ViewPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class HotLineTestSuite {

    private WebDriver driver;

    @Before
    public void driverSetUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void verifyHotlineFilterFunctionality() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.get("https://hotline.ua/");
        final HotlineMainPage hotlineMainPage = new HotlineMainPage(driver);
        final HotlineSearchResultPage hotlineSearchResultPage = new HotlineSearchResultPage(driver);

        hotlineMainPage.mouseOverOnSamrtphonesMenuItem();
        hotlineMainPage.mouseOverOnsmartphonesMobilePhonesSmartwathesSubMunuItem();
        hotlineMainPage.clickOnsmartphonesMobilePhonesItem();
        hotlineSearchResultPage.clickOnSamsungCheckbox();
        hotlineSearchResultPage.waitMerchToBeDisplayed();
        hotlineSearchResultPage.clickOnsamsungGalaxyNote9Checkbox();
        hotlineSearchResultPage.clickOnsamsungGalaxyS8Checkbox();
        hotlineSearchResultPage.clickOnsamsungGalaxyS9Checkbox();
        hotlineSearchResultPage.clickOnCompareBtn();
        assertEquals(hotlineSearchResultPage.getNumberOfCompareItems(),
                "Смартфоны и мобильные телефоны: 3");
        hotlineSearchResultPage.clearListOfCompare();
        hotlineSearchResultPage.clickOnCompareBtn();
        assertEquals(hotlineSearchResultPage.getTextOfEmptyCompareBlock(),
                "Ваш список \"Сравнения\" пуст.");
    }

    @Test
    public void verifyMinAndMaxPriceOfXiaomiRedmiNote5() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.get("https://hotline.ua/");
        final HotlineMainPage hotlineMainPage = new HotlineMainPage(driver);
        final HotlineSearchResultPage hotlineSearchResultPage = new HotlineSearchResultPage(driver);
        final HotlineXiaomiRedmiNote5ViewPage
                hotlineXiaomiRedmiNote5ViewPage = new HotlineXiaomiRedmiNote5ViewPage(driver);
        hotlineMainPage.mouseOverOnSamrtphonesMenuItem();
        hotlineMainPage.mouseOverOnsmartphonesMobilePhonesSmartwathesSubMunuItem();
        hotlineMainPage.clickOnsmartphonesMobilePhonesItem();
        String xiaomiRedmiNote5MinPrice = hotlineSearchResultPage.getXiaomiRedmiNote5MinPrice();
        String xiaomiRedmiNote5MaxPrice = hotlineSearchResultPage.getXiaomiRedmiNote5MaxPrice();
        hotlineSearchResultPage.clickOnXiaomiRedmiNote5CompareBtn();
        assertTrue(hotlineXiaomiRedmiNote5ViewPage.getListOfPrices().contains(xiaomiRedmiNote5MinPrice));
        assertTrue(hotlineXiaomiRedmiNote5ViewPage.getListOfPrices().contains(xiaomiRedmiNote5MaxPrice));
//        System.out.println(xiaomiRedmiNote5MinPrice + " " + xiaomiRedmiNote5MaxPrice);
    }

    @After
    public void driverTeardown(){
        driver.close();
    }
}
