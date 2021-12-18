package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;
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
	private static final String ERROR_MESSAGE_COURSE_LEVEL_MISSION
		= "[ERROR] <과정>, <레벨>, <미션> 형태로 입력해 주세요. 과정, 레벨, 미션이 존재하는 값인지 확인해 주세요\n";
	private static final String REGULAR_EXPRESSION_COURSE_LEVEL_MISSION
		= "^[가-힣]+, [가-힣0-9]+, [a-zA-Z가-힣0-9]+$";
	private static final String COURSE_LEVEL_MISSION_SEPARATOR
		= ", ";

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
}
