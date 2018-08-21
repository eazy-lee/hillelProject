package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class RozetkaSearchResultPage {
    @FindBy(xpath = "//*[@id='catalog_goods_block']/div/div[14]/div[1]/div/div[1]/div/div[6]/ul/li[2]")
    private WebElement firstSamsungToCompare;

    @FindBy(xpath = "//*[@id='catalog_goods_block']/div/div[19]/div[1]/div/div/div[2]/div[6]/ul/li[2]")
    private WebElement secondSamsungToCompare;

    @FindBy(id = "comparison")
    private WebElement comparisonBtn;

    @FindBy(xpath = "//div[4]/a/span")
    private WebElement compareThisProductsBtn;

    @FindBy(xpath = "//div[2]/div[2]/div/div/div/span")
    private WebElement firstSamsungTypeOfScreen;

    @FindBy(xpath = "//div[2]/div[3]/div/div/div/span")
    private WebElement secondSamsungTypeOfScreen;

    @FindBy(xpath = "//div[3]/div[2]/div/div/div/span")
    private WebElement firstSamsungDiagonal;

    @FindBy(xpath = "//div[3]/div[3]/div/div/div/span")
    private WebElement secondSamsungDiagonal;

    @FindBy(xpath = "//div[4]/div[2]/div/div/div/span")
    private WebElement firstSamsungRam;

    @FindBy(xpath = "//div[4]/div[3]/div/div/div")
    private WebElement secondSamsungRam;

    @FindBy(xpath = "//*[@id='filter_producer_12']/label/a/span")
    private WebElement checkboxSanmsung;

    @FindBys(@FindBy(xpath = "//div[contains(@class, 'g-i-tile-i-title')]"))
    private List<WebElement> searchResult;

    private WebDriver driver;

    public RozetkaSearchResultPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addFirstTabletToCompareList() {
        firstSamsungToCompare.click();
    }

    public void addSecondTabletToCompareList() {
        secondSamsungToCompare.click();
    }

    public void clickOnCompareBtn() {
        comparisonBtn.click();
    }

    public void clickSamsungCheckbox() {
        checkboxSanmsung.click();
    }

    public List<String> getSearchResults() {
        final List<String> searchResultText = new ArrayList<String>();
        for(final WebElement searchResultItem : searchResult) {
            final String text = searchResultItem.getText();
            searchResultText.add(text);
        }
        return searchResultText;
    }

    public List<String> getTextOfFeaturesOfTheFirstSamsung() {
        final List<String> listOfFeaturesInFirstSamsung = new ArrayList<String>();
        listOfFeaturesInFirstSamsung.add(firstSamsungTypeOfScreen.getText());
        listOfFeaturesInFirstSamsung.add(firstSamsungDiagonal.getText());
        listOfFeaturesInFirstSamsung.add(firstSamsungRam.getText());
        return listOfFeaturesInFirstSamsung;
    }

    public List<String> getTextOfFeaturesOfTheSecondSamsung() {
        final List<String> listOfFeaturesInSecondSamsung = new ArrayList<String>();
        listOfFeaturesInSecondSamsung.add(secondSamsungTypeOfScreen.getText());
        listOfFeaturesInSecondSamsung.add(secondSamsungDiagonal.getText());
        listOfFeaturesInSecondSamsung.add(secondSamsungRam.getText());
        return listOfFeaturesInSecondSamsung;
    }
}
