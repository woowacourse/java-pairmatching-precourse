package pairmatching;

import pairmatching.controller.PairMatchingController;

public class PairMatchingStarter {

	private PairMatchingController pairMatchingController;

	public PairMatchingStarter() {
		this.pairMatchingController = new PairMatchingController();
	}

	public void start() {
		if(pairMatchingController.selectFunction()) {
			pairMatchingController.selectProcessLevelMission();
		}
	}
}
