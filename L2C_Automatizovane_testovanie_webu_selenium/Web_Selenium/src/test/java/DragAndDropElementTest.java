import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;

public class DragAndDropElementTest extends MainTest {

    @Before
    public void openBaseUrl() {
        driver.get(getBASE_URL() + "/moveme.php");
    }

    @Test
    public void test() {
        //vybranie elementov co chceme presunut a kam chceme presunut
        WebElement donald = driver.findElement(By.id("donald"));
        WebElement tree = driver.findElement(By.id("tree"));
        //actions class zo selenia a parametere pre dragAndDrop
        Actions actions = new Actions(driver);
        actions.dragAndDrop(donald, tree).build().perform();

        //zadefinovanie si hladaneho a aktualneho elementu
        String expectedMessage = "HOOO HOOOOO !!!!";
        WebElement message = driver.findElement(By.xpath("//div[contains(@class,'success')]/h2"));

        //konkretne veci co overujem
        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals(expectedMessage, message.getText());
    }

    @Test
    public void movingTest() throws InterruptedException {

        WebElement donald = driver.findElement(By.id("donald"));
        Actions actions = new Actions(driver);

        for (int i = 0; i < 100; i++) {
            actions.clickAndHold(donald).moveByOffset(100, 0).release().build().perform();
            Thread.sleep(500);
        }
    }
}
