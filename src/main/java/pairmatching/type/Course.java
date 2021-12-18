package pairmatching.type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.data.ProgramData;

public enum Course {
	BACKEND("백엔드", ProgramData.BACKEND_CREW_FILEPATH),
	FRONTEND("프론트엔드", ProgramData.FRONTEND_CREW_FILEPATH);

	private String name;
	private String filePath;

	Course(String name, String filePath) {
		this.name = name;
		this.filePath = filePath;
	}

	public String getName() {
		return name;
	}

	public String getFilePath() {
		return filePath;
	}

	public static List<Course> courseList() {
		List<Course> courseList = Arrays.asList(Course.values());
		return courseList;
	}

	public static String getCourseInfo() {
		return String.format(ProgramData.COURSE_LIST_FORMAT, String.join(ProgramData.BAR_SEPARATOR, getCourseNames()));
	}

	private static List<String> getCourseNames() {
		List<String> courseNames = courseList().stream().map(Course::getName).collect(Collectors.toList());
		return courseNames;
	}
}