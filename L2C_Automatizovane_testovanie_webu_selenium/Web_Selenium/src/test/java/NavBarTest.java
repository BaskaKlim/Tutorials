import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class NavBarTest {

    private WebDriver driver;
    final private String BASE_URL = "http://localhost";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //relative path cize od tohto projektu
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

}
