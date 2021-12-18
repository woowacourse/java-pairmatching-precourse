package pairmatching.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.repository.CrewRepository;

public class CrewService {
	private final CrewRepository crewRepository = CrewRepository.getInstance();

	public CrewService() {
		try {
			initBackendCrew();
			initFrontendCrew();
		} catch (FileNotFoundException e) {

		}
	}

	void initBackendCrew() throws FileNotFoundException {
		File backendFile = new File("src/main/resources/backend-crew.md");
		Scanner scanner = new Scanner(backendFile);
		while (scanner.hasNextLine()) {
			Crew crew = new Crew(Course.BACKEND, scanner.nextLine());
			crewRepository.addBackendCrews(crew);
		}
	}

	void initFrontendCrew() throws FileNotFoundException {
		File frontendFile = new File("src/main/resources/frontend-crew.md");
		Scanner scanner = new Scanner(frontendFile);
		while (scanner.hasNextLine()) {
			Crew crew = new Crew(Course.FRONTEND, scanner.nextLine());
			crewRepository.addFrontCrews(crew);
		}
	}

	public List<Crew> getBackendCrew() {
		return crewRepository.getBackendCrews();
	}

	public List<Crew> getFrontendCrew() {
		return crewRepository.getFrontendCrews();
	}
}
