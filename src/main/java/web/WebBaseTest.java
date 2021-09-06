package web;

import core.Config;
import core.Log;
import core.PropertyValues;
import core.cucumberHelper.ReportHelper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static web.SeleniumWebHelper.maximizeWindow;

public class WebBaseTest extends AbstractTestNGCucumberTests{
    public static WebDriver driver;
    public static String amazonUrl;
    public static final String FILE_CONFIG = "\\src\\main\\config\\web.properties";

    @BeforeSuite(alwaysRun = true)
    @Parameters( {"environment", "browserType"} )
    public void setUp(String environment, String browserType) throws IOException {
        Config.init(environment);
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        driver = SeleniumWebHelper.initBrowser(browserType);
        Timer.implicitWait(driver);
        amazonUrl = properties.getProperty(Config.globalEnvironment + "." + "url.amazon");
        UIComponent.navigateToUrl(driver, amazonUrl);
        maximizeWindow(driver);
    }

    @AfterSuite(alwaysRun=true)
    public void generateHTMLReports() {
        ReportHelper.generateCucumberReport("web.properties");
    }

    @AfterSuite(alwaysRun = true)
    public void quitTest(){
        driver.quit();
    }
}
