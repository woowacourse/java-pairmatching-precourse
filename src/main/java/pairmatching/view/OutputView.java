package pairmatching.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.Level;
import pairmatching.model.Mission;
import pairmatching.model.MissionRepository;
import pairmatching.model.Pair;

public class OutputView {
	private static final String NAME_DELIMITER = " | ";
	private static final String MISSION_DELIMITER = ": ";
	private static final String MISSION_PREFIX = "  - ";
	private static final String OPTION_DELIMITER = ". ";

	public static void printMain() {
		printMessage("기능을 선택하세요.");
		printOptionMenu("1", "페어 매칭");
		printOptionMenu("2", "페어 조회");
		printOptionMenu("3", "페어 초기화");
		printOptionMenu("Q", "종료");
	}

	public static void printMissionInformation() {
		printBlankLine();
		printMessage("#############################################");
		printMessage("과정: " + courseListWithDelimiter(Arrays.asList(Course.values())));
		printMessage("미션: ");
		printMissionList(Arrays.asList(Level.values()), MissionRepository.findAll());
		printMessage("#############################################");
		printMessage("과정, 레벨, 미션을 선택하세요.");
		printMessage("ex) 백엔드, 레벨1, 자동차경주");
	}

	public static void printMatchingResult(List<Pair> matchingResult) {
		printBlankLine();
		printMessage("페어 매칭 결과입니다.");
		matchingResult.stream().forEach(p -> printPair(p));
		printBlankLine();
	}

	private static void printPair(Pair p) {
		String crewNames = p.getCrews().stream().map(Crew::getName).collect(Collectors.joining(" : "));
		System.out.println(crewNames);
	}

	public static void printErrorMessage(String message) {
		printError(message);
	}

	public static void printRematchingMessage() {
		printBlankLine();
		printMessage("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
		printMessage("네 | 아니오");
	}

	public static void printInitializeMessage() {
		printBlankLine();
		printMessage("초기화 되었습니다. ");
		printBlankLine();
	}

	private static String courseListWithDelimiter(List<Course> courses) {
		return courses.stream().map(Course::getName).collect(Collectors.joining(NAME_DELIMITER));
	}

	private static void printMissionList(List<Level> levels, List<Mission> missions) {
		for (Level level : levels) {
			String message =
				MISSION_PREFIX + level.getName() + MISSION_DELIMITER + missionListWithDelimiter(missions, level);
			printMessage(message);
		}
	}

	private static String missionListWithDelimiter(List<Mission> missions, Level level) {
		return findMissionsByLevel(missions, level).stream().map(Mission::getName).distinct()
			.collect(Collectors.joining(NAME_DELIMITER));
	}

	private static List<Mission> findMissionsByLevel(List<Mission> missions, Level level) {
		return missions.stream().filter(m -> m.getLevel().equals(level)).collect(Collectors.toList());
	}

	private static void printMessage(String header) {
		System.out.println(header);
	}

	private static void printOptionMenu(String option, String name) {
		System.out.println(option + OPTION_DELIMITER + name);
	}

	private static void printError(String message) {
		System.out.println("[ERROR] " + message);
	}

	private static void printBlankLine() {
		System.out.println();
	}
}
