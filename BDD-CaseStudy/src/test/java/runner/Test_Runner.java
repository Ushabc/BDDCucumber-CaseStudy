package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/SignUp/SignUp.feature"},
glue= {"stepDefinition"},
dryRun=false,
tags="@MultipleUsersRegistration",
plugin= {"html:testoutput/usha.html","junit:testoutput/usha.xml","json:testoutput/usha.json"})
public class Test_Runner {

}
