package pairmatching.controller;

import pairmatching.domains.crew.BackendCrews;
import pairmatching.domains.crew.FrontendCrews;
import pairmatching.domains.mission.Missions;

public class PairController {
	private FrontendCrews frontendCrews;
	private BackendCrews backendCrews;
	private Missions missions;

	public PairController(FrontendCrews frontendCrews, BackendCrews backendCrews,
		Missions missions) {
		this.frontendCrews = frontendCrews;
		this.backendCrews = backendCrews;
		this.missions = missions;
	}

	public void initiate() {
		frontendCrews.setFrontendCrews();
		backendCrews.setBackendCrews();
		missions.loadMission();
	}
}
