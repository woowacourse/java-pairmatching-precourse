package pairmatching.utils;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.repository.CourseRepository;

public class Initializer {
	public static void init() {
		initCourse();
	}

	private static void initCourse() {
		List<Course> courses = new ArrayList<>();
		for (Course course : Course.values()) {
			courses.add(course);
		}
		CourseRepository.setCourses(courses);
	}

}
