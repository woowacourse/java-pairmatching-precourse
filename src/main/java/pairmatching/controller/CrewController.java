package pairmatching.controller;

import pairmatching.domain.crew.BackendCrews;
import pairmatching.domain.crew.FrontendCrews;
import pairmatching.service.CrewService;

public class CrewController {
	private static final String BACKEND_CREW = "/backend-crew.md";
	private static final String FRONTEND_CREW = "/frontend-crew.md";

	private CrewService crewService;

	public CrewController() {
		this.crewService = new CrewService(new BackendCrews(BACKEND_CREW), new FrontendCrews(FRONTEND_CREW));
	}
}
