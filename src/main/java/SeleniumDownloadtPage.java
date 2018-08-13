import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumDownloadtPage {
    @FindBy(id = "firstHeading")
    private WebElement titleOfTheArticle;

    public SeleniumDownloadtPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getSearchResultTitle() {

        String searchResultTitle = titleOfTheArticle.getText();
        return searchResultTitle;
    }
}
