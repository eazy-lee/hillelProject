import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumMainPage {

    @FindBy(id = "menu_download")
    private WebElement downloadTab;

    @FindBy(xpath = "//*[@id='mainContent']/table[1]/tbody//td[1]")
    private WebElement searchResult;

    private WebDriver driver;

    public SeleniumMainPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WikiSearchResultPage clickDownloadTab() {
        downloadTab.click();
        return new WikiSearchResultPage(driver);
    }
}
