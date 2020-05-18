import java.io.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class AfterTest extends MainTest {

    @Before
    public void openBaseUrl()  {
        driver.get(getBASE_URL() + "vybersi.php");
    }

    @After
    public void tearDown() {
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

        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Bulbasaur");
        String text = driver.findElement(By.xpath("//div/h3")).getText();
        Assert.assertTrue("Pikacu sa v texte nenachadzza", text.contains("Pikacu"));
    }

}
