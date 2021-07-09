package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {
    @Test
    @DisplayName("야구 숫자 1-9 검증")
    void invalid(){
        Assertions.assertThat(ValidationUtils.vaildNo(9)).isTrue();
        Assertions.assertThat(ValidationUtils.vaildNo(0)).isFalse();
        Assertions.assertThat(ValidationUtils.vaildNo(10)).isFalse();
    }
}
