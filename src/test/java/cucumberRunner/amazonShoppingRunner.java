package cucumberRunner;

import io.cucumber.testng.CucumberOptions;
import web.WebBaseTest;

@CucumberOptions(
        monochrome = true,
        features = "src/test/feature/amazonShopping.feature",
        glue = "stepDefinition",
        plugin = {"json:target/cucumber-reports/cucumber.json", "pretty"}
)

public class amazonShoppingRunner extends WebBaseTest {
}
