import org.junit.*;
import org.openqa.selenium.*;

public class AlertTest extends MainTest {

    @Before
    public void openBaseUrl() {
        driver.get(BASE_URL + "/redalert.php");
    }

    @Test
    // TODO: overit, ci sa zobrazi hlaska po kliknuti na button a akceptovani alertu
    public void itShouldRunAlert1() {
        //click on the button
        driver.findElement(By.id("alert1")).click();
        // switch to alert window and click on check button ok
        Alert alert = driver.switchTo().alert();
        alert.accept();
        // assert allert message - text
        String text = driver.findElement(By.xpath("//div[@class='result']/h1")).getText();
        Assert.assertEquals(text, "Kirov Reporting");
    }

    @Test
    // TODO: overit, ci sa zobrazi hlaska po kliknuti na button a zruseni alertu
    public void itShouldRunAndDismissAlert2() {
        //click on the button
        driver.findElement(By.id("alert2")).click();
        // switch to alert window
        Alert alert = driver.switchTo().alert();
        //print text on alert window
        System.out.println(alert.getText());
        //dismiss alert
        alert.dismiss();
        //assert text message is "Negative"
        String text = driver.findElement(By.xpath("//div[@class='result']/h1")).getText();
        Assert.assertEquals(text, "Negative");

    }

    @Test
    // TODO: overit, ci sa zobrazi hlaska po kliknuti na button 3 a vpisani vstupnych parametrov do alert okna
    public void itShouldRunAlert3() {
        driver.findElement(By.id("alert3")).click();
        Alert alert = driver.switchTo().alert();
        // write key value that the alert ask for
        alert.sendKeys("Yuri");
        alert.accept();
        String text = driver.findElement(By.xpath("//div[@class='result']/h1")).getText();
        Assert.assertTrue(text.contains("Yuri"));
    }

}
