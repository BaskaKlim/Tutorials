import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class CalculatorTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost:8888/kalkulacka.php";

    @Before

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @After

    public void tearDown() {
        driver.close();
        driver.quit();
    }



    @Test
    public void testSum() {
        checkSum("6", "2", "8");
        checkSum("8", "7", "15");
        checkSum("10", "2", "12");
        checkSum("23", "27", "50");
        checkSum("511", "13", "524");
    }

    @Test
    public void testDeduct() {
        //actions
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("6");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("2");
        driver.findElement(By.id("deduct")).click();
        // validation
        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());
        Assert.assertEquals("4", driver.findElement(By.id("result")).getText());

    }

    @Test
    public void testMultiply() {
        //actions
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("6");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("2");
        driver.findElement(By.id("count")).click();
        // validation
        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());
        Assert.assertEquals("12", driver.findElement(By.id("result")).getText());


    }

    @Test
    public void testDivide() {
        //actions
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("6");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("2");
        driver.findElement(By.id("count")).click();
        // validation
        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());
        Assert.assertEquals("3", driver.findElement(By.id("result")).getText());


    }

    @Test
    public void testInvalidInputs() {
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput"));
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput"));

    }

    public void checkSum(String firstInput, String secondInput, String expectedResult){
        //actions
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys(firstInput);
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys(secondInput);
        driver.findElement(By.id("count")).click();
        // validation
        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());
        Assert.assertEquals(expectedResult, driver.findElement(By.id("result")).getText());
    }

}
