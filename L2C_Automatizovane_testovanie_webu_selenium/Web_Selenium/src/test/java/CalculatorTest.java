import org.junit.*;
import org.openqa.selenium.*;

public class CalculatorTest extends MainTest {

    @Before
    public void openBaseUrl() {
        driver.get(getBASE_URL()+ "/kalkulacka.php");
    }


    @Test
    public void testSum() {
        checkSum("6", "2", "8");
        checkSum("8", "7", "15");
        checkSum("10", "2", "12");
        checkSum("23", "27", "50");
        checkSum("511", "13", "524");
    }

    @Test
    public void testDeduct() {
        checkDeduct("6", "2", "4");
        checkDeduct("23", "17", "6");
        checkDeduct("-1", "2", "-3");

    }
    

    @Test
    public void testInvalidInputs() {
        //vlozim string pismena nie cisla
        enterImputs("blud1", "blud2");
        driver.findElement(By.id("count")).click();
        WebElement bordersOfFirstInput = driver.findElement(By.xpath("//div[input[@id='firstInput']]"));
        WebElement bordersOfSecondInput = driver.findElement(By.xpath("//div[input[@id='secondInput']]"));

         // chcem zistit ci tento element ak vlozim bludne inputy obsahuje triedu has-error
        Assert.assertTrue(bordersOfFirstInput.getAttribute("class").contains("has-error"));
        Assert.assertTrue(bordersOfSecondInput.getAttribute("class").contains("has-error"));
    }

    @Test
    public void testReset() {
        enterImputs("6", "2");
        driver.findElement(By.id("count")).click();
        driver.findElement(By.id("reset")).click();
        //chcem overit ci su prve dva inputy prazne a  ze sa v casti vysledku nezobrazi text
        //input maju atribute value, result je len text cize tam pouzijem getText nie getAttribute
        Assert.assertTrue(driver.findElement(By.id("firstInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("secondInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("result")).getText().isEmpty());

    }

    /************** Methods ******************/

    private void enterImputs(String firstInput, String secondInput) {
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys(firstInput);
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys(secondInput);
    }

    public void checkSum(String firstInput, String secondInput, String expectedResult) {
        //actions
        enterImputs(firstInput, secondInput);
        driver.findElement(By.id("count")).click();
        // validation
        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());
        Assert.assertEquals(expectedResult, driver.findElement(By.id("result")).getText());
    }

    private void checkDeduct(String firstInput, String secondInput, String expectedResult) {
        //actions
        enterImputs(firstInput, secondInput);
        driver.findElement(By.id("deduct")).click();
        // validation
        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());
        Assert.assertEquals(expectedResult, driver.findElement(By.id("result")).getText());
    }

}
