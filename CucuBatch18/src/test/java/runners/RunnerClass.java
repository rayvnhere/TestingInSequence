package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
            features = "src/test/resources/features/",
            glue = "steps",
            dryRun =false,
            tags="@excel",
            plugin = {"pretty"}
)

    public class RunnerClass { }



/* //we need runWith options to run cucu with junit
@RunWith(Cucumber.class)
//run all the cucumber as class

//cucumberOptions decide what to execute, where to execute
@CucumberOptions(
        //features we use to provide the path of the all feature related files
        features = "src/test/resources/features/", //path/location of the feature file // this doesnt finds stepDefinition // if specific location /Login.feature

        glue = "steps",   //it sticks StepsDef with runnerClass // glue demands path of package
//glue is the keyword use to find the gherkin stepDef we provide the path of steps package where we have all stepsDef
//WITHOUT GLUE FEATURE'S WILL GENERATE AND ASK FOR STEPdEF IN CONSOLE
//SO GLUE STICKS/LINKS THE features(File) + steps(Package)

        dryRun =false,//this stops the actual execution when set to true
//it will scan all the stepsDef and provide if there is any stepDef
// whatever stepDef is missing, it will give it without executing the code
IF TRUE will scan and GENERATE missing stepDef BUT wont execute
IF FALSE will execute

        tags="@add",//if want to test some specific testCase  //can be used for regression and smoke testing

        plugin = {"pretty"} //it will print all the steps with it proper hierarchy in console//increases the visibility of the console
)

public class RunnerClass { }








 */