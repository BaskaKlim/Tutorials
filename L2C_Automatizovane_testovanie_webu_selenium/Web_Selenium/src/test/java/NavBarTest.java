import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

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
        driver.get(BASE_URL + "zjavenie.php");
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

    @Test

    public void itShouldTestBackAndForward() {
        driver.get(BASE_URL + "registracia.php");
        String email = "barbara@klimek.sk";

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.xpath("//a[@href='zenaalebomuz.php']")).click();
        //testing back step
        driver.navigate().back();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
        System.out.println(driver.findElement(By.name("email")).getAttribute("Value"));
        Assert.assertEquals(email, driver.findElement(By.name("email")).getAttribute("Value"));
        //tetsing forward step
        driver.navigate().forward();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='img/conchita.jpg']")));
        Assert.assertEquals(email, driver.findElement(By.xpath("//img[@src='img/conchita.jpg']")).isDisplayed());
    }

    @Test
    //TODO: prejst v navigacii vsetkymi podstrankami a overit ich title
    public void itShouldPrintPageTitle() {
        driver.get(BASE_URL + "zjavenie.php");
        System.out.println(driver.getTitle());

    }

   

}
