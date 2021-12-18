package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Crew {

	private List<String> backendCrew = new ArrayList<>();
	private List<String> frontendCrew = new ArrayList<>();

	private BufferedReader bufferedReaderBackend = new BufferedReader(
		new FileReader("src/main/resources/backend-crew.md"), 16 * 1024
	);
	private BufferedReader bufferedReaderFrontend = new BufferedReader(
		new FileReader("src/main/resources/frontend-crew.md"), 16 * 1024
	);
	public Crew() throws IOException {
		initBackendCrew();
		initFrontendCrew();
	}

	private void printAll() {
		for (String name : frontendCrew) {
			System.out.println(name);
		}
	}

	public void initBackendCrew() throws IOException {
		while (true) {
			String crewName= bufferedReaderBackend.readLine();
			if (crewName != null) {
				backendCrew.add(crewName);
				continue;
			}
			return;
		}
	}

	public void initFrontendCrew() throws IOException {
		while (true) {
			String crewName= bufferedReaderFrontend.readLine();
			if (crewName != null) {
				frontendCrew.add(crewName);
				continue;
			}
			return;
		}
	}




}
