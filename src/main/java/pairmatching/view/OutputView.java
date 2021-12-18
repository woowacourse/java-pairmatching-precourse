package pairmatching.view;

import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Missions;

public class OutputView {
	public static void printCourseAndMissionStatus(Missions missions) {
		printSeparator();
		printCourseNames();
		printMissionsNames(missions);
		printSelectMatchingOption();
		printSeparator();
	}

	private static void printSeparator() {
		System.out.println("#############################################");
	}

	private static void printSelectMatchingOption() {
		System.out.println("과정, 레벨, 미션을 선택하세요.");
		System.out.println("ex) 백엔드, 레벨1, 자동차경주");
	}

	private static void printMissionsNames(Missions missions) {
		StringBuilder sb = new StringBuilder();
		System.out.println("미션: ");
		for (Level level : Level.values()) {
			sb.append("  - ");
			sb.append(level.getName());
			sb.append(": ");
			Missions nowLevelMissions = missions.getByLevel(level);
			if (nowLevelMissions.isEmpty()) {
				printToString(sb);
				continue;
			}
			printNowLevelMissionsNames(sb, nowLevelMissions);
			String str = trimedLastSeparator(sb);
			printToString(sb);
		}
	}

	private static void printToString(StringBuilder sb) {
		System.out.println(sb.toString());
		sb.setLength(0);
	}

	private static void printNowLevelMissionsNames(StringBuilder sb, Missions nowLevelMissions) {
		List<String> missionsNames = nowLevelMissions.getNames();
		for (String missionName : missionsNames) {
			sb.append(missionName);
			sb.append(" | ");
		}
	}

	private static String trimedLastSeparator(StringBuilder sb) {
		String now = sb.toString();
		return sb.substring(0, now.length() - 3);
	}

	private static void printCourseNames() {
		System.out.print("과정: ");
		StringBuilder sb = new StringBuilder();
		for (Course course : Course.values()) {
			sb.append(course.getName());
			sb.append(" | ");
		}
		String str = trimedLastSeparator(sb);
		System.out.println(str);
	}

	public static void printError(String message) {
		System.out.println(message);
	}
}
