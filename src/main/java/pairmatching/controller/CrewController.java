package pairmatching.controller;

import pairmatching.domain.crew.BackendCrews;
import pairmatching.domain.crew.Crews;
import pairmatching.domain.crew.FrontendCrews;
import pairmatching.service.CrewService;

public class CrewController {
	private static final String BACKEND_CREW = "/backend-crew.md";
	private static final String FRONTEND_CREW = "/frontend-crew.md";
	private static final String BACKEND = "백엔드";

	private static CrewService crewService;

	public CrewController() {
		crewService = new CrewService(new BackendCrews(BACKEND_CREW), new FrontendCrews(FRONTEND_CREW));
	}

	public static Crews getRightCrews(String crewType) {
		if (crewType.equals(BACKEND)) {
			return getShuffledBackendCrews();
		}
		return getShuffledFrontendCrews();
	}

	private static BackendCrews getShuffledBackendCrews() {
		return crewService.getShuffledBackendCrews();
	}

	private static FrontendCrews getShuffledFrontendCrews() {
		return crewService.getShuffledFrontendCrews();
	}
}
