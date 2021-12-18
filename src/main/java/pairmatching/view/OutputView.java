package pairmatching.view;

import java.util.stream.Stream;

import pairmatching.Function;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.MatchedPairs;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;

public class OutputView {
	private static final String TITLE_MAIN = "기능을 선택하세요.";
	private static final String TITLE_MATCHED = "페어 매칭 결과입니다.";
	private static final String TITLE_INQUIRY = "조회 결과입니다.";

	private static final String NOTICE_NO_MATCHED = "매칭 이력이 없습니다.";

	private static final String QUESTION_MISSION = "과정, 레벨, 미션을 선택하세요.";
	private static final String QUESTION_MISSION_EX = "ex) 백엔드, 레벨1, 자동차경주";

	private static final String PREFIX_COURSE = "과정: ";
	private static final String PREFIX_MISSION = "미션: ";
	private static final String CONJUNCTION_MISSION = " | ";
	private static final String CONJUNCTION_CREW = " : ";

	private static final String OPTION_FORMAT = "%s. %s%n";
	private static final String LEVEL_FORMAT = "  - %s: %s%n";
	private static final String ERROR_FORMAT = "[ERROR] %s%n";

	private static final String BORDER = "############################################";

	public void printMain() {
		printBlankLine();
		System.out.println(TITLE_MAIN);
		Stream.of(Function.values())
			.forEach(
				function -> System.out.printf(OPTION_FORMAT, function.getCode(), function.getName()));
	}

	public void printCourseAndMission() {
		printBlankLine();
		printBorderLine();
		printCourse();
		printMission();
		printBorderLine();
		System.out.println(QUESTION_MISSION);
		System.out.println(QUESTION_MISSION_EX);
	}

	public void printMatchedPairs(MatchedPairs matchedPairs) {
		System.out.println(TITLE_MATCHED);
		matchedPairs.getPairs()
			.forEach(this::printPair);
	}

	public void printInquiryResult(MatchedPairs matchedPairs) {
		System.out.println(TITLE_INQUIRY);
		if (matchedPairs == null) {
			System.out.println(NOTICE_NO_MATCHED);
			return;
		}
		matchedPairs.getPairs()
			.forEach(this::printPair);
	}

	public void printError(Exception exception) {
		printBlankLine();
		System.out.printf(ERROR_FORMAT, exception.getMessage());
	}

	private void printCourse() {
		StringBuilder courses = new StringBuilder();
		courses.append(PREFIX_COURSE);
		Stream.of(Course.values()).forEach(
			course -> courses.append(course.getName()).append(CONJUNCTION_MISSION)
		);
		courses.delete(
			courses.lastIndexOf(CONJUNCTION_MISSION), courses.length());
		System.out.println(courses);
	}

	private void printMission() {
		System.out.println(PREFIX_MISSION);
		Stream.of(Level.values()).forEach(this::printLevel);
	}

	private void printLevel(Level level) {
		StringBuilder missions = new StringBuilder();
		Stream.of(Mission.values()).filter(mission -> mission.isLevel(level)).forEach(
			mission -> missions.append(mission.getName()).append(CONJUNCTION_MISSION)
		);
		if (missions.length() > 0) {
			missions.delete(
				missions.lastIndexOf(CONJUNCTION_MISSION), missions.length());
		}
		System.out.printf(LEVEL_FORMAT, level.getName(), missions);
	}

	private void printPair(Pair pair) {
		StringBuilder crewNames = new StringBuilder();
		pair.getCrews().forEach(
			crew -> crewNames.append(crew.getName()).append(CONJUNCTION_CREW)
		);
		if (crewNames.length() > 0) {
			crewNames.delete(
				crewNames.lastIndexOf(CONJUNCTION_CREW), crewNames.length());
		}
		System.out.println(crewNames);
	}

	private void printBlankLine() {
		System.out.println();
	}

	private void printBorderLine() {
		System.out.println(BORDER);
	}
}
