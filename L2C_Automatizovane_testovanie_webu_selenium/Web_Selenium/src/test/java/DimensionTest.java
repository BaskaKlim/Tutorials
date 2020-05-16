import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import static org.junit.Assert.*;

public class DimensionTest {

    private WebDriver driver;
    final private String BASE_URL = "http://localhost:8888/";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    //TODO: otestovat responzivitu webu
    public void test() {
        //set new pixels size for window
        driver.manage().window().setSize(new Dimension(300, 2500));
        driver.get(BASE_URL + "clickmebaby.php");
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals("1", driver.findElement(By.id("clicks")).getText());
    }

    @Test
    //TODO: otestovat responzivitu webu
    public void test2() {
        //set max size for window
        driver.manage().window().maximize();
        Assert.assertTrue(driver.findElement(By.id("donald")).isDisplayed());
    }
}
