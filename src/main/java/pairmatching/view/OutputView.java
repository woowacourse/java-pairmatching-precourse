package pairmatching.view;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.repository.CourseRepository;
import pairmatching.repository.MissionRepository;

public class OutputView {
	public static final String SELECT_FUNCTION = "기능을 선택하세요.";
	public static final String MAIN_MATCH_PAIR = "1. 페어 매칭";
	public static final String MAIN_SEARCH_PAIR = "2. 페어 조회";
	public static final String MAIN_RESET_PAIR = "3. 페어 초기화";
	public static final String MAIN_EXIT = "Q. 종료";

	public static final String PAIR_BORDER = "#############################################";
	public static final String PAIR_COURSE = "과정: ";
	public static final String PAIR_MISSION = "미션: ";

	public static final String SCREEN_MISSION_DASH = "  - ";
	public static final String SCREEN_MISSION_DELIMITER = ": ";
	public static final String SCREEN_DELIMITER = " | ";


	static void printMainScreen() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(SELECT_FUNCTION).append("\n")
			.append(MAIN_MATCH_PAIR).append("\n")
			.append(MAIN_SEARCH_PAIR).append("\n")
			.append(MAIN_RESET_PAIR).append("\n")
			.append(MAIN_EXIT);
		System.out.println(stringBuilder);
	}

	static void printPairScreen() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(PAIR_BORDER).append("\n")
			.append(PAIR_COURSE).append(getCourseList()).append("\n")
			.append(PAIR_MISSION + "\n").append(getMissionList())
			.append(PAIR_BORDER);
		System.out.println(stringBuilder);
	}

	private static String getCourseList() {
		List<String> courseNames = new ArrayList<>();
		for (Course course : CourseRepository.courses) {
			courseNames.add(course.getName());
		}
		return String.join(SCREEN_DELIMITER, courseNames);
	}

	private static String getMissionList() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Level level : Level.values()) {
			stringBuilder.append(SCREEN_MISSION_DASH).append(level.getName() + SCREEN_MISSION_DELIMITER)
				.append(getMissionByLevel(level)).append("\n");
		}
		return stringBuilder.toString();
	}

	private static String getMissionByLevel(Level level) {
		List<String> missionByLevel = MissionRepository.getMissionByLevel(level);
		return String.join(SCREEN_DELIMITER, missionByLevel);
	}
}
