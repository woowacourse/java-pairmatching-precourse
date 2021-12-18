package pairmatching.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.LevelGroup;
import pairmatching.domain.Mission;
import pairmatching.domain.PairMatching;
import pairmatching.util.ErrorMessage;

public class OutputView {

	public static final String DONE_INITIALIZATION = "초기화 되었습니다.";
	public static final String SPLIT = "#############################################";
	public static final String NONE_RESULT = "매칭 이력이 없습니다.";

	public static void printErrorMessage(String errorMessage) {
		System.out.println(errorMessage);
	}

	public static void printCourseAndMission() {
		System.out.println(SPLIT);
		printCourse();
		printMission();
		System.out.println(SPLIT);
	}

	public static void printCourse() {
		System.out.print("과정: ");
		System.out.println(Stream.of(Course.values())
			.map(Course::getName)
			.collect(Collectors.joining(" | ")));
	}

	public static void printMission() {
		System.out.println("미션:");
		Stream.of(LevelGroup.values())
			.map(e -> String.join("\n", "  - " + e.getName() + ": "
					+ Arrays.stream(e.getMissions()).map(Mission::getName).collect(Collectors.joining(" | "))
				)
			)
			.forEach(System.out::println);
	}

	public static void printInitialization() {
		System.out.println(DONE_INITIALIZATION);
	}

	public static void newLine() {
		System.out.println();
	}

	public static void printPairResult(PairMatching pairMatching) {
		List<List<String>> printPairMatching = pairMatching.getMatchCrews()
			.stream().map(e -> e.stream().map(Crew::getName).collect(Collectors.toList()))
			.collect(Collectors.toList());

		printPairMatching.stream()
			.map(e ->
				String.join(" : ", e))
			.forEach(System.out::println);
	}

	public static void printPairResultNone() {
		System.out.print(ErrorMessage.ERROR + NONE_RESULT);
	}
}
