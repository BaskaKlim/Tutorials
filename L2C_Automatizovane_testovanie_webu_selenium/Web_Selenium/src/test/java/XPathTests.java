import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class XPathTests {

    private WebDriver driver;
    final private String BASE_URL = "http://localhost:8888/";

    @Before
    public void setUp() throws Exception {
        //relative path cize od tohto projektu
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void tabulkaXpths(){
        driver.get(BASE_URL + "tabulka.php");
        driver.findElement(By.xpath("//tbody/tr[5]/td[3]"));

    }

    @Test
    public void clickMeXpths(){
        driver.get(BASE_URL + "clickmebaby.php");
        //relative xpath id selector
        driver.findElement(By.xpath("//*[@id=\"clickMe\"]"));
        //relative xpath text selector
        driver.findElement(By.xpath("//h1[text()='Click me baby one more time']")).isDisplayed();
         // relative xpath class selector
        driver.findElement(By.xpath("//p[@class=\'description\']")).getText().equals("klikov");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
