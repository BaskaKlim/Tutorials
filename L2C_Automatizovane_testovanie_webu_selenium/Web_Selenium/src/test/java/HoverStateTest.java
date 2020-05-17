import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;

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
    @Test

    public void test() {
        //0.expected values - these we are testing
        String expectedGreen = "rgba(10, 129, 0, 1)";
        String expectedRed = "rgba(205, 58, 63, 1)";

        //1.vytiahnem si element
        WebElement trafficLights = driver.findElement(By.className("light"));
        //2. vychodzia farba  a overim ocakavanu farbu s realnou
        String actualRedColor = (trafficLights.getCssValue("background-color"));
        Assert.assertEquals(expectedRed,actualRedColor);
        //3. akcia - prechod mysov, hover stav
        Actions actions = new Actions(driver);
        actions.moveToElement(trafficLights).build().perform();
        //4. vytiahnem si aktualnu farbu
        String actualGreenColor = (trafficLights.getCssValue("background-color"));
        //5. porovnam ocakavnu a aktualnu farbu
        Assert.assertEquals(expectedGreen,actualGreenColor);
    }
   
}
