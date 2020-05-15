import java.util.concurrent.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import static org.junit.Assert.*;

public class WaitingForElementTest {

    private WebDriver driver;
    final private String BASE_URL = "http://localhost";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //relative path cize od tohto projektu
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + ":8888/zjavenie.php");
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
    //TODO: wait for image - using Java method thread.sleep that is fixed
    public void itShouldWaitForImageElement() throws InterruptedException {
        //click to button "zobrazit"
        driver.findElement(By.id("showHim")).click();
        Thread.sleep(2500);
        //find image of Brano Mojsej
        driver.findElement(By.xpath("//img[@class='brano']"));

    }

    @Test
    //TODO: wait for image - using WebDriverWait for dynamic waiting
    public void itShouldWaitForImageElement2() throws InterruptedException {
        //click to button "zobrazit"
        driver.findElement(By.id("showHim")).click();
        // wait maximum 5 secund until state that image is visibile
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//img[@class='brano']"))));
        //find image of Brano Mojsej
        driver.findElement(By.xpath("//img[@class='brano']"));

    }

}

