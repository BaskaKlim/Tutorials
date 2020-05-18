import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitingForElementTest extends MainTest {

    @Before
    public void setUp() {

        driver.get(getBASE_URL() + "zjavenie.php");
    }


    @Test
    //TODO: wait for image - using Java method thread.sleep that is fixed
    public void itShouldWaitForImageElement() throws InterruptedException {
        //click to button "zobrazit"
        driver.findElement(By.id("showHim")).click();
        Thread.sleep(2500);
        //find image of Brano Mojsej
        driver.findElement(By.xpath("//img[@class='brano']"));

    }

    @Test
    //TODO: wait for image - using WebDriverWait for dynamic waiting
    public void itShouldWaitForImageElement2() throws InterruptedException {
        //click to button "zobrazit"
        driver.findElement(By.id("showHim")).click();
        // wait maximum 5 secund until state that image is visibile
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//img[@class='brano']"))));
        //find image of Brano Mojsej
        driver.findElement(By.xpath("//img[@class='brano']"));

    }

    @Test
    public void itShoulValidateThatPictureIsDisplayed() {
        driver.findElement(By.id("showHim")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//img[@class='brano']"))));
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='brano']")).isDisplayed());
    }

}

