package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import example.StringCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void plusTest() {
        try {
            Method method = stringCalculator.getClass().getDeclaredMethod("plus", double.class, double.class);
            method.setAccessible(true);

            double actual = (double) method.invoke(stringCalculator, 2.5, 3.0);
            assertThat(actual).isEqualTo(5.5);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"3 + 4 / 2:3.5", "20:20", "2 + 3 * 4 / 2:10", "2 - 4 * -1:2", "2 * -1:-2"}, delimiter = ':')
    @DisplayName("정상적인 입력 테스트")
    void calculateSuccessCase(String value, Double expected) throws Exception {
        double actual = stringCalculator.calculate(value);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"/", "3 +", "2 - 5 *"})
    @DisplayName("비정상적인 입력 테스트: 연산자로 끝날 때")
    void calculateFailCase1(String value) throws Exception {
        assertThatThrownBy(() -> {
            stringCalculator.calculate(value);
        }).isInstanceOf(Exception.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"+ 3", "5 * /", "2 - 5 13 /"})
    @DisplayName("비정상적인 입력 테스트: 연산자와 숫자 순서가 잘못되었을 때")
    void calculateFailCase2(String value) throws Exception {
        assertThatThrownBy(() -> {
            stringCalculator.calculate(value);
        }).isInstanceOf(Exception.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "5 & 3", "3 - 7 @@ 2.8", "4/2"})
    @DisplayName("비정상적인 입력 테스트: 수식 외의 값이 들어왔을 때")
    void calculateFailCase3(String value) throws Exception {
        assertThatThrownBy(() -> {
            stringCalculator.calculate(value);
        }).isInstanceOf(Exception.class);
    }
}
