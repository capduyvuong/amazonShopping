package web.objectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import web.WebBaseTest;

import static web.Timer.waitForClickable;
import static web.Timer.waitForVisible;

public class ShoppingCartPage extends WebBaseTest {
    WebDriver driver;

    //Constructor, as every page needs a Webdriver to find elements
    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    //Declare web elements
    @FindBy(xpath = "//div[@data-quantity='5']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
    WebElement firstItemPrice;

    @FindBy(xpath = "//div[@data-quantity='2']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
    WebElement secondItemPrice;

    @FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
    WebElement subTotalPrice;

    @FindBy(xpath = "//span[@class='a-dropdown-prompt'][contains(text(), '5')]")
    WebElement firstItemQuantity;

    @FindBy(xpath = "//span[@class='a-dropdown-prompt'][contains(text(), '2')]")
    WebElement secondItemQuantity;

    @FindBy(xpath = "//div[@data-quantity='5']//span[@class='a-dropdown-container']")
    WebElement dropBoxOfFirstItemQuantity;

    @FindBy(xpath = "//div[@data-quantity='5']//select[@class='a-native-dropdown a-declarative sc-update-quantity-select']")
    WebElement dropBoxOfSelectedFirstItemQuantity;

    @FindBy(xpath = "//div[@data-quantity='2']//span[@class='a-dropdown-container']")
    WebElement dropBoxOfSecondItemQuantity;

    @FindBy(xpath = "//div[@data-quantity='2']//select[@class='a-native-dropdown a-declarative sc-update-quantity-select']")
    WebElement dropBoxOfSelectedSecondItemQuantity;

    @FindBy(xpath = "//div[@data-quantity='3']//span[@data-action='delete']")
    WebElement deleteButtonOfFirstItem;

    @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
    WebElement proceedToCheckoutButton;

    /* Declare methods to perform the actions */
    //Method to see Quantities Of Items
    public void seeQuantitiesOfItemsAction(int expectedFirstItemQuantity, int expectedSecondItemQuantity) {
        waitForVisible(driver, firstItemQuantity);
        int actualFirstItemQuantity = Integer.parseInt(firstItemQuantity.getText());
        Assert.assertEquals(actualFirstItemQuantity, expectedFirstItemQuantity);

        waitForVisible(driver, secondItemQuantity);
        int actualSecondItemQuantity = Integer.parseInt(secondItemQuantity.getText());
        Assert.assertEquals(actualSecondItemQuantity, expectedSecondItemQuantity);
    }

    //Method to see Prices Of Individual Items
    public void seePricesOfIndividualItemsAction() {
        waitForVisible(driver, firstItemPrice);
        firstItemPrice.isDisplayed();
        secondItemPrice.isDisplayed();
    }

    //Method to see Total Prices Of Combined Items
     public void seeTotalPricesOfCombinedItemsAction(int quantityOfFirstItem, int quantityOfSecondItem) {
        waitForVisible(driver, firstItemPrice);
        String FirstItemPriceInclude$ = firstItemPrice.getText();
        String FirstItemPriceNotInclude$ = FirstItemPriceInclude$.replace("$", "");
        float FirstItemPriceNotInclude$Converted = Float.parseFloat(FirstItemPriceNotInclude$);
        System.out.println(FirstItemPriceNotInclude$Converted);
        float TotalPriceOfFirstItem = FirstItemPriceNotInclude$Converted * quantityOfFirstItem;

        String SecondItemPriceInclude$ = secondItemPrice.getText();
        String SecondItemPriceNotInclude$ = SecondItemPriceInclude$.replace("$", "");
        float SecondItemPriceNotInclude$Converted = Float.parseFloat(SecondItemPriceNotInclude$);
        System.out.println(SecondItemPriceNotInclude$Converted);
        float TotalPriceOfSecondItem = SecondItemPriceNotInclude$Converted * quantityOfSecondItem;

        float TotalPriceOfTwoItems = TotalPriceOfFirstItem + TotalPriceOfSecondItem;

        String SubTotalPriceInclude$ = subTotalPrice.getText();
        String SubTotalPriceNotInclude$ = SubTotalPriceInclude$.replace("$", "");
        float SubTotalPriceNotInclude$Converted = Float.parseFloat(SubTotalPriceNotInclude$);
        System.out.println(SubTotalPriceNotInclude$Converted);

        Assert.assertEquals(TotalPriceOfTwoItems, SubTotalPriceNotInclude$Converted);
    }

    //Method to edit The First Item Quantity
    public void editTheFirstItemQuantityAction(int updatedFirstItemQuantity) {
        dropBoxOfFirstItemQuantity.click();
        Select DropBoxOfSelectedFirstItemQuantity = new Select(dropBoxOfSelectedFirstItemQuantity);
        DropBoxOfSelectedFirstItemQuantity.selectByIndex(updatedFirstItemQuantity);
     }

    //Method to edit The Second Item Quantity
    public void editTheSecondItemQuantityAction(int updatedSecondItemQuantity) {
        dropBoxOfSecondItemQuantity.click();
        Select DropBoxOfSelectedSecondItemQuantity = new Select(dropBoxOfSelectedSecondItemQuantity);
        DropBoxOfSelectedSecondItemQuantity.selectByIndex(updatedSecondItemQuantity);
     }

    //Method to delete The First Item Quantity
    public void deleteTheFirstItemAction() {
        waitForClickable(driver, deleteButtonOfFirstItem);
        deleteButtonOfFirstItem.click();
     }

    //Method to proceed Checkout
    public void clickProceedToCheckoutAction() {
        try {
            waitForClickable(driver, proceedToCheckoutButton);
            proceedToCheckoutButton.click();
        }
        catch (org.openqa.selenium.StaleElementReferenceException ex) {
            waitForClickable(driver, proceedToCheckoutButton);
            proceedToCheckoutButton.click();
        }
     }
}
