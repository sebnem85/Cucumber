package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class automationPage {

    WebDriver driver;

    public automationPage() {  // we must always create a constractor
        this.driver = Driver.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInButton;
    @FindBy(id="email_create")
    public WebElement email;
    @FindBy(id="SubmitCreate")
    public WebElement createAccount;
    @FindBy(xpath="//input[@id='customer_firstname']")
    public WebElement firstName;
    @FindBy(xpath="//input[@id='customer_lastname']")
    public WebElement lastName;
//    @FindBy(xpath = "//input[@id='email']")
//    public WebElement eMail;
    @FindBy(xpath="//input[@id='passwd']")
    public WebElement password;








}
