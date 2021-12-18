package pairmatching.controller;

import pairmatching.domains.crew.BackendCrews;
import pairmatching.domains.crew.FrontendCrews;
import pairmatching.domains.mission.Missions;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

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

		run();
	}

	private void run() {
		try {
			OutputView.printSelection();
			InputView.getUserSelect();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			OutputView.breakLine();
			run();
		}
	}
}
