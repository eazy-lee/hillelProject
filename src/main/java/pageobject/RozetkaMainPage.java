package pageobject;

import org.openqa.selenium.Beta;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class RozetkaMainPage {

    @FindBy(id = "2416")
    private WebElement notebookItem;

    @FindBy(xpath = "//div/div[2]/div/p/a")
    private WebElement tabletLink;

    @FindBy(xpath = "//li/ul/li[5]/a/span")
    private WebElement allTabletsLink;

    private WebDriver driver;

    public RozetkaMainPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnNotebookItem() {
        notebookItem.click();
    }

    public void clickOnTabletLink() {
        tabletLink.click();
    }

    public void clickOnAllTabletsLink() {
        allTabletsLink.click();
    }


}
