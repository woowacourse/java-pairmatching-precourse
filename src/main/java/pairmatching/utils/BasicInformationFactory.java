package pairmatching.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.view.OutputView;

public class BasicInformationFactory {

	private BasicInformationFactory() {
	}

	public static void noticeBasicInformation() {
		OutputView.printBasicInformation(makeCourses(), makeLevels());
	}

	private static List<String> makeCourses() {
		return Arrays.stream(Course.values()).map(Course::getName).collect(Collectors.toList());
	}

	private static List<String> makeLevels() {
		return Arrays.stream(Level.values()).map(Level::getName).collect(Collectors.toList());
	}
}
