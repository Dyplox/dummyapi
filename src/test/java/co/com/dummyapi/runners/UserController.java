package co.com.dummyapi.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/user_controller.feature",
        glue = "co.com.dummyapi.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class UserController {
}
