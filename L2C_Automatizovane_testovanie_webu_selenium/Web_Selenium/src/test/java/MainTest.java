import java.util.concurrent.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import static org.junit.Assert.*;

public class MainTest {

    public WebDriver driver;
    final String BASE_URL = "http://localhost";
    public StringBuffer verificationErrors = new StringBuffer();

    @Before

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After

    public void tearDown() {
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
        driver.close();
        driver.quit();
    }

}
