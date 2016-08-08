import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class SessionTest {

    private Calendar date;
    private long minute;
    private long time;
    private Date expectionDeletion;
    private Date sessionRemoved;
    private SimpleDateFormat sdf;
    private SeleniumFunctions sf = new SeleniumFunctions();
    private WebDriver driver = sf.getDriver("Chrome");
    private GenericSelenium gs = new GenericSelenium();
    private Session session = new Session();

    @Before
    public void setup() {
        long minute = 60000;
        date = Calendar.getInstance();
        time = date.getTimeInMillis();
        expectionDeletion = new Date(time + (10 * minute));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        gs.setDriver(driver);
        session.setDriver(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testSessionLife() throws InterruptedException {
        Date[] dates = session.sesionDeleted();
        assertTrue(dates[0].getTime() < dates[1].getTime());
    }

}
