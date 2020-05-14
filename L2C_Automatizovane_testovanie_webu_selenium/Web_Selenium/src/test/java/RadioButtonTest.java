import java.util.concurrent.*;
import javax.xml.soap.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import static org.junit.Assert.*;

public class RadioButtonTest {

    private WebDriver driver;
    final private String BASE_URL = "http://localhost";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //relative path cize od tohto projektu
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + ":8888/zenaalebomuz.php");
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
    //TODO: overit moznost MUZ
    public void itShouldChoseOptionMuz() {

        //1. find input a pristupit jeho value pre moznos muz //2. zakliknut tento radiobutton
        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        //2. vytiahnut si text po zobrazeni
        String message = driver.findElement(By.xpath("//h1[@class='description text-center']")).getText();
        //3. overit ocakavanu hodnotu
        Assert.assertEquals(message, "It's wurst");
    }

    @Test
    //TODO: overit spravnost zaclicknutia radiobuttonov, moze byt vzdy len jeden z nich vybrany
    public void itShouldValidateCorrectChoosingOfRadioButtons() {

        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='conchita']")).isSelected());
    }

}
