package web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import core.Log;

public class Timer {
    static int implicitWaitTime = 10;
    static int waitPageLoadTimeOut = 10;
    static int waitElementTime = 5;

    public static void waiting(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (Exception exception) {
            Log.errorAndStop("Have error when sleeping: " + exception);
        }
    }

    public static void implicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
    }

    public static void waitForVisible(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, waitElementTime);
        wait.until(ExpectedConditions.visibilityOf(element));
        core.Log.debug("Element that you're waiting for : " + element.getAttribute
                ("id") + " is visible !");
    }

    public static void waitForClickable(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, waitElementTime);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Log.debug("Element that you're waiting for : " + element.getAttribute
                ("id") + " is clickable !");
    }

    public static void jsWaitForPageToLoad(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String jsCommand = "return document.readyState";
        if (!js.executeScript(jsCommand, new Object[0]).toString().equals("complete")) {
            for(int i = 0; i < waitPageLoadTimeOut; ++i) {
                waiting(2);
                if (js.executeScript(jsCommand, new Object[0]).toString().equals("complete")) {
                    break;
                }
            }
        }
    }
}
