package pairmatching;

import java.util.List;
import java.util.stream.Collectors;

public enum Guide {
	PLEASE_SELECT_FUNCTION("기능을 선택하세요."),
	PLEASE_SELECT_COURSE_TUPLE("과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주"),
	COURSE_INFO("\n#############################################\n"
		+ "과정: 백엔드 | 프론트엔드\n"
		+ "미션:\n"
		+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "  - 레벨3: \n"
		+ "  - 레벨4: 성능개선 | 배포\n"
		+ "  - 레벨5: \n"
		+ "############################################"),
	SHOW_PAIR_MATCHING_RESULT("\n페어 매칭 결과입니다."),
	DUPLICATE_MATCHING_RESULT("\n매칭 정보가 있습니다. 다시 매칭하시겠습니까?");

	private static final String CREW_NAME_SEPARATOR = " : ";

	private final String message;

	Guide(String message) {
		this.message = message;
	}

	public void print() {
		System.out.println(this.message);
	}

	public static void printMatchingResult(PairList pairList) {
		for (int i = 0; i < pairList.size(); i++) {
			List<String> crewNames = pairList.get(i).get().stream()
				.map(Crew::getName).collect(Collectors.toList());
			String output = String.join(CREW_NAME_SEPARATOR, crewNames);
			System.out.println(output);
		}
	}
}
