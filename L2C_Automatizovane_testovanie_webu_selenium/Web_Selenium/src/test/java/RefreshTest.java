import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import static org.junit.Assert.*;

public class RefreshTest {

    private WebDriver driver;
    final private String BASE_URL = "http://localhost:8888/";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //relative path cize od tohto projektu
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
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
    public void itShouldRefreshPage() {
        driver.get(BASE_URL + "clickmebaby.php");

        //click 5 time on the button and validate that there is 5 clicks made
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("clickMe")).click();
        }
        Assert.assertEquals("5", driver.findElement(By.id("clicks")).getText());

        // refresh    and wait for refreshed page
        driver.navigate().refresh();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("clicks")));

        //validate that there is 0 clicks made
        Assert.assertEquals("0", driver.findElement(By.id("clicks")).getText());
    }

}
