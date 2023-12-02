package pairmatching;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {

	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	void 짝수_인원_페어_매칭() {
		assertShuffleTest(
			() -> {
				run("1", "백엔드, 레벨1, 자동차경주", "Q");
				assertThat(output()).contains("태웅 : 백호", "치수 : 태섭");
			},
			Arrays.asList("태웅", "백호", "치수", "태섭")
		);
	}

	@Test
	void 없는_미션에_대한_예외_처리() {
		assertSimpleTest(
			() -> {
				runException("1", "백엔드, 레벨1, 오징어게임");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Override
	public void runMain() {
		try {
			Application.main(new String[] {});
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		}
	}
}
