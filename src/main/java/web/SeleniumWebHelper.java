package web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumWebHelper {
    public static void configureDriverPath() {
        if(System.getProperty("os.name").startsWith("Windows")) {
            String firefoxDriverPath = System.getProperty("user.dir") + "/src/resources/drivers/windows/geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            String chromeDriverPath = System.getProperty("user.dir") + "/src/resources/drivers/windows/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        }
    }

    public static WebDriver initBrowser(String browserType) {
        WebDriver driver = null;
        configureDriverPath();
        if (browserType.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserType.equals("chrome")) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }
}
