package pairmatching.view;

import java.util.List;

import pairmatching.model.Level;
import pairmatching.model.MissionRepository;
import pairmatching.model.Pair;
import pairmatching.model.Pairs;

public class OutputView {
	private static final String SELECT_FUNTION_MESSAGE = "기능을 선택하세요";
	private static final String PAIR_MATCHING_MESSAGE = "1. 페어 매칭";
	private static final String PAIR_FIND_MESSAGE = "2. 페어 조회";
	private static final String PAIR_INITIALIZATION_MESSAGe = "3. 페어 초기화";
	private static final String EXIT_MEESAGE = "Q. 종료";
	private static final String HASH_LINE = "#############################################";
	private static final String MISSION_MESSAGE = "미션:";
	private static final String COLON = ": ";
	private static final String LINE = "  - ";
	private static final String SLASH = " / ";
	private static final String OPTION_MESSAGE = "과정, 레벨, 미션을 선택하세요.";
	private static final String OPTION_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
	private static final String COLON_GAP = " : ";
	private static final String PAIR_MATCH_MESSAGE = "페어 매칭 결과입니다.";

	private OutputView() {
	}

	public static void askSelectFunction() {
		System.out.println(SELECT_FUNTION_MESSAGE);
		System.out.println(PAIR_MATCHING_MESSAGE);
		System.out.println(PAIR_FIND_MESSAGE);
		System.out.println(PAIR_INITIALIZATION_MESSAGe);
		System.out.println(EXIT_MEESAGE);
	}

	public static void askSelectOption() {
		System.out.println(OPTION_MESSAGE);
		System.out.println(OPTION_EXAMPLE);
	}

	public static void printMissions() {
		emptyLine();
		System.out.println(HASH_LINE);
		System.out.println(MISSION_MESSAGE);

		for (String levelName : Level.from()) {
			System.out.print(LINE + levelName + COLON);
			List<String> copyMissions = MissionRepository.findByLevel(levelName);
			System.out.print(String.join(SLASH, copyMissions));
			System.out.println(PAIR_MATCH_MESSAGE);
		}

		System.out.println(HASH_LINE);
	}

	public static void printPairMatch(List<Pair> matchList) {
		emptyLine();
		for (Pair pairMatch : matchList) {
			System.out.println(String.join(COLON_GAP, pairMatch.getPair()));
		}
		emptyLine();
	}

	private static void emptyLine() {
		System.out.println();
	}
}
