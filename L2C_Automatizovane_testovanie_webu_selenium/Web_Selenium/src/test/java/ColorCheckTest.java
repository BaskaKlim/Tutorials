import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.*;

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
    //TODO: vypisat farbu prveho elementu - nazvu green
    public void itShouldPrintColorOfElement() {
        //text prveho elementu
        driver.findElement(By.xpath("//div[contains(@class,'colours')]/h1[1]")).getText();
        //farba prveho elementu  takze sa musim dostat k css vlastnostiam daneho elementu
        System.out.println(driver.findElement(By.xpath("//div[contains(@class,'colours')]/h1[1]")).getCssValue("color"));

    }

    @Test
    //TODO: vypisat farby vsetkych elementov
    public void itShouldPrintColorOfEachElements() {
        List<WebElement> titles = driver.findElements(By.xpath("//div[contains(@class,'colours')]/h1"));
        for (WebElement title : titles) {
            System.out.println(title.getText());
            System.out.println(title.getCssValue("color"));
            //vypisem si farbu v hexadecimalnom kode nie v rgb
            String hexColor = Color.fromString(title.getCssValue("color")).asHex();
            System.out.println(hexColor);
        }
    }

    @Test
    //TODO: vypisat farbu prveho elementu - nazvu green
    public void itShouldPrintFontSizeOfElement() {

        String rgbaColor = driver.findElement(By.xpath("//div[contains(@class,'colours')]/h1[1]")).getCssValue("color");
        String hexColor = Color.fromString(rgbaColor).asHex();
        Assert.assertEquals("#ff0d0e", hexColor);

    }

    @Test
    //TODO: overit ci farba textu je ocakavana farba
    public void itShouldValidateExpectedColorOfElement() {
        driver.findElement(By.xpath("//div[contains(@class,'colours')]/h1[1]")).getText();
        System.out.println(driver.findElement(By.xpath("//div[contains(@class,'colours')]/h1[1]")).getCssValue("font-size"));

    }
}
