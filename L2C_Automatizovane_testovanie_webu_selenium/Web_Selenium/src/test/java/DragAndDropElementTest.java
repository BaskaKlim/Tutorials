import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;

public class DragAndDropElementTest {

    private WebDriver driver;
    final private String BASE_URL = "http://localhost:8888/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL + "/moveme.php");
    }

    @After
    public void tearDown() {

        driver.close();
        driver.quit();

    }

    @Test
    public void test() {
        WebElement donald = driver.findElement(By.id("donald"));
        WebElement tree = driver.findElement(By.id("tree"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(donald, tree).build().perform();

        String expectedMessage = "HOOO HOOOOO !!!!";
        WebElement message = driver.findElement(By.xpath("//div[contains(@class,'success')]/h2"));

        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals(expectedMessage, message.getText());
    }
}
