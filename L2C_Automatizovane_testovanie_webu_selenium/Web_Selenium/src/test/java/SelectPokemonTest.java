import java.util.*;
import java.util.concurrent.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

public class SelectPokemonTest {

    private WebDriver driver;
    final private String BASE_URL = "http://localhost:8888/";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //relative path cize od tohto projektu
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + "vybersi.php");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
        Assert.assertTrue(text.contains("Bulbasaur"));
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
