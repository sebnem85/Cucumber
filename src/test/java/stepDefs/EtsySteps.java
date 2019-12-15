package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.EtsyHomePage;
import pages.EtsyResultPage;
import utilities.Configuration;
import utilities.Driver;

public class EtsySteps {

    EtsyHomePage etsyHomePage = new EtsyHomePage();// we create that object so we can access to search box WebElement
    EtsyResultPage etsyResultPage = new EtsyResultPage(); // we are gonna have actual result from WebPage

    //expected result stored uifeature page which is carpet
    @Given("^Navigate Etsy Homepage$")
    public void navigate_Etsy_Homepage() throws Throwable {
        Driver.driver.get(Configuration.getProperties("etsyUrl")); // we haver Driver utilities so we don`t need to create driver
        // driver takes the url address from configuration page.
    }

    @When("^User searches for \"([^\"]*)\"$")
    public void user_searches_for(String item) throws Throwable {  // don`t write any specific item name just write simply item that is it
        etsyHomePage.searchBox.sendKeys(item + Keys.ENTER);
    }

    @Then("^Validate search message have word \"([^\"]*)\"$") // this double quote means it is string
    public void validate_search_message_have_word(String item) throws Throwable {

        String actualSearchMessage = etsyResultPage.searchMessage.getText();

    }

    @When("^User clicks on \"([^\"]*)\"$")
    public void user_clicks_on(String department) throws Throwable {

        if (etsyHomePage.JeweleryA.getText().equalsIgnoreCase(department)) {
            etsyHomePage.JeweleryA.click();

        } else if (etsyHomePage.ClothesS.getText().equalsIgnoreCase(department)) {
            etsyHomePage.ClothesS.click();

        } else if (etsyHomePage.HomeL.getText().equalsIgnoreCase(department)) {
            etsyHomePage.HomeL.click();

        } else if (etsyHomePage.WeddingP.getText().equalsIgnoreCase(department)) {
            etsyHomePage.WeddingP.click();

        } else if (etsyHomePage.ToysE.getText().equalsIgnoreCase(department)) {
            etsyHomePage.ToysE.click();
        }
    }

    @Then("^User validate title \"([^\"]*)\"$")
    public void user_validate_title(String title) throws Throwable {
        String actualTitle = Driver.driver.getTitle();  // first we should find actual title and then we assert it.
        Assert.assertEquals(title, actualTitle);

    }

    @When("^User clicks on Free Shipping checkbox$")
    public void user_clicks_on_Free_Shipping_checkbox() throws Throwable {
        Thread.sleep(5000);
        etsyResultPage.freeShippingCheckbox.click();
        Thread.sleep(5000);

    }

    @Then("^Verify all results have\"([^\"]*)\" label$")
    public void verify_all_results_have_label(String label) throws Throwable {

        for (WebElement element : etsyResultPage.freeShippingLabels) {
            Assert.assertEquals(label, element.getText().trim());

        }
    }

    @When("^User click on Over Price checkbox$")
    public void user_click_on_Over_Price_checkbox() throws Throwable {
        WebDriverWait wait = new WebDriverWait(Driver.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(etsyResultPage.over1000checkbox));
        etsyResultPage.over1000checkbox.click();
    }

    @Then("^User verifies all items prices are over that price$")
    public void user_verifies_all_items_prices_are_over_that_price() throws Throwable {
        for (WebElement element : etsyResultPage.resultPage) {
            String number = element.getText().replace(",", "");
            System.out.println(number);
            if (!number.isEmpty()) {
                double price = Double.parseDouble(number);
                System.out.println(price);
                Assert.assertTrue(price >= 1000);


            }


        }
    }
}








