package pairmatching.view;

import static pairmatching.model.MissionRepository.*;

import java.util.List;

import pairmatching.model.Level;
import pairmatching.model.Mission;
import pairmatching.model.MissionRepository;

public class OutputView {
	private static final String SELECT_FUNTION_MESSAGE = "기능을 선택하세요";
	private static final String PAIR_MATCHING_MESSAGE = "1. 페어 매칭";
	private static final String PAIR_FIND_MESSAGE = "2. 페어 조회";
	private static final String PAIR_INITIALIZATION_MESSAGe = "3. 페어 초기화";
	private static final String EXIT_MEESAGE = "Q. 종료";
	private static final String HASH_LINE = "#############################################";
	private static final String MISSION_MESSAGE = "미션:";
	private static final String COLON = ":";
	private static final String LINE = "- ";
	private static final String SLASH = " / ";

	private OutputView() {
	}

	public static void askSelectFunction() {
		System.out.println(SELECT_FUNTION_MESSAGE);
		System.out.println(PAIR_MATCHING_MESSAGE);
		System.out.println(PAIR_FIND_MESSAGE);
		System.out.println(PAIR_INITIALIZATION_MESSAGe);
		System.out.println(EXIT_MEESAGE);
	}

	public static void printMissions() {
		System.out.println(HASH_LINE);
		System.out.println(MISSION_MESSAGE);

		for (String levelName : Level.from()) {
			System.out.print(LINE + levelName + COLON);
			List<String> copyMissions = MissionRepository.findByLevel(levelName);
			System.out.print(String.join(SLASH, copyMissions));
			emptyLine();
		}

		System.out.println(HASH_LINE);
	}

	private static void emptyLine() {
		System.out.println();
	}
}
