package pairmatching.domain.service;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.MissionType;

public class MatchingService {
	public static void generateMatching(Course course, Level level, MissionType mission) throws IOException {
		if (course.isValidateBackend()) {
		}

		if (course.isValidateFrontend()) {

		}
	}

	private static void fileReader(List<String> names) throws IOException {
		Path currentPath = Paths.get("");
		String path = currentPath.toAbsolutePath().toString();
		BufferedReader reader = new BufferedReader(new FileReader(path + "/src/main/resources/backend-crew.md"));
		String str;
		while ((str = reader.readLine()) != null) {
			names.add(str);
		}
		reader.close();
	}
}

