package pairmatching.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.repository.CrewMembers;

public class FileInputController {
	private static final String BACKEND_FILE = "backend-crew.md";
	private static final String FRONTEND_FILE = "frontend-crew.md";

	public static void setCrewMembers() {

		List<String> backendNames = readFile(BACKEND_FILE);
		List<String> frontendNames = readFile(FRONTEND_FILE);

		CrewMembers.add(Course.BACKEND, backendNames);
		CrewMembers.add(Course.FRONTEND, frontendNames);
	}

	private static List<String> readFile(String backendFile) {
		List<String> names = new ArrayList<>();
		ClassLoader loader = FileInputController.class.getClassLoader();
		try {
			FileInputStream file = new FileInputStream(
				Objects.requireNonNull(loader.getResource(backendFile)).getFile());
			BufferedReader br = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));
			String line = null;
			while ((line = br.readLine()) != null) {
				names.add(line);
			}
		} catch (IOException ignored) {

		}
		return names;
	}
}