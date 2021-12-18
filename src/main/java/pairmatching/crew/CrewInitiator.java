package pairmatching.crew;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import pairmatching.condition.Course;
import pairmatching.view.ErrorView;

public class CrewInitiator {
	private static final String ERROR_READ_FILE = "해당 파일을 읽어 올 수 없습니다.";
	private static final String BACKEND_CREW_FILE = "src/main/resources/backend-crew.md";
	private static final String FRONTEND_CREW_FILE = "src/main/resources/frontend-crew.md";

	public void readFile() {
		try {
			readBackendCrewFile();
			readFrontendCrewFile();
		} catch (IOException ioException) {
			ErrorView.print(ERROR_READ_FILE);
		}
	}

	private void readBackendCrewFile() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(BACKEND_CREW_FILE));
		String name;
		while ((name = reader.readLine()) != null) {
			CrewRepository.addCrews(new Crew(Course.BACKEND, name));
		}
		reader.close();
	}

	private void readFrontendCrewFile() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(FRONTEND_CREW_FILE));
		String name;
		while ((name = reader.readLine()) != null) {
			CrewRepository.addCrews(new Crew(Course.FRONTEND, name));
		}
		reader.close();
	}
}
