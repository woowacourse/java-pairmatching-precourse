package pairmatching.controller;

import static pairmatching.utils.Constant.*;

import java.util.List;

import pairmatching.repository.CrewRepository;
import pairmatching.utils.CrewReader;

public class InitController {
	private final CrewRepository crewRepository = CrewRepository.getInstance();

	public void initSettings() {
		List<String> frontEndCrew = CrewReader.getFileCrew(FRONTEND_CREW_FILE_LOCATION);
		List<String> backEndCrew = CrewReader.getFileCrew(BACKEND_CREW_FILE_LOCATION);

		crewRepository.saveCrews(backEndCrew, frontEndCrew);
	}
}
