package pairmatching.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

public class OutputView {

	public static void printCourseLevelMission(Course[] courses, Level[] levels) {
		System.out.println("#############################################");
		printCourse(courses);
		System.out.println("미션: ");
		for (Level level : levels) {
			printMissionInLevel(level);
		}
		System.out.println("#############################################");
	}

	public static void printCourse(Course[] courses) {
		System.out.println("과정: " + Arrays.stream(courses)
			.map(course -> course.getName())
			.collect(Collectors.joining(" | ")));
	}

	public static void printMissionInLevel(Level level) {
		System.out.printf(" - %s: %s\n",
			level.getName(),
			level.getMissions()
				.stream()
				.map(mission -> mission.getName())
				.collect(Collectors.joining(" | ")));
	}
}
