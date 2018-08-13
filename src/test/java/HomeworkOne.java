import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeworkOne {

    private WebDriver driver;

    @Before
    public void driverSetUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void verifyWikyTitle(){
        driver.get("https://ru.wikipedia.org/wiki/");
        final WikiMainPage mainPage = new WikiMainPage(driver);
        mainPage.typeSearchText("Java");
        final SeleniumDownloadtPage searchResultPage = mainPage.clickFindButton();

        Assert.assertEquals("Java", searchResultPage.getSearchResultTitle());
    }

    @Test
    public void verifySeleniumTable(){
        List <String> list = Arrays.asList(new String[] {"Java", "C#", "Ruby", "Python", "Javascript (Node)"});
        driver.get("https://www.seleniumhq.org/");
        final SeleniumMainPage mainPage = new SeleniumMainPage(driver);
        mainPage.clickDownloadTab();
        final SeleniumDownloadPage downloadPage = new SeleniumDownloadPage(driver);

        Assert.assertEquals(list, downloadPage.getListOfLanguages());
//        Assert.assertTrue(downloadPage.predefineListOfLanguages().equals(downloadPage.getListOfLanguages()));
    }

    @After
    public void driverTeardown(){
        driver.close();
    }
}
