package pairmatching.controller;

import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.MissionRepository;
import pairmatching.domain.crew.BackendCrewRepository;
import pairmatching.domain.crew.Crew;
import pairmatching.view.Input;

public class InitializeController {
	public static void initCrews() {
		initBackendCrews();
		initFrontendCrews();
		MissionRepository.initMission();
	}

	private static void initBackendCrews() {
		List<String> backendCrewNames = Input.backendCrewName();
		backendCrewNames.stream()
			.map(name -> new Crew(Course.BACKEND, name))
			.forEach(BackendCrewRepository::add);
	}

	private static void initFrontendCrews() {
		List<String> frontendCrewNames = Input.frontendCrewName();
		frontendCrewNames.stream()
			.map(name -> new Crew(Course.FRONTEND, name))
			.forEach(BackendCrewRepository::add);
	}
}
