package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import web.WebBaseTest;
import web.objectPages.HomePage;
import web.objectPages.ShoppingCartPage;
import web.objectPages.SignInPage;

import static web.Timer.waitForClickable;
import static web.Timer.waitForVisible;

public class signInPageSteps extends WebBaseTest {
    SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);

    @Then("I have been navigated to Sign-In screen")
    public void iHaveBeenNavigatedToSignInScreen() {
        signInPage.seeTheNavigationToSignInScreenAction();
    }
}
