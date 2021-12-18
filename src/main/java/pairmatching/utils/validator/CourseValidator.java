package pairmatching.utils.validator;

import pairmatching.domain.Course;

public class CourseValidator {
	public static void validateCourseName(String courseName) {
		Course.find(courseName);
	}
}
