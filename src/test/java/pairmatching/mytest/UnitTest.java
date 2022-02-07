package pairmatching.mytest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class UnitTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	void noError() {
		String hello = "HELLO WORLD!";
		assertThat(hello)
			.doesNotContain(
				ERROR_MESSAGE
			)
		;
	}

	@Test
	void error() {
		String hello = "[ERROR] HELLO WORLD!";
		assertThat(hello)
			.contains(
				ERROR_MESSAGE
			)
		;
	}

	@Test
	void num() {
		int num = 1;
		assertThat(num)
			.isEqualTo(1)
			.isOdd()
			.isNotSameAs(0)
		;
	}
}
