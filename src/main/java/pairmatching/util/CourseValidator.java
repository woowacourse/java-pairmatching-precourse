package pairmatching.util;

import pairmatching.domain.Course;

public class CourseValidator {
	public static boolean validate(String course) {
		return course.equals(Course.BACKEND.getName()) || course.equals(Course.FRONTEND.getName());
	}
}
