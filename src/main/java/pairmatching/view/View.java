package pairmatching.view;

import java.util.ArrayList;

import pairmatching.model.PairMatching;
import pairmatching.model.repository.PairMatchingRepository;

public class View {

	public static final String MAIN_MENU_MESSAGE = "기능을 선택하세요.\n"
		+ "1. 페어 매칭\n"
		+ "2. 페어 조회\n"
		+ "3. 페어 초기화\n"
		+ "Q. 종료";
	public static final String COURSE_LEVEL_MISSION_INFO_MESSAGE = "#############################################\n"
		+ "과정: 백엔드 | 프론트엔드\n"
		+ "미션:\n"
		+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "  - 레벨3: \n"
		+ "  - 레벨4: 성능개선 | 배포\n"
		+ "  - 레벨5: \n"
		+ "############################################";
	public static final String SELECT_COURSE_LEVEL_MISSION_MESSAGE = "과정, 레벨, 미션을 선택하세요.\n"
		+ "ex) 백엔드, 레벨1, 자동차경주";
	public static final String RE_PAIR_MATCHING_MESSAGE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
		+ "네 | 아니오";
	public static final String PAIR_MATCHING_RESULT_MESSAGE = "페어 매칭 결과입니다.";

	public void mainMenu() {
		System.out.println(MAIN_MENU_MESSAGE);
	}

	public void courseLevelMissionInfo() {
		System.out.println(COURSE_LEVEL_MISSION_INFO_MESSAGE);
	}

	public void selectCourseLevelMission() {
		System.out.println(SELECT_COURSE_LEVEL_MISSION_MESSAGE);
	}

	public void rePairMatching() {
		System.out.println(RE_PAIR_MATCHING_MESSAGE);
	}

	public void pairMatchingResult() {
		System.out.println(PAIR_MATCHING_RESULT_MESSAGE);

		ArrayList<PairMatching> repo = PairMatchingRepository.repo;
		PairMatching pairMatching = repo.get(repo.size() - 1);
		ArrayList<String> pairList = pairMatching.getPairList();

		StringBuilder stringBuilder = new StringBuilder();

		if (pairList.size() % 2 == 0) {
			for (int i = 0; i < pairList.size(); i += 2) {
				stringBuilder.append(pairList.get(i));
				stringBuilder.append(" : ").append(pairList.get(i + 1)).append("\n");
			}
		}

		if (pairList.size() % 2 != 0) {
			for (int i = 0; i < pairList.size() - 3; i += 2) {
				stringBuilder.append(pairList.get(i));
				stringBuilder.append(" : ").append(pairList.get(i + 1)).append("\n");
			}
			stringBuilder.append(pairList.get(pairList.size() - 3))
				.append(" : ")
				.append(pairList.get(pairList.size() - 2))
				.append(" : ")
				.append(pairList.get(pairList.size() - 1))
				.append("\n");
		}

		System.out.println(stringBuilder.toString());
	}
}
