package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class OrangeMainPage {
    WebDriver driver;

    public OrangeMainPage() {

        this.driver = Driver.driverSetup("chrome");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "menu_admin_viewAdminModule")
    public WebElement adminButton;

//    @FindBy(xpath = "//a[@href='saveSystemUser?userId=6']")
    @FindBy(xpath = "//a[.='fiona.grace']")
    public WebElement fionaGraceButton;

    @FindBy(id = "btnSave")
    public WebElement editButton;

    @FindBy(id = "systemUser_chkChangePassword")
    public WebElement changePasswordButton;

    @FindBy(id = "systemUser_password")
    public WebElement newPasswordField;

    @FindBy(id = "systemUser_confirmPassword")
    public WebElement confirmPasswordField;

//    @FindBy(id = "btnSave")
//     public  WebElement savebutton;

    @FindBy(id= "welcome")
    public WebElement welcomePage;

//    @FindBy(xpath = "//*[@id='welcome-menu']/ul/li[2]/a")
    @FindBy(xpath = "//a[@href='/index.php/auth/logout']")
    public WebElement logoutButton;


}
