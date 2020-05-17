import java.io.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

public class AfterTest {
    //TODO: nastavenia pre ukoncenie a spadnutie testov

    private WebDriver driver;
    final private String BASE_URL = "http://localhost:8888/";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() throws Exception {
        //vytvorenie screenshotu
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // ulozenie si screenshotu
       // FileUtils.copyFile(screenshot, new File("Users/barbaraklimekova/Tutorials/L2C_Automatizovane_testovanie_webu_selenium/screens/screen.png"));

        // dat si vypisat do kontentu page source code
        System.out.println(driver.getPageSource());
        driver.close();
        driver.quit();
    }

    @Test
    //test spadne
    public void itShouldSelectBulbasaur() {
        driver.get(BASE_URL + "vybersi.php");
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Bulbasaur");
        String text = driver.findElement(By.xpath("//div/h3")).getText();
        Assert.assertTrue("Pikacu sa v texte nenachadzza", text.contains("Pikacu"));
    }

}
