import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SeleniumDownloadPage {
    @FindBys(@FindBy(xpath = "//*[@id='mainContent']/table[1]/tbody//td[1]"))
            private List<WebElement> languagesList;

    public SeleniumDownloadPage (final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> getListOfLanguages() {
        final List<String> searchResultText = new ArrayList<String>();
        for (WebElement searchResultItem: languagesList) {
            final String text = searchResultItem.getText();
            searchResultText.add(text);
        }
        return searchResultText;
    }
}
