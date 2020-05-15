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

    public void itShouldMarkTheCurrecntPageInNavigation() {
        driver.get(BASE_URL + ":8888/zjavenie.php");
        Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='zjavenie.php']")).getAttribute("class").contains("active"));

    }

    @Test
    //TODO: overit, ci sa to deje pre vsetky/viacere podstranky
    public void itShouldMarkEachCurrentPageInNavigation() {

        driver.get(BASE_URL + ":8888/zjavenie.php");
        Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='zjavenie.php']")).getAttribute("class").contains("active"));


        driver.get(BASE_URL + ":8888/clickmebaby.php");
        Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='clickmebaby.php']")).getAttribute("class").contains("active"));


        driver.get(BASE_URL + ":8888/vybersi.php");
        Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='vybersi.php']")).getAttribute("class").contains("active"));


        driver.get(BASE_URL + ":8888/redalert.php");
        Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='redalert.php']")).getAttribute("class").contains("active"));
        

        driver.get(BASE_URL + ":8888/kalkulacka.php");
        Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='kalkulacka.php']")).getAttribute("class").contains("active"));



    }

}
