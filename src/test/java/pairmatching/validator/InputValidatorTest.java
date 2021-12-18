package pairmatching.validator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static pairmatching.validator.InputValidator.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

	@Test
	void 집입_메뉴_입력_예외() {
		assertThatThrownBy(() -> InputValidator.validateEntryMenu("4"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(InputValidator.ERROR_PREFIX)
			.hasMessage(INVALID_ENTRY_MENU_CHOICE);
	}

	@ParameterizedTest
	@ValueSource(strings = {"프론트엔드, 레벨1", "프론트엔드, 레벨1, 자동차경주,"})
	void 서브_메뉴_입력_예외() {
		assertThatThrownBy(() -> InputValidator.validateSubMenu(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(InputValidator.ERROR_PREFIX)
			.hasMessage(INVALID_SUB_MENU_CHOICE);
	}
}