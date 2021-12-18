package pairmatching.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {
    private static final Validator validator = new Validator();

    @Test
    void 올바른_입력() {
        String input = "백엔드, 레벨1, 자동차경주";
        assertThat(validator.isValidDetails(input));
    }

    @Test
    void 잘못된_입력_Course() {
        String input = "풀스택, 레벨1, 자동차경주";
        assertThrows(IllegalArgumentException.class,
                () -> validator.isValidDetails(input));
    }

    @Test
    void 잘못된_입력_Level() {
        String input = "백엔드, 레벨8, 자동차경주";
        assertThrows(IllegalArgumentException.class,
                () -> validator.isValidDetails(input));
    }

    @Test
    void 잘못된_입력_Mission() {
        String input = "백엔드, 레벨2, 자동차경주";
        assertThrows(IllegalArgumentException.class,
                () -> validator.isValidDetails(input));
    }
}