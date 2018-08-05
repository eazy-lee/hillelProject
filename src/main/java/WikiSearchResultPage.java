import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiSearchResultPage {
    @FindBy(id = "firstHeading")
    private WebElement titleOfTheArticle;

    public WikiSearchResultPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getSearchResultTitle(){
        String searchResultTitle;
        searchResultTitle = titleOfTheArticle.getText();
        return searchResultTitle;
    }
}
