// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
public class ClickMeBabyWebTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    //relative path cize od tohto projektu
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void oneClick() {
    driver.get("http://localhost:8888/");
    driver.findElement(By.linkText("Click me baby")).click();
    driver.findElement(By.id("clickMe")).click();
    assertThat(driver.findElement(By.id("clicks")).getText(), is("1"));
    assertThat(driver.findElement(By.cssSelector(".description")).getText(), is("klik"));
  }
}
