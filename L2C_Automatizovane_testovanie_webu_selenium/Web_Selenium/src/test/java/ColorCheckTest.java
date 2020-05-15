import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import static org.junit.Assert.*;

public class ColorCheckTest {
    private WebDriver driver;
    final private String BASE_URL = "http://localhost:8888/";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //relative path cize od tohto projektu
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + "stroopeffect.php");
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

    public void itShouldPrintColorOfElement(){
        //text prveho elementu
        driver.findElement(By.xpath("//div[contains(@class,colours)]/h1[1]")).getText();
        //farba prveho elementu  takze sa musim dostat k css vlastnostiam daneho elementu
        System.out.println(driver.findElement(By.xpath("//div[contains(@class,'colours')]/h1[1]")).getCssValue("color"));
        
    }

}
