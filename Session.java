import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Session {
    private static WebDriver driver;
    private static JavascriptExecutor js;
    private Customer customer = new Customer();
    private boolean result;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    public Date[] sesionDeleted() {
        Date[] dates = new Date[2];
        WriteAReviewSelenium writeReview = new WriteAReviewSelenium();
        writeReview.setDriver(driver);
        ArrayList<String> reviewCreated = writeReview.completeForm("C:\\Java Resources\\tests\\Write Review\\FormInput\\New Customer\\data.txt");
        Date dateCreated = new Date();
        dates[0] = dateCreated;
        customer.setEmail(reviewCreated.get(3));
        int attempts = 0;
        while (checkSession()) {
            attempts++;
            try {
                Thread.sleep(90000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (attempts > 20) {
                break;
            }
        }
        if (result == false) {
            Date deletedTime = new Date();
            dates[1] = deletedTime;
        }
        return dates;
    }

    private boolean checkSession() {
        result = false;
        Database db = new Database();
        db.connect("amwilliams");
        ResultSet rs = db.query("select session from vl_customers where session is not null and email = '" + customer.getEmaill() + "'");
        try {
           rs.next();
            result = rs.getString(1).contains("vl:") ? true : false;
        } catch (SQLException e) {
        }
        db.disconnect();
        return result;
    }

}
