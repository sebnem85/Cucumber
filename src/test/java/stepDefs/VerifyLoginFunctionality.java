package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.Configuration;
import utilities.Driver;

public class VerifyLoginFunctionality {

    WebDriver driver = Driver.driverSetup("chrome"); // it is static method it calls with the class name
    LoginPage loginPage = new LoginPage();

    @Given("^Navigate to login page$")
    public void navigate_to_login_page() throws Throwable {

        Driver.driver.get(Configuration.getProperties("browserUrl"));
        Thread.sleep(3000);

    }

    @Then("^User logs in with valid credentials username \"([^\"]*)\" password \"([^\"]*)\"$")
    public void user_logs_in_with_valid_credentials_username_password(String username, String password) throws Throwable {
        loginPage.username.sendKeys(username); // we provide the username and password from "VerifyLoginFunctionality" file and then we click the login button.
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();

    }

    @Then("^Verify user gets error message \"([^\"]*)\"$")  // As a first step; we have to inspect
    public void verify_user_gets_error_message(String errorMessage) throws Throwable { // we have to verify error msj.It comes from "VerifyLoginPage" if you rename it makes more sence
        // actualResult comes from website so we have to verify it.
        String actualResult = loginPage.errorMessage.getText();  // errorMessage is expected result
        Thread.sleep(3000);
        Assert.assertEquals(errorMessage, actualResult);

    }

}
