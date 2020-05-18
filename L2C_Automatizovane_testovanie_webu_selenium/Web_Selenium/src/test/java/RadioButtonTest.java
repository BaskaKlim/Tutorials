import org.junit.*;
import org.openqa.selenium.*;

public class RadioButtonTest extends MainTest {

    @Before
    public void setUp() {

        driver.get(getBASE_URL() + ":8888/zenaalebomuz.php");
    }

    @Test
    //TODO: overit moznost MUZ
    public void itShouldChoseOptionMuz() {

        //1. find input a pristupit jeho value pre moznos muz //2. zakliknut tento radiobutton
        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        //2. vytiahnut si text po zobrazeni
        String message = driver.findElement(By.xpath("//h1[@class='description text-center']")).getText();
        //3. overit ocakavanu hodnotu
        Assert.assertEquals(message, "It's wurst");
    }

    @Test
    //TODO: overit spravnost zaclicknutia radiobuttonov, moze byt vzdy len jeden z nich vybrany
    public void itShouldValidateCorrectChoosingOfRadioButtons() {

        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='conchita']")).isSelected());
    }

}
