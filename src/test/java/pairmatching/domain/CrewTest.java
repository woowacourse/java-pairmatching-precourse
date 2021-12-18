package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CrewTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 공백이 들어올 경우 exception이 발생해야 한다.")
    void createExceptionByEmptyName(String input) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Crew(Course.FRONTEND, input))
            .withMessage("[ERROR] 이름은 공백이 들어올 수 없습니다.");
    }
}