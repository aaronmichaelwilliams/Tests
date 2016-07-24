import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class SeleniumFunctions {

    private static WebDriver driver;
    //private static JavascriptExecutor js;

    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "Firefox": {
                ProfilesIni profiles = new ProfilesIni();
                FirefoxProfile setBrowserProfile = profiles
                        .getProfile("Default User");
                driver = new FirefoxDriver(setBrowserProfile);
                break;
            }
            case "Chrome": {
                System.setProperty("webdriver.chrome.driver", "C:\\Java Resources\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            }
            default: {
                ProfilesIni profiles = new ProfilesIni();
                FirefoxProfile setBrowserProfile = profiles
                        .getProfile("Default User");
                driver = new FirefoxDriver(setBrowserProfile);
            }
        }
        driver.manage().window();
        return driver;
    }
}
