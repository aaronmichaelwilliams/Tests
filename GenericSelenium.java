import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GenericSelenium {

    private static WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
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

}
