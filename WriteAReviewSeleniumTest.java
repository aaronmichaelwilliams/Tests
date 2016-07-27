import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.*;

public class WriteAReviewSeleniumTest {

    WriteAReviewSelenium writeReview;
    SeleniumFunctions sf = new SeleniumFunctions();
    GenericSelenium gs = new GenericSelenium();
    WebDriver driver = sf.getDriver("FireFox");
    HtmlUnitDriver unitDriver = sf.getUnitDriver();

    @Before
    public void setUp() throws Exception {
        writeReview = new WriteAReviewSelenium();
        //writeReview.setDriver(driver);
        //gs.setDriver(driver);
        //writeReview.goToPage();
        writeReview.setUnitDriver(unitDriver);
    }

    @After
    public void tearDown() throws Exception {
        writeReview.close();
    }

    @Test
    public void goToPage() throws Exception {
        String result = writeReview.checkPage();
        assertTrue(result.contains("Write Review") ? true : false);
    }

    @Test
    public void testBreadcrumb() {
        String textReturned = writeReview.breadcrumb();
        String textReturnedSplit[] = textReturned.split(" > ");
        boolean result = false;
        if (textReturnedSplit[0].contains("Home")
                && textReturnedSplit[1].contains("Write new Review")) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    public void testFormContents() {
        assertTrue(writeReview.formContents());
    }

    @Test
    public void testFormTabIndex() {
        assertTrue(writeReview.tabIndex());
    }

    @Test
    public void testValidationFailsAfterFieldClear() {
        assertTrue(writeReview.validationFailsAfterFieldClear());
    }

    @Test
    public void testFormInput() {
        writeReview.formInput();
    }

    @Test
    public void testHeader() {
        assertTrue(gs.header());
    }

    @Test
    public void testStickyHeaderShows() {
        assertTrue(gs.stickyHeaderShows());

    }

    @Test
    public void testStickyHeaderHides() {
        assertTrue(gs.stickyHeaderHides());

    }

    @Test
    public void testStickyHeaderClicking() {

    }

    @Test
    public void testFooter() {

    }

    @Test
    public void testBackToTop() {

    }

    @Test
    public void testing() {
        assertTrue(writeReview.testing().contains("Google"));
    }

}