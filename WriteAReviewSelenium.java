import org.apache.commons.lang3.StringEscapeUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class WriteAReviewSelenium {
    WebDriver driver;
    HtmlUnitDriver unitDriver;
    JavascriptExecutor js;
    ArrayList<String> actualResults;
    List<WebElement> allLabels;
    WebElement elNameTextField;
    Select elGenderDropDown;
    By byNameTextField = By.name("name");
    By byEmailTextField = By.name("email");
    By byRestaurantTextField = By.name("restaurant");
    By byPostCodeTextField = By.name("postcode");
    By byReviewTextArea = By.name("reviewText");
    By byBreadCrumb = By.id("breadcrumb");
    By byFile = By.id("file");
    By byUploadImage = By.id("uploadImage");
    By byAuthenticnessDropDown = By.name("authenticness");
    By byHeatDropDown = By.name("heat");
    By byServiceDropDown = By.name("service");
    By byPriceDropDown = By.name("price");
    By bySubmit = By.id("submit");
    By byGender = By.name("gender");
    By byNameFailed = By.id("nameFailed");
    By byGenderFailed = By.id("genderFailed");
    By byEmailFailed = By.id("emailFailed");
    By byRestaurantFailed = By.id("restaurantFailed");
    By bypostcodeFailed = By.id("postcodeFailed");
    By byReviewFailed = By.id("reviewFailed");
    By byHeatFailed = By.id("heatFailed");
    By byServiceFailed = By.id("serviceFailed");
    By byPriceFailed = By.id("priceFailed");
    By byAuthenticnessFailed = By.id("authenticnessFailed");
    By byOptOut = By.name("optOut");
    WebElement elEmailTextField;
    WebElement elRestaurantTextField;
    WebElement elPostcodeTextField;
    WebElement elReviewTextArea;
    WebElement elFile;
    WebElement elUploadImage;
    String pageURL = "http://www.amwilliams.co.uk/a/write_review.php";
    WebElement elNameFailed;
    Select elAuthenticnessDropDown;
    Select elHeatDropDown;
    Select elServiceDropDown;
    Select elPriceDropDown;
    WebElement elOptCheckBox;
    WebElement elSubmitButton;
    WebElement elGenderFailed;
    WebElement elEmailFailed;
    WebElement elRestaurantFailed;
    WebElement elpostcodeFailed;
    WebElement elReviewFailed;
    WebElement elAuthenticnessFailed;
    WebElement elHeatFailed;
    WebElement elServiceFailed;
    WebElement elPriceFailed;
    WebElement elReviewTextCount;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    public void setUnitDriver(HtmlUnitDriver unitDriver) {
        this.unitDriver = unitDriver;
    }

    public void goToPage() {
        driver.get(pageURL);
    }

    public String checkPage() {
        return driver.getTitle();
    }

    public String breadcrumb() {
        return driver.findElement(byBreadCrumb).getText();
    }

    public ArrayList<String> formLabels() {
        actualResults = new ArrayList<>();
        allLabels = driver.findElements(By.tagName("label"));
        for (int i = 0; i < allLabels.size(); i++) {
            actualResults.add(allLabels.get(i).getText().trim()
                    .replaceAll("[0-9]", "").replaceAll("\\n", "")
                    .replaceAll("  ", "").replace(" Select", "")
                    .replaceAll("MaleFemaleSelect", ""));
        }
        return actualResults;
    }

    public ArrayList<String> formInputs() {
        actualResults = new ArrayList<String>();
        List<WebElement> textFields = driver.findElements(By.tagName("input"));
        for (int i = 0; i < textFields.size(); i++) {
            if (textFields.get(i).getAttribute("name").length() > 0) {
                actualResults.add(textFields.get(i).getAttribute("name"));
            }
        }
        elReviewTextArea = driver.findElement(By.tagName("textarea"));
        if (elReviewTextArea.isDisplayed()) {
            actualResults.add(elReviewTextArea.getAttribute("name"));
        }
        elSubmitButton = driver.findElement(By.tagName("button"));
        if (elSubmitButton.isDisplayed()) {
            actualResults.add(elSubmitButton.getAttribute("type"));
        }
        return actualResults;
    }

    public ArrayList<String> formDropDowns() {
        actualResults = new ArrayList<String>();
        List<WebElement> selectDropDowns = driver.findElements(By.tagName("select"));
        for (int i = 0; i < selectDropDowns.size(); i++) {
            actualResults.add(TestFunctions.StripWhiteSpace(selectDropDowns.get(i).getText()));
        }
        return actualResults;
    }

    public boolean tabIndex() {
        boolean result = false;
        boolean fieldName = false;
        boolean fieldRestaurant = false;
        boolean fieldGender = false;
        boolean fieldEmail = false;
        boolean fieldLocation = false;
        boolean fieldReview = false;
        boolean fieldFile = false;
        boolean fieldAuthentic = false;
        boolean fieldHeat = false;
        boolean fieldService = false;
        boolean fieldPrice = false;
        boolean fieldOpt = false;
        boolean fieldSubmit = false;
            allLabels = driver.findElements(By.tagName("label"));
            allLabels.get(0).click();
            WebElement activeElement = driver.switchTo().activeElement();
            fieldName = activeElement.getAttribute("name").equals("name") ? true : false;
            activeElement.sendKeys(Keys.TAB);
            activeElement = driver.switchTo().activeElement();
            fieldGender = activeElement.getAttribute("name").equals("gender") ? true : false;
            activeElement.sendKeys(Keys.TAB);
            activeElement = driver.switchTo().activeElement();
            fieldEmail = activeElement.getAttribute("name").equals("email") ? true : false;
            activeElement.sendKeys(Keys.TAB);
            activeElement = driver.switchTo().activeElement();
            fieldRestaurant = activeElement.getAttribute("name").equals("restaurant") ? true : false;
            activeElement.sendKeys(Keys.TAB);
            activeElement = driver.switchTo().activeElement();
            fieldLocation = activeElement.getAttribute("name").equals("postcode") ? true : false;
            activeElement.sendKeys(Keys.TAB);
            activeElement = driver.switchTo().activeElement();
            fieldReview = activeElement.getAttribute("name").equals("reviewText") ? true : false;
            activeElement.sendKeys(Keys.TAB);
            activeElement = driver.switchTo().activeElement();
            driver.findElement(byFile).sendKeys("C:\\\\Java Resources\\Untitled.png");
            fieldFile = activeElement.getAttribute("name").equals("file") ? true : false;
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(byUploadImage).click();
        activeElement = driver.switchTo().activeElement();
        activeElement.sendKeys(Keys.TAB);
            activeElement = driver.switchTo().activeElement();
            fieldAuthentic = activeElement.getAttribute("name").equals("authenticness") ? true : false;
            activeElement.sendKeys(Keys.TAB);
            activeElement = driver.switchTo().activeElement();
            fieldHeat = activeElement.getAttribute("name").equals("heat") ? true : false;
            activeElement.sendKeys(Keys.TAB);
            activeElement = driver.switchTo().activeElement();
            fieldService = activeElement.getAttribute("name").equals("service") ? true : false;
            activeElement.sendKeys(Keys.TAB);
            activeElement = driver.switchTo().activeElement();
            fieldPrice = activeElement.getAttribute("name").equals("price") ? true : false;
            activeElement.sendKeys(Keys.TAB);
            activeElement = driver.switchTo().activeElement();
            fieldOpt = activeElement.getAttribute("name").equals("optOut") ? true : false;
            activeElement.sendKeys(Keys.TAB);
            activeElement = driver.switchTo().activeElement();
            fieldSubmit = activeElement.getAttribute("type").equals("submit") ? true : false;
            if (fieldName && fieldGender && fieldEmail && fieldRestaurant && fieldLocation
                && fieldReview && fieldAuthentic && fieldHeat && fieldService
                && fieldPrice && fieldOpt && fieldSubmit) {
            result = true;
        }
        return result;
    }


    public boolean validationFailsAfterFieldClear() {
        boolean result = false;
        elNameFailed = driver.findElement(byNameFailed);
        driver.findElement(By.name("name")).sendKeys("Text input");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.tagName("button")).click();
        return result = elNameFailed.isDisplayed() ? true : false;
    }

    public ArrayList<String> completeForm(String fileLocation) {
        actualResults = new ArrayList<>();
        File file = new File(fileLocation);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                driver.get("http://amwilliams.co.uk/a/write_review.php");
                elNameTextField = driver.findElement(byNameTextField);
                elNameTextField.sendKeys(scanner.nextLine());
                Select genderDropDown = new Select (driver.findElement(byGender));
                genderDropDown.selectByValue(scanner.nextLine());
                elEmailTextField = driver.findElement(byEmailTextField);
                elEmailTextField.sendKeys(scanner.nextLine());
                elRestaurantTextField = driver.findElement(byRestaurantTextField);
                elRestaurantTextField.sendKeys(scanner.nextLine());
                elPostcodeTextField = driver.findElement(byPostCodeTextField);
                elPostcodeTextField.sendKeys(scanner.nextLine());
                elReviewTextArea = driver.findElement(byReviewTextArea);
                elReviewTextArea.sendKeys(scanner.nextLine());
                //scanner.nextLine();
                elFile = driver.findElement(byFile);
                elFile.sendKeys(scanner.nextLine());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                elUploadImage = driver.findElement(byUploadImage);
                elUploadImage.click();
                scanner.nextLine();
                elAuthenticnessDropDown = new Select(driver.findElement(byAuthenticnessDropDown));
                elAuthenticnessDropDown.selectByValue(scanner.nextLine());
                elHeatDropDown = new Select(driver.findElement(byHeatDropDown));
                elHeatDropDown.selectByValue(scanner.nextLine());
                elServiceDropDown = new Select(driver.findElement(byServiceDropDown));
                elServiceDropDown.selectByValue(scanner.nextLine());
                elPriceDropDown = new Select(driver.findElement(byPriceDropDown));
                elPriceDropDown.selectByValue(scanner.nextLine());
                elOptCheckBox = driver.findElement(byOptOut);
                if (scanner.nextLine().equals("1")) {
                    elOptCheckBox.click();
                }
                elSubmitButton = driver.findElement(bySubmit);
                elSubmitButton.click();
            try {
                scanner.nextLine();
                scanner.nextLine();
                scanner.nextLine();
            } catch (Exception ex) {
            }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Database db = new Database();
        db.connect("amwilliams");
        ResultSet rs = db.query("select rev.cust_id, cust.id, cust.first_name, cust.gender, cust.email, rev.title, rev.postcode, rev.desc, rev.image, rev.score, rev.authenticness, rev.heat, rev.service, rev.price, cust.opt_in, rev.date_crtd, rev.published from vl_customers cust join vl_reviews rev on cust.id = rev.cust_id order by 1 asc");
        try {
            while (rs.next()) {
                if (rs.getInt(1) == rs.getInt(2)) {
                actualResults.add("Customer Id Matches");
                } else {
                    actualResults.add("Customer Id Mismatch");
                }
                actualResults.add(StringEscapeUtils.unescapeHtml4(rs.getString(3)));
                actualResults.add(rs.getString(4));
                actualResults.add(rs.getString(5));
                actualResults.add(StringEscapeUtils.unescapeHtml4(rs.getString(6)));
                actualResults.add(rs.getString(7));
                actualResults.add(StringEscapeUtils.unescapeHtml4(rs.getString(8)));
                actualResults.add(rs.getString(9));
                actualResults.add(rs.getString(10));
                actualResults.add(rs.getString(11));
                actualResults.add(rs.getString(12));
                actualResults.add(rs.getString(13));
                actualResults.add(rs.getString(14));
                actualResults.add(rs.getString(15));
                actualResults.add(rs.getString(16).substring(0, 10));
                actualResults.add(rs.getString(17));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (StringIndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
        return actualResults;
    }

    public Date[] returningCustomer() {
        Date[] dates = new Date[2];
        ArrayList<String> results = new ArrayList<>();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date firstReviewDate = new Date();
        Date secondReviewDate = new Date();
        results = completeForm("C:\\Java Resources\\tests\\Write Review\\FormInput\\Returning Customer\\data.txt");
        Customer customer1 = getCustomerDetails(results.get(3));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Review review1 = getReviewDetails(customer1.getId());
        results = completeForm("C:\\Java Resources\\tests\\Write Review\\FormInput\\Returning Customer\\data.txt");
        Customer customer2 = getCustomerDetails(results.get(3));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }        Review review2 = getReviewDetails(customer2.getId());
        try {
            System.out.println("Cust1 Last Review: " + customer1.getLast_review());
            System.out.println("Cust2 Last Review: " + customer2.getLast_review());
            System.out.println("Review1 created: " + review1.getDate_crtd());
            System.out.println("Review2 created: " + review2.getDate_crtd());
            System.out.println("Cust1 ID: " + customer1.getId());
            System.out.println("Cust2 ID: " + customer2.getId());
            Date date1 = formatter.parse(customer1.getLast_review());
            Date date2 = formatter.parse(customer2.getLast_review());
            Date date3 = formatter.parse(review1.getDate_crtd());
            Date date4 = formatter.parse(review2.getDate_crtd());
        if (date1.getTime() < date2.getTime()
                && customer1.getId() == customer2.getId()
                && date3.getTime() < date4.getTime()
                && customer1.getId() == customer2.getId()
                )                                           {
                dates[0] = date3;
                dates[1] = date4;
        }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dates;
    }

    public Customer getCustomerDetails(String email) {
        Customer customer = new Customer();
        Database db = new Database();
        db.connect("amwilliams");
        ResultSet rs = db.query("select * from vl_customers where email = '" + email.replace(" | ", "").trim() + "' order by last_review desc");
        try {
            rs.next();
            customer.setId(rs.getInt(1));
            customer.setGender(rs.getString(2));
            customer.setFirst_name((rs.getString(3)));
            customer.setEmail(rs.getString(4));
            customer.setOpt_in(rs.getBoolean(5));
            customer.setRegister_date(rs.getString(6).substring(0, 19));
            customer.setLast_review(rs.getString(7).substring(0, 19));
            customer.setDeactivated(rs.getBoolean(8));
            try {
                customer.setDeactivate_date(rs.getString(9).substring(0, 19));
            } catch (Exception ex) {
            }
            customer.setSession(rs.getString(10));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public Review getReviewDetails(int customerId) {
        Review review = new Review();
        Database db = new Database();
        db.connect("amwilliams");
        ResultSet rs = db.query("select * from vl_reviews where cust_id = '" + customerId + "' order by date_crtd desc");
        try {
            rs.next();
            review.setId(rs.getInt(1));
            review.setCust_id(rs.getInt(2));
            review.setDate_crtd(rs.getString(3).substring(0, 19));
            review.setTitle(rs.getString(4));
            review.setDesc(rs.getString(5));
            review.setScore(rs.getInt(6));
            review.setHeat(rs.getInt(7));
            review.setService(rs.getInt(8));
            review.setPrice(rs.getInt(9));
            review.setLocation(rs.getString(10));
            review.setPostcode(rs.getString(11));
            review.setPublished(rs.getBoolean(12));
            review.setImage(rs.getString(14));
            review.setMetadata(rs.getString(15));
            review.setKeywords(rs.getString(16));
            try {
                review.setDate_published(rs.getString(17).substring(0, 19));
            } catch (Exception e) {

            }
        } catch (SQLException e) {
        }
        return review;
    }

    public ArrayList<String> validateName() {
        actualResults = new ArrayList<>();
        File file = new File("C:\\Java Resources\\tests\\Write Review\\First Name\\data.txt");
        try {
            Scanner scanner = new Scanner(file);
            elNameTextField = driver.findElement(By.name("name"));
            elNameFailed = driver.findElement(byNameFailed);
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                String[] input = nextLine.split(" EXPECTED -> ");
                boolean result = inputAndValidateField(input[0], elNameTextField, elNameFailed);
                if (result == false && input[1].equals("PASS VALIDATION")) {
                    actualResults.add(nextLine);
                } else if (result == true && input[1].equals("FAIL VALIDATION")) {
                    actualResults.add(nextLine);
                } else {
                    String resultToWrite = result == false ? "PASS VALIDATION" : "FAIL VALIDATION";
                    actualResults.add(input[0] + " EXPECTED -> " + resultToWrite);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return actualResults;
    }

    public ArrayList<String> genderDropDown() {
        actualResults = new ArrayList<>();
        elGenderDropDown = new Select(driver.findElement(byGender));
        elGenderFailed = driver.findElement(byEmailFailed);
        actualResults.add(dropDownTester(elGenderDropDown, elGenderFailed, "Male", true));
        actualResults.add(dropDownTester(elGenderDropDown, elGenderFailed, "Female", true));
        actualResults.add(dropDownTester(elGenderDropDown, elGenderFailed, "Select", false));
        return actualResults;
    }

    public ArrayList<String> validateEmail() {
        actualResults = new ArrayList<>();
        File file = new File("C:\\Java Resources\\tests\\Write Review\\Email\\data.txt");
        try {
            Scanner scanner = new Scanner(file);
            elEmailTextField = driver.findElement(byEmailTextField);
            elEmailFailed = driver.findElement(byEmailFailed);
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                String[] input = nextLine.split(" EXPECTED -> ");
                boolean result = inputAndValidateField(input[0], elEmailTextField, elEmailFailed);
                if (result == false && input[1].equals("PASS VALIDATION")) {
                    actualResults.add(nextLine);
                } else if (result == true && input[1].equals("FAIL VALIDATION")) {
                    actualResults.add(nextLine);
                } else {
                    String resultToWrite = result == false ? "PASS VALIDATION" : "FAIL VALIDATION";
                    actualResults.add(input[0] + " EXPECTED -> " + resultToWrite);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return actualResults;
    }

    public ArrayList<String> validateRestaurant() {
        actualResults = new ArrayList<>();
        File file = new File("C:\\Java Resources\\tests\\Write Review\\Restaurant\\data.txt");
        try {
            Scanner scanner = new Scanner(file);
            elRestaurantTextField = driver.findElement(byRestaurantTextField);
            elRestaurantFailed = driver.findElement(byRestaurantFailed);
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                String[] input = nextLine.split(" EXPECTED -> ");
                boolean result = inputAndValidateField(input[0], elRestaurantTextField, elRestaurantFailed);
                if (result == false && input[1].equals("PASS VALIDATION")) {
                    actualResults.add(nextLine);
                } else if (result == true && input[1].equals("FAIL VALIDATION")) {
                    actualResults.add(nextLine);
                } else {
                    String resultToWrite = result == false ? "PASS VALIDATION" : "FAIL VALIDATION";
                    actualResults.add(input[0] + " EXPECTED -> " + resultToWrite);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return actualResults;
    }

    public ArrayList<String> validatePostcode() {
        actualResults = new ArrayList<>();
        File file = new File("C:\\Java Resources\\tests\\Write Review\\Postcode\\data.txt");
        try {
            Scanner scanner = new Scanner(file);
            elPostcodeTextField = driver.findElement(byPostCodeTextField);
            elpostcodeFailed = driver.findElement(bypostcodeFailed);
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                String[] input = nextLine.split(" EXPECTED -> ");
                boolean result = inputAndValidateField(input[0], elPostcodeTextField, elpostcodeFailed);
                if (result == false && input[1].equals("PASS VALIDATION")) {
                    actualResults.add(nextLine);
                } else if (result == true && input[1].equals("FAIL VALIDATION")) {
                    actualResults.add(nextLine);
                } else {
                    String resultToWrite = result == false ? "PASS VALIDATION" : "FAIL VALIDATION";
                    actualResults.add(input[0] + " EXPECTED -> " + resultToWrite);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return actualResults;
    }

    public ArrayList<String> validateReview() {
        actualResults = new ArrayList<>();
        File file = new File("C:\\Java Resources\\tests\\Write Review\\Review\\data.txt");
        try {
            Scanner scanner = new Scanner(file);
            elReviewTextArea = driver.findElement(byReviewTextArea);
            elReviewFailed = driver.findElement(byReviewFailed);
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                String[] input = nextLine.split(" EXPECTED -> ");
                boolean result = inputAndValidateField(input[0], elReviewTextArea, elReviewFailed);
                if (result == false && input[1].equals("PASS VALIDATION")) {
                    actualResults.add(nextLine);
                } else if (result == true && input[1].equals("FAIL VALIDATION")) {
                    actualResults.add(nextLine);
                } else {
                    String resultToWrite = result == false ? "PASS VALIDATION" : "FAIL VALIDATION";
                    actualResults.add(input[0] + " EXPECTED -> " + resultToWrite);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return actualResults;
    }

    public ArrayList<String> reviewCounts() {
        actualResults = new ArrayList<>();
        elReviewTextCount = driver.findElement(byReviewFailed);
        elReviewTextArea = driver.findElement(byReviewTextArea);
        if (!(elReviewTextCount.isDisplayed())) {
            actualResults.add("hidden");
        } else {
            actualResults.add("showing");
        }
        elReviewTextArea.clear();
        elReviewTextArea.sendKeys("A");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        String currentCount = elReviewTextCount.getText();
        if (currentCount.contains("499 characters")) {
            actualResults.add("400 characters");
        } else {
            actualResults.add(currentCount);
        }
        elReviewTextArea.clear();
        elReviewTextArea.sendKeys("AbCdFrHgFfFfFfFfFfFfFfFfFfFfFfFDSFDSFDASFADSFADSFDASFSDFSDFDAS");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        currentCount = elReviewTextCount.getText();
        if (currentCount.contains("438 characters")) {
            actualResults.add("438 characters");
        } else {
            actualResults.add(currentCount);
        }
        elReviewTextArea.clear();
        elReviewTextArea.sendKeys("AbCdFrDHgFfFfFfFfFfFfFfFfFfFfFfFDSFDSFDASFADSFADSFDASFSDFSDFDASAbCdFrHgFfFfFfFfFfFfFfFfFfFfFfFDSFDSFDASFADSFADSFDASFSDFSDFDASAbCdFrHgFfFfFfFfFfFfFfFfFfFfFfFDSFDSFDASFADSFADSFDASFSDFSDFDASAbCdFrHgFfFfFfFfFfFfFfFfFfFfFfFDSFDSFDASFADSFADSFDASFSDFSDFDASAbCdFrHgFfFfFfFfFfFfFfFfFfFfFfFDSFDSFDASFADSFADSFDASFSDFSDFDASAbCdFrHgFfFfFfFfFfFfFfFfFfFfFfFDSFDSFDASFADSFADSFDASFSDFSDFDASAbCdFrHgFfFfFfFfFfFfFfFfFfFfFfFDSFDSFDASFADSFADSFDASFSDFSDFDASAbCdFrHgFfFfFfFfFfFfFfFfFfFfFfFDSFDSFDASFADSFADSFDASFSDFSDFDASdd");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        currentCount = elReviewTextCount.getText();
        if (currentCount.contains("1 character")) {
            actualResults.add("1 character");
        } else {
            actualResults.add(currentCount);
        }
        elReviewTextArea.clear();
        elReviewTextArea.sendKeys("A1bCdFrHgDFfFfFfFfFfFfFfFfFfFfFfFDSFDSFDASFADSFADSFDASFSDFSDFDASAbCdFrHgFfFfFfFfFfFfFfFfFfFfFfFDSFDSFDASFADSFADSFDASFSDFSDFDASAbCdFrHgFfFfFfFfFfFfFfFfFfFfFfFDSFDSFDASFADSFADSFDASFSDFSDFDASAbCdFrHgFfFfFfFfFfFfFfFfFfFfFfFDSFDSFDASFADSFADSFDASFSDFSDFDASAbCdFrHgFfFfFfFfFfFfFfFfFfFfFfFDSFDSFDASFADSFADSFDASFSDFSDFDASAbCdFrHgFfFfFfFfFfFfFfFfFfFfFfFDSFDSFDASFADSFADSFDASFSDFSDFDASAbCdFrHgFfFfFfFfFfFfFfFfFfFfFfFDSFDSFDASFADSFADSFDASFSDFSDFDASAbCdFrHgFfFfFfFfFfFfFfFfFfFfFfFDSFDSFDASFADSFADSFDASFSDFSDFDASdd");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        if (!(elReviewTextCount.isDisplayed())) {
            actualResults.add("hidden");
        } else {
            actualResults.add("showing");
        }
        return actualResults;
    }

    public ArrayList<String> validateAuthenticness() {
        actualResults = new ArrayList<>();
        elAuthenticnessDropDown = new Select(driver.findElement(byAuthenticnessDropDown));
        elAuthenticnessFailed = driver.findElement(byAuthenticnessFailed);
        actualResults.add(dropDownTester(elAuthenticnessDropDown, elAuthenticnessFailed, "5", true));
        actualResults.add(dropDownTester(elAuthenticnessDropDown, elAuthenticnessFailed, "4", true));
        actualResults.add(dropDownTester(elAuthenticnessDropDown, elAuthenticnessFailed, "3", true));
        actualResults.add(dropDownTester(elAuthenticnessDropDown, elAuthenticnessFailed, "2", true));
        actualResults.add(dropDownTester(elAuthenticnessDropDown, elAuthenticnessFailed, "1", true));
        actualResults.add(dropDownTester(elAuthenticnessDropDown, elAuthenticnessFailed, "0", true));
        actualResults.add(dropDownTester(elAuthenticnessDropDown, elAuthenticnessFailed, "Select", false));
        return actualResults;
    }

    public ArrayList<String> validateHeat() {
        actualResults = new ArrayList<>();
        elHeatDropDown = new Select(driver.findElement(byHeatDropDown));
        elHeatFailed = driver.findElement(byHeatFailed);
        actualResults.add(dropDownTester(elHeatDropDown, elHeatFailed, "5", true));
        actualResults.add(dropDownTester(elHeatDropDown, elHeatFailed, "4", true));
        actualResults.add(dropDownTester(elHeatDropDown, elHeatFailed, "3", true));
        actualResults.add(dropDownTester(elHeatDropDown, elHeatFailed, "2", true));
        actualResults.add(dropDownTester(elHeatDropDown, elHeatFailed, "1", true));
        actualResults.add(dropDownTester(elHeatDropDown, elHeatFailed, "0", true));
        actualResults.add(dropDownTester(elHeatDropDown, elHeatFailed, "Select", false));
        return actualResults;
    }

    public ArrayList<String> validatePrice() {
        actualResults = new ArrayList<>();
        elPriceDropDown = new Select(driver.findElement(byPriceDropDown));
        elPriceFailed = driver.findElement(byPriceFailed);
        actualResults.add(dropDownTester(elPriceDropDown, elPriceFailed, "5", true));
        actualResults.add(dropDownTester(elPriceDropDown, elPriceFailed, "4", true));
        actualResults.add(dropDownTester(elPriceDropDown, elPriceFailed, "3", true));
        actualResults.add(dropDownTester(elPriceDropDown, elPriceFailed, "2", true));
        actualResults.add(dropDownTester(elPriceDropDown, elPriceFailed, "1", true));
        actualResults.add(dropDownTester(elPriceDropDown, elPriceFailed, "0", true));
        actualResults.add(dropDownTester(elPriceDropDown, elPriceFailed, "Select", false));
        return actualResults;
    }

    public ArrayList<String> validateService() {
        actualResults = new ArrayList<>();
        elServiceDropDown = new Select(driver.findElement(byServiceDropDown));
        elServiceFailed = driver.findElement(byServiceFailed);
        actualResults.add(dropDownTester(elServiceDropDown, elServiceFailed, "5", true));
        actualResults.add(dropDownTester(elServiceDropDown, elServiceFailed, "4", true));
        actualResults.add(dropDownTester(elServiceDropDown, elServiceFailed, "3", true));
        actualResults.add(dropDownTester(elServiceDropDown, elServiceFailed, "2", true));
        actualResults.add(dropDownTester(elServiceDropDown, elServiceFailed, "1", true));
        actualResults.add(dropDownTester(elServiceDropDown, elServiceFailed, "0", true));
        actualResults.add(dropDownTester(elServiceDropDown, elServiceFailed, "Select", false));
        return actualResults;
    }

    private String dropDownTester(Select element, WebElement validation, String option,
                                  boolean expectedResult) {
        String result = null;
        element.selectByValue(option);
        driver.findElement(bySubmit).click();
        if (expectedResult == false && validation.isDisplayed()) {
            result = option + " EXPECTED -> FAIL VALIDATION";
        } else {
            result = option + " EXPECTED -> PASS VALIDATION";
        }
        return result;
    }

    private boolean inputAndValidateField(String input, WebElement element, WebElement failedValidationEl) {
        boolean result;
        element.clear();
        element.sendKeys(input);

        driver.findElement(bySubmit).click();
        return result = failedValidationEl.isDisplayed();
    }

}