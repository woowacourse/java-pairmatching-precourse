package pairmatching.domain.input;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class FunctionTypeTest {

	@Test
	void fromFunctionNumberTest() {
		Arrays.stream(FunctionType.values())
			.forEach(functionType ->
				assertEquals(functionType, FunctionType.fromFunctionNumber(functionType.getFunctionNumber()))
			);

		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
			FunctionType.fromFunctionNumber("4")
		);

		assertEquals("해당 기능은 존재하지 않습니다.", exception.getMessage());
	}
}