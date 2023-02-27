package co.com.dummyapi.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/user_controller.feature",
        glue = "co.com.dummyapi.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class UserController {
}
