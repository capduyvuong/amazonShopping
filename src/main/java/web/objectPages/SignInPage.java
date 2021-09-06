package web.objectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.WebBaseTest;
import static web.Timer.waitForVisible;

public class SignInPage extends WebBaseTest {
    WebDriver driver;

    //Constructor, as every page needs a Webdriver to find elements
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = ("//input[@id='ap_email']"))
    WebElement emailOrPhoneNumberTextBox;

    //Method to view the navigation To SignIn Screen
    public void seeTheNavigationToSignInScreenAction() {
        waitForVisible(driver, emailOrPhoneNumberTextBox);
        emailOrPhoneNumberTextBox.isDisplayed();
    }

}
