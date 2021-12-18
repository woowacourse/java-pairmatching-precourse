package pairmatching.repository;

import java.util.List;

import pairmatching.domain.Course;

public class CourseRepository {
	public static List<Course> courses;

	public static void setCourses(List<Course> courses) {
		CourseRepository.courses = courses;
	}
}
