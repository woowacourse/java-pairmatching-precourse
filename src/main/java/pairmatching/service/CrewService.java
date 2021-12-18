package pairmatching.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.repository.CrewRepository;

public class CrewService {
	private static final String BACKEND_CREW_FILE = "src/main/resources/backend-crew.md";
	private static final String FRONT_CREW_FILE = "src/main/resources/frontend-crew.md";

	private final CrewRepository crewRepository = CrewRepository.getInstance();

	public CrewService() {
	}

	public void init() throws FileNotFoundException {
		initBackendCrew();
		initFrontendCrew();
	}

	void initBackendCrew() throws FileNotFoundException {
		File backendFile = new File(BACKEND_CREW_FILE);
		Scanner scanner = new Scanner(backendFile);
		while (scanner.hasNextLine()) {
			Crew crew = new Crew(Course.BACKEND, scanner.nextLine());
			crewRepository.addBackendCrews(crew);
		}
	}

	void initFrontendCrew() throws FileNotFoundException {
		File frontendFile = new File(FRONT_CREW_FILE);
		Scanner scanner = new Scanner(frontendFile);
		while (scanner.hasNextLine()) {
			Crew crew = new Crew(Course.FRONTEND, scanner.nextLine());
			crewRepository.addFrontCrews(crew);
		}
	}
}
