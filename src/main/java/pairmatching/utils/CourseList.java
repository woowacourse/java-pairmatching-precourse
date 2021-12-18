package pairmatching.utils;

import java.util.ArrayList;
import java.util.List;

import pairmatching.models.Course;

public class CourseList {
	public static List<String> getCourseList() {
		List<String> courses = new ArrayList<>();
		courses.add(Course.BACKEND.getName());
		courses.add(Course.FRONTEND.getName());
		return courses;
	}
}
