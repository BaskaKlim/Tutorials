import org.junit.*;
import org.openqa.selenium.*;

public class XPathTests extends MainTest {

    @Before
    public void setUp() {
        driver.get(BASE_URL + "tabulka.php");
    }

    @Test
    public void tabulkaXpths() {
        driver.findElement(By.xpath("//tbody/tr[5]/td[3]"));

    }

    @Test
    public void clickMeXpths() {
        driver.get(BASE_URL + "clickmebaby.php");
        //relative xpath id selector
        driver.findElement(By.xpath("//*[@id=\"clickMe\"]"));
        //relative xpath text selector
        driver.findElement(By.xpath("//h1[text()='Click me baby one more time']")).isDisplayed();
        // relative xpath class selector
        driver.findElement(By.xpath("//p[@class=\'description\']")).getText().equals("klikov");
    }

}
