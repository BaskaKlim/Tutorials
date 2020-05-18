import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class CalculatorTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost:8888/kalkulacka.php";

    @Before

    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }
    @After

    public void tearDown(){
        driver.close();
        driver.quit();
    }
    

}
