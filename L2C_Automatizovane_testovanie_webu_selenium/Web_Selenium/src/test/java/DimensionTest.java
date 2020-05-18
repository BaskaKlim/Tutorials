import org.junit.*;
import org.openqa.selenium.*;

public class DimensionTest extends MainTest {


    @Before
    public void openBaseUrl() {
        driver.get(getBASE_URL() + "clickmebaby.php");
    }

    @Test
    //TODO: otestovat responzivitu webu
    public void test() {
        //set new pixels size for window
        driver.manage().window().setSize(new Dimension(300, 2500));

        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals("1", driver.findElement(By.id("clicks")).getText());
    }

    @Test
    //TODO: otestovat responzivitu webu
    public void test2() {
        //set max size for window
        driver.manage().window().maximize();
        Assert.assertTrue(driver.findElement(By.id("donald")).isDisplayed());
    }
}
