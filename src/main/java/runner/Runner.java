package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/java/features/CreateLeadWithPOM.feature",glue="steps.implementation",monochrome=true,tags="@createlead")

public class Runner {

}
