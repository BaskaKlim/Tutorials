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
     //TODO: nechat vypisat vsetky moznosti z dropdownu
    public void itShouldSelectCharmander() {
    List<WebElement> options = new Select(driver.findElement(By.className("form-control"))).getOptions();
    for (int i=0; i<options.size();i++){
        System.out.println(options.get(i).getText());
    }

    }

    @Test
    public void itShouldSelectBulbasaur() {
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Bulbasaur");
    }
}
