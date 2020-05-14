import java.util.concurrent.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import static org.junit.Assert.*;

public class AlertTest {

    private WebDriver driver;
    final private String BASE_URL = "http://localhost";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //relative path cize od tohto projektu
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + ":8888/redalert.php");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }

    }

    @Test
    public void itShouldRunAlert1() {
        //click on the button
        driver.findElement(By.id("alert1")).click();
        // switch to alert window and click on check button ok
        Alert alert = driver.switchTo().alert();
        alert.accept();
        // assert allert message - text
        String text = driver.findElement(By.xpath("//div[@class='result']/h1")).getText();
        Assert.assertEquals(text, "Kirov Reporting");
    }

}
