import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class WriteAReviewSeleniumTest {
    WriteAReviewSelenium writeReview;
    SeleniumFunctions sf = new SeleniumFunctions();
    GenericSelenium gs = new GenericSelenium();
    WebDriver driver = sf.getDriver("Chrome");
    HtmlUnitDriver unitDriver = sf.getUnitDriver();

    @Before
    public void setUp() throws Exception {
        writeReview = new WriteAReviewSelenium();
        writeReview.setDriver(driver);
        gs.setDriver(driver);
        writeReview.goToPage();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void testBreadcrumb() {
        String textReturned = writeReview.breadcrumb();
        String textReturnedSplit[] = textReturned.split(" > ");
        boolean result = false;
        if (textReturnedSplit[0].contains("Home")
                && textReturnedSplit[1].contains("Write Review")) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    public void testFormContents() {
        ArrayList<String> expectedLabels = new ArrayList<>();
        expectedLabels.add("Your Name");
        expectedLabels.add("Gender");
        expectedLabels.add("Your Email");
        expectedLabels.add("Restaurant");
        expectedLabels.add("Postcode");
        expectedLabels.add("Review");
        expectedLabels.add("Upload Your Image");
        expectedLabels.add("Authenticness");
        expectedLabels.add("Heat");
        expectedLabels.add("Service");
        expectedLabels.add("Price");
        expectedLabels.add("I would not like to be added to marketing list");
        assertEquals(expectedLabels, writeReview.formLabels());
    }

    @Test
    public void testFormInputs() {
        ArrayList<String> expectedinputs = new ArrayList<>();
        expectedinputs.add("name");
        expectedinputs.add("email");
        expectedinputs.add("restaurant");
        expectedinputs.add("postcode");
        expectedinputs.add("file");
        expectedinputs.add("optOut");
        expectedinputs.add("reviewText");
        expectedinputs.add("submit");
        assertEquals(expectedinputs, writeReview.formInputs());
    }
    
    @Test
    public void testFormDropDowns() {
        ArrayList<String> expectedDropDowns = new ArrayList<>();
        expectedDropDowns.add("MaleFemaleSelect");
        expectedDropDowns.add("543210Select");
        expectedDropDowns.add("543210Select");
        expectedDropDowns.add("543210Select");
        expectedDropDowns.add("543210Select");
        assertEquals(expectedDropDowns, writeReview.formDropDowns());
    }

    @Test
    public void testFormTabIndex() {
        assertTrue(writeReview.tabIndex());
    }

    @Test
    public void testNameValidation() {
        ArrayList<String> expectedResults = new ArrayList<>();
        File file = new File("C:\\Java Resources\\tests\\Write Review\\First Name\\data.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                expectedResults.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(expectedResults, writeReview.validateName());
    }

    @Test
    public void testGenderDropDown() {
        ArrayList<String> expectedResults = new ArrayList<>();
        expectedResults.add("Male EXPECTED -> PASS VALIDATION");
        expectedResults.add("Female EXPECTED -> PASS VALIDATION");
        expectedResults.add("Select EXPECTED -> FAIL VALIDATION");
        assertEquals(writeReview.genderDropDown(), expectedResults);
    }

    @Test
    public void testEmailValidation() {
        ArrayList<String> expectedResults = new ArrayList<>();
        File file = new File("C:\\Java Resources\\tests\\Write Review\\Email\\data.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                expectedResults.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(expectedResults, writeReview.validateEmail());
    }

    @Test
    public void testRestaurantValidation() {
        ArrayList<String> expectedResults = new ArrayList<>();
        File file = new File("C:\\Java Resources\\tests\\Write Review\\Restaurant\\data.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                expectedResults.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(expectedResults, writeReview.validateRestaurant());
    }

    @Test
    public void testPostcodeValidation() {
        ArrayList<String> expectedResults = new ArrayList<>();
        File file = new File("C:\\Java Resources\\tests\\Write Review\\Postcode\\data.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                expectedResults.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(expectedResults, writeReview.validatePostcode());
    }

    @Test
    public void testReviewValidation() {
        ArrayList<String> expectedResults = new ArrayList<>();
        File file = new File("C:\\Java Resources\\tests\\Write Review\\Review\\data.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                expectedResults.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(expectedResults, writeReview.validateReview());
    }

    @Test
    public void testReviewCounts() {
        ArrayList<String> expectedResults = new ArrayList<>();
        expectedResults.add("hidden");
        expectedResults.add("400 characters");
        expectedResults.add("438 characters");
        expectedResults.add("1 character");
        expectedResults.add("hidden");
        assertEquals(expectedResults, writeReview.reviewCounts());
    }

    @Test
    public void testAuthenticnessValidation() {
        ArrayList<String> expectedResults = new ArrayList<>();
        expectedResults.add("5 EXPECTED -> PASS VALIDATION");
        expectedResults.add("4 EXPECTED -> PASS VALIDATION");
        expectedResults.add("3 EXPECTED -> PASS VALIDATION");
        expectedResults.add("2 EXPECTED -> PASS VALIDATION");
        expectedResults.add("1 EXPECTED -> PASS VALIDATION");
        expectedResults.add("0 EXPECTED -> PASS VALIDATION");
        expectedResults.add("Select EXPECTED -> FAIL VALIDATION");
        assertEquals(expectedResults, writeReview.validateAuthenticness());
    }

    @Test
    public void testHeatValidation() {
        ArrayList<String> expectedResults = new ArrayList<>();
        expectedResults.add("5 EXPECTED -> PASS VALIDATION");
        expectedResults.add("4 EXPECTED -> PASS VALIDATION");
        expectedResults.add("3 EXPECTED -> PASS VALIDATION");
        expectedResults.add("2 EXPECTED -> PASS VALIDATION");
        expectedResults.add("1 EXPECTED -> PASS VALIDATION");
        expectedResults.add("0 EXPECTED -> PASS VALIDATION");
        expectedResults.add("Select EXPECTED -> FAIL VALIDATION");
        assertEquals(expectedResults, writeReview.validateHeat());
    }

    @Test
    public void testServiceValidation() {
        ArrayList<String> expectedResults = new ArrayList<>();
        expectedResults.add("5 EXPECTED -> PASS VALIDATION");
        expectedResults.add("4 EXPECTED -> PASS VALIDATION");
        expectedResults.add("3 EXPECTED -> PASS VALIDATION");
        expectedResults.add("2 EXPECTED -> PASS VALIDATION");
        expectedResults.add("1 EXPECTED -> PASS VALIDATION");
        expectedResults.add("0 EXPECTED -> PASS VALIDATION");
        expectedResults.add("Select EXPECTED -> FAIL VALIDATION");
        assertEquals(expectedResults, writeReview.validateService());
    }

    @Test
    public void testPriceValidation() {
        ArrayList<String> expectedResults = new ArrayList<>();
        expectedResults.add("5 EXPECTED -> PASS VALIDATION");
        expectedResults.add("4 EXPECTED -> PASS VALIDATION");
        expectedResults.add("3 EXPECTED -> PASS VALIDATION");
        expectedResults.add("2 EXPECTED -> PASS VALIDATION");
        expectedResults.add("1 EXPECTED -> PASS VALIDATION");
        expectedResults.add("0 EXPECTED -> PASS VALIDATION");
        expectedResults.add("Select EXPECTED -> FAIL VALIDATION");
        assertEquals(expectedResults, writeReview.validatePrice());
    }

    @Test
    public void testValidationFailsAfterFieldClear() {
        assertTrue(writeReview.validationFailsAfterFieldClear());
    }

    @Test
    public void testFormInputNewCustomer() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(now);
        now.getTime();
        TestFunctions.tearDownDB();
        ArrayList<String> expectedResults = new ArrayList<>();
        File file = new File("C:\\Java Resources\\tests\\Write Review\\FormInput\\New Customer\\data.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                expectedResults.add("Customer Id Matches");
                expectedResults.add(scanner.nextLine());
                expectedResults.add(scanner.nextLine());
                expectedResults.add(scanner.nextLine());
                expectedResults.add(scanner.nextLine());
                expectedResults.add(scanner.nextLine());
                expectedResults.add(scanner.nextLine());
                expectedResults.add(scanner.nextLine().replace("C:\\Java Resources\\tests\\Write Review\\FormInput\\New Customer\\", ""));
                expectedResults.add(scanner.nextLine());
                expectedResults.add(scanner.nextLine());
                expectedResults.add(scanner.nextLine());
                expectedResults.add(scanner.nextLine());
                expectedResults.add(scanner.nextLine());
                expectedResults.add(scanner.nextLine());
                expectedResults.add(date);
                expectedResults.add("0");
                try {
                    scanner.nextLine();
                    scanner.nextLine();
                    scanner.nextLine();
                } catch (Exception ex) {
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(expectedResults, writeReview.completeForm("C:\\Java Resources\\tests\\Write Review\\FormInput\\New Customer\\data.txt"));
    }

    @Test
    public void testFormInputReturningCustomer() {
        TestFunctions.tearDownDB();
        Date[] dates = writeReview.returningCustomer();
        assertTrue(dates[0].getTime() < dates[1].getTime());

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
        assertTrue(gs.stickyHeaderClicking());
    }

    @Test
    public void testFooter() {
        assertTrue(gs.footer());
    }

    @Test
    public void testBackToTop() {
        assertTrue(gs.backToTop());
    }
}