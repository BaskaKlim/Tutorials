import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import static org.junit.Assert.*;

public class NavBarTest {

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
    //TODO: over ci je vyznacena podstranka na navigacii ta, na ktorej sa prave nachadzas

    public void itShouldMarkTheCurrecntPageInNavigation() {
        driver.get(BASE_URL + ":8888/zjavenie.php");
        Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='zjavenie.php']")).getAttribute("class").contains("active"));

    }

    @Test
    //TODO: overit, ci sa to deje pre vsetky/viacere podstranky
    public void itShouldMarkEachCurrentPageInNavigation() {
        String expectedClass = "active";

        List<String> pages = new ArrayList<>();
        pages.add("zjavenie.php");
        pages.add("clickmebaby.php");
        pages.add("vybersi.php");
        pages.add("zjavenie.php");
        pages.add("redalert.php");
        pages.add("kalkulacka.php");

        for (String page : pages) {
            driver.get(BASE_URL + page);
            Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='" + page + "']")).getAttribute("class").contains(expectedClass));
        }
    }

}
