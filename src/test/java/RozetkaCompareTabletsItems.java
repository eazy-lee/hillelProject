import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.RozetkaMainPage;
import pageobject.RozetkaSearchResultPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RozetkaCompareTabletsItems {

    private WebDriver driver;

    @Before
    public void driverSetUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void testOne() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://rozetka.com.ua/");
        final RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(driver);
        final RozetkaSearchResultPage rozetkaSearchResultPage = new RozetkaSearchResultPage(driver);
        rozetkaMainPage.clickOnNotebookItem();
        rozetkaMainPage.clickOnTabletLink();
        rozetkaMainPage.clickOnAllTabletsLink();
        rozetkaSearchResultPage.getSearchResults();
//        System.out.println(rozetkaSearchResultPage.getSearchResults());
        rozetkaSearchResultPage.clickSamsungCheckbox();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("g-rating-reviews")));
        final List<String> searchResultText = rozetkaSearchResultPage.getSearchResults();
        for (String text : searchResultText) {
            Assert.assertTrue(text.contains("Samsung"));
//            System.out.println(text);
        }
    }

//    @Test
//    public void test() throws InterruptedException {
//        driver.get("https://rozetka.com.ua/");
//        final pageobject.RozetkaMainPage rozetka = new pageobject.RozetkaMainPage(driver);
//        rozetka.clickOnNotebookItem();
//        rozetka.clickOnTabletLink();
//        rozetka.clickOnAllTabletsLink();
//        Thread.sleep(1000);
//        rozetka.addFirstTabletToCompareList();
//        rozetka.addSecondTabletToCompareList();
//        rozetka.clickOnCompareBtn();
//
//        Assert.assertEquals(rozetka.getTextOfFeaturesOfTheFirstSamsung(),
//                            rozetka.getTextOfFeaturesOfTheSecondSamsung());
//        System.out.println("first " + rozetka.getTextOfFeaturesOfTheFirstSamsung());
//        System.out.println("second " + rozetka.getTextOfFeaturesOfTheSecondSamsung());
//    }

    @After
    public void driverTeardown(){
        driver.close();
    }
}
