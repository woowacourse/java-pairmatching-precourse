package pairmatching.service;

import pairmatching.model.Course;
import pairmatching.model.CrewPair;
import pairmatching.util.FileUtil;

import java.io.IOException;
import java.util.List;

import static pairmatching.model.Error.WRONG_COURSE_NAME;

public class FileService {

	private FileUtil fileUtil = new FileUtil();
	private static final String BACKEND_CREW_PATH = "src/main/resources/backend-crew.md";
	private static final String FRONTEND_CREW_PATH = "src/main/resources/frontend-crew.md";

	public List<String> readCrewNamesFromFile(Course course) {
		if (course.equals(Course.BACKEND)) {
			return fileUtil.readCrewList(BACKEND_CREW_PATH);
		}
		if (course.equals(Course.FRONTEND)) {
			return fileUtil.readCrewList(FRONTEND_CREW_PATH);
		}
		throw new IllegalArgumentException(WRONG_COURSE_NAME);
	}

	public void saveCrewMatchResult(String fileName, List<CrewPair> crewPairs) {
		StringBuilder stringBuilder = new StringBuilder();
		for (CrewPair crewPair : crewPairs) {
			stringBuilder.append(crewPair.toString()).append("\n");
		}
		String list = stringBuilder.toString();
		try {
			fileUtil.saveMatchResult(fileName, list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readMatch(String path) {
		fileUtil.readSavedMatch(path);
	}
}