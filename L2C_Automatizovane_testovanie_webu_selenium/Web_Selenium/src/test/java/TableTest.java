import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;

public class TableTest extends MainTest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() {
        driver.get(BASE_URL + "tabulka.php");
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
        // pouzivam find elements nie element
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
        WebElement row = driver.findElement(By.xpath("//table/tbody/tr[(last())]"));
        System.out.println(row.getText());
    }

    @Test

    public void itShouldPrintAllRows2() {
        int rows = Integer.parseInt(driver.findElement(By.xpath("//table/tbody/tr[(last())]/td[1]")).getText());
        // od 1. riadku po pocet riadkov rows
        for (int i = 1; i < rows; i++) {
            System.out.println(driver.findElement(By.xpath("//table/tbody/tr[" + i + "]")).getText());
        }

        Assert.assertFalse(driver.findElement(By.xpath("//table/tbody/tr[3]")).getText().isEmpty());
    }

    @Test
    public void testVerify() {
        //assert
        Assert.assertEquals("1", driver.findElement(By.cssSelector("td")).getText());

        //verify, zachyti chybu do catch bloku a vyhodi ju az na konci
        try {
            Assert.assertEquals("2", driver.findElement(By.xpath("//tr[2]/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

}
