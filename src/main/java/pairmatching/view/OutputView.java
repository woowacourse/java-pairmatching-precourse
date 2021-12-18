package pairmatching.view;

import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Missions;
import pairmatching.domain.Pair;

public class OutputView {
	public static void printCourseAndMissionStatus(Missions missions) {
		printSeparator();
		printCourseNames();
		printMissionsNames(missions);
		printSelectMatchingOption();
		printSeparator();
	}

	public static void printSelectOption() {
		System.out.println("기능을 선택하세요.");
		System.out.println("1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료");
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
			System.out.println(str);
			sb.setLength(0);
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

	public static void printReMatching() {
		System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
	}

	public static void printPair(List<Pair> pairs) {
		StringBuilder sb = new StringBuilder();
		System.out.println("페어 매칭 결과입니다.");
		for (Pair pair : pairs) {
			List<String> crewNameList = pair.getCrewNameList();
			sb.append(crewNameList);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void printInit() {
		System.out.println("초기화 되었습니다.");
	}
}
