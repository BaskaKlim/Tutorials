import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;

public class HoverStateTest extends MainTest {

    @Before
    public void openBaseUrl() {

        driver.get(getBASE_URL()+ "semafor.php");
    }

    @Test

    public void test() {
        //0.expected values - these we are testing
        String expectedGreen = "rgba(10, 129, 0, 1)";
        String expectedRed = "rgba(205, 58, 63, 1)";
        String expectedOrange = "rgba(191, 111, 7, 1)";

        //1.vytiahnem si element
        WebElement trafficLights = driver.findElement(By.className("light"));
        //2. vychodzia farba  a overim ocakavanu farbu s realnou
        String actualRedColor = (trafficLights.getCssValue("background-color"));
        Assert.assertEquals(expectedRed, actualRedColor);

        //3. akcia - prechod mysov, hover stav
        Actions actions = new Actions(driver);
        actions.moveToElement(trafficLights).build().perform();
        //4. vytiahnem si aktualnu farbu a porovnam ocakavnu a aktualnu farbu
        String actualGreenColor = (trafficLights.getCssValue("background-color"));
        Assert.assertEquals(expectedGreen, actualGreenColor);

        //5. akcia - active state - podrzanie mysi,  pri action musi byt vzdy build a perform
        actions.clickAndHold(trafficLights).build().perform();
        String actualOrangeColor = (trafficLights.getCssValue("background-color"));
        Assert.assertEquals(expectedOrange, actualOrangeColor);
    }

}
