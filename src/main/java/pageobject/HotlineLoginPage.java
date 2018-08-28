package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobject.common.DefaultUrl;

@DefaultUrl(value = "https://www.hotline.ua/login")
public class HotlineLoginPage {

    @FindBy(xpath = "//input[contains(@type, 'email')]")
    private WebElement emailInput;

    @FindBy(xpath = "//input[contains(@type, 'password')]")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[contains(@type, 'submit')]")
    private WebElement submitBtn;

    private WebDriver driver;

    public HotlineLoginPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



}
