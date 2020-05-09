import java.sql.*;
import java.util.*;
import java.util.concurrent.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import static org.junit.Assert.*;

public class TableTest {

    private WebDriver driver;
    final private String BASE_URL = "http://localhost:8888/";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //relative path cize od tohto projektu
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + "tabulka.php");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void xPathTest() {
        //absolute path
        driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[2]"));
        //relative path
        driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
    }

    @Test
    public void itShouldGoThrowAllRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        for (WebElement row : rows) {
            //TODO: vypis riadky
            //vypisal text kazdeho riadku
            System.out.println(row.getText());
            //TODO: vypis iba priezviska
            //v najdenom elemente mozme hladat cez xpath dalej, :./td[] ta bodka znamena ze chceme hladat len pod tymto roe elementom dalsie td
            System.out.println(row.findElement(By.xpath("./td[3]")).getText());
        }
    }

    @Test
    //TODO: pocet riadkov tabulky
    public void itShouldPrintLastRow() {
        WebElement row = driver.findElement(By.xpath("//table/tbody/tr(last()/td[1])"));
        System.out.println(row.getText());
    }

    @Test

    public void itShouldPrintAllRows2(){
        int rows = Integer.parseInt(driver.findElement(By.xpath("//table/tbody/tr(last()/td[1])")).getText()) ;
      // od 1. riadku po pocet riadkov rows
    for (int i=1; i<rows; i++){
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr["+i+"]")));
        }

    Assert.assertFalse(driver.findElement(By.xpath("//table/tbody/tr[3]")).getText().isEmpty());
    }
    

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
