package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeLoginPage {
    WebDriver driver;

    public OrangeLoginPage() {

        this.driver = Driver.driverSetup("chrome");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "txtUsername")
    public WebElement loginField;

    @FindBy(id = "txtPassword")
    public WebElement passwordField;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;


}

