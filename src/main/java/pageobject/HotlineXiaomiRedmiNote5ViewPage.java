package pageobject;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.ws.wsaddressing.W3CEndpointReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HotlineXiaomiRedmiNote5ViewPage {

    @FindBys
            (@FindBy(xpath = "//div[contains(@class, 'price-box row')]//span[contains(@class, 'value')]"))
    private List<WebElement> listOfPrices;

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public HotlineXiaomiRedmiNote5ViewPage(final WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        actions = new Actions(driver);
    }

    public List<String> getListOfPrices() {
        final List<String> searchResultText = new ArrayList<String>();
        for (WebElement prices : listOfPrices) {
            final String text = prices.getText();
            searchResultText.add(text);
        } return searchResultText;
    }
}
