package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.AwsCalcHomepage;
import utilities.Configuration;
import utilities.Driver;
import utilities.ExcelUtils;

public class AwsCalculatorSteps {

    AwsCalcHomepage awsPage = new AwsCalcHomepage();

    @Given("^user Navigate to AWS Calculator Homepage$")
    public void user_Navigate_to_AWS_Calculator_Homepage() throws Throwable {

        Driver.driver.get(Configuration.getProperties("awsUrl"));

    }

    @When("^User adds (\\d+) EC(\\d+) Instances$")  // EC comes from feature file that EC2
    public void user_adds_EC_Instances(int numberOfInstances, int arg2) throws Throwable {

        awsPage.ec2InstanceAddButton.click();
        Driver.driver.findElement(By.xpath("(//*[@class='cell firstCell\'])[3]")).click();
        Thread.sleep(5000);


    }

    @When("^user adds (\\d+) EC(\\d+) Dedicated Hosts$")
    public void user_adds_EC_Dedicated_Hosts(int arg1, int arg2) throws Throwable {
        Driver.driver.findElement(By.xpath("(//*[@class='cell firstCell'])[6]")).click();
        Driver.driver.findElement(By.xpath("(//*[@class='cell firstCell'])[7]")).click();
        Thread.sleep(5000);


    }

    @Then("^Total estimated cost has to match with prices on \"([^\"]*)\" \"([^\"]*)\" excel file$")
    public void total_estimated_cost_has_to_match_with_prices_on_excel_file(String excelName, String sheetName) throws Throwable {

        awsPage.estimateOfBillPart.click();
        Thread.sleep(3000);
        String totalActualAmount = awsPage.totalAmount.getAttribute("value");
        System.out.println(totalActualAmount);

        ExcelUtils.openExcelFile(excelName, sheetName);
        String ec2Price = ExcelUtils.getValue(1, 1);
        double calcEC2Price = Double.parseDouble(ec2Price) * 2;
        String ec2Hosts = ExcelUtils.getValue(2, 1);
        double calcEC2Hosts = Double.parseDouble(ec2Hosts) * 2;
        double expectedTotalAmount = calcEC2Price + calcEC2Hosts;

        Assert.assertEquals(expectedTotalAmount, Double.parseDouble(totalActualAmount), +1);






    }

}
