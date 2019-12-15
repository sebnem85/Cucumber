package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EtsyResultPage {
    WebDriver driver;

    public EtsyResultPage() {
        this.driver = Driver.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='display-inline strong wt-text-caption']") //it is search message
    public WebElement searchMessage;

    @FindBy(xpath = "//*[@id=\"search-filter-reset-form\"]/fieldset[2]/div/div[1]/div/a/label")
    public WebElement freeShippingCheckbox;

    @FindBy(xpath = "//span[@class='text-body-smaller no-wrap']")
    public List<WebElement> freeShippingLabels;

    @FindBy(xpath = "//a[@data-path='Over $1,000']")
    public WebElement over1000checkbox;

    @FindBy(xpath = "//ul[@class='responsive-listing-grid wt-grid wt-grid--block justify-content-flex-start pl-xs-0’]//span[@class=‘currency-value']\n")
    public List<WebElement> resultPage;


}
