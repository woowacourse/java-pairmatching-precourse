package pairmatching.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import pairmatching.Application;

class PairMatchingControllerTest extends NsTest {

	private static final String ERROR_MESSAGE = "[ERROR]";


	@Test
	public void 맞는_기능을_입력했는지() {
		assertSimpleTest(
			() -> {
				runException("q", "백엔드, 레벨1, 로또");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Test
	public void 맞는_코스를_입력했는지() {
		assertSimpleTest(
			() -> {
				runException("1", "벡엔드, 레벨1, 로또");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Test
	public void 맞는_레벨을_입력했는지() {
		assertSimpleTest(
			() -> {
				runException("1", "백엔드, 1레벨, 로또");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Test
	public void 맞는_미션_입력했는지() {
		assertSimpleTest(
			() -> {
				runException("1", "백엔드, 레벨1, 오징어게임");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Test
	public void 레벨과_미션이_매칭되는지() {
		assertSimpleTest(
			() -> {
				runException("1", "백엔드, 레벨1, 결제");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Test
	void 홀수_인원_페어_매칭() {
		assertShuffleTest(
			() -> {
				run("1", "백엔드, 레벨1, 자동차경주", "Q");
				assertThat(output()).contains("태웅 : 백호", "치수 : 태섭 : 주리");
			},
			Arrays.asList("태웅", "백호", "치수", "태섭", "주리")
		);
	}

	@Test
	void 과정_레벨_미션_폼이_맞지않는경우() {
		assertSimpleTest(
			() -> {
				runException("1", "백엔드, 레벨1 결제");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[]{});
	}

}