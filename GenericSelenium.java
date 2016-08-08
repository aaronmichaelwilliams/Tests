import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GenericSelenium {

    private static WebDriver driver;
    private static JavascriptExecutor js;

    public void setDriver(WebDriver driver) {

        this.driver = driver;
        js = (JavascriptExecutor)driver;
     }

    public void setJs(JavascriptExecutor js) {
        this.js = js;
    }

    public boolean header() {
        boolean result = false;
        boolean resultText = false;
        boolean resultURL = false;
        String[][] expectedLinks = {{"Home", "Reviews", "Write Review", "" ,
                "Invite Me", "Feedback", "Advertise"}, {"index.php", "reviews.php",
        "write_review.php", "index.php", "javascript:void(0)", "feedback.php", "feedback.php" }};
        WebElement headerContainer = driver.findElement(By.id("headerContainer"));
        List<WebElement> anchors = headerContainer.findElements(By.tagName("a"));
        int numberOfChecks = 0;
        for (WebElement we : anchors) {
            System.out.println("does " + we.getText() + " = " + expectedLinks[0][numberOfChecks]);
            System.out.println("does " + we.getAttribute("href").replace("http://www.amwilliams.co.uk/a/", "") + " = " + expectedLinks[1][numberOfChecks]);
            resultText = we.getText().equals(expectedLinks[0][numberOfChecks]) ? true : false;
            resultURL = we.getAttribute("href").replace("http://www.amwilliams.co.uk/a/", "").equals(expectedLinks[1][numberOfChecks]) ? true : false;
            if (!(resultText && resultURL)) {
                break;
            }
            numberOfChecks++;
        }
        if (resultText && resultURL) {
            result = true;
        }
        return result;
    }

    public boolean footer() {
        return driver.findElement(By.tagName("footer")).isDisplayed();
    }

    public boolean backToTop() {
        boolean result;
        js.executeScript("window.scrollTo(0, 9000);");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        WebElement backToTop = driver.findElement(By.id("backToTop"));
        backToTop.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        long scrollPosition = (long) js.executeScript("return window.scrollY");
        result = scrollPosition == 0 ? true : false;
        if (result) {
            result = backToTop.isDisplayed() ? false : true;
        }
        return result;
    }

    public boolean stickyHeaderShows() {
        boolean result = false;
        String startTopValue = driver.findElement(By.id("stickyHeader")).getCssValue("top");
        js.executeScript("window.scrollTo(0, 180);");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        String endTopValue = driver.findElement(By.id("stickyHeader")).getCssValue("top");
        if (startTopValue.equals("-50px") && endTopValue.equals("0px")) {
            result = true;
        }
        return result;
    }

    public boolean stickyHeaderHides() {
        boolean result = false;
        js.executeScript("window.scrollTo(0, 180);");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        String startTopValue = driver.findElement(By.id("stickyHeader")).getCssValue("top");
        js.executeScript("window.scrollTo(0, 0);");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        String endTopValue = driver.findElement(By.id("stickyHeader")).getCssValue("top");
        if (startTopValue.equals("0px") && endTopValue.equals("-50px")) {
            result = true;
        }
        return result;
    }

    public boolean stickyHeaderClicking() {
        boolean result = false;
        String startTopValue = driver.findElement(By.id("stickyHeader")).getCssValue("top");
        js.executeScript("window.scrollTo(0, 180);");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        js.executeScript("window.scrollTo(0, 180);");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        WebElement stickyHeader = driver.findElement(By.id("stickyHeader"));
        String endTopValue = stickyHeader.getCssValue("top");
        if (startTopValue.equals("-50px") && endTopValue.equals("0px")) {
            stickyHeader.click();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        long scrollPosition = (long) js.executeScript("return window.scrollY");
        result = scrollPosition == 0 ? true : false;
        return result;
    }
}
