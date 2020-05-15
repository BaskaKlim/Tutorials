import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import static org.junit.Assert.*;

public class NavBarTest {

    private WebDriver driver;
    final private String BASE_URL = "http://localhost";
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
    //TODO: over ci je vyznacena podstranka na navigacii ta, na ktorej sa prave nachadzas

    public void itShouldMarkTheCurrecntPageInNavigation(){
        driver.get(BASE_URL + ":8888/zjavenie.php");
        Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='zjavenie.php']")).getAttribute("class").contains("active"));

    }

}
