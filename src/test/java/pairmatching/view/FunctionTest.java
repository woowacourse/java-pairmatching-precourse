package pairmatching.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FunctionTest {
	@Test
	public void allFunctionsInquiry() {
		for (Function function : Function.values()) {
			System.out.println(function);
		}
	}
}
