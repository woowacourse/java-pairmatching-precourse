package pairmatching.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
	private static final String BACKEND_CREW_PATH = "./src/main/resources/backend-crew.md";
	private static final String FRONTEND_CREW_PATH = "./src/main/resources/frontend-crew.md";
	private final List<Crew> crews = new ArrayList<>();

	public CrewRepository() throws IOException {
		readBackEnd();
		readFrontEnd();
	}

	private void readBackEnd() throws IOException {
		File backendFile = new File(BACKEND_CREW_PATH);
		if (backendFile.exists()) {
			BufferedReader inFile = new BufferedReader(new FileReader(backendFile));
			String sLine;
			while ((sLine = inFile.readLine()) != null)
				crews.add(new Crew(Course.BACKEND, sLine));
		}
	}

	private void readFrontEnd() throws IOException {
		File frontendFile = new File(FRONTEND_CREW_PATH);
		if (frontendFile.exists()) {
			BufferedReader inFile = new BufferedReader(new FileReader(frontendFile));
			String sLine;
			while ((sLine = inFile.readLine()) != null)
				crews.add(new Crew(Course.FRONTEND, sLine));
		}
	}

	public List<Crew> getCrews() {
		return crews;
	}
}
