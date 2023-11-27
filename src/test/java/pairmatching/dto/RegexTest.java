package pairmatching.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RegexTest {

    private static final Pattern LEVEL_PATTERN = Pattern.compile("레벨+[1-5]");

    @ParameterizedTest
    @ValueSource(strings = {"레벨1", "레벨2", "레벨3", "레벨4", "레벨5"})
    void success(String input){
        Assertions.assertThat(LEVEL_PATTERN.matcher(input).matches())
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"레벨6", "레벨 2", "레벨0", "1", "level 5"})
    void fail(String input){
        Assertions.assertThat(LEVEL_PATTERN.matcher(input).matches())
                .isFalse();
    }
}