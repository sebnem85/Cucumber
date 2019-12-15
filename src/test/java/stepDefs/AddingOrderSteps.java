package stepDefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.OrdersHomePage;
import pages.OrdersPage;

import java.util.List;
import java.util.Map;

public class AddingOrderSteps {

    OrdersHomePage ordersHomePage = new OrdersHomePage();
    OrdersPage ordersPage = new OrdersPage(); // I have to create an object out of my OrdersPage class
    int initialOrderCount;  // counting the order we should create an int value. It shows this much order I have

    @Then("^User clicks on Order$")
    public void user_clicks_on_Order() throws Throwable {

        initialOrderCount = ordersHomePage.orderRows.size();
        ordersHomePage.OrderButton.click();
    }

    @Then("^User creates new order$")
    public void user_creates_new_order(DataTable dataTable) throws Throwable {
        List<Map<String, Object>> listOfMaps = dataTable.asMaps(String.class, Object.class);
        // that means dataTable get all the datas from cucumber feature file and converted which
        // key of the map going to be String and value of the map going to be object.
        // inside the List creates map as an object -->  our dataTable variables converted as maps. String.class->keys, Object.class-->value
        Select select = new Select(ordersPage.productName); // ordersPage gives the webElement which is productName. So I have to chose one options from dropdown menu
        select.selectByVisibleText(listOfMaps.get(0).get("Product Name").toString());// get(0) it shows first index number.
        // it will convert the object value to the String
        ordersPage.productQuantity.sendKeys(listOfMaps.get(0).get("Quantity").toString());
        ordersPage.customerName.sendKeys(listOfMaps.get(0).get("Customer Name").toString());
        ordersPage.street.sendKeys(listOfMaps.get(0).get("Street").toString());
        ordersPage.city.sendKeys(listOfMaps.get(0).get("State").toString());
        ordersPage.zipCode.sendKeys(listOfMaps.get(0).get("Zip").toString());
        ordersPage.visaCardType.click();
        ordersPage.cardNr.sendKeys(listOfMaps.get(0).get("Card Nr").toString());
        ordersPage.expDate.sendKeys(listOfMaps.get(0).get("Expire Date").toString());
        Thread.sleep(5000);
        ordersPage.processButton.click();
        Thread.sleep(8000);

    }

    @Then("^User verifies Order \"([^\"]*)\" created$")
    public void user_verifies_Order_created(String isCondition) throws Throwable {
        ordersPage.ordersViewButton.click();
        Thread.sleep(10000);
        int afterOrderCreated = ordersHomePage.orderRows.size();//we should count again, how many rows we have.
        if (isCondition.equalsIgnoreCase("is")) { // we should provide first expected value and then actual value comes
            Assert.assertEquals("Initial order number is: " + initialOrderCount + "\n" +
                            "After you created order the row number is: " + afterOrderCreated,
                    initialOrderCount + 1, afterOrderCreated);//assertEquals is overloading method. we can provide two,three etc. parameters
        } else {
            Assert.assertEquals("Initial order number is: " + initialOrderCount + "\n" +
                            "After you created order the row number is: " + afterOrderCreated,
                    initialOrderCount, afterOrderCreated);
        }


    }



    @Then("^User deletes \"([^\"]*)\" from table$")
    public void user_deletes_from_table(String name) throws Throwable {

        for(int i=0;i<ordersHomePage.names.size();i++){
            if(ordersHomePage.names.get(i).getText().equalsIgnoreCase(name)){
                ordersHomePage.checkboxes.get(i).click();

            }

        }
        Thread.sleep(5000);
        ordersHomePage.deleteButton.click();
        Thread.sleep(3000);
    }

    @Then("^Validate that \"([^\"]*)\" is deleted$")
    public void validate_that_is_deleted(String name) throws Throwable {
        for(WebElement element: ordersHomePage.names){
            Assert.assertFalse(element.getText().equalsIgnoreCase(name));   // this condition has to be false because this element
                                                                           // should not be the part of the list anymore

        }

    }





}
//        System.out.println(listOfMaps.get(0).get("Quantity"));// Quantity is key value
//        System.out.println(listOfMaps.get(0).get("Street"));
//        System.out.println(listOfMaps.get(1).get("Quantity"));
//
//        System.out.println("Values of list: "+listOfMaps.size());
//        System.out.println("Values of Map: "+listOfMaps.get(0).size());
//

