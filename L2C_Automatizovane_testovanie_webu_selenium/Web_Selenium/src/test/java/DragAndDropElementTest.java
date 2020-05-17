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
        //vybranie elementov co chceme presunut a kam chceme presunut
        WebElement donald = driver.findElement(By.id("donald"));
        WebElement tree = driver.findElement(By.id("tree"));
        //actions class zo selenia a parametere pre dragAndDrop
        Actions actions = new Actions(driver);
        actions.dragAndDrop(donald, tree).build().perform();

        //zadefinovanie si hladaneho a aktualneho elementu
        String expectedMessage = "HOOO HOOOOO !!!!";
        WebElement message = driver.findElement(By.xpath("//div[contains(@class,'success')]/h2"));

        //konkretne veci co overujem
        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals(expectedMessage, message.getText());
    }
}
