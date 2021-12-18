package pairmatching.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import pairmatching.domain.Course;
import pairmatching.domain.CrewRepository;
import pairmatching.view.OutputView;

public class DataInitializer {
	private final static String FILE_PATH = "./src/main/resources";
	private final static String FILE_NAME_BACK = "/backend-crew.md";
	private final static String FILE_NAME_FRONT = "/frontend-crew.md";

	public void initializeCrew() {
		try {
			initializeBackendCrew();
			initializeFrontendCrew();
		} catch (IOException e) {
			OutputView.printError(e);
		}
	}

	private void initializeBackendCrew() throws IOException {
		BufferedReader backendReader = new BufferedReader(new FileReader(FILE_PATH + FILE_NAME_BACK));
		String name;
		while ((name = backendReader.readLine()) != null) {
			CrewRepository.addCrew(Course.BACKEND, name);
		}
	}

	private void initializeFrontendCrew() throws IOException {
		BufferedReader frontendReader = new BufferedReader(new FileReader(FILE_PATH + FILE_NAME_FRONT));
		String name;
		while ((name = frontendReader.readLine()) != null) {
			CrewRepository.addCrew(Course.FRONTEND, name);
		}
	}
}
