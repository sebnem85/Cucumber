package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AwsCalcHomepage {

    WebDriver driver;

    public AwsCalcHomepage() {
        driver = Driver.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//*[@class='cell firstCell\'])[2]")
    public WebElement ec2InstanceAddButton;

    @FindBy(xpath = "//*[@class='billLabel']")
    public WebElement estimateOfBillPart;

    @FindBy(xpath = "(//input[@class='gwt-TextBox gwt-TextBox-readonly'])[4119]")
    public WebElement totalAmount;


    // GET means --> REQUEST SOME INFORMATION.         IT WILL GET THE URL
    // post
    // pull
    // delete
    // Status code -> if API successfully return the data status code gonna be something ... if failed status code 404,400 etc.
    // Status code -> 500 ,100,300 etc.



}
