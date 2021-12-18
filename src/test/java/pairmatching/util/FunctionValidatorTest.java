package pairmatching.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FunctionValidatorTest {

	@Test
	void 기능_입력값_검증() {
		FunctionValidator.validateInputForm("1");
		FunctionValidator.validateInputForm("2");
		FunctionValidator.validateInputForm("3");
		FunctionValidator.validateInputForm("Q");
	}

	@Test
	void 기능_입력값_예외() {
		assertThrows(IllegalArgumentException.class, () -> FunctionValidator.validateInputForm(""));
		assertThrows(IllegalArgumentException.class, () -> FunctionValidator.validateInputForm(" "));
		assertThrows(IllegalArgumentException.class, () -> FunctionValidator.validateInputForm("q"));
		assertThrows(IllegalArgumentException.class, () -> FunctionValidator.validateInputForm("2 "));
		assertThrows(IllegalArgumentException.class, () -> FunctionValidator.validateInputForm("12"));
		assertThrows(IllegalArgumentException.class, () -> FunctionValidator.validateInputForm("A"));
	}

}
