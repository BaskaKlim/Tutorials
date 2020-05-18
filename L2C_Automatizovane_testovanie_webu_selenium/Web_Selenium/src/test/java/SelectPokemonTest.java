import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class SelectPokemonTest extends MainTest {

    @Before
    public void setUp() {
        driver.get(getBASE_URL() + "vybersi.php");
    }

    @Test
    //TODO: vyber z comboboxu - dropdownu
    public void itShouldSelectPokemonPikachu() {
        //3 sposoby ako vybrat konkretnu option  selectByIndex, selectByValue, selectByVisibleText
        new Select(driver.findElement(By.className("form-control"))).selectByIndex(4);
    }

    @Test
    public void itShouldSelectCharmander() {
        new Select(driver.findElement(By.className("form-control"))).selectByValue("01");

    }

    @Test
    //TODO: vyprat z dropdownu moznost via ByVisible Text a overit hlasku pod obrazkom ci obsahuje dany text
    public void itShouldSelectBulbasaur() {
        //1. select bulbasaur via visibleText
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Bulbasaur");
        //2. assert that the text below picture contain
        String text = driver.findElement(By.xpath("//div/h3")).getText();
        Assert.assertTrue("Pikacu sa v texte nenachadzza", text.contains("Pikacu"));
    }

    @Test
    //TODO: nechat vypisat vsetky moznosti z dropdownu
    public void itShouldPrintAllOptions() {
        List<WebElement> options = new Select(driver.findElement(By.className("form-control"))).getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }
    }

}
