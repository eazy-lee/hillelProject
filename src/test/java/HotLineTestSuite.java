import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.HotlineMainPage;
import pageobject.HotlineSearchResultPage;

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
    public void verifyGoogleSearchFunctionality() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.get("https://hotline.ua/");
        final HotlineMainPage hotlineMainPage = new HotlineMainPage(driver);
        final HotlineSearchResultPage hotlineSearchResultPage = new HotlineSearchResultPage(driver);

        hotlineMainPage.mouseOverOnSamrtphonesMenuItem();
        hotlineMainPage.mouseOverOnsmartphonesMobilePhonesSmartwathesSubMunuItem();
        hotlineMainPage.clickFindButton();
        hotlineSearchResultPage.clickOnSamsungCheckbox();
        Thread.sleep(4000);
        hotlineSearchResultPage.clickOnsamsungGalaxyNote9Checkbox();
        hotlineSearchResultPage.clickOnsamsungGalaxyS8Checkbox();
        hotlineSearchResultPage.clickOnsamsungGalaxyS9Checkbox();
        hotlineSearchResultPage.clickOnCompareBtn();
        assertEquals(hotlineSearchResultPage.getNumberOfCompareItems(),
                "Смартфоны и мобильные телефоны: 3");
    }

    @After
    public void driverTeardown(){
        driver.close();
    }
}
