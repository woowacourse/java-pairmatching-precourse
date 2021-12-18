package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseRepository {
	private final List<Course> courses = new ArrayList<Course>() {
		{
			add(Course.BACKEND);
			add(Course.FRONTEND);
		}
	};

	public List<Course> getCourses() {
		return courses;
	}

	public String getCourseListString() {
		return courses.stream()
			.map(Course::getName)
			.collect(Collectors.joining(" | "));
	}
}
