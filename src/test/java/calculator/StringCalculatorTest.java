package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setup(){
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2,3,+,5","5,4,*,20","20,2,/,10"})
    void calculateTest(int number1, int number2, String sign, int result){
        assertThat(stringCalculator.calculate(number1,number2,sign)).isEqualTo(result);
    }

    @Test
    void excuteTest(){
        String[] arr = new String[]{"2","+","3","*","4","/","2"};
        assertThat(stringCalculator.excute(arr)).isEqualTo(10);
    }

    @Test
    void calculatorTest(){
        assertThat(stringCalculator.calculator("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    void isCalculateException(){
        assertThatIllegalArgumentException().isThrownBy(()->{
            stringCalculator.calculate(2,3,"??");
            
        });


    }

}