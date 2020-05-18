import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class RefreshTest extends MainTest {

    @Before
    public void setUp() {
        driver.get(BASE_URL + "clickmebaby.php");
    }

    @Test
    public void itShouldRefreshPage() {

        //click 5 time on the button and validate that there is 5 clicks made
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("clickMe")).click();
        }
        Assert.assertEquals("5", driver.findElement(By.id("clicks")).getText());

        // refresh    and wait for refreshed page
        driver.navigate().refresh();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("clicks")));

        //validate that there is 0 clicks made
        Assert.assertEquals("0", driver.findElement(By.id("clicks")).getText());
    }

}
