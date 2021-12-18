package pairmatching.view;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class OutputView {

	public static final String DONE_INITIALIZATION = "초기화 되었습니다.";
	public static final String SPLIT = "#############################################";

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
		Stream.of(Level.values())
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
}
