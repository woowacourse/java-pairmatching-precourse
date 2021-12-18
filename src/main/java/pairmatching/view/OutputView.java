package pairmatching.view;

import static pairmatching.constants.Constants.*;
import static pairmatching.constants.OutputMessage.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import pairmatching.model.Course;
import pairmatching.model.Level;

public class OutputView {
	public static void introCourse() {
		System.out.println(HASHTAG);
		System.out.println(COURSE + courseString());
		System.out.println(MISSION);
		printMissions();
		System.out.println(HASHTAG);
	}

	private static String courseString() {
		Course[] values = Course.values();
		List<String> courseList = new LinkedList<>();
		Arrays.stream(values).forEach(course -> courseList.add(course.getName()));
		return String.join(JOIN_DELIMETER, courseList);
	}

	private static void printMissions() {
		Level[] values = Level.values();
		for (Level level:
			 values) {
			System.out.println(INDENT + HYPHEN + level.getName() + COLON + String.join(JOIN_DELIMETER, level.getMissions()));
		}
	}
}
