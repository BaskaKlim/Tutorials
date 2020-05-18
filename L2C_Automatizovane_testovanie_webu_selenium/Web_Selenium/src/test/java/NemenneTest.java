import org.junit.*;
import org.openqa.selenium.*;

public class NemenneTest extends MainTest{


    @Before
    public void openBaseUrl()  {

        driver.get(getBASE_URL() + ":8888/nemenne.php");
    }

    @Test

    public void itShouldValidateThatElemensOfFormAreOrAreNotEnabled() {
        //first input field
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Eva Mazikova']")).isEnabled());
        //second input field
        Assert.assertFalse(driver.findElement(By.id("sel1")).isEnabled());
        //third input field   - dropdown, so at first chect whole element, that the options
        Assert.assertTrue(driver.findElement(By.id("sel2")).isEnabled());
        //first 2 should be not enabled and 3. shoudl be enabled
        Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[1]")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[2]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[3]")).isEnabled());
        //first button
        Assert.assertFalse(driver.findElement(By.xpath("//button[contains(@class,'btn-danger')]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(@class,'btn-success')]")).isEnabled());


    }

}
