package pairmatching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pairmatching.domain.PairMatchingService;

class PairMatchingServiceTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "Q"})
    void getValidateMenuSuccess(String value) {
        Assertions.assertThatNoException().isThrownBy(() -> {
            PairMatchingService.getValidateMenu(value);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "", "B", "q", "12", "2b", "4", "a"})
    void getValidateMenuFail(String value) {
        Assertions.assertThatThrownBy(() -> {
            PairMatchingService.getValidateMenu(value);
        });
    }
}