package web;

import core.Log;
import org.openqa.selenium.WebDriver;

public class UIComponent {
    public static void reloadPage(WebDriver driver){
        Log.debug("Reload page");
        driver.navigate().refresh();
    }

    public static void navigateToUrl(WebDriver driver, String url) {
        Log.debug("Navigate to " + url);
        driver.navigate().to(url);
        Timer.jsWaitForPageToLoad(driver);
    }

}
