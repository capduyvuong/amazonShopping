package web.objectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import web.Timer;
import web.WebBaseTest;

public class HomePage extends WebBaseTest {
    WebDriver driver;
    //Constructor, as every page needs a Webdriver to find elements
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //Declare web elements
    @FindBy(xpath= "//a[text()='Home']")
    WebElement homeMenu;

    @FindBy(xpath= "//div[@id='nav-subnav']//a[@class='nav-a'][1]")
    WebElement dealTab;

    @FindBy(xpath= "//span[@class='a-button-text a-declarative']")
    WebElement sortByDropbox;

    @FindBy (xpath = "//a[@class='a-dropdown-link'][contains(text(), 'Discount - High to Low')]")
    WebElement sortByDiscountHighToLow;

    @FindBy (xpath = "//a[@class='a-dropdown-link'][contains(text(), 'Discount - high to low')]")
    WebElement sortByDiscountHighToLowOfTodayDeals;

    @FindBy (xpath = "//a[@class='a-dropdown-link'][contains(text(), 'Newest Arrivals')]")
    WebElement sortByNewestArrival;

    @FindBy (xpath = "//a[contains(text(), 'View Deal')]")
    WebElement viewAnyDeal;

    @FindBy (xpath = "//a[@class='a-link-normal']")
    WebElement linkToSeeCurrentDeals;

    @FindBy (xpath = "//span[@class='nav-a-content'][contains(text(), 'Deals')]")
    WebElement todayDealsTab;

    @FindBy (xpath = "//div[@data-deal-id='9488f8b6']//a[@class='a-link-normal  a-color-base a-text-normal']")
    WebElement viewSecondItemWithoutButton;

    @FindBy (xpath = "(//a[text()='View item'])[1]")
    WebElement viewSecondItemWithButton;

    @FindBy (xpath = "//div[@id='selectQuantity']//select[@class='a-native-dropdown a-declarative']")
    WebElement dropBoxQuantity;

    @FindBy (xpath = "//input[@id='add-to-cart-button']")
    WebElement addToCartButton;

    @FindBy (xpath = "//a[@id='nav-logo-sprites']")
    WebElement homePageLogo;

    @FindBy (xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchTextBox;

    @FindBy (xpath = "//input[@id='nav-search-submit-button']")
    WebElement searchButton;

    @FindBy (xpath = "//div[@class='_bXVsd_gridColumn_2Jfab'][1]")
    WebElement newestArrivalItem;

    @FindBy (xpath = "//span[@id='nav-cart-count']")
    WebElement gotoCartIcon;

    /* Declare methods to perform the actions */
    //Method to go To Home Menu
    public void goToHomeMenuAction(){
        Timer.waitForClickable(driver, homeMenu);
        homeMenu.click();
    }
    //Method to go To Deal Tab
    public void goToDealTabAction(){
        Timer.waitForClickable(driver, dealTab);
        dealTab.click();
    }
    //Method to sort By Discount High To Low
    public void sortByDiscountHighToLowAction(){
        Timer.waitForClickable(driver, sortByDropbox);
        sortByDropbox.click();
        sortByDiscountHighToLow.click();
    }
    //Method to sort By Discount High To Low Of Today Deals
    public void sortByDiscountHighToLowOfTodayDealsAction(){
        Timer.waitForClickable(driver, sortByDropbox);
        sortByDropbox.click();
        sortByDiscountHighToLowOfTodayDeals.click();
    }
    //Method to sort By NewestArrival
    public void sortByNewestArrivalAction(){
        Timer.waitForClickable(driver, sortByDropbox);
        sortByDropbox.click();
        sortByNewestArrival.click();
    }
    //Method to view Second Deal
    public void viewSecondDealAction(){
        Timer.waitForClickable(driver, viewAnyDeal);
        viewAnyDeal.click();
    }
    //Method to go to link See Current Deals
    public void linkToSeeCurrentDealsAction(){
        Timer.waitForClickable(driver, linkToSeeCurrentDeals);
        linkToSeeCurrentDeals.click();
    }
    //Method to check visibility of today Deals Tab
    public void checkVisibilityAction(){
        Timer.waitForVisible(driver, todayDealsTab);
        String todayDealsTabGetText = todayDealsTab.getText();
        Assert.assertEquals(todayDealsTabGetText, "Today's Deals");
    }
    //Method to go to today Deals Tab
    public void todayDealsTabAction(){
        Timer.waitForClickable(driver, todayDealsTab);
        todayDealsTab.click();
    }
    //Method to view Second Item of Today's Deals
    public void viewSecondItemAction(){
        if (viewSecondItemWithoutButton.isDisplayed()) {
            Timer.waitForClickable(driver, viewSecondItemWithoutButton);
            viewSecondItemWithoutButton.click();
        }
    }
    //Method to click dropBox Quantity and select Quantity
    public void dropBoxQuantityAction(int quantity){
        Timer.waitForClickable(driver, dropBoxQuantity);
        dropBoxQuantity.click();
        Select selectDropBoxQuantity = new Select(dropBoxQuantity);
        selectDropBoxQuantity.selectByIndex(quantity - 1);
    }
    //Method to click add To Cart Button
    public void addToCartButtonAction(){
        Timer.waitForClickable(driver, addToCartButton);
        addToCartButton.click();
    }
    //Method to click home Page Logo
    public void homePageLogoAction(){
        Timer.waitForClickable(driver, homePageLogo);
        homePageLogo.click();
    }
    //Method to enter search Data
    public void searchTextBoxAction(String searchData){
        Timer.waitForVisible(driver, searchTextBox);
        searchTextBox.sendKeys(searchData);
    }
    //Method to click search Button
    public void searchButtonAction(){
        Timer.waitForClickable(driver, searchButton);
        searchButton.click();
    }
    //Method to click newest Arrival Item
    public void newestArrivalItemAction(){
        Timer.waitForClickable(driver, newestArrivalItem);
        newestArrivalItem.click();
    }
    //Method to go to Cart
    public void gotoShoppingCartAction(){
        homePageLogo.click();
        Timer.waitForClickable(driver, gotoCartIcon);
        gotoCartIcon.click();
    }

}
