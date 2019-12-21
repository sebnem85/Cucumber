package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber; // cucumber junit dependency imported
import org.junit.runner.RunWith; // this file is gonna run with junit.

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberHTML-report", "pretty", "json:target/cucumber.json"},
        features ={"src/test/resources/uiFeature","src/test/resources/dbFeatures"},
        glue = "stepDefs",
        dryRun = false,
        tags = {"@TECTC-110"}   //{"@ui","@smokeTest"}//"@TECTC-1015"
)

public class UiTestRunner {

}

//  we have to provide the pass under this package features gonna go read all the feature files and it will find all the steps so then
// it needs code all the steps. glue has all the codes for the steps which calls stepDefs class
// If dryrun is false, everystep checks and runs.
// if we put dryrun as true; it is not runnig the steps but it is ignoring the steps.So it doesn`t run just check it. It checks all the steps implementing with codes.
//if some steps don`t implement it, it gives us the definition in console.

// false means; go to uiFeauture folder and look that feature files and get those steps
// from "stepDefs" package and look those step`s implementation and run them.
// dryRun=false --->> it checks the steps and run them.
// dryRun=true--->> if it is true, it is only check the steps, it is implemented or not
//  that annotation means; runner class go to feature file and read the step, and then it has to run this step.For that reason;
//  we created stepDefs(step definition )=> and inside taht package we created Hooks and VerifyLoginFunctionality