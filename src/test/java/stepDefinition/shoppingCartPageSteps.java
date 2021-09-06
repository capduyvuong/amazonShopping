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

public class shoppingCartPageSteps extends WebBaseTest {
    //Instantiating Shopping Cart page using initElements()
    ShoppingCartPage shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);

    @Then("I should see quantities of first item is {int} and second item is {int}")
    public void iShouldSeeQuantitiesOfItemsCorrect(int firstItemQuantity, int secondItemQuantity) {
        shoppingCartPage.seeQuantitiesOfItemsAction(firstItemQuantity, secondItemQuantity);
    }

    @Then("I should see prices of individual items is displayed")
    public void iShouldSeePricesOfIndividualItemsIsDisplayed() {
        shoppingCartPage.seePricesOfIndividualItemsAction();
    }

    @Then("I see total prices of {int} first item and {int} second item are calculated correctly")
    public void iSeeTotalPricesOfFirstItemAndSecondItemAreCalculatedCorrectly(int quantityOfFirstItem, int quantityOfSecondItem) {
        shoppingCartPage.seeTotalPricesOfCombinedItemsAction(quantityOfFirstItem, quantityOfSecondItem);
    }

    @And("I edit the first item quantity to {int}")
    public void iEditTheFirstItemQuantityTo(int updatedFirstItemQuantity) {
        shoppingCartPage.editTheFirstItemQuantityAction(updatedFirstItemQuantity);
    }

    @And("I edit the second item quantity to {int}")
    public void iEditTheSecondItemQuantityTo(int updatedSecondItemQuantity) {
        shoppingCartPage.editTheSecondItemQuantityAction(updatedSecondItemQuantity);
    }

    @And("I delete the first item")
    public void iDeleteTheFirstItem() {
        shoppingCartPage.deleteTheFirstItemAction();
    }

    @And("I click “Proceed to Checkout”")
    public void i_click_proceed_to_checkout() {
        shoppingCartPage.clickProceedToCheckoutAction();
    }

}
