package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    private StringCalculator cal;

    @BeforeEach
    void setup(){
        cal = new StringCalculator();
    }

    @Test
    void testSplit(){
        String[] result = cal.split(null);
        Assertions.assertArrayEquals(new String[]{},result);
    }

    @Test
    void testSplitWhenComma(){
        String[] result = cal.split("1,2,3,");
        Assertions.assertArrayEquals(new String[]{"1","2","3"},result);
    }

    @Test
    void testSplitWhenNewLine(){
        String[] result = cal.split("1\n2\n3,");
        Assertions.assertArrayEquals(new String[]{"1","2","3"},result);
    }

    @Test
    void testToInt(){
        int[] result = cal.toInt(new String[]{"1","2","3"});
        Assertions.assertArrayEquals(new int[]{1,2,3},result);

        result = cal.toInt(new String[]{});
        Assertions.assertArrayEquals(new int[]{},result);

        result = cal.toInt(null);
        Assertions.assertArrayEquals(new int[]{},result);
    }


}
