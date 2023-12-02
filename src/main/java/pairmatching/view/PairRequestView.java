package pairmatching.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pairmatching.controller.dto.request.PairRequest;
import pairmatching.domain.constants.Course;
import pairmatching.domain.constants.Level;
import pairmatching.domain.constants.Mission;
import pairmatching.global.exception.CustomException;
import pairmatching.global.exception.ErrorMessage;
import pairmatching.view.console.ConsoleReader;
import pairmatching.view.console.ConsoleWriter;

/**
 * 과정과 레벨, 미션을 출력하고 입력받는 뷰
 */
public final class PairRequestView {
	private static final String REQUEST_MESSAGE = "과정, 레벨, 미션을 선택하세요.";
	private static final String REQUEST_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
	private static final String NOTICE = ""
		+ "#############################################\n"
		+ "과정: 백엔드 | 프론트엔드\n"
		+ "미션:\n"
		+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "  - 레벨3: \n"
		+ "  - 레벨4: 성능개선 | 배포\n"
		+ "  - 레벨5: \n"
		+ "############################################";
	private static final String DIVISOR = ",";

	public static PairRequest request() {
		ConsoleWriter.printlnMessage(NOTICE);
		ConsoleWriter.printlnMessage(REQUEST_MESSAGE);
		ConsoleWriter.printlnMessage(REQUEST_MESSAGE);

		return validate(ConsoleReader.enterMessage());
	}

	// 레벨과 미션의 입력이 맞지 않는 경우 예외처리
	private static PairRequest validate(String message) {
		List<String> input = split(message);
		return new PairRequest(
			Course.getCourse(input.get(0)),
			Level.getLevel(input.get(1)),
			Mission.getMission(input.get(2))
		);
	}

	private static List<String> split(String message) {
		String[] split = message.split(DIVISOR, -1);
		if (split.length != 3) {
			throw CustomException.from(ErrorMessage.INVALID_PAIR_REQUEST);
		}
		return new ArrayList<>(
			Arrays.asList(
				split[0].trim(),
				split[1].trim(),
				split[2].trim()
			)
		);
	}

}
