import java.util.concurrent.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import static org.junit.Assert.*;

public class NemenneTest {

    private WebDriver driver;
    final private String BASE_URL = "http://localhost";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //relative path cize od tohto projektu
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + ":8888/nemenne.php");
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

    public void itShouldValidateThatElemensOfFormAreOrAreNotEnabled() {
        //first input field
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Eva Mazikova']")).isEnabled());
        //second input field
        Assert.assertFalse(driver.findElement(By.id("sel1")).isEnabled());
        //third input field   - dropdown, so at first chect whole element, that the options
        Assert.assertTrue(driver.findElement(By.id("sel2")).isEnabled());
        //first 2 should be not enabled and 3. shoudl be enabled
        Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[1]")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[2]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[3]")).isEnabled());
        

    }

}
