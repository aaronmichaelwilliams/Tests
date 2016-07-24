import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class WriteAReviewSeleniumTest {

    WriteAReviewSelenium writeReview;
    SeleniumFunctions sf = new SeleniumFunctions();
    WebDriver driver = sf.getDriver("Chrome");

    @Before
    public void setUp() throws Exception {
        writeReview = new WriteAReviewSelenium();
        writeReview.setDriver(driver);
        writeReview.goToPage();
    }

    @After
    public void tearDown() throws Exception {
        writeReview.close();
    }

    @Test
    public void goToPage() throws Exception {
        writeReview.goToPage();
        String result = writeReview.checkPage();
        assertTrue(result.contains("Write Review") ? true : false);
    }

    @Test
    public void testBreadcrumb() {
        writeReview.goToPage();
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
    public void testFormTabIndex() { assertTrue(writeReview.tabIndex()); }

    @Test
    public void testHeader() {
        GenericSelenium gs = new GenericSelenium();
        gs.setDriver(driver);
        assertTrue(gs.header());
    }

    @Test
    public void testStickyHeader() {

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
}