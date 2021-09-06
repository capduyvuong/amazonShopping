package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import web.WebBaseTest;
import web.objectPages.HomePage;

public class homePageSteps extends WebBaseTest {
    //Instantiating homePage page using initElements()
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    @When("I go to Home menu")
    public void iGoToHomeMenu() {
        homePage.goToHomeMenuAction();
    }

    @And("I go to deal tab")
    public void iGoToDealTab() {
        homePage.goToDealTabAction();
    }

    @And("I sort the Deals on Home Products by “Discount: High to Low”")
    public void iSortTheDealsOnHomeProductsByDiscountHighToLow() {
        homePage.sortByDiscountHighToLowAction();
    }

    @And("I view Deal for second item")
    public void iViewDealForSecondItem() {
        homePage.viewSecondDealAction();
    }

    @And("I click the link {string}")
    public void iClickTheLink(String arg0) {
        homePage.linkToSeeCurrentDealsAction();
    }

    @Then("I should be on Today's Deals")
    public void iShouldBeOnTodaySDeals() {
        homePage.checkVisibilityAction();
    }

    @When("I sort the Today's Deals by “Discount: High to Low”")
    public void i_sort_the_deals_on_home_products_by_discount_high_to_low() {
        homePage.sortByDiscountHighToLowOfTodayDealsAction();
    }

    @And("I click View second item")
    public void iClickViewSecondItem() {
        homePage.viewSecondItemAction();
    }

    @And("I add {int} items into the cart")
    public void iAddItemsIntoTheCart(int quantity) {
        homePage.dropBoxQuantityAction(quantity);
        homePage.addToCartButtonAction();
    }

    @And("I go back to Home page")
    public void iGoBackToHomePage() {
        homePage.homePageLogoAction();
    }

    @And("I search for {string}")
    public void iSearchForText(String searchName) {
        homePage.searchTextBoxAction(searchName);
        homePage.searchButtonAction();
    }

    @And("I sort the items by “Newest Arrivals”")
    public void iSortTheItemsByNewestArrivals() {
        homePage.sortByNewestArrivalAction();
    }

    @And("I click on Newest Arrivals item")
    public void iClickOnNewestArrivalsItem() {
        homePage.newestArrivalItemAction();
    }

    @And("I go to shopping cart")
    public void iGoToShoppingCart() {
        homePage.gotoShoppingCartAction();
    }
}
