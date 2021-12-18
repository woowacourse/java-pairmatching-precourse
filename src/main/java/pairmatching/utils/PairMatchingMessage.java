package pairmatching.utils;

import java.util.List;

import pairmatching.models.Mission;

public class PairMatchingMessage {

	/* input message */
	private static final String CHOOSE_FUNCTION = "기능을 선택하세요.";

	private static final String FUNCTION1 = "1. 페어 매칭";

	private static final String FUNCTION2 = "2. 페어 조회";

	private static final String FUNCTION3 = "3. 페어 초기화";

	private static final String FUNCTION4 = "Q. 종료";

	private static final String COURSE = "과정: ";

	private static final String MISSIONS = "미션:";

	private static final String DISTINGUISH = " | ";

	private static final String INPUT_MISSION_INFORMATION = "과정, 레벨, 미션을 선택하세요.";

	private static final String INPUT_MISSION_INFORMATION_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";

	private static final String COURSE_LIST_BORDER = "#############################################";

	private static final String RESHUFFLE_PAIR_OR_NOT = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";

	private static final String YES = "네";

	private static final String NO = "아니요";

	public static void printInputFunction() {
		System.out.println(CHOOSE_FUNCTION);
		System.out.println(FUNCTION1);
		System.out.println(FUNCTION2);
		System.out.println(FUNCTION3);
		System.out.println(FUNCTION4);
	}

	private static void printLevelMission(final List<String> missionList, final String lastMission) {
		missionList.forEach(mission -> {
			System.out.print(mission);
			if(!mission.equals(lastMission)) {
				System.out.print(DISTINGUISH);
			}
		});
		System.out.print("\n");
	}

	private static void printLevels(final List<Mission> missions) {
		System.out.println(MISSIONS);
		missions.forEach(mission -> {
			final String level = mission.getLevel();
			final List<String> missionList = mission.getMissionList();
			String lastMission = "";
			if(!missionList.isEmpty()) {
				lastMission = missionList.get(missionList.size() - 1);
			}
			System.out.print(" - " + level + ": ");
			printLevelMission(missionList, lastMission);
		});
	}

	private static void printCourses(final List<String> courses, final String lastCourse) {
		System.out.print(COURSE);
		courses.forEach(course -> {
			System.out.print(course);
			if(!course.equals(lastCourse)) {
				System.out.print(DISTINGUISH);
			}
		});
		System.out.print("\n");
	}

	public static void printChooseMission(final List<String> courses,
			final List<Mission> missions) {
		final String lastCourse = courses.get(courses.size() - 1);
		System.out.println(COURSE_LIST_BORDER);
		printCourses(courses, lastCourse);
		printLevels(missions);
		System.out.println(COURSE_LIST_BORDER);
		System.out.println(INPUT_MISSION_INFORMATION);
		System.out.println(INPUT_MISSION_INFORMATION_EXAMPLE);
	}

	public static void printRematchingPair() {
		System.out.println(RESHUFFLE_PAIR_OR_NOT);
		System.out.println(YES + DISTINGUISH + NO);
	}
}
