package pairmatching.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.crew.Crew;

public class Output {
	static final String ERROR_PREFIX = "[ERROR] ";
	static final String MAIN_OPTION = "기능을 선택하세요.\n"
		+ "1. 페어 매칭\n"
		+ "2. 페어 조회\n"
		+ "3. 페어 초기화\n"
		+ "Q. 종료";
	static final String MISSION_INFO = "#############################################\n"
		+ "과정: 백엔드 | 프론트엔드\n"
		+ "미션:\n"
		+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "  - 레벨3: \n"
		+ "  - 레벨4: 성능개선 | 배포\n"
		+ "  - 레벨5: \n"
		+ "############################################";
	static final String ENTER_MISSION_INFO = "과정, 레벨, 미션을 선택하세요.\n"
		+ "ex) 백엔드, 레벨1, 자동차경주";
	static final String ENTER_REMATCHING = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
		+ "네 | 아니오";
	static final String MATCHING_RESULT = "페어 매칭 결과입니다.";
	static final String DONE_INIT = "초기화 되었습니다.";

	public static void printError(String errorMessage) {
		System.out.println(ERROR_PREFIX + errorMessage);
		System.out.println();
	}

	public static void mainOption() {
		System.out.println(MAIN_OPTION);
	}

	public static void missionInfo() {
		System.out.println(MISSION_INFO);
		System.out.println(ENTER_MISSION_INFO);
	}

	public static void enterRematching() {
		System.out.println(ENTER_REMATCHING);
	}

	public static void pairs(List<List<Crew>> pairs) {
		System.out.println(MATCHING_RESULT);
		for (List<Crew> pair : pairs) {
			System.out.println(Arrays.stream(pair.toArray())
				.map(Object::toString)
				.collect(Collectors.joining(" : ")));
		}
		System.out.println();
	}

	public static void doneInit() {
		System.out.println(DONE_INIT);
		System.out.println();
	}
}
