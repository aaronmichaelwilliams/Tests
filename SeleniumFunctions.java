import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SeleniumFunctions {

    private static WebDriver driver;
    private static HtmlUnitDriver unitDriver;
    private static JavascriptExecutor js;

    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "Firefox": {
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                driver = new FirefoxDriver(capabilities);
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
        return driver;
    }

    public HtmlUnitDriver getUnitDriver() {
        return unitDriver = new HtmlUnitDriver(true);
    }

    public void takeScreenshot() {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("C:\\Java Resources\\Screenshots\\Screenshot.png"));
        } catch (IOException e) {
        }
    }

    public void switchTabs(String direction, WebDriver driver) {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        if (direction.contains("+")) {
            driver.switchTo().window(tabs.get(Integer.parseInt(direction.replace("+", ""))));
        } else if (direction.contains("-")) {
                driver.switchTo().window(tabs.get(Integer.parseInt(direction.replace("-", ""))));
            }
    }

    public void closeAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        driver.switchTo().parentFrame();
    }

    public void maximiseWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public void positionWindow(WebDriver driver, int x, int y) {
        Point points = new Point(x, y);
        driver.manage().window().setPosition(points);
    }

    public String getLocationOfElement(WebDriver driver, WebElement element) {
        Point points = element.getLocation();
        int x = points.getX();
        int y = points.getY();
        return x + "x" + y;
    }

    public void doubleClick(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).doubleClick().perform();
    }

    public void rightClickSelect(WebDriver driver, WebElement element, int optionsDown) {
        Actions action = new Actions(driver);
        action.moveToElement(element);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        action.contextClick(element).build().perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        action.sendKeys(Keys.ARROW_RIGHT).build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setPageLoadTimeOut(WebDriver driver, int time) {
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
    }

    public void scrollToElement(JavascriptExecutor js, WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void setImplicitTimeout(WebDriver driver, int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void explicitWait(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("el"))));
    }

    public String getSizeOfElement(WebDriver driver, WebElement element) {
        Dimension dim = element.getSize();
        return dim.width + " " + dim.height;
    }

    public void dragAndDrop(WebDriver driver, WebElement element,
                                                    WebElement to) {
        Actions action = new Actions(driver);
        action.clickAndHold(element).moveToElement(to).release(to).build();

    }

}
