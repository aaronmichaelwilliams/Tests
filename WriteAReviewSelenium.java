import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WriteAReviewSelenium {

    private static WebDriver driver;
    private static HtmlUnitDriver unitDriver;
    private static JavascriptExecutor js;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public void setUnitDriver(HtmlUnitDriver unitDriver) {
        this.unitDriver = unitDriver;
    }

    public void goToPage() {
        driver.get("http://www.amwilliams.co.uk/a/write_review.html");
    }

    public String checkPage() {
        return driver.getTitle();
    }

    public void close() {
        driver.close();
    }

    public String breadcrumb() {
        return driver.findElement(By.id("breadcrumb")).getText();
    }

    public boolean formContents() {
        boolean result = false;
        boolean labelsResult = false;
        boolean textFieldsResult = false;
        boolean reviewsTextArea = false;
        boolean selectDropDownsResult = false;
        boolean submitButtonResult = false;
        List<WebElement> labels = driver.findElements(By.tagName("label"));
        if (labels.get(0).getText().trim()
                 .replaceAll("[0-9]", "").replaceAll("\\n", "").contains("Your Name")
                && labels.get(1).getText().trim()
                .replaceAll("[0-9]", "").replaceAll("\\n", "").contains("Restaurant")
                && labels.get(2).getText().trim()
                .replaceAll("[0-9]", "").replaceAll("\\n", "").contains("Location")
                && labels.get(3).getText().trim()
                .replaceAll("[0-9]", "").replaceAll("\\n", "").contains("Review")
                && labels.get(4).getText().trim()
                .replaceAll("[0-9]", "").replaceAll("\\n", "").contains("Authenticness")
                && labels.get(5).getText().trim()
                .replaceAll("[0-9]", "").replaceAll("\\n", "").contains("Heat")
                && labels.get(6).getText().trim()
                .replaceAll("[0-9]", "").replaceAll("\\n", "").contains("Service")
                && labels.get(7).getText().trim()
                .replaceAll("[0-9]", "").replaceAll("\\n", "").contains("Price")) {
            labelsResult = true;
        }
        List<WebElement> textFields = driver.findElements(By.tagName("input"));
        if (textFields.get(1).getAttribute("name").equals("name")
                && textFields.get(2).getAttribute("name").equals("restaurant")
                && textFields.get(3).getAttribute("name").equals("location")) {
                textFieldsResult = true;
        }
        WebElement textArea = driver.findElement(By.tagName("textarea"));
        if (textArea.getAttribute("name").equals("reviewText")) {
            reviewsTextArea = true;
        }
        List<WebElement> selectDropDowns = driver.findElements(By.tagName("select"));
        if (TestFunctions.StripWhiteSpace(selectDropDowns.get(0).getText()).equals("543210")
                && TestFunctions.StripWhiteSpace(selectDropDowns.get(0).getAttribute("name")).equals("authenticness")
                && TestFunctions.StripWhiteSpace(selectDropDowns.get(1).getText()).equals("543210")
                && TestFunctions.StripWhiteSpace(selectDropDowns.get(1).getAttribute("name")).equals("heat")
                && TestFunctions.StripWhiteSpace(selectDropDowns.get(2).getText()).equals("543210")
                && TestFunctions.StripWhiteSpace(selectDropDowns.get(2).getAttribute("name")).equals("service")
                && TestFunctions.StripWhiteSpace(selectDropDowns.get(3).getText()).equals("543210")
                && TestFunctions.StripWhiteSpace(selectDropDowns.get(3).getAttribute("name")).equals("price")
                ) {
            selectDropDownsResult = true;
        }
        WebElement submitButton = driver.findElement(By.tagName("button"));
        if (submitButton.getAttribute("type").equals("submit")) {
            submitButtonResult = true;
        }
        if (labelsResult && textFieldsResult && reviewsTextArea && selectDropDownsResult && submitButtonResult) {
            result = true;
        }
        return result;
    }

    public boolean tabIndex() {
        boolean result = false;
        boolean fieldName = false;
        boolean fieldRestaurant = false;
        boolean fieldLocation = false;
        boolean fieldReview = false;
        boolean fieldAuthentic = false;
        boolean fieldHeat = false;
        boolean fieldService = false;
        boolean fieldPrice = false;
        boolean fieldSubmit = false;
        List<WebElement> labels = driver.findElements(By.tagName("label"));
        labels.get(0).click();
        WebElement activeElement = driver.switchTo().activeElement();
        fieldName = activeElement.getAttribute("name").equals("name") ? true : false;
        activeElement.sendKeys(Keys.TAB);
        activeElement = driver.switchTo().activeElement();
        fieldRestaurant = activeElement.getAttribute("name").equals("restaurant") ? true : false;
        activeElement.sendKeys(Keys.TAB);
        activeElement = driver.switchTo().activeElement();
        fieldLocation = activeElement.getAttribute("name").equals("location") ? true : false;
        activeElement.sendKeys(Keys.TAB);
        activeElement = driver.switchTo().activeElement();
        fieldReview = activeElement.getAttribute("name").equals("reviewText") ? true : false;
        activeElement.sendKeys(Keys.TAB);
        activeElement = driver.switchTo().activeElement();
        fieldAuthentic = activeElement.getAttribute("name").equals("authenticness") ? true : false;
        activeElement.sendKeys(Keys.TAB);
        activeElement = driver.switchTo().activeElement();
        fieldHeat = activeElement.getAttribute("name").equals("heat") ? true : false;
        activeElement.sendKeys(Keys.TAB);
        activeElement = driver.switchTo().activeElement();
        fieldPrice = activeElement.getAttribute("name").equals("service") ? true : false;
        activeElement.sendKeys(Keys.TAB);
        activeElement = driver.switchTo().activeElement();
        fieldPrice = activeElement.getAttribute("name").equals("price") ? true : false;
        activeElement.sendKeys(Keys.TAB);
        activeElement = driver.switchTo().activeElement();
        fieldSubmit = activeElement.getAttribute("type").equals("submit") ? true : false;
        if (fieldName && fieldRestaurant && fieldLocation
                && fieldReview && fieldAuthentic && fieldHeat
                && fieldPrice && fieldSubmit) {
            result = true;
        }
        return result;
    }

    public boolean validationFailsAfterFieldClear() {
        /* TO FINISH AFTER VALIDATION IS COMPLETED */
        boolean result = false;
        driver.findElement(By.name("name")).sendKeys("Text input!");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.tagName("button")).click();
        return result;
    }

    public void formInput() {
        /* TO FINISH AFTER VALIDATION IS COMPLETED */
        Select heatDownDown = new Select(driver.findElement(By.name("heat")));
        heatDownDown.selectByIndex(3);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String testing() {
        unitDriver.get("http://www.google.com");
        return unitDriver.getTitle();
    }

}















