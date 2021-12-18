package pairmatching.validator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

	@Test
	void 집입_메뉴_입력_예외() {
		assertThatThrownBy(() -> {
			InputValidator.validateEntryMenu("4");
		})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(InputValidator.ERROR_PREFIX);
	}
}