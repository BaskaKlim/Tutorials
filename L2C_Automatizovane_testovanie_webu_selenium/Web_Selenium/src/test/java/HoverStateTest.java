import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class HoverStateTest {

    private WebDriver driver;
    final private String BASE_URL = "http://localhost:8888/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + "semafor.php");
    }

    @After
    public void tearDown() {

        driver.close();
        driver.quit();

    }

   
}
