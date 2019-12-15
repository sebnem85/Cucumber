package stepDefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class Hooks {

    // This Hooks class(runs)=>>  setup method runs @Before senario  each scenario
    @Before  // annotations must come from cucumber.api.java  // it will run one time in the beginning before scenario stars
    public void setUp() {  // it means driver set up

        WebDriver driver = Driver.driverSetup("chrome");// we set up our driver as implicitly wait.
                                                                // it waits every element implicitly wait.
    }

    @After
    public void tearDown(Scenario scenario){ //  "after" scenario created to quit that browser // it only run one time after each steps done.
        if(scenario.isFailed()){  // it means;  if this scenario failed just take the screenshot
            final byte[] screenshot=((TakesScreenshot)Driver.driver).getScreenshotAs(OutputType.BYTES); //?? where did come from final and byte[]?
            scenario.embed(screenshot,"image.png");



        }
      //  Driver.closeDriver(); // or Driver.close(); those methods are just closed the driver.


    }
}
