package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class UiLogic {
	private static final String QUESTION_COURSE_LEVEL_MISSION
		= "#############################################\n"
		+ "과정: 백엔드 | 프론트엔드\n"
		+ "미션:\n"
		+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "  - 레벨3: \n"
		+ "  - 레벨4: 성능개선 | 배포\n"
		+ "  - 레벨5: \n"
		+ "############################################\n"
		+ "과정, 레벨, 미션을 선택하세요.\n";
	private static final String QUESTION_REMATCH
		= "\n매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
		+ "네 | 아니오\n";
	private static final String MESSAGE_PAIR_RESULT
		= "\n페어 매칭 결과입니다.\n";
	private static final String ERROR_MESSAGE_COURSE_LEVEL_MISSION
		= "[ERROR] <과정>, <레벨>, <미션> 형태로 입력해 주세요. 과정, 레벨, 미션이 존재하는 값인지 확인해 주세요\n";
	private static final String ERROR_MESSAGE_FILE_READ
		= "[ERROR] 파일 읽기 실패\n";
	private static final String ERROR_MESSAGE_REMATCH
		= "[ERROR] 네, 아니오 중 하나로 답해주세요\n";
	private static final String ERROR_MESSAGE_FAIL_PAIR
		= "[ERROR] 페어 생성 불가\n";
	private static final String REGULAR_EXPRESSION_COURSE_LEVEL_MISSION
		= "^[가-힣]+, [가-힣0-9]+, [a-zA-Z가-힣0-9]+$";
	private static final String COURSE_LEVEL_MISSION_SEPARATOR
		= ", ";
	private static final String NAME_IN_PAIR_SEPARATOR =
		" : ";
	private static final String POSITIVE
		= "네";
	private static final String NEGATIVE
		= "아니오";

	private Ui ui;

	UiLogic() {
		ui = new Ui();
	}

	private void checkCourseLevelMissionFormat(String userInput) throws IllegalArgumentException {
		if (Boolean.FALSE.equals(Pattern.matches(REGULAR_EXPRESSION_COURSE_LEVEL_MISSION, userInput))) {
			throw new IllegalArgumentException();
		}
	}

	protected ArrayList<String> printCourseLevelMission() throws IllegalArgumentException {
		String userInput = ui.printQuestion(QUESTION_COURSE_LEVEL_MISSION);
		checkCourseLevelMissionFormat(userInput);
		return new ArrayList<>(Arrays.asList(userInput.split(COURSE_LEVEL_MISSION_SEPARATOR)));
	}

	protected void printCourseLevelMissionErrorMessage() {
		ui.printMessage(ERROR_MESSAGE_COURSE_LEVEL_MISSION);
	}

	protected void printFileReadError() {
		ui.printMessage(ERROR_MESSAGE_FILE_READ);
	}

	private void checkBinaryInputForamt(String userInput) throws IllegalArgumentException {
		if (userInput.equals(POSITIVE) || userInput.equals(NEGATIVE)) {
			return;
		}
		throw new IllegalArgumentException();
	}

	protected boolean printRematchQuestion() throws IllegalArgumentException {
		String userInput = ui.printQuestion(QUESTION_REMATCH);
		checkBinaryInputForamt(userInput);
		if (userInput.equals(POSITIVE)) {
			return true;
		}
		return false;
	}

	protected void printRematchQuestionErrorMessage() {
		ui.printMessage(ERROR_MESSAGE_REMATCH);
	}

	protected void printFailPairErrorMessage() {
		ui.printMessage(ERROR_MESSAGE_FAIL_PAIR);
	}

	private String getPairMessage(List<String> names) {
		StringBuilder pairMessage = new StringBuilder();
		pairMessage.append(names.get(0));
		pairMessage.append(NAME_IN_PAIR_SEPARATOR);
		pairMessage.append(names.get(1));
		if (names.size() == 3) {
			pairMessage.append(NAME_IN_PAIR_SEPARATOR);
			pairMessage.append(names.get(2));
		}
		pairMessage.append("\n");
		return pairMessage.toString();
	}

	protected void printPair(List<String> pairBucket) {
		ui.printMessage(MESSAGE_PAIR_RESULT);
		for (String pair : pairBucket) {
			List<String> names = new ArrayList<>(Arrays.asList(pair.split(NAME_IN_PAIR_SEPARATOR)));
			ui.printMessage(getPairMessage(names));
		}
	}
}
