package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.OrangeLoginPage;
import pages.OrangeMainPage;
import utilities.Configuration;
import utilities.Driver;

public class ChangePassword {

    OrangeLoginPage orangeLoginPage = new OrangeLoginPage();
    OrangeMainPage orangeMainPage = new OrangeMainPage();

    @Given("^Navigate OrangeHRM Homepage$")
    public void navigate_OrangeHRM_Homepage() throws Throwable {
        Driver.driver.get(Configuration.getProperties("OrangePageUrl"));
    }

    @Then("^User provides login\"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_provides_login_and_password(String login, String password) throws Throwable {

        orangeLoginPage.loginField.sendKeys(login);
        orangeLoginPage.passwordField.sendKeys(password);
        Thread.sleep(3000);
        orangeLoginPage.loginButton.click();
    }

    @Then("^Change password for Fiona Grace$")
    public void change_password_for_Fiona_Grace() throws Throwable {

        orangeMainPage.adminButton.click();


        Thread.sleep(5000);
        orangeMainPage.fionaGraceButton.click();
        orangeMainPage.editButton.click();
        orangeMainPage.changePasswordButton.click();
        //orangeMainPage.savebutton.click();
        orangeMainPage.newPasswordField.sendKeys("abcd1234");
        orangeMainPage.confirmPasswordField.sendKeys("abcd1234");
        orangeMainPage.editButton.click();


    }

    @Then("^Verify it is changed by signing in again$")
    public void verify_it_is_changed_by_signing_in_again() throws Throwable {

        orangeMainPage.welcomePage.click();
        Thread.sleep(2000);
        orangeMainPage.logoutButton.click();
        Thread.sleep(2000);
        orangeLoginPage.loginField.sendKeys("fiona.grace");
        orangeLoginPage.passwordField.sendKeys("abcd1234");
        orangeLoginPage.loginButton.click();
        String actual = orangeMainPage.welcomePage.getText();
        String expected = "Welcome Fiona";
        Assert.assertEquals(expected,actual);

    }

}
