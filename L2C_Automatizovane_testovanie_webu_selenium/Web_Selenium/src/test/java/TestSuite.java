import org.junit.runner.*;
import org.junit.runners.*;

//anotacie z JUnit
@RunWith(Suite.class)

@Suite.SuiteClasses({

        AlertTest.class,
        CalculatorTest.class,
        ClickMeBabyWebTest.class,
        ColorCheckTest.class,
        NemenneTest.class,
        RadioButtonTest.class

})

public class TestSuite {

}
