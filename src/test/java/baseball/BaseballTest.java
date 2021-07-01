package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballTest {
    private NumberBaseball numberBaseball;

    @BeforeEach
    void setup(){
        numberBaseball = new NumberBaseball();
    }

    @ParameterizedTest
    @CsvSource(value = {"122, false", "123, true"})
    void isCorrectNumber(int input, boolean result){
        assertThat(numberBaseball.isCorrect(input)).isEqualTo(result);

    }

    @ParameterizedTest
    @CsvSource(value = {"123, true"})
    void isNumberTest(String input, boolean isNumber){
        assertThat(numberBaseball.isNumber(input)).isEqualTo(isNumber);
    }

    @Test
    void isNumberExceptionTest(){
        assertThatThrownBy(()->{
            numberBaseball.isNumber("aaa");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->{
            numberBaseball.isNumber(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"123, 1볼 1스트라이크", "145, 1볼","671, 2볼","216, 1스트라이크", "713, 3스트라이크","256,낫싱"})
    void checkMyNumberStringTest(String myNumberString, String result){
        String computerNumberString = "713";
        assertThat(numberBaseball.getResult(computerNumberString, myNumberString)).isEqualTo(result);
    }
}
