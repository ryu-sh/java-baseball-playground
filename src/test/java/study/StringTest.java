package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitTest(){
        String[] arr = "1,2".split(",");
        String[] arr1 = "1".split(",");
        assertThat(arr).contains("1").contains("2");
        assertThat(arr1).contains("1");
    }

    @Test
    void subStringTest(){
        String str = "(1,2)";
        String result = str.substring(1,str.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 범위 오류 테스트")
    void charAtTest(){
        String str = "abc";
        char character = str.charAt(0);
        assertThat(character).isEqualTo('a');
        assertThatThrownBy(() -> {
            str.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
