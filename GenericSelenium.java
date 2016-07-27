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
        String[][] expectedLinks = {{"Home", "Reviews", "Write Review",
                "Recipies", "Add Recipie", "Advertise"}, {"index.html", "reviews.html",
        "write_review.html", "write_review.html#", "write_review.html#", "write_review.html#" }};
        WebElement headerContainer = driver.findElement(By.id("headerContainer"));
        List<WebElement> anchors = headerContainer.findElements(By.tagName("a"));
        int numberOfChecks = 0;
        for (WebElement we : anchors) {
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

    public boolean stickyHeaderShows() {
        boolean result = false;
        String startTopValue = driver.findElement(By.id("stickyHeader")).getCssValue("top");
        js.executeScript("window.scrollTo(0, 180);");
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
        System.out.println(startTopValue);
        js.executeScript("window.scrollTo(0, 0);");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        String endTopValue = driver.findElement(By.id("stickyHeader")).getCssValue("top");
        System.out.println(endTopValue);
        if (startTopValue.equals("0px") && endTopValue.equals("-50px")) {
            result = true;
        }
        return result;
    }
}
