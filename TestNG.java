import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.example.Main;

public class TestNG{

    @DataProvider(name = "validFactorialData")
    public Object[][] validFactorialData() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {5, 120},
                {10, 3628800}
        };
    }

    @Test(dataProvider = "validFactorialData")
    public void testFactorialWithValidInputs(int input, long expected) {
        assertEquals(Main.factorial(input), expected,
                "Факториал " + input + " должен быть равен " + expected);
    }

    @DataProvider(name = "invalidFactorialData")
    public Object[][] invalidFactorialData() {
        return new Object[][]{
                {-1}, {-5}, {-10}
        };
    }

    @Test(dataProvider = "invalidFactorialData", expectedExceptions = IllegalArgumentException.class)
    public void testFactorialWithInvalidInputs(int input) {
        Main.factorial(input);
    }
}
