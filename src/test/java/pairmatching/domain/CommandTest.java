package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommandTest {

    @Test
    @DisplayName("없는 커맨드를 요청할 경우 exception이 발생해야 한다.")
    void getCommandExceptionTest() {
        // given
        String input = "4";

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Command.getCommand(input))
            .withMessage("[ERROR] 존재하지 않는 커맨드입니다.");
    }
}