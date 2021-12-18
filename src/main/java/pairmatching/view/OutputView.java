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
				System.out.println(sb.toString());
				sb.setLength(0);
				continue;
			}
			List<String> missionsNames = nowLevelMissions.getNames();
			for (String missionName : missionsNames) {
				sb.append(missionName);
				sb.append(" | ");
			}
			String s2 = sb.toString();
			String substring1 = sb.substring(0, s2.length() - 3);
			System.out.println(substring1);
			sb.setLength(0);
		}
	}

	private static void printCourseNames() {
		System.out.print("과정: ");
		StringBuilder sb = new StringBuilder();
		for (Course course : Course.values()) {
			sb.append(course.getName());
			sb.append(" | ");
		}
		String s = sb.toString();
		String substring = s.substring(0, s.length() - 3);
		System.out.println(substring);
	}
}
