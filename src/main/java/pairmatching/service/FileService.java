package pairmatching.service;

import pairmatching.model.Course;
import pairmatching.util.FileReader;

import java.io.BufferedOutputStream;
import java.util.List;

import static pairmatching.model.Error.WRONG_COURSE_NAME;

public class FileService {

	private FileReader fileReader = new FileReader();
	private static final String BACKEND_CREW_PATH = "src/main/resources/backend-crew.md";
	private static final String FRONTEND_CREW_PATH = "src/main/resources/frontend-crew.md";

	public List<String> readCrewNamesFromFile(Course course) {
		if (course.equals(Course.BACKEND)) {
			return fileReader.readCrewList(BACKEND_CREW_PATH);
		}
		if (course.equals(Course.FRONTEND)) {
			return fileReader.readCrewList(FRONTEND_CREW_PATH);
		}
		throw new IllegalArgumentException(WRONG_COURSE_NAME);
	}
}
