package pairmatching.view;

import java.util.ArrayList;
import java.util.List;

import pairmatching.Menu;
import pairmatching.condition.Answer;
import pairmatching.condition.Course;
import pairmatching.condition.Level;
import pairmatching.condition.Mission;

public class InputView {
	private static final String SELECT_FEATURE = "기능을 선택하세요.";
	private static final String LINE_BREAK_DELIMITER = "#############################################";
	private static final String OPTION_DELIMITER = " | ";
	private static final String PREFIX_COURSE = "과정:";
	private static final String PREFIX_MISSION = "미션:";
	private static final String PREFIX_LEVEL_DASH = "  -";
	private static final String SUFFIX_LEVEL_COLON = ": ";
	private static final String SELECT_COURSE_LEVEL_MISSION = "과정,레벨,미션을 선택하세요.";
	private static final String SELECT_COURSE_LEVEL_MISSION_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
	private static final String ALREADY_PAIR = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";

	private static void printLineBreak() {
		System.out.println();
	}

	public static void printChooseFeature() {
		System.out.println(SELECT_FEATURE);
		printMainMenuView();
	}

	private static void printMainMenuView() {
		for (Menu each : Menu.values()) {
			System.out.println(each.toString());
		}
	}

	private static void printLineBreakDelimiter() {
		System.out.println(LINE_BREAK_DELIMITER);
	}

	private static void printCourse() {
		List<String> courses = new ArrayList<>();
		for (Course each : Course.values()) {
			courses.add(each.toString());
		}
		System.out.println(PREFIX_COURSE + String.join(OPTION_DELIMITER, courses));
	}

	private static void printLevelWithMission() {
		System.out.println(PREFIX_MISSION);
		for (Level each : Level.values()) {
			System.out.print(PREFIX_LEVEL_DASH + each.toString() + SUFFIX_LEVEL_COLON);
			printMission(each);
		}
	}

	private static void printMission(Level level) {
		List<String> missions = new ArrayList<>();
		for (Mission each : Mission.findMissionByLevel(level)) {
			missions.add(each.toString());
		}
		System.out.println(String.join(OPTION_DELIMITER, missions));
	}

	private static void printSelectCourseLevelMission() {
		System.out.println(SELECT_COURSE_LEVEL_MISSION);
		System.out.println(SELECT_COURSE_LEVEL_MISSION_EXAMPLE);
	}

	public static void printSelectPairTarget() {
		printLineBreak();
		printLineBreakDelimiter();
		printCourse();
		printLevelWithMission();
		printLineBreakDelimiter();
		printSelectCourseLevelMission();
	}

	public static void printAlreadyPair() {
		printLineBreak();
		System.out.println(ALREADY_PAIR);
		List<String> answers = new ArrayList<>();
		for (Answer each : Answer.values()) {
			answers.add(each.toString());
		}
		System.out.println(String.join(OPTION_DELIMITER, answers));
	}
}


