import java.util.concurrent.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import static org.junit.Assert.*;

public class RegistrationTest {
    private WebDriver driver;
    final private String BASE_URL = "http://localhost:8888/";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //relative path cize od tohto projektu
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + "registracia.php");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void validRegistration() {
        //find element email input   and write test email
        driver.findElement(By.className("form-control")).sendKeys("baska.klimekova@gmail.com");
        driver.findElement(By.name("name")).sendKeys("barbara");
        driver.findElement(By.name("surname")).sendKeys("klimek");
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.name("password-repeat")).sendKeys("1234");
        driver.findElement(By.cssSelector("input#checkbox")).click();
    }



    @After
    public void tearDown() throws Exception {
       // driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
