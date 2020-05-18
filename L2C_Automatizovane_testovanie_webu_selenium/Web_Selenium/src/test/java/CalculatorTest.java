import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class CalculatorTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost:8888/kalkulacka.php";

    @Before

    public void setUp() {
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
        //actions
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("6");
        driver.findElement(By.id("secondInput")).click();
        driver.findElement(By.id("secondInput")).sendKeys("2");
        driver.findElement(By.id("count")).click();
        // validation
        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());
        Assert.assertEquals("8", driver.findElement(By.id("result")).getText());


    }

    @Test
    public void testSub() {
        //actions
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("6");
        driver.findElement(By.id("secondInput")).click();
        driver.findElement(By.id("secondInput")).sendKeys("2");
        driver.findElement(By.id("count")).click();
        // validation
        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());
        Assert.assertEquals("4", driver.findElement(By.id("result")).getText());

    }

    @Test
    public void testMultiply() {
        //actions
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("6");
        driver.findElement(By.id("secondInput")).click();
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
        driver.findElement(By.id("secondInput")).click();
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
        driver.findElement(By.id("secondInput")).click();
        driver.findElement(By.id("secondInput"));

    }

}
