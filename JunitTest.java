import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Main;

class JunitTest {

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "5, 120",
            "10, 3628800"
    })
    void testFactorialWithValidInputs(int input, long expected) {
        assertEquals(expected, Main.factorial(input),
                "Факториал " + input + " должен быть равен " + expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -10})
    void testFactorialWithInvalidInputs(int input) {
        assertThrows(IllegalArgumentException.class, () -> Main.factorial(input),
                "Для отрицательных чисел должно выбрасываться исключение");
    }
}
