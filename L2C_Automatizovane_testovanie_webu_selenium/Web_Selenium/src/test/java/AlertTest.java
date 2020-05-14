import java.util.concurrent.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import static org.junit.Assert.*;

public class AlertTest {

    private WebDriver driver;
    final private String BASE_URL = "http://localhost";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //relative path cize od tohto projektu
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + ":8888/redalert.php");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }

    }

    @Test
    // TODO: overit, ci sa zobrazi hlaska po kliknuti na button a akceptovani alertu
    public void itShouldRunAlert1() {
        //click on the button
        driver.findElement(By.id("alert1")).click();
        // switch to alert window and click on check button ok
        Alert alert = driver.switchTo().alert();
        alert.accept();
        // assert allert message - text
        String text = driver.findElement(By.xpath("//div[@class='result']/h1")).getText();
        Assert.assertEquals(text, "Kirov Reporting");
    }

    @Test
    // TODO: overit, ci sa zobrazi hlaska po kliknuti na button a zruseni alertu
    public void itShouldRunAndDismissAlert2() {
        //click on the button
        driver.findElement(By.id("alert2")).click();
        // switch to alert window
        Alert alert = driver.switchTo().alert();
        //print text on alert window
        System.out.println(alert.getText());
        //dismiss alert
        alert.dismiss();
        //assert text message is "Negative"
        String text = driver.findElement(By.xpath("//div[@class='result']/h1")).getText();
        Assert.assertEquals(text, "Negative");

    }

    @Test
    // TODO: overit, ci sa zobrazi hlaska po kliknuti na button 3 a vpisani vstupnych parametrov do alert okna
    public void itShouldRunAlert3() {
        driver.findElement(By.id("alert3")).click();
        Alert alert = driver.switchTo().alert();
        // write key value that the alert ask for
        alert.sendKeys("Yuri");
        alert.accept();
        String text = driver.findElement(By.xpath("//div[@class='result']/h1")).getText();
        Assert.assertTrue(text.contains("Yuri"));
    }

}
