package pairmatching.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
	private final List<Crew> crews = new ArrayList<>();

	public CrewRepository() throws IOException {
		readBackEnd();
		readFrontEnd();
	}

	private void readBackEnd() throws IOException {
		File backendFile = new File("./src/main/resources/backend-crew.md");
		if (backendFile.exists()) {
			BufferedReader inFile = new BufferedReader(new FileReader(backendFile));
			String sLine;
			while ((sLine = inFile.readLine()) != null)
				crews.add(new Crew(Course.BACKEND, sLine));
		}
	}

	private void readFrontEnd() throws IOException {
		File frontendFile = new File("./src/main/resources/frontend-crew.md");
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
